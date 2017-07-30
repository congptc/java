package com.worm.crawling.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.worm.crawling.interfaces.ICrawlingData;

public class CrawlingDataForHTMLReponse implements ICrawlingData {

	@SuppressWarnings("unchecked")
	public Document crawling(String link) throws Exception {
		Document doc = null;
		doc = Jsoup.connect(link).get();
		return doc;
	}

}
