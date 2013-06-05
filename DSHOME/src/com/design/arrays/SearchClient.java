package com.design.arrays;

import com.design.utils.InputReader;

public class SearchClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchClient client=new SearchClient();
		client.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/array.txt"));
	}

}
