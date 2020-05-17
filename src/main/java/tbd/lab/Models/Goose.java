package tbd.lab.Models;

public class Goose {
    private long id;
    private int evilness = 666;

    public void setEvilness(int number){
        evilness = number;
    }

    public long getId(){
        return id;
    }

    public int getEvilness(){
        return evilness;
    }

    public String honk(){
        return "Honk";
    }
}

