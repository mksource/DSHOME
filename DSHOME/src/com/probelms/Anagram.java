package com.probelms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
/**
 * 
 * @author karthik1
 * A file contains set of anagrams we have to find the similar words
 *First we have to sort each and every word in the file 
 *We have to maintain a hashmap with key as the sorted word and entries containing the 
 *anagrams
 */
public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String arr[]={"plates","stop","staple","pots","meat","not","pot","team"};
		HashMap<String,TreeSet<String>> hashmap=new HashMap<String,TreeSet<String>>();
		for(int i=0;i<arr.length;i++)
		{
			String word=arr[i];
			char wordc[]=word.toCharArray();
			Arrays.sort(wordc);
			String sorted=new String(wordc);
			if(hashmap.containsKey(sorted))
				hashmap.get(sorted).add(word);
			else
			{
				TreeSet<String> set=new TreeSet<String>();
				set.add(word);
				hashmap.put(sorted,set);
			}
			
		}
		
		System.out.println("The anagrams in the list of the words are");
		System.out.println(hashmap);
		

	}

}
