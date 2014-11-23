package lib.lection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import lib.princeton.In;
import lib.princeton.StdOut;

public class DepthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	private int count;
	private boolean isHamiltonian;

	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
		isHamiltonian = false;

	}

	/**
	 * пошук в глибину
	 * 
	 * @param G
	 *            - граф
	 * @param v
	 *            - dfs з вершини v
	 */
	private void dfs(Graph G, int v) {
		count++;
		// System.out.println(count);
		marked[v] = true;
		for (int w : G.adj(v)) {
			System.out.println(w);
			if (!marked[w]) {
				edgeTo[w] = v;
				System.out.println(":" + w);
				if (count == G.V()) {
					for (int r : G.adj(w)) {
						if (r == s)
							System.out.println("CCCCCCCCCCCCCCccc");

						isHamiltonian = true;
					}

				}
				dfs(G, w);

			}
		}
	}

	public boolean isConnected() {
		for (int i = 0; i < marked.length; i++)
			if (marked[i] == false)
				return false;
		return true;
	}

	/**
	 * Чи присутній шлях з v в s, що задана конструктором
	 * 
	 * @param v
	 *            - вершина до чкої шукаємо шлях
	 * @return true якщо є шлях, false якщо немає
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * повертає шлях між s та v; null якщо шляху немає
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();

		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	private static final String testFile = "5V6E.txt";

	public static void main(String[] args) {
		In in = new In(testFile);
		Graph G = new Graph(in);
		StdOut.println(G);
		int s = Integer.parseInt("0");
		DepthFirstPaths dfs = new DepthFirstPaths(G, s);
		
		System.out.println(dfs.isConnected());
		
		
		
		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:  ", s, v);
				for (int x : dfs.pathTo(v)) {
					if (x == s)
						StdOut.print(" " + x);
					else
						StdOut.print("-" + x);
				}
				StdOut.println();
			} else {
				StdOut.printf("%d to %d:  not connected\n", s, v);
			}
		}
	}
}
