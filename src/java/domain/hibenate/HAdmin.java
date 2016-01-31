package domain.hibenate;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lazar Vujadinovic
 */
public class HAdmin implements Serializable {

    private String username;
    private String password;
    private String theme;

    private Date lastLogin;
    private boolean ulogovan;

    public HAdmin() {
    }

    public HAdmin(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean getUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }
    
}
