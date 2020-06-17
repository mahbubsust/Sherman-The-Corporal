package shermanthecorporal;

import java.io.File;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
class GameMenu extends Parent {
        
        MediaPlayer player;
        public GameMenu() {
            Stage st = new Stage();
            StackPane root1 = new StackPane();
            
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);
            

            menu0.setTranslateX(100);
            menu0.setTranslateY(200);

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);
            
            menu2.setTranslateX(100);
            menu2.setTranslateY(200);
            
            String path = "C:\\corporal.mp3";
            Media media = new Media(new File(path).toURI().toString());  
            MediaPlayer mediaPlayer = new MediaPlayer(media);     
            mediaPlayer.setAutoPlay(true);  

            final int offset = 400;

            menu1.setTranslateX(offset);
            menu2.setTranslateX(offset);
            
            MenuButton btnNewgame = new MenuButton("NEW GAME");
            MenuButton prevbtn = new MenuButton("click here to see");
            prevbtn.setOnMouseClicked(event -> {
                root1.setStyle("-fx-Background-color : yellow");
               
            });
            btnNewgame.setOnMouseClicked(event -> {
                root1.getChildren().add(prevbtn);
                root1.setStyle("-fx-Background-color : gray");
                st.setScene(new Scene(root1,1400,700));
                st.show();
            });
           

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