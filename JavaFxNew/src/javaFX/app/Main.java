package javaFX.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("main"); //
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");//Initialize our application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");  // start an application
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar); //add menu bar within VBOX at top

        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(new Scene(rootNode));
        primaryStage.show();
    }

     private MenuBar createMenu(){
    	//File Menu
    	Menu fileMenu = new Menu("File");
	     MenuItem newMenuItem = new MenuItem("New");

	     newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

	     SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	     MenuItem quitMenuItem = new MenuItem("Quit");

	     quitMenuItem.setOnAction(event -> {
		     Platform.exit();
		     System.exit(0);
	     });

	     fileMenu.getItems().addAll(newMenuItem,separatorMenuItem, quitMenuItem);

	     // Help Menu
	    Menu helpMenu = new Menu("Help");
         MenuItem aboutApp = new MenuItem("About");

         aboutApp.setOnAction(event -> aboutApp());

         helpMenu.getItems().addAll(aboutApp);

         //Menu Bar
	    MenuBar menuBar = new MenuBar();  // Menu Bar
	    menuBar.getMenus().addAll(fileMenu, helpMenu);

	    return menuBar;
	}    //Menu 

	public static void aboutApp(){      //Alert Dialog

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App ");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("Don't stop learning you have more to learn in this world");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
			//code..
			System.out.println("Yes Button Clicked !");
		} else {
			System.out.println("No Button Clicked!");
		}
	}

	@Override
    public void stop() throws Exception {
        System.out.println("stop "); // after we close the window its stops
        super.stop();
    }
}




