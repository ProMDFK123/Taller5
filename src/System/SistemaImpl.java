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

        //iniciarSesion(window);
    }

    /**
     * Menú principal con las opciones del programa.
     * @param ventana a usar.
     */
    public void mainMenu(Ventana ventana){
        //Definición de botones y panel.
        JButton boton1,boton2,boton3,boton4,boton5;
        JPanel panel;

        //Visualización de la ventana.
        ventana.setBounds(50,20,280,200);
        ventana.setVisible(true);

        //Inicialización del panel.
        panel=new JPanel();
        panel.setBackground(Color.pink);
        ventana.setContentPane(panel);
        panel.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Inicialización de botones.
        boton1=new JButton();
        boton2=new JButton();
        boton3=new JButton();
        boton4=new JButton();
        boton5=new JButton();

        //Añadir botones
        boton1.setBounds(50,10,160,25);
        boton2.setBounds(50,40,160,25);
        boton3.setBounds(50,70,160,25);
        boton4.setBounds(50,100,160,25);
        boton5.setBounds(50,130,160,25);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        boton1.setText("Buscar Libro");
        boton2.setText("Prestar Libro");
        boton3.setText("Agregar Libro");
        boton4.setText("Devolver Libro");
        boton5.setText("Cerrar Sesión");
    }

    /**
     * Pestaña de inicio de sesión.
     * @param ventana a usar.
     */
    @Override
    public void iniciarSesion(Ventana ventana) {
        //Definición de textos, botones y el panel.
        JTextField texto1,texto2;
        JButton boton;
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
        boton=new JButton();

        //Se coloca el texto y se les da un mensaje.
        texto1.setBounds(50,10,160,25);
        panel.add(texto1);
        texto1.setText("RUT");
        texto2.setBounds(50,40,160,25);
        panel.add(texto2);
        texto2.setText("Contraseña");

        boton.setBounds(50,110,80,25);
        panel.add(boton);
        boton.setText("logIn");
    }

    @Override
    public void buscarLibro(Ventana ventana) {
        JTextField texto;
        JButton boton;
        JPanel panel;

        ventana.setBounds(50,20,280,180);
        ventana.setVisible(true);


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
