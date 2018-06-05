package chap19;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.javafx.iio.ImageFormatDescription.Signature;

import sun.reflect.generics.repository.GenericDeclRepository;

public class MyMouseListener extends MouseAdapter {

	JTextField text1, text2, text3;
	JComboBox genderCombox;

	public MyMouseListener(JTextField text1, JTextField text2, JComboBox genderCombox) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.genderCombox = genderCombox;
		// this.text3 = text3;
	}

	public MyMouseListener(JTextField text1, JTextField text2, JTextField text3) {
		super();
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		// 마우스 클릭이벤트 발생시
		JTable table = (JTable) e.getSource();

		int row = table.getSelectedRow();

		if (row != -1) {
			System.out.println(row + 1);
			System.out.println(table.getValueAt(row, 0));
			System.out.println(table.getValueAt(row, 1));
			System.out.println(table.getValueAt(row, 2));

			text1.setText(table.getValueAt(row, 0).toString());
			text2.setText(table.getValueAt(row, 1).toString());
			String genderStr = (table.getValueAt(row, 2).toString());

			if (genderStr.equals("남")) {
				genderCombox.setSelectedIndex(1);
			} else if (genderStr.equals("여")) {
				genderCombox.setSelectedIndex(2);

			} else {
				genderCombox.setSelectedIndex(0);
			}

			// int selectedIndex = genderCombox.getSelectedIndex();
			// FObject item = genderCombox.getSelectedItem();

			// System.out.println("selected Index: " + selectedIndex);
			// System.out.println("item: "+toString());

			// text3.setText(table.getValueAt(row, 2).toString());
			// text1.setText((String) table.getValueAt(row, 0));
		}
	}
}
