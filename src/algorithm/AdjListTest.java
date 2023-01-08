package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {

	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
		
	}
	static int V ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		V= sc.nextInt();
		
		int E  =sc.nextInt(); //간선 수
		
		Node[] adjList = new Node[V];
		
		for(int i=0;i<E;i++) {
			int from=sc.nextInt();
			int to =sc.nextInt();
			
			adjList[from]=new Node(to,adjList[from]);
			adjList[to]=new Node(from,adjList[to]);
		}
		
//		for(Node head : adjList) {
//			System.out.println(head);
//		}
//		
//		bfs(adjList,0);
		dfs(adjList,new boolean[V],0);
		
	}
	
	public static void bfs(Node[] adjList,int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[V];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current =queue.poll();
			System.out.println(current);
			
			for(Node temp=adjList[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			
			
		}
	}
	public static void dfs(Node[] adjList,boolean[] visited,int current) {
		visited[current] = true;
		System.out.println(current);
		
		//current 정점의 인접정점 처리
		for(Node temp = adjList[current] ; temp!=null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				dfs(adjList,visited,temp.vertex);
			}
		}
	}

}
