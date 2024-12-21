import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 extends JFrame {

    private JTextField txtbLogin;
    private JPasswordField txtbPassword;
    private JLabel lblError;

    public Form1() {
        // Initialisation des composants
        setTitle("Gestion Commercial");
        setSize(587, 319);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centrer la fenêtre à l'écran

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(45, 52, 71));

        // Label et champ pour le login
        JLabel labelLogin = new JLabel("Login");
        labelLogin.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
        labelLogin.setForeground(Color.WHITE);
        labelLogin.setBounds(62, 58, 53, 20);
        panel.add(labelLogin);

        txtbLogin = new JTextField();
        txtbLogin.setBounds(200, 60, 228, 20);
        panel.add(txtbLogin);

        // Label et champ pour le mot de passe
        JLabel labelPassword = new JLabel("Mot de Passe");
        labelPassword.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
        labelPassword.setForeground(Color.WHITE);
        labelPassword.setBounds(68, 114, 118, 20);
        panel.add(labelPassword);

        txtbPassword = new JPasswordField();
        txtbPassword.setBounds(202, 116, 228, 20);
        panel.add(txtbPassword);

        // Boutons
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(145, 160, 85, 29);
        btnAnnuler.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
        btnAnnuler.setBackground(Color.WHITE);
        btnAnnuler.setForeground(Color.BLACK);
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to cancel the action
                txtbLogin.setText("");
                txtbPassword.setText("");
            }
        });
        panel.add(btnAnnuler);

        JButton btnConnexion = new JButton("Connexion");
        btnConnexion.setBounds(305, 160, 123, 29);
        btnConnexion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
        btnConnexion.setBackground(new Color(33, 150, 243));
        btnConnexion.setForeground(Color.WHITE);
        btnConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for login action
                String login = txtbLogin.getText();
                String password = new String(txtbPassword.getPassword());
                
                // Mock check for credentials (replace with actual authentication logic)
                if (login.equals("admin") && password.equals("password")) {
                    lblError.setText("Connexion réussie !");
                    lblError.setForeground(Color.GREEN);
                } else {
                    lblError.setText("Login ou Mot de Passe Incorrect");
                    lblError.setForeground(Color.RED);
                }
            }
        });
        panel.add(btnConnexion);

        // Label pour le message d'erreur
        lblError = new JLabel("");
        lblError.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
        lblError.setForeground(Color.RED);
        lblError.setBounds(123, 17, 269, 20);
        panel.add(lblError);

        // Titre du formulaire
        JLabel titleLabel = new JLabel("Formulaire de Connexion");
        titleLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(183, 26, 249, 24);
        panel.add(titleLabel);

        // Ajouter le panel à la fenêtre
        add(panel);
    }

    public static void main(String[] args) {
        // Lancer l'application dans le thread de gestion de l'interface utilisateur
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Créer et afficher le formulaire de connexion
                new Form1().setVisible(true);
            }
        });
    }
}
