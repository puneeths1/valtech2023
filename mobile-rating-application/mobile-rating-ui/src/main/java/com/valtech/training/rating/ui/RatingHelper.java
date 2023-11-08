package com.valtech.training.rating.ui;

import java.util.List;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.pattern.checker.PatternCheckerService;

public class RatingHelper {
//	private MobileRankingService mobRankService;
//	public int getRating(String mobile) {
//		return mobRankService.rankMobile(mobile);
//	}
	private MobileRankingService mobRankService;
   

	private PatternCheckerService patternCheckerService;

    public RatingHelper(MobileRankingService mobRankService, PatternCheckerService patternCheckerService) {
        this.mobRankService = mobRankService;
        this.patternCheckerService = patternCheckerService;
    }

    

	public int getRating(String mobile) {
    	if(mobRankService!=null) {
        return mobRankService.rankMobile(mobile);
    }else {
     return 0;
    }
    }

    public List<String> listPatterns(List<String> mobileNumbers) {
        List<String> sortedMobileNumbers = patternCheckerService.listPatterns(mobileNumbers);
        return sortedMobileNumbers;
    }

}
