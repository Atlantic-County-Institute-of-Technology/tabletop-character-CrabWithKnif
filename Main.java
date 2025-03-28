public class Main {
    public static void main(String[] args) {
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
