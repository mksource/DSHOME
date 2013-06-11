package com.design.trees;

import com.design.utils.InputReader;

public class ThreadClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadClient client=new ThreadClient();
		client.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/thread.txt"));
		
		int num=in.readInt();
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		
		for(int i=0;i<num;i++)
		{
			tree.insert(in.readInt());
		}
		tree.doTraversal(ThreadedBinaryTree.INORDER);
	}

}
