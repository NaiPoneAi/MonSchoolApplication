package org.mon_edu.view.main.main_stage.welcome_view;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.Main;
import org.mon_edu.view.FxController;
import org.mon_edu.view.main.employeemanagement.employee_view.AddEmpPane;
import org.mon_edu.view.main.studentmanagement.user_view.MainPane2;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class WelcomePane implements Initializable, FxController {

    public void btn_stuOnClick(ActionEvent event){
        Main.getStageManager().rebuildStage(MainPane2.class);
    }
    public void btn_empOnClick(ActionEvent event){
        Main.getStageManager().rebuildStage(AddEmpPane.class);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
