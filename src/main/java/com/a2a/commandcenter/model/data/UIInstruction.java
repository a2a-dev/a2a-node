package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.data.ContinueFlowHandler;
import com.a2a.commandcenter.data.DnDInstructionHandler;
import com.a2a.commandcenter.data.DoubleClickInstructionHandler;
import com.a2a.commandcenter.data.KeyInInstructionHandler;
import com.a2a.commandcenter.data.LeftClickInstructionHandler;
import com.a2a.commandcenter.data.MoveInstructionHandler;
import com.a2a.commandcenter.data.ParallelFlowHandler;
import com.a2a.commandcenter.data.RightClickInstructionHandler;
import com.a2a.commandcenter.data.WaitInstructionHandler;
import com.a2a.commandcenter.ui.ScreenShotInstructionHandler;
import com.commandcenter.action.IProcessor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UIInstruction {

    private A2aControl action;
    public String flowName;
    private A2aActionBlock[] blocks;

    public enum A2aControl {
        START(StartFlowHandler.class),
        STOP(StopFlowHandler.class),
        QUEUE(QueueFlowHandler.class),
        PARALLEL(ParallelFlowHandler.class),
        PAUSE(PauseFlowHandler.class),
        CONTINUE(ContinueFlowHandler.class),
        RESTART(RestartFlowHandler.class);

        private Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, A2aActionBlock[], ActionResult>> handlerType;

        public Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, A2aActionBlock[], ActionResult>> getHandlerType() {
            return handlerType;
        }

        A2aControl(
                Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, A2aActionBlock[], ActionResult>> handlerType) {
            this.handlerType = handlerType;
        }
    }

    @Getter
    @Setter
    public static class A2aActionBlock {
        public A2aControlAction controlAction;
        public String expression;
        public A2aUIAction action[];

    }

    public class A2aControlAction {

    }

    @Getter
    @Setter
    public class A2aUIAction {
        public A2aUIActionType actionType;
        public ActionParameter actionParameter;
        public String name;
        A2aActionBlock flow;

    }

    @Getter
    @Setter
    public static class ActionParameter {
        // This field is not part of the
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
        public long actionName;
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
        MOVE(MoveInstructionHandler.class),
        READ(ReadInstructionHandler.class),
        SCREENSHOT(ScreenShotInstructionHandler.class);

        private Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult>> handlerType;

        public Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult>> getHandlerType() {
            return handlerType;
        }

        A2aUIActionType(
                Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult>> handlerType) {
            this.handlerType = handlerType;
        }
    }
}
