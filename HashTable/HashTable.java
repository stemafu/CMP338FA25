import java.util.Iterator;

public class HashTable <E extends KeyedElementInterface<K>, K>
implements HashTableInterface<E, K> {
	
	/* The base data structure for the hash table is an array.
	This means we need an array that we will use for our
	hash table
	*/
	private Bucket [] buckets;
	
	/* We also need to have a variable that will keep
	track of the amount items currently stored in the 
	hash table
	*/
	private int numElements = 0;
	
	private int probes = 0;
	
	public HashTable() {
		this.numElements = 0;
		this.buckets = new Bucket[13];
		for(int i = 0; i < buckets.length; i++) {
			this.buckets[i] = new Bucket();
			this.buckets[i].element = null;
			this.buckets[i].isEmptyFromTheBeginning = true;
		}
		
	}
	

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.numElements == 0;
	}

	@Override
	public HashTableInterface<E, K> copy() throws InstantiationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E insert(E element) {
		
		K key = element.getKey();
		
		int hashCode = key.hashCode() % buckets.length;
		
		// collisions (linear probing)
		
		int numProbes = 1;
		
		/*
		 * When the hasCode leads to a collision, we need
		 * to probe to find the next location to insert.
		 */
		while(this.buckets[hashCode].element != null) {
			
			// If they key already exists in the hash table, we just replace.
			// The insert algorithm first searches for the key to insert. 
			// If found, the corresponding value is updated.
			if( ((E)this.buckets[hashCode].element).getKey().equals(element.getKey())){
				E replacedElement = (E)this.buckets[hashCode].element;
				this.buckets[hashCode].element = element;
				return replacedElement;
			}
			
			hashCode = probes(hashCode, numProbes);
			numProbes++;
		}
		
		this.buckets[hashCode].element = element;
		this.buckets[hashCode].isEmptyFromTheBeginning = false;
		this.numElements++;
		
		return null;
	}
	
	private int probes(int hashcode, int i) {
		// linear probing
		this.probes++;
		return (hashcode + 1) % this.buckets.length;
		
		// quadratic probing
		//return (hashcode + i + i * i) % this.buckets.length;
	}

	@Override
	public E get(K key) {
		
		int hashCode = key.hashCode() % this.buckets.length;
		int numProbes = 1;
		
		while(! ((E)this.buckets[hashCode].element).getKey().equals(key) ) {
			hashCode = probes(hashCode, numProbes);
			numProbes++;
		}
		
		return (E)this.buckets[hashCode].element;
	}

	@Override
	public E remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		this.numElements = 0;
		this.buckets = new Bucket[13];
		for(int i = 0; i < buckets.length; i++) {
			this.buckets[i] = new Bucket();
			this.buckets[i].element = null;
			this.buckets[i].isEmptyFromTheBeginning = true;
		}		
		
	}

	@Override
	public int getSizeOfLargestBucket() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageBucketSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] getBuckets() {
		// TODO Auto-generated method stub
		return null;
	}

}


class Bucket{
	/* The following variable will be used to keep a value
	at a bucket
	*/
	public Object element; 
	
	/*
	 * This value will true if this bucket has not been 
	 * used at all.
	 */
	public boolean isEmptyFromTheBeginning;
}
