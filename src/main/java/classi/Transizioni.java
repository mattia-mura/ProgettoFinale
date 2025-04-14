package classi;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Transizioni extends JFrame {

  private final JPanel pannello;
  private final GridBagConstraints gbc;

  public Transizioni(String nomeFile) {

    setTitle("Menedor Bank - Trandizioni");
    setSize(500, 650);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(true);

    pannello = new JPanel(new GridBagLayout());
    pannello.setBackground(new Color(240, 240, 240));

    gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1.0;

    JTextArea areaTesto = new JTextArea(30, 40);
    areaTesto.setEditable(false);
    areaTesto.setFont(new Font("Monospaced", Font.PLAIN, 12));

    JScrollPane scrollPane = new JScrollPane(areaTesto);
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    pannello.add(scrollPane, gbc);

    // Leggi il contenuto del file e mostrane le righe
    try (BufferedReader reader = new BufferedReader(new FileReader("CartellaUtenti/"+nomeFile+".csv"))) {
      String linea;
      while ((linea = reader.readLine()) != null) {
        areaTesto.append(linea + "\n");
      }
    } catch (IOException e) {
      areaTesto.setText("Errore nella lettura del file: " + e.getMessage());
    }


    add(pannello);
    setVisible(true);
  }
}
