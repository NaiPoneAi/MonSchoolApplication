package org.monedu.view.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.monedu.view.FxController;
import org.monedu.view.StageManager;
import org.monedu.view.main.center.UserListPane;
import org.monedu.view.main.left.UserDetailPane;
import org.monedu.view.main.top.MenuBar;
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
        borderPane.setLeft(stageManager.loadView(UserDetailPane.class));
        borderPane.setCenter(stageManager.loadView(UserListPane.class));
    }
}

