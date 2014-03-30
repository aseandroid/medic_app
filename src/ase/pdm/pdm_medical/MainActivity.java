package ase.pdm.pdm_medical;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import ase.pdm.listeners.onclick.IbCreatePatientListener;
import ase.pdm.listeners.onclick.IbDiagnosisListener;
import ase.pdm.listeners.onclick.IbSearchHospitalsListener;
import ase.pdm.listeners.onclick.IbSelectPactientListener;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LinearLayout ibCreatePatient = (LinearLayout) findViewById(R.id.llCreatePatient);
		ibCreatePatient.setOnClickListener(new IbCreatePatientListener(this));
		
		LinearLayout ibSelectPactient = (LinearLayout) findViewById(R.id.llSelectPatient);
		ibSelectPactient.setOnClickListener(new IbSelectPactientListener(this));
		
		LinearLayout ibSelectDiagnosis = (LinearLayout) findViewById(R.id.llDiagnosis);
		ibSelectDiagnosis.setOnClickListener(new IbDiagnosisListener(this));
		
		LinearLayout ibSearchHospitals = (LinearLayout) findViewById(R.id.llSearchHospitals);
		ibSearchHospitals.setOnClickListener(new IbSearchHospitalsListener(this));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Log.d("Debugging", "Clicked something!");
		}
		return super.onOptionsItemSelected(item);
	}

}
