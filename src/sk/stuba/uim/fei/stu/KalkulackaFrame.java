package sk.stuba.uim.fei.stu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulackaFrame extends JFrame implements ActionListener, KeyListener {

    JTextField displej;
    int vysledok;
    int cislo;
    boolean ukazany_vysledok;
    String operacia;
    String zobrazene;

    KButton[] cislice= new KButton[10];
    KButton scitanie;
    KButton odcitanie;
    KButton nasobenie;
    KButton rovnasa;
    KButton reset;
    KButton znamienko;

    public KalkulackaFrame(){
        super("Kalulacka");
        vysledok = 0;
        cislo = 0;
        ukazany_vysledok =  false;
        operacia = "+";
        zobrazene="";
        displej = new JTextField(10);
        Font font1 = new Font("Arial", Font.BOLD, 20);
        displej.setSize(150, 20);
        displej.setFont(font1);
        displej.setHorizontalAlignment(JTextField.RIGHT);
        displej.setEditable(false);
        JPanel p0 = new JPanel();
        p0.add(displej);
        add(p0);

        JPanel p1 = new JPanel();
        setLayout(new GridLayout(0,1));

        for(int i=0;i<10;i++){

            cislice[i] = new KButton(Integer.toString(i));
            cislice[i].addActionListener(this);

            scitanie = new KButton("+");
            scitanie.addActionListener(this);

            odcitanie = new KButton("-");
            odcitanie.addActionListener(this);

            nasobenie = new KButton("*");
            nasobenie.addActionListener(this);

            rovnasa = new KButton("=");
            rovnasa.addActionListener(this);

            reset = new KButton("C");
            reset.addActionListener(this);

            znamienko = new KButton("-/+");
            znamienko.addActionListener(this);


        }

        p1.add(cislice[0]);
        p1.add(znamienko);
        p1.add(reset);
        p1.add(rovnasa);

        JPanel p2 = new JPanel();
        p2.add(cislice[1]);
        p2.add(cislice[2]);
        p2.add(cislice[3]);
        p2.add( scitanie);

        JPanel p3 = new JPanel();
        p3.add(cislice[4]);
        p3.add(cislice[5]);
        p3.add(cislice[6]);
        p3.add( odcitanie);

        JPanel p4 = new JPanel();
        p4.add(cislice[7]);
        p4.add(cislice[8]);
        p4.add(cislice[9]);
        p4.add( nasobenie);

        add(p1);
        add(p2);
        add(p3);
        add(p4);

        displej.addKeyListener(this);
        setSize(300,300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String bla = e.getActionCommand();
        akcia(bla);
    }



    @Override
    public void keyTyped(KeyEvent e) {
        String bla = Character.toString(e.getKeyChar());
        akcia(bla);
    }

    private void akcia(String bla) {
        if((bla.compareTo("0")>=0) && (bla.compareTo("9")<=0)){
            if(ukazany_vysledok == true){
                zobrazene = bla;
            }else{
                zobrazene = zobrazene + bla;
            }
            ukazany_vysledok = false;
            cislo = Integer.parseInt(zobrazene);
            displej.setText(zobrazene);
        }
        if(bla.equals("-/+")){
            if(ukazany_vysledok == false){
                cislo = -cislo;
                zobrazene = Integer.toString(cislo);
            }
            else{
                vysledok = -vysledok;
                zobrazene = Integer.toString(vysledok);
            }
            displej.setText(zobrazene);
        }
        if(bla.equals("C")){
            ukazany_vysledok = false;
            cislo = 0;
            zobrazene="";
            vysledok=0;
            operacia="+";
            displej.setText(zobrazene);

        }
        if(bla.equals("+") || bla.equals("*") || bla.equals("-") || bla.equals("=")){

            if(operacia.equals("+")){
                vysledok = vysledok + cislo;
            }
            if(operacia.equals("-")){
                vysledok = vysledok - cislo;
            }
            if(operacia.equals("*")){
                vysledok = vysledok * cislo;
            }
            zobrazene = Integer.toString(vysledok);
            ukazany_vysledok = true;
            operacia = bla;
            displej.setText(zobrazene);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
