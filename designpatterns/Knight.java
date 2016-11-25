public class Knight extends Character {
    public Knight(WeaponBehaviour w){
        super(w);
        System.out.println("A Knight spawns.");
    }

    @Override
    public void fight(){
        System.out.print("The Knight attacks. ");
        super.fight();
    }
}
