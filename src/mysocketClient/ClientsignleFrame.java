package mysocketClient;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientsignleFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea jta;
	JTextField jtf=null;
	JButton jbt=null;
	 public ClientsignleFrame(String sname)
     {
    	this.setTitle(sname);
     	this.setSize(400, 350);
     	//this.setResizable(false);
     	JFrameToolkit.setCenterFrame(this);
     	init();
     	this.setListen();
     }

	private void setListen() {
		// TODO Auto-generated method stub
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				System.exit(0);
			}
		});
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		//������Χ�߿���ʾ����ʾ
		scrollPane2.setBorder(BorderFactory.createTitledBorder("�����¼"));
		//������ʾλ�úʹ�С
		scrollPane2.setBounds(13, 13, 350, 250);
		this.add(scrollPane2);
		
		
		//��¼�������ݵ��ı�
		jta=new JTextArea();
		jta.setEnabled(false);
		//jta.setBounds(23,23,300,250);
		scrollPane2.setViewportView(jta);
		
		//��Ϣ���͸������
		jtf=new JTextField(20);
		jtf.setBounds(13, 270, 250, 30);
		this.add(jtf);
		//���Ͱ�ť
		jbt=new JButton("����");
		jbt.setBounds(270, 270, 90, 30);
		this.add(jbt);
		
	}

}
