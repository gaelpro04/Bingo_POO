import javax.swing.*;
import java.awt.*;

public class BingoInterTest {

    JFrame frame;
    JPanel panelBingo, panelHistorial, panelBotones;
    JTable tableBingo, tableHistorial;
    JButton botonTira;
    JLabel labelHistorialVertical, labelUltimaTira;

    String[] bingo = {"B", "I", "N", "G", "O"};
    String[] fals = {"-", "-", "-", "-", "-","-","-","-","-","-", "-","-","-","-","-"};
    Carta cartaTest;
    Tombola tombolaTest;

    public BingoInterTest()
    {
        cartaTest = new Carta();
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
        for (int i = 0; i < tableHistorial.getColumnCount(); i++) {
            tableHistorial.getColumnModel().getColumn(i).setPreferredWidth(20); // Ajusta el ancho de las columnas
        }

        // Botón de Tira
        botonTira = new JButton("Tira");
        botonTira.setPreferredSize(new Dimension(150, 50));
        labelHistorialVertical = new JLabel("Historial Vertical");
        labelUltimaTira = new JLabel("Última Tira");

        hacerFrame();
    }

    private void hacerFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Paneles
        panelBingo.setLayout(new BorderLayout());
        panelHistorial.setLayout(new BorderLayout());
        panelBotones.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  // Centrado en el eje X
        gbc.gridy = 0;  // Centrado en el eje Y
        gbc.insets = new Insets(20, 20, 20, 20); // Añade un espacio alrededor del botón
        panelBotones.add(botonTira, gbc);

        // Agregar tablas al panel correspondiente
        panelBingo.add(tableBingo, BorderLayout.CENTER);
        panelHistorial.add(tableHistorial, BorderLayout.SOUTH);
        panelBotones.add(botonTira);

        // Crear un panel de contenedor para las tablas Bingo y Carta
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
        panelIzquierda.add(new JLabel("Bingo"));
        panelIzquierda.add(new JScrollPane(tableBingo));
        panelIzquierda.add(new JLabel("Carta"));
        panelIzquierda.add(new JScrollPane(tableBingo));

        // Agregar paneles al frame
        frame.add(panelIzquierda, BorderLayout.WEST);
        frame.add(panelBotones, BorderLayout.CENTER);
        frame.add(panelHistorial, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setSize(1000, 700);  // Puedes ajustar el tamaño según sea necesario
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(67,71,80));
    }
}
