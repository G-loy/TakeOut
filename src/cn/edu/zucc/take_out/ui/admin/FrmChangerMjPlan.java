package cn.edu.zucc.take_out.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanMjPlan;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.admin
 * @date:2020年7月9日
 */
public class FrmChangerMjPlan extends JFrame {

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
					FrmChangerMjPlan frame = new FrmChangerMjPlan();
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
	public FrmChangerMjPlan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改满减方案");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(147, 6, 130, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("满减金额");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 62, 93, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(232, 65, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("优惠金额");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(31, 115, 93, 33);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(232, 121, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("能否与优惠叠加");
		rdbtnNewRadioButton.setBounds(232, 167, 141, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(136, 216, 117, 29);
		contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Double mjMoney = Double.valueOf(textField.getText());
				Double discantMoney = Double.valueOf(textField_1.getText());
				boolean canAdd = rdbtnNewRadioButton.isSelected();
				BeanMjPlan plan = new BeanMjPlan();
				plan.setMjID(FrmAdminMain.curMj.getMjID());
				plan.setMjMoney(mjMoney);
				plan.setDicountMoney(discantMoney);
				plan.setCanADD(canAdd);
				try {
					TakeOutUtil.MJPlanManager.changePlan(plan);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
				}
			}
		});		
		textField.setText(String.valueOf(FrmAdminMain.curMj.getMjMoney()));
		textField_1.setText(String.valueOf(FrmAdminMain.curMj.getDicountMoney()));
		rdbtnNewRadioButton.setSelected(FrmAdminMain.curMj.isCanADD());
		
	}

}
