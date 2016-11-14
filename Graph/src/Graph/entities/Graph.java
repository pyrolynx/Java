package Graph.entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph<T> implements Iterable<Item<T>>{
	
	private ArrayList<Item<T>> items;
	private ArrayList<Edge<T>> edges;
	
	public Graph()
	{
		items = new ArrayList<Item<T>>();
		edges = new ArrayList<Edge<T>>();
	}
	
	public void add(Item<T> item)
	{
		if (!this.contains(item))
			this.items.add(item);
	}
	
	public void addEdge(Item<T> u, Item<T> v)
	{
		if (this.contains(u) && this.contains(v) && 
			!this.containsEdge(new Edge<T>(this, u, v)) &&
			!u.equals(v))
			edges.add(new Edge<T>(this, u, v));
	}
	
	public void deleteEdge(Edge<T> edge)
	{
		if (this.containsEdge(edge))
			edges.remove(edge);
	}
	
	public boolean isEmpty()
	{
		return items.isEmpty();
	}
	
	public ArrayList<Item<T>> getAdjacent(Item<T> v)
	{
		ArrayList<Item<T>> neighbors = new ArrayList<Item<T>>();
		for (Edge<T> e: edges)
			if (e.includes(v))
				neighbors.add(e.getOpposite(v));
		return neighbors;
		
	}
	
	public Item<T> find(T value)
	{
		for (Item<T> e: items)
			if (e.value.equals(value))
				return e;
		return null;
	}
	
	
	public boolean contains(Item<T> item)
	{
		for (Item<T> e: items)
			if (e.equals(item))
				return true;
		return false;
	}
	
	public boolean containsEdge(Edge<T> edge)
	{
		for (Edge<T> e: edges)
			if (e.equals(edge))
				return true;
		return false;
	}

	@Override
	public Iterator<Item<T>> iterator() {
		return items.iterator();
	}
}
