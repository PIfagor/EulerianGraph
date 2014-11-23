package lib.lection;

import lib.develop.Bag;
import lib.develop.Storage;



public class Digraph {

	private final int V;
	private Bag<Integer>[] adj;
	
	/**
	 * ��������� ������� ������ ��������� V 
	 * ���������� ����� �������� �������� ���� Bag
	 * @param V - ������� ������
	 */
	public Digraph(int V){
		this.V=V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v=0; v<V; v++)
			adj[v] = new Bag<Integer>();
	}
	
	/**
	 * ������ ��������� ����� � v � w
	 * @param v - �������
	 * @param w - �������
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	/**
	 * @param v - ������� �����
	 * @return - ������ ������� ����� v
	 */
	public int degree(int v){
		int degree = 0;
		for (int w : adj(v))
			degree++;
		return degree;
	}
	
	/**
	 * �������� �� �������� ������� � �������� v
	 * @param v - �������
	 * @return - �������� �� ���� ������� � v ������
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public int V() {
		return V;
	}

	public Digraph reverse() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
