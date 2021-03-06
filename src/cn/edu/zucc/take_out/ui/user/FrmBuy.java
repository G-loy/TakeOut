package cn.edu.zucc.take_out.ui.user;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanOrderInfo;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanProductOrder;
import cn.edu.zucc.take_out.model.BeanUserInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui.user
 * @date:2020年7月9日
 */
public class FrmBuy extends JFrame implements ActionListener {

	private JPanel contentPane;
	JMenuItem menuItemBuyNow = new JMenuItem("立刻购买");
	JMenuItem menuItemAddToShoppingCar = new JMenuItem("加入购物车");
	JMenuItem menuItemRefresh = new JMenuItem("刷新");
	JMenuItem menuItemDeletProduct = new JMenuItem("删除商品");
	JMenuItem menuItemChangeNumber = new JMenuItem("修改数量");
	JMenuItem menuItemCheckOut = new JMenuItem("结账");
	JMenuItem menuItemRefresh2 = new JMenuItem("刷新");

	private Object tblProductTitle[] = BeanProductInfo.PRODUCT_TITLE;
	private Object tblProductOrderTilte[] = BeanProductOrder.PRODUCTORDER_TITLE;
	
	
	private Object tblProductDate[][];
	private Object tblProductOrderDate[][];
	
	DefaultTableModel ProducttablModel = new DefaultTableModel();
	
	
	List<BeanProductInfo>  allProduct = null;
	List<BeanProductOrder> allProductOrder = null;
	
	private JTable tableProduct = new JTable();;

	JScrollPane crollpane = new JScrollPane();
	private final JMenu mnNewMenu_2 = new JMenu("已买到的商品");
	private final JMenuItem mntmNewMenuItem = new JMenuItem("查看已买到的商品");
	private final JMenuItem mntmNewMenuItem_1 = new JMenuItem("评价");
	public static BeanProductInfo curProduct=null;
	public static BeanOrderInfo curOrder = null;
	public static BeanProductOrder curProductOrder = null;
	private final JMenuItem mntmNewMenuItem_2 = new JMenuItem("查看订单");
	private final JMenuItem mntmNewMenuItem_3 = new JMenuItem("确认收货");
	
	

	private void reloadProductTable() {
		try {
			allProduct = TakeOutUtil.productManager.loadAll();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showInternalMessageDialog(null, e.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
		}
		tblProductDate = new Object[allProduct.size()][BeanProductInfo.PRODUCT_TITLE.length];
		for(int i=0;i<allProduct.size();i++) {
			for(int j=0;j<BeanProductInfo.PRODUCT_TITLE.length;j++) {
				tblProductDate[i][j]=allProduct.get(i).getCell(j);
				System.out.println(tblProductDate.toString());
			}
		}
		ProducttablModel.setDataVector(tblProductDate, tblProductTitle);
		tableProduct.setModel(ProducttablModel);
		this.tableProduct.validate();
		this.tableProduct.repaint();
		tableProduct.setBounds(0, 48, 1200, 613);
		crollpane.setViewportView(tableProduct);
	}
	
	
	private void reloadProductOrderTable() {
		try {
			allProductOrder = TakeOutUtil.productOrderManager.loadALL(BeanUserInfo.currentLoginUser);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showInternalMessageDialog(null, e.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
		}
		tblProductOrderDate = new Object[allProductOrder.size()][BeanProductOrder.PRODUCTORDER_TITLE.length];
		for(int i=0;i<allProductOrder.size();i++) {
			for(int j=0;j<BeanProductOrder.PRODUCTORDER_TITLE.length;j++) {
				tblProductOrderDate[i][j]=allProductOrder.get(i).getCell(j);
				System.out.println(tblProductOrderDate.toString());
			}
		}
		ProducttablModel.setDataVector(tblProductOrderDate, tblProductOrderTilte);
		tableProduct.setModel(ProducttablModel);
		this.tableProduct.validate();
		this.tableProduct.repaint();
		tableProduct.setBounds(0, 48, 1200, 613);
		crollpane.setViewportView(tableProduct);
	}




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuy frame = new FrmBuy();
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
	public FrmBuy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1200, 48);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("商品选购界面");
		menuBar.add(mnNewMenu);
		mnNewMenu.add(menuItemBuyNow);
		mnNewMenu.add(menuItemAddToShoppingCar);
		mnNewMenu.add(menuItemRefresh);
		menuItemRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloadProductTable();
			}
		});

		JMenu mnNewMenu_1 = new JMenu("购物车");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.add(menuItemDeletProduct);
		mnNewMenu_1.add(menuItemChangeNumber);
		mnNewMenu_1.add(menuItemCheckOut);
		mnNewMenu_1.add(menuItemRefresh2);

		menuBar.add(mnNewMenu_2);

		mnNewMenu_2.add(mntmNewMenuItem);
		
		mnNewMenu_2.add(mntmNewMenuItem_2);
        mntmNewMenuItem_2.addActionListener(this);
		
		mnNewMenu_2.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_1);
	    mntmNewMenuItem_1.addActionListener(this);
		crollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		crollpane.setBounds(0, 48, 1200, 613);
		contentPane.add(crollpane);
		reloadProductTable();
		
		menuItemBuyNow.addActionListener(this);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menuItemBuyNow) {

			if(tableProduct.getSelectedRow()>=0) {
				curProduct = allProduct.get(tableProduct.getSelectedRow());
			}else {
				JOptionPane.showMessageDialog(null, "为选中有效序列", "警告", JOptionPane.ERROR_MESSAGE);
			}
			FrmOrder order = new FrmOrder();
			order.setVisible(true);
		}else if(e.getSource()==mntmNewMenuItem_2) {
			reloadProductOrderTable();
		}else if(e.getSource()==mntmNewMenuItem_3) {
			curProductOrder=allProductOrder.get(tableProduct.getSelectedRow());
			try {
				TakeOutUtil.productOrderManager.receive(curProductOrder);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
			    JOptionPane.showMessageDialog(null, e1.getMessage(), "警告",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==mntmNewMenuItem_1) {
			curProductOrder=allProductOrder.get(tableProduct.getSelectedRow());
			FrmEvaluation evaluation = new FrmEvaluation();
			evaluation.setVisible(true);
			
		}
	}
}


