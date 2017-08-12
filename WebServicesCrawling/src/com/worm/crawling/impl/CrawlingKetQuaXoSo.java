package com.worm.crawling.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.jsoup.nodes.Document;

import com.worm.crawling.entity.Lottery;
import com.worm.crawling.interfaces.ICrawlingData;
import com.worm.crawling.utility.NetworkUtility;

public class CrawlingKetQuaXoSo implements ICrawlingData {

	private final Map<String, String[]> frameworkLottery = new HashMap<String, String[]>();
	private final Map<String, List<String>> prize = new  HashMap<String, List<String>>();
	private final List<Map<String, List<String>>> resultLottery = new ArrayList<>();
	private Lottery lottery;
	private NetworkUtility networkUtility;
	
	public void setNetworkUtility(NetworkUtility networkUtility) {
		this.networkUtility = networkUtility;
	}

	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}

	

	public CrawlingKetQuaXoSo() {
		frameworkLottery.put("7", new String[] { "#rs_7_3", "#rs_7_2", "#rs_7_1", "#rs_7_0" });
		frameworkLottery.put("6", new String[] { "#rs_6_2", "#rs_6_1", "#rs_6_0" });
		frameworkLottery.put("5", new String[] { "#rs_5_5", "#rs_5_4", "#rs_5_3", "#rs_5_2", "#rs_5_1", "#rs_5_0" });
		frameworkLottery.put("4", new String[] { "#rs_4_3", "#rs_4_2", "#rs_4_1", "#rs_4_0" });
		frameworkLottery.put("3", new String[] { "#rs_3_5", "#rs_3_4", "#rs_3_3", "#rs_3_2", "#rs_3_1", "#rs_3_0" });
		frameworkLottery.put("2", new String[] { "#rs_2_1", "#rs_2_0" });
		frameworkLottery.put("1", new String[] { "#rs_1_0" });
		frameworkLottery.put("0", new String[] { "#rs_0_0" });
		frameworkLottery.put("*", new String[] { "span#date_mb" });
	}

	@SuppressWarnings("unchecked")
	public String crawling(String link) throws Exception {
		Document doc = networkUtility.crawlingReturnHTML(link);
		for (Map.Entry<String, String[]> result : frameworkLottery.entrySet()) {
			List<String> lstResutlFollowPrize = new ArrayList<>();
			for(String strPrize : result.getValue()) {
				lstResutlFollowPrize.add(doc.select(strPrize).first().text());
			}
			prize.put(result.getKey(), lstResutlFollowPrize);
		}
		resultLottery.add(prize);
		lottery.setPrizeLottery(resultLottery);
		JSONObject jsonObject = new JSONObject(lottery);
		lottery.clearLottery();
		return jsonObject.toString();
	}

}
