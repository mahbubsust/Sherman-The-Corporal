package sherman.the.corporal;

import java.io.File;
import java.io.FileInputStream;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {

    private GameMenu gameMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();
        root.setPrefSize(1400, 700);
        
        

        Image img = new Image(new FileInputStream("C:\\Users\\Mahbub Hasan\\Pictures\\Screenshots\\e.jpg"));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1400);
        imgView.setFitHeight(700);
        
        gameMenu = new GameMenu();
        gameMenu.setVisible(true);
        
        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);
        

        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class GameMenu extends Parent {
        MediaPlayer player;
        public GameMenu() {
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);
            

            menu0.setTranslateX(500);
            menu0.setTranslateY(300);

            menu1.setTranslateX(500);
            menu1.setTranslateY(300);
            
            menu2.setTranslateX(500);
            menu2.setTranslateY(300);
            
            String path = "C:\\Users\\Mahbub Hasan\\Documents\\NetBeansProjects\\Sherman The Corporal\\src\\Audio\\a.mp3";
            Media media = new Media(new File(path).toURI().toString());  
            MediaPlayer mediaPlayer = new MediaPlayer(media);     
            mediaPlayer.setAutoPlay(true);  

            final int offset = 400;

            menu1.setTranslateX(offset);
            menu2.setTranslateX(offset);
            
            MenuButton btnNewgame = new MenuButton("NEW GAME");

            MenuButton btnResume = new MenuButton("RESUME");
            btnResume.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> setVisible(false));
                ft.play();
            });


            MenuButton btnOptions = new MenuButton("OPTIONS");
            btnOptions.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.125), menu0);
                tt.setToX(menu0.getTranslateX() - offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });
            });
            MenuButton btnHistry = new MenuButton("HISTORY");

            MenuButton btnExit = new MenuButton("EXIT");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            MenuButton btnBack = new MenuButton("BACK");
            btnBack.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);             
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu1);
                });
            });

            MenuButton btnSound = new MenuButton("SOUND");
            btnSound.setOnMouseClicked(event -> {
                getChildren().add(menu2);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.125), menu1);
                tt.setToX(menu1.getTranslateX() - offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                    getChildren().remove(menu1);
                });
            });
            MenuButton btnOn = new MenuButton("ON");
            btnOn.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);             
                tt.setToX(menu2.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                
                tt1.setToX(menu0.getTranslateX()+offset);

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu2);
                });
                mediaPlayer.play();
                
            });
            MenuButton btnOff = new MenuButton("OFF");
            btnOff.setOnMouseClicked(event -> {
                
                
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);             
                tt.setToX(menu2.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                
                tt1.setToX(menu0.getTranslateX()+offset);

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu2);
                });
                mediaPlayer.pause();
                
                
            });
            
            MenuButton btnVideo = new MenuButton("VIDEO");

            menu0.getChildren().addAll(btnNewgame,btnResume, btnOptions,btnHistry, btnExit);
            menu1.getChildren().addAll(btnBack, btnSound, btnVideo);
            menu2.getChildren().addAll(btnOn,btnOff);
            Rectangle bg = new Rectangle(800, 600);
            bg.setFill(Color.GREY);
            bg.setOpacity(0.4);

            getChildren().addAll(bg, menu0);
        }
    }

    private static class MenuButton extends StackPane {
        private Text text;

        public MenuButton(String name) {
            text = new Text(name);
            text.setFont(text.getFont().font(30));
            text.setFill(Color.BURLYWOOD);

            Rectangle bg = new Rectangle(250, 30);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
