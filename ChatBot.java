import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;

public class ChatBot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    public ChatBot() {

        setTitle("AI ChatBot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        chatArea.append("🤖 AI ChatBot:\n");
        chatArea.append("Hello! I am your AI ChatBot.\n");
        chatArea.append("Ask me anything.\n\n");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String message = inputField.getText().trim();

        if (message.isEmpty())
            return;

        chatArea.append("You: " + message + "\n");

        String response = getResponse(message);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    private String getResponse(String input) {

        input = input.toLowerCase();

        // Greetings
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        // Java
        if (input.contains("java")) {
            return "Java is an Object-Oriented Programming language developed by Sun Microsystems.";
        }

        // AI
        if (input.contains("artificial intelligence") || input.contains("ai")) {
            return "Artificial Intelligence enables machines to learn and make decisions.";
        }

        // NLP
        if (input.contains("nlp")) {
            return "NLP stands for Natural Language Processing. It helps computers understand human language.";
        }

        // Machine Learning
        if (input.contains("machine learning")) {
            return "Machine Learning is a branch of AI that learns patterns from data.";
        }

        // College Project
        if (input.contains("project")) {
            return "You can build an AI ChatBot using Java Swing, NLP, and a rule-based response engine.";
        }

        // Time
        if (input.contains("time")) {
            return "Current Time: " + LocalDateTime.now();
        }

        // Name
        if (input.contains("your name")) {
            return "My name is Java AI ChatBot.";
        }

        // Thanks
        if (input.contains("thank")) {
            return "You're welcome!";
        }

        // Bye
        if (input.contains("bye")) {
            return "Goodbye! Have a nice day.";
        }

        // Default Response
        return generateSmartResponse(input);
    }

    // Simple NLP-style keyword matching
    private String generateSmartResponse(String input) {

        String[] words = input.split(" ");

        for (String word : words) {

            switch (word) {

                case "computer":
                    return "A computer is an electronic machine.";

                case "python":
                    return "Python is a popular programming language used in AI.";

                case "database":
                    return "A database stores and manages data.";

                case "internet":
                    return "The Internet connects millions of computers worldwide.";

                case "chatbot":
                    return "A chatbot is software that communicates with users.";

                case "engineering":
                    return "Engineering uses science and mathematics to solve real-world problems.";

                case "college":
                    return "College is a place for higher education.";

            }

        }

        return "Sorry, I don't understand your question. Please ask something else.";
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new ChatBot());

    }

}
