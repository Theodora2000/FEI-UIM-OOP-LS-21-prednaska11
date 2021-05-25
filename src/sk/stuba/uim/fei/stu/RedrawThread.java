package sk.stuba.uim.fei.stu;

import java.awt.*;

public class RedrawThread extends  Thread{
    TestFrame a;
    Color actual_color;
    int k=0;
    boolean stop;

    int x,y,dx,dy,w,h;
    final int s = 20;//rozmer gulicky

    RedrawThread(TestFrame a, Color c, int k){
        this.a = a;
        actual_color= c;
        this.k = k;

        w = this.a.getWidth()-1;
        h = this.a.getHeight()-1;

        x = w/2;
        y = s;
        dx = 1;
        dy = 15;
        stop = false;

        start();

    }

    public void run(){

        while(!stop){
            if(x+dx<s){
                dx =  -dx;
            }
            if(x>w-s-1){
                dx = -dx;
            }
            if(y+dy<s){
                dy =  20;
            }
            x+=dx;
            y+=dy;
            dy--;
            try {
                sleep(this.k);
            }catch (Exception e){

            }
            this.a.setCoordinates(x,y,actual_color);
            this.a.repaint();

        }
    }


}
