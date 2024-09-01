package com.a2a.ui;

import com.a2a.commandcenter.A2aOrchestrator;

import javafx.application.Application;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        A2aOrchestrator orchestrator = A2aOrchestrator.getInstance(new A2aCCDelegates());

        Application.launch(NodeUIRunner.class, args);
    }
}
