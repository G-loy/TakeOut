package cn.edu.zucc.take_out.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.model.BeanShopInfo;
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
 * @date:2020年7月5日
 */
public class FrmAddRider extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddRider frame = new FrmAddRider();
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
	public FrmAddRider() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("添加骑手");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel.setBounds(168, 6, 100, 48);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(63, 89, 61, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(197, 85, 185, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(197, 135, 185, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("星级");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(63, 145, 61, 16);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String name = textField.getText();
					int star = Integer.valueOf(textField_1.getText());

					try {
						BeanRiderInfo rider = TakeOutUtil.riderManger.regist(name, star);
						JOptionPane.showMessageDialog(null, "成功添加一位骑手", "提示", JOptionPane.ERROR_MESSAGE);
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(145, 199, 158, 48);
		contentPane.add(btnNewButton);


	}

}
