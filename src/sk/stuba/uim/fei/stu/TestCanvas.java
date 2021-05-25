package sk.stuba.uim.fei.stu;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestCanvas extends Canvas implements MouseListener, MouseMotionListener {

    public ArrayList<Obdlznik> our_objects = new ArrayList<Obdlznik>();
    Obdlznik aktualnyObdlznik;
    int xpos =0, ypos=0;

    public TestCanvas(){
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xpos = e.getX();
        ypos = e.getY();
        aktualnyObdlznik = new Obdlznik(xpos, ypos, 1,1, Color.green);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        our_objects.add(aktualnyObdlznik);
        repaint();
        aktualnyObdlznik = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX();
        int dy = e.getY();
        if(aktualnyObdlznik != null){
            if( dx > xpos && dy > ypos){
                aktualnyObdlznik.width = dx - xpos;
                aktualnyObdlznik.height = dy - ypos;
                repaint();
            }
            if( dx < xpos && dy > ypos){
                aktualnyObdlznik.x = dx;
                aktualnyObdlznik.width = xpos - dx;
                aktualnyObdlznik.height =dy - ypos ;
                repaint();
            }
            if( dx > xpos && dy < ypos){
                aktualnyObdlznik.y = dy;
                aktualnyObdlznik.width = dx - xpos;
                aktualnyObdlznik.height =ypos - dy ;
                repaint();
            }
            if( dx < xpos && dy < ypos){
                aktualnyObdlznik.x = dx;
                aktualnyObdlznik.y = dy;
                aktualnyObdlznik.width = xpos -dx;
                aktualnyObdlznik.height =ypos - dy ;
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paint(Graphics g){
        for(Obdlznik a : our_objects){
            a.kresliObdlznik(g);
        }
        if(aktualnyObdlznik!=null ){
            aktualnyObdlznik.kresliObdlznik(g);
        }
    }
}
