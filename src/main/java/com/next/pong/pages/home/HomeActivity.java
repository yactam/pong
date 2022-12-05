package com.next.pong.pages.home;

import com.next.pong.content.Resources;
import com.next.pong.framework.activity.Activity;
import com.next.pong.framework.audio.Sound;
import com.next.pong.framework.window.Window;
import com.next.pong.pages.game.GameActivity;
import com.next.pong.pages.settings.SettingsActivity;
import javafx.scene.Node;

public class HomeActivity extends Activity<HomeLayout> {

    private final Sound sound;
    private final Sound se;

    public HomeActivity() {
        super(new HomeLayout());

        sound = new Sound();
        se    = new Sound();
        sound.playMusic(Resources.Music.GAME);

        Node playButton = findElementById("newGameButton");
        playButton.setOnMouseClicked(event -> {
            se.playSoundEffect(Resources.Music.COIN);
            Window.goTo(new GameActivity(false));
        });

        Node playButtonAI = findElementById("newGameButtonAI");
        playButtonAI.setOnMouseClicked(event -> {
            se.playSoundEffect(Resources.Music.COIN);
            Window.goTo(new GameActivity(true));
        });

        Node settingsOfGame = findElementById("settingsOfGame");
        settingsOfGame.setOnMouseClicked(event -> Window.goTo(new SettingsActivity()));

        Node quitTheGame = findElementById("quitTheGame");
        quitTheGame.setOnMouseClicked(event -> System.exit(0));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(sound != null) sound.stopMusic();
    }
}