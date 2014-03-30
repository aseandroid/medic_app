package ase.pdm.db.models;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import ase.pdm.db.helpers.SqliteHelper;

public class Model {
	protected HashMap<String, String> types = new HashMap<String, String>();
	protected HashMap<String, Object> classTypes = new HashMap<String, Object>();
	private Context context;
	private SqliteHelper helper;
	private SQLiteDatabase db;

	public Model(Context context) {
		this.context = context;
		this.helper = new SqliteHelper(this.context);
	}

	public Context getModelContext() {
		return this.context;
	}

	public SqliteHelper getDbHelper() {
		return this.helper;
	}

	public SQLiteDatabase getDbConnection() {
		return this.db;
	}

	public void open() {
		this.db = helper.getWritableDatabase();
	}

	public void close() {
		this.db.close();
		this.db = null;
	}

	public HashMap<String, Object> getAttributes() {
		final HashMap<String, Object> fields = new HashMap<String, Object>();
		for (Field field : this.getClass().getDeclaredFields()) {
			try {
				String name = field.getName();
				if (!name.equalsIgnoreCase("db")) {
					field.setAccessible(true);
					fields.put(field.getName(), field.get(this));
				}
			} catch (IllegalAccessException e) {
				Log.e("IllegalAccessException", e.toString());
			} catch (IllegalArgumentException e) {
				Log.e("IllegalArgumentException", e.toString());
			}
		}

		return fields;
	}

	public void setAttributes(HashMap<String, Object> attributes) {
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				field.setAccessible(true);
				field.set(this, attributes.get(field.getName()));
			} catch (IllegalAccessException e) {
				Log.e("IllegalAccessException", e.toString());
			} catch (IllegalArgumentException e) {
				Log.e("IllegalArgumentException", e.toString());
			}
		}
	}

	public void save() {
		ContentValues values = new ContentValues();
		HashMap<String, Object> attributes = this.getAttributes();
		Iterator it = attributes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			values.put(pairs.getKey().toString(), pairs.getValue().toString());
		}
		long insertId = db
				.insert(this.getClass().getSimpleName(), null, values);
	}

	@SuppressLint("NewApi")
	public HashMap<Integer, Model> findAll() {
		HashMap<Integer, Model> list = new HashMap<Integer, Model>();
		HashMap<String, Object> attributes = this.getAttributes();
		int attributesCount = attributes.size();
		Iterator it = attributes.entrySet().iterator();
		String[] columns = new String[attributesCount];
		int i = 0;
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			columns[i] = (String) pairs.getKey();
			i++;
		}

		String className = this.getClass().getSimpleName();
		String classNameWithPackage = this.getClass().getName();
		Cursor cursor = db.query(className, columns, null, null, null, null,
				null);
		cursor.moveToFirst();
		while (cursor != null && !cursor.isAfterLast()) {
			try {
				Model instance = (Model) Class.forName(classNameWithPackage)
						.getConstructor(Context.class).newInstance(context);
				for (int j = 0; j < attributesCount && cursor != null; j++) {
					String columnName = cursor.getColumnName(j);
					String columnType = this.types.get(columnName);
					Class<?> columnTypeClass = (Class<?>) this.classTypes
							.get(columnName);

					String columnNameSetter = "set" + columnName;
					String columnTypeGetter = "get" + columnType;

					Method getterMethod = Class.forName(
							cursor.getClass().getName()).getMethod(
							columnTypeGetter, int.class);
					Method setterMethod = Class.forName(
							instance.getClass().getName()).getMethod(
							columnNameSetter, columnTypeClass);

					setterMethod.invoke(instance,
							getterMethod.invoke(cursor, j));
				}
				list.put(cursor.getPosition(), instance);
			} catch (NoSuchMethodException e) {
				Log.e("NoSuchMethodException", e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				Log.e("IllegalAccessException", e.getMessage());
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				Log.e("IllegalArgumentException", e.getMessage());
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				Log.e("InvocationTargetException", e.getMessage());
				e.printStackTrace();
			} catch (InstantiationException e) {
				Log.e("InstantiationException", e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				Log.e("InstantiationException", e.getMessage());
				e.printStackTrace();
			}

			cursor.moveToNext();
		}
		cursor.close();
		cursor = null;
		return list;
	}

	public void delete() {
		long id = 0;
		db.delete(this.getClass().getSimpleName(), "Id  = " + id, null);
	}
}
