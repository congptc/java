package com.worm.crawling.interfaces;

public interface ICrawlingData {
	<T> T crawling(String link) throws Exception;
}
