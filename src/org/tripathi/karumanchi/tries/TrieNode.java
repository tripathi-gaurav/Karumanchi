package org.tripathi.karumanchi.tries;

import java.util.*;

public class TrieNode {

	Map<Character, TrieNode> children;
	boolean endOfWord;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
	
}
