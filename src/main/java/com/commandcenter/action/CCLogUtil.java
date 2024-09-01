package com.commandcenter.action;

public class CCLogUtil {
    static boolean verboseEnabled = true;

    public final static void verbose(String string) {
        if (verboseEnabled) {
            System.out.println(string);
        }
    }

}
