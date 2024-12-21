import javax.swing.*;

public class GestionCommercial {
    
    // Point d'entrée principal de l'application
    public static void main(String[] args) {
        // S'assurer que l'application utilise le thread principal pour l'interface graphique
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Initialisation de l'interface utilisateur
                JFrame frame = new FrmMenu();  // Remplacez FrmMenu par votre propre classe JFrame
                frame.setTitle("Gestion Commerciale"); // Titre de la fenêtre
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l'application lorsque la fenêtre est fermée
                frame.setSize(800, 600); // Définir la taille de la fenêtre
                frame.setVisible(true); // Afficher la fenêtre
            }
        });
    }
}
