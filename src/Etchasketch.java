import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class Etchasketch extends JPanel 
{
        
        private int playerX = 100;
        private int playerY = 100;
        private final int Player_Speed = 40;
        private final int Move_Speed = 5;
    public Etchasketch()
    {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        setupKeyBindings();

    }
    private void setupKeyBindings()
    {
    InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = getActionMap();
    inputMap.put(KeyStroke.getKeyStroke("W"), "Move Up");
    inputMap.put(KeyStroke.getKeyStroke( "S"), "Move Down");
    inputMap.put(KeyStroke.getKeyStroke("A"),"Move Left");
    inputMap.put(KeyStroke.getKeyStroke("D"), "Move Right");
    }

    action 
}   
