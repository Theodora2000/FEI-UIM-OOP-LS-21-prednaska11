package sk.stuba.uim.fei.stu;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame extends Frame {
    RedrawThread a,b;
    Color c1;
    Color c2;

    int x1,y1;
    int x2,y2;

    int w,h;

    final int s = 20;

    public TestFrame(){
        setSize(500,500);
        a = new RedrawThread(this,Color.blue, 20);
        b = new RedrawThread(this,Color.magenta, 40);
        w = a.w;
        h = a.h;
        x1 = a.x;
        y1 = a.y;
        c1= a.actual_color;
        x2 = b.x;
        y2 = b.y;
        c2= b.actual_color;
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

    }

    public void setCoordinates(int x, int y, Color c) {
        if(c.equals(Color.blue)){
            x1 = x;
            y1= y;
            c1 = Color.blue;
        }
        if(c.equals(Color.magenta)){
            x2 = x;
            y2= y;
            c2 = Color.magenta;
        }
    }

    public void paint(Graphics g) {
        g.setColor(c1);
        g.fillOval(x1-s,h-y1-s,2*s,2*s);
        g.setColor(c2);
        g.fillOval(x2-s,h-y2-s,2*s,2*s);
    }
}
