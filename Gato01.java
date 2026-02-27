//Eduardo Dominguez Cuapio - Programación movil 2809

package com.mycompany.gato01;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Gato01 extends JFrame implements ActionListener {

    JButton botones[] = new JButton[9];
    JButton btnReiniciar;
    boolean turnoX = true;
    Font fuente = new Font("Arial", 1, 60);
    JPanel pJuego, pOpciones;
    String letra;

    public Gato01() {
        setTitle("Gato");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pJuego = new JPanel();
        pJuego.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("");
            botones[i].setFont(fuente);
            botones[i].addActionListener(this);
            pJuego.add(botones[i]);
        }

        add(pJuego, BorderLayout.CENTER);

        btnReiniciar = new JButton("Reiniciar Juego");
        pOpciones = new JPanel();

        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                reiniciarJuego();
            }
        });

        pOpciones.add(btnReiniciar);
        add(pOpciones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Gato01 g01 = new Gato01();
        g01.setVisible(true);
    }

    public void actionPerformed(ActionEvent btnApretado) {

        if (turnoX) {
            letra = "X";
            turnoX = false;
        } else {
            letra = "O";
            turnoX = true;
        }

        for (int i = 0; i < botones.length; i++) {
            if (btnApretado.getSource() == botones[i]) {
                botones[i].setText(letra);
                botones[i].setEnabled(false);
            }
        }

        validarGanador();
    }

    // Aqui se valida el ganador por medio de un for y se declaran las validaciones
    public void validarGanador() {

        int[][] combinaciones = {
            {0,1,2},{3,4,5},{6,7,8}, // filas
            {0,3,6},{1,4,7},{2,5,8}, // columnas
            {0,4,8},{2,4,6}          // diagonales
        };

        for (int i = 0; i < combinaciones.length; i++) {
            String b1 = botones[combinaciones[i][0]].getText();
            String b2 = botones[combinaciones[i][1]].getText();
            String b3 = botones[combinaciones[i][2]].getText();

            if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                JOptionPane.showMessageDialog(this, "Ganó " + b1);
                desactivarBotones();
                return;
            }
        }

        // Validar empate
        boolean empate = true;
        for (int i = 0; i < botones.length; i++) {
            if (botones[i].getText().equals("")) {
                empate = false;
                break;
            }
        }

        if (empate) {
            JOptionPane.showMessageDialog(this, "Empate");
        }
    }

    // Se desactiva cuando alguno gana
    public void desactivarBotones() {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }

    // Por ultimo se reinicia el juego
    public void reiniciarJuego() {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setText("");
            botones[i].setEnabled(true);
        }
        turnoX = true;
    }
}