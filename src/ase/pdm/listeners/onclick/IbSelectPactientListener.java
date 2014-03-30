package ase.pdm.listeners.onclick;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import ase.pdm.pdm_medical.CreatePatientActivity;
import ase.pdm.pdm_medical.SelectPactientActivity;

public class IbSelectPactientListener implements View.OnClickListener {
	private Activity activity;
	
	public IbSelectPactientListener(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(v.getContext(), SelectPactientActivity.class);
		activity.startActivityForResult(intent, 0);
	}
}