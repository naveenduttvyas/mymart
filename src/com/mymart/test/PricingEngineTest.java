package com.mymart.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import com.mymart.service.PricingEngine;

public class PricingEngineTest {

	@Test
	public void test() {

		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(3);
		inputList.add(3);
		inputList.add(4);
		inputList.add(4);
		inputList.add(5);
		inputList.add(5);
		inputList.add(6);
		inputList.add(7);

		System.out.println("########## Calculating Price for 2 copies of 3rd book and so .. mentioned in problem statement #############");
		PricingEngine prEngine = new PricingEngine();
		Map<String, Double> map = prEngine.calRecommendedPackPrice(inputList);
		System.out.println("Map size >> " + map.size());
		org.junit.Assert.assertEquals(9, map.size());
		
		
		
	}

}
