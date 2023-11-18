package org.monedu.view.login;


import org.monedu.service.UserService;
import org.monedu.view.StageManager;
import org.monedu.view.main.MainPane;
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
