package QandA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class QuestionAndAnswer extends JPanel implements ActionListener, ItemListener, MouseListener{
	
	public Color bgcolor;	
	private int scoreCount = 0;
	protected String scoreshow = "Your Score is ";
	static String show_scoreshow = "";
	String timeUP = "Time is Up!";
	String show_timeUP = "";
	int second = 60;

	//timer
	Timer timer = new Timer(1000, this);

	JPanel questionsPanel = new JPanel();
	JPanel settingsPanel = new JPanel();
	
	//inside questionsPanel
	JPanel q1_panel = new JPanel();
	JPanel q2_panel = new JPanel();
	JPanel q3_panel = new JPanel();
	
	//inside settingsPanel
	JPanel displayPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	
	
	//Questions123 RadioBox1234 and choices1234
	JLabel q1lb = new JLabel("1. How many legs does a spider have?");

	JRadioButton a1 = new JRadioButton("Eight");  //correct
	JRadioButton b1 = new JRadioButton("Five");
	JRadioButton c1 = new JRadioButton("Six");
	JRadioButton d1 = new JRadioButton("Nine");
	
	JLabel q2lb = new JLabel("2. Where does Santa Claus live?");
	JRadioButton a2 = new JRadioButton("The South Pole");
	JRadioButton b2 = new JRadioButton("North America");
	JRadioButton c2 = new JRadioButton("The North Pole");  //correct
	JRadioButton d2 = new JRadioButton("Antarctica");
	
	JLabel q3lb = new JLabel("3. Where is the Great Pyramid of Giza?");
	JRadioButton a3 = new JRadioButton("Sudan");
	JRadioButton b3 = new JRadioButton("Afghanistan");
	JRadioButton c3 = new JRadioButton("Iraq");
	JRadioButton d3 = new JRadioButton("Egypt");  //correct
	
	JRadioButton whitetRBut = new JRadioButton("White");
	JRadioButton blackRBut = new JRadioButton("Black");
	
	
	JButton showBt = new JButton("Show Your Score!");
	JLabel BackGSettings = new JLabel("Background Settings");
	JTextField blanktf = new JTextField(""); //nothing to do with this
	
	String displayScreen = "Welcome to my Quiz Game!";
	
	public QuestionAndAnswer() {
	
		timer.start();
		this.setLayout(new BorderLayout());
		this.add(questionsPanel, BorderLayout.NORTH);
		this.add(settingsPanel, BorderLayout.EAST);
		
		questionsPanel.setLayout(new GridLayout(3,1));
		questionsPanel.add(q1_panel);
		questionsPanel.add(q2_panel);
		questionsPanel.add(q3_panel);
		
		settingsPanel.setBorder(BorderFactory.createBevelBorder(1));
		settingsPanel.setLayout(new BorderLayout());
		settingsPanel.add(buttonsPanel, BorderLayout.WEST);
		settingsPanel.add(showBt, BorderLayout.SOUTH);
		settingsPanel.add(blanktf, BorderLayout.NORTH);
		
		blanktf.setEditable(false);
			
		buttonsPanel.setLayout(new GridLayout(5,1));
		buttonsPanel.add(BackGSettings);
		buttonsPanel.add(whitetRBut);
		buttonsPanel.add(blackRBut);
		
		whitetRBut.addItemListener(this);
		blackRBut.addItemListener(this);
		
		
		//question1
		q1_panel.setBorder(BorderFactory.createBevelBorder(1));
		q1lb.setFont(new Font("Agency FB",Font.BOLD,25));
		q1_panel.setLayout(new GridLayout(5,1));
		q1_panel.add(q1lb);
		q1_panel.add(a1);
		q1_panel.add(b1);
		q1_panel.add(c1);
		q1_panel.add(d1);
		//reg question1
		a1.addItemListener(this);
		b1.addItemListener(this);
		c1.addItemListener(this);
		d1.addItemListener(this);

		//question2
		q2_panel.setBorder(BorderFactory.createBevelBorder(1));
		q2lb.setFont(new Font("Agency FB",Font.BOLD,25));
		q2_panel.setLayout(new GridLayout(5,1));
		q2_panel.add(q2lb);
		q2_panel.add(a2);
		q2_panel.add(b2);
		q2_panel.add(c2);
		q2_panel.add(d2);
		//reg question2
		a2.addItemListener(this);
		b2.addItemListener(this);
		c2.addItemListener(this);
		d2.addItemListener(this);
		//question3
		q3_panel.setBorder(BorderFactory.createBevelBorder(1));
		q3lb.setFont(new Font("Agency FB",Font.BOLD,25));
		q3_panel.setLayout(new GridLayout(5,1));
		q3_panel.add(q3lb);
		q3_panel.add(a3);
		q3_panel.add(b3);
		q3_panel.add(c3);
		q3_panel.add(d3);
		//reg question2
		a3.addItemListener(this);
		b3.addItemListener(this);
		c3.addItemListener(this);
		d3.addItemListener(this);
		
		showBt.addActionListener(this);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(1, 110, 0));
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		g.drawString(displayScreen, 2,500); 
		g.setColor((Color) bgcolor);
		setBackground(bgcolor);
		g.setColor(Color.BLACK);                      
		g.drawRect(0, 462, 594, 218);                 
		g.setColor(new Color(1, 110, 0));             
		g.drawRoundRect(2, 475, 323, 30, 10, 10);     
		g.drawString(show_scoreshow, 10, 575);
		
		g.setColor(Color.red);
		g.drawString(""+show_timeUP, 10, 625);
		
		//timer
		g.setColor(new Color(1, 110, 0));
		g.setFont(new Font("Agency FB",Font.ITALIC,25));
		g.drawOval(514, 648, 28, 28);
		g.drawString(""+second, 517, 673);
}
	
	public void itemStateChanged(ItemEvent e) {
		//question1 only one choice is selected
		if(e.getSource() == a1 && e.getStateChange() == 1) {  //a1 is the answer
			a1.setSelected(true);
			b1.setSelected(false);
			c1.setSelected(false);
			d1.setSelected(false);
			scoreCount++;
		}
		if(e.getSource() == b1 && e.getStateChange() == 1) {
			a1.setSelected(false);
			b1.setSelected(true);
			c1.setSelected(false);
			d1.setSelected(false);
		}
		if(e.getSource() == c1 && e.getStateChange() == 1) {
			a1.setSelected(false);
			b1.setSelected(false);
			c1.setSelected(true);
			d1.setSelected(false);
		}
		if(e.getSource() == d1 && e.getStateChange() == 1) {
			a1.setSelected(false);
			b1.setSelected(false);
			c1.setSelected(false);
			d1.setSelected(true);
		}
		
		//question2 only one choice is selected
				if(e.getSource() == a2 && e.getStateChange() == 1) {
					a2.setSelected(true);
					b2.setSelected(false);
					c2.setSelected(false);
					d2.setSelected(false);
				}
				if(e.getSource() == b2 && e.getStateChange() == 1) {
					a2.setSelected(false);
					b2.setSelected(true);
					c2.setSelected(false);
					d2.setSelected(false);
				}
				if(e.getSource() == c2 && e.getStateChange() == 1) {  //c2 is the answer
					a2.setSelected(false);
					b2.setSelected(false);
					c2.setSelected(true);
					d2.setSelected(false);
					scoreCount++;
				}
				if(e.getSource() == d2 && e.getStateChange() == 1) {
					a2.setSelected(false);
					b2.setSelected(false);
					c2.setSelected(false);
					d2.setSelected(true);
				}
				
				//question3 only one choice is selected
				if(e.getSource() == a3 && e.getStateChange() == 1) {
					a3.setSelected(true);
					b3.setSelected(false);
					c3.setSelected(false);
					d3.setSelected(false);
				}
				if(e.getSource() == b3 && e.getStateChange() == 1) {
					a3.setSelected(false);
					b3.setSelected(true);
					c3.setSelected(false);
					d3.setSelected(false);
				}
				if(e.getSource() == c3 && e.getStateChange() == 1) {
					a3.setSelected(false);
					b3.setSelected(false);
					c3.setSelected(true);
					d3.setSelected(false);
				}
				if(e.getSource() == d3 && e.getStateChange() == 1) {  // d3 is the answer
					a3.setSelected(false);
					b3.setSelected(false);
					c3.setSelected(false);
					d3.setSelected(true);
					scoreCount++;
				}
		
		if(e.getSource() == whitetRBut) {
			if (whitetRBut.isSelected()) {
			bgcolor = Color.WHITE;
			blackRBut.setSelected(false);
			}
		}
		if(e.getSource() == blackRBut) {
			if (blackRBut.isSelected()) {
			bgcolor = Color.BLACK;
			whitetRBut.setSelected(false);}
		}
		repaint();
		
	}
	
	public int scoreCalculate() {
		return (int) (Math.abs(scoreCount));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == showBt){
			timer.stop();
			showBt.setEnabled(false);
			show_scoreshow = "" +scoreshow+scoreCount;
			System.out.println(Math.abs(scoreCalculate()));
		} 
		second--; //every 1000 ms or 1 second it updates this second-- by 1 second
		
		if(second == 0) {
			timer.stop();
			showBt.setEnabled(false);
			show_scoreshow = "" +scoreshow+scoreCount;
			show_timeUP = "" +timeUP;	
		}
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}