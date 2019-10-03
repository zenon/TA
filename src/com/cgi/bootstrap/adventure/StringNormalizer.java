package com.cgi.bootstrap.adventure;

import java.util.Map;
import java.util.HashMap;

class StringNormalizer {
    private Map<String, String> map;

    StringNormalizer(){
        map = new HashMap<>();
        map.put("n", "NORTH");
        map.put("nord", "NORTH");
        map.put("Nord", "NORTH");
        map.put("s", "SOUTH");
        map.put("süd", "SOUTH");
        map.put("Süd", "SOUTH");
        map.put("o", "EAST");
        map.put("e", "EAST");
        map.put("ost", "EAST");
        map.put("Ost", "EAST");
        map.put("w", "WEST");
        map.put("west", "WEST");
        map.put("West", "WEST");
        map.put("u", "UP");
        map.put("oben", "UP");
        map.put("Oben", "UP");
        map.put("d", "DOWN");
        map.put("unten", "DOWN");
        map.put("Unten", "DOWN");
    }

    String normalize(final String s){
        String normalized = map.get(s);
        if(normalized == null){
            return s;
        }else{
            return normalized;
        }
    }

}
