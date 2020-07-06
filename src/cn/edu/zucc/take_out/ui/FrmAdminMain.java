package cn.edu.zucc.take_out.ui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.model.BeanShopInfo;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月5日
 */
public class FrmAdminMain extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JMenuBar menuBar = new JMenuBar();

	private JMenu menuUser = new JMenu("用户管理");
	private JMenuItem menuItemAddUser = new JMenuItem("添加用户");
	private JMenuItem menuItemDeletUser = new JMenuItem("删除用户");

	private JMenu menuShop = new JMenu("商家管理");
	private JMenuItem menuItemAddShop = new JMenuItem("添加商家");
	private final JMenuItem menuItemDeletShop = new JMenuItem("删除商家");

	private JMenu menuRider = new JMenu("骑手管理");
	private JMenuItem MmnuItemAddRider = new JMenuItem("添加骑手");
	private JMenuItem menuItemDeletRider = new JMenuItem("删除骑手");

	private JMenu menuAdmin = new JMenu("管理员管理");
	private JMenuItem menuItemAddAdmin = new JMenuItem("添加管理员");
	private JMenuItem menuItemDeletAdmin = new JMenuItem("删除管理员");
	private JMenuItem menuItemChangePwd = new JMenuItem("修改本管理员密码");

	private JMenu mnNewMenu_5 = new JMenu("优惠管理");




	private JMenuItem MenuItemRefAdmin = new JMenuItem("刷新");
	private JMenuItem MenuItemRefRider = new JMenuItem("刷新");
	private JMenuItem MenuItemRefUser = new JMenuItem("刷新");
	private JMenuItem MenuItemRefShop = new JMenuItem("刷新");

	//将所有管理员显示在dataTable上
	private Object tblAdminTitle[] = BeanAdminInfo.adminTableTitle;
	private Object tblUserTitle[] = BeanUserInfo.USER_TITLE;
	private Object tbShopTitle[] = BeanShopInfo.SHOP_TITLE;
	private Object tbRiderTitle[] = BeanRiderInfo.Rider_TITLE;



	private Object tblAdminDate[][];
	private Object tblUserDate[][];
	private Object tblShopDate[][];
	private Object tblRiderDate[][];



	DefaultTableModel tablModel = new DefaultTableModel();
	private JTable dataTable = new JTable();

	List<BeanAdminInfo> allAdmin = null;
	List<BeanUserInfo>  allUser = null;
	List<BeanShopInfo>  allShop = null;
	List<BeanRiderInfo> allRider = null;

	private void reloadAdminTable() {
		try {
			allAdmin = TakeOutUtil.adminManger.loadAll();
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblAdminDate = new Object[allAdmin.size()][BeanAdminInfo.adminTableTitle.length];
		for(int i=0;i<allAdmin.size();i++) {
			for(int j=0;j<BeanAdminInfo.adminTableTitle.length;j++) {

				tblAdminDate[i][j]=allAdmin.get(i).getCell(j);
				System.out.println(tblAdminDate.toString());
			}
		}

		tablModel.setDataVector(tblAdminDate, tblAdminTitle);
		dataTable.setModel(tablModel);
		dataTable.setBounds(0, 49, 884, 421);
		this.dataTable.validate();
		this.dataTable.repaint();
		this.dataTable.updateUI();
	}


	private void reloadUserTable() {
		try {
			allUser = TakeOutUtil.userManger.loadAll();
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblUserDate = new Object[allUser.size()][BeanUserInfo.USER_TITLE.length];
		for(int i=0;i<allUser.size();i++) {
			for(int j=0;j<BeanUserInfo.USER_TITLE.length;j++) {

				tblUserDate[i][j]=allUser.get(i).getCell(j);
				System.out.println(tblUserDate.toString());
			}
		}

		tablModel.setDataVector(tblUserDate, tblUserTitle);
		dataTable.setModel(tablModel);
		dataTable.setBounds(0, 49, 884, 421);
		this.dataTable.validate();
		this.dataTable.repaint();
	}

	private void reloadRiderTable() {
		try {
			allRider = TakeOutUtil.riderManger.loadAll();
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblRiderDate = new Object[allRider.size()][BeanRiderInfo.Rider_TITLE.length];
		for(int i=0;i<allRider.size();i++) {
			for(int j=0;j<BeanRiderInfo.Rider_TITLE.length;j++) {
				tblRiderDate[i][j]=allRider.get(i).getCell(j);
				System.out.println(tblRiderDate.toString());
			}
		}

		tablModel.setDataVector(tblRiderDate, tbRiderTitle);
		dataTable.setModel(tablModel);
		dataTable.setBounds(0, 49, 884, 421);
		this.dataTable.validate();
		this.dataTable.repaint();
	}


	private void reloadShopTable() {
		try {
			allShop = TakeOutUtil.shopManger.loadAll();
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblShopDate = new Object[allShop.size()][BeanShopInfo.SHOP_TITLE.length];
		for(int i=0;i<allShop.size();i++) {
			for(int j=0;j<BeanShopInfo.SHOP_TITLE.length;j++) {

				tblShopDate[i][j]=allShop.get(i).getCell(j);
				System.out.println(tblShopDate.toString());
			}
		}

		tablModel.setDataVector(tblShopDate, tbShopTitle);
		dataTable.setModel(tablModel);
		dataTable.setBounds(0, 49, 884, 421);
		this.dataTable.validate();
		this.dataTable.repaint();
	}




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminMain frame = new FrmAdminMain();
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
	public FrmAdminMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(dataTable);
		menuBar.setBackground(new Color(240, 255, 240));
		menuBar.setBounds(0, 0, 884, 49);
		contentPane.add(menuBar);

		menuBar.add(menuUser);
		menuUser.add(menuItemAddUser);
		menuItemAddUser.addActionListener(this);
		menuUser.add(menuItemDeletUser);
		menuItemDeletUser.addActionListener(this);
		menuUser.add(MenuItemRefUser);

		menuBar.add(menuShop);
		menuShop.add(menuItemAddShop);
		menuItemAddShop.addActionListener(this);
		menuShop.add(menuItemDeletShop);
		menuItemDeletShop.addActionListener(this);
		menuShop.add(MenuItemRefShop);
		MenuItemRefShop.addActionListener(this);

		menuBar.add(menuRider);
		menuRider.add(MmnuItemAddRider);
		MmnuItemAddRider.addActionListener(this);
		menuRider.add(menuItemDeletRider);
		menuItemDeletRider.addActionListener(this);


		menuRider.add(MenuItemRefRider);
		menuItemDeletRider.addActionListener(this);

		menuBar.add(menuAdmin);
		menuAdmin.add(menuItemAddAdmin);
		menuItemAddAdmin.addActionListener(this);

		menuAdmin.add(menuItemDeletAdmin);
		menuItemDeletAdmin.addActionListener(this);
		menuAdmin.add(menuItemChangePwd);
		menuItemChangePwd.addActionListener(this);


		menuAdmin.add(MenuItemRefAdmin);
		MenuItemRefAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloadAdminTable();
			}

		});
		MenuItemRefUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloadUserTable();
			}

		});

		MenuItemRefRider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloadRiderTable();
			}

		});
		MenuItemRefShop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloadShopTable();	
			}
		});



		menuBar.add(mnNewMenu_5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.menuItemAddUser) {
			// TODO Auto-generated method stub
			FrmAddUser fadd= new FrmAddUser();
			fadd.setVisible(true);
		}else if (e.getSource()==this.menuItemDeletUser){
			int i = dataTable.getSelectedRow();
			BeanUserInfo sel = new BeanUserInfo();
			sel = allUser.get(i);
			if(sel==null) {
				JOptionPane.showMessageDialog(null, "为选中有效序列","警告",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				TakeOutUtil.userManger.delete(sel);
				this.reloadUserTable();
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==this.menuItemAddShop) {
			FrmAddShop fadd=new FrmAddShop();
			fadd.setVisible(true);
		}else if(e.getSource()==this.menuItemDeletShop) {
			int i = dataTable.getSelectedRow();
			BeanShopInfo sel = new BeanShopInfo();
			sel = allShop.get(i);
			if(sel==null) {
				JOptionPane.showMessageDialog(null, "为选中有效序列","警告",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				TakeOutUtil.shopManger.delete(sel);
				this.reloadShopTable();
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==this.MmnuItemAddRider) {
			FrmAddRider fadd = new FrmAddRider();
			fadd.setVisible(true);
		}else if(e.getSource()==this.menuItemDeletRider){
			int i = dataTable.getSelectedRow();
			BeanRiderInfo sel = new BeanRiderInfo();
			sel = allRider.get(i);
			System.out.println(i);
			if(sel==null) {
				JOptionPane.showMessageDialog(null, "为选中有效序列","警告",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				TakeOutUtil.riderManger.delete(sel);
//				this.reloadRiderTable();
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getSource()==this.menuItemAddAdmin) {
			FrmAddAdmin fadd = new FrmAddAdmin();
			fadd.setVisible(true);
			tablModel.fireTableDataChanged();
		}else if(e.getSource()==this.menuItemDeletAdmin) {
			int i = dataTable.getSelectedRow();
			BeanAdminInfo sel  = new BeanAdminInfo();
			sel=allAdmin.get(i);
			if (sel == null) {
				JOptionPane.showMessageDialog(null, "未选中有效的列","警告",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				TakeOutUtil.adminManger.deleteAdmin(sel);
				this.reloadAdminTable();
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(), "警告",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}else if (e.getSource()==this.menuItemChangePwd) {
			 FrmChangeAdminPassword change = new FrmChangeAdminPassword();
			 change.setVisible(true);
			 this.setVisible(false);
		}
	}
}





















