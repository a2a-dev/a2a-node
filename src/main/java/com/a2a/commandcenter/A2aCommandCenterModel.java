package com.a2a.commandcenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a2a.commandcenter.IA2aOrchestrator.IA2aCommandCenterModel;
import com.a2a.commandcenter.model.data.Session.SessionInfo;
import com.a2a.commandcenter.model.data.UIInstruction.A2aActionBlock;
import com.a2a.commandcenter.model.data.UIInstruction.A2aControlBlock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class A2aCommandCenterModel implements IA2aCommandCenterModel {

    Map<String, List<A2aControlBlock>> controlBlocksByName = new HashMap<>();
    Map<String, A2aActionBlock> actionBlocksByName = new HashMap<>();
    String sessionId;
    SessionInfo sessionInfo;
    FlowData<String> flowData = new FlowData<>("parent", null, null);

    @Getter
    @Setter
    public static class FlowData<T> {
        private FlowData<?> parent;
        public FlowData(String name, T value, FlowData<?> parent) {
            this.Name = name;
            this.value = value;
            this.parent = parent;
        }

        Map<String, FlowData<?>> flowData = new HashMap<>();
        String Name;
        T value;
    }

}