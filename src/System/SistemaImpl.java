package System;

import List.Array.ListaElemento;
import List.Linked.ListaNodoDoble;
import List.Linked.NodoDoble;
import Objects.Libro;
import Objects.Transferencia;
import Objects.Usuario;
import List.Elemento;

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

    private List<Transferencia> movimientos;

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
                    if (e.getSource() == boton2) prestarLibro(window, usuario);
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
                    if (e.getSource() == boton4) devolverLibro(window, usuario);
                }
            });
            boton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == boton5) {
                        try {
                            cerrarPrograma(window, (ArrayList) movimientos, libros);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
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

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut = texto1.getText();
                String clave = texto2.getText();

                Usuario auxUsser = (Usuario) usuarios.buscar(rut);

                if(auxUsser==null){
                    MensajeEmergente(panel,error);
                } else{
                    if(!auxUsser.getContrasenia().equals(clave)){
                        MensajeEmergente(panel,error);
                    }else{
                        mainMenu(window,auxUsser);
                    }
                }
            }
        });
    }

    /**
     * Método de busqueda de un libro.
     * @param ventana a utilizar.
     */
    @Override
    public void buscarLibro(Ventana ventana, Usuario usuario) {
        JTextField texto;
        JButton boton;
        JButton boton2;
        JPanel panel;
        String notFound = "No se ha encontrado el libro.";
        String error = "ISBN inválida.";

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
        boton2=new JButton();

        texto.setBounds(50,10,160,25);
        panel.add(texto);
        texto.setText("ISBN");

        boton.setBounds(50,40,160,25);
        boton2.setBounds(50,70,160,25);
        panel.add(boton);
        panel.add(boton2);
        boton.setText("Buscar");
        boton2.setText("Volver");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String auxISBN = texto.getText();

                if(auxISBN==null){
                    MensajeEmergente(panel,error);
                }else {
                    Libro libro = (Libro) libros.getElemento(auxISBN);

                    if(libro==null){
                        MensajeEmergente(panel,notFound);
                    }else {
                        String titulo = libro.getTitulo();
                        String autor = libro.getAutor();
                        String categoria = libro.getCategoria();
                        String copias = String.valueOf(libro.getStock());

                        StringBuilder bookInfo = new StringBuilder();
                        bookInfo.append("Título: "+titulo+"\n");
                        bookInfo.append("Autor: "+autor+"\n");
                        bookInfo.append("Categoría: "+categoria+"\n");
                        bookInfo.append("Unidades disponibles: "+copias+"\n");

                        MensajeEmergente(panel,bookInfo.toString());
                    }
                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu(ventana,usuario);
            }
        });
    }

    /**
     * Método para prestar un libro.
     * @param ventana a utilizar.
     */
    @Override
    public void prestarLibro(Ventana ventana, Usuario usuario) {
        JTextField texto;
        JButton boton;
        JButton boton1;
        JPanel panel;
        String success = "El préstamo se realizó correctamente.";
        String error = "ISBN Inválido.";
        String notFound = "Libro no existe.";
        String outOfStock = "No hay copias disponibles para este libro.";

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
        boton1=new JButton();

        texto.setBounds(50,10,160,25);
        boton.setBounds(50,40,160,25);
        boton1.setBounds(50,70,160,25);
        panel.add(texto);
        panel.add(boton);
        panel.add(boton1);
        texto.setText("ISBN");
        boton.setText("Realizar Préstamo");
        boton1.setText("Volver");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String auxISBN = texto.getText();

                if(auxISBN==null){
                    MensajeEmergente(panel,error);
                }else {
                    Libro libro = (Libro) libros.getElemento(auxISBN);

                    if(libro==null){
                        MensajeEmergente(panel,notFound);
                    }else {
                        if(libro.getStock()==0){
                            MensajeEmergente(panel,outOfStock);
                        }else {
                            libro.setStock(libro.getStock()-1);
                            Transferencia prestamo = new Transferencia(usuario.getRut(), usuario.getNombre(),usuario.getApellido(), libro.getIsbn(), libro.getTitulo(),"prestamo");
                            movimientos.add(prestamo);
                            MensajeEmergente(panel,success);
                        }
                    }
                }
            }
        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu(ventana, usuario);
            }
        });
    }

    /**
     * Método para añadir un nuevo libro al stock.´
     * @param ventana a utilizar.
     */
    @Override
    public void agregarLibro(Ventana ventana, Usuario usuario) {
        JTextField t1,t2,t3,t4,t5,t6;
        JButton boton;
        JButton boton2;
        JPanel panel;
        String error = "Alguno de los campos es invalido";
        String success = "Se añadió el libro correctamente.";
        String exist = "El libro a agregar ya existe.";

        ventana.setBounds(50,20,280,310);
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
        boton2=new JButton();

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
        boton2.setBounds(50,210,160,25);
        panel.add(boton2);
        boton2.setText("Volver");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = t1.getText();
                String titulo = t2.getText();
                String autor = t3.getText();
                String categoria = t4.getText();
                int stock = Integer.parseInt(t5.getText());
                int precio = Integer.parseInt(t6.getText());

                if(isbn==null || titulo==null || autor==null || categoria==null){
                    MensajeEmergente(panel,error);
                } else if (isbn.equals("ISBN") || titulo.equals("Título") || autor.equals("Autor") || categoria.equals("Categoría") || stock<=0 || precio<=0) {
                    MensajeEmergente(panel,error);
                } else {
                    Libro newLibro = new Libro(isbn,titulo,autor,categoria,stock,precio);

                    if(libros.contiene(newLibro)){
                        MensajeEmergente(panel,exist);
                    }else {
                        libros.agregar(newLibro);
                        MensajeEmergente(panel,success);
                    }
                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu(ventana,usuario);
            }
        });
    }

    /**
     * Método de devolución de un libro.
     * @param ventana a usar.
     */
    @Override
    public void devolverLibro(Ventana ventana, Usuario usuario) {
        JTextField texto;
        JButton boton;
        JButton boton1;
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
        boton1=new JButton();

        texto.setBounds(50,10,160,25);
        panel.add(texto);
        texto.setText("ISBN");

        boton.setBounds(50,40,160,25);
        boton1.setBounds(50,70,160,25);
        panel.add(boton);
        panel.add(boton1);
        boton.setText("Devolver");
        boton1.setText("Volver");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = texto.getText();

                if(str==null || str.equals("ISBN")){
                    MensajeEmergente(panel,"ISBN ingresado es invalido.");
                }else {
                    Libro aux = (Libro) libros.getElemento(str);

                    if(aux==null){
                        MensajeEmergente(panel,"Libro no existe.");
                    }else {
                        aux.setStock(aux.getStock()+1);
                        Transferencia devolucion = new Transferencia(usuario.getRut(), usuario.getNombre(), usuario.getApellido(), aux.getIsbn(), aux.getTitulo(),"devolucion");
                        movimientos.add(devolucion);
                        MensajeEmergente(panel,"La devolución fue exitosa");
                    }
                }
            }
        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu(ventana,usuario);
            }
        });
    }

    /**
     * Método para cerrar el programa.
     * @param ventana a usar.
     * @param lista1 - una lista a actualizar.
     * @param lista2 - otra lista a actualizar.
     * @throws IOException en caso de error.
     */
    @Override
    public void cerrarPrograma(Ventana ventana, ArrayList lista1, ListaNodoDoble lista2) throws IOException {
        ArrayList<Elemento> librosArray = toArray(lista2);

        GuardadoArchivo.guardar(lista1,"reservas.txt");
        GuardadoArchivo.guardar(librosArray,"libros.txt");
        System.exit(0);
    }

    /**
     * Método auxiliar para pasar una ListaNodoDoble a ArrayList
     * @param lista a convertir a ArrayList
     * @return la lista en ArrayList
     */
    public ArrayList toArray(ListaNodoDoble lista){
        ArrayList<Elemento> list = new ArrayList<>();

        for(NodoDoble aux=lista.getCabeza(); aux!=null; aux=aux.getSiguiente()){
            list.add(aux.getElemento());
        }

        return list;
    }
}
