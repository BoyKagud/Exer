package com.mongskie.mongscryptor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Encryptor extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encryptor);
		
		final EditText inputET = (EditText) findViewById(R.id.editText_input);
		final EditText keyET = (EditText) findViewById(R.id.editText_key);
		
		final RadioGroup directionRG = (RadioGroup) findViewById(R.id.radioGroup_direction);
		final RadioGroup operationRG = (RadioGroup) findViewById(R.id.radioGroup_operation);
		
		final TextView resOut = (TextView) findViewById(R.id.textView_result);
		
		Button cryptB = (Button) findViewById(R.id.button_crypt);
		cryptB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String plain = inputET.getText().toString().toUpperCase();
				char[] plainChar = plain.toCharArray();
				Integer key = Integer.parseInt(keyET.getText().toString());
				
				if(key <= 10 && key > 0) {
					int dirId = directionRG.getCheckedRadioButtonId();
					View radioDir = directionRG.findViewById(dirId);
					int dirIndex = directionRG.indexOfChild(radioDir);
					Integer dir = Integer.parseInt(directionRG.getChildAt(dirIndex).getTag().toString());
					
					resOut.setText(shift(plainChar, dir*key));
				} else resOut.setText("Key must only be between 1 - 10");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encryptor, menu);
		return true;
	}
	
	private int getIntVal(char key) {
		char[] alpha = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		int alphaNum = alpha.length-1;
		for(int k=0; k <= alphaNum; k++) {
			if(alpha[k] == key) return k;
		}
		return -1;
	}
	
	private char getCharVal(int key) {
		char[] alpha = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		return alpha[key];
	}
	
	private String shift(char[] plain, int key) {
		int[] seq = new int[plain.length];
		int[] seqCipher = new int[plain.length];
		char[] cipherText = new char[plain.length];
		int i=0;
		for(char k : plain) {
			seq[i] = getIntVal(k);
			i++;
		}
		i=0;
		for(int k : seq) {
			int shift = k+key;
			if (shift > 25) shift = (shift%25)-1; 
			else if(shift < 0) shift = shift + 26;
			cipherText[i] = getCharVal(shift);
			i++;
		}
		String out = String.copyValueOf(cipherText).toUpperCase();
		return out;
	}

}
