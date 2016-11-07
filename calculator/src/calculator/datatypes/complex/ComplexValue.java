package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class ComplexValue extends AbstractValue {
	
	private final double real;
	private final double imaginary;

	public ComplexValue(double r, double i)
	{
		this.real = r;
		this.imaginary = i;
	}
	
	public AbstractValue add(AbstractValue operand){
		
		return new ComplexValue(this.real + ((ComplexValue) operand).real, 
				this.imaginary + ((ComplexValue) operand).imaginary);
	}

	public AbstractValue sub(AbstractValue operand){
		return new ComplexValue(this.real - ((ComplexValue) operand).real, 
				this.imaginary - ((ComplexValue) operand).imaginary);
	}

	public AbstractValue mul(AbstractValue operand){
		return new ComplexValue(this.real * ((ComplexValue) operand).real -
				this.imaginary * ((ComplexValue) operand).imaginary, 
				this.real * ((ComplexValue) operand).imaginary +
				this.imaginary * ((ComplexValue) operand).real);
	}

	public AbstractValue div(AbstractValue operand) throws DivisionByZeroException{
		if (((ComplexValue) operand).real == 0 && ((ComplexValue) operand).imaginary == 0)
			throw new DivisionByZeroException();
		return new ComplexValue((this.real * ((ComplexValue) operand).real +
				this.imaginary * ((ComplexValue) operand).imaginary) /
				(Math.pow(((ComplexValue) operand).real, 2.0) + 
				Math.pow(((ComplexValue) operand).imaginary, 2.0)), 
				(this.imaginary * ((ComplexValue) operand).real -
				this.real * ((ComplexValue) operand).imaginary) /
				(Math.pow(((ComplexValue) operand).real, 2.0) + 
				Math.pow(((ComplexValue) operand).imaginary, 2.0)));
	}

	public String toString() {
		String view = String.format("%1$.2f+%2$.2fi", this.real, this.imaginary);
		return view;
	}

	public boolean equals(AbstractValue operand){
		return this.real == ((ComplexValue) operand).real && 
				this.imaginary == ((ComplexValue) operand).imaginary;
	}
}
