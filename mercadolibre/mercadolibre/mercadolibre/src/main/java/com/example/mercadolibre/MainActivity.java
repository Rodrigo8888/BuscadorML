package com.example.mercadolibre;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends Activity {

	private ListView lista;
	private ArrayList<Item> listaItems;
	private ListAdapter adapter;
	ProgressDialog dialog = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.lista = (ListView)findViewById(R.id.listView1);
		this.listaItems = new ArrayList<Item>();
		adapter = new ListAdapter(this, R.id.listView1, this.listaItems);
		this.lista.setAdapter(adapter);
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
		ImageLoader.getInstance().init(config);
		
		
		Button btSearch = (Button)findViewById(R.id.button1);
		btSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialog = ProgressDialog.show(MainActivity.this, "", "Buscando...", true);
				EditText txt = (EditText)findViewById(R.id.editText1);
				GetList list = new GetList(MainActivity.this, txt.getText().toString());
				list.start();				
			}
		});
			
		
	}

	
	public void refreshList(final ArrayList<Item> items)
	{
		dialog.dismiss();
		this.listaItems = items;
		runOnUiThread(new Runnable() {
			public void run() {
				adapter = new ListAdapter(MainActivity.this, R.id.listView1, items);
				lista.setAdapter(adapter);
				adapter.notifyDataSetChanged();
				}
			});
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
