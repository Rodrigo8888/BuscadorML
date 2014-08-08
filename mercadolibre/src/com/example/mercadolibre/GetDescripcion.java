/*package com.example.mercadolibre;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;



//Esta clase era exclusivamente para tratar de obtener la descripcion de la APIs de ML y refrescar la vista con la descripcion obtenida
public class GetDescripcion extends Thread {

	private MainActivity activity;
	private Item idItem;
	
	public GetDescripcion(MainActivity activity, Item i)
	{
		this.activity = activity;
		this.idItem = i;
	}
	
	@Override
	public void run() {
		try {
			URL urlToRequest = new URL("https://api.mercadolibre.com/items/"+this.idItem.getDescription()+"/description/");
			HttpURLConnection urlConnection = (HttpURLConnection) urlToRequest.openConnection();
			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
			JSONObject json = new JSONObject(getResponseText(in));
			String description = json.getString("text");
			this.activity.refreshDescription(description);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getResponseText(InputStream inStream) {
		return new Scanner(inStream).useDelimiter("\\A").next();
	}

}*/

