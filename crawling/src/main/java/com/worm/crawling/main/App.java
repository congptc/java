package com.worm.crawling.main;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import com.worm.crawling.impl.CrawlingDataForJsonResponse;
import com.worm.crawling.interfaces.ICrawlingData;

/**
 * Hello world!
 *
 */
public class App {
	
	static ICrawlingData iCrawlingData = new CrawlingDataForJsonResponse();
	public static void main(String[] args) throws Exception {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					JSONObject object = (JSONObject)iCrawlingData.crawling("https://s2.bitcoinwisdom.com/ticker");
					System.out.println(object.getJSONObject("btcebtcusd").getDouble("last"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 3000,3000);

	}
}
