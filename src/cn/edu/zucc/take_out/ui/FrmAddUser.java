package cn.edu.zucc.take_out.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月5日
 */
public class FrmAddUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					FrmAddUser frame = new FrmAddUser();
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
	public FrmAddUser() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 536, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(85, 79, 73, 43);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(282, 88, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("添加用户");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(196, 18, 153, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("电话");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(85, 185, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 181, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("是否开通会员");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(85, 213, 112, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("性别");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(85, 140, 61, 21);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(282, 138, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("一个月会员");
		chckbxNewCheckBox.setBounds(284, 219, 153, 26);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==btnNewButton) {
						String userName = textField.getText();
						String phone = textField_1.getText();
						String gender = textField_3.getText();
						Boolean is_number = chckbxNewCheckBox.isSelected();
						try {
							@SuppressWarnings("unused")
							BeanUserInfo user=TakeOutUtil.userManger.regist(userName, phone, gender, is_number);
							JOptionPane.showMessageDialog(null, "已经添加一位用户，请通知用户尽快修改初始密码", "警告", JOptionPane.ERROR_MESSAGE);
						} catch (BaseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showConfirmDialog(null, e1.getMessage(),"Lucida Grande",JOptionPane.ERROR_MESSAGE);
						}

					}
				}
		});
		btnNewButton.setBounds(196, 268, 117, 29);
		contentPane.add(btnNewButton);
	}
}
