package ase.pdm.listeners.onclick;

import android.view.View;
import android.widget.EditText;

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
	public void onClick(View arg0) {
		
		
	}

}
