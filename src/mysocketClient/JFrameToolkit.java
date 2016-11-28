package mysocketClient;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameToolkit {
    //private Toolkit tk=
	//���ô����ͼ��
	public static void setImageIcon(String pathname,JFrame frame)
	{
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.getImage(pathname);
		frame.setIconImage(image);
	}
	
	//���ô������
	public static void setCenterFrame(JFrame frame)
	{
		//��ȡ������
		Toolkit tk=Toolkit.getDefaultToolkit();
		//��ȡ��Ļ���
		Dimension ds=tk.getScreenSize();
		double width=ds.getWidth();
		double height=ds.getHeight();
		//��ȡ����Ŀ��
		int jwidth=frame.getWidth();
		int jheight=frame.getHeight();
		//���ô�����ʾ��λ��
		int x=((int)width-jwidth)/2;
		int y=((int)height-jheight)/2;
		frame.setLocation(x, y);
	}

	//�˳�����
	public static void exit()
	{
		System.exit(0);
	}
}
