package cn.edu.zucc.take_out.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.util.BaseException;

import java.awt.FlowLayout;
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
 * @date:2020年7月7日
 */
public class FrmAddProudctClass extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAddClass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddProudctClass frame = new FrmAddProudctClass();
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
	public FrmAddProudctClass() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加类别");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(165, 6, 109, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("类别名");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(48, 93, 90, 49);
		contentPane.add(lblNewLabel_1);
		
		textFieldAddClass = new JTextField();
		textFieldAddClass.setBounds(252, 107, 130, 26);
		contentPane.add(textFieldAddClass);
		textFieldAddClass.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String name= textFieldAddClass.getText();
				    try {
						TakeOutUtil.productClaassManager.add(name);
						JOptionPane.showMessageDialog(null, "您以成功添加一个商品类", "警告", JOptionPane.ERROR_MESSAGE);
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(140, 178, 156, 52);
		contentPane.add(btnNewButton);
	}
}
