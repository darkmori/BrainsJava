package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calc_Listener implements ActionListener {
	JTextField text1;
	JTextField text2;
	JTextField text3;

	Calc_Listener(JTextField text1, JTextField text2, JTextField text3) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("확인")) {
			// 계산
			String strNum1 = text1.getText();
			String strNum2 = text2.getText();

			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			int result = num1 + num2;

			System.out.println(result);

			text3.setText(String.valueOf(result));
		} else {
			//
			text1.setText("");
			text2.setText("");
			text3.setText("");

		}

	}

	public static void main(String[] args) {
		System.out.println();
	}

}
