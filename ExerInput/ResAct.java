package com.example.exerinput;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResAct extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_res);
		
		Intent passed = getIntent();
		String output = passed.getExtras().getString("output");
		
		TextView outputView = (TextView) findViewById(R.id.textView_output);
		outputView.setText(output);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.res, menu);
		return true;
	}

}
