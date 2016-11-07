import java.util.Arrays;

public class Vector {
	private double[] coords;
	
	public Vector(double[] abc){
		coords = abc.clone();
	}
	
	public double[] getCoords(){
		return coords;
	}
	
	public String toString(){
		return String.format("Vector %1$s, length: %2$f", Arrays.toString(coords), this.length());
	}
	
	public Vector add(Vector v){
		double[] vcoords = v.getCoords();
		if (vcoords.length != coords.length)
			return null;
		double[] ucoords = new double[coords.length];
		for (int i=0;i<vcoords.length; i++)
			ucoords[i]= coords[i]+vcoords[i];
		return new Vector(ucoords);
	}
	
	public Vector sub(Vector v){
		return v.add(this.mult(-1));
	}
	
	public Vector mult(double a){
		double[] ucoords = new double[coords.length];
		for (int i=0;i<coords.length; i++)
			ucoords[i]= coords[i]*a;
		return new Vector(ucoords);
	}
	
	public double scalar(Vector v){
		double[] vcoords = v.getCoords();
		if (vcoords.length != coords.length)
			return -1;
		double value = 0;
		for (int i=0;i<vcoords.length; i++)
			value+= coords[i]*vcoords[i];
		return value;
	}
	
	public double length(){
		double length = 0;
		for (int i=0;i<coords.length; i++)
			length+= coords[i] * coords[i];
		return Math.sqrt(length);
	}
	
	public Vector cross(Vector v){
		double[] vcoords = v.getCoords();
		if (vcoords.length != coords.length || coords.length != 3)
			return null;
		double[] ucoords = new double[coords.length];
		for (int i=0;i<coords.length; i++)
			ucoords[i]= coords[(i+1)%3]*vcoords[(i+2)%3] - coords[(i+2)%3]*vcoords[(i+1)%3];
		return new Vector(ucoords);
	}
}
