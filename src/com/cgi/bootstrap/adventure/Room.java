package com.cgi.bootstrap.adventure;

public class Room extends Place {

    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description+"\nWie jeder Raum hat er vier Wände, einen Fußboden und eine Decke.";
    }

}
