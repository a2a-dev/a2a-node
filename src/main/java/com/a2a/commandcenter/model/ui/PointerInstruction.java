package com.a2a.commandcenter.model.ui;

import com.a2a.commandcenter.model.data.UIInstruction.ActionParameter;
import com.a2a.commandcenter.ui.Point;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointerInstruction extends ActionParameter {
    Point point;
}
