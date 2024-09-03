package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.model.data.UIInstruction.A2aActionBlock;
import com.a2a.commandcenter.model.data.UIInstruction.ActionResult;
import com.a2a.commandcenter.ui.A2aAProcessor;

public class StopFlowHandler
        extends A2aAProcessor<A2aActionBlock[], ActionResult> {

    public StopFlowHandler(A2aCommandCenterModel model) {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionResult process(A2aActionBlock[] input) {

        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

}
