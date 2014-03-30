package ase.pdm.listeners.onclick;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import ase.pdm.pdm_medical.MedicalLocationsActivity;



public class IbSearchHospitalsListener implements View.OnClickListener {
	private Activity activity;
	
	public IbSearchHospitalsListener(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(v.getContext(), MedicalLocationsActivity.class);
		activity.startActivityForResult(intent, 0);
	}
}