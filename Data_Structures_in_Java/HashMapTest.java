package datastructures;

import java.util.*;
import java.util.Map.Entry;

public class HashMapTest
{
	public static void main(String[] args)
	{
		// Create a HashMap and put stuff in it
	    Map<String, String> objMap = new HashMap<String, String>();
	    objMap.put("Name", "Suzuki");
	    objMap.put("Power", "220");
	    objMap.put("Type", "2-wheeler");
	    objMap.put("Price", "85000");
	    
	    // Get a set of the entries
	    Set<Entry<String, String>> set = objMap.entrySet();
	    
	    // Get an iterator
	    Iterator<Entry<String, String>> i = set.iterator();
	    
	    // Display Map Contents
	    System.out.println("These are all the items in the Hashmap with Keys on the left and Values on the right:");
	    while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
	    }
	    
	    System.out.println("HashMap.get('Type') returns:\n" + objMap.get("Type"));
	    System.out.println("HashMap.values() returns:\n" + objMap.values());
	}
}
