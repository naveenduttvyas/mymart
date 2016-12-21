package com.mymart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.mymart.util.SetDivider;
import com.mymart.vo.BookEnum;
import com.mymart.vo.Discount;
import com.mymart.vo.InputConverter;
import com.mymart.vo.InputMapper;

public class PricingEngine {

	static Map<Integer, Integer> discountSource = new HashMap<Integer, Integer>();

	static double itemPrice = 0.00d;
	static double totalPrice = 0.00d;

	public Map<String, Double> calRecommendedPackPrice(List<Integer> numbers) {

		discountSource.put(0, 0);
		discountSource.put(1, 0);
		discountSource.put(2, 15);
		discountSource.put(3, 10);
		discountSource.put(4, 20);
		discountSource.put(5, 25);
		discountSource.put(6, 30);
		discountSource.put(7, 35);
		discountSource.put(8, 35);
		discountSource.put(9, 35);
		discountSource.put(10, 35);
		discountSource.put(11, 35);

		Map<String, Double> resultMap = new HashMap<String, Double>();

		int[] intInput = InputConverter.convertIntegers(numbers);

		// get subsets
		List<InputMapper> inputMappers = SetDivider.getSubSets(intInput);

		double fSetPrice = 0.00d;
		double secSetPrice = 0.00d;

		for (InputMapper entry : inputMappers) {

			fSetPrice = (entry.getFirstSubset().size() * 8 * (100 - discountSource.get(entry.getFirstSubset().size())));
			secSetPrice = (entry.getSecondSubset().size() * 8 * (100 - discountSource.get(entry.getSecondSubset().size())));
			totalPrice = fSetPrice / 100 + secSetPrice / 100;
			
			resultMap.put(entry.getFirstSubset().size() + "-" + entry.getSecondSubset().size(), totalPrice);

		}

		Set<Entry<String, Double>> set = resultMap.entrySet();
		List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1,
					Map.Entry<String, Double> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		for (Map.Entry<String, Double> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}

		// loop against the input
		/*
		 * for (Integer userInput : numbers) { BookEnum myBook =
		 * BookEnum.getByNumber(userInput);
		 * System.out.println("Individual Price - " + myBook.price); totalPrice
		 * = totalPrice + myBook.price; }
		 * 
		 * // calculate discount totalPrice = totalPrice * (100 -
		 * discountSource.get(numbers.size()))/ 100;
		 */

		System.out.println("Final price is :" + totalPrice);

		return resultMap;
	}

}
