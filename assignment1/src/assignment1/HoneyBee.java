package assignment1;

public abstract class HoneyBee extends Insect {
    private int costFood;

    public HoneyBee(Tile position, int hp, int costFood){
       super(position, hp);
       this.costFood = costFood;

    }
    public int getCost(){
        return costFood;
    }
    public static double HIVE_DMG_REDUCTION;

    @Override
    public void takeDamage(int damageReceived) {
        ///////////////////////////////
        Tile currentPosition = getPosition();
        HoneyBee beeOnTile = currentPosition.getBee();
        if (currentPosition.isHive()){
        //if (beeOnTile != null && currentPosition.isHive()) {
            damageReceived = (int) (damageReceived *(1 - HIVE_DMG_REDUCTION));
        }
       // int hp = getHealth() - damageReceived;

        super.takeDamage(damageReceived);


    }
}
