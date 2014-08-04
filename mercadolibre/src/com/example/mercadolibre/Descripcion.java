/*package com.example.mercadolibre;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

/*Esta seria la clase descripcion, en la cual estaria la logica para poder obtener la descripcion de la APIs de mercado libre
 * y vincularla con la vista, fue lo que no pude lograr, pero lo dejo para que puedan ver lo que hice.
 * Hay mucho codigo de prueba, por eso hay metodos que se repiden
 

public class Descripcion extends Activity {
	
	private String descripcion;
	private ListView listdesc;
	private ListAdapter adapter;
	private ArrayList<Item> listaItems;
	ProgressDialog dialog = null;
	Activity mActivity;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_descripcion);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		//dialog = ProgressDialog.show(Descripcion.this, "", "Accediendo a Descripcion...", true);
		Bundle b = this.getIntent().getExtras();
		final Item item = (Item)b.getSerializable("item");
		
		this.tv = (TextView)findViewById(R.id.itemDes);
		
		mActivity= this;
		
		/*GetDescripcion desc = new GetDescripcion(Descripcion.this, item.getIdItem());
		desc.start();*/
		
		/*TextView txt = (TextView)findViewById(R.id.itemDes);
		txt.setText(item.getIdItem());*/
		//runThread(item.getIdItem());
		
		/*Handler refresh = new Handler(Looper.getMainLooper());
		refresh.post(new Runnable() {
		    public void run()
		    {
		    	try {
	    			URL urlToRequest = new URL("https://api.mercadolibre.com/items/"+item.getIdItem()+"/description/");
	    			HttpURLConnection urlConnection = (HttpURLConnection) urlToRequest.openConnection();
	    			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
	    			JSONObject json = new JSONObject(getResponseText(in));
	    			String description = json.getString("text");
	    			
	    			/*if (this.activity != null){
	    				this.activity.refreshDescription(description);
	    			}else{
	    				String coso = "null";
	    			}*/
	    			/*tv.setText(description);
	    			
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
		    }
		});
	}
	
	private void runThread(final String idItem) {
	    new Thread() {
	        public void run() {
	        	try {
	    			URL urlToRequest = new URL("https://api.mercadolibre.com/items/"+idItem+"/description/");
	    			HttpURLConnection urlConnection = (HttpURLConnection) urlToRequest.openConnection();
	    			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
	    			JSONObject json = new JSONObject(getResponseText(in));
	    			String description = json.getString("text");
	    			
	    			/*if (this.activity != null){
	    				this.activity.refreshDescription(description);
	    			}else{
	    				String coso = "null";
	    			}*/
	    		/*	tv.setText(description);
	    			
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	        }
	    }.start();
	}
	
	/*
	thread{
	    mActivity.runOnUiThread(new Runnable() {
	        public void run() {
	            tv.setText("javier");
	        }
	    });
	}*/

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.descripcion, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_descripcion,
					container, false);
			return rootView;
		}
	}

	/*public void refreshDescription(String description) {
		//dialog.dismiss();
		//Item item = new Item("","","","",description);
		//final ArrayList<Item> items = new ArrayList<Item>();
		//items.add(item);
		this.descripcion = description;
		/*runOnUiThread(new Runnable() {
			public void run() {
				adapter = new ListAdapter(Descripcion.this, R.id.listaDes, items,0);
				listdesc.setAdapter(adapter);
				adapter.notifyDataSetChanged();
				}
			});*/
		//TextView txt = (TextView)findViewById(R.id.itemDes);
		//txt.setText(description);
	//}
	
	/*private String getResponseText(InputStream inStream) {
		return new Scanner(inStream).useDelimiter("\\A").next();
	}
}*/

