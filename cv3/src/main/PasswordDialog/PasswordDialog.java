package PasswordDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PasswordDialog extends JFrame {
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JCheckBox showPasswordCheckBox;
    private JButton submitButton;
    private JLabel strengthLabel;
    private JProgressBar strengthBar;

    public PasswordDialog() {
        setTitle("Zadání hesla");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Zadejte heslo:"));
        passwordField = new JPasswordField();
        passwordField.setName("passwordField");  // Důležité pro testování
        panel.add(passwordField);

        panel.add(new JLabel("Potvrďte heslo:"));
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setName("confirmPasswordField");  // Důležité pro testování
        panel.add(confirmPasswordField);

        panel.add(new JLabel("Ukázat heslo:"));
        showPasswordCheckBox = new JCheckBox();
        showPasswordCheckBox.setName("showPasswordCheckBox");  // Důležité pro testování
        panel.add(showPasswordCheckBox);

        panel.add(new JLabel("Síla hesla:"));
        strengthBar = new JProgressBar(0, 100);
        strengthBar.setStringPainted(true);
        strengthBar.setName("strengthBar");  // Důležité pro testování
        panel.add(strengthBar);

        strengthLabel = new JLabel("Heslo je příliš slabé");
        strengthLabel.setName("strengthLabel");  // Důležité pro testování
        panel.add(strengthLabel);

        submitButton = new JButton("Potvrdit");
        submitButton.setEnabled(false);
        submitButton.setName("submitButton");  // Důležité pro testování
        panel.add(submitButton);

        // Nastavení posluchačů událostí
        setUpListeners();

        add(panel);
    }

    // Zbytek kódu je stejný jako v předchozím příkladu
    // ...

    private void setUpListeners() {
        // Posluchač pro zobrazení hesla
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean show = showPasswordCheckBox.isSelected();
                passwordField.setEchoChar(show ? (char)0 : '*');
                confirmPasswordField.setEchoChar(show ? (char)0 : '*');
            }
        });

        // Posluchač pro kontrolu síly hesla
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updatePasswordStrength(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updatePasswordStrength(); }
            @Override
            public void changedUpdate(DocumentEvent e) { updatePasswordStrength(); }
        });

        // Posluchač pro kontrolu shody hesel
        DocumentListener matchListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { checkPasswordsMatch(); }
            @Override
            public void removeUpdate(DocumentEvent e) { checkPasswordsMatch(); }
            @Override
            public void changedUpdate(DocumentEvent e) { checkPasswordsMatch(); }
        };

        passwordField.getDocument().addDocumentListener(matchListener);
        confirmPasswordField.getDocument().addDocumentListener(matchListener);

        // Posluchač pro tlačítko potvrzení
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PasswordDialog.this,
                        "Heslo bylo úspěšně nastaveno!", "Úspěch", JOptionPane.INFORMATION_MESSAGE);
                passwordField.setText("");
                confirmPasswordField.setText("");
                strengthBar.setValue(0);
                strengthLabel.setText("Heslo je příliš slabé");
                submitButton.setEnabled(false);
            }
        });
    }

    private void updatePasswordStrength() {
        String password = new String(passwordField.getPassword());
        int strength = calculatePasswordStrength(password);

        strengthBar.setValue(strength);

        if (strength < 30) {
            strengthLabel.setText("Heslo je příliš slabé");
            strengthBar.setForeground(Color.RED);
        } else if (strength < 60) {
            strengthLabel.setText("Heslo je středně silné");
            strengthBar.setForeground(Color.YELLOW);
        } else {
            strengthLabel.setText("Heslo je silné");
            strengthBar.setForeground(Color.GREEN);
        }

        checkPasswordsMatch();
    }

    private int calculatePasswordStrength(String password) {
        int strength = 0;

        if (password.length() > 0) {
            // Základní bodování za délku
            strength += Math.min(password.length() * 5, 30);

            // Bodování za obsahové prvky
            if (password.matches(".*[A-Z].*")) strength += 15;  // Velká písmena
            if (password.matches(".*[a-z].*")) strength += 10;  // Malá písmena
            if (password.matches(".*[0-9].*")) strength += 15;  // Číslice
            if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"))
                strength += 20;  // Speciální znaky

            // Bonus za různorodost
            long distinctChars = password.chars().distinct().count();
            strength += Math.min((int)(distinctChars * 2), 10);
        }

        return Math.min(strength, 100);
    }

    private void checkPasswordsMatch() {
        String password = new String(passwordField.getPassword());
        String confirm = new String(confirmPasswordField.getPassword());

        boolean passwordsMatch = password.equals(confirm) && !password.isEmpty();
        int strength = strengthBar.getValue();

        // Povolíme tlačítko pouze pokud hesla odpovídají a síla je dostatečná
        submitButton.setEnabled(passwordsMatch && strength >= 30);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordDialog().setVisible(true);
            }
        });
    }
}