package assignment1;

public class AngryBee extends HoneyBee{
    private int attackDamage;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public AngryBee(Tile position, int attackDamage){
        super(position, BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
    }

    @Override
    public boolean takeAction() {
        Tile currentPosition = getPosition();
        HoneyBee beeOnTile = currentPosition.getBee();

        if (currentPosition.isOnThePath() == true){
            Hornet[] hornetSwarm = currentPosition.getHornets();
            Tile nextTile = currentPosition.towardTheNest();

            if (hornetSwarm.length > 0 || nextTile.getHornets().length > 0 ){

                if (!currentPosition.isNest() || !nextTile.isNest()){
                    Hornet stingHornet = hornetSwarm[0];
                    stingHornet.takeDamage(attackDamage);

                    return true;
                }
            }
        }

        return false;
    }
}
