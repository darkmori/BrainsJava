package chap19;

import javax.swing.*;
import java.awt.event.*;

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}
}
