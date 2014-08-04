/*package com.example.mercadolibre;

import java.util.ArrayList;
import java.util.Collections;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/*Intente crear un adapter para poder comunicar el item con su descripcion, estuve investigando pero me tira
 * el error de que el hilo que estoy manejando no puede setear parametros que maneja el hilo principal.
 * Como aun no manejo mucho los cnceptos practicos de hilos, no puedo conseguirlo.
 * Dejo la clase comentada.
 
public class DescAdapter extends BaseAdapter {

	private Context context;
	private String descripcion;

	public DescAdapter(Context context,int textViewResourceId,
			String descripcion) {
		//super(context, textViewResourceId, descripcion);
		super();
		this.context = context;
		this.descripcion = descripcion;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_descripcion, parent, false);

		TextView txtName = (TextView) view.findViewById(R.id.itemDes);
		txtName.setText(descripcion);
		
		return view;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

}
*/