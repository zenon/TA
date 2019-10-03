package com.cgi.bootstrap.adventure;

import java.util.Scanner;
import java.io.PrintStream;

public class TextAdventure {

    private Place currentPlace;
    private boolean alive;
    private PrintStream out;
    private StringNormalizer normalizer;


    public static void main(String [] args){
        TextAdventure adventure = new TextAdventure();
        try {
            adventure.initialize();
            int result = adventure.play();
            System.exit(result);
        }catch(RuntimeException re){
            System.out.println("We have a problem:");
            re.printStackTrace();
            System.exit(5);
        }
    }

    private TextAdventure(){
        alive = true;
        out = System.out;
        normalizer = new StringNormalizer();
    }

    private int play(){
        while(alive){
            playerMove();
        }
        return 0;
    }

    private void initialize(){
        Place start = new Room();
        start.setName("Start");
        start.setDescription("Es ist ein durchaus guslig aussehenden Raum.");
        Place p1 = new Path();
        p1.setName("Le Pfad");
        p1.setDescription("Ein eher verlassen wirkender Pfad.");
        start.addExit(Direction.NORTH, p1);
        Place p2 = new Room();
        p2.setName("Langweiliger Raum");
        p2.setDescription("Ein beeindruckend langweiliger Raum.");
        p1.addExit(Direction.WEST, p2);
        currentPlace = start;
    }

    private void playerMove(){
        displayInfo();
        currentPlace.markAsSeen();
        currentPlace = processInput();
    }

    private Place processInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String command = normalizer.normalize(line);
        Direction dir = Direction.fromString(command);
        if (dir != null){
            Place next = currentPlace.getExits().get(dir);
            if(next != null) {
                out.println("Gehe in Richtung "+dir+" nach "+next.getName()+".");
                return next;
            }else{
                out.println("Da ist kein Weg.");
                return currentPlace;
            }
        }else{
            out.println("Ich weiß nicht, wie ich das tun soll.");
            return currentPlace;
        }
    }

    private void displayInfo() {
        out.println(currentPlace.getCompleteDescription());
    }
}
