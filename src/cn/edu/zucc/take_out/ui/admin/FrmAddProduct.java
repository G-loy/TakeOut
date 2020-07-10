package cn.edu.zucc.take_out.ui.admin;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.JobPriority;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月7日
 */
public class FrmAddProduct extends JFrame {

	private JPanel contentPane = new JPanel();
	private JTextField textFieldName = new JTextField();
	private JTextField textFieldPrice = new JTextField();
	private JTextField textFieldPrefPrice = new JTextField();
	private JTextField textFieldNumber = new JTextField();


	private JLabel lblNewLabel = new JLabel("添加商品");
	private JLabel lblNewLabel_1 = new JLabel("商品名");
	private JLabel lblNewLabel_2 = new JLabel("商品类别");
	private JLabel lblNewLabel_3 = new JLabel("商品价格");
	private JLabel lblNewLabel_4 = new JLabel("优惠价格");
	private JLabel lblNewLabel_5 = new JLabel("数量");
	private JComboBox<String> comboBox = new JComboBox();
	private final JLabel lblNewLabel_6 = new JLabel("商家名");
	private final JComboBox comboBox_1 = new JComboBox();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddProduct frame = new FrmAddProduct();
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
	public FrmAddProduct() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(150, 6, 170, 49);
		contentPane.add(lblNewLabel);


		lblNewLabel_1.setBounds(39, 72, 61, 16);
		contentPane.add(lblNewLabel_1);


		lblNewLabel_2.setBounds(39, 100, 61, 16);
		contentPane.add(lblNewLabel_2);


		lblNewLabel_3.setBounds(39, 134, 61, 23);
		contentPane.add(lblNewLabel_3);


		lblNewLabel_4.setBounds(39, 169, 61, 24);
		contentPane.add(lblNewLabel_4);


		lblNewLabel_5.setBounds(39, 205, 61, 16);
		contentPane.add(lblNewLabel_5);


		textFieldName.setBounds(139, 67, 130, 26);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);


		comboBox.setBounds(139, 96, 130, 27);
		contentPane.add(comboBox);
		try {
			for(int i=0;i<loadComboBox().size();i++) {
				comboBox.addItem(loadComboBox().get(i));
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		textFieldPrice.setBounds(139, 132, 130, 26);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		textFieldPrefPrice.setBounds(139, 168, 130, 26);
		contentPane.add(textFieldPrefPrice);
		textFieldPrefPrice.setColumns(10);

		textFieldNumber.setBounds(139, 200, 130, 26);
		contentPane.add(textFieldNumber);
		textFieldNumber.setColumns(10);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(281, 117, 145, 47);
		contentPane.add(btnNewButton);
		lblNewLabel_6.setBounds(39, 233, 76, 16);
		
		contentPane.add(lblNewLabel_6);
		comboBox_1.setBounds(139, 229, 130, 27);
		
		contentPane.add(comboBox_1);
		try {
			for(int i=0;i<TakeOutUtil.shopManger.loadAllName().size();i++) {
				comboBox_1.addItem(TakeOutUtil.shopManger.loadAllName().get(i));
			}
		}catch(BaseException e) {
			e.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btnNewButton) {
					String name =textFieldName.getText();
					String className = (String) comboBox.getSelectedItem();
					Double price = Double.valueOf(textFieldPrefPrice.getText());
					Double prefPrice = Double.valueOf(textFieldPrefPrice.getText());
					int number = Integer.valueOf(textFieldNumber.getText());
					String shopName = String.valueOf(comboBox_1.getSelectedItem());
					try {
						TakeOutUtil.productManager.add(className, name, price, prefPrice, number,shopName);
						JOptionPane.showMessageDialog(null,"您以成功添加商品","警告", JOptionPane.ERROR_MESSAGE);
					} catch (BaseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,e1.getMessage(),"警告", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}
	public static List<String> loadComboBox() throws BaseException {
		return TakeOutUtil.productClaassManager.getAllClassName();	
	}





























}