package ase.pdm.listeners.onclick;

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.EditText;
import ase.pdm.listeners.ondateset.DatePickerListener;

public class EttPatientBirthDayListener implements View.OnClickListener {
	private EditText ettPacientBirthDay;
	private DatePickerDialog datePicker;
	
	public EttPatientBirthDayListener(EditText ettPacientBirthDay) {
		this.ettPacientBirthDay = ettPacientBirthDay;
	}

	@Override
	public void onClick(View v) {
		this.datePicker = new DatePickerDialog(
			v.getContext(), 
			new DatePickerListener(ettPacientBirthDay),
			Calendar.YEAR, 
			Calendar.MONTH,
			Calendar.DAY_OF_MONTH
		);
		datePicker.setTitle("Alegeti data nasterii a pacientului");
		datePicker.show();
	}
	
}
