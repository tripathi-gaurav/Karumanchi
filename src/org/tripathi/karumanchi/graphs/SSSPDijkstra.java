package org.tripathi.karumanchi.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/network-delay-time/
public class SSSPDijkstra {

	//If you want a graph with labels
    //Map<String, Map<String, Double>> graph = new HashMap<>();
	//If you want a graph with Integer IDs
	//Map( src (u ), map<dst (v), WEIGHT> )
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

    public int networkDelayTime(int[][] times, int N, int K) {
    
        init( times ); //initialize the weighted graph
        PriorityQueue<int[]> pq = new PriorityQueue<>( new Comparator<int[]>() {
        	@Override
        	public int compare( int[] i1, int[] i2 ) {
        		return i1[0]- i2[0];
        	}
        });
        
        pq.add( new int[] {0, K} );
        
        Map<Integer, Integer> distance = new HashMap<>();
        
        while( !pq.isEmpty() ) {
        	int[] curr = pq.poll();
        	int u = curr[1];
        	int wt = curr[0];
        	
        	if( distance.containsKey( u ) ) {
        		continue;
        	}
        	distance.put( u , wt );
        	Map<Integer, Integer> adjList = graph.get( u );
        	for( Map.Entry<Integer, Integer> neighbors : adjList.entrySet() ) {
        		int v = neighbors.getKey();
        		int wt2 = neighbors.getValue();
        		if( !distance.containsKey( v ) ) {
        			pq.add(new int[] {wt+wt2, v} );
        		}
        	}
        	
        }
        
        
        
        Map<Integer, Integer> adjacentToU = graph.get( K ); //src
        for( Map.Entry<Integer, Integer> neighbors : adjacentToU.entrySet() ){
            int v = neighbors.getKey();
            int wt = neighbors.getValue();
            
            
        }
        return -1;
    }
    
    
    private void init(int[][] times){
        for( int[] edges : times ){
            int u = edges[0];
            int v = edges[1];
            int wt = edges[2];
            
            graph.putIfAbsent( u, new HashMap<>() );
            graph.putIfAbsent( v, new HashMap<>() );
            Map<Integer, Integer> adj = graph.get( u );
            adj.put( v, wt );
            
        }
    }

}
