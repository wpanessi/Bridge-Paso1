package ar.edu.unlu.bridge.graficador;

import javax.swing.*;
import java.awt.event.*;

public class DefPuntos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inicioX;
    private JTextField inicioY;
    private JTextField finX;
    private JTextField finY;
    private Integer[] respuesta = new Integer[4];

    public DefPuntos() {
        respuesta[0] = 10;
        respuesta[1] = 10;
        respuesta[2] = 20;
        respuesta[3] = 20;
        inicioX.setText(respuesta[0].toString());
        inicioY.setText(respuesta[1].toString());
        finX.setText(respuesta[2].toString());
        finY.setText(respuesta[3].toString());
        setBounds(100, 100, 250, 200);

        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    public Integer[] showDialog() {
        this.setVisible(true);
        return respuesta;
    }
    private void onOK() {
        // add your code here
        respuesta[0] = Integer.parseInt(inicioX.getText());
        respuesta[1] = Integer.parseInt(inicioY.getText());
        respuesta[2] = Integer.parseInt(finX.getText());
        respuesta[3] = Integer.parseInt(finY.getText());
        dispose();
    }

    private void onCancel() {
        respuesta[0] = -1;
        respuesta[1] = -1;
        respuesta[2] = -1;
        respuesta[3] = -1;
        dispose();
    }
}
