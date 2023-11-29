package org.mon_edu.view.main.employeemanagement.employee_view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.view.FxController;
import org.mon_edu.view.StageManager;
import org.mon_edu.view.main.employeemanagement.employeedetail_pane.EmployeeDetailPane;
import org.mon_edu.view.main.employeemanagement.employees.EmployeeListPane;
import org.mon_edu.view.main.main_stage.menubar.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;
@Controller
@FxmlView
public class AddEmpPane implements Initializable, FxController {
    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private BorderPane addEmp;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addEmp.setTop(stageManager.loadView(MenuBar.class));
        addEmp.setLeft(stageManager.loadView(EmployeeDetailPane.class));
        addEmp.setCenter(stageManager.loadView(EmployeeListPane.class));
    }
}
