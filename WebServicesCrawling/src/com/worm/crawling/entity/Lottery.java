package com.worm.crawling.entity;

import java.util.List;
import java.util.Map;

public class Lottery {
	private List<Map<String, List<String>>> prizeLottery;

	public List<Map<String, List<String>>> getPrizeLottery() {
		return prizeLottery;
	}

	public void setPrizeLottery(List<Map<String, List<String>>> prizeLottery) {
		this.prizeLottery = prizeLottery;
	}
	
	public void clearLottery()
	{
		prizeLottery.clear();
	}
	
}
