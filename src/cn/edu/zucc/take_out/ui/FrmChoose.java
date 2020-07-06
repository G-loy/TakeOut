package cn.edu.zucc.take_out.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
    @Title:FrmChoose.java
    @author created by Pengkun Gu
    @version 1.0
    @date 2020年7月4日上午10:21:26
*/
public class FrmChoose extends JFrame{
	 static FrmChoose frame = new FrmChoose();
	private  JPanel contentPane = new JPanel();
	private JPanel panelYonghu = new JPanel();
	private JPanel panel = new JPanel();
	private JButton btnNewButton_2 = new JButton("登录");
	private JButton btnNewButton_1 = new JButton("管理员");
	private JButton btnNewButton = new JButton("用户");
	private JButton btnCancel = new JButton("退出");
	private JLabel lblNewLabel = new JLabel("管理员登录");
	private JLabel lblNewLabelUser = new JLabel("用户登录");
	private JLabel lblNewLabel1 = new JLabel("用户名");
	private JLabel lblNewLabelUsername = new JLabel("手机号");
	private JLabel lblNewLabel_2 = new JLabel("密码");
	private JTextField textFieldYonghu = new JTextField(16);
	private JTextField textField = new JTextField(16);
	
	private JPasswordField passwordField_2 = new JPasswordField(16);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

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
	public FrmChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		panel.setBounds(5, 5, 440, 268);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);
		
		
		
		contentPane.add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 0, 439, 273);
		panel_1.setLayout(null);
		

		lblNewLabel.setFont(new Font("004-CAI978", Font.BOLD, 23));
		lblNewLabel.setBounds(149, 6, 140, 48);
		panel_1.add(lblNewLabel);
		

		lblNewLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel1.setBounds(89, 64, 48, 42);
		panel_1.add(lblNewLabel1);
		

		textField.setBounds(201, 66, 196, 40);
        panel_1.add(textField);
		textField.setColumns(10);
		

		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(89, 122, 48, 47);
		panel_1.add(lblNewLabel_2);
		

		passwordField_2.setBounds(201, 126, 196, 40);
		panel_1.add(passwordField_2);
		passwordField_2.setColumns(10);
		

		btnNewButton_2.setLocation(149, 194);
		btnNewButton_2.setSize(168, 50);
		btnNewButton.setBounds(159, 184, 114, 42);
		panel_1.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              if(e.getSource()==btnNewButton_2) {
            	  String adminName=textField.getText();
            	  String adminPwd = new String( passwordField_2.getPassword());
            	  System.out.println(adminName);
            	  System.out.println(adminPwd);
            	  
            	  try {
            	  BeanAdminInfo.currentLoginAdmin=TakeOutUtil.adminManger.login(adminName, adminPwd);
            	  frame.setVisible(false);
            	  FrmAdminMain fadmin = new FrmAdminMain();
            	  fadmin.setVisible(true);
            	  }catch(BaseException e1) {
            		  JOptionPane.showInternalMessageDialog(null, e1.getMessage(),"警告", JOptionPane.ERROR_MESSAGE);
            	  }

              }else if (e.getSource() ==btnCancel ) {
            	  System.exit(0);
              }
			}
		});
		
		
		
		//管理员登录
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.add(panel_1);
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});

		
		//用户登录
		
		panelYonghu.setBounds(5, 5, 449, 275);
		lblNewLabelUser.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabelUser.setBounds(162, 6, 153, 65);
		lblNewLabel.setFont(new Font("004-CAI978", Font.BOLD, 23));
		lblNewLabel.setBounds(149, 6, 140, 48);
		panelYonghu.setLayout(null);
		panelYonghu.add(lblNewLabelUser);
		
		
		lblNewLabelUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelUsername.setBounds(75, 66, 75, 46);
		panelYonghu.add(lblNewLabelUsername);
		

		textFieldYonghu.setBounds(149, 73, 273, 39);
		textFieldYonghu.setColumns(10);
        panelYonghu.add(textFieldYonghu);
		
		JLabel lblNewLabelMima = new JLabel("密码");
		lblNewLabelMima.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelMima.setBounds(75, 126, 48, 52);
		panelYonghu.add(lblNewLabelMima);
		
		
		JPasswordField textField_Mima = new JPasswordField(20);
		textField_Mima.setBounds(149, 136, 273, 39);
		textField_Mima.setColumns(10);
		panelYonghu.add(textField_Mima);
		
		JButton btnNewButton_Denglu = new JButton("登录");
		//通过手机号登陆
		btnNewButton_Denglu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_Denglu) {
					String phoneNumber = textFieldYonghu.getText();
					String pwd = new String(textField_Mima.getPassword());
					try {
						BeanUserInfo.currentLoginUser=TakeOutUtil.userManger.login(phoneNumber, pwd);
					}catch(BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Lucida Grande", JOptionPane.ERROR_MESSAGE);
					}
					frame.setVisible(false);
				}
				
			}
		});
		btnNewButton_Denglu.setLocation(132, 194);
		btnNewButton_Denglu.setSize(168, 50);
		btnNewButton_Denglu.setBounds(37, 196, 141, 68);
		panelYonghu.add(btnNewButton_Denglu);
		
		JButton btnNewButton_Zhuce = new JButton("注册");
		btnNewButton_Zhuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegister frg = new FrmRegister();
				frg.setVisible(true);
			}
		});
		
		btnNewButton_Zhuce.setBounds(252, 196, 141, 68);
		panelYonghu.add(btnNewButton_Zhuce);
		
		//用户登录
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				contentPane.add(panelYonghu);
				panelYonghu.setVisible(true);
			}
		});
		
	}


}
