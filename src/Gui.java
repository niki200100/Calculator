import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Gui implements ActionListener, KeyListener{

	private Control control;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel operator, equal, result;
	private JTextField numberOne, numberTwo;
	private JButton addition, substraction, multiply, divide, c;
	
	private Font font, fontB;
	
	private int actualOperator= 0;	//0=+ 1=- 2=* 3=/
	private double first, second;
	private double resultD;
	
	public Gui(Control control) {
		
		this.control= control;
		font= new Font("Arial",Font.BOLD, 30);
		fontB= new Font("Arial",Font.PLAIN, 25);
		createGui();
	}
	public void createGui(){
		
		frame= new JFrame("Calculator");
		frame.setSize(590, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel= new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(true);
		frame.add(panel);
		
		numberOne= new JTextField("0");
		numberOne.setBounds(20, 20, 150, 50);
		numberOne.setVisible(true);
		numberOne.setFont(font);
		numberOne.setHorizontalAlignment(SwingConstants.CENTER);
		numberOne.addKeyListener(this);
		panel.add(numberOne);
		
		operator= new JLabel("+");
		operator.setBounds(180, 30, 25, 25);
		operator.setVisible(true);
		operator.setFont(font);
		operator.setHorizontalAlignment(SwingConstants.CENTER);
		operator.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(operator);
		
		numberTwo= new JTextField("0");
		numberTwo.setBounds(215, 20, 150, 50);
		numberTwo.setVisible(true);
		numberTwo.setFont(font);
		numberTwo.setHorizontalAlignment(SwingConstants.CENTER);
		numberTwo.addKeyListener(this);
		panel.add(numberTwo);
		
		equal= new JLabel("=");
		equal.setBounds(380,32,25,25);
		equal.setVisible(true);
		equal.setFont(font);
		panel.add(equal);
		
		result= new JLabel("0.0");
		result.setBounds(415, 20, 150, 50);
		result.setVisible(true);
		result.setFont(font);
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBorder(new  EtchedBorder());
		panel.add(result);
		
		addition= new JButton("+");
		addition.setBounds(65,100,50,50);
		addition.setVisible(true);
		addition.setBackground(Color.WHITE);
		addition.setFocusable(false);
		addition.setFont(fontB);
		addition.addActionListener(this);
		panel.add(addition);
		
		substraction= new JButton("-");
		substraction.setBounds(165,100,50,50);
		substraction.setVisible(true);
		substraction.setBackground(Color.WHITE);
		substraction.setFocusable(false);
		substraction.setFont(fontB);
		substraction.addActionListener(this);
		panel.add(substraction);
		
		multiply= new JButton("*");
		multiply.setBounds(265,100,50,50);
		multiply.setVisible(true);
		multiply.setBackground(Color.WHITE);
		multiply.setFocusable(false);
		multiply.setFont(fontB);
		multiply.addActionListener(this);
		panel.add(multiply);
		
		divide= new JButton("/");
		divide.setBounds(365,100,50,50);
		divide.setVisible(true);
		divide.setBackground(Color.WHITE);
		divide.setFocusable(false);
		divide.setFont(fontB);
		divide.addActionListener(this);
		panel.add(divide);
		
		c= new JButton("c");
		c.setBounds(465,100,50,50);
		c.setVisible(true);
		c.setBackground(Color.WHITE);
		c.setFocusable(false);
		c.setFont(fontB);
		c.addActionListener(this);
		panel.add(c);
		
		panel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addition){
			actualOperator= 0;
			operator.setText("+");
			addition();
		}else
			if(e.getSource()==substraction){
				actualOperator=1;
				operator.setText("-");
				substraction();
			}else
				if(e.getSource()==multiply){
					actualOperator=2;
					operator.setText("*");
					multiply();
				}else
					if(e.getSource()==divide){
						actualOperator=3;
						operator.setText("/");
						divide();
					}else
						if(e.getSource()==c){
							numberOne.setText("0");
							numberTwo.setText("0");
							operator.setText("+");
							result.setText("0.0");
							first=0;
							second=0;
							actualOperator=0;
							resultD=0;;
						}
		if(e.getSource()!=c)
			result.setText(Double.toString(resultD));
		operator.repaint();
		result.repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		first= (double) Double.parseDouble(numberOne.getText());
		second= (double) Double.parseDouble(numberTwo.getText());
		
		switch(actualOperator){
		case 0: addition();break;
		case 1: substraction();break;
		case 2: multiply();break;
		case 3: divide();break;
		}
		
		result.setText(Double.toString(resultD));
		
		result.repaint();
	}
	
	public void addition(){
		resultD= control.addition(first, second);
	}
	public void substraction(){
		resultD= control.Subtract(first, second);
	}
	public void multiply(){
		resultD= control.Multiply(first, second);
	}
	public void divide(){
		resultD= control.Divide(first, second);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}