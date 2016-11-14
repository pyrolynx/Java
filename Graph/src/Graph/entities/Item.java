package Graph.entities;

import Graph.entities.*;
public class Item<T> {
	
	public final T value;
	private Graph<T> parent;
	
	public Item(Graph<T> graph, T value)
	{
		this.parent = graph;
		this.value = value;
	}
	
	
	@Override
	public boolean equals(Object item)
	{
		return ((Item<T>)item).value.equals(this.value);
	}
	
}
