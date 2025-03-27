import java.util.ArrayList;
import java.util.Random;

public class Character {

    protected int str;
    protected int dex;
    protected int con;
    protected int intl;
    protected int wis;
    protected int cha;
    protected String name;
    protected int lvl;
    protected int hp;
    protected int ac;
    protected ArrayList<String> feats;

    public Character(){
        this.name = "player";
        this.lvl = 1;
        this.str = 10;
        this.dex = 10;
        this.con = 10;
        this.intl = 10;
        this.wis = 10;
        this.cha = 10;
        this.hp = calculateHP();
        this.ac = calculateAC();
        feats = new ArrayList<String>();
    }

    public Character(String name, int lvl){
        this.name = name;
        this.lvl = lvl;
        this.str = d6(3);
        this.dex = d6(3);
        this.con = d6(3);
        this.intl = d6(3);
        this.wis = d6(3);
        this.cha = d6(3);
        this.hp = calculateHP();
        this.ac = calculateAC();
        feats = new ArrayList<String>();
    }

    private int d6(int times){
        Random rand = new Random();
        int sum = 0;
        for(int i=0; i<times;i++){
            sum += rand.nextInt(6) +1;
        }
        return sum;
    }

    protected int calculateHP(){
        if (lvl==1){
            hp = 10 + getAbMod(con);
        }
        else{
            hp = hp + (lvl-1) * (6+getAbMod(con));
        }
        return hp;
    }

    protected int calculateAC(){
        return 10+getAbMod(dex);
    }

    protected int getAbMod(int ability){
        return ((ability - 10) / 2);
    }

    protected void lvlUp(){
        lvl ++;
        this.hp = calculateHP();
        this.ac = calculateAC();
    }

    protected void addFeat(String feat){
        feats.add(feat);
    }

    public String toString(){
        String outstring = "";
        outstring += "Character: " + name + " | Level: " + lvl + " | Class\n";
        outstring += "HP: " + hp + " | AC: " + ac +"\n";
        outstring += "STR: " + str + " | DEX: " + dex + " | CON: " + con + "\n";
        outstring += "INT: " + intl + " | Wis: " + wis + " | CHA: " + cha + "\n";
        outstring += "Feats: " + feats.toString();
        return outstring;
    }

}

class Barbarian extends Character{
    public Barbarian(){
        this.str += 2;
        this.con += 1;
        addFeat("Rage");
        addFeat("Unarmored Defense");
    }
}

class Bard extends Character{
    public Bard(){
        this.cha += 2;
        this.dex += 1;
        addFeat("Inspiration");
        addFeat("Jack of all Trades");
    }
}

class Cleric extends Character{
    public Cleric(){
        this.wis += 2;
        this.con += 1;
        addFeat("Channel Divinity");
        addFeat("Turn Undead");
    }
}

class Druid extends Character{
    public Druid(){
        this.wis += 2;
        this.con += 1;
        addFeat("Wild Shape");
        addFeat("Commune with Nature");
    }
}

class Fighter extends Character{
    public Fighter(){
        this.dex += 2;
        this.con += 1;
        addFeat("Action Surge");
        addFeat("Second Wind");
    }
}

class Monk extends Character{
    public Monk(){
        this.dex += 2;
        this.wis += 1;
        addFeat("Unarmored Movement");
        addFeat("Stunning Strike");
    }
}

class Paladin extends Character{
    public Paladin(){
        this.str += 2;
        this.cha += 1;
        addFeat("Divine Smite");
        addFeat("Aura of Protection");
    }
}

class Ranger extends Character{
    public Ranger(){
        this.dex += 2;
        this.wis += 1;
        addFeat("Favored Enemy");
        addFeat("Surefooted");
    }
}

class Rogue extends Character{
    public Rogue(){
        this.dex += 2;
        this.intl += 1;
        addFeat("Sneak Attack");
        addFeat("Uncanny Dodge");
    }
}

class Sorcerer extends Character{
    public Sorcerer(){
        this.cha += 2;
        this.con += 1;
        addFeat("Wild Magic");
        addFeat("Flexible Spellcasting");
    }
}

class Warlock extends Character{
    public Warlock(){
        this.cha += 2;
        this.con += 1;
        addFeat("Eldritch Patron");
        addFeat("Pact Magic");
    }
}

class Wizard extends Character{
    public Wizard(){
        this.intl += 2;
        this.con += 1;
        addFeat("Arcane Recovery");
        addFeat("Spell Mastery");
    }
}