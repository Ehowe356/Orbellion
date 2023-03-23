package com.example.orbellion;

public class helion {

    private String name;
    private int health;
    private boolean active;
    private boolean dead;

    private int image;

    public helion(String name, int health, boolean active,int image){
        this.name = name;
        this.health = health;
        this.active = active;
        this.dead = false;
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void updateHealth(int n){
        this.health += n;
        if(this.getHealth()<=0){
            setDead(true);
        }
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }
}
