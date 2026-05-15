import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounterApp extends JFrame implements ActionListener {

    JTextArea textArea;
    JLabel wordLabel, charLabel, paraLabel;
    JButton countButton, resetButton;

    WordCounterApp() {

        // Frame properties
        setTitle("Word Counter Application");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text Area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        // Labels
        wordLabel = new JLabel("Words: 0");
        charLabel = new JLabel("Characters: 0");
        paraLabel = new JLabel("Paragraphs: 0");

        // Buttons
        countButton = new JButton("Count");
        resetButton = new JButton("Reset");

        countButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Panel for buttons and labels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3, 10, 10));

        panel.add(wordLabel);
        panel.add(charLabel);
        panel.add(paraLabel);
        panel.add(countButton);
        panel.add(resetButton);

        // Layout
        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == countButton) {

            String text = textArea.getText().trim();

            // Character count
            int charCount = text.length();

            // Word count
            int wordCount = 0;

            if (!text.isEmpty()) {
                String[] words = text.split("\\s+");
                wordCount = words.length;
            }

            // Paragraph count
            int paraCount = 0;

            if (!text.isEmpty()) {
                String[] paragraphs = text.split("\\n+");
                paraCount = paragraphs.length;
            }

            // Update labels
            charLabel.setText("Characters: " + charCount);
            wordLabel.setText("Words: " + wordCount);
            paraLabel.setText("Paragraphs: " + paraCount);

        } else if (e.getSource() == resetButton) {

            textArea.setText("");

            charLabel.setText("Characters: 0");
            wordLabel.setText("Words: 0");
            paraLabel.setText("Paragraphs: 0");
        }
    }

    public static void main(String[] args) {
        new WordCounterApp();
    }
}