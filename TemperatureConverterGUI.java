/**
 * Description: Java GUI Application, that will do 
 *				temperature conversions between 
 * 				Celcius, Fahrenheit and Kelvin temperature scales.
 * 
 * @author Priyanka Narasimha Murthy
 */
package week3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

public class TemperatureConverterGUI extends JFrame  {


	private static final long serialVersionUID = 1L;

	JPanel inputtextPanel, selectinputPanel, selectoutputPanel, outputdisplayPanel;

	JLabel input, output;

	JRadioButton inputcelcius, outputcelcius, inputfahrenheit, outputfahrenheit, inputkelvin, outputkelvin;

	ButtonGroup inputgroup, outputgroup;

	JTextField textfield;

	JTextArea area;

	//constructor
	TemperatureConverterGUI()
	{
		super( "Temperature Converter" );
		prepareGUI();
	}
	
	private void prepareGUI(){


		input = new JLabel("Input ");//input label

		textfield = new JTextField(7);// to enter temperature needed to be converted

		inputtextPanel = new JPanel();

		inputtextPanel.add(input);
		inputtextPanel.add(textfield);

		//input radio buttons
		inputcelcius = new JRadioButton("Celcius");
		inputfahrenheit = new JRadioButton("Fahrenheit");
		inputkelvin = new JRadioButton("Kelvin");

		inputgroup = new ButtonGroup();

		//grouping radio buttons
		inputgroup.add(inputcelcius); 
		inputgroup.add(inputfahrenheit);
		inputgroup.add(inputkelvin);

		selectinputPanel = new JPanel(new GridLayout(5, 1, 8, 5));// aligning the Panel

		selectinputPanel.add(inputcelcius);
		selectinputPanel.add(Box.createVerticalStrut(20));//to create invisible space in-between
		selectinputPanel.add(inputfahrenheit);
		selectinputPanel.add(Box.createVerticalStrut(20));
		selectinputPanel.add(inputkelvin);


		TitledBorder border = new TitledBorder("Input Scale");//setting the border with title
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitlePosition(TitledBorder.TOP);

		selectinputPanel.setBorder(border);

		//output radio buttons
		outputcelcius = new JRadioButton("Celcius");
		outputfahrenheit = new JRadioButton("Fahrenheit");
		outputkelvin = new JRadioButton("Kelvin");

		outputgroup = new ButtonGroup();

		//grouping output buttons
		outputgroup.add(outputcelcius);
		outputgroup.add(outputfahrenheit);
		outputgroup.add(outputkelvin);

		selectoutputPanel = new JPanel(new GridLayout(5, 1, 8, 5));// aligning the Panel

		selectoutputPanel.add(outputcelcius);
		selectoutputPanel.add(Box.createVerticalStrut(20));
		selectoutputPanel.add(outputfahrenheit);
		selectoutputPanel.add(Box.createVerticalStrut(20));
		selectoutputPanel.add(outputkelvin);

		TitledBorder border2 = new TitledBorder("Output Scale");//setting the border with title
		border2.setTitleJustification(TitledBorder.CENTER);
		border2.setTitlePosition(TitledBorder.TOP);

		selectoutputPanel.setBorder(border2);

		output = new JLabel("Output ");
		area = new JTextArea(1,7);// to display converted temperature
		area.setEditable(false);

		outputdisplayPanel = new JPanel();

		outputdisplayPanel.add(output);
		outputdisplayPanel.add(area);


		Container container = getContentPane();

		//adding all the panels to the container
		container.add(inputtextPanel, BorderLayout.NORTH);
		container.add(selectinputPanel, BorderLayout.WEST);
		container.add(selectoutputPanel, BorderLayout.EAST);
		container.add(outputdisplayPanel, BorderLayout.SOUTH);		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 280);
		setVisible(true);

		//adding listener for text input
		textfield.addActionListener(new TextFieldHandler());	

		//adding listener for button action
		inputcelcius.addActionListener(new RadioButtonHandler()); 
		inputfahrenheit.addActionListener(new RadioButtonHandler()); 
		inputkelvin.addActionListener(new RadioButtonHandler()); 
		outputcelcius.addActionListener(new RadioButtonHandler()); 
		outputfahrenheit.addActionListener(new RadioButtonHandler()); 
		outputkelvin.addActionListener(new RadioButtonHandler()); 
	}

	// Declaring the inner class for handling events from the input text field
	private class TextFieldHandler implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			String s = textfield.getText();
			if (s.length() == 0)
			{
				area.setText("No Input");
			}else{
				RadioButtonHandler a = new RadioButtonHandler();
				a.performConversion(s);
			}
		}

	}

	//Declaring the inner class for handling events from all the radio buttons
	private class RadioButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{

			String s = textfield.getText();
			if (s.length() == 0)
			{
				area.setText("No Input");
			}

			if (s.length() > 0) {
				performConversion(s);
			}

		}

		//supporting method to perform conversions
		public void performConversion(String s) {

			double temperature = Double.parseDouble(s);

			//celcius to celcius, fahrenheit,kelvin conversions

			if (inputcelcius.isSelected() && outputcelcius.isSelected())
			{
				area.setText(TemperatureConversionFormulae.CelciustoCelcius(temperature) + "\u00B0C");
			}
			else if (inputcelcius.isSelected() && outputfahrenheit.isSelected())
			{
				area.setText(TemperatureConversionFormulae.CelciustoFahrenheit(temperature) + "\u00B0F");
			}
			else if (inputcelcius.isSelected() && outputkelvin.isSelected())
			{
				area.setText(TemperatureConversionFormulae.CelciustoKelvin(temperature) + "\u00B0K");
			}

			//fahrenheit to celcius, fahrenheit, kelvin conversions

			if (inputfahrenheit.isSelected() &&  outputcelcius.isSelected())
			{
				area.setText(TemperatureConversionFormulae.FahrenheittoCelcius(temperature) + "\u00B0C");
			}
			else if (inputfahrenheit.isSelected() && outputfahrenheit.isSelected())
			{
				area.setText(TemperatureConversionFormulae.FahrenheittoFahrenheit(temperature) + "\u00B0F");
			}
			else if (inputfahrenheit.isSelected() && outputkelvin.isSelected())
			{
				area.setText(TemperatureConversionFormulae.FahrenheittoKelvin(temperature) + "\u00B0K");
			}

			//kelvin to celcius, fahrenheit, kelvin conversions

			if (inputkelvin.isSelected() && outputcelcius.isSelected())
			{
				area.setText(TemperatureConversionFormulae.KelvintoCelcius(temperature) + "\u00B0C");
			}
			else if (inputkelvin.isSelected() && outputfahrenheit.isSelected())
			{
				area.setText(TemperatureConversionFormulae.KelvintoFahrenheit(temperature) + "\u00B0F");
			}
			else if (inputkelvin.isSelected() && outputkelvin.isSelected())
			{
				area.setText(TemperatureConversionFormulae.KelvintoKelvin(temperature) + "\u00B0K");
			}

		}

	}

	//main
	public static void main(String[] args)
	{

		new TemperatureConverterGUI();

	}

}