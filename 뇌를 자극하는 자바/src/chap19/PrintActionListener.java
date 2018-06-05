package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class PrintActionListener implements ActionListener {

	JTable table;

	PrintActionListener(JTable table) {
		super();
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TableModel model = table.getModel();
		int rowNum = model.getRowCount();
		int colNum = model.getColumnCount();
		for (int col = 0; col < colNum; col++) {
			String colName = model.getColumnName(col);
			System.out.println(colNum + "\t");
		}

		for (int row = 0; row < rowNum; row++) {
			for (int col = 0; col < colNum; col++) {
				Object obj = model.getValueAt(row, col);
				System.out.println(obj + "\t");
			}
			System.out.println();
		}
		System.out.println("==================================");
	}

}
