package ase.pdm.db.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import ase.pdm.db.helpers.SqliteActiveRecord;

public class Patient extends SqliteActiveRecord {
	
	public Patient(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	private long Id;
	private String Name;
	private String Gender;
	private String BirthDay;
	private float Weight;

	public float getWeight() {
		return this.Weight;
	}

	public void setWeight(float weight) {
		this.Weight = weight;
	}

	public String getBirthDay() {
		return this.BirthDay;
	}

	public void setBirthDay(String patientBirthDay) {
		this.BirthDay = patientBirthDay;
	}

	public String getGender() {
		return this.Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public long getId() {
		return this.Id;
	}

	public void setId(long id) {
		this.Id = id;
	}
	
	public String toString() {
		return this.Id + ";" + this.Name + ";" + this.Gender + ";" + this.BirthDay + ";" + this.Weight + "\n";
	}
	
}
