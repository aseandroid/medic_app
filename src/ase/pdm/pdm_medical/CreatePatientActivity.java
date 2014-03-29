package ase.pdm.pdm_medical;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import ase.pdm.listeners.onclick.BSubmitPatientListener;
import ase.pdm.listeners.onclick.EttPatientBirthDayListener;

public class CreatePatientActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_patient);
		
		EditText ettPatientName = (EditText) findViewById(R.id.ettPatientName);
		EditText ettPatientGender = (EditText) findViewById(R.id.ettPatientGender);
		EditText ettPatientBirthDay = (EditText) findViewById(R.id.ettPatientBirthDay);
		EditText etnPatientWeight = (EditText) findViewById(R.id.etnPatientWeight);		
		Button bSubmitPatient = (Button) findViewById(R.id.bSubmitPatient);
		
		ettPatientBirthDay.setOnClickListener(new EttPatientBirthDayListener(ettPatientBirthDay));
		bSubmitPatient.setOnClickListener(new BSubmitPatientListener(
				ettPatientName,
				ettPatientGender,
				ettPatientBirthDay,
				etnPatientWeight
		));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_patient, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
