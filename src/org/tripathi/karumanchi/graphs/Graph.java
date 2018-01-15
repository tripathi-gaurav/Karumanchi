package org.tripathi.karumanchi.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
//dfs on adjency list graph 
public class Graph {
	
	private Map<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	
	class Node{
		//using specialized vertex
		private int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id) {
			this.id = id;
		}
	}
	
	private Node getNode(int id) {
		return this.nodeLookup.get(id);
	}
	
	public void addEdge(int source, int dest) {
		Node s = getNode(source);
		Node d = getNode(dest);
		
		s.adjacent.add(d);
	}
	
	public boolean hasPathDFS(int source, int dest) {
		Node src = getNode(source);
		Node des = getNode(dest);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(src, des, visited);
	}
	
	public boolean hasPathDFS(Node source, Node dest, HashSet<Integer> visited) {
		if(visited.contains(source.id)) {
			return false;
		}
		for(Node child : source.adjacent) {
			if(hasPathDFS(child, dest, visited)) {
				return true;
			}
		}
		return false;
	}
	

}
