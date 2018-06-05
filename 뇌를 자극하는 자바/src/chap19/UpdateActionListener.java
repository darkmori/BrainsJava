package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class UpdateActionListener implements ActionListener {

	JDBC_Manager jdbc_Manager;
	JTable table;
	JTextField text1, text2;

	public UpdateActionListener(JDBC_Manager jdbc_Manager, JTable table, JTextField text1, JTextField text2) {
		super();
		this.jdbc_Manager = jdbc_Manager;
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			String name = text1.getText();
			String age = text2.getText();
			jdbc_Manager.updateTable(name, age);

			SelectActionListener selectActionListener = new SelectActionListener(jdbc_Manager, table);
			selectActionListener.actionPerformed(e);

			JOptionPane.showMessageDialog(null, "수정되었습니다.", "수정메시지", JOptionPane.INFORMATION_MESSAGE);

			// jdbc_Manager.updateTable(name, age);

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
	}

}
