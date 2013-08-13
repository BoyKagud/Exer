package com.example.exerinput;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	EditText nameField;
	
	RadioGroup radGcourses;
	RadioGroup radGlevels;
	RadioButton cCS;
	RadioButton cIT;
	RadioButton cIS;
	RadioButton y1;
	RadioButton y2;
	RadioButton y3;
	RadioButton y4;
	RadioButton y5;
	
	Button submit;
	
	String output;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		nameField = (EditText) findViewById(R.id.editText1);
		
		radGcourses = (RadioGroup) findViewById(R.id.radioGroup_course);
		radGlevels = (RadioGroup) findViewById(R.id.radioGroup_level);
		
		cCS = (RadioButton) findViewById(R.id.radio_course_Computer_Science);
		cIT = (RadioButton) findViewById(R.id.radio_course_Info_Tech);
		cIS = (RadioButton) findViewById(R.id.radio_course_infp_sys);
		
		y1 = (RadioButton) findViewById(R.id.radio_level_1);
		y2 = (RadioButton) findViewById(R.id.radio_level_2);
		y3 = (RadioButton) findViewById(R.id.radio_level_3);
		y4 = (RadioButton) findViewById(R.id.radio_level_4);
		y5 = (RadioButton) findViewById(R.id.radio_level_5);
		
		submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				output = "";
				int radioCid = radGcourses.getCheckedRadioButtonId();
				View radioCV = radGcourses.findViewById(radioCid);
				int radioCIndex = radGcourses.indexOfChild(radioCV);
				String course = radGcourses.getChildAt(radioCIndex).getTag().toString();
				
				int radioLid = radGlevels.getCheckedRadioButtonId();
				View radioLV = radGlevels.findViewById(radioLid);
				int radioLIndex = radGlevels.indexOfChild(radioLV);
				String level = radGlevels.getChildAt(radioLIndex).getTag().toString();
				
				output += nameField.getText().toString()+"\n"
						+ course+"\n"+level;
				Intent toNext = new Intent(getApplicationContext(), ResAct.class);
				toNext.putExtra("output", output);
				startActivity(toNext); 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
