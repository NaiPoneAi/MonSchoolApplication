package org.monedu.view.main.top;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import net.rgielen.fxweaver.core.FxmlView;
import org.monedu.Main;
import org.monedu.view.ResourceBundleUtil;
import org.monedu.view.main.help.HelpPane;
import org.monedu.view.main.MainPane;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
@FxmlView
public class MenuBar implements Initializable
{
    public Menu languageMenu, help;

    @FXML
    private void exit(ActionEvent event)
    {
        Platform.exit();
    }
    @FXML
    private void help(ActionEvent event) throws IOException {
        Main.getStageManager().rebuildStage(HelpPane.class);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        for (Locale locale : ResourceBundleUtil.getSupportedLanguages())
        {
            MenuItem menuItem = new MenuItem(locale.getDisplayLanguage());
            menuItem.setOnAction(event ->
            {
                Main.setLOCALE(locale);
                Main.getStageManager().rebuildStage(MainPane.class);
            });
            languageMenu.getItems().addAll(menuItem);
        }
    }
}
