package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.ui.DnDHandler;
import com.a2a.commandcenter.ui.DoubleClickHandler;
import com.a2a.commandcenter.ui.KeyInHandler;
import com.a2a.commandcenter.ui.LeftClickHandler;
import com.a2a.commandcenter.ui.MoveHandler;
import com.a2a.commandcenter.ui.ReadHandler;
import com.a2a.commandcenter.ui.RightCLickHandler;
import com.a2a.commandcenter.ui.ScreenShotHandler;
import com.a2a.commandcenter.ui.ScrollHandler;
import com.a2a.commandcenter.ui.TimerHandler;
import com.a2a.commandcenter.ui.WaitHandler;
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

    public class ActionParameter {
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
        RIGHT_CLICK(RightCLickHandler.class),
        LEFT_CLICK(LeftClickHandler.class),
        DOUBLE_CLICK(DoubleClickHandler.class),
        TIMER(TimerHandler.class),
        TYPE(KeyInHandler.class),
        DND(DnDHandler.class),
        WAIT(WaitHandler.class),
        MOVE(MoveHandler.class),
        SCROLL(ScrollHandler.class),
        READ(ReadHandler.class),
        SCREENSHOT(ScreenShotHandler.class),;

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
