import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuIniziale extends JPanel {
    
    private Image backgroundImage;
    
    public MenuIniziale() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Creo una finestra con il titolo "menu iniziale"
        JFrame frame = new JFrame("Menu iniziale");
        // Creo un pannello che conterrà il pulsante e lo sfondo
        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Disegno lo sfondo del pannello leggendo l'immagine dal file "immagineMenuIniziale.jpg"
                try {
                    Image sfondo = ImageIO.read(new File("src/images/immagineMenuIniziale.jpg"));
                    g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        // Imposto il layout del pannello a null per poter posizionare il pulsante manualmente
        panel.setLayout(null);
        // Creo un pulsante con il testo "Cliccami"
        JButton pulsante = new JButton("Cliccami") {
            private static final long serialVersionUID = 1L;
            private Image sfondo;

            {
                // Leggo l'immagine del pulsante dal file "play.png" e la salvo nella variabile sfondo
                try {
                    sfondo = ImageIO.read(new File("src/images/play.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Disegno l'immagine del pulsante nella posizione (0, 0) con la larghezza e l'altezza del pulsante
                if (sfondo != null) {
                    g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        // Aggiungo un listener al pulsante che chiude la finestra corrente e apre una nuova finestra di gioco
        pulsante.addActionListener(e -> {
            frame.dispose(); // Chiude la finestra corrente
            GameWindow gw = new GameWindow();
            gw.inizaGioco();
        });
        // Imposto la larghezza e l'altezza del pulsante
        pulsante.setSize(200, 120);
        // Posiziono il pulsante nella posizione (400, 500) all'interno del pannello
        pulsante.setLocation(400, 500);
        // Aggiungo il pulsante al pannello
        panel.add(pulsante);
        // Aggiungo il pannello alla finestra
        frame.add(panel);
        // Imposto la larghezza e l'altezza della finestra
        frame.setSize(1012, 785);
        // Rendo la finestra visibile
        frame.setVisible(true);
        // Impedisce che la finesta venga ridimensionata
        frame.setResizable(false);
    }
}