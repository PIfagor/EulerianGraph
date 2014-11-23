package lib.lection;


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lib.develop.ArrayQueue;
import lib.develop.Queue;
import lib.princeton.In;
import lib.princeton.StdOut;


public class WebCrawler {

	Queue<String> queue = new ArrayQueue<String>();
	Set<String> marked = new HashSet<String>();
	private int depth;
	
	public WebCrawler(String root, int depth){
		queue.enqueue(root);
		marked.add(root);
		this.depth=depth;
	}

	public void process() {
		while((!queue.isEmpty())&&(marked.size()<=depth)){
			String v = queue.dequeue();
			StdOut.println(v);
			In in = new In(v);
			if (!in.exists()) continue;
			String input = in.readAll();
			if (input == null) continue;
			String regexp = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(input);
			while(matcher.find()){
				String w = matcher.group();
				if (!marked.contains(w)){
					marked.add(w);
					queue.enqueue(w);
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		WebCrawler crawler = new WebCrawler("http://www.sadovnik.mobi",1000);
		crawler.process();
	}
}
