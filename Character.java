//Importing random and arraylists to use in the project for stats and feats
import java.util.ArrayList;
import java.util.Random;
//Creates the character class
public class Character {
    //Initializes variables used throughout both the class and subclass.
    //These are the stats, name, level, hp, ac, and feats list
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
    //Blank class constructor, for if a character is created with no elements given.
    //Initializes all variables to a base value, name to player, and pulls the hp and ac for level 1
    public Character(){
        this.name = "player";
        this.lvl = 1;
        this.str = 10;
        this.dex = 10;
        this.con = 10;
        this.intl = 10;
        this.wis = 10;
        this.cha = 10;
        //Calls the later function to calculate the hp and ac
        this.hp = calculateHP();
        this.ac = calculateAC();
        feats = new ArrayList<>();
    }
    //Class constructor that allows for the input of name and level at the start
    public Character(String name, int lvl){
        this.name = name;
        this.lvl = lvl;
        //Instead of setting all stats to 10, randomize the stats by pulling 3
        //randomly generated numbers 1-6 and adding them.
        this.str = d6(3);
        this.dex = d6(3);
        this.con = d6(3);
        this.intl = d6(3);
        this.wis = d6(3);
        this.cha = d6(3);
        this.hp = calculateHP();
        this.ac = calculateAC();
        feats = new ArrayList<>();
    }

    //Randomly generate a number n times (although for this version n is always 3)
    //The generated number is always between 1-6, by randomizing 0-5 and adding one
    private int d6(int times){
        Random rand = new Random();
        int sum = 0;
        for(int i=0; i<times;i++){
            sum += rand.nextInt(6) +1;
        }
        return sum;
    }

    //Uses the given formula to calculate hp, both at level one and
    //for any future level.
    protected int calculateHP(){
        if (lvl==1){
            hp = 10 + getAbMod(con);
        }
        else{
            hp = hp + (lvl-1) * (6+getAbMod(con));
        }
        return hp;
    }

    //Returns the calculated armor class, which is 10 with added dex mod.
    protected int calculateAC(){
        return 10+getAbMod(dex);
    }

    //Get the ability modifier of the given ability, by subtracting it by 10 and dividing by 2
    //then, because it's an int, it automatically truncates it, rounding it down.
    protected int getAbMod(int ability){
        return ((ability - 10) / 2);
    }

    //Adds one to the leve count and recalculates hp and ac
    protected void lvlUp(){
        lvl ++;
        this.hp = calculateHP();
        this.ac = calculateAC();
    }

    //Adds a feat to the arrayList feats.
    protected void addFeat(String feat){
        feats.add(feat);
    }

    //Overrides the toString to display all the stats of the newly created character.
    public String toString(){
        String outstring = "";
        outstring += "Character: " + name + " | Level: " + lvl + " | Class: " + this.getClass().getSimpleName() + "\n";
        outstring += "HP: " + hp + " | AC: " + ac +"\n";
        outstring += "STR: " + str + " | DEX: " + dex + " | CON: " + con + "\n";
        outstring += "INT: " + intl + " | Wis: " + wis + " | CHA: " + cha + "\n";
        outstring += "Feats: " + feats.toString();
        return outstring;
    }

}

//For the subclasses, first a class is created that extends the superclass, giving it access
//to all info, variables, and functions of the superclass.
class Barbarian extends Character{
    //Class constructor for an empty object.
    public Barbarian(){
        //Calls the super() function, which just gives this subclass
        //the exact same class constructor of the superclass.
        super();
        //It then raises 2 different stats depending on the class, and adds the feats given
        //by the class.
        this.str += 2;
        this.con += 1;
        addFeat("Rage");
        addFeat("Unarmored Defense");
    }
    //Class constructor when given a name and level.
    public Barbarian(String name, int lvl){
        //The same as above, except the super() function call is now
        //called with the variables needed to call that superclass class constructor
        super(name, lvl);
        this.str += 2;
        this.con += 1;
        addFeat("Rage");
        addFeat("Unarmored Defense");
    }
}

//Every other subclass follows the exact same rules as the barbarian featured above.
class Bard extends Character{
    public Bard(){
        super();
        this.cha += 2;
        this.dex += 1;
        addFeat("Inspiration");
        addFeat("Jack of all Trades");
    }
    public Bard(String name, int lvl){
        super(name, lvl);
        this.cha += 2;
        this.dex += 1;
        addFeat("Inspiration");
        addFeat("Jack of all Trades");
    }
}

class Cleric extends Character{
    public Cleric(){
        super();
        this.wis += 2;
        this.con += 1;
        addFeat("Channel Divinity");
        addFeat("Turn Undead");
    }
    public Cleric(String name, int lvl){
        super(name, lvl);
        this.wis += 2;
        this.con += 1;
        addFeat("Channel Divinity");
        addFeat("Turn Undead");
    }
}

class Druid extends Character{
    public Druid(){
        super();
        this.wis += 2;
        this.con += 1;
        addFeat("Wild Shape");
        addFeat("Commune with Nature");
    }
    public Druid(String name, int lvl){
        super(name, lvl);
        this.wis += 2;
        this.con += 1;
        addFeat("Wild Shape");
        addFeat("Commune with Nature");
    }
}

class Fighter extends Character{
    public Fighter(){
        super();
        this.dex += 2;
        this.con += 1;
        addFeat("Action Surge");
        addFeat("Second Wind");
    }
    public Fighter(String name, int lvl){
        super(name, lvl);
        this.dex += 2;
        this.con += 1;
        addFeat("Action Surge");
        addFeat("Second Wind");
    }
}

class Monk extends Character{
    public Monk(){
        super();
        this.dex += 2;
        this.wis += 1;
        addFeat("Unarmored Movement");
        addFeat("Stunning Strike");
    }
    public Monk(String name, int lvl){
        super(name, lvl);
        this.dex += 2;
        this.wis += 1;
        addFeat("Unarmored Movement");
        addFeat("Stunning Strike");
    }
}

class Paladin extends Character{
    public Paladin(){
        super();
        this.str += 2;
        this.cha += 1;
        addFeat("Divine Smite");
        addFeat("Aura of Protection");
    }
    public Paladin(String name, int lvl){
        super(name, lvl);
        this.str += 2;
        this.cha += 1;
        addFeat("Divine Smite");
        addFeat("Aura of Protection");
    }
}

class Ranger extends Character{
    public Ranger(){
        super();
        this.dex += 2;
        this.wis += 1;
        addFeat("Favored Enemy");
        addFeat("Surefooted");
    }
    public Ranger(String name, int lvl){
        super(name, lvl);
        this.dex += 2;
        this.wis += 1;
        addFeat("Favored Enemy");
        addFeat("Surefooted");
    }
}

class Rogue extends Character{
    public Rogue(){
        super();
        this.dex += 2;
        this.intl += 1;
        addFeat("Sneak Attack");
        addFeat("Uncanny Dodge");
    }
    public Rogue(String name, int lvl){
        super(name, lvl);
        this.dex += 2;
        this.intl += 1;
        addFeat("Sneak Attack");
        addFeat("Uncanny Dodge");
    }
}

class Sorcerer extends Character{
    public Sorcerer(){
        super();
        this.cha += 2;
        this.con += 1;
        addFeat("Wild Magic");
        addFeat("Flexible Spellcasting");
    }
    public Sorcerer(String name, int lvl){
        super(name, lvl);
        this.cha += 2;
        this.con += 1;
        addFeat("Wild Magic");
        addFeat("Flexible Spellcasting");
    }
}

class Warlock extends Character{
    public Warlock(){
        super();
        this.cha += 2;
        this.con += 1;
        addFeat("Eldritch Patron");
        addFeat("Pact Magic");
    }
    public Warlock(String name, int lvl){
        super(name, lvl);
        this.cha += 2;
        this.con += 1;
        addFeat("Eldritch Patron");
        addFeat("Pact Magic");
    }
}

class Wizard extends Character{
    public Wizard(){
        super();
        this.intl += 2;
        this.con += 1;
        addFeat("Arcane Recovery");
        addFeat("Spell Mastery");
    }
    public Wizard(String name, int lvl){
        super(name, lvl);
        this.intl += 2;
        this.con += 1;
        addFeat("Arcane Recovery");
        addFeat("Spell Mastery");
    }
}