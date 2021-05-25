package sk.stuba.uim.fei.stu;

import javax.swing.*;
import java.awt.*;

public class MojFrame extends JFrame {

    public MojFrame() {
        TestCanvas can = new TestCanvas();
        setSize(300,300);
        setVisible(true);
        add(can);
    }
}
