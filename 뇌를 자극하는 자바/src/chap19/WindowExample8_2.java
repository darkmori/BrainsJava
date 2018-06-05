
package chap19;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class WindowExample8_2 {

	public WindowExample8_2() {
		JDBC_Manager jdbc_Manager = new JDBC_Manager();

		JFrame frame = new JFrame("참가자 명단 프로그램");
		frame.setPreferredSize(new Dimension(600, 250));
		frame.setLocation(500, 400);

		Container contentPane = frame.getContentPane();
		String colNames[] = { "이름", "나이", "성별" };
		String genders[] = { "선택", "남", "여" };

		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel panel = new JPanel();

		JTextField text1 = new JTextField(6);
		JTextField text2 = new JTextField(4);
		JComboBox<String> genderCombox = new JComboBox<String>(genders);

		JButton selectBtn = new JButton("조회");
		JButton addBtn = new JButton("추가");
		JButton deleteBtn = new JButton("삭제");
		JButton updateBtn = new JButton("수정");

		panel.add(new JLabel("이름"));
		panel.add(text1);
		panel.add(new JLabel("나이"));
		panel.add(text2);
		panel.add(new JLabel("성별"));
		panel.add(genderCombox);

		panel.add(selectBtn);
		panel.add(addBtn);
		panel.add(updateBtn);
		panel.add(deleteBtn);
		contentPane.add(panel, BorderLayout.SOUTH);

		table.addMouseListener(new MyMouseListener(text1, text2, genderCombox));
		// 조회버튼 이벤트 리스너 등록
		selectBtn.addActionListener(new SelectActionListener(jdbc_Manager, table));
		addBtn.addActionListener(new AddActionListener(jdbc_Manager, table, text1, text2, genderCombox));
		updateBtn.addActionListener(new UpdateActionListener(jdbc_Manager, table, text1, text2));
		deleteBtn.addActionListener(new RemoveActionListener(jdbc_Manager, table));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		System.out.println("프로그램 시작");

		try {
			jdbc_Manager.DBConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/malldb", "root", "12345");
			System.out.println("데이터베이스에 접속했습니다.");
			frame.setTitle("참가자 명단 프로그램 -DB접속 성공");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을수 없습니다." + cnfe.getMessage());
			frame.setTitle("참가자 명단 프로그램 -DB접속 실패");
		} catch (Exception e) {
			e.printStackTrace();
			frame.setTitle("참가자 명단 프로그램 -DB접속 실패");
		}

	}

	public static void main(String[] args) {

	}

}
