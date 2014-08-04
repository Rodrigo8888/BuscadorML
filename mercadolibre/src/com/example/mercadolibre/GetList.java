package com.example.mercadolibre;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

//Obtengo la lista de la APIs Search, y muestro los elementos
public class GetList extends Thread {

	private MainActivity activity;
	private String search;
	
	public GetList(MainActivity activity, String search)
	{
		this.activity = activity;
		this.search = search;
	}
	
	@Override
	//Obtengo datos de la APIs
	public void run() {
		try {
			URL urlToRequest = new URL("https://api.mercadolibre.com/sites/MLU/search?q=" + this.search);
			HttpURLConnection urlConnection = (HttpURLConnection) urlToRequest.openConnection();
			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
			JSONObject json = new JSONObject(getResponseText(in));
			JSONArray lista = json.getJSONArray("results");
			
			ArrayList<Item> listaItems = new ArrayList<Item>();
			
			//Creo nuevos items con cada uno de los elementos que necesito de la Api
			for (int i = 0; i < lista.length(); i++) {
				JSONObject item = (JSONObject) lista.get(i);		
				listaItems.add(new Item(item.getString("thumbnail"), item.getString("title"),item.getString("price"),item.getString("id"),""));	
			}
			//Refresco la lista con los nuevos datos
			this.activity.refreshList(listaItems,0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getResponseText(InputStream inStream) {
		return new Scanner(inStream).useDelimiter("\\A").next();
	}

}
