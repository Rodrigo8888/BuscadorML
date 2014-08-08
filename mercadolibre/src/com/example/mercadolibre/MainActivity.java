package com.example.mercadolibre;

import java.util.ArrayList;

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
import android.widget.ImageButton;
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
		adapter = new ListAdapter(this, R.id.listView1, this.listaItems,0);
		this.lista.setAdapter(adapter);
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
		ImageLoader.getInstance().init(config);
		
		this.lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			//Evento, al hacer click sobre un item de la lista, lo muestra en la siguiente actividad Detail
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Item item = listaItems.get(arg2);
				Intent i = new Intent(MainActivity.this, Detail.class);
				i.putExtra("item", item);
				startActivity(i);
			}
			
		});
		

		
		ImageButton btSearch = (ImageButton)findViewById(R.id.imageButton1);
		btSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			//Evento del boton buscar
			public void onClick(View arg0) {
				dialog = ProgressDialog.show(MainActivity.this, "", "Buscando...", true);
				EditText txt = (EditText)findViewById(R.id.editText1);
				GetList list = new GetList(MainActivity.this, txt.getText().toString());
				list.start();			
			}
		});
		
	}

	//Metodo que refresca la vista
	public void refreshList(final ArrayList<Item> items,final int sort)
	{
		dialog.dismiss();
		this.listaItems = items;
		runOnUiThread(new Runnable() {
			public void run() {
				adapter = new ListAdapter(MainActivity.this, R.id.listView1, items,sort);
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
	//Metodo del menu, que permite ordenar la lista por menor o mayor precio
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(!listaItems.isEmpty()){
			if (id == R.id.precio_mayor) 
				this.refreshList(listaItems,1);
			else{
				if (id == R.id.precio_menor) 
					this.refreshList(listaItems,-1);
			}
		}
			
		return super.onOptionsItemSelected(item);
	}
}
