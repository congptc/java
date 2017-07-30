package com.worm.crawling.main;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.worm.crawling.impl.CrawlingDataForJsonResponse;
import com.worm.crawling.interfaces.ICrawlingData;

/**
 * Hello world!
 *
 */
public class App {

	static ICrawlingData iCrawlingData;
	static App app = new App();
	static ApplicationContext context = new ClassPathXmlApplicationContext("com/worm/crawling/config/bean.xml");

	public static void main(String[] args) throws Exception {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					app.crawlingHTMLData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 3000, 3000);

	}

	public void crawlingJSONData() throws Exception {
		iCrawlingData = context.getBean("crawlingDataForJSONReponse",ICrawlingData.class);
		JSONObject object = (JSONObject) iCrawlingData.crawling("https://s2.bitcoinwisdom.com/ticker");
		System.out.println(object.getJSONObject("btcebtcusd").getDouble("last"));
	}

	public void crawlingHTMLData() throws Exception {
		iCrawlingData = context.getBean("crawlingDataForHTMLReponse",ICrawlingData.class);
		Document doc = (Document) iCrawlingData.crawling("http://ketqua.net");
		Elements elements = doc.select("#rs_0_0");
		Element element = elements.get(0);
		System.out.println("Ket Qua : " + element.text());
	}
}
