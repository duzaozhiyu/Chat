package mysocketClient;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientLoginFrame extends JFrame{
    
	private JPanel jp1;
	private JPanel jp2;
	private JButton jb_in;
	private JButton jb_out;
	private JLabel  jl_IP;
	private JLabel  jl_duankou;
	private JLabel  jl_name;
	
	private JTextField jtf_IP;
	private JTextField jtf_duankou;
	private JTextField jtf_name;
	
	
    
	
	
	
	public ClientLoginFrame(String  sname)
    {
		
    	this.setTitle(sname);
    	this.setSize(296, 249);
    	this.setResizable(false);
    	init();
    	
    }

	private void init() {
		// TODO Auto-generated method stub
		JFrameToolkit.setCenterFrame(this);
    	JFrameToolkit.setImageIcon("socket.jpg", this);
    	
    	addCompent();
    	setVidaioListen(this);
    	
    	try {
			InetAddress ia=InetAddress.getLocalHost();
			jtf_IP.setText(ia.getHostAddress());
			jtf_duankou.setText("12348");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
	}
	//添加监听
	public  void setVidaioListen(final JFrame frame)
	{
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				System.exit(0);
			}
		});
		//登录监听
		jb_in.addActionListener(new ActionListener()
		{
            
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String loginname=jtf_name.getText();
				String loginIP=jtf_IP.getText().trim();
				String duankou=jtf_duankou.getText().trim();
				int d=Integer.parseInt(duankou);
				StringBuilder sb=new StringBuilder(loginname);
				sb.append("/");
				sb.append(loginIP).append("/").append(duankou);
				
				if(loginname.trim().equals(""))
				{
					JOptionPane jop=new JOptionPane();
					jop.showMessageDialog(null,"登录名不能为空");
					return ;
				}
				
//				try {
//					DatagramSocket ds=new DatagramSocket();
//					byte []buf=sb.toString().getBytes();
//					DatagramPacket dp=new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(), d);
//					ds.send(dp);
//					ds.close();
//				} catch (SocketException e1) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "服务器未开启1");
//					return;
//					//e1.printStackTrace();
//				} catch (UnknownHostException e) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "服务器未开启2");
//					return;
//					//e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//					JOptionPane.showMessageDialog(null, "服务器未开启");
//					return;
//				}
				
				//创建Socket 对象
				Socket s=null;
				try {
					s=new Socket("10.1.41.156",12348);
					BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
					bw.write(sb.toString());
					//OutputStream os=s.getOutputStream();
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "服务器未开启1");
					return ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "服务器未开启2");
					return;
				}finally{
					if(s!=null)
					{
						try {
							s.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
					
				
				ClientChatFrame ccf=new ClientChatFrame(loginname);
				ccf.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		
		//退出按键监听
		jb_out.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrameToolkit.exit();
			}
			
		});
	}
	public void addCompent()
	{
		
	    this.setLayout(null);
		jb_in=new JButton("登录");
		jb_out=new JButton("退出");
		jl_IP=new JLabel("IP地址");
		jl_duankou=new JLabel("端口");
		jl_name=new JLabel("用户名");
		jtf_IP=new JTextField();
		jtf_duankou=new JTextField();
		jtf_name=new JTextField();
		
		
		jl_name.setBounds(23, 30, 81, 34);
		this.add(jl_name);
		jtf_name.setBounds(114, 30, 143, 34);
		this.add(jtf_name);
		jl_IP.setBounds(23, 74, 81, 34);
		this.add(jl_IP);
		jtf_IP.setBounds(114, 74, 143, 34);
		this.add(jtf_IP);
		jl_duankou.setBounds(23, 114, 81, 34);
		this.add(jl_duankou);
		jtf_duankou.setBounds(114, 114, 143, 34);
		this.add(jtf_duankou);
		
		this.add(jb_in);
		jb_in.setBounds(23, 162, 108, 39);
		this.add(jb_out);
		jb_out.setBounds(154, 162, 108,39);
	}
}
