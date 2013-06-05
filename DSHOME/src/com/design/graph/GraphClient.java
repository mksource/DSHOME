package com.design.graph;



import com.design.utils.InputReader;

public class GraphClient {

	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a Graph and print it 
		GraphClient client=new GraphClient();
		client.printGraph();
		

	}
	
	public void printGraph()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/tinyG.txt"));
		
		
		Graph g=new Graph(in);
		in.close();
		System.out.println(g);
		
		/*
		AdjMatrixgraph graph=new AdjMatrixgraph(in);
		in.close();
		System.out.println(graph);*/
		
	}

}
