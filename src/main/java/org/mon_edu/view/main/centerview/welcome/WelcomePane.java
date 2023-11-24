package org.mon_edu.view.main.centerview.welcome;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.Main;
import org.mon_edu.view.FxController;
import org.mon_edu.view.main.main_stage_adduser.MainPane2;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class WelcomePane implements Initializable, FxController {

    public void btn_stuOnClick(ActionEvent event){
        Main.getStageManager().rebuildStage(MainPane2.class);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
