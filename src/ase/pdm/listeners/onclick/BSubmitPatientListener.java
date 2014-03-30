package ase.pdm.listeners.onclick;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import ase.pdm.db.models.Patient;

public class BSubmitPatientListener  implements View.OnClickListener {
	private EditText ettPatientName;
	private EditText ettPatientGender;
	private EditText ettPatientBirthDay;
	private EditText etnPatientWeight;
	private Activity activity;

	public BSubmitPatientListener(
			EditText ettPatientName,
			EditText ettPatientGender, 
			EditText ettPatientBirthDay,
			EditText etnPatientWeight,
			Activity activity) 
	{
		this.ettPatientName = ettPatientName;
		this.ettPatientGender = ettPatientGender;
		this.ettPatientBirthDay = ettPatientBirthDay;
		this.etnPatientWeight = etnPatientWeight;
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		String patientName = this.ettPatientName.getText().toString();
		String patientGender = this.ettPatientGender.getText().toString();
		String patientBirthDay = this.ettPatientBirthDay.getText().toString();
		String patientWeight = this.etnPatientWeight.getText().toString();
		
		Patient patient = new Patient(this.activity);
		patient.open();
		patient.setName(patientName);
		patient.setGender(patientGender);
		patient.setBirthDay(patientBirthDay);
		patient.setWeight(patientWeight);
		patient.save();
		patient.close();
	}

}
