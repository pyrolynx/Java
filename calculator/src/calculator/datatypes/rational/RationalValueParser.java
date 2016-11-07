package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class RationalValueParser implements AbstractValueParser
{
	public AbstractValue parse(String value) throws ParseValueException {
		try {
			String[] values = value.split("/");
			int n = Integer.parseInt(values[0]);
			int d = Integer.parseInt(values[1]);
			return new RationalValue(n, d);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "рациональные числа";
	}



}
