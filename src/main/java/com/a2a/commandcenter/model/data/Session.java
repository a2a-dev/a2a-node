package com.a2a.commandcenter.model.data;

import com.a2a.commandcenter.ui.Point;

import lombok.Getter;
import lombok.Setter;

/**
 * Session
 */
public class Session {

    @Getter
    @Setter
    public static class SessionEnd {

        private String nodeName;
        private String nodeType;
        private String operatingSystem;
        private String ipAddress;
        private String port;
        private String username;

    }

    @Getter
    @Setter
    public static class SessionInit {

        private String nodeName;
        private String nodeType;
        private String operatingSystem;
        private String ipAddress;
        private String port;
        private String username;
        private Screen[] screens;

        public static class Screen {

            String name;
            Point size;
        }

    }

}