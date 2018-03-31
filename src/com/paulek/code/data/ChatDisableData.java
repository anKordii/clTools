package com.paulek.code.data;

import java.util.ArrayList;
import java.util.List;

public class ChatDisableData {

    private static boolean ischaton = true;
    private static List<String> list = new ArrayList<>();
    private static List<String> tocenzor = new ArrayList<>();
    private static boolean enablecenzor = true;

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        ChatDisableData.list = list;
    }

    public static boolean isIschaton() {

        return ischaton;
    }

    public static void setIschaton(boolean ischaton) {
        ChatDisableData.ischaton = ischaton;
    }

    public static List<String> getTocenzor() {
        return tocenzor;
    }

    public static void setTocenzor(List<String> tocenzor) {
        ChatDisableData.tocenzor = tocenzor;
    }

    public static boolean isEnablecenzor() {
        return enablecenzor;
    }

    public static void setEnablecenzor(boolean enablecenzor) {
        ChatDisableData.enablecenzor = enablecenzor;
    }
}
