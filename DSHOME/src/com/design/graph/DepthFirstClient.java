package com.design.graph;

import com.design.utils.InputReader;

public class DepthFirstClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepthFirstClient client=new DepthFirstClient();
		client.searchGraph();
		

	}
	public void searchGraph()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/dfs.txt"));
		Graph graph=new Graph(in);
		DepthFirstSearch dfs=new DepthFirstSearch(graph,0);
		if(dfs.count()==graph.V())
			System.out.println("Graph is connected");
		else
			System.out.println("Graph is not connected");
	}

}
