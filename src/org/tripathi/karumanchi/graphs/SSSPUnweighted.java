package org.tripathi.karumanchi.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Single Source shortest path in an unweighted graph
 */
public class SSSPUnweighted {
	
	// Runtime : O( V + E )
	public void UnweightedShortedPath( List<List<Integer>> graph, Integer u /* src */ ) {
		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[ graph.size() ];
		
		Arrays.fill(distance, -1);
		
		distance[u] = 0;
		queue.add( u );
		
		while( !queue.isEmpty() ) {
			int v = queue.poll();
			
			List<Integer> adj = graph.get( v );
			
			for( Integer neighbor : adj ) {
				
				if( distance[ neighbor ] == -1 /* also means, if neighbor is unvisited */){
					queue.add( neighbor );
					distance[ neighbor ] = distance[ v ] + 1;
					queue.add( neighbor );
				}
			}
		}
	}
}
