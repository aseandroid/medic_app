package ase.pdm.listeners.onclick;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import ase.pdm.db.models.Patient;

public class BSubmitPatientListener  implements View.OnClickListener {
	private EditText ettPatientName;
	private EditText ettPatientGender;
	private EditText ettPatientBirthDay;
	private EditText etnPatientWeight;

	public BSubmitPatientListener(
			EditText ettPatientName,
			EditText ettPatientGender, 
			EditText ettPatientBirthDay,
			EditText etnPatientWeight) 
	{
		this.ettPatientName = ettPatientName;
		this.ettPatientGender = ettPatientGender;
		this.ettPatientBirthDay = ettPatientBirthDay;
		this.etnPatientWeight = etnPatientWeight;
	}

	@Override
	public void onClick(View v) {
		String patientName = this.ettPatientName.getText().toString();
		String patientGender = this.ettPatientGender.getText().toString();
		String patientBirthDay = this.ettPatientBirthDay.getText().toString();
		String patientWeight = this.etnPatientWeight.getText().toString();
	}

}
