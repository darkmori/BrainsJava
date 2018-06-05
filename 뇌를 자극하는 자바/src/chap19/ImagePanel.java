package chap19;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	Image image;
	Toolkit toolkit = getToolkit();

	void setPath(String path) {
		image = toolkit.getImage(path);
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		if (image != null)
			g.drawImage(image, 0, 0, this);
	}

}
