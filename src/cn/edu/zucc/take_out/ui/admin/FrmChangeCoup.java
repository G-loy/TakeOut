package cn.edu.zucc.take_out.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanCouInfo;
import cn.edu.zucc.take_out.util.BaseException;
import cn.edu.zucc.take_out.util.BusinessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.print.attribute.standard.JobPriority;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月7日
 */
public class FrmChangeCoup extends JFrame {

	JPanel contentPane = new JPanel();
	JTextField textField = new JTextField();
	JTextField textField_1 = new JTextField();
	JTextField textField_2 = new JTextField();
	JTextField textField_3 = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChangeCoup frame = new FrmChangeCoup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws BusinessException 
	 */
	public FrmChangeCoup()  {


		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("修改优惠");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(162, 6, 95, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("修改优惠金额");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 62, 120, 16);
		contentPane.add(lblNewLabel_1);


		textField.setBounds(189, 57, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);


		JLabel lblNewLabel_2 = new JLabel("集单要求");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(53, 95, 95, 27);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("修改起始时间");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(53, 134, 120, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("修改结束日期");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(53, 172, 120, 16);
		contentPane.add(lblNewLabel_4);


		textField_1.setBounds(189, 95, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);


		textField_2.setBounds(189, 129, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);


		textField_3.setBounds(189, 167, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField.setText(String.valueOf(FrmAdminMain.curCoup.getCoupMoney()));
		textField_3.setText(String.valueOf(FrmAdminMain.curCoup.getFinishTime()));
		textField_2.setText(String.valueOf(FrmAdminMain.curCoup.getStartTime()));
		textField_1.setText(String.valueOf(FrmAdminMain.curCoup.getCollRequest()));


		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					BeanCouInfo newCoupInfo = new BeanCouInfo();
					newCoupInfo.setCoupId(FrmAdminMain.curCoup.getCoupId());
					newCoupInfo.setCoupMoney(Integer.valueOf(textField.getText()));
					newCoupInfo.setCollRequest(Integer.valueOf(textField_1.getText()));
					newCoupInfo.setFinishTime(TakeOutUtil.strToDate(textField_3.getText()));
					newCoupInfo.setStartTime(TakeOutUtil.strToDate(textField_2.getText()));
					try {
						TakeOutUtil.couManager.changeCoup(newCoupInfo);
						JOptionPane.showMessageDialog(null,"成功修改一个优惠","警告",JOptionPane.ERROR_MESSAGE);
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
					}
                   
				}
			}
		});
		btnNewButton.setBounds(132, 222, 136, 50);
		contentPane.add(btnNewButton);
		
	}



}
