package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class corresponds to the Sequential strategy to count frequencies in an
 * array list.
 * @author Fernando J. Bermudez && William A. Martínez Martínez
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SequentialFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public SequentialFD() {
		super("Sequential");
	}
	/**
	 * Method that counts the frequency of a dataSet with a regular ArrayList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * one by one without any sorting or re-arrangement of the elements
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		// Every element inside dataSet will be stored here with its corresponding frequency
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		for (E e : dataSet) { // Going through every element inside dataSet
			boolean found = false; // Will determine whether there's already an element in results or not
			for (int i = 0; i < results.size() && !found; i++) {
				Map.Entry<E, Integer> entry = results.get(i);
				if (entry.getKey().equals(e)) { // Checking if there's already a key inside results that is equal to the current element
					entry.setValue(entry.getValue()+1); // If the current element exists in results, its frequency will be incremented by one
					found = true; // The current element has been found inside results
				}
			}
			if (!found) {
				// If we haven't found the current element inside results, a new key will be created in results with frequency 1 
	            Map.Entry<E,Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(e,1); 
	            results.add(entry); // Add the new entry to results
			}
		}
		return results; // The array list now contains elements as keys and the frequency in which they can be found in dataSet
	}

}
