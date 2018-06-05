package chap19;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;

public class WindowExample2 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Hello Java Programm");
		frame.setPreferredSize(new Dimension(200, 100));
		frame.setLocation(500, 400);
		// ImageIcon image = new ImageIcon("images/001.png");
		// JLabel imglabel = new JLabel(image);

		Container contentPane = frame.getContentPane();

		JTextField text = new JTextField("이름을 입력하세요");
		// JTextField text2 = new JTextField();
		// JPanel jPanel = new JPanel();
		// jPanel.add(text);
		// jPanel.add(text2);

		JButton button = new JButton("확인");
		JLabel label = new JLabel("Hello");

		contentPane.add(text, BorderLayout.CENTER);
		// contentPane.add(text2, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		// contentPane.add(imglabel, BorderLayout.NORTH);
		ActionListener listener = new ConfirmButtonActionListener(text, label);
		button.addActionListener(listener);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
