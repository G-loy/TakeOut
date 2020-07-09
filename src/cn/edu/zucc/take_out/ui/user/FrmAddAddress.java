package cn.edu.zucc.take_out.ui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanAddress;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.print.attribute.standard.JobPriority;
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
public class FrmAddAddress extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldProvince;
	private JTextField textFieldDistance;
	private JTextField textFieldAddress;
	private JTextField textFieldLinkMan;
	private JTextField textFieldCity;
	private JTextField textFieldPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddAddress frame = new FrmAddAddress();
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
	public FrmAddAddress() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加地址");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(422, 106, 165, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("省");
		lblNewLabel_1.setBounds(53, 53, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		textFieldProvince = new JTextField();
		textFieldProvince.setBounds(182, 48, 130, 26);
		contentPane.add(textFieldProvince);
		textFieldProvince.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("区");
		lblNewLabel_2.setBounds(53, 137, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textFieldDistance = new JTextField();
		textFieldDistance.setBounds(182, 127, 130, 26);
		contentPane.add(textFieldDistance);
		textFieldDistance.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("具体地址");
		lblNewLabel_3.setBounds(53, 178, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(182, 173, 130, 26);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("联系人姓名");
		lblNewLabel_4.setBounds(53, 216, 79, 16);
		contentPane.add(lblNewLabel_4);
		
		textFieldLinkMan = new JTextField();
		textFieldLinkMan.setBounds(182, 211, 130, 26);
		contentPane.add(textFieldLinkMan);
		textFieldLinkMan.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("市");
		lblNewLabel_5.setBounds(53, 96, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(182, 94, 130, 26);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("联系人电话");
		lblNewLabel_6.setBounds(53, 267, 79, 16);
		contentPane.add(lblNewLabel_6);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(182, 262, 130, 26);
		contentPane.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					BeanAddress addressInfo = new BeanAddress();
					int userId = BeanUserInfo.currentLoginUser.getUserId();
					String province = textFieldProvince.getText();
					String city = textFieldCity.getText();
					String distance = textFieldDistance.getText();
					String address = textFieldAddress.getText();
					String linkman = textFieldLinkMan.getText();
					String phonenumber = textFieldPhoneNumber.getText();
				    try {
						TakeOutUtil.addressManager.addAddress(userId, province, city, distance, address, linkman, phonenumber);
						JOptionPane.showMessageDialog(null, "您已经成功添加一条配送地址", "警告", JOptionPane.ERROR_MESSAGE);
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton.setBounds(422, 247, 117, 59);
		contentPane.add(btnNewButton);
	}

}
