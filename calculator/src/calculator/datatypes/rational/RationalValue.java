package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class RationalValue extends AbstractValue{
	
	private final int numerator;
	private final int denomenator;
	
	public RationalValue(int n, int d)
	{
		super();
		this.numerator = n;
		this.denomenator = d;
	}
	
	public String toString()
	{
		return Double.toString(this.numerator) + '/' + Double.toString(this.denomenator);
	}
	
	public AbstractValue add(AbstractValue operand)
	{
		RationalValue a = (RationalValue) this.simplify();
		RationalValue b = (RationalValue) ((RationalValue) operand).simplify();
		return new RationalValue(a.numerator * b.denomenator + a.denomenator*b.numerator, 
				a.denomenator*b.denomenator).simplify();
//		return new RationalValue(
//				this.numerator * ((RationalValue) operand).denomenator +
//				this.denomenator *((RationalValue) operand).numerator,
//				this.denomenator * ((RationalValue) operand).denomenator).simplify();
	}
	
	public AbstractValue sub(AbstractValue operand)
	{
		RationalValue a = (RationalValue) this.simplify();
		RationalValue b = (RationalValue) ((RationalValue) operand).simplify();
		return new RationalValue(a.numerator * b.denomenator - a.denomenator*b.numerator, 
				a.denomenator*b.denomenator).simplify();
	}
	
	public AbstractValue mul(AbstractValue operand)
	{
		RationalValue a = (RationalValue) this.simplify();
		RationalValue b = (RationalValue) ((RationalValue) operand).simplify();
		return new RationalValue(a.numerator * b.numerator, 
				a.denomenator*b.denomenator).simplify();
		
	}
	
	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException {
		RationalValue a = (RationalValue) this.simplify();
		RationalValue b = (RationalValue) ((RationalValue) operand).simplify();
		if (b.numerator == 0.0)
			throw new DivisionByZeroException();		
		return new RationalValue(a.numerator * b.denomenator,
				a.denomenator * b.numerator).simplify();
	}
	
	public boolean equals(AbstractValue operand)
	{
		return this.numerator == ((RationalValue) operand).numerator &&
				this.denomenator == ((RationalValue) operand).denomenator;
	}
	
	public AbstractValue simplify()
	{
		if (this.numerator == 0 || this.denomenator == 0)
			return new RationalValue(0, 1);
		int n = this.numerator;
		int d = this.denomenator;
		if (d < 0)
		{
				n *= -1;
				d *= -1;
		}
		for (int i = Integer.min(Math.abs(n), Math.abs(d)); i > 1; i--)
			if ((n % i == 0) && (d % i == 0))
			{
				n /= i;
				d /= i;
			}
		return new RationalValue(n, d);
	}
}
