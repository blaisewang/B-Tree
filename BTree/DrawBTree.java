package BTree;

import java.awt.*;

/**
 * DataStructure
 * Created by Blaise Wang on 16/6/10.
 */
public class DrawBTree extends Frame {

    private int key;
    private MyCanvas canvas;
    private TextField keyText = new TextField(10);
    private TextField elementText = new TextField(10);

    private BTree<Integer, Double> bTree;

    public DrawBTree(BTree<Integer, Double> tree) {
        super("B-tree GUI");
        bTree = tree;
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        final int windowHeight = 720;
        final int windowWidth = 1024;
        canvas = new MyCanvas<Integer, Double>(windowWidth, windowHeight, bTree);
        Button insertButton = new Button("Insert");
        Button deleteButton = new Button("Delete");
        Label keyPrompt = new Label("key: ");
        Label elementPrompt = new Label("element: ");
        elementText.setText("0.0");

        setLayout(new FlowLayout());
        add(keyPrompt);
        add(keyText);
        add(elementPrompt);
        add(elementText);
        add(insertButton);
        add(deleteButton);
        add(canvas);

        insertButton.addActionListener(e -> insertValue());
        deleteButton.addActionListener(e -> deleteValue());
        addWindowListener(new HandleWin());
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);
        setVisible(true);
    }

    private void insertValue() {
        try {
            key = Integer.parseInt(keyText.getText());
            double element = Double.parseDouble(elementText.getText());
            keyText.setText("");
            elementText.setText("0.0");
            bTree.insert(key, element);
            canvas.repaint();
        } catch (NumberFormatException e) {
            System.out.println("Illegal input data!");
        }
    }

    private void deleteValue() {
        try {
            key = Integer.parseInt(keyText.getText());
            keyText.setText("");
            elementText.setText("0.0");
            bTree.delete(key);
            canvas.repaint();
        } catch (NumberFormatException e) {
            System.out.println("Illegal input data!");
        }
    }
}
