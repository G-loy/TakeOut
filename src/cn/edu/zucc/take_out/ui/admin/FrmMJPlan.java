package cn.edu.zucc.take_out.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.admin
 * @date:2020年7月9日
 */
public class FrmMJPlan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMJPlan frame = new FrmMJPlan();
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
	public FrmMJPlan() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 544, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("添加满减方案");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblNewLabel.setBounds(136, 6, 196, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("商家名");
		lblNewLabel_1.setBounds(60, 82, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		
		comboBox.setBounds(262, 78, 167, 27);
		contentPane.add(comboBox);
		
		try {
			for(int i = 0;i<loadComboBox().size();i++) {
				comboBox.addItem(loadComboBox().get(i));
			}
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel_2 = new JLabel("满减金额");
		lblNewLabel_2.setBounds(60, 124, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(262, 117, 167, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("优惠金额");
		lblNewLabel_3.setBounds(60, 163, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(262, 158, 167, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("是否能与优惠券叠加");
		rdbtnNewRadioButton.setBounds(262, 201, 167, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shopName = String.valueOf(comboBox.getSelectedItem());
				double mjMoney = Double.valueOf(textField.getText());
				double discantMoney = Double.valueOf(textField_1.getText());
				boolean canADD = rdbtnNewRadioButton.isSelected();
			try {
				TakeOutUtil.MJPlanManager.addPlan(shopName, mjMoney, discantMoney, canADD);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
			   JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		btnNewButton.setBounds(154, 238, 190, 50);
		contentPane.add(btnNewButton);
	}
	
	public static List<String> loadComboBox() throws BaseException {
		return TakeOutUtil.shopManger.loadAllName();
		
	}
	
	
}
