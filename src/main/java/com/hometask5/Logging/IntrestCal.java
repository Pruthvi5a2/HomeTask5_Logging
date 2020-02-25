package com.hometask5.Logging;

import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.TextField;
import java.awt.event.*;
public class IntrestCal implements ActionListener
{
	private static final Logger LOGGER =LogManager.getLogger(IntrestCal.class);
	JFrame f;
	JLabel lableforPrinAmount,lableforTimePeriod,lableforIntrest,lableforCompIntrest;
	TextField textforPrinAmount,textforTImePeriod,textforIntrest,textforSimpleIntrest,textforCompIntrest,text;
	JButton buttonforSimpleIntrest,buttonforCompIntrest,ExitButton;
	IntrestCal()
	{
			f=new JFrame();
			lableforPrinAmount=new JLabel("Principle Amount In Digits");
			lableforTimePeriod=new JLabel("Time Period In Years");
			lableforIntrest=new JLabel("Rate of Intrest In Decimals");
			lableforCompIntrest=new JLabel("No.of Times Compounded For CompIntrest");
			textforPrinAmount=new TextField(10);
			textforTImePeriod=new TextField(10);
			textforIntrest=new TextField(10);
			textforSimpleIntrest=new TextField(10);
			textforCompIntrest=new TextField(10);
			text=new TextField(10);
			buttonforSimpleIntrest=new JButton("SimpleIntrest");
			buttonforCompIntrest=new JButton("CompoundIntrest");
			ExitButton=new JButton("EXIT");
			f.add(lableforPrinAmount);
			f.add(textforPrinAmount);
			f.add(lableforTimePeriod);
			f.add(textforTImePeriod);
			f.add(lableforIntrest);
			f.add(textforIntrest);
			f.add(lableforCompIntrest);
			f.add(text);
			f.add(buttonforSimpleIntrest);
			f.add(textforSimpleIntrest);
			f.add(buttonforCompIntrest);
			f.add(textforCompIntrest);
			f.add(ExitButton);
			lableforPrinAmount.setBounds(100,60,200,20);
			textforPrinAmount.setBounds(120,100,100,30);
			lableforTimePeriod.setBounds(115,140,200,20);
			textforTImePeriod.setBounds(120,180,100,30);
			lableforIntrest.setBounds(105,220,200,20);
			textforIntrest.setBounds(120,260,100,30);
			lableforCompIntrest.setBounds(85,300,200,30);
			text.setBounds(120,340,100,30);
			buttonforSimpleIntrest.setBounds(40,380,120,30);
			textforSimpleIntrest.setBounds(180,380,100,30);
			buttonforCompIntrest.setBounds(40,420,120,30);
			textforCompIntrest.setBounds(180,420,100,30);
			ExitButton.setBounds(110,460,120,30);
			f.setLayout(null);
			f.setVisible(true);
			f.setSize(400,600);
			buttonforSimpleIntrest.addActionListener(this);
			buttonforCompIntrest.addActionListener(this);
			ExitButton.addActionListener(this);
			LOGGER.info("Frame Opened");
		}
		public void actionPerformed(ActionEvent e)
		{
			String a=textforPrinAmount.getText();
			String b=textforTImePeriod.getText();
			String c=textforIntrest.getText();
			double SimpleIntrest,CompoundIntrest,principleAmount,timePeriod,rateOfIntrest,CompoundTime;
			if(e.getSource()==ExitButton)
			{
				LOGGER.warn("Frame Closed");
				System.exit(0);
			}
			else
			{
				if(e.getSource()==buttonforSimpleIntrest)
				{
					if(a.equals("")||b.equals("")||c.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Correct Numbers");
						LOGGER.warn("Enter Correct Numbers");
					}
					else
					{
						principleAmount=Double.parseDouble(textforPrinAmount.getText());
						timePeriod=Double.parseDouble(textforTImePeriod.getText());
						rateOfIntrest=Double.parseDouble(textforIntrest.getText());
						SimpleIntrest=(principleAmount*rateOfIntrest*timePeriod)/100;
						textforSimpleIntrest.setText(String.valueOf(SimpleIntrest));
						textforPrinAmount.setText("");
						textforTImePeriod.setText("");
						textforIntrest.setText("");
						textforCompIntrest.setText("");
						LOGGER.info("Simple Intrest Calculated");
					}
				}
				else if(e.getSource()==buttonforCompIntrest)
				{
					String d=text.getText();
					if(a.equals("")||b.equals("")||c.equals("")||d.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Correct Numbers");
						LOGGER.warn("Enter Correct Numbers");
					}
					else
					{
						principleAmount=Double.parseDouble(textforPrinAmount.getText());
						timePeriod=Double.parseDouble(textforTImePeriod.getText());
						rateOfIntrest=Double.parseDouble(textforIntrest.getText());
						CompoundTime=Double.parseDouble(text.getText());
						CompoundIntrest=(principleAmount*Math.pow(1.0+rateOfIntrest/CompoundTime,CompoundTime*timePeriod))-principleAmount;
						textforCompIntrest.setText(String.valueOf(CompoundIntrest));
						textforPrinAmount.setText("");
						textforTImePeriod.setText("");
						textforIntrest.setText("");
						text.setText("");
						textforSimpleIntrest.setText("");
						LOGGER.info("Compound Intrest Calculated");
					}
				}
			}
		}
		public static void main(String p[])
		{
			new IntrestCal();
		}
}

