package com.a2a.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.a2a.ui.ScreenRatio.RegionRect;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KeyUtil {

    public static boolean shouldContinue;

    public static Map<String, RegionRect> readRegionRects(String config, String resol) throws IOException {
        Gson g = new Gson();
        InputStream resource = KeyUtil.class.getClassLoader().getResourceAsStream("./" + config + "/" + resol + "_region.json");
        Map<String, RegionRect> regionRects = new HashMap<>();
        if (resource != null) {
            regionRects.putAll(parseRects(g, resource));
        }
        resource = KeyUtil.class.getClassLoader().getResourceAsStream("./" + resol + "_region.json");
        if (resource != null) {
            regionRects.putAll(parseRects(g, resource));
        }
        resource = KeyUtil.class.getClassLoader().getResourceAsStream("./_region.json");
        if (resource != null) {
            regionRects.putAll(parseRects(g, resource));
        }

        return regionRects;
    }
   private static Map<String, RegionRect> parseRects(Gson g, InputStream resource) {
        Type collectionType = new TypeToken<Map<String, RegionRect>>() {
        }.getType();
        Map<String, RegionRect> regionRects = g.fromJson(new InputStreamReader(resource), collectionType);
        return regionRects;
    }

    public static void keyPress(Screen s, String... key) {
        for (String i : key) {
            s.keyDown(i);
            sleep(600);
        }
        s.keyUp();
        sleep(1000);

    }
      public static void writeRegionRects(Map<String, RegionRect> regionRects, String config, String resol) throws IOException {
        Gson g = new Gson();
        File file = new File("./" + config + "/" + resol + "_region.json");
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
        g.toJson(regionRects, writer);
        writer.close();
        fileOutputStream.close();

    }

    public static void sleep(int time) {
        int seconds = (int) (time + (Math.random() * 500));
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep() {
        sleep(5000);
    }

    public static void highlightOn(Region s) {
        s.highlightOn();
    }

    public static void highlightOff(Region s) {
        s.highlightOn();
    }

    public static String getPath(String string) {
        return KeyUtil.class.getClassLoader().getResource(string).getPath();
    }

    public static void log(Object string) {
        // System.out.println(string);
    }

    public static Region create(String name, boolean captureMode) {
        RegionRect rect = ScreenRatio.getRegionMap().get(name);
        if (rect == null) {
            rect = new RegionRect(100, 100, 100, 100);
        }
        Region highlight = Region.create((int) rect.x, (int) rect.y, (int) rect.w, (int) rect.h);
        if (captureMode) {
            highlight.highlightOn();
            shouldContinue = false;
            startRecapture(highlight, name);
            while (!shouldContinue) {
                KeyUtil.sleep(1000);
            }
        }
        return highlight;
    }

    private static void startRecapture(Region highlight, String regionName) {

        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setAlwaysOnTop(true);
            stage.setResizable(true);
            FXMLLoader fxmlLoader = new FXMLLoader();
            try {
                VBox p = fxmlLoader.load(KeyUtil.class.getResource("recapture.fxml").openStream());
                CaptureController captureController = (CaptureController) fxmlLoader.getController();
                captureController.setStage(stage);
                captureController.setRegion(highlight, regionName);
                Scene scene = new Scene(p);
                scene.setFill(Color.TRANSPARENT);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.setX(highlight.x);
                stage.setY(highlight.y - 40);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void captureWindow() {
        Stage stage = new Stage();
        Pane root = new Pane();
        ImageView img = new ImageView();
        img.setImage(new Image(getClass().getResource("pathToYourPngLocatedInYourResourcesFolder.png").toExternalForm()));
        root.getChildren().add(img);
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
