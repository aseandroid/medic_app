package ase.pdm.db.models;
import android.content.Context;

public class Patient extends Model {
	
	public Patient(Context context) {
		super(context);
		
		//tipuri pentru cursorul sql
		types.put("Id", "Long");
		types.put("Name", "String");
		types.put("Weight", "String");
		types.put("Gender", "String");
		types.put("BirthDay", "String");
		
		//tipuri primite de setteri
		classTypes.put("Id", long.class);
		classTypes.put("Name", String.class);
		classTypes.put("Weight", String.class);
		classTypes.put("Gender", String.class);
		classTypes.put("BirthDay", String.class);
	}

	protected long Id;
	protected String Name;
	protected String Gender;
	protected String BirthDay;
	protected String Weight;

	public String getWeight() {
		return this.Weight;
	}

	public void setWeight(String weight) {
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
