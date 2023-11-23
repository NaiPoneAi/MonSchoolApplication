package org.mon_edu.view.login;


import org.mon_edu.service.UserService;
import org.mon_edu.view.StageManager;
import org.mon_edu.view.main.centerview.welcome_pane.WelcomePane;
import org.mon_edu.view.main.main_stage.MainPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LoginPaneManager
{
    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    public void login(LoginPane loginPane)
    {
        String username = loginPane.getUsername();
        String password = loginPane.getPassword();

        if (userService.authenticate(username, password))
            stageManager.rebuildStage(MainPane.class);
        else
            loginPane.getLblLogin().setText("Login Failed.");
    }
}
