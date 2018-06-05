package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kosea.kmove30.JDBC_Manager;

public class LoginView extends JFrame {
	private MainProcess main;
	private TestFrm testFrm;

	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;

	ResultSet rs = null;

	public static void main(String[] args) {
		// new LoginView();
	}

	public LoginView() {
		// setting
		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		setLocation(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);

		// add
		add(panel);

		// visiible
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("Pass");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);
		passText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// isLoginCheck(userText.getText(), passText.getPassword().toString());
			}
		});

		btnInit = new JButton("Reset");
		btnInit.setBounds(10, 80, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passText.setText("");
			}
		});

		btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 80, 100, 25);
		panel.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck(userText.getText(), new String(passText.getPassword()));
			}
		});
	}

	public void isLoginCheck(String id, String password) {

		JDBC_Manager jdbc_Manager = new JDBC_Manager();
		String idCheckQuery = "select id, password from member where id ='" + id + "'";

		try {
			jdbc_Manager.DBConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/malldb", "root", "12345");
			rs = jdbc_Manager.SelectTable(idCheckQuery);

			if (rs.next()) {
				System.out.println(rs.getString(1) + "---" + rs.getString(2));
				// 아이디가 존재하면 패스워드 비교

				System.out.println("아이디존재");

				if (password.equals(rs.getString("password"))) {
					System.out.println("비밀번호성공");
					// 로그인 성공
					JOptionPane.showMessageDialog(null, "LogIn Success");
					bLoginCheck = true;

					// 로그인 성공이라면 매니저창 띄우기
					if (isLogin()) {// if (bLoginCheck) {
						main.showFrameTest(); // 메인창 메소드를 이용해 창띄우기
					}
				} else {
					// 패스워드 틀림
					JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다");
				}
			} else {
				// 아이디가 없음
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		// if (userText.getText().equals("test") && new
		// String(passText.getPassword()).equals("1234")) {
		// JOptionPane.showMessageDialog(null, "LogIn Success");
		// bLoginCheck = true;
		//
		// // 로그인 성공이라면 매니져창 뛰우기
		// if (isLogin()) {
		// main.showFrameTest(); // 메인창 메소드를 이용해 창뛰우기
		// }
		// } else {
		// JOptionPane.showMessageDialog(null, "Faild");
		// }
	}

	// mainProcess와 연동
	public void setMain(MainProcess main) {
		this.main = main;
	}

	public boolean isLogin() {
		return bLoginCheck;
	}

}
