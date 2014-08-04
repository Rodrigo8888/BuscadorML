package com.example.mercadolibre;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Detail extends Activity {

	
	private ProgressDialog dialog = null;
	
	@Override
	//Vinculo los datos de la api con los elementos de la vista
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		Bundle b = this.getIntent().getExtras();
		final Item i = (Item)b.getSerializable("item");
		
		TextView txt = (TextView)findViewById(R.id.titulo);
		txt.setText(i.getTitle());
		
		TextView precio = (TextView)findViewById(R.id.precio);
		precio.setText(i.getPrice());
		
		ImageView image = (ImageView)findViewById(R.id.imageView1);
		ImageLoader.getInstance().displayImage(i.getImage(), image);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
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
