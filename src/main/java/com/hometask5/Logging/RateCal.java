package com.hometask5.Logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.*;
import java.awt.TextField;
import java.awt.event.*;
public class RateCal implements ActionListener
{
	private static final Logger LOGGER =LogManager.getLogger(RateCal.class);
	JFrame f;
	JLabel lableforSArea,lableforHouseType,lableforCost;
	TextField textforArea,textforHouseType;
	JButton StandardMatButton,aboveStandardMatButton,highStandardMatButton,fullyAutomatedMatButton,clearButton,exitButton;
	RateCal()
	{
		f=new JFrame();
		lableforSArea=new JLabel("Enter Total Area Of House In Square Feet");
		lableforHouseType=new JLabel("Select House Type");
		lableforCost=new JLabel("Total Cost");
		textforArea=new TextField(10);
		textforHouseType=new TextField(10);
		StandardMatButton=new JButton("Standard Material");
		aboveStandardMatButton=new JButton("Above Standard Material");
		highStandardMatButton=new JButton("High Standard Material");
		fullyAutomatedMatButton=new JButton("Fully Automated");
		clearButton=new JButton("Clear");
		exitButton=new JButton("EXIT");
		f.add(lableforSArea);
		f.add(textforArea);
		f.add(lableforHouseType);
		f.add(StandardMatButton);
		f.add(aboveStandardMatButton);
		f.add(highStandardMatButton);
		f.add(fullyAutomatedMatButton);
		f.add(lableforCost);
		f.add(textforHouseType);
		f.add(clearButton);
		f.add(exitButton);
		lableforSArea.setBounds(65,40,300,20);
		textforArea.setBounds(120,80,100,20);
		lableforHouseType.setBounds(120,120,200,20);
		StandardMatButton.setBounds(80,160,200,20);
		aboveStandardMatButton.setBounds(80,200,200,20);
		highStandardMatButton.setBounds(80,240,200,20);
		fullyAutomatedMatButton.setBounds(80,280,200,20);
		lableforCost.setBounds(140,320,200,20);
		textforHouseType.setBounds(120,360,100,20);
		clearButton.setBounds(80,400,70,20);
		exitButton.setBounds(180,400,70,20);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(380,500);
		StandardMatButton.addActionListener(this);
		aboveStandardMatButton.addActionListener(this);
		highStandardMatButton.addActionListener(this);
		fullyAutomatedMatButton.addActionListener(this);
		clearButton.addActionListener(this);
		exitButton.addActionListener(this);
		LOGGER.info("Frame Opened");
	}
	public void actionPerformed(ActionEvent arg0) {
		String a=textforArea.getText();
		double Area;
		if(arg0.getSource()==exitButton)
		{
			LOGGER.info("Exited Successfully");
			System.exit(0);
		}
		else if(arg0.getSource()==clearButton)
		{
			textforArea.setText("");
			textforHouseType.setText("");
			LOGGER.info("Data Cleared");
		}
		else if(a.equals("")==false)
		{
			Area=Double.parseDouble(textforArea.getText());
			if(arg0.getSource()==StandardMatButton)
			{
				Area=1200*Area;
				JOptionPane.showMessageDialog(null,"1200 INR for Square Feet");
				textforHouseType.setText(String.valueOf(Area));
				textforArea.setText("");
				LOGGER.info("Calculated for Standard Material");
			}
			else if(arg0.getSource()==aboveStandardMatButton)
			{
				Area=1500*Area;
				JOptionPane.showMessageDialog(null,"1500 INR for Square Feet");
				textforHouseType.setText(String.valueOf(Area));
				textforArea.setText("");
				LOGGER.info("Calculated for Above Standard Material");
			}
			else if(arg0.getSource()==highStandardMatButton)
			{
				Area=1800*Area;
				JOptionPane.showMessageDialog(null,"1800 INR for Square Feet");
				textforHouseType.setText(String.valueOf(Area));
				textforArea.setText("");
				LOGGER.info("Calculated for High Standard Material");
			}
			else if(arg0.getSource()==fullyAutomatedMatButton)
			{
				Area=2500*Area;
				JOptionPane.showMessageDialog(null,"2500 INR for Square Feet");
				textforHouseType.setText(String.valueOf(Area));
				textforArea.setText("");
				LOGGER.info("Calculated for Fully Automated");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Enter Correct Numbers");
			LOGGER.warn("Numbers not Enterd");
		}
	}
	public static void main(String p[])
	{
		new RateCal();
	}

}
