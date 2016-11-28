package mysocketClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientChatFrame extends JFrame{
	
	JButton jb;
	JButton jb1;
	JButton jbsend;
	JButton jbs;
	
     public ClientChatFrame(String sname)
     {
    	this.setTitle(sname);
     	this.setSize(400, 320);
     	this.setResizable(false);
     	JFrameToolkit.setCenterFrame(this);
     	init();
     	this.setListen(this);
     }

	private void init() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder("聊天窗口"));
		scrollPane.setBounds(23, 23, 250, 150);
		this.add(scrollPane);
		
		
		JScrollPane scrollPane2 = new JScrollPane();
		//设置外围边框显示的提示
		scrollPane2.setBorder(BorderFactory.createTitledBorder("在线用户"));
		//设置显示位置和大小
		scrollPane2.setBounds(280, 23, 100, 150);
		this.add(scrollPane2);
		//scrollPane.setColumnHeader();
		
		//退出聊天室按钮
		 jb=new JButton("退出聊天室");
		 jb1=new JButton("删除聊天记录");
		jbsend=new JButton("发送");
	    jbs=new JButton("单人聊天");
		jb.setBounds(23, 180, 115, 30);
		jb1.setBounds(155, 180, 115, 30);
		jbsend.setBounds(200, 220, 70, 30);
		jbs.setBounds(280,220,100,30);
		this.add(jb);
		this.add(jb1);
		this.add(jbsend);
		this.add(jbs);
		
		//发送文本框
		JTextField jtf=new JTextField(25);
		jtf.setBounds(23,220,170,30);
		this.add(jtf);
		
		//聊天窗口
		JTextArea jta=new JTextArea();
		jta.setEditable(false);
		scrollPane.setViewportView(jta);
		//jta.setSize(200, 100);
		//scrollPane.add(jta);
		//在线窗口
		JTextArea jta1=new JTextArea();
		jta1.setEditable(false);
		scrollPane2.setViewportView(jta1);
	}
	
	public void setListen(final JFrame frame)
	{
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				System.exit(0);
			}
		});
		//单独聊天监听
		jbs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//选取列表上的名字
//				String name = null;
//				if(name==null)
//				{
//					return ;
//				}
				ClientsignleFrame csf=new ClientsignleFrame("单独聊天");
				//frame.dispose();
				csf.setVisible(true);
			}
			
		});
	}
}
