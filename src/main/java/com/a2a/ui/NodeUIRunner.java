/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.a2a.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class NodeUIRunner extends Application {

    GridPane pane;

    @Override
    public void start(Stage stage) throws Exception {
        pane = FXMLLoader.load(getClass().getResource(("NodeUIRunner.fxml")));
        stage.setScene(new javafx.scene.Scene(pane));
        stage.show();
    }

}
