package com.mymart.util;

import java.util.ArrayList;
import java.util.List;

import com.mymart.vo.InputMapper;

public class SetDivider {
	public static List<InputMapper> getSubSets(int[] intArray) {
		
		List<InputMapper> inputMappers = new ArrayList<InputMapper>();
		
	    int[] l = intArray;
	    boolean[] flags = new boolean[l.length];
	    for (int i = 0; i != l.length;) {
	        ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
	        for (int j = 0; j < l.length; j++)
	            if (flags[j]) a.add(l[j]); else b.add(l[j]);
	        InputMapper iMapper = new InputMapper();
	       // System.out.println("" + a + ", " + b);
	        iMapper.setFirstSubset(a);
	        iMapper.setSecondSubset(b);
	        inputMappers.add(iMapper);	        
	        for (i = 0; i < l.length && !(flags[i] = !flags[i]); i++);
	    }
	    
	 
		return inputMappers;
	    
	}

   
}