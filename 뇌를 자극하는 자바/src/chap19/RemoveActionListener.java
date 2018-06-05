package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class RemoveActionListener implements ActionListener {

	JDBC_Manager jdbc_Manager;
	JTable table;

	public RemoveActionListener(JDBC_Manager jdbc_Manager, JTable table) {
		super();
		this.jdbc_Manager = jdbc_Manager;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int confirm = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);

		System.out.println("confirm: " + confirm);

		if (confirm == 1)
			return;

		int row = table.getSelectedRow();
		if (row == -1)
			return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// 삭제될 이름
		Object name = table.getValueAt(row, 0);
		String deleteName = name.toString();
		System.out.println(deleteName);
		///////////////////////////////////////

		model.removeRow(row); // 선택된 행을 삭제

		// DB table record(Data) 삭제
		try {
			jdbc_Manager.deleteTable(deleteName);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
