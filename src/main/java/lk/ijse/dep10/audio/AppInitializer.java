package lk.ijse.dep10.audio;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class AppInitializer extends Application {
    private Stage audioStage;
    private MediaPlayer mediaPlayer;
    private File audioFile;
    private String[] audioFileName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene();

    }

    private void mainScene() {
        if (audioStage != null) return;
        Label lblDuration = new Label("Duration : 00:00");
        Label lblTitle = new Label("Open File and Choose a Audio File to Play");
        lblTitle.setFont(Font.font(16));
        lblTitle.setTextFill(Color.BLUE);
        audioStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        Slider volumeSlider = new Slider();

        ImageView imagePlay = new ImageView();
        ImageView imagePause = new ImageView();
        ImageView imageStop = new ImageView();
        ImageView imageRepeat = new ImageView();
        ImageView imageMute = new ImageView();
        ImageView imageFileOpen = new ImageView();


        imagePlay.setFitHeight(50);
        imagePlay.setFitWidth(50);
        imagePause.setFitHeight(50);
        imagePause.setFitWidth(50);
        imageStop.setFitHeight(50);
        imageStop.setFitWidth(50);
        imageRepeat.setFitHeight(50);
        imageRepeat.setFitWidth(50);
        imageMute.setFitHeight(50);
        imageMute.setFitWidth(50);
        imageFileOpen.setFitHeight(50);
        imageFileOpen.setFitWidth(50);


        AnchorPane root = new AnchorPane();
        root.getChildren().add(imagePlay);
        imagePlay.setLayoutX(30);
        imagePlay.setLayoutY(220);
        root.getChildren().add(imagePause);
        imagePause.setLayoutX(100);
        imagePause.setLayoutY(220);
        root.getChildren().add(imageStop);
        imageStop.setLayoutX(170);
        imageStop.setLayoutY(220);
        root.getChildren().add(imageRepeat);
        imageRepeat.setLayoutX(240);
        imageRepeat.setLayoutY(220);
        root.getChildren().add(imageFileOpen);
        imageFileOpen.setLayoutX(310);
        imageFileOpen.setLayoutY(220);
        root.getChildren().add(imageMute);
        imageMute.setLayoutX(400);
        imageMute.setLayoutY(220);
        root.getChildren().add(volumeSlider);
        volumeSlider.setLayoutX(465);
        volumeSlider.setLayoutY(238);
        root.getChildren().add(lblTitle);
        lblTitle.setLayoutX(160);
        lblTitle.setLayoutY(10);
        root.getChildren().add(lblDuration);
        lblDuration.setLayoutX(480);
        lblDuration.setLayoutY(180);


        root.setBackground(Background.fill(Color.LIGHTCYAN));
        root.setPadding(new Insets(10));

        mediaPlayer = new MediaPlayer(new Media(new File("data/video/newvid.mp4").toURI().toString()));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(400);
        mediaView.setFitHeight(150);
        root.getChildren().add(mediaView);
        mediaView.setLayoutX(240);
        mediaView.setLayoutY(50);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(Animation.INDEFINITE);


        Image play = new Image("file:data/image/play.png");
        Image pause = new Image("file:data/image/pause.png");
        Image stop = new Image("file:data/image/stop.png");
        Image repeat = new Image("file:data/image/cycle.png");
        Image mute = new Image("file:data/image/mute.png");
        Image fileOpen = new Image("file:data/image/fileopen.png");
        Image muteOff = new Image("file:data/image/muteoff.png");


        imagePlay.setImage(play);
        imagePause.setImage(pause);
        imageStop.setImage(stop);
        imageRepeat.setImage(repeat);
        imageMute.setImage(muteOff);
        imageFileOpen.setImage(fileOpen);

        imagePlay.setOnMouseEntered(mouseEvent -> {
            imagePlay.setOpacity(0.7);
            imagePlay.setCursor(Cursor.HAND);
        });
        imagePlay.setOnMouseExited(mouseEvent -> imagePlay.setOpacity(1));
        imagePause.setOnMouseEntered(mouseEvent -> {
            imagePause.setOpacity(0.7);
            imagePause.setCursor(Cursor.HAND);
        });
        imagePause.setOnMouseExited(mouseEvent -> imagePause.setOpacity(1));
        imageStop.setOnMouseEntered(mouseEvent -> {
            imageStop.setOpacity(0.7);
            imageStop.setCursor(Cursor.HAND);
        });
        imageStop.setOnMouseExited(mouseEvent -> imageStop.setOpacity(1));
        imageRepeat.setOnMouseEntered(mouseEvent -> {
            imageRepeat.setOpacity(0.7);
            imageRepeat.setCursor(Cursor.HAND);
        });
        imageRepeat.setOnMouseExited(mouseEvent -> {
            imageRepeat.setOpacity(1);
            mediaPlayer.setCycleCount(0);
        });
        imageMute.setOnMouseEntered(mouseEvent -> {
            imageMute.setOpacity(0.7);
            imageMute.setCursor(Cursor.HAND);
        });
        imageMute.setOnMouseExited(mouseEvent -> imageMute.setOpacity(1));
        imageFileOpen.setOnMouseEntered(mouseEvent -> {
            imageFileOpen.setOpacity(0.7);
            imageFileOpen.setCursor(Cursor.HAND);
        });
        imageFileOpen.setOnMouseExited(mouseEvent -> imageFileOpen.setOpacity(1));
        volumeSlider.setOnMouseEntered(mouseEvent -> volumeSlider.setCursor(Cursor.HAND));

        imagePlay.setOnMousePressed(mouseEvent -> imagePlay.setEffect(new InnerShadow(20, Color.BLACK)));
        imagePause.setOnMousePressed(mouseEvent -> imagePause.setEffect(new InnerShadow(20, Color.BLACK)));
        imageStop.setOnMousePressed(mouseEvent -> imageStop.setEffect(new InnerShadow(20, Color.BLACK)));
        imageRepeat.setOnMousePressed(mouseEvent -> imageRepeat.setEffect(new InnerShadow(20, Color.BLACK)));
        imageFileOpen.setOnMousePressed(mouseEvent -> imageFileOpen.setEffect(new InnerShadow(20, Color.BLACK)));
        imageMute.setOnMousePressed(mouseEvent -> imageMute.setEffect(new InnerShadow(20, Color.BLACK)));

        imagePlay.setOnMouseReleased(mouseEvent -> {
            imagePlay.setEffect(null);
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(volumeSlider.getValue());
                mediaPlayer.play();

            }
        });
        imagePause.setOnMouseReleased(mouseEvent -> {
            imagePause.setEffect(null);
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        });
        imageStop.setOnMouseReleased(mouseEvent -> {
            imageStop.setEffect(null);
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        });
        imageRepeat.setOnMouseReleased(mouseEvent -> {
            imageRepeat.setEffect(null);
            if (mediaPlayer != null) {
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            }
        });
        imageFileOpen.setOnMouseReleased(mouseEvent -> {
            imageFileOpen.setEffect(null);
            audioFile = fileChooser.showOpenDialog(null);
            fileChooser.setTitle("Open an Audio File");
            if (audioFile != null) {
                mediaPlayer = new MediaPlayer(new Media(audioFile.toURI().toString()));
                audioFileName = audioFile.toString().split("/");
                lblTitle.setText(audioFileName[audioFileName.length - 1]);
            } else mediaPlayer = null;
        });
        imageMute.setOnMouseReleased(mouseEvent -> {
            imageMute.setEffect(null);
            if (mediaPlayer != null) {
                imageMute.setImage(mute);
                if (mediaPlayer.isMute()) {
                    imageMute.setImage(muteOff);
                    mediaPlayer.setMute(false);
                } else mediaPlayer.setMute(true);
            }
        });

        volumeSlider.valueProperty().addListener((observableValue, number, t1) -> {
            if (volumeSlider.isValueChanging()) mediaPlayer.setVolume(volumeSlider.getValue() / 100);
            if (volumeSlider.getValue() == 0) imageMute.setImage(mute);
            else imageMute.setImage(muteOff);
        });

        KeyFrame keyFrame = new KeyFrame(Duration.millis(6000), actionEvent -> {
            TranslateTransition translateX = new TranslateTransition(Duration.millis(6000), lblTitle);
            translateX.setFromX(-700);
            translateX.setToX(450);
            translateX.playFromStart();
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();


        audioStage.setScene(new Scene(root));
        audioStage.setTitle("Audio Player");
        audioStage.setMinWidth(620);
        audioStage.setMinHeight(320);
        audioStage.setMaxWidth(620);
        audioStage.setMaxHeight(320);
        audioStage.sizeToScene();
        audioStage.show();
        audioStage.centerOnScreen();
        audioStage.setOnCloseRequest(windowEvent -> audioStage = null);

    }
}
