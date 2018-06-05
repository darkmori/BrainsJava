package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc {
	public static void main(String[] args) {
		JFrame frame = new JFrame("덧셈 프로그램");
		frame.setPreferredSize(new Dimension(250, 100));
		frame.setLocation(500, 400);

		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(5);
		JTextField result = new JTextField(5);
		JButton submitBtn = new JButton("확인");
		JButton cancleBtn = new JButton("취소");

		submitBtn.addActionListener(new Calc_Listener(text1, text2, result));
		cancleBtn.addActionListener(new Calc_Listener(text1, text2, result));

		panel.add(text1);
		panel.add(new JLabel("+"));
		panel.add(text2);
		panel.add(new JLabel("="));
		panel.add(result);

		panel.add(submitBtn);
		panel.add(cancleBtn);

		contentPane.add(panel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
