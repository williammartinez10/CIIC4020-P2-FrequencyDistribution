package StrategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import DataStructures.SortedList.*;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && William A. Martínez Martínez
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Fernando J. Bermudez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings({ "serial", "unused" })
	private static class ComparableEntry<K extends Comparable<K>, V> extends AbstractMap.SimpleEntry<K, V>
																	 implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {
			super(key, value);
		}

		@Override
		public int compareTo(Map.Entry<K, V> entry) {
			/* Entries will be compared based on their keys, which are Comparable */
			return getKey().compareTo(entry.getKey());
		}

	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {
		super("SortedList");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a SortedList
	 * It uses Map.Entry to count the frequency of each elements inside dataSet
	 * 
	 * @author William A. Martínez Martínez
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		// The elements in dataSet will be initially transfered and stored in order here
		SortedList<E> sortedDataSet = new SortedArrayList<>(dataSet.size());
		
		// Every element inside the new sorted dataSet will be stored here with its corresponding frequency
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		
		for (E e : dataSet) {
			sortedDataSet.add(e); // Adding every element in dataSet to the new sorted dataSet
		}
		for (E e : sortedDataSet.toArray()) { // Going through every element inside the sorted dataSet
			boolean found = false; // Will determine whether an element has been found inside results or not
			if (!results.isEmpty()) {
				/* If results contains elements, the last key will be accessed and compared to 
				 * the current element of the sorted dataSet
				 */
				Map.Entry<E, Integer> lastEntry = results.get(results.size()-1);
				if (lastEntry.getKey().equals(e)) {
					/* If the last key is equal to the current element, the frequency of that specific key
					 * will be increased by 1
					 */
					lastEntry.setValue(lastEntry.getValue()+1); 
					found = true; // The current element has been found inside results
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