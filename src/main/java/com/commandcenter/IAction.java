package com.commandcenter;

public interface IAction {

    public static interface DataDelegate extends IAction {

    }

    public static interface UIDesignDelegate extends IAction {

    }

    public static interface UIAction extends IAction {

    }

    public static interface CommandCenterAction extends IAction {

    }

}
