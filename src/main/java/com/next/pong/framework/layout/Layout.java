package com.next.pong.framework.layout;

import com.next.pong.content.Resources;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

import java.io.IOException;


public abstract class Layout extends Pane {
    private static final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
    public static final int DEFAULT_WIDTH = (int) screenBounds.getWidth();
    public static final int DEFAULT_HEIGHT = (int) screenBounds.getHeight();


    public Layout() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setMaxHeight(DEFAULT_HEIGHT);
        this.setMaxWidth(DEFAULT_WIDTH);
    }

    public Layout(int width, int height) {
        setMinWidth(width);
        setMinHeight(height);
        setBackground(Color.WHITE);
    }

    public Layout(String layoutName) {

        var path = "com/next/pong/layout/" + layoutName + ".fxml";
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(path));

        try {
            Parent parent = loader.load();
            parent.setLayoutX(0);
            parent.setLayoutY(0);
            ((Pane) parent).setPrefWidth(DEFAULT_WIDTH);
            ((Pane) parent).setPrefHeight(DEFAULT_HEIGHT);
            addElements(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Layout(Resources.Layout layout) {
        this(layout.toString());
    }

    public void onUpdate(double deltaTime) {
    }

    public void onDestroy() {
    }

    protected void addElements(Node... elements) {
        getChildren().addAll(elements);
    }

    protected void removeElements(Node... elements) {
        getChildren().removeAll(elements);
    }

    protected void setBackground(Color colour) {
        setBackground(colour, CornerRadii.EMPTY);
    }

    protected void setBackground(Color colour, CornerRadii cornerRadii) {
        setBackground(colour, cornerRadii, Insets.EMPTY);
    }

    protected void setBackground(Color colour, CornerRadii cornerRadii, Insets insets) {
        setBackground(
                new Background(
                        new BackgroundFill(colour, cornerRadii, insets)
                )
        );
    }

    protected void addStyleSheet(Resources.Style style) {
        getStylesheets().add("com/next/pong/css/" + style + ".css");
    }
}
