package model;

import javax.management.RuntimeErrorException;

public class Player {

    private String name;

    public Player(String name) {
        if(name == null || name.trim().isEmpty())
            throw new RuntimeException("Name must not be null or empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }
    

}
