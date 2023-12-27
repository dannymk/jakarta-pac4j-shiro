import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

@SessionScoped
@Named("loginBean")
public class loginBean implements Serializable {
    private String username;
    private String password;
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
    public String login() {
        if (username.equals("admin") && password.equals("admin")) {
          AuthenticationToken token = new UsernamePasswordToken(username, password);
          SecurityUtils.getSubject().login(token);
          return "success";
        } else {
          SecurityUtils.getSubject().logout();
          return "failure";
        }
    }
}
