package com.cgi.bootstrap.adventure;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    UP,
    DOWN;

    Direction back(){
        switch(this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
        }
        return null;
    }

    static Direction fromString(final String s){
        switch(s){
            case "NORTH": return NORTH;
            case "SOUTH": return SOUTH;
            case "EAST": return EAST;
            case "WEST": return WEST;
            case "UP": return UP;
            case "DOWN": return DOWN;
        }
        return null;
    }
}
