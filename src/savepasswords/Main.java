package savepasswords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.UIManager;

/**
 *
 * @author MeTaXaS4
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String username = null;
        String password = null;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver).newInstance();
            String url = "jdbc:derby:savePasswordsE";
            Connection conn = DriverManager.getConnection(url, "admin", "nimda");
            conn.setAutoCommit(true);

            PreparedStatement statement = conn.prepareStatement("select * from APP.\"USERS\"");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            username = resultSet.getString("username");
            password = resultSet.getString("password");
            System.out.println(username + password);
            loginBox l = new loginBox(null, true);
            l.setLocationRelativeTo(null);
            l.show();
            int choise = l.getReturnStatus();
            if (choise == loginBox.RET_OK) {
                boolean correctPassword = false;
                if (username.equals(loginBox.username) && password.equals(loginBox.password)) {
                    correctPassword = true;
                }
                try {
                    MainForm f = new MainForm(correctPassword);
                    f.setLocationRelativeTo(null);
                    f.show();
                } catch (Exception e) {
                    System.out.println("here" + e.toString());
                }
            }
                
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
