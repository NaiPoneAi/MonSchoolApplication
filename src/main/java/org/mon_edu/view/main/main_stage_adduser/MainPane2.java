package org.mon_edu.view.main.main_stage_adduser;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.view.FxController;
import org.mon_edu.view.StageManager;
import org.mon_edu.view.main.centerview.userlist_pane.UserListPane;
import org.mon_edu.view.main.leftview.userdetail_pane.UserDetailPane;
import org.mon_edu.view.main.menubar.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class MainPane2 implements Initializable, FxController {
    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private BorderPane dashboard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dashboard.setTop(stageManager.loadView(MenuBar.class));
        dashboard.setLeft(stageManager.loadView(UserDetailPane.class));
        dashboard.setCenter(stageManager.loadView(UserListPane.class));
    }
}
