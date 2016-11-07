public final class Vector
{
    private double X;
    private double Y;
    private double Z;
    
    public Vector (double x, double y, double z)
    {
        X = x;
        Y = y;
        Z = z;
    }
    
    public double getX()
    {
        return X;
    }
    
    public double getY()
    {
        return Y;
    }
    
    public double getZ()
    {
        return Z;
    }
    
    public double len()
    {
        return Math.sqrt(X*X + Y*Y + Z*Z);
    }
    
    public double scalar(Vector v)
    {
        return v.getX()*X + v.getY()*Y + v.getZ()*Z;
    }
    
    public Vector multiply(double k)
    {
        return new Vector(k*X, k*Y, k*Z);
    }
    
    public Vector add(Vector v)
    {
        return new Vector(v.getX()+X, v.getY()+Y, v.getZ()+Z);
    }
    
    public Vector sub(Vector v)
    {
        return this.add(v.multiply(-1));
    }
    
    public boolean areEqual(Vector v)
    {
    	return Math.abs(X - v.getX()) < 0.0001 &&
    			Math.abs(Y - v.getY()) < 0.0001 &&
    			Math.abs(Z - v.getZ()) < 0.0001;
    }
    
    public boolean onLine(Vector v, Vector u)
    {
//    	if (v.len() == 0)
  
    	return X / v.getX() - Y / v.getY() < 0.0001 && X / v.getX() - Z / v.getZ() < 0.0001;
    }
}
 