package com.cgi.bootstrap.adventure;

import java.util.HashMap;
import java.util.Map;

public abstract class Place {

    String getCompleteDescription() {
        StringBuffer buf = new StringBuffer();
        if(!isSeen()) {
            buf.append("Du befindest Dich in eine(r/m) ");
            buf.append(getClass().getSimpleName());
            buf.append('\n');
            buf.append(getDescription());
        }else{
            buf.append("Du warst hier schon mal.");
        }
        buf.append("\nDu kannst gehen nach:");
        if(exits.size() == 0){
            buf.append("\nKein Ausweg.");
        }else {
            getExits().forEach((key, value) -> {
                buf.append("\n- ");
                buf.append(key);
            });
        }
        return buf.toString();
    }

    abstract void setDescription(String description);
    abstract String getDescription();

    private Map<Direction, Place> exits;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    private String name;

    private boolean isSeen() {
        return seen;
    }

    void markAsSeen() {
        seen = true;
    }

    private boolean seen;

    Place(){
        seen = false;
        this.exits = new HashMap<>();
    }

    Map<Direction, Place> getExits() {
        return exits;
    }

    void addExit(Direction direction, Place neighbour) {
        exits.put(direction, neighbour);
        neighbour.addBack(direction.back(), this);
    }

    private void addBack(Direction direction, Place neighbour) {
        exits.put(direction, neighbour);
    }

    public String toString(){
        return getClass().getSimpleName()+":"+name;
    }

}
