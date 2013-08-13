package com.mongskie.mongscryptor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {
	
	Button toDesc = null;
	Button toAuthor = null;
	Button toCipher = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		toDesc = (Button) findViewById(R.id.button_desc);	
		toDesc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View p) {
				Intent next = new Intent(getApplicationContext(), AppDesc.class);
				startActivity(next);
			}
		});
		toAuthor = (Button) findViewById(R.id.button_author);
		toAuthor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent next = new Intent(getApplicationContext(), Author.class);
				startActivity(next);
			}
		});
		toCipher = (Button) findViewById(R.id.button_crypt);
		toCipher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent next = new Intent(getApplicationContext(), Encryptor.class);
				startActivity(next);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
