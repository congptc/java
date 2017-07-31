package com.worm.crawling.impl;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;

import com.worm.crawling.interfaces.ICrawlingData;
import com.worm.crawling.utility.NetworkUtility;

public class CrawlingKetQuaXoSo implements ICrawlingData {

	private final Map<String, String[]> listResult = new HashMap<String, String[]>();
	private final StringBuilder sb = new StringBuilder();

	public CrawlingKetQuaXoSo() {
		listResult.put("Giai bay", new String[] { "#rs_7_3", "#rs_7_2", "#rs_7_1", "#rs_7_0" });
		listResult.put("Giai sau", new String[] { "#rs_6_2", "#rs_6_1", "#rs_6_0" });
		listResult.put("Giai nam", new String[] { "#rs_5_5", "#rs_5_4", "#rs_5_3", "#rs_5_2", "#rs_5_1", "#rs_5_0" });
		listResult.put("Giai tu", new String[] { "#rs_4_3", "#rs_4_2", "#rs_4_1", "#rs_4_0" });
		listResult.put("Giai ba", new String[] { "#rs_3_5", "#rs_3_4", "#rs_3_3", "#rs_3_2", "#rs_3_1", "#rs_3_0" });
		listResult.put("Giai nhi", new String[] { "#rs_2_1", "#rs_2_0" });
		listResult.put("Giai nhat", new String[] { "#rs_1_0" });
		listResult.put("Giai dac biet", new String[] { "#rs_0_0" });
	}

	@SuppressWarnings("unchecked")
	public String crawling(String link, ApplicationContext context) throws Exception {
		NetworkUtility networkUtility = context.getBean("networkUtility", NetworkUtility.class);
		Document doc = networkUtility.crawlingReturnHTML(link);
		
		for (Map.Entry<String, String[]> result : listResult.entrySet()) {
			for(String strPrize : result.getValue()) {
				sb.append(doc.select(strPrize).first().text()+"|");
			}
			System.out.println(result.getKey() + ":" + sb.toString());
			sb.setLength(0);
		}
		System.out.println("=========================================");
		return "hehe";
	}

}
