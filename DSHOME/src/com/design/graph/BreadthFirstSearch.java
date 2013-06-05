package com.design.graph;

import java.util.Stack;

import com.design.queue.Queue;




public class BreadthFirstSearch {
	
	private boolean marked[];
	private int edgeTo[];
	private int source;
	
	public BreadthFirstSearch(Graph g,int s)
	{
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
		this.source=s;
		bfs(g,s);
	}
	
	private void bfs(Graph g,int s)
	{
		Queue queue=new Queue(g.V());
		marked[s]=true;
		queue.enqueue(s);
		while(!queue.isEmpty())
		{
			int v=queue.dequeue();
			for(int w:g.adj(v))
			{
				if(!marked[w])
				{
					marked[w]=true;
					edgeTo[w]=v;
					queue.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))return null;
		Stack<Integer> stack=new Stack<Integer>();
		for(int x=v;x!=source;x=edgeTo[x])
			stack.push(x);
		stack.push(source);
		return stack;
	}

}
