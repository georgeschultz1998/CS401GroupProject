package characters;

public class CharacterGenerator {

    public static void main(String[] args) {
        Tinkerer tinkerer = new Tinkerer("Foo", 100, 0 , 0, 6,5);
        Cragheart crag = new Cragheart("Bar", 100, 1, 1, 12,5);
        Brute brute = new Brute("Buzz",100,2,2,3,5);

        System.out.println(tinkerer.toString());
        System.out.println(crag.toString());
        System.out.println(brute.toString());
    }
}
