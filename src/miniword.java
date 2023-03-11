import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class miniword {
    JFrame ventana;
    JMenuBar menu;
    JMenu archivo;
    JMenu help;
    JTextArea notas;
    String nombre="res.txt";
    String ruta="C:\\Users\\cagua\\OneDrive\\Documentos\\Nueva carpeta"; //   
    JMenuItem nuevo,abrir,guardar,salir, acerca;

    public miniword(){
        ventana = new JFrame("Word");
        menu = new JMenuBar();

        archivo = new JMenu("Archivo");
        help = new JMenu("Ayuda");

        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir...");
        guardar = new JMenuItem("Guardar");
        salir = new JMenuItem("Salir");
        acerca = new JMenuItem("Acerca de...");

        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);
        help.add(acerca);
    
        menu.add(archivo);
        menu.add(help);

        ventana.setJMenuBar(menu);
        notas = new JTextArea();
        JScrollPane scrollNotas = new JScrollPane(notas);
        
        ventana.add(scrollNotas);
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                guardar();
            }
            
        });
        abrir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                abrir();
            }
        });
        nuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               notas.setText("");
            }    
        });

        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }           
        });
        acerca.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "¡ITSP Pinkie!");
            }
            
        });
    }
    public void guardar() {
      try {
        String texto = notas.getText();
        File archivo = new File(ruta+"\\"+nombre);
        FileWriter escritor = new FileWriter(archivo);
        escritor.write(texto);
        escritor.close();
    } catch (IOException e) {
    }  
    }
    
    public void abrir() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            File selectFile = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectFile)){
                String text = scanner.useDelimiter("\\A").next();
                notas.setText(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new miniword();
    }
}

