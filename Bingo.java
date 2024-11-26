import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Bingo implements Juego {

    //ATRIBUTOS DE JUEGO
    private Jugador jugador;
    private Tombola tombola;
    private CartaPatrones cartaPatrones;
    private Carta cartaPatronSeleccionada;
    private boolean bandera;
    private int numeroBola;

    //ATRIBUTOS DE INTERFAZ JUEGO
    private JFrame frame;
    private JPanel panelBingo, panelHistorial, panelBotones, panelBotonesCen, panelBotonesInf, panelBotonesSup, panelPrincipal;
    private JPanel panelBotonesSupIzq, panelBotonesSupCen, panelBotonesSupDer;
    private JTable tableBingo, tableHistorial;
    private JButton botonTira;
    private JLabel labelHistoriaVertical, labelUltimaTiraCont, labelTira, labelUltimaTira, labelNombre, labelNumTiras;
    private  JLabel labelNumMaxTiras, labelPatron;

    //ATRIBUTOS DE INTERFAZ TEMP
    private JFrame frameTemp;
    private JTextField lecturaNombre;

    //ATRIBUTOS DE INTERFAZ MENU PATRONES
    private JFrame frameMenu;
    private JPanel panelMenu;
    private ArrayList<JButton> buttonsPatrones;
    private JLabel labelEscogePatron;

    public Bingo()
    {
        bandera = false;
        tombola = new Tombola();
        cartaPatrones = new CartaPatrones();
        numeroBola = -1;

        hacerFrameTemp();
    }

    private void hacerFrameTemp()
    {
        //FRAME DE PARAMETROS
        frameTemp = new JFrame("Bingo");
        frameTemp.setLayout(new BorderLayout());
        frameTemp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panelTemp = new JPanel(new FlowLayout(FlowLayout.CENTER,5,10));
        JLabel labelPedirNombre = new JLabel("Ingresa tu nombre");
        lecturaNombre = new JTextField();
        lecturaNombre.setPreferredSize(new Dimension(150,30));
        lecturaNombre.addActionListener(nombre -> lecturaNombre());

        panelTemp.add(labelPedirNombre);
        panelTemp.add(lecturaNombre);
        frameTemp.add(panelTemp);
        frameTemp.setSize(400,100);
        frameTemp.setLocationRelativeTo(null);
        frameTemp.setVisible(true);
    }

    private void hacerFrame()
    {
        //INICIALIZACIÓN DE ATRIBUTOS SWING
        String[] bingo = {"B", "I", "N", "G", "O"};
        String[] titleColumHistorial = {"-", "-", "-", "-", "-","-","-","-","-","-", "-","-","-","-","-"};

        frame = new JFrame("Bingo");
        panelBingo = new JPanel();
        panelHistorial = new JPanel();
        panelBotones = new JPanel();
        panelBotonesCen = new JPanel();
        panelBotonesInf = new JPanel();
        panelBotonesSup = new JPanel();
        panelBotonesSupCen = new JPanel();
        panelBotonesSupIzq = new JPanel();
        panelBotonesSupDer = new JPanel();
        panelPrincipal = new JPanel();
        botonTira = new JButton("Tira");
        labelHistoriaVertical = new JLabel("Historial vertical");
        labelUltimaTira = new JLabel("Bola actual: ");
        labelUltimaTiraCont = new JLabel("-ultima tira-");
        labelTira = new JLabel("Presiona el botón para sacar una bola");
        labelNombre = new JLabel(jugador.getNombre());
        labelNumTiras = new JLabel("1");
        labelNumMaxTiras = new JLabel("20");

        //DESARROLLO DE INTERFAZ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panelPrincipal.setLayout(new BorderLayout());
        panelBingo.setLayout(new BoxLayout(panelBingo, BoxLayout.Y_AXIS));
        panelHistorial.setLayout(new BorderLayout());
        panelBotones.setLayout(new BorderLayout());
        panelBotonesCen.setLayout(new GridBagLayout());
        panelBotonesSup.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        panelBotonesSupIzq.setLayout(new FlowLayout(FlowLayout.RIGHT,10,5));
        panelBotonesSupCen.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
        panelBotonesSupDer.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        panelBotonesInf.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));

        tableBingo = new JTable(jugador.getCartaJugador().getTablaString(), bingo);
        tableBingo.setEnabled(false);
        tableBingo.setRowHeight(40);
        configurarRenderizadorTB();

        panelBingo.add(new JScrollPane(tableBingo));

        tableHistorial = new JTable(tombola.getTablaString(), titleColumHistorial);
        tableHistorial.setRowHeight(30);
        tableHistorial.setEnabled(false);
        configurarRenderizadorTH();

        panelHistorial.add(new JScrollPane(tableHistorial), BorderLayout.CENTER);
        panelHistorial.setPreferredSize(new Dimension(frame.getWidth(), 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,10,5,10);
        panelBotonesCen.add(labelTira, gbc);

        botonTira.setPreferredSize(new Dimension(100,50));
        botonTira.addActionListener(tira -> tirar());
        gbc.gridx = 0;
        gbc.gridy = 10;
        panelBotonesCen.add(botonTira, gbc);

        labelHistoriaVertical.setBackground(Color.WHITE);
        labelHistoriaVertical.setOpaque(true);
        labelHistoriaVertical.setPreferredSize(new Dimension(150,20));

        labelUltimaTiraCont.setBackground(Color.WHITE);
        labelUltimaTiraCont.setOpaque(true);
        labelUltimaTiraCont.setPreferredSize(new Dimension(50,20));

        labelNumTiras.setBackground(Color.WHITE);
        labelNumTiras.setOpaque(true);
        labelNumTiras.setPreferredSize(new Dimension(50, 20));

        panelBotonesInf.setOpaque(true);
        panelBotonesInf.setBorder(new LineBorder(new Color(205, 205, 205),1));
        panelBotonesInf.add(labelUltimaTiraCont,FlowLayout.LEFT);
        panelBotonesInf.add(labelUltimaTira, FlowLayout.LEFT);
        panelBotonesInf.add(labelHistoriaVertical);

        panelBotonesSupIzq.setOpaque(true);
        panelBotonesSupIzq.setBorder(new LineBorder(new Color(205, 205, 205),1));
        panelBotonesSupIzq.add(labelNumTiras);
        panelBotonesSupIzq.add(new JLabel("Numero de tira:"), FlowLayout.LEFT);
        panelBotonesSupIzq.add(labelNombre, FlowLayout.LEFT);

        panelBotonesSupCen.setOpaque(true);
        panelBotonesSupCen.setBorder(new LineBorder(new Color(205, 205, 205),1));
        panelBotonesSupCen.add(labelNumMaxTiras);
        panelBotonesSupCen.add(new JLabel("Tiras máximas: "), FlowLayout.LEFT);


        ImageIcon originalIcon = new ImageIcon(cartaPatronSeleccionada.getRutaImagen());
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        labelPatron = new JLabel(resizedIcon);
        panelBotonesSupDer.setOpaque(true);
        panelBotonesSupDer.setBorder(new LineBorder(new Color(205, 205, 205),1));
        panelBotonesSupDer.add(labelPatron);

        panelBotonesSup.setOpaque(true);
        panelBotonesSup.setBorder(new LineBorder(new Color(205, 205, 205),1));
        panelBotonesSup.add(panelBotonesSupIzq);
        panelBotonesSup.add(panelBotonesSupCen);
        panelBotonesSup.add(panelBotonesSupDer);

        panelBotones.add(panelBotonesSup, BorderLayout.NORTH);
        panelBotones.add(panelBotonesCen,BorderLayout.CENTER);
        panelBotones.add(panelBotonesInf, BorderLayout.SOUTH);


        panelPrincipal.add(panelBingo, BorderLayout.WEST);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(panelHistorial, BorderLayout.SOUTH);

        frame.add(panelPrincipal, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
    }

    private void hacerFramePatron()
    {
        frameMenu = new JFrame("Bingo");
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setLayout(new BorderLayout());

        panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(7,6,10,10));
        labelEscogePatron = new JLabel("Hola " + jugador.getNombre() + ", escoge el patrón para ganar");
        labelEscogePatron.setFont(new Font("SansSerif", Font.BOLD, 32));
        ArrayList<Carta> cartaPatronesMenu = new CartaPatrones().getCartaPatrones();
        buttonsPatrones = new ArrayList<>(38);

        for (int i = 0;i < cartaPatronesMenu.size(); ++i) {
            buttonsPatrones.add(new JButton(cartaPatronesMenu.get(i).getTablaImagen()));
            int finalI = i;
            buttonsPatrones.get(i).addActionListener(boton -> lecturaPatron(finalI));
            buttonsPatrones.get(i).setFocusPainted(false);  // Desactiva el efecto de selección
            buttonsPatrones.get(i).setContentAreaFilled(false); // Desactiva el fondo del botón
            buttonsPatrones.get(i).setOpaque(false);
            panelMenu.add(buttonsPatrones.get(i));
        }

        JPanel panelMenuSup = new JPanel(new BorderLayout());
        panelMenuSup.setPreferredSize(new Dimension(frameMenu.getWidth(), 70));
        panelMenuSup.add(labelEscogePatron, BorderLayout.CENTER);

        frameMenu.add(panelMenuSup, BorderLayout.NORTH);
        frameMenu.add(new JScrollPane(panelMenu), BorderLayout.CENTER);
        frameMenu.setSize(800,800);
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setVisible(true);
    }

    private void configurarRenderizadorTB()
    {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Personalizar celdas específicas
                if (!jugador.getCartaJugador().getTablaLogica()[row][column]) {
                    cell.setBackground(new Color(59,131,189));
                } else {
                    cell.setBackground(Color.WHITE);
                }

                return cell;
            }
        };
        for (int i = 0; i < tableBingo.getColumnCount(); i++) {
            tableBingo.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    private void configurarRenderizadorTH()
    {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if ((int) tombola.getTablaString()[row][column] == numeroBola || tombola.getNumeroYaTirados().contains((int) value)) {
                    cell.setBackground(new Color(255,105,97));
                } else {
                    cell.setBackground(Color.WHITE);
                }

                return cell;
            }
        };
        for (int i = 0; i < tableHistorial.getColumnCount(); i++) {
            tableHistorial.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    private void lecturaNombre()
    {
        jugador = new Jugador(lecturaNombre.getText());
        frameTemp.dispose();
        hacerFramePatron();

    }

    private void lecturaPatron(int i)
    {
        cartaPatronSeleccionada = cartaPatrones.getCartaPatrones().get(i);;
        frameMenu.dispose();
        jugar();
    }

    private void tirar()
    {
        if (tombola.comprobarEspacios()) {
            numeroBola = tombola.tirarNumero();
            tableHistorial.repaint();
            tableHistorial.revalidate();
            if (verificarBola(numeroBola, jugador.getCartaJugador())) {
                colocarBola(numeroBola, jugador.getCartaJugador());
                if (bingo(cartaPatronSeleccionada, jugador.getCartaJugador())) {

                }
            }
        }
    }




    /**
     * Método que determinar si una carta de bingo efectivamente hizo bingo
     * @param cartaPatron
     * @param cartaJugador
     * @return
     */
    private boolean bingo(Carta cartaPatron, Carta cartaJugador)
    {
        int cantidadFalsesJugador = 0;
        boolean[][] cartaPatronLogico = cartaPatron.getTablaLogica();
        boolean[][] cartaPatronLogicoJugador = cartaJugador.getTablaLogica();

        for (int i = 0;i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (!cartaPatronLogico[i][j] && !cartaPatronLogicoJugador[i][j]) {
                    ++cantidadFalsesJugador;
                }
            }
        }
        System.out.println(cartaPatron.obtenerCantidadFalses() + " | " + cantidadFalsesJugador);
        return cartaPatron.obtenerCantidadFalses() == cantidadFalsesJugador;
    }

    /**
     * Método para verificar si la bola sacada de la tombola concuerda con algún
     * valor de la carta de bingo
     * @param bola
     * @param cartaJugador
     * @return
     */
    private boolean verificarBola(int bola, Carta cartaJugador)
    {
        return cartaJugador.contieneElemento(bola);
    }

    /**
     * Método para colocar la bola a la carta
     * @param bola
     * @param cartaJugador
     * @return
     */
    private void colocarBola(int bola, Carta cartaJugador)
    {
        cartaJugador.ocuparElemento(bola);
        tableBingo.repaint();
        tableBingo.revalidate();
    }

    @Override
    public void jugar()
    {
        hacerFrame();
    }
}
