public class Queen extends Character{
    public Queen(WeaponBehaviour w){
        super(w);
        System.out.println("A Queen spawns.");
    }

    @Override
    public void fight(){
        System.out.print("The Queen attacks. ");
        super.fight();
    }
}
