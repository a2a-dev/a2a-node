package com.a2a.commandcenter.model.data;

import java.util.List;
import java.util.Map;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.ui.ScreenShotInstructionHandler;
import com.a2a.commandcenter.ui.instruction.DnDInstructionHandler;
import com.a2a.commandcenter.ui.instruction.DoubleClickInstructionHandler;
import com.a2a.commandcenter.ui.instruction.KeyInInstructionHandler;
import com.a2a.commandcenter.ui.instruction.LeftClickInstructionHandler;
import com.a2a.commandcenter.ui.instruction.MouseMoveInstructionHandler;
import com.a2a.commandcenter.ui.instruction.ReadInstructionHandler;
import com.a2a.commandcenter.ui.instruction.RightClickInstructionHandler;
import com.a2a.commandcenter.ui.instruction.WaitInstructionHandler;
import com.a2a.commandcenter.ui.instruction.flow.ContinueFlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.FlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.PauseFlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.QueueFlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.RestartFlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.SkipFlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.StartFlowHandler;
import com.a2a.commandcenter.ui.instruction.flow.StopFlowHandler;
import com.commandcenter.action.IProcessor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UIInstruction {

    private A2aInstructionType action;
    public String flowName;
    private List<A2aControlBlock> controlBlocks;
    private Map<String, A2aActionBlock> actionBlocks;
    private String lastModified;
    private boolean record;
    private String scope;
    private String parentFlowName;
    public String requestId;

    public static enum A2aInstructionType {

        START(StartFlowHandler.class),
        STOPAll(StopFlowHandler.class),
        QUEUE(QueueFlowHandler.class),
        SKIP(SkipFlowHandler.class),
        PAUSE(PauseFlowHandler.class),
        CONTINUE(ContinueFlowHandler.class),
        RESTART(RestartFlowHandler.class);

        private Class<? extends FlowHandler> handlerType;

        public Class<? extends FlowHandler> getHandlerType() {
            return handlerType;
        }

        A2aInstructionType(Class<? extends FlowHandler> handlerType) {
            this.handlerType = handlerType;
        }
    }

    @Getter
    @Setter
    public static class A2aControlBlock {
        public String expression;
        public String trueActionBlock;
        public String falseActionBlock;
        public String scope;
        public transient boolean record;
        public transient boolean terminate;
        public transient Map<String, Object> data;
        public transient String requestId;
    }

    @Getter
    @Setter
    public class A2aActionBlock {
        public List<A2aUIAction> actions;
        public String name;
    }

    @Getter
    @Setter
    public static class A2aUIAction {
        public A2aUIActionType actionType;
        public ActionParameter actionParameter;
        public String name;
        public String scopeContributor;
        public transient String requestId;

    }

    @Getter
    @Setter
    public static class ActionParameter {
        public transient boolean record;
        public Rectangle location;
        public String value;
    }

    @Getter
    @Setter
    public static class Rectangle {
        public int x;
        public int y;
        public int width;
        public int height;
    }

    @Getter
    @Setter
    public static class ActionResult extends FlowResult {
        public String actionName;
        public String requestId;
    }

    @Getter
    @Setter
    public static class FlowResult {
        public boolean success;
        public String message;
        public String session;
        public String jsonString;
    }

    public enum A2aUIActionType {
        RIGHT_CLICK(RightClickInstructionHandler.class),
        LEFT_CLICK(LeftClickInstructionHandler.class),
        DOUBLE_CLICK(DoubleClickInstructionHandler.class),
        TYPE(KeyInInstructionHandler.class),
        DND(DnDInstructionHandler.class),
        WAIT(WaitInstructionHandler.class),
        MOVE(MouseMoveInstructionHandler.class),
        READ(ReadInstructionHandler.class),
        SCREENSHOT(ScreenShotInstructionHandler.class);

        private Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, A2aUIAction, ActionResult>> handlerType;

        public Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, A2aUIAction, ActionResult>> getHandlerType() {
            return handlerType;
        }

        A2aUIActionType(
                Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, A2aUIAction, ActionResult>> handlerType) {
            this.handlerType = handlerType;
        }
    }
}
