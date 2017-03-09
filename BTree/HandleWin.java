package BTree;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * DataStructure
 * Created by Blaise Wang on 16/6/11.
 */
class HandleWin extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        (e.getWindow()).dispose();
        System.exit(0);
    }
}
