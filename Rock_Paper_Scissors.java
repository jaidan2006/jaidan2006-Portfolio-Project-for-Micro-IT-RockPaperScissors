import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Rock-Paper-Scissors Game
 * Developed using Java Swing
 * Player vs Computer
 */
public class Rock_Paper_Scissors extends JFrame implements ActionListener {

    private JLabel resultLabel, playerChoiceLabel, computerChoiceLabel;
    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();

    public Rock_Paper_Scissors() {
        setTitle("Rock-Paper-Scissors Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Labels
        resultLabel = new JLabel("Make your move!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(resultLabel, BorderLayout.NORTH);

        JPanel statusPanel = new JPanel(new GridLayout(2, 1));
        playerChoiceLabel = new JLabel("Your choice: ", SwingConstants.CENTER);
        computerChoiceLabel = new JLabel("Computer's choice: ", SwingConstants.CENTER);
        statusPanel.add(playerChoiceLabel);
        statusPanel.add(computerChoiceLabel);
        add(statusPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        for (String choice : choices) {
            JButton btn = new JButton(choice);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand();
        String computerChoice = choices[random.nextInt(3)];

        playerChoiceLabel.setText("Your choice: " + playerChoice);
        computerChoiceLabel.setText("Computer's choice: " + computerChoice);

        String result = determineWinner(playerChoice, computerChoice);
        resultLabel.setText(result);
    }

    private String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "It's a Tie!";
        }

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            return "You Win!";
        } else {
            return "Computer Wins!";
        }
    }

    public static void main(String[] args) {
        new Rock_Paper_Scissors();
    }
}