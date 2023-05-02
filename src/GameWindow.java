import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by Armin on 6/25/2016.
 */
public class GameWindow extends JFrame {

    enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter
    }

    //PlantType activePlantingBrush = PlantType.None;
    
    public GameWindow(){
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel sun = new JLabel("SUN");
        sun.setLocation(37,80);
        sun.setSize(60,20);

        GamePanel gp = new GamePanel(sun);
        gp.setLocation(0,0);
        getLayeredPane().add(gp,new Integer(0));
        
        PlantCard sunflower = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/carta_peach.png")).getImage());
        sunflower.setLocation(110,8);
        sunflower.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Sunflower;
        });
        getLayeredPane().add(sunflower,new Integer(3));

        PlantCard peashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/carta_mario_fuoco.png")).getImage());
        peashooter.setLocation(175,8);
        peashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Peashooter;
        });
        getLayeredPane().add(peashooter,new Integer(3));

        PlantCard freezepeashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/carta_mario_ghiaccio.png")).getImage());
        freezepeashooter.setLocation(240,8);
        freezepeashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FreezePeashooter;
        });
        getLayeredPane().add(freezepeashooter,new Integer(3));



        getLayeredPane().add(sun,new Integer(2));
        setResizable(false);
        setVisible(true);
    }
    /*public GameWindow(boolean b) {
        Menu menu = new Menu();
        menu.setLocation(0,0);
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getLayeredPane().add(menu,new Integer(0));
        menu.repaint();
        setResizable(false);
        setVisible(true);
    }*/
    static GameWindow gw;
    public static void begin() {
       gw.dispose();
    }
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        MenuIniziale menuIniziale = new MenuIniziale();  
    }
    
    public void inizaGioco()
    {
        gw = new GameWindow();
        begin();
    }

}
