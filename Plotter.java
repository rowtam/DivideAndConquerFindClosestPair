import java.awt.*;
import java.awt.event.*;

public class Plotter extends Frame {
  static int count = 0;
  Font f = new Font("helvetica",Font.PLAIN,10);
  XYPoint[] p;
  int minX,minY,maxX,maxY;
  boolean numbered;
  String title;
  
  public Plotter(XYPoint[] p, int minX, int minY, int maxX, int maxY,
                                              boolean numbered, String title){
    super(title);
    this.p = p;
    this.minX = minX; this.minY = minY;
    this.maxX = maxX; this.maxY = maxY;
    this.numbered = numbered;
    this.title = title;
    setSize(400,400);
    count++;
    addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
	      if (--count == 0) System.exit(0);
	      e.getWindow().dispose();
            }
        });
    show();
  }

  public void paint(Graphics g) {
    if (p != null){
      g.setFont(f);
      g.drawString(title,5,40);
      int i=0;
      while (i < p.length){
	if (p[i]!=null){
	  g.setColor(p[i].color);
	  int width = getBounds().width-25;
	  int height = getBounds().height-45;
	  int x = 7+(p[i].x-minX)*width/(maxX-minX);
	  int y = height + 35 - (p[i].y-minY)*height/(maxY-minY);
	  if (numbered)
	    g.drawString(""+i,x+1,y-1);
	    g.drawRect(x,y,1,1);
	}
	i++;
      }
    }
  }
}
      
