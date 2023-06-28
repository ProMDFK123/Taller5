package System;

import List.Array.ListaElemento;
import List.Linked.ListaNodoDoble;
import Objects.Usuario;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del sistema.
 */
public class SistemaImpl implements Sistema{
    //Lista de usuarios.
    private ListaElemento usuarios;
    //Lista de libros.
    private ListaNodoDoble libros;
    //Una ventana para los JPanel.
    private Ventana window;

    private List<String> movimientos;

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
        movimientos=new ArrayList<>();
        //Lectura de archivos.
        LecturaArchivos.leerArchivoLibros(libros);
        LecturaArchivos.leerArchivoUsuarios(usuarios);

        iniciarSesion(window);
    }

    /**
     * Método que arroja un texto en una ventana emergente.
     * @param panel en donde se mostrará el mensaje.
     * @param texto a mostrar en pantalla.
     */
    public void MensajeEmergente(JPanel panel, String texto){JOptionPane.showMessageDialog(panel,texto);}

    /**
     * Menú principal con las opciones del programa.
     * @param ventana a usar.
     */
    public void mainMenu(Ventana ventana, Usuario usuario){
        while(usuario!=null) {
            //Definición de botones y panel.
            JButton boton1, boton2, boton3, boton4, boton5;
            JPanel panel;

            //Visualización de la ventana.
            ventana.setBounds(50, 20, 280, 200);
            ventana.setVisible(true);

            //Inicialización del panel.
            panel = new JPanel();
            panel.setBackground(Color.pink);
            ventana.setContentPane(panel);
            panel.setLayout(null);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Inicialización de botones.
            boton1 = new JButton();
            boton2 = new JButton();
            boton3 = new JButton();
            boton4 = new JButton();
            boton5 = new JButton();

            //Añadir botones
            boton1.setBounds(50, 10, 160, 25);
            boton2.setBounds(50, 40, 160, 25);
            boton3.setBounds(50, 70, 160, 25);
            boton4.setBounds(50, 100, 160, 25);
            boton5.setBounds(50, 130, 160, 25);
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

            //Acciones de botones.
            boton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == boton1) buscarLibro(window,usuario);
                }
            });
            boton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == boton2) prestarLibro(window,usuario);
                }
            });
            boton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == boton3) agregarLibro(window,usuario);
                }
            });
            boton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == boton4) devolverLibro(window,usuario);
                }
            });
            boton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == boton5) {
                        try {
                            cerrarPrograma(window,usuario, (ArrayList) movimientos);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
        }
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
        String error = "Credenciales Invalidas.";

        //Visibilidad de la ventana.
        ventana.setBounds(50,20,280,180);
        ventana.setVisible(true);
        ventana.setResizable(false);

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

        boton.setBounds(50,110,160,25);
        panel.add(boton);
        boton.setText("Iniciar Sesión");
    }

    /**
     * Método de busqueda de un libro.
     * @param ventana a utilizar.
     */
    @Override
    public void buscarLibro(Ventana ventana,Usuario usuario) {
        JTextField texto;
        JButton boton;
        JPanel panel;

        ventana.setBounds(50,20,280,180);
        ventana.setVisible(true);
        ventana.setResizable(false);

        panel=new JPanel();
        panel.setBackground(Color.pink);
        ventana.setContentPane(panel);
        panel.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        texto=new JTextField();
        boton=new JButton();

        texto.setBounds(50,10,160,25);
        panel.add(texto);
        texto.setText("ISBN");

        boton.setBounds(50,40,160,25);
        panel.add(boton);
        boton.setText("Buscar");
    }

    /**
     * Método para prestar un libro.
     * @param ventana a utilizar.
     */
    @Override
    public void prestarLibro(Ventana ventana,Usuario usuario) {
        JTextField texto;
        JButton boton;
        JPanel panel;

        ventana.setBounds(50,20,280,180);
        ventana.setVisible(true);
        ventana.setResizable(false);

        panel=new JPanel();
        panel.setBackground(Color.pink);
        ventana.setContentPane(panel);
        panel.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        texto=new JTextField();
        boton=new JButton();

        texto.setBounds(50,10,160,25);
        boton.setBounds(50,40,160,25);
        panel.add(texto);
        panel.add(boton);
        texto.setText("ISBN");
        boton.setText("Realizar Prestamo");
    }

    /**
     * Método para añadir un nuevo libro al stock.´
     * @param ventana a utilizar.
     */
    @Override
    public void agregarLibro(Ventana ventana,Usuario usuario) {
        JTextField t1,t2,t3,t4,t5,t6;
        JButton boton;
        JPanel panel;

        ventana.setBounds(50,20,280,280);
        ventana.setVisible(true);
        ventana.setResizable(false);

        panel=new JPanel();
        panel.setBackground(Color.pink);
        ventana.setContentPane(panel);
        panel.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();

        boton=new JButton();

        t1.setBounds(50,10,160,25);
        t2.setBounds(50,40,160,25);
        t3.setBounds(50,70,160,25);
        t4.setBounds(50,100,160,25);
        t5.setBounds(50,130,160,25);
        t6.setBounds(50,160,160,25);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(t6);
        t1.setText("ISBN");
        t2.setText("Título");
        t3.setText("Autor");
        t4.setText("Categoría");
        t5.setText("Stock");
        t6.setText("Precio");

        boton.setBounds(50,190,160,25);
        panel.add(boton);
        boton.setText("Añadir");
    }

    /**
     * Método de devolución de un libro.
     * @param ventana a usar.
     */
    @Override
    public void devolverLibro(Ventana ventana,Usuario usuario) {
        JTextField texto;
        JButton boton;
        JPanel panel;

        ventana.setBounds(50,20,280,180);
        ventana.setVisible(true);
        ventana.setResizable(false);

        panel=new JPanel();
        panel.setBackground(Color.pink);
        ventana.setContentPane(panel);
        panel.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        texto=new JTextField();

        boton=new JButton();

        texto.setBounds(50,10,160,25);
        panel.add(texto);
        texto.setText("ISBN");

        boton.setBounds(50,40,160,25);
        panel.add(boton);
        boton.setText("Devolver");
    }

    /**
     * Método para cerrar la sesión.
     */
    @Override
    public Usuario cerrarPrograma(Ventana ventana, Usuario usuario, ArrayList lista) throws IOException {
        GuardadoArchivo.guardar(lista);
        usuario=null;
        return usuario;
    }
}
