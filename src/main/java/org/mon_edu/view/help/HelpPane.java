package org.mon_edu.view.help;

import javafx.fxml.Initializable;
import net.rgielen.fxweaver.core.FxmlView;
import org.mon_edu.view.FxController;
import org.mon_edu.view.StageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@FxmlView
public class HelpPane implements Initializable, FxController {

    public static FxmlView fxml;
    @Lazy
    @Autowired
    private StageManager stageManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
