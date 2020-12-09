package com.company;

import javax.swing.plaf.synth.SynthScrollBarUI;
//головний клас програми
public class Main {
    public static void main(String[] args) {
        GameCreator creator = GetCreatorByName("PS");
            Game game = creator.createGame();
            game.Play();
        }
        public static GameCreator GetCreatorByName(String creator){
        if(creator.equals("PS"))
            return new PSGameCreator();
        else if (creator.equals("PC"))
            return new PCGameCreator();
        else throw new RuntimeException("Не підтримується виробництво даного типу ігор : "+ creator);
        }
    }
interface Game{
    void Play();
}
class PSGame implements Game{
    public void Play(){
        System.out.println("play PS Game");
    }
}
class PCGame implements Game{
    public void Play() {
        System.out.println("play PC Game");
    }
}
interface GameCreator{
    Game createGame();
}
 class PSGameCreator implements GameCreator{
    public Game createGame(){
        return new PSGame();
    }
}
class PCGameCreator implements GameCreator{
    public Game createGame(){
        return new PCGame();
    }
}
