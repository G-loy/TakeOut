package cn.edu.zucc.take_out.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.zucc.edu.take_out.ui
 * @date:2020年7月4日
 */
public class FrmRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegister frame = new FrmRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("用户注册");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(160, 6, 96, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("手机号");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 42, 96, 38);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(52, 92, 83, 33);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("确认密码");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(52, 153, 96, 33);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("确认\u0010");
		btnNewButton.setBounds(144, 203, 156, 53);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(196, 42, 150, 38);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField(16);
		textField_1.setBounds(196, 92, 150, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JPasswordField(16);
		textField_2.setBounds(196, 153, 150, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String phoneNumber = textField.getText();
					String pwd1 = new String(textField_1.getPassword());
					String pwd2 = new String(textField_2.getPassword());
					try {
						@SuppressWarnings("unused")
						BeanUserInfo user=TakeOutUtil.userManger.regist(phoneNumber, pwd1, pwd2);
						JOptionPane.showMessageDialog(null, "注册成功请重新登陆", "提示", JOptionPane.ERROR_MESSAGE);
						FrmRegister.this.setVisible(false);

					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showConfirmDialog(null, e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		
		


	}

}
