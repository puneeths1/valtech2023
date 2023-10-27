package com.valtech.training.mobileranking;

import java.util.List;

import com.valtech.training.pattern.checker.PatternCheckerService;
import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;

public class MobileRankingServiceImpl implements MobileRankingService{
	
	private PatternCheckerService pattCheckService = new PatternCheckerServiceImpl();
	
	@Override
	public int rankMobile(String mobile) {
		// TODO Auto-generated method stub
		List<String> patterns = pattCheckService.listPatterns(mobile);
		return 0;
	}
}
