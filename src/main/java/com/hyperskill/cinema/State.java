package com.hyperskill.cinema;

public enum State {
    SHOW, SHOW_MENU, BUY, STATISTICS, START, EXIT;

    public static State getType(String type) {
        switch (type) {
            case "1": return SHOW;
            case "2": return BUY;
            case "3": return STATISTICS;
            case "0": return  EXIT;
            default: return  START;
        }
    }
}