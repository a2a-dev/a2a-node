package com.a2a.commandcenter.ui.instruction.action;

import java.util.logging.Level;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aActionBlock;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aDataAction;

import io.github.jamsesso.jsonlogic.JsonLogic;
import io.github.jamsesso.jsonlogic.JsonLogicException;

public class ActionBlockHandler extends A2aDataAction<A2aControlBlock, ActionResult> {
    JsonLogic jsonLogic = new JsonLogic();

    public ActionBlockHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aControlBlock input) {
        ActionResult result = new ActionResult();
        try {
            boolean passed = (boolean) jsonLogic.apply(input.expression, input.getData());
            if (passed) {
                A2aActionBlock execution = getModel().getActionBlocksByName().get(input.getTrueActionBlock());
                execution.getActions().forEach(action -> {
                    goSync(action.actionType.getHandlerType(), action);
                });

            }
        } catch (JsonLogicException e) {
            result.setSuccess(false);
            getDelegates().getLogger().log(Level.SEVERE, "Json Logic Exception", e);

        }
        return null;

    }

}
