package org.tripathi.karumanchi.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/path-sum-ii/description/
//Find path to leaf that equal a target
//similar to problem 21, but a bit different

public class PathWithSum {

public List<List<Integer>> pathSum(BinaryTreeNode root, int sum) {
        
        List<List<Integer>> listOfPathSum = new ArrayList<List<Integer>>();
        List<Integer> pathSumElements = new ArrayList<Integer>();
        if(root == null){
            return listOfPathSum;
        }
        String pathElements = "";
        Stack<Object> stack = new Stack<Object>();
        stack.push(root);
        //pathSumElements.add(root.getData());
        pathElements = root.getData() + " ";
        stack.push(pathElements);
        Integer pathSum = 0;
        
        while(!stack.isEmpty()){
            pathElements = (String) stack.pop(); 
            root = (BinaryTreeNode) stack.pop();
            
            if(root.getLeft() == null && root.getRight() == null){
                //check if path == sum
                pathSum = 0;
                //System.out.println(pathElements);
                String[] individualElements = pathElements.split(" ");
                for(String element : individualElements){
                    pathSum += Integer.parseInt(element.trim());
                }
                if(pathSum == sum){
                    pathSumElements = new ArrayList<Integer>();
                    for(String element : individualElements){
                        pathSumElements.add(Integer.parseInt(element));
                    }
                    listOfPathSum.add(pathSumElements);
                    //pathSumElements.clear();
                }
            }
            
            if(root.getLeft() != null){
                stack.push(root.getLeft());
                stack.push(pathElements + root.getLeft().getData() + " ");
            }
            
            if(root.getRight() != null){
                stack.push(root.getRight());
                stack.push(pathElements + root.getRight().getData() + " ");
            }
        }
        
        
        return listOfPathSum;
        
    }
}
