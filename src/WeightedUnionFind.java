/**
 * Implement the Union Find algorithm with a weighted improvement while
 * building the tree (after union)
 * 
 * (c) Princeton University
 * http://algs4.cs.princeton.edu
 *
 */
public class WeightedUnionFind {
	
	public int[] id;		// id[i] = parent of i
	public int[] sz;		// sz[i] = number of objects in subtree rooted at i
	public int count;		// number of components
	
	// Create an empty union find data structure with N isolated sets
	public WeightedUnionFind(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	// Return the number of disjoint sets
	public int count() {
		return count;
	}
	
	// Return component identifier for component containing p
	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}
	
	// Are objects p and q in the same set?
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	// Replace sets containing p and q with their union
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		
		if (i == j)
			return;
		
		// Make smaller root point to larger one
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		
		count--; // Decrement the number of components	
	}
	
	public static void main(String[] args) {
		WeightedUnionFind uf = new WeightedUnionFind(10);
		print_r(uf.id);
		uf.union(2, 1);
		uf.union(3, 0);
		uf.union(6, 9);
		uf.union(3, 6);
		uf.union(7, 8);
		uf.union(2, 5);
		uf.union(5, 8);
		uf.union(0, 8);
		uf.union(1, 4);
		print_r(uf.id);
	}
	
	public static void print_r(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (0 == i)
				System.out.print(array[i]);
			else
				System.out.print(", " + array[i]);
		}
		System.out.println();
	}
}
