package com.worm.crawling.main;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.worm.crawling.interfaces.ICrawlingData;

/**
 * Hello world!
 *
 */
public class App {

	static ICrawlingData iCrawlingData;
	static ApplicationContext context = new ClassPathXmlApplicationContext("com/worm/crawling/config/bean.xml");

	public static void main(String[] args) throws Exception {

		iCrawlingData = context.getBean("crawlingKetQuaXoSo",ICrawlingData.class);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					iCrawlingData.crawling("http://ketqua.net",context);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 3000, 3000);

	}

	public void crawlingJSONData() throws Exception {
		JSONObject object = (JSONObject) iCrawlingData.crawling("https://s2.bitcoinwisdom.com/ticker",context);
		System.out.println(object.getJSONObject("btcebtcusd").getDouble("last"));
	}

}
