package cn.edu.zucc.take_out.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
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
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月6日
 */
public class FrmChangeAdminPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOldPwd;
	private JTextField textFieldNewPwd1;
	private JTextField textFieldNewPwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChangeAdminPassword frame = new FrmChangeAdminPassword();
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
	public FrmChangeAdminPassword() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改密码");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblNewLabel.setBounds(163, 6, 112, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("原密码：");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(79, 82, 122, 26);
		contentPane.add(lblNewLabel_1);
		
		textFieldOldPwd = new JTextField();
		textFieldOldPwd.setBounds(202, 82, 130, 26);
		contentPane.add(textFieldOldPwd);
		textFieldOldPwd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("新密码");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(79, 123, 71, 23);
		contentPane.add(lblNewLabel_2);
		
		textFieldNewPwd1 = new JTextField();
		textFieldNewPwd1.setBounds(202, 120, 130, 26);
		contentPane.add(textFieldNewPwd1);
		textFieldNewPwd1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("确认新密码");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(79, 163, 122, 26);
		contentPane.add(lblNewLabel_3);
		
		textFieldNewPwd2 = new JTextField();
		textFieldNewPwd2.setBounds(202, 166, 130, 26);
		contentPane.add(textFieldNewPwd2);
		textFieldNewPwd2.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String oldPwd = textFieldOldPwd.getText();
					String newPwd1= textFieldNewPwd1.getText();
					String newPwd2= textFieldNewPwd2.getText();
					try {
						TakeOutUtil.adminManger.changePwd(BeanAdminInfo.currentLoginAdmin, oldPwd, newPwd1, newPwd2);
						JOptionPane.showMessageDialog(null, "管理员密码已经改变请重新登陆", "警告", JOptionPane.ERROR_MESSAGE);
						FrmChangeAdminPassword.this.setVisible(false);
						FrmChoose.frame.setVisible(true);
					} catch (BaseException e1) {
					// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(145, 208, 130, 38);
		contentPane.add(btnNewButton);
	}
}






















