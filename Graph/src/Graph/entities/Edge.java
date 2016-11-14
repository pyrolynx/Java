package Graph.entities;

import Graph.entities.*;

public class Edge<T> {
	
	private Graph<T> parent;
	private Item<T> u;
	private Item<T> v;
	
	
	public Edge(Graph<T> graph, Item<T> u, Item<T> v)
	{
		this.parent = graph;
		this.u = u;
		this.v = v;
	}
	
	public Item<T> getOpposite(Item<T> item)
	{
		if (!item.equals(this.u) && !item.equals(this.v))
			return null;
		if (item.equals(this.v))
			return this.u;
		else
			return this.v;
	}
	
	public boolean includes(Item<T> item)
	{
		return this.u.equals(item) || this.v.equals(item);
	}
	
	public boolean equals(Edge<T> edge)
	{
		return this.u.equals(edge.u) && this.v.equals(edge.v);
	}
}
