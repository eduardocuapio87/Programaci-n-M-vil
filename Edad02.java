/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.edad02;
/**
 *
 * @author eduardocuapio
 */
//Eduardo Dominguez Cuapio
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Edad02 extends JFrame implements ActionListener {
    JTextField txtEdad;
    JButton btnVerificar;
    JPanel panel01;
    JLabel etiqueta;
    
    public Edad02() {
        // Configuración de la ventana
        setTitle("Verificador de Edad");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        etiqueta = new JLabel("Ingrese su edad:");
        txtEdad = new JTextField(10);
        btnVerificar = new JButton("Verificar");
        
        btnVerificar.addActionListener(this);
        
        panel01 = new JPanel();
        panel01.add(etiqueta);
        panel01.add(txtEdad);
        panel01.add(btnVerificar);
        
        // Agregar panel a la ventana
        add(panel01);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVerificar) {
            try {
                // Recuperar la edad del campo de texto
                String edadTexto = txtEdad.getText();
                
                // Verificar si el campo está vacío
                if (edadTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, 
                        "Por favor ingrese una edad");
                    return;
                }
                
                int edad = Integer.parseInt(edadTexto);
                
                // Validar que la edad sea positiva
                if (edad < 0) {
                    JOptionPane.showMessageDialog(null, 
                        "La edad no puede ser negativa");
                } 
                else if (edad >= 18) {
                    JOptionPane.showMessageDialog(null, 
                        "MAYOR DE EDAD\n" +
                        "Edad ingresada: " + edad + " años");
                } 
                else {
                    JOptionPane.showMessageDialog(null, 
                        "MENOR DE EDAD\n" +
                        "Edad ingresada: " + edad + " años");
                }
                
                txtEdad.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error: Debe ingresar un número válido");
            }
        }
    }
    
    public static void main(String[] args) {
        Edad02 programa = new Edad02 ();
    }
}