package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class implements the Ordered strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && William A. Martínez Martínez
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {
		super("Ordered");
	}

	/**
	 * Method that counts the frequency of a dataSet with a SORTED COPY of dataSet
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		// Creates a copy of dataSet
		ArrayList<E> dataSetCopy = new ArrayList<>(dataSet);
		// Sorts dataSet's copy
		Collections.sort(dataSetCopy);
		
		// Every element inside the sorted dataSet copy will be stored here with its corresponding frequency
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		for (E e : dataSetCopy) { // Going through every element inside dataSet's copy
			boolean found = false; // Will determine whether an element has been found inside results or not
			if (!results.isEmpty()) {
				/* If results contains elements, the last key will be accessed and compared to 
				 * the current element of the dataSet's copy
				 */
				Map.Entry<E, Integer> lastEntry = results.get(results.size()-1);;
				if (lastEntry.getKey().equals(e)) {
					/* If the last key is equal to the current element, the frequency of that specific key
					 * will be increased by 1
					 */
					lastEntry.setValue(lastEntry.getValue()+1);
					found = true;
				}
			}
			if (!found) {
				// If the current element is not in results, a new key will be created with a frequency of 1
				Map.Entry<E,Integer> firstEntry = new AbstractMap.SimpleEntry<E, Integer>(e,1);
	            results.add(firstEntry); // Add the new entry to results
			}
		}
		return results; // The array list now contains elements as keys and the frequency in which they can be found in dataSet
	}

}
