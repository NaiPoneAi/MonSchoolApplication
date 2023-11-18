package org.monedu;

import javafx.stage.Stage;
import org.monedu.view.StageManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;


@Configuration
public class AppConfig
{
    @Bean
    @Lazy(value = true) //Stage only created after Spring context bootstap
    public StageManager stageManager(Stage stage) throws IOException
    {
        return new StageManager(stage);
    }

}
