package com.a2a.ui;

import com.a2a.commandcenter.A2aWorkflow;

import javafx.application.Application;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        A2aWorkflow orchestrator = A2aWorkflow.getInstance(new A2aCCDelegateImplementer());

        Application.launch(NodeUIRunner.class, args);
    }
}
