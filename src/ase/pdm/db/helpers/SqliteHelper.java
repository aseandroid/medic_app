package ase.pdm.db.helpers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ase.pdm.db.migrations.Migration;

public class SqliteHelper extends SQLiteOpenHelper {

	// db definition
	public static final String DBNAME = "medApp.db";
	public static final int DBVERSION = 1;

	// table names
	public static final String TABLE_PATIENT = "Patient";

	// table structure maps and ddls
	public static HashMap<String, String> Migration;
	public static String MigrationDDL = "CREATE TABLE Migration (";
	public static HashMap<String, String> Patient;
	public static String PatientDDL = "CREATE TABLE Patient (";

	public SqliteHelper(Context context) {
		super(context, DBNAME, null, DBVERSION);

		// Patient table structure
		this.Patient = new HashMap<String, String>();
		this.Patient.put("Id", "INTEGER PRIMARY KEY AUTOINCREMENT");
		this.Patient.put("Name", "CHAR(255) NOT NULL");
		this.Patient.put("Gender", "CHAR(1) NOT NULL");
		this.Patient.put("BirthDay", "DATE");
		this.Patient.put("Weight", "REAL");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.createTables(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
		for (int i = oldVer; i < newVer; i++) {
			this.getMigrationForVersion(i).apply(db);
		}
	}

	public void onDowngrade(SQLiteDatabase db, int oldVer, int newVer) {
		for (int i = oldVer; i > newVer; i++) {
			this.getMigrationForVersion(i).revert(db);
		}
	}

	private void createTables(SQLiteDatabase db) {
		PatientDDL += this.getDDL(Patient);
		db.execSQL(PatientDDL);
	}

	private String getDDL(HashMap<String, String> TableMap) {
		String ddl = "";
		Iterator it = TableMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			ddl += pairs.getKey() + " " + pairs.getValue() + ",";
		}
		ddl = ddl.substring(0, (ddl.length() - 1));
		ddl += ");";

		return ddl;
	}

	private Migration getMigrationForVersion(int version) {
		Reflections reflections = new Reflections("pdm.ase.db.migrations");
		Set<Class<? extends Migration>> classes = reflections.getSubTypesOf(Migration.class);
		for (Class<? extends Migration> cls : classes) {
			try {
				Migration instance = (Migration) cls.newInstance();
				Field field = cls.getDeclaredField("DBVERSION");
				int fieldValue = (Integer) field.get(instance);
				if (fieldValue == version) {
					return instance;
				}
			} catch (InstantiationException e) {
				Log.e("InstantiationException", e.toString());
			} catch (IllegalAccessException e) {
				Log.e("IllegalAccessException", e.toString());
			} catch (NoSuchFieldException e) {
				Log.e("NoSuchFieldException", e.toString());
			}

		}
		//it's ok, the class has no implementation anyway
		return new Migration();
	}
}
