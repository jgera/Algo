package com.problems;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import com.util.ReadArray;

public class Problem6 extends Problem{
	public Problem6(){
	    super();
	    this.solutions.add(new Solution1());
	    this.solutions.add(new Solution2());
	}

	public String question(){
	    return "Write a function to find a given number in a 2 dimensional matrix where each row and column are sorted. (source: http://inder-gnu.blogspot.com/2008/01/find-element-in-row-and-column-sorted.html)";
	}
	
	public Map readParameters() throws Exception{
	   try{
	       Map<String, Object> options = new HashMap<String, Object>();
	       Comparable[][] matrix = ReadArray.read();
	       options.put("matrix", matrix);
	       
	       InputStreamReader isr = new InputStreamReader(System.in);
	       BufferedReader reader = new BufferedReader(isr);
	       System.out.print("\n\n Enter element to search for: ");
	       options.put("search", new Integer(reader.readLine()));
	       
	       return options;
	       
	   }catch(Exception ex){
	       System.out.println(ex);
	       System.exit(-1);
	   }	
	   return null;
	}
	
	
	public class Solution1 implements Solution{
	    public void execute(Map options){
	 	   Comparable[][] matrix = (Comparable[][]) options.get("matrix");
	 	   //TODO: SANITY CHECKs
	 	   Comparable search = (Comparable) options.get("search");
	 	   int rows = matrix.length;
	 	   int cols = matrix[0].length;
	 	   
	 	   Stack<Integer[]> stack = new Stack<Integer[]>();
	 	   
	 	   stack.add(new Integer[]{0, 0});
	 	   int counter = 0;
	 
	 	   while(stack.size() > 0){
	 	   	counter++;
	 	        Integer[] idx = stack.pop();
	 	        int row = idx[0].intValue();
	 	        int col = idx[1].intValue();
	 	        
	 	        System.out.println("Pop: " + matrix[row][col]);
	 	   	
	 	   	//search sideways
	 	   	if(row < rows-1){
	 	   		Comparable next = matrix[row+1][col];
	 	   		int match = search.compareTo(next);
	 	   		if(match==0){
	 	   		   System.out.println("i = " + (row+1) + ", j = " + col);
	 	   		   System.out.println("Counter = " + counter);
	 	   		   return;
	 	   		}
	 	   		else if(match > 0)
	 	   		   stack.push(new Integer[]{row+1, col});
	 	   	}
	 	   	
	 	   	//search downward
	 	   	if(col < cols-1){
	 	   	    Comparable next = matrix[row][col+1];
	 	   	    int match = search.compareTo(next);
	 	   	    if(match==0){
	 	   	    	System.out.println("i = " + row + ", j = " + (col+1));
	 	   	    	System.out.println("Counter = " + counter);
	 	   	    	return;
	 	   	    }else if(match > 0 )
	 	   	    	stack.push(new Integer[]{row, col+1});
	 	   	}
	 	   }	
		}
		
		
		public String describe(){
		    return "Use an approach similar to breadth/depth first search";
		}
		
		public String timeComplexity(){
		    return "O(n) -- need to confirm";
		}
		
		public String spaceComplexity(){
		    return "O(n), where n is number of elements";
		}
		
	}

	public class Solution2 implements Solution{
		public void execute(Map options){
	 	   Comparable[][] matrix = (Comparable[][]) options.get("matrix");
	 	   //TODO: SANITY CHECKs
	 	   Comparable search = (Comparable) options.get("search");
	 	   int rows = matrix.length;
	 	   int cols = matrix[0].length;
	 	   
	 	   
	 	   int counter = 0;
	 	   int row = rows-1; int col = 0;
	 	   while(row > -1 && col < cols){
	 	   	counter++;
	 	        Comparable current = matrix[row][col];
	 	   	System.out.println("Pop: " + current);
	 	   	
	 	   	int match = search.compareTo(current);
	 	   	if(match == 0){     //if match then print element index
	 	   	    System.out.println("i = " + (row+1) + ", j = " + col);
	 	   	    System.out.println("Counter = " + counter);
	 	   	    return;
	 	   	}else if(match < 0) // search smaller than current --> go up
	 	   	    row = row - 1;
	 	   	else  if(match > 0) // if search greater than current --> go side
	 	   	    col = col + 1;
	 	   }	
		}
		
		
		public String describe(){
		    return "Similar to the first solution but starts searching from last row first column. Every element on its right will be greather than this element and every element on top will be small. Also it has much simpler implementation and requires no stack";
		}
		
		public String timeComplexity(){
		    return "O(n)  where n is number of rows or columns";
		}
		
		public String spaceComplexity(){
		    return "O(1)";
		}
		
	}
	
}