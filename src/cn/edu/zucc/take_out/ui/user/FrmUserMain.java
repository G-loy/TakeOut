package cn.edu.zucc.take_out.ui.user;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanAddress;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.user
 * @date:2020年7月8日
 */
public class FrmUserMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	JMenuBar menuBar = new JMenuBar();
	JMenu mnNewMenu = new JMenu("个人信息");
	JMenuItem menuItemUserInfo = new JMenuItem("个人信息维护");
	JMenu mnNewMenu_1 = new JMenu("配送地址");
	JMenu mnNewMenu_2 = new JMenu("商品订单");
	JMenu mnNewMenu_3 = new JMenu("优惠券持有");
	JMenu mnNewMenu_4 = new JMenu("集单送券表");
	JMenu mnNewMenu_5 = new JMenu("购买界面");
	private final JMenuItem menuItemAddAddress = new JMenuItem("新增配送地址");
	private final JMenuItem menuItemProduct = new JMenuItem("查看商品订单");
	private final JMenuItem menuItemCoup = new JMenuItem("查看优惠券持有");
	private final JMenuItem menuItemJDSQ = new JMenuItem("查看集单情况");
	private final JMenuItem menuItemBuy = new JMenuItem("进入购买界面");
	private final JMenuItem menuItemChangePwd = new JMenuItem("修改密码");
	private final JMenuItem menuItemDeletAddress = new JMenuItem("删除配送地址");
	private final JMenuItem menuItemRefresh = new JMenuItem("刷新");
	private JTable dataTable = new JTable();
	
	private Object[] tblAddressTitle = BeanAddress.ADDRESS_TITLE;
	private Object[][] tblAddressDate;
	private DefaultTableModel tablModel = new DefaultTableModel();
	private List<BeanAddress> allAddress = null;
	
	public  void reloadAddressTable() {
		try {
			allAddress=TakeOutUtil.addressManager.loadAll();
		}catch (BaseException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
		}
		tblAddressDate = new Object[allAddress.size()][tblAddressTitle.length];
		
		for(int i=0;i<allAddress.size();i++) {
			for(int j=0;j<BeanAddress.ADDRESS_TITLE.length;j++) {

				tblAddressDate[i][j]=allAddress.get(i).getCell(j);
				System.out.println(tblAddressDate.toString());
			}
		}

		tablModel.setDataVector(tblAddressDate, tblAddressTitle);
		dataTable.setModel(tablModel);
		dataTable.setBounds(0, 49, 884, 421);
		this.dataTable.validate();
		this.dataTable.repaint();
		this.dataTable.updateUI();
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserMain frame = new FrmUserMain();
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
	public FrmUserMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		menuBar.setBounds(0, 0, 879, 45);
		contentPane.add(menuBar);
		menuBar.add(mnNewMenu);
		mnNewMenu.add(menuItemUserInfo);	
		menuItemUserInfo.addActionListener(this);
		mnNewMenu.add(menuItemChangePwd);
		menuItemChangePwd.addActionListener(this);
		
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_1.add(menuItemAddAddress);
		
		mnNewMenu_1.add(menuItemDeletAddress);
		
		mnNewMenu_1.add(menuItemRefresh);
		menuItemAddAddress.addActionListener(this);
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_2.add(menuItemProduct);
		menuItemProduct.addActionListener(this);
		menuBar.add(mnNewMenu_3);
		
		mnNewMenu_3.add(menuItemCoup);
		menuItemCoup.addActionListener(this);
		menuBar.add(mnNewMenu_4);
		
		mnNewMenu_4.add(menuItemJDSQ);
		menuItemJDSQ.addActionListener(this);
		menuBar.add(mnNewMenu_5);
		
		mnNewMenu_5.add(menuItemBuy);
		

		dataTable.setBounds(0, 45, 879, 481);
		contentPane.add(dataTable);
		menuItemBuy.addActionListener(this);
		reloadAddressTable();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menuItemUserInfo) {
			FrmChangeUserInfo user = new FrmChangeUserInfo();
			user.setVisible(true);
		}else if(e.getSource()==menuItemChangePwd) {
			FrmChangePwd pwd = new FrmChangePwd();
			pwd.setVisible(true);
			this.setVisible(false);
		}
	}
}
