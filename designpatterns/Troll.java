public class Troll extends Character {
    public Troll(WeaponBehaviour w){
        super(w);
        System.out.println("A Troll spawns.");
    }

    @Override
    public void fight(){
        System.out.print("The Troll attacks. ");
        super.fight();
    }
}
