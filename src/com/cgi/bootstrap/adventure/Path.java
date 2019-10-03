package com.cgi.bootstrap.adventure;

public class Path extends Place {

    private String description;

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription(){
        return description+"\nDer Pfad ist nur fast grade. Also eigentlich gar nicht.";
    }

}
