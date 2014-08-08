/*import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

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
	//Vincular los elementos con la vista, se muestra titulo, imagen y precio
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row, parent, false);

		Item item = list.get(position);
		TextView txtName = (TextView) rowView.findViewById(R.id.textView1);
		txtName.setText(item.getTitle());
		
		ImageView image = (ImageView)rowView.findViewById(R.id.imageView1);
		ImageLoader.getInstance().displayImage(item.getImage(), image);
		
		TextView costo = (TextView) rowView.findViewById(R.id.costo);
		costo.setText(item.getPrice());
		
		return rowView;
	}
		/*private String getResponseText(InputStream inStream) {
		return new Scanner(inStream).useDelimiter("\\A").next();
	}
}*/

