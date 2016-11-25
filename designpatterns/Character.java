public class Character{
    private WeaponBehaviour weapon;

    public Character(WeaponBehaviour w){
        setWeapon(w);
    }

    public void setWeapon(WeaponBehaviour w){
        this.weapon = w;
    }

    public void fight(){
        weapon.useWeapon();
    }
}
