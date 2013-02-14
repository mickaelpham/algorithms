
public class UnionFind {
	
	/* Data structure for quick-find */
	private int[] id;

	/**
	 * Initialize union-find data structure with N objects (0 to N-1)
	 */
	public UnionFind(int N) {
		
		id = new int[N];
		
		// Initialize the array with no connection
		for (int i = 0; i < N; i ++) {
			id[i] = i;
		}
	}
	
	
	/**
	 * Chase parent pointers until reach root
	 * (depth of i array accesses)
	 */
	@SuppressWarnings("unused")
	private int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}
	
	
	/**
	 * Add connection between p and q
	 * (change the 1st entry index to match the 2nd one)
	 */
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		
		// Change all entries with id[p] to id[q]
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid)
				id[i] = qid;
		}
		// (at most 2N + 2 array accesses)
	}
	
	
	/**
	 * Are p and q in the same component?
	 */
	public boolean quickFind(int p, int q) {
		return id[p] == id[q];
	}
	
	
	/**
	 * Component identifier for p(0 to N-1)
	 */
	public int find(int p) {
		
		return 0;
	}
	
	
	/**
	 * Number of components
	 */
	public int count() {
		
		return 0;
	}
}
