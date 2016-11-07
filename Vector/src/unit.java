import java.util.Scanner;

public class unit {
	 public static void main(String[] agrs)
	 {
//		 ShowTests();
//		 QuadTask();
		 DistanseToPoint();
	 }
	 
	 public static void ShowTests()
	 {
		 Vector a = new Vector(new double[]{-2.0, 5.0, 7.0 });
		 Vector b = new Vector(new double[]{3.0, 4.0, 0.0});
		 System.out.println("A: "+a.toString());
		 System.out.println("B: "+b.toString());
		 System.out.println(String.format("A + B = %1$s", a.add(b).toString()));
		 System.out.println(String.format("A - B = %1$s", a.sub(b).toString()));
		 System.out.println(String.format("A * %1$f = %2$s", 5.0, a.mult(5.0).toString()));
		 System.out.println(String.format("A * B = %1$f", a.scalar(b)));
		 System.out.println(String.format("A x B = %1$s", a.cross(b).toString()));
	 }
	 
	 public static void QuadTask(){
		 System.out.println("Quadtask...");
		 Scanner input = new Scanner(System.in);
		 double[][] coords = new double[3][3];
		 for (int i=0;i<3;i++)
		 {
			 String[] numbers = input.nextLine().split(" ");
			 for (int j=0;j<numbers.length;j++)
			 {
				 coords[i][j] = Double.parseDouble(numbers[j]);
			 }
		 }
		 input.close();
		 Vector a = new Vector(coords[0]);
		 Vector b = new Vector(coords[1]);
		 Vector c = new Vector(coords[2]);
		 Vector v = null;
		 
		 if (Math.abs(a.sub(b).scalar(a.sub(c))) < 0.0001 && a.sub(b).length() - a.sub(c).length() < 0.0001)
			 v = a.add(c.add(b));
		 if (Math.abs(b.sub(a).scalar(b.sub(c))) < 0.0001 && b.sub(a).length() - b.sub(c).length() < 0.0001)
			 v = b.add(a.add(c));
		 if (Math.abs(c.sub(b).scalar(c.sub(a))) < 0.0001 && c.sub(b).length() - c.sub(a).length() < 0.0001)
			 v = c.add(a.add(b));
		 if (v != null)
			 System.out.println("Fourth point is " + v.toString());
		 else
			 System.out.println("This is not quad!");
		 }
	 
	 public static void DistanseToPoint()
	 {
		 System.out.println("DistanseToPoint...");
		 Scanner input = new Scanner(System.in);
		 double[][] coords = new double[3][3];
		 for (int i=0;i<3;i++)
		 {
			 String[] numbers = input.nextLine().split(" ");
			 for (int j=0;j<numbers.length;j++)
			 {
				 coords[i][j] = Double.parseDouble(numbers[j]);
			 }
		 }
		 input.close();
		 Vector a = new Vector(coords[0]);
		 Vector b = new Vector(coords[1]);
		 Vector c = new Vector(coords[2]);
		 double ab = a.sub(b).length();
		 double bc = b.sub(c).length();
		 double ac = a.sub(c).length();
		 double cosBAC = (ac*ac + ab*ab - bc*bc) / (2 * ab*ac);
		 double s = ac*Math.sqrt(1 - cosBAC*cosBAC);
		 System.out.println("Distanse to line AB: " + s);
		 
	 }
}
