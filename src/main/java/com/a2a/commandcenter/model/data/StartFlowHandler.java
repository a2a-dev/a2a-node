package com.a2a.commandcenter.model.data;

import java.util.Arrays;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aActionBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;

public class StartFlowHandler
        extends A2aAProcessor<A2aActionBlock[], ActionResult> {

    public StartFlowHandler(A2aCommandCenterModel model) {
        super(model);
    }

    @Override
    public ActionResult process(A2aActionBlock[] input) {

        Arrays.stream(input).forEach(actionBlock -> {
            goSync(ActionBlockHandler.class, actionBlock);
        });
        return null;

    }

}
