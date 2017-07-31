package com.worm.crawling.interfaces;

import org.springframework.context.ApplicationContext;

public interface ICrawlingData {
	<T> T crawling(String link,ApplicationContext context) throws Exception;
}
