package cn.edu.zucc.take_out.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanShopInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
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
public class FrmAddShop extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldStar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddShop frame = new FrmAddShop();
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
	public FrmAddShop() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("添加商家");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(144, 23, 105, 45);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("商家名称");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(41, 109, 130, 21);
		contentPane.add(lblNewLabel_1);

		textFieldName = new JTextField();
		textFieldName.setBounds(238, 107, 130, 26);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);


		JLabel lblNewLabel_2 = new JLabel("星级");
		lblNewLabel_2.setBounds(41, 142, 61, 29);
		contentPane.add(lblNewLabel_2);

		textFieldStar = new JTextField();
		textFieldStar.setBounds(238, 145, 130, 26);
		contentPane.add(textFieldStar);
		textFieldStar.setColumns(10);

		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String shopName = textFieldName.getText();
					int star = Integer.valueOf(textFieldStar.getText());
					try{
						BeanShopInfo shop = TakeOutUtil.shopManger.regist(shopName, star);
						JOptionPane.showMessageDialog(null, "成功添加一户商家", "提示", JOptionPane.ERROR_MESSAGE);
					}catch(BaseException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE); 
                        return;
					}
				}

			}
		});
		btnNewButton.setBounds(144, 193, 130, 37);
		contentPane.add(btnNewButton);

	}
}
