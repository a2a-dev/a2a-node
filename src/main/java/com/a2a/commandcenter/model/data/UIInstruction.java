package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.data.RightClickInstructionHandler;
import com.a2a.commandcenter.ui.DnDInstructionHandler;
import com.a2a.commandcenter.ui.DoubleClickInstructionHandler;
import com.a2a.commandcenter.ui.KeyInInstructionHandler;
import com.a2a.commandcenter.ui.LeftClickInstructionHandler;
import com.a2a.commandcenter.ui.MoveInstructionHandler;
import com.a2a.commandcenter.ui.ReadInstructionHandler;
import com.a2a.commandcenter.ui.ScreenShotInstructionHandler;
import com.a2a.commandcenter.ui.ScrollInstructionHandler;
import com.a2a.commandcenter.ui.WaitInstructionHandler;
import com.commandcenter.action.IProcessor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UIInstruction {

    public A2aAction action;

    public A2aActionFlow[] flow;

    public enum A2aAction {
        START,
        STOP,
        RECORD,
        QUEUE,
        PARALLEL,
        PAUSE,
        CONTINUE,
        RESTART,
        SKIP
    }

    @Getter
    @Setter
    public static class A2aActionFlow {
        public String flowName;
        public A2aUIAction action[];

    }

    public class A2aUIAction {
        public A2aActionType actionType;
        public ActionParameter actionParameter;
        public String name;

    }

    @Getter
    @Setter
    public static class ActionParameter {
        // This field is not part of the
        public transient boolean record;
        public Rectangle location;
        public TypeInstruction[] value;
    }

    @Getter
    @Setter
    public static class TypeInstruction {
        public String value;
        public boolean isControl;

    }

    @Getter
    @Setter
    public static class Rectangle {
        public int x;
        public int y;
        public int width;
        public int height;
    }

    public static class ActionResult {
        public boolean success;
        public long sequence;
        public String message;
        public String flowName;
        public String session;

    }

    public enum A2aActionType {
        RIGHT_CLICK(RightClickInstructionHandler.class),
        LEFT_CLICK(LeftClickInstructionHandler.class),
        DOUBLE_CLICK(DoubleClickInstructionHandler.class),
        TYPE(KeyInInstructionHandler.class),
        DND(DnDInstructionHandler.class),
        WAIT(WaitInstructionHandler.class),
        MOVE(MoveInstructionHandler.class),
        SCROLL(ScrollInstructionHandler.class),
        READ(ReadInstructionHandler.class),
        SCREENSHOT(ScreenShotInstructionHandler.class),;

        private Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult>> handlerType;

        public Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult>> getHandlerType() {
            return handlerType;
        }

        A2aActionType(
                Class<? extends IProcessor<IA2aCCDelegates, A2aCommandCenterModel, ActionParameter, ActionResult>> handlerType) {
            this.handlerType = handlerType;
        }
    }
}
