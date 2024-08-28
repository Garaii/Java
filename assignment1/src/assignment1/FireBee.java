package assignment1;

public class FireBee extends HoneyBee{
    private int maxAttackRange;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public FireBee(Tile position, int maxAttackRange){
        super(position, BASE_HEALTH, BASE_COST);
        this.maxAttackRange = maxAttackRange;

    }

    @Override
    public boolean takeAction() {
        Tile currentPosition = getPosition();
        Tile nextTile = currentPosition.towardTheNest();
        Hornet[] hornetSwarm = currentPosition.getHornets();

        if (currentPosition.isOnThePath()) { //verifying if we are on the path
            for (int i = 0; i < maxAttackRange; i++) {
                currentPosition = currentPosition.towardTheNest();
                if (!currentPosition.isOnFire() && currentPosition.getNumOfHornets() != 0 && !currentPosition.isNest()) { //seeing if the hornets are within range

                    currentPosition.setOnFire();
                    return true;
                }

            }

        }
        return false;
    }

//    private Tile findingTile(Tile currentPosition, int maxAttackRange){
//        Tile nextTile = currentPosition.towardTheNest();
//        int i=0;
//        while (nextTile != null && maxAttackRange >= i ){
//            if (nextTile.getHornets().length >0 && !nextTile.isOnFire() ){
//                return nextTile;
//            }
//            i++;
//            nextTile = nextTile.towardTheNest();
//        }
//        return null;
//    }

}
