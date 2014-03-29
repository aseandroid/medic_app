package ase.pdm.listeners.onclick;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import ase.pdm.pdm_medical.CreatePatientActivity;

public class IbCreatePatientListener implements View.OnClickListener {
	private Activity activity;
	
	public IbCreatePatientListener(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(v.getContext(), CreatePatientActivity.class);
		activity.startActivityForResult(intent, 0);
	}

}
