package ase.pdm.listeners.onclick;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import ase.pdm.pdm_medical.DiagnosisActivity;


public class IbDiagnosisListener implements View.OnClickListener {
	private Activity activity;
	
	public IbDiagnosisListener(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(v.getContext(), DiagnosisActivity.class);
		activity.startActivityForResult(intent, 0);
	}
}