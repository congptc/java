package com.worm.crawling.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class NetworkUtility {
	
	public JSONObject crawlingReturnJSON(String link) throws Exception {
		URL url = new URL(link);
		JSONObject jsonObject= null;
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + link);
		System.out.println("Response Code : " + responseCode);
		GZIPInputStream gis = new GZIPInputStream(connection.getInputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(gis,"UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print result
		jsonObject = new JSONObject(response.toString());
		return jsonObject;
	}
	
	public Document crawlingReturnHTML(String link) throws Exception {
		Document doc = null;
		doc = Jsoup.connect(link).get();
		return doc;
	}
	
	
	
}
