/* 
 * Copyright 2019 Patrik Karlström.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package se.trixon.nbpfx.core;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.openide.LifecycleManager;

public class MainApp extends Application {

    private static final Logger LOGGER = Logger.getLogger(MainApp.class.getName());
    private FXMLController controller;

    public MainApp() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.log(Level.INFO, "start fx application");
        URL url = getClass().getResource("/fxml/Scene.fxml");
        FXMLLoader loader = new FXMLLoader(url);

        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root);

        stage.setTitle("NBPFX");
        stage.getIcons().add(new Image("/org/netbeans/core/startup/frame48.gif"));
        stage.setScene(scene);
        stage.show();
        controller.init(stage);
    }

    @Override
    public void stop() throws Exception {
        LOGGER.log(Level.INFO, "request platform shutdown");
        LifecycleManager.getDefault().exit();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as
     * fallback in case the application can not be launched through deployment artifacts, e.g., in
     * IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "manual start");
        launch(args);
    }
}
