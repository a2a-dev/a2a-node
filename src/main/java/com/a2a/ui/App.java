package com.a2a.ui;

import com.a2a.IA2aOrchestrator.A2aOrchestrator;

import javafx.application.Application;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        A2aOrchestrator orchestrator = new A2aOrchestrator(new A2aCommandCenterModel(), new IA2aCCDelegates());

       Application.launch(NodeUIRunner.class, args);
    }
}
