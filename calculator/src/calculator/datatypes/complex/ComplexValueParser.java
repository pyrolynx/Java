package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValue;;

public class ComplexValueParser implements AbstractValueParser {

	public AbstractValue parse(String value) throws ParseValueException {
		try {
			String[] values = value.split("\\+");
			double r = Double.parseDouble(values[0]);
			double i = Double.parseDouble(values[1].split("i")[0]);
			return new ComplexValue(r, i);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "комплексные числа";
	}

}
