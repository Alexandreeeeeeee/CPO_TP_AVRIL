/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sp4_console_avril_alexandre;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    Joueur[] listeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    PlateauDeJeu grilleJeu = new PlateauDeJeu();

    public fenetreDeJeu() {
        initComponents();
        panneau_info_joueurs.setVisible(false);
        panneau_info_partie.setVisible(false);

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(grilleJeu.Grille[i][j]);

                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        CelluleDeGrille c = cellGraph.celluleAssociee;
                        if (c.jetonCourant == null) {
                            return;
                        }

                        if (c.jetonCourant.couleur.equals(joueurCourant.couleur)) {
                            message.setText("le joueur " + joueurCourant.Nom + " récupère un de ses jetons");
                            Jeton jrecup = c.recupererJeton();
                            joueurCourant.ajouterJeton(jrecup);
                            joueurSuivant();
                        } else {
                            if (joueurCourant.nombreDesintegrateurs > 0) {
                                message.setText("le joueur " + joueurCourant.Nom + " désintégre un jeton");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                joueurSuivant();
                            } else {
                                return;
                            }
                        }
                        grilleJeu.tasserGrille();
                        panneau_grille.repaint(); // on rafraichit le panneau !
                        lbl_j1_desint1.setText(listeJoueurs[0].nombreDesintegrateurs + ""); // pb d'ajout du nombre de désint.
                        lbl_j2_desint2.setText(listeJoueurs[1].nombreDesintegrateurs + "");

                        boolean vict_j1 = grilleJeu.etreGagnantePourCouleur("Rouge");
                        boolean vict_j2 = grilleJeu.etreGagnantePourCouleur("Jaune");

                        if (vict_j1 && !vict_j2) {
                            message.setText("Victoire de " + listeJoueurs[0].Nom);
                        }
                        if (vict_j2 && !vict_j1) {
                            message.setText("Victoire de " + listeJoueurs[1].Nom);
                        }
                        if (vict_j1 && vict_j2) {
                            if (joueurCourant == listeJoueurs[0]) {
                                message.setText("Victoire de " + listeJoueurs[1].Nom);
                            } else {
                                message.setText("Victoire de " + listeJoueurs[0].Nom + " faute de jeu de l'autre joueur");
                            }
                        }
                    }
                });

                panneau_grille.add(cellGraph);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_j1 = new javax.swing.JTextField();
        nom_j2 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_joueurs = new javax.swing.JPanel();
        lbl_j1_nom1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_j1_couleur1 = new javax.swing.JLabel();
        lbl_j1_desint1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_j2_couleur2 = new javax.swing.JLabel();
        lbl_j2_desint2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_j2_nom2 = new javax.swing.JLabel();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        btn_col_0 = new javax.swing.JButton();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(0, 51, 51));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 672, 580));

        panneau_creation_partie.setBackground(new java.awt.Color(51, 153, 255));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom joueur 2 :");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setText("Nom joueur 1 :");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        panneau_creation_partie.add(nom_j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 190, -1));

        nom_j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_j2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 190, -1));

        btn_start.setText("C'est partie ?");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 350, 130));

        panneau_info_joueurs.setBackground(new java.awt.Color(255, 255, 255));
        panneau_info_joueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_j1_nom1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_j1_nom1.setText("nomj1");
        panneau_info_joueurs.add(lbl_j1_nom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel5.setText("joueur 1 :");
        panneau_info_joueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lbl_j1_couleur1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_j1_couleur1.setText("couleurj1 ");
        panneau_info_joueurs.add(lbl_j1_couleur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        lbl_j1_desint1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_j1_desint1.setText("nbdesj1");
        panneau_info_joueurs.add(lbl_j1_desint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jLabel8.setText("couleur :");
        panneau_info_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel9.setText("désintegrateurs :");
        panneau_info_joueurs.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        panneau_info_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 330, 10));

        lbl_j2_couleur2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_j2_couleur2.setText("couleurj2 ");
        panneau_info_joueurs.add(lbl_j2_couleur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        lbl_j2_desint2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_j2_desint2.setText("nbdesj2");
        panneau_info_joueurs.add(lbl_j2_desint2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jLabel12.setText("couleur :");
        panneau_info_joueurs.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel13.setText("désintegrateurs :");
        panneau_info_joueurs.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jLabel4.setText("Infos joueurs : ");
        panneau_info_joueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setText("joueur 2 :");
        panneau_info_joueurs.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        lbl_j2_nom2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_j2_nom2.setText("nomj2");
        panneau_info_joueurs.add(lbl_j2_nom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        getContentPane().add(panneau_info_joueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, 350, 280));

        panneau_info_partie.setBackground(new java.awt.Color(255, 102, 102));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 20)); // NOI18N
        jLabel3.setText("Infos jeu : ");
        panneau_info_partie.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setText("Au tour de :");
        panneau_info_partie.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, -1));

        lbl_jcourant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_jcourant.setText("nomjoueur");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        panneau_info_partie.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 330, 100));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 350, 190));

        btn_col_0.setText("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 50, -1, -1));

        btn_col_1.setText("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 50, -1, -1));

        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 50, -1, -1));

        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 50, -1, -1));

        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 50, -1, -1));

        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));

        setBounds(0, 0, 1322, 1068);
    }// </editor-fold>//GEN-END:initComponents

    private void nom_j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_j2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_j2ActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(1);
        if (grilleJeu.colonneRemplie(1) == true) {
            btn_col_1.setEnabled(false);
        }

        joueurSuivant();

    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(2);
        if (grilleJeu.colonneRemplie(2) == true) {
            btn_col_2.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        panneau_info_joueurs.setVisible(true);
        panneau_info_partie.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        btn_start.setEnabled(false);
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(0);
        if (grilleJeu.colonneRemplie(0) == true) {
            btn_col_0.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(3);
        if (grilleJeu.colonneRemplie(3) == true) {
            btn_col_3.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(4);
        if (grilleJeu.colonneRemplie(4) == true) {
            btn_col_4.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(5);
        if (grilleJeu.colonneRemplie(5) == true) {
            btn_col_5.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        // TODO add your handling code here:
        jouerDansColonne(6);
        if (grilleJeu.colonneRemplie(6) == true) {
            btn_col_6.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_6ActionPerformed

    public void joueurSuivant() {
        if (joueurCourant == listeJoueurs[0]) {
            joueurCourant = listeJoueurs[1];
        } else {
            joueurCourant = listeJoueurs[0];
        }
        lbl_jcourant.setText(joueurCourant.Nom);
    }

    public boolean jouerDansColonne(int indice_colonne) {
        boolean result;
        //joueurCourant.nbj--; 
        result = grilleJeu.ajouterJetonDansColonne(joueurCourant.reserveJeton.get(joueurCourant.nbj), indice_colonne);
        panneau_grille.repaint();

        lbl_j1_desint1.setText(listeJoueurs[0].nombreDesintegrateurs + ""); // pb d'ajout du nombre de désint.
        lbl_j2_desint2.setText(listeJoueurs[1].nombreDesintegrateurs + "");

        boolean vict_j1 = grilleJeu.etreGagnantePourCouleur("Rouge");
        boolean vict_j2 = grilleJeu.etreGagnantePourCouleur("Jaune");

        if (vict_j1 && !vict_j2) {
            message.setText("Victoire de " + listeJoueurs[0].Nom);
        }
        if (vict_j2 && !vict_j1) {
            message.setText("Victoire de " + listeJoueurs[1].Nom);
        }
        if (vict_j1 && vict_j2) {
            if (joueurCourant == listeJoueurs[0]) {
                message.setText("Victoire de " + listeJoueurs[1].Nom);
            } else {
                message.setText("Victoire de " + listeJoueurs[0].Nom + " faute de jeu de l'autre joueur");
            }
        }

        if (result == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    public void initialiserPartie() {

        grilleJeu.viderGrille(joueurCourant, joueurCourant); // vidange de la grille.
        // l'utilisateur rentre dans la console.

        String nomJ1 = nom_j1.getText();
        Joueur j1 = new Joueur(nomJ1);

        String nomJ2 = nom_j2.getText();
        Joueur j2 = new Joueur(nomJ2);

        listeJoueurs[0] = j1; // attribuation des couleurs.
        listeJoueurs[1] = j2;

        //grilleJeu = new PlateauDeJeu(); // on créé une grille de jeu
        Random r = new Random();

        attribuerCouleurAuxJoueurs();
        System.out.println(j1.Nom + " est de couleur " + j1.couleur);
        System.out.println(j2.Nom + " est de couleur " + j2.couleur);

        // MISE A JOUR DES INFOS DE JEUX.
        lbl_j1_nom1.setText(nomJ1);
        lbl_j1_couleur1.setText(j1.couleur);
        lbl_j1_desint1.setText(j1.nombreDesintegrateurs + "");

        lbl_j2_nom2.setText(nomJ2);
        lbl_j2_couleur2.setText(j2.couleur);
        lbl_j2_desint2.setText(j2.nombreDesintegrateurs + "");

        Random couleur = new Random();
        int alea = couleur.nextInt(2);

        if (alea == 1) { // on fait commencer un des 2 joueurs aléatoirement.
            joueurCourant = listeJoueurs[0];
            System.out.println(listeJoueurs[0].Nom + " commence");
        } else {
            joueurCourant = listeJoueurs[1];
            System.out.println(listeJoueurs[1].Nom + " commence");
        }
        lbl_jcourant.setText(joueurCourant.Nom);

        for (int i = 0; i < 21; i++) { // attribution des 21 jetons aux joueurs.
            Jeton unJeton = new Jeton(listeJoueurs[0].couleur);
            listeJoueurs[0].ajouterJeton(unJeton);
            Jeton unJeton2 = new Jeton(listeJoueurs[1].couleur);
            listeJoueurs[1].ajouterJeton(unJeton2);

        }
        Random pos = new Random(); // position
        int cpt = 0;

        for (int i = 0; i < 5; i++) {

            int l = pos.nextInt(5);
            int c = pos.nextInt(6);

            if (cpt < 2) {
                if (!grilleJeu.placerDesintegrateur(l, c)) {
                    cpt--;
                }
                cpt++;
            }
            if (!grilleJeu.placerTrouNoir(l, c)) {
                i--;
            }
        }
        for (int i = 0; i < 3; i++) {
            int l = pos.nextInt(5);
            int c = pos.nextInt(6);
            if (!grilleJeu.placerDesintegrateur(l, c)) {
                i--;
            }
        }
    }

    public void attribuerCouleurAuxJoueurs() {
        int r = (int) (2 * Math.random()); // random donne un chiffre entre 0 et 1, nous on veut un entie donc on met int
        // et x2
        if (r == 0) {
            listeJoueurs[0].couleur = "Rouge";
            listeJoueurs[1].couleur = "Jaune";
        } else {
            listeJoueurs[0].couleur = "Jaune";
            listeJoueurs[1].couleur = "Rouge";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur1;
    private javax.swing.JLabel lbl_j1_desint1;
    private javax.swing.JLabel lbl_j1_nom1;
    private javax.swing.JLabel lbl_j2_couleur2;
    private javax.swing.JLabel lbl_j2_desint2;
    private javax.swing.JLabel lbl_j2_nom2;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField nom_j1;
    private javax.swing.JTextField nom_j2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueurs;
    private javax.swing.JPanel panneau_info_partie;
    // End of variables declaration//GEN-END:variables

}
