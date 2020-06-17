package shermanthecorporal;



import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mahbub Hasan
 */
public class Main extends Application {
    

    GameMenu gameMenu;

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setPrefSize(1400, 700);
        
        

        Image img = new Image(new FileInputStream("C:\\sherman.jpg"));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1400);
        imgView.setFitHeight(700);
        
        gameMenu = new GameMenu();
        gameMenu.setVisible(true);
        
        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);
        

        stage.setTitle("Sherman The Corporal");
        stage.setScene(scene);
        stage.show();
    }

    

    

    public static void main(String[] args) {
        launch(args);
    }
}
