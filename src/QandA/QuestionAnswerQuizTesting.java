package QandA;

import java.awt.*;
import java.awt.*;


import javax.swing.*;

public class QuestionAnswerQuizTesting {
	public static void main(String []args) {
		JFrame frame = new JFrame("Question And Answer");
		frame.add(new QuestionAndAnswer());
	
		frame.setVisible(true);
		frame.setSize(700, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(230,230,230));
		frame.setFont(new Font("Agency FB",Font.BOLD,30));
		
	}
}