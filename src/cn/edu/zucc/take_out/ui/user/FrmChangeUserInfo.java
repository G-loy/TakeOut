package cn.edu.zucc.take_out.ui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.ui.admin.FrmAdminMain;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.user
 * @date:2020年7月8日
 */
public class FrmChangeUserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserGender;
	private JTextField textFieldUserName;
	private JTextField textFieldUserPhone;
	private JTextField textFieldUserEmail;
	private JTextField textFieldCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChangeUserInfo frame = new FrmChangeUserInfo();
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
	public FrmChangeUserInfo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 593, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("个人信息维护");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblNewLabel.setBounds(195, 6, 216, 57);
		contentPane.add(lblNewLabel);
		
		JLabel IBINewLable_1 = new JLabel("用户名：");
		IBINewLable_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		IBINewLable_1.setBounds(86, 77, 95, 32);
		contentPane.add(IBINewLable_1);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(344, 83, 130, 26);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldUserGender = new JTextField();
		textFieldUserGender.setBounds(344, 127, 130, 26);
		contentPane.add(textFieldUserGender);
		textFieldUserGender.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("用户性别：");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(86, 127, 109, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("绑定的手机号：");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(86, 169, 163, 34);
		contentPane.add(lblNewLabel_3);
		
		textFieldUserPhone = new JTextField();
		textFieldUserPhone.setBounds(344, 176, 130, 26);
		contentPane.add(textFieldUserPhone);
		textFieldUserPhone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("用户邮箱：");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(86, 222, 109, 29);
		contentPane.add(lblNewLabel_4);
		
		textFieldUserEmail = new JTextField();
		textFieldUserEmail.setBounds(344, 226, 208, 26);
		contentPane.add(textFieldUserEmail);
		textFieldUserEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("用户所在城市：");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(86, 271, 140, 32);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeanUserInfo user = new BeanUserInfo();
				user.setUserName(textFieldUserName.getText());
				user.setUserGender(textFieldUserGender.getText());
				user.setUserPhone(textFieldUserPhone.getText());
				user.setUserEmail(textFieldUserEmail.getText());
				user.setUserCity(textFieldCity.getText());
				user.setUserId(BeanUserInfo.currentLoginUser.getUserId());
				try {
					BeanUserInfo.currentLoginUser=TakeOutUtil.userManger.changeInfo(user);
					JOptionPane.showMessageDialog(null, "你的个人信息已经成功修改", "提示", JOptionPane.ERROR_MESSAGE);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(209, 339, 163, 51);
		contentPane.add(btnNewButton);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(344, 277, 130, 26);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		//输入预设
        textFieldUserName.setText(BeanUserInfo.currentLoginUser.getUserName());
        textFieldUserPhone.setText(BeanUserInfo.currentLoginUser.getUserPhone());
        textFieldUserGender.setText(BeanUserInfo.currentLoginUser.getUserGender());
        textFieldUserEmail.setText(BeanUserInfo.currentLoginUser.getUserEmail());
        textFieldCity.setText(BeanUserInfo.currentLoginUser.getUserCity());

	}
}
