package com.a2a;

import java.util.concurrent.CompletableFuture;

import com.a2a.commandcenter.IA2aOrchestrator.Ia2aUIDelegate;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.RightClickInstruction;

public class TestA2aUIDelegate implements Ia2aUIDelegate {

    @Override
    public void createLayout() {
        System.out.println("Creating layout");
    }

    @Override
    public CompletableFuture<ActionResult> processRightClick(RightClickInstruction rightClickInstruction) {
        return CompletableFuture.supplyAsync(() -> {
            return new ActionResult();
        });
    }

}
