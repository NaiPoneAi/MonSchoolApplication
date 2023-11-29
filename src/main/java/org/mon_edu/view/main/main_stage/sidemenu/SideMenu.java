package org.mon_edu.view.main.main_stage.sidemenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.Main;
import org.mon_edu.view.main.studentmanagement.user_view.MainPane2;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class SideMenu implements Initializable {

    @FXML
    private Button btnSide_Home;

    @FXML
    public void homeClicked(ActionEvent event){
        Main.getStageManager().rebuildStage(MainPane2.class);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
