package org.mon_edu.view.main.main_stage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.view.FxController;
import org.mon_edu.view.StageManager;
import org.mon_edu.view.help.HelpPane;
import org.mon_edu.view.main.centerview.userlist_pane.UserListPane;
import org.mon_edu.view.main.centerview.welcome_pane.WelcomePane;
import org.mon_edu.view.main.leftview.sidemenu.SideMenu;
import org.mon_edu.view.main.menubar.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class MainPane implements Initializable, FxController
{
    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    public BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // set layout
        borderPane.setTop(stageManager.loadView(MenuBar.class));
        //borderPane.setLeft(stageManager.loadView(SideMenu.class));
        borderPane.setCenter(stageManager.loadView(WelcomePane.class));
    }

}

