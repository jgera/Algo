package com.questions;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problem7 extends Problem{
	public Problem7(){
		super();
		// TODO: add all possible solutions
		//this.solutions.add(new Solution1());
	}

	public String question(){
		//TODO: describe question
		return "Given a matrix with m rows and n columns, each of which are sorted, write a function to efficently sort the entire matrix";
	}
	
	public Map readParameters(PrintWriter writer, BufferedReader reader) throws Exception{
		/* 
		//TODO: read parameters from command line and return a hashmap
		// which will be passed to all solutions
		
		Map<String, String> options = new HashMap<String, String>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);

		System.out.print("Enter String: ");
		options.put("str", reader.readLine());
	
		return options;
		*/
		return null;
	}
	
	
	
	public class Solution1 implements Solution{
		public void execute(Map options, PrintWriter writer){
			//TODO: write your function over here
			return;
			
		}
		
		public String describe(){
			//TODO: descibe your solution and its limitation
			return "Initializes an empty boolean vector of length 256 (assuming ASCII) and set everything to false intially. For each character, check if corresponding index is true or not. If true then string contains duplicates. Otherwise set the corresponding index to true.";
		}
		
		public String timeComplexity(){
			//TODO: return time complexity of the solution
			return "O(N^2)";
		}
		
		public String spaceComplexity(){
			//TODO: return space complexity of the solution
			return "O(1)";
		}

		
		
	}

	
}