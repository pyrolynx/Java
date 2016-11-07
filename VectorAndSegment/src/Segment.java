
public final class Segment {
	private Vector Start;
	private Vector End;
	
	public Segment(Vector start, Vector end)
	{
		Start = start;
		End = end;				
	}
	
	public Vector getStart()
	{
		return Start;
	}
	
	public Vector getEnd()
	{
		return End;
	}
	
	public double len()
	{
		return End.sub(Start).len();
	}
	
	public double distanseTo(Vector v)
	{
//		if ()
		double ab = Start.sub(End).len();
		double bc = End.sub(v).len();
		double ac = Start.sub(v).len();
		double cosBAC = (ac*ac + ab*ab - bc*bc) / (2 * ab*ac);
		double s = ac*Math.sqrt(1 - cosBAC*cosBAC);
		return s;
	}
	
}
