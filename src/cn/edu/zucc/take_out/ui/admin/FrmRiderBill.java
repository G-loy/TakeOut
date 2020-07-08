package cn.edu.zucc.take_out.ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.take_out.TakeOutUtil;
import cn.edu.zucc.take_out.model.BeanProductInfo;
import cn.edu.zucc.take_out.model.BeanRiderIncome;
import cn.edu.zucc.take_out.model.BeanRiderInfo;
import cn.edu.zucc.take_out.util.BaseException;

import javax.swing.JToolBar;
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
public class FrmRiderBill extends JFrame implements ActionListener {

	private JPanel contentPane;
	private	JMenuBar menuBar = new JMenuBar();
	private JMenu mnNewMenu = new JMenu("骑手管理");
	private JMenuItem menuItemAddRider =  new JMenuItem("添加骑手");
	private JMenuItem menuItemDeleteRider = new JMenuItem("删除骑手");
	private JMenuItem menuItemRefresh = new JMenuItem("刷新");
	
	private JMenu mnNewMenu_1 = new JMenu("账单管理");
	private JMenuItem menuItemDeletBill = new JMenuItem("删除账单");
	
	private final JTable dataTable = new JTable();
	private final JTable table_1 = new JTable();
	
	private Object tbRiderTitle[] = BeanRiderInfo.Rider_TITLE;
    private Object tbIncomeTitle[] = BeanRiderIncome.BEAN_RIDER_INCOME;
	
	DefaultTableModel tablRiderModel = new DefaultTableModel();
	DefaultTableModel tablIncomeModer = new DefaultTableModel();
	
	private Object tblRiderDate[][];
	private Object tblRiderIncomeDate[][];
	
	List<BeanRiderInfo> allRider = null;
	List<BeanRiderIncome> allIncom = null;
	
	BeanRiderInfo curRider = null;
	
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

		tablRiderModel.setDataVector(tblRiderDate, tbRiderTitle);
		dataTable.setModel(tablRiderModel);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	
	private void reloadIncomeTable(int riderIdx) {
		if(riderIdx<0) {
			return;
		}
		curRider = allRider.get(riderIdx);
		try {
			allIncom = TakeOutUtil.riderIncomeManager.loadAll(curRider);
		}catch(BaseException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblRiderIncomeDate = new Object[allIncom.size()][BeanRiderIncome.BEAN_RIDER_INCOME.length];
		for(int i=0;i<allIncom.size();i++) {
			for(int j=0;j<BeanRiderIncome.BEAN_RIDER_INCOME.length;j++) {
                tblRiderIncomeDate[i][j]=allIncom.get(i).getCell(j);
				System.out.println(tblRiderIncomeDate.toString());
			}
		}
		tablIncomeModer.setDataVector(tblRiderIncomeDate, tbIncomeTitle);
		table_1.setModel(tablIncomeModer);
		table_1.validate();
		table_1.repaint();
        System.out.println("骑手账单已经刷新"+"骑手ID"+curRider.getRiderId());
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRiderBill frame = new FrmRiderBill();
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
	public FrmRiderBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		menuBar.setBounds(0, 0, 824, 36);
		contentPane.add(menuBar);

		menuBar.add(mnNewMenu);
		
		
		mnNewMenu.add(menuItemAddRider);
		menuItemAddRider.addActionListener(this);
		
		mnNewMenu.add(menuItemDeleteRider);
		menuItemDeleteRider.addActionListener(this);
		
		mnNewMenu.add(menuItemRefresh);
		menuItemRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloadRiderTable();
			}
		});
		
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.add(menuItemDeletBill);
		dataTable.setBounds(0, 37, 384, 470);
		
		contentPane.add(dataTable);
		dataTable.addMouseListener(new MouseListener() {
			
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
				int i=dataTable.getSelectedRow();
				reloadIncomeTable(i);
			}
		});
		
		
		table_1.setBounds(384, 35, 440, 472);
		contentPane.add(table_1);
		menuItemDeletBill.addActionListener(this);
		reloadRiderTable();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	   if(e.getSource()==menuItemAddRider) {
		   FrmAddRider fadd = new FrmAddRider();
		   fadd.setVisible(true);
	   }else if(e.getSource()==menuItemDeleteRider){
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
				reloadRiderTable();
			}catch(BaseException e1) {
				JOptionPane.showMessageDialog(null,e1.getMessage(),"警告",JOptionPane.ERROR_MESSAGE);
			}
	   }
	}
}
