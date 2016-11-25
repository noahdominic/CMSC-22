public class King extends Character{
    public King(WeaponBehaviour w){
        super(w);
        System.out.println("A KING spawns.");
    }

    @Override
    public void fight(){
        System.out.print("The King attacks. ");
        super.fight();
    }
}
