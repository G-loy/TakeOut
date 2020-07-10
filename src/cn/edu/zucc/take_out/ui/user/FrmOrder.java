package cn.edu.zucc.take_out.ui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.user
 * @date:2020年7月10日
 */
public class FrmOrder extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabelProductId = new JLabel();
	private JLabel lblNewLabelProductPrice = new JLabel();
	private JLabel lblNewLabelProductName = new JLabel();
	private JTextField textField;
	private JTextField textFieldProductNumber = new JTextField();
	private JLabel lblNewLabelpreDiscount = new JLabel();
	static JComboBox comboBox = new JComboBox();
	static JComboBox comboBox_1 = new JComboBox();
	private double totalPriceBeforeMJ ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOrder frame = new FrmOrder();
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
	public FrmOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("商品编号");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(39, 106, 95, 26);
		contentPane.add(lblNewLabel_3);
		lblNewLabelProductId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelProductId.setText("1111");


		lblNewLabelProductId.setBounds(268, 111, 61, 16);
		contentPane.add(lblNewLabelProductId);

		JLabel lblNewLabel_5 = new JLabel("商品数量");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(39, 191, 84, 29);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("商品价格");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(39, 236, 84, 26);
		contentPane.add(lblNewLabel_6);
		lblNewLabelProductPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelProductPrice.setText("1111");


		lblNewLabelProductPrice.setBounds(268, 241, 130, 16);
		contentPane.add(lblNewLabelProductPrice);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(39, 533, 152, 49);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_9 = new JLabel("商品名");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(39, 150, 95, 29);
		contentPane.add(lblNewLabel_9);
		lblNewLabelProductName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelProductName.setText("1111");


		lblNewLabelProductName.setBounds(268, 150, 130, 28);
		contentPane.add(lblNewLabelProductName);

		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setBounds(272, 533, 152, 49);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("要求送达时间");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(39, 302, 131, 41);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(268, 311, 130, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("选择配送地址");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(39, 348, 141, 26);
		contentPane.add(lblNewLabel_4);


		comboBox.setBounds(268, 352, 130, 27);
		contentPane.add(comboBox);


		textFieldProductNumber.setBounds(268, 195, 130, 26);
		contentPane.add(textFieldProductNumber);
		textFieldProductNumber.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("商品优惠价格");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(39, 274, 152, 29);
		contentPane.add(lblNewLabel_7);
		lblNewLabelpreDiscount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabelpreDiscount.setText("11111");


		lblNewLabelpreDiscount.setBounds(268, 272, 130, 27);
		contentPane.add(lblNewLabelpreDiscount);

		JLabel lblNewLabel = new JLabel("确认订单");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblNewLabel.setBounds(163, 31, 116, 49);
		contentPane.add(lblNewLabel);

		lblNewLabelProductId.setText(String.valueOf(FrmBuy.curProduct.getProductId()));
		lblNewLabelProductName.setText(String.valueOf(FrmBuy.curProduct.getProductName()));
		textFieldProductNumber.setText(String.valueOf(1));
		lblNewLabelProductPrice.setText(String.valueOf(FrmBuy.curProduct.getProductPrice()));
		lblNewLabelpreDiscount.setText(String.valueOf(FrmBuy.curProduct.getPrefPrice()));

		JLabel lblNewLabel_1 = new JLabel("选择优惠券");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 386, 131, 26);
		contentPane.add(lblNewLabel_1);


		comboBox_1.setBounds(268, 390, 130, 27);
		contentPane.add(comboBox_1);

		JLabel lblNewLabel_8 = new JLabel("结算金额");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(39, 466, 122, 29);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(268, 460, 126, 41);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("满减金额");
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(39, 424, 131, 30);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(268, 429, 130, 25);
		contentPane.add(lblNewLabel_12);

		try {
			for(int i = 0; i<TakeOutUtil.addressManager.loadAddress().size();i++) {
				comboBox.addItem(TakeOutUtil.addressManager.loadAddress().get(i));
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(String.valueOf(comboBox_1.getSelectedItem())==null||String.valueOf(comboBox_1.getSelectedItem())=="") {
			totalPriceBeforeMJ=FrmBuy.curProduct.getProductPrice()*Integer.valueOf(textFieldProductNumber.getText());
		}else {
			try {
				totalPriceBeforeMJ = FrmBuy.curProduct.getProductPrice()*Integer.valueOf(textFieldProductNumber.getText())-TakeOutUtil.userHasCouInfoManager.getCutMoneyByID(getCoupId());
			}catch (NumberFormatException | BaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}





//获得所选地址的ID
public static String getQuantity(String regular){
	int index = 0;
	for (int i = 0; i < regular.length(); i++) {
		char c = regular.charAt(i);
		if (Character.isDigit(c)) {
			if (i == regular.length() - 1) {
				index = i + 1;
			} else {
				index = i;
			}
			continue;
		} else {
			index = i;
			break;
		}
	}
	return regular.substring(0, index);
}

public static int getCoupId() {
	String coup = String.valueOf(comboBox_1.getSelectedItem());
	System.out.println(coup);
	String coupID=getQuantity(coup.substring(2));
	System.out.println(coupID);
	return Integer.valueOf(coupID);
}


}













