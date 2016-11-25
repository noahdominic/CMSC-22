public class CharacterTest {
    public static void main (String args[]) {
        WeaponBehaviour w = new SwordBehaviour();
        new King(w).fight();
        new Queen(w).fight();
        new Knight(w).fight();
        new Troll(w).fight();

        w = new BowAndArrowBehaviour();
        new King(w).fight();
        new Queen(w).fight();
        new Knight(w).fight();
        new Troll(w).fight();

        w = new AxeBehaviour();
        new King(w).fight();
        new Queen(w).fight();
        new Knight(w).fight();
        new Troll(w).fight();

        w = new KnifeBehaviour();
        new King(w).fight();
        new Queen(w).fight();
        new Knight(w).fight();
        new Troll(w).fight();
    }
}
