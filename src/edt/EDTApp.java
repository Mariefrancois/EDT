/*
 * EDTApp.java
 */

package edt;

import edt.mysql.BD_MySQL;
import edt.Classe.Batiment;
import edt.Classe.Etudiant;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;



/**
 * The main class of the application.
 */
public class EDTApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        BD_MySQL.init();
        show(new EDTView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of EDTApp
     */
    public static EDTApp getApplication() {
        return Application.getInstance(EDTApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) throws SQLException {
        launch(EDTApp.class, args);
        BD_MySQL.close();
        
    }
}
