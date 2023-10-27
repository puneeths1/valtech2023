package com.valtech.training.rating.ui;

import com.valtech.training.mobileranking.MobileRankingService;

public class RatingHelper {
	private MobileRankingService mobRankService;
	public int getRating(String mobile) {
		return mobRankService.rankMobile(mobile);
	}

}
