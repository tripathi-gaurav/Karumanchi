package org.tripathi.karumanchi.tries;

//https://leetcode.com/problems/implement-trie-prefix-tree/description/

public class Trie {

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				node.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public void insertRecursive(String word) {

	}

	public void insertRecursive(String word, TrieNode current, int index) {
		if(index == word.length()) {
			current.endOfWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null) {
			node = new TrieNode();
			node.children.put(ch, node);
		}
		current = node;
		insertRecursive(word, current, index+1);
	}
	
	public boolean search(String word) {
		TrieNode current = root;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null) {
				return false;
			}
			current = node;
		}
		return (current.endOfWord); 
		
	}
	
	public boolean delete(TrieNode current, String word, int index) {
		if( index == word.length() ) {
			
			if(!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return true;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node==null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index+1);
		
		if(shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}
	
    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return (current != null);
    }
    
}
