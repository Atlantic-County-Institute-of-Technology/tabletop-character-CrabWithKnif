public class Main {
    public static void main(String[] args) {
        //Creates a new character and barbarian with a name and level.
        //Then, uses the level up function and also creates a new blank character.
        //All should work.
        Character c1 = new Character("bob", 5);
        System.out.println(c1);
        c1.lvlUp();
        System.out.println(c1);
        Barbarian b1 = new Barbarian("gsd", 5);
        System.out.println(b1);
        Character c2 = new Character();
        System.out.println(c2);
    }
}
