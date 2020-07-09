package cn.edu.zucc.take_out.ui.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanAdminInfo;
import cn.edu.zucc.take_out.model.BeanProductClass;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanShopInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * @author: Pengkun Gu
 * @version: v1.0
 * @description: cn.edu.zucc.take_out.ui
 * @date:2020年7月7日
 */
public class FrmProduct extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tableClass = new JTable();
	private JTable tableProduct = new JTable();
	private JMenu menuClass = new JMenu("类别管理");
	private JMenuItem menuItemAddClass = new JMenuItem("添加类别");
	private JMenuItem menuItemDeletClass = new JMenuItem("删除类别");
	private JMenu menProduct = new JMenu("商品管理");
	private JMenuItem menuItemAddProduct = new JMenuItem("添加商品");
	private JMenuItem menuItemDeletProduct = new JMenuItem("删除商品");
	private JMenuBar menuBar = new JMenuBar();
	
	
	private Object tblProductClassTitle[] = BeanProductClass.PRODUCT_CLASS_TITLE;
	private Object tblProductTitle[] = BeanProductInfo.PRODUCT_TITLE;
	
	
	private Object tblProductClassDate[][];
	private Object tblProductDate[][];
	
	DefaultTableModel ProductClasstablModel = new DefaultTableModel();
	DefaultTableModel ProducttablModel = new DefaultTableModel();
	
	List<BeanProductClass> allProductClass = null;
	List<BeanProductInfo>  allProduct = null;
	
	private final JMenuItem menuItemRefreshClass = new JMenuItem("刷新");
	private final JMenuItem menuItemRefreshProduct = new JMenuItem("刷新");
	
	private BeanProductClass curClass = null;
	
	private void reloadProductClassTable() {
		try {
			allProductClass = TakeOutUtil.productClaassManager.loadAll();
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblProductClassDate = new Object[allProductClass.size()][BeanProductClass.PRODUCT_CLASS_TITLE.length];
		for(int i=0;i<allProductClass.size();i++) {
			for(int j=0;j<BeanProductClass.PRODUCT_CLASS_TITLE.length;j++) {
                tblProductClassDate[i][j]=allProductClass.get(i).getCell(j);
				System.out.println(tblProductClassDate.toString());
			}
		}
		ProductClasstablModel.setDataVector(tblProductClassDate, tblProductClassTitle);
		tableClass.setModel(ProductClasstablModel);
		this.tableClass.validate();
		this.tableClass.repaint();
	}
	
	private void reloadProductTable(int classIdx) {
		if(classIdx<0) {
			return;
		}
		curClass = allProductClass.get(classIdx);
		try {
			if(curClass==null) {
				JOptionPane.showMessageDialog(null,"为选中有效序列","警告",JOptionPane.ERROR_MESSAGE);
			}else {
			allProduct = TakeOutUtil.productManager.loadAll(curClass);
			}
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
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
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProduct frame = new FrmProduct();
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
	public FrmProduct() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 820, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		menuBar.setBounds(0, 0, 820, 22);
		contentPane.add(menuBar);
		
		menuBar.add(menuClass);
		menuClass.add(menuItemAddClass);
		menuItemAddClass.addActionListener(this);
		
		menuClass.add(menuItemDeletClass);
		menuItemDeletClass.addActionListener(this);
		
		menuClass.add(menuItemRefreshClass);
        menuItemRefreshClass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    reloadProductClassTable();
			}
		});
		
        
		menuBar.add(menProduct);
		menProduct.add(menuItemAddProduct);
		menuItemAddProduct.addActionListener(this);
		menProduct.add(menuItemDeletProduct);
		menuItemDeletProduct.addActionListener(this);
		menProduct.add(menuItemRefreshProduct);
		
		
		
		
		tableClass.setBounds(0, 21, 406, 441);
		contentPane.add(tableClass);
		tableProduct.setBounds(407, 21, 413, 441);
		contentPane.add(tableProduct);
		tableClass.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i=tableClass.getSelectedRow();
				reloadProductTable(i);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menuItemAddProduct) {
			FrmAddProduct add =  new FrmAddProduct();
			add.setVisible(true);
		}else if(e.getSource()==menuItemAddClass) {
			FrmAddProudctClass add = new FrmAddProudctClass();
			add.setVisible(true);
		}else if(e.getSource()==menuItemDeletClass) {
			int i = tableClass.getSelectedRow();
			BeanProductClass sel = new BeanProductClass();
			sel = allProductClass.get(i);
			if(sel==null) {
				JOptionPane.showMessageDialog(null, "未选中有效序列","警告",JOptionPane.ERROR_MESSAGE);				
				return;
			}
			try {
				TakeOutUtil.productClaassManager.delet(sel);
				JOptionPane.showMessageDialog(null,"成功删除一类商品","提示",JOptionPane.ERROR_MESSAGE);
				reloadProductClassTable();
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource()==menuItemDeletProduct) {
			int i = tableProduct.getSelectedRow();
			BeanProductInfo sel = new BeanProductInfo();
			sel = allProduct.get(i);
			if(sel==null) {
				JOptionPane.showMessageDialog(null, "未选中有效序列","警告",JOptionPane.ERROR_MESSAGE);				
				return;
			}
			try {
				TakeOutUtil.productManager.delet(sel);
				JOptionPane.showMessageDialog(null,"成功删除一商品","提示",JOptionPane.ERROR_MESSAGE);
				reloadProductTable(i);
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
