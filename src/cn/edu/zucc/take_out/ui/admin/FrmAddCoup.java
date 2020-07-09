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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月7日
 */
public class FrmAddCoup extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCoupMoney;
	private JTextField textFieldRequestNumber;
	private JTextField textFieldStartTime;
	private JTextField textFieldFinishTime;
	private JComboBox comboBox = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddCoup frame = new FrmAddCoup();
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
	public FrmAddCoup() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("添加优惠券");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(166, 6, 157, 47);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("优惠金额");
		lblNewLabel_1.setBounds(31, 67, 61, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("所需集单数量");
		lblNewLabel_2.setBounds(31, 107, 91, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("开始日期");
		lblNewLabel_3.setBounds(31, 144, 61, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("结束日期");
		lblNewLabel_4.setBounds(31, 177, 61, 16);
		contentPane.add(lblNewLabel_4);

		textFieldCoupMoney = new JTextField();
		textFieldCoupMoney.setBounds(150, 62, 130, 26);
		contentPane.add(textFieldCoupMoney);
		textFieldCoupMoney.setColumns(10);

		textFieldRequestNumber = new JTextField();
		textFieldRequestNumber.setBounds(150, 102, 130, 26);
		contentPane.add(textFieldRequestNumber);
		textFieldRequestNumber.setColumns(10);

		textFieldStartTime = new JTextField();
		textFieldStartTime.setBounds(150, 139, 130, 26);
		contentPane.add(textFieldStartTime);
		textFieldStartTime.setColumns(10);

		textFieldFinishTime = new JTextField();
		textFieldFinishTime.setBounds(150, 172, 130, 26);
		contentPane.add(textFieldFinishTime);
		textFieldFinishTime.setColumns(10);

		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(311, 198, 117, 40);
		contentPane.add(btnNewButton);

		JLabel IbNewLable_5 = new JLabel("商家");
		IbNewLable_5.setBounds(31, 214, 61, 16);
		contentPane.add(IbNewLable_5);

		

		try {
			for(int i=0;i<TakeOutUtil.shopManger.loadAll().size();i++) {
				comboBox.addItem(loadComboBox().get(i));
			}
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.setBounds(150, 210, 130, 27);
		contentPane.add(comboBox);
		//		comboBox.addItem(item);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btnNewButton) {
					Double coupMoney = Double.valueOf(textFieldCoupMoney.getText());
					int  requestNumber = Integer.valueOf(textFieldCoupMoney.getText());
					Date startTime = strToDate(textFieldStartTime.getText());
					Date finishTime =  strToDate(textFieldFinishTime.getText());
					String shopName = String.valueOf(comboBox.getSelectedItem());
					try {
						TakeOutUtil.couManager.add(coupMoney, requestNumber, startTime, finishTime,shopName);
						JOptionPane.showMessageDialog(null,"成功添加一类优惠券","警告", JOptionPane.ERROR_MESSAGE);
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"警告", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});
	}

	public static java.sql.Date strToDate(String strDate) {  
		String str = strDate;  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date d = null;  
		try {  
			d = format.parse(str);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		java.sql.Date date = new java.sql.Date(d.getTime());  
		return date;  
	}  
	public static List<String> loadComboBox() throws BaseException {
		return TakeOutUtil.shopManger.loadAllName();
		
	}
}

