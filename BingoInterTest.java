import javax.swing.*;
import java.awt.*;

public class BingoInterTest {

    JFrame frame;
    JPanel panelBingo, panelHistorial, panelBotones;
    JTable tableBingo, tableHistorial;
    JButton botonTira;
    JLabel labelHistorialVertical, labelUltimaTira, labelTira, labelNumeroTira, labelTiraMax;

    String[] bingo = {"B", "I", "N", "G", "O"};
    String[] fals = {"-", "-", "-", "-", "-","-","-","-","-","-", "-","-","-","-","-"};
    Carta cartaTest;
    Tombola tombolaTest;

    public BingoInterTest()
    {
        tombolaTest = new Tombola();

        frame = new JFrame("Bingo");
        panelBingo = new JPanel();
        panelHistorial = new JPanel();
        panelBotones = new JPanel();

        // Crear tabla de bingo (5x15)
        tableBingo = new JTable(cartaTest.getTablaString(), bingo);
        tableBingo.setEnabled(false);
        tableBingo.setRowHeight(40); // Ajusta la altura de las filas

        // Crear tabla de historial
        tableHistorial = new JTable(tombolaTest.getTablaString(), fals);
        tableHistorial.setRowHeight(30); // Ajusta la altura de las filas
        tableHistorial.setEnabled(false);
        for (int i = 0; i < tableHistorial.getColumnCount(); i++) {
            tableHistorial.getColumnModel().getColumn(i).setPreferredWidth(20); // Ajusta el ancho de las columnas
        }

        // Botón de Tira
        botonTira = new JButton("Tira");
        botonTira.setPreferredSize(new Dimension(150, 50));
        labelHistorialVertical = new JLabel("Historial Vertical");
        labelUltimaTira = new JLabel("Última Tira");
        labelTira = new JLabel("Presiona el botón para sacar una bola");
        labelNumeroTira = new JLabel("Numero de tira");
        labelTiraMax = new JLabel("Tira maxima");

        hacerFrame();
    }

    private void hacerFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Paneles
        panelBingo.setLayout(new BorderLayout());
        panelHistorial.setLayout(new BorderLayout());
        panelBotones.setLayout(new GridBagLayout());

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(5,10,5,10);
        panelBotones.add(labelTira, gbc3);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  // Centrado en el eje X
        gbc.gridy = 10;  // Centrado en el eje Y
        gbc.insets = new Insets(20, 20, 20, 20); // Añade un espacio alrededor del botón
        panelBotones.add(botonTira, gbc);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 20;
        gbc1.insets = new Insets(20,20,20,20);
        panelBotones.add(labelUltimaTira, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 30;
        gbc2.insets = new Insets(20,20,20,20);
        panelBotones.add(labelHistorialVertical, gbc2);

        // Agregar tablas al panel correspondiente

        panelHistorial.add(new JLabel("Carta historial"), BorderLayout.NORTH);
        panelHistorial.add(new JScrollPane(tableHistorial) ,BorderLayout.CENTER);
        panelHistorial.setPreferredSize(new Dimension(frame.getWidth(), 200)); // Altura fija
        // Crear un panel de contenedor para las tablas Bingo y Carta
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
        panelIzquierda.add(new JLabel("Carta"));
        panelIzquierda.add(new JScrollPane(tableBingo));

        // Agregar paneles al frame
        frame.add(panelIzquierda, BorderLayout.WEST);
        frame.add(panelBotones, BorderLayout.CENTER);
        frame.add(panelHistorial, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setSize(1000, 500);  // Puedes ajustar el tamaño según sea necesario
        frame.setLocationRelativeTo(null);
    }
}
