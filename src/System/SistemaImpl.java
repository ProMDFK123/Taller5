package System;

import List.Array.ListaElemento;
import List.Linked.ListaNodoDoble;

import javax.swing.*;
import java.awt.Color;

/**
 * Implementación del sistema.
 */
public class SistemaImpl implements Sistema{
    //Lista de usuarios.
    private ListaElemento usuarios;
    //Lista de libros.
    private ListaNodoDoble libros;
    private Ventana window;

    /**
     * Constructor.
     */
    public SistemaImpl() {
        menu();
    }

    /**
     * Método que implementa el programa completo.
     */
    public void menu(){
        //Inicialización de una ventana
        window = new Ventana();
        //Inicialización de listas.
        usuarios=new ListaElemento(999);
        libros=new ListaNodoDoble();
        //Lectura de archivos.
        LecturaArchivos.leerArchivoLibros(libros);
        LecturaArchivos.leerArchivoUsuarios(usuarios);

        iniciarSesion(window);

    }

    @Override
    public void iniciarSesion(Ventana ventana) {
        //Definición de textos, botones y el panel.
        JTextField texto1,texto2;
        JButton boton1,boton2;
        JPanel panel;

        //Visibilidad de la ventana.
        ventana.setBounds(50,20,280,180);
        ventana.setVisible(true);

        //Inicialización de la ventana.
        panel=new JPanel();
        panel.setBackground(Color.pink);
        ventana.setContentPane(panel);
        panel.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Inicialización de textos;
        texto1=new JTextField();
        texto2=new JTextField();

        //Inicialización de botones
        boton1=new JButton();
        boton2=new JButton();

        //Se coloca el texto y se les da un mensaje.
        texto1.setBounds(50,10,160,25);
        panel.add(texto1);
        texto1.setText("RUT");
        texto2.setBounds(50,40,160,25);
        panel.add(texto2);
        texto2.setText("Contraseña");

        boton1.setBounds(20,110,80,25);
        panel.add(boton1);
        boton1.setText("logIn");
        boton2.setBounds(180,110,80,25);
        panel.add(boton2);
        boton2.setText("Close");
    }

    @Override
    public void buscarLibro(Ventana ventana) {

    }

    @Override
    public void prestarLibro(Ventana ventana) {

    }

    @Override
    public void agregarLibro(Ventana ventana) {

    }

    @Override
    public void devolverLibro(Ventana ventana) {

    }

    @Override
    public void cerrarPrograma() {
    }
}
