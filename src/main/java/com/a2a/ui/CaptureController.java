package com.a2a.ui;

import org.sikuli.script.Location;
import org.sikuli.script.Region;

import com.a2a.ui.ScreenRatio.RegionRect;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CaptureController {

    private Region highlight;

    @FXML
    Pane region;
    @FXML
    ImageView drag;
    @FXML
    ImageView anchor;

    @FXML
    Label regionName;

    private Stage stage;

    public void accept() {
        int h = (int) region.getPrefHeight();
        int w = (int) region.getPrefWidth();
        Bounds boundsInScene = region.localToScreen(region.getBoundsInLocal());
        int x = (int) boundsInScene.getMinX();
        int y = (int) boundsInScene.getMinY();
        highlight.setLocation(new Location(x, y));
        highlight.setH(h);
        highlight.setW(w);
        highlight.highlightOff();
        highlight.highlight(2);
        ScreenRatio.getRegionMap().put(regionName.getText(), new RegionRect(x, y, w, h));
        KeyUtil.shouldContinue = true;

        stage.close();
    }

    public void close() {
        KeyUtil.shouldContinue = true;
        stage.close();
    }

    public void reset() {
        region.setPrefSize(highlight.w, highlight.h);
        region.autosize();
        region.layout();
        stage.sizeToScene();
        Window window = stage.getScene().getWindow();

        window.setX(highlight.x);
        window.setY(highlight.y - 40);
    }

    public void setRegion(Region highlight, String name) {
        this.highlight = highlight;
        region.setPrefSize(highlight.w, highlight.h);
        region.autosize();
        region.layout();
        stage.sizeToScene();
        regionName.setText(name);
        drag.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                highlight.highlightOff();
                double prefWidth = event.getScreenX() - stage.getX() - 30;
                double prefHeight = event.getScreenY() - stage.getY() - 30;
                region.setPrefSize(prefWidth, prefHeight);
                highlight.setH((int) prefHeight);
                highlight.setW((int) prefWidth);
                highlight.highlightOn();
                region.layout();
                stage.sizeToScene();
            }
        });

        anchor.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                highlight.highlightOff();
                double x = event.getScreenX();
                double y = event.getScreenY();
                Window window = stage.getScene().getWindow();
                window.setX(x);
                window.setY(y);
                highlight.setLocation(new Location(x, y + 40));
                highlight.highlightOn();
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
