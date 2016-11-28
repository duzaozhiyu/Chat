package mysocketClient;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameToolkit {
    //private Toolkit tk=
	//设置窗体的图标
	public static void setImageIcon(String pathname,JFrame frame)
	{
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.getImage(pathname);
		frame.setIconImage(image);
	}
	
	//设置窗体居中
	public static void setCenterFrame(JFrame frame)
	{
		//获取工具类
		Toolkit tk=Toolkit.getDefaultToolkit();
		//获取屏幕宽高
		Dimension ds=tk.getScreenSize();
		double width=ds.getWidth();
		double height=ds.getHeight();
		//获取窗体的宽高
		int jwidth=frame.getWidth();
		int jheight=frame.getHeight();
		//设置窗体显示的位置
		int x=((int)width-jwidth)/2;
		int y=((int)height-jheight)/2;
		frame.setLocation(x, y);
	}

	//退出操作
	public static void exit()
	{
		System.exit(0);
	}
}
