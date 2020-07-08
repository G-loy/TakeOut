package cn.edu.zucc.take_out.ui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.ui.FrmChoose;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.user
 * @date:2020年7月8日
 */
public class FrmChangePwd extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOldPwd;
	private JTextField textFieldNewPwd;
	private JTextField textFieldNewPwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChangePwd frame = new FrmChangePwd();
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
	public FrmChangePwd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改密码");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(144, 6, 122, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("旧密码：");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 53, 106, 38);
		contentPane.add(lblNewLabel_1);
		
		textFieldOldPwd = new JTextField();
		textFieldOldPwd.setBounds(237, 70, 130, 26);
		contentPane.add(textFieldOldPwd);
		textFieldOldPwd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("新密码：");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(36, 103, 94, 39);
		contentPane.add(lblNewLabel_2);
		
		textFieldNewPwd = new JTextField();
		textFieldNewPwd.setBounds(237, 112, 130, 26);
		contentPane.add(textFieldNewPwd);
		textFieldNewPwd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("确认新密码：");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(36, 154, 122, 34);
		contentPane.add(lblNewLabel_3);
		
		textFieldNewPwd2 = new JTextField();
		textFieldNewPwd2.setBounds(237, 161, 130, 26);
		contentPane.add(textFieldNewPwd2);
		textFieldNewPwd2.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TakeOutUtil.userManger.changePwd(BeanUserInfo.currentLoginUser, textFieldOldPwd.getText(), textFieldNewPwd.getText(), textFieldNewPwd2.getText());
					JOptionPane.showMessageDialog(null, "您的密码已经得到修改请重新登陆","警告",JOptionPane.ERROR_MESSAGE);
					FrmChangePwd.this.setVisible(false);
					FrmChoose.frame.setVisible(true);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(116, 208, 174, 46);
		contentPane.add(btnNewButton);
	}

}
