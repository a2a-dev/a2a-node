package com.a2a.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.sikuli.script.Screen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ScreenRatio {

    int screenWidth;
    int screenHeight;
    private static Map<String, RegionRect> regionMap = new HashMap<>();
    private String config;
    static Map<String, ScreenRatio> screenRatioMap = new HashMap<>();

    @Getter
    @Setter
    @AllArgsConstructor
    public static class RegionRect {

        double x;
        double y;
        double w;
        double h;
    };

    public static ScreenRatio getInstance(String config) {
        if (!screenRatioMap.containsKey(config)) {
            ScreenRatio sr = new ScreenRatio(config);
            screenRatioMap.put(config, sr);
        }
        return screenRatioMap.get(config);
    }

    private ScreenRatio(String config) {

        this.config = config;
        screenWidth = (int) Screen.getPrimaryScreen().getBounds().getWidth();
        screenHeight = (int) Screen.getPrimaryScreen().getBounds().getHeight();

        try {
            regionMap.putAll(KeyUtil.readRegionRects(config, +screenWidth + "x" + screenHeight));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save() {
        try {
            KeyUtil.writeRegionRects(regionMap, config, "" + screenWidth + "x" + screenHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ScreenRatio screenRatio = new ScreenRatio("bovada");
        KeyUtil.log("" + screenRatio.getScreenHeight());
        KeyUtil.log("" + screenRatio.getScreenWidth());
        getRegionMap().forEach((k, v) -> {
            KeyUtil.log(k + " -> x:" + v.x + " y: " + v.y + " W: " + v.w + " H: " + v.h);
        });
        System.err.println("--------------");
        getRegionMap().put("arg0", new RegionRect(100, 100, 100, 100));

        getRegionMap().forEach((k, v) -> {
            KeyUtil.log(k + " -> x:" + v.x + " y: " + v.y + " W: " + v.w + " H: " + v.h);
        });
        screenRatio.save();
    }

    public static Map<String, RegionRect> getRegionMap() {
        return regionMap;
    }

}
