package ase.pdm.db.helpers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteActiveRecord extends SQLiteOpenHelper {
	
	//db definition
	public static final String DBNAME = "medApp.db";
	public static final String DBVERSION = "1";
	
	//table names
	public static final String TABLE_PATIENT = "Patient";
	
	//table structure maps
	public static HashMap<String, String> Patient;
	public static String PatientDDL = "CREATE TABLE Patient (";

	public SqliteActiveRecord(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		
		//Patient table structure
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
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
	
	private void createTables(SQLiteDatabase db) {
		PatientDDL += this.getPatientDDL();
		
		db.execSQL(PatientDDL);
	}
	
	private String getPatientDDL() {
		String ddl = "";
		Iterator it = Patient.entrySet().iterator();
	    while (it.hasNext()) {
	    	Map.Entry pairs = (Map.Entry)it.next();
	    	ddl += pairs.getKey() + " " + pairs.getValue() + ",";
	    }
	    ddl.substring(-1);
	    ddl += ");";
	    
	    return ddl;
	}
}
