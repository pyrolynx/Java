
public class main {
	public static void main(String[] args)
	{
		Vector v = new Vector(0, 0, 5);
		Vector w = new Vector(4, 3, 5);
		Segment s = new Segment(v, w);
		System.out.printf("Length of segment %f\n", s.len());
	}
}
