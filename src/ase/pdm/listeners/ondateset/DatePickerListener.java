package ase.pdm.listeners.ondateset;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class DatePickerListener implements DatePickerDialog.OnDateSetListener {
	private TextView input;
	
	public DatePickerListener(EditText input) {
		this.input = input;
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		view.updateDate(year, month, day);
		this.input.setText(day + "." + month + "." + year);
	}
	
}
