package com.design.graph;

public class DepthFirstSearch {
	
	private boolean marked[];
	private int count;
	
	public DepthFirstSearch(Graph g,int s)
	{
		marked=new boolean[g.V()];
		dfs(g,s);
	}
	private void dfs(Graph g,int s)
	{
		marked[s]=true;
		count++;
		for(int w:g.adj(s))
			if(!marked[w])dfs(g,w);
			
	}
	public boolean marked(int w){
		return marked[w];
	}
	
	public int count()
	{
		return count;
	}

}
