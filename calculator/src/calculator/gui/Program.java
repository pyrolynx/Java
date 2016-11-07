package calculator.gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.rational.RationalValueParser;
import calculator.datatypes.real.RealValueParser;
import javax.swing.*;

public class Program extends JFrame {
	private JPanel panel;
	private JTextField expression;
	private JLabel result;
	private JButton calc;
	private JComboBox<Object> types;
	
	public Program()
	{
		super("Calculator");
		setBounds(100, 100, 300, 160);
		setMinimumSize(new Dimension(300, 160));
		drawForm();
	}
	
	private void drawForm(){
		this.panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(new JLabel("Enter number type:"));
		AbstractValueParser[] valueParsers = new AbstractValueParser[] { new IntegerValueParser(),
				new RealValueParser(), new RationalValueParser(), new ComplexValueParser() };
		HashMap<String, AbstractValueParser> parsers = new HashMap<String, AbstractValueParser>();
		for (AbstractValueParser e: valueParsers)
			parsers.put(e.getDatatypeName(), e);
		types = new JComboBox<>(parsers.keySet().toArray());
		panel.add(types);
		expression = new JTextField();
		panel.add(expression);
		result = new JLabel("Result: ");
		panel.add(result);
		calc = new JButton("Calc");
		calc.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e){
				Calculator handler = new Calculator(parsers.get(types.getSelectedItem()));
				String[] args = expression.getText().split(" ");
				if (args.length != 3)
					return;
				String first = args[0];
				String operation = args[1];
				String second = args[2];
				try
				{
				result.setText("Result: " + handler.calculate(first, operation, second).toString());
				}
				catch (OperationNotSupportedException|ParseValueException|DivisionByZeroException exception)
				{
					return;
				}
			}
		});
		panel.add(calc);
		add(panel);
	}
	
	
	public static void main(String[] args)
	{
		new Program().setVisible(true);
	}
}
