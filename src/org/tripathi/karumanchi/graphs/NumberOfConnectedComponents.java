package org.tripathi.karumanchi.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
//Problem-19 in the book
public class NumberOfConnectedComponents {

	public int countComponents(int n, int[][] edges) {

		Map<Integer, List<Integer>> graph = new HashMap<>();

		init(graph, edges);
		int[] count = new int[2];
		boolean[] visited = new boolean[n];
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			Integer src = entry.getKey();
			if (!visited[src]) {

				dfs(graph, count, src, visited);
				count[1]++;
			}
		}

		return (n - count[0]);
	}

	private void dfs(Map<Integer, List<Integer>> graph, int[] count, int u, boolean[] visited) {

		List<Integer> adj = graph.get(u);

		visited[u] = true;

		for (Integer neighbor : adj) {
			if (!visited[neighbor]) {
				count[0]++;
				dfs(graph, count, neighbor, visited);
			}
		}

	}

	private void init(Map<Integer, List<Integer>> graph, int[][] edges) {
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			List<Integer> adj = graph.get(edge[0]);
			adj.add(edge[1]);

			graph.putIfAbsent(edge[1], new ArrayList<>());
			adj = graph.get(edge[1]);
			adj.add(edge[0]);
		}
	}
}
