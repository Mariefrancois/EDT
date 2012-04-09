/*
 * EDTView.java
 */

package edt;

import edt.Classe.Promotion;
import edt.mysql.BD_MySQL;
import edt.EDTAboutBox;
import edt.EDTApp;
import edt.Frame.NewPromotion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * The application's main frame.
 */
public class EDTView extends FrameView {
    private NewPromotion newPromo;
    private int id_promo;
    private Promotion promo;
    public void init(){
        BD_MySQL.init();
        int nb = 1;
        try {
            nb = BD_MySQL.nombre_Promotion();
        } catch (SQLException ex) {
            Logger.getLogger(EDTView.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(nb == 2){
            desactiveBouton();
            etat = Etat.Debut;
        }
        else{
            desactiveBouton();
            etat = Etat.Debut1;
            refreshPromotion();
        }
        
    }
    public void refreshPromotion(){
    this.jList1.doLayout();
    DefaultListModel modell = new DefaultListModel();
     
    this.jList1.setModel(modell);
    ArrayList<String> listenom = new ArrayList();
    try {
        listenom = BD_MySQL.liste_nom_promotion();
    } catch (SQLException ex) {
        Logger.getLogger(EDTView.class.getName()).log(Level.SEVERE, null, ex);
    }
    modell.addElement(" Promotion:"); 
    for (String l : listenom) {
        modell.addElement(" - "+l); 
    }
    }
    public void desactiveBouton(){
        this.UE.setEnabled(false);
        this.Etudiants.setEnabled(false);
        this.Creneau.setEnabled(false);
    }
    public void activeBouton(){
        this.UE.setEnabled(true);
        this.Etudiants.setEnabled(true);
        this.Intervenants.setEnabled(true);
        this.Salles.setEnabled(true);
        this.Batiment.setEnabled(true);
        this.Creneau.setEnabled(true);
    }
    public EDTView(SingleFrameApplication app) {
        super(app);

        initComponents();
        init();
        this.donner1.setVisible(false);

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = EDTApp.getApplication().getMainFrame();
            aboutBox = new EDTAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        EDTApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        ajouter_promotion = new javax.swing.JButton();
        ajouter_cours = new javax.swing.JButton();
        UE = new javax.swing.JButton();
        Etudiants = new javax.swing.JButton();
        Intervenants = new javax.swing.JButton();
        Salles = new javax.swing.JButton();
		Batiment = new javax.swing.JButton();
		Creneau = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        donner1 = new edt.view.Donner();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        titre = new javax.swing.JLabel();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setVerifyInputWhenFocusTarget(false);

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(EDTView.class);
        ajouter_promotion.setText(resourceMap.getString("ajouter_promotion.text")); // NOI18N
        ajouter_promotion.setFocusable(false);
        ajouter_promotion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ajouter_promotion.setName("ajouter_promotion"); // NOI18N
        ajouter_promotion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ajouter_promotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_promotionActionPerformed(evt);
            }
        });
        jToolBar1.add(ajouter_promotion);
		
		titre.setText(resourceMap.getString("titre.text")); // NOI18N
        titre.setName("titre"); // NOI18N
		titre.setLocation(300,300);
		
		
		ajouter_cours.setText(resourceMap.getString("ajouter_cours.text")); // NOI18N
        ajouter_cours.setFocusable(false);
        ajouter_cours.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ajouter_cours.setName("ajouter_cours"); // NOI18N
        ajouter_cours.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ajouter_cours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter_coursActionPerformed(evt);
            }
        });
        jToolBar1.add(ajouter_cours);
		
        UE.setText(resourceMap.getString("UE.text")); // NOI18N
        UE.setName("UE"); // NOI18N
        UE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UEActionPerformed(evt);
            }
        });

        Etudiants.setText(resourceMap.getString("Etudiants.text")); // NOI18N
        Etudiants.setMaximumSize(new java.awt.Dimension(45, 23));
        Etudiants.setMinimumSize(new java.awt.Dimension(45, 23));
        Etudiants.setName("Etudiants"); // NOI18N
        Etudiants.setPreferredSize(new java.awt.Dimension(45, 15));
        Etudiants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtudiantsActionPerformed(evt);
            }
        });

        Intervenants.setText(resourceMap.getString("Intervenants.text")); // NOI18N
        Intervenants.setMaximumSize(new java.awt.Dimension(45, 23));
        Intervenants.setMinimumSize(new java.awt.Dimension(45, 23));
        Intervenants.setName("Intervenants"); // NOI18N
        Intervenants.setPreferredSize(new java.awt.Dimension(45, 23));
        Intervenants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IntervenantsActionPerformed(evt);
            }
        });

        Salles.setText(resourceMap.getString("Salles.text")); // NOI18N
        Salles.setMaximumSize(new java.awt.Dimension(45, 23));
        Salles.setMinimumSize(new java.awt.Dimension(45, 23));
        Salles.setName("Salles"); // NOI18N
        Salles.setPreferredSize(new java.awt.Dimension(45, 23));
        Salles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SallesActionPerformed(evt);
            }
        });
		
		Batiment.setText(resourceMap.getString("Batiment.text")); // NOI18N
        Batiment.setMaximumSize(new java.awt.Dimension(45, 23));
        Batiment.setMinimumSize(new java.awt.Dimension(45, 23));
        Batiment.setName("Batiment"); // NOI18N
        Batiment.setPreferredSize(new java.awt.Dimension(45, 23));
        Batiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatimentActionPerformed(evt);
            }
        });
		
		Creneau.setText(resourceMap.getString("Creneau.text")); // NOI18N
        Creneau.setMaximumSize(new java.awt.Dimension(45, 23));
        Creneau.setMinimumSize(new java.awt.Dimension(45, 23));
        Creneau.setName("Creneau"); // NOI18N
        Creneau.setPreferredSize(new java.awt.Dimension(45, 23));
        Creneau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreneauActionPerformed(evt);
            }
        });
        jSeparator1.setName("jSeparator1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "EDT" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
            public void addElementAt(String element) { strings[getSize()] = element; }
        });
        jList1.setAutoscrolls(false);
        jList1.setMaximumSize(new java.awt.Dimension(120, 80));
        jList1.setName("jList1"); // NOI18N
        jList1.setPreferredSize(new java.awt.Dimension(33, 120));
		jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        donner1.setName("donner1"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(Creneau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Batiment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Salles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Intervenants, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Etudiants, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UE, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(donner1, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE))
                .addContainerGap())
			.addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(titre)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UE, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Etudiants, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Intervenants, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Salles, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Batiment, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Creneau, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addContainerGap(500, Short.MAX_VALUE))
				
			.addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(donner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(100, Short.MAX_VALUE))
			.addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(titre)
                .addContainerGap(100, Short.MAX_VALUE))
        );
		mainPanel.add(titre);
        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(EDTView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1168, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents
    
    public void Promo(){
        Object prom = this.jList1.getSelectedValue();
        String p = String.valueOf(prom);
        if(p.compareTo(" Promotion:") != 0){
            try {
                this.id_promo = BD_MySQL.id_Promotion(p.substring(3,p.length()));
            } catch (SQLException ex) {
                Logger.getLogger(EDTView.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.promo = new Promotion(this.id_promo);
            } catch (SQLException ex) {
                Logger.getLogger(EDTView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            this.promo = null;
            this.titre.setText("");
        }
    }
    public String afficherDate(Timestamp tim){
        String date = String.valueOf(tim);
        int an = Integer.parseInt(date.substring(0, 4));
        int mois = Integer.parseInt(date.substring(5, 7));
        int jour = Integer.parseInt(date.substring(8, 10));
        return jour+"/"+mois+"/"+an;
    }
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        switch(etat){
            case Debut:
                //interdit
                break;
            case Debut1:
                Promo();
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
            case UE:
                Promo();
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
            case Intervenant:
                Promo();
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
            case Salle:
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
            case Etudiant:
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
            case Creneau:
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
            case Batiment:
                if(this.promo != null){
                    this.titre.setText(this.promo.getNom()+"  "+this.promo.getAnnee()+"  du "+afficherDate(this.promo.getTsDebut())+" au "+afficherDate(this.promo.getTsFin()));
                    this.id_promo = this.promo.getId();
                    activeBouton();
                    this.donner1.setVisible(false);
                }
                else{
                    desactiveBouton();
                    this.donner1.frame_Promotion();
                    this.donner1.setVisible(true);
                    this.donner1.setEtat("Promotion");
                }
                etat = Etat.Debut1;
                break;
        }
	}
    private void EtudiantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtudiantsActionPerformed
        // TODO add your handling code here:
        switch(etat){
            case Debut:
                //interdit
                break;
            case Debut1:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case UE:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Intervenant:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Salle:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Etudiant:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Creneau:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Batiment:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
        }
    }//GEN-LAST:event_EtudiantsActionPerformed

    private void UEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UEActionPerformed
        // TODO add your handling code here:
        switch(etat){
            case Debut:
                //interdit
                break;
            case Debut1:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
            case UE:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
            case Intervenant:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
            case Salle:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
            case Etudiant:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
            case Creneau:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
            case Batiment:
                this.donner1.frame_UE(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("UE");
                this.donner1.desactive_sup_modif();
                etat = Etat.UE;
                activeBouton();
                break;
        }
    }//GEN-LAST:event_UEActionPerformed

    private void IntervenantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntervenantsActionPerformed
        // TODO add your handling code here:
        
        switch(etat){
            case Debut:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                desactiveBouton();
                break;
            case Debut1:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
            case UE:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
            case Intervenant:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
            case Salle:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
            case Etudiant:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
            case Creneau:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
            case Batiment:
                donner1.frame_Intervenant();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Intervenant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Intervenant;
                activeBouton();
                break;
        }
    }//GEN-LAST:event_IntervenantsActionPerformed

    private void SallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SallesActionPerformed
        // TODO add your handling code here:
        switch(etat){
            case Debut:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                desactiveBouton();
                break;
            case Debut1:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
            case UE:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
            case Intervenant:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
            case Salle:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
            case Etudiant:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
            case Creneau:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
            case Batiment:
                donner1.frame_Salle();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Salle");
                this.donner1.desactive_sup_modif();
                etat = Etat.Salle;
                activeBouton();
                break;
        }
    }//GEN-LAST:event_SallesActionPerformed
	private void ajouter_coursActionPerformed(java.awt.event.ActionEvent evt) {   
            
	}
	
    private void CreneauActionPerformed(java.awt.event.ActionEvent evt) {      
            // TODO add your handling code here:
        switch(etat){
            case Debut:
                //interdit
                break;
            case Debut1:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case UE:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Intervenant:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Salle:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Etudiant:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Creneau:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
            case Batiment:
                this.donner1.frame_Etudiant(this.id_promo);
                this.donner1.setVisible(true);
                this.donner1.setEtat("Etudiant");
                this.donner1.desactive_sup_modif();
                etat = Etat.Etudiant;
                activeBouton();
                break;
        }
    }
    private void BatimentActionPerformed(java.awt.event.ActionEvent evt) { 
            // TODO add your handling code here:
        switch(etat){
            case Debut:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                desactiveBouton();
                break;
            case Debut1:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
            case UE:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
            case Intervenant:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
            case Salle:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
            case Etudiant:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
            case Creneau:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
            case Batiment:
                this.donner1.frame_Batiment();
                this.donner1.setVisible(true);
                this.donner1.setEtat("Batiment");
                this.donner1.desactive_sup_modif();
                etat = Etat.Batiment;
                activeBouton();
                break;
        }
}
    private void ajouter_promotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter_promotionActionPerformed
        // TODO add your handling code here:
        switch(etat){
            case Debut:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                int nb = 0;
                try {
                    nb = BD_MySQL.nombre_Promotion();
                } catch (SQLException ex) {
                    Logger.getLogger(EDTView.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(nb == 1){
                    desactiveBouton();
                    etat = Etat.Debut;
                }
                else{
                    activeBouton();
                    etat = Etat.Debut1;
                }
                refreshPromotion();
                break;
            case Debut1:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
            case UE:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
            case Intervenant:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
            case Salle:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
            case Etudiant:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
            case Creneau:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
            case Batiment:
                newPromo = new NewPromotion(new java.awt.Frame(),"Ajouter une Promotion",true,this.donner1,"Promotion2",0);
                newPromo.setVisible(true);
                etat = Etat.Debut1;
                desactiveBouton();
                refreshPromotion();
                break;
        }
    }//GEN-LAST:event_ajouter_promotionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Etudiants;
    private javax.swing.JButton Intervenants;
    private javax.swing.JButton Salles;
	private javax.swing.JButton Batiment;
	private javax.swing.JButton Creneau;
    private javax.swing.JButton UE;
    private javax.swing.JButton ajouter_promotion;
	private javax.swing.JButton ajouter_cours;
    private edt.view.Donner donner1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel titre;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private enum Etat{
        UE,
        Intervenant,
        Salle,
        Etudiant,
        Debut,
        Debut1,
        Batiment,
        Creneau
               
    }
    private Etat etat;
}
