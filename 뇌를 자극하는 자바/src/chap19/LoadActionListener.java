package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class LoadActionListener implements ActionListener {

	JTextField text;
	ImagePanel imagePanel;

	LoadActionListener(JTextField text, ImagePanel imagePanel) {
		super();
		this.text = text;
		this.imagePanel = imagePanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		imagePanel.setPath(text.getText());
		imagePanel.repaint();
	}

}
