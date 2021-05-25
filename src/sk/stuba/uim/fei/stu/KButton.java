package sk.stuba.uim.fei.stu;

import javax.swing.*;
import java.awt.*;

public class KButton extends JButton {
    KButton(String napis){
        super(napis);
        Font font = new Font("Arial", Font.BOLD, 20);
        setPreferredSize(new Dimension(60,30));
        setFont(font);
    }

}
