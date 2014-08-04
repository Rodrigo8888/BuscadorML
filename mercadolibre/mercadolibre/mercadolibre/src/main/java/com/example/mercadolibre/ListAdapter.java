package com.example.mercadolibre;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Item> {

	private Context context;
	private ArrayList<Item> list;

	public ListAdapter(Context context,int textViewResourceId,
			ArrayList<Item> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.list = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row, parent, false);

		Item item = list.get(position);
		TextView txtName = (TextView) rowView.findViewById(R.id.textView1);
		txtName.setText(item.getTitle());
		
		ImageView image = (ImageView)rowView.findViewById(R.id.imageView1);
		ImageLoader.getInstance().displayImage(item.getImage(), image);
		
		return rowView;
	}

}
