package StrategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class implements the Map/Hash table strategy to count frequencies in an ArrayList.
 * @author Fernando J. Bermudez && William A. Martínez Martínez
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {
		super("Map");
	}
	
	/**
	 * Method that counts the frequency of a dataSet with a Hash table
	 * It uses a Hash table to count the frequency of each elements inside dataSet instead of Map.Entry
	 * like the previous strategies in this experiment
	 * 
	 * @param dataSet	The Data Set to count and distribute the frequency of its elements
	 * @return results 	The resulting entries of each elements inside dataSet
	 */
	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		// The elements in dataSet will be initially stored here as keys and values
		Hashtable<E, Integer> hashTable = new Hashtable<>(dataSet.size());
		
		// Every key and value inside the hash table will be stored here as entries
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		/*
		 * Adding the elements in dataSet to the hash table
		 */
		for (E e : dataSet) {
			if (hashTable.containsKey(e)) {
				// If an element is found inside the hash table as a key, its value will be incremented by 1
				hashTable.put(e, hashTable.get(e)+1);
			} else {
				// If the element is not found, it will be added as a key with value 1
				hashTable.put(e, 1);
			}
		}
		/*
		 * Transferring the keys and values inside the hash table to results as entries
		 */
		for (Map.Entry<E, Integer> entry : hashTable.entrySet()) {
			results.add(entry);
		}
		return results; // The array list now contains elements as keys and the frequency in which they can be found in dataSet
	}

}
