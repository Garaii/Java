package assignment1;

public class Hornet extends Insect {
    private int attackDamage;
    public Hornet(Tile position, int hp, int attackDamage){
       super(position, hp);
       this.attackDamage = attackDamage;

    }
    //step 3
    public boolean takeAction(){
        Tile currentPosition = getPosition();
        HoneyBee beeOnTile = currentPosition.getBee();
        Tile nextTile = currentPosition.towardTheHive();
        int numTurns = 1;

        if (currentPosition.isHive()){
            return false;
        }
        else{
            if(this.isTheQueen()){
                numTurns = 2;

            }
            for (int i=0; i<numTurns; i++){
                if (currentPosition.isOnFire()){
                    this.takeDamage(BASE_FIRE_DMG);

                }
                if (beeOnTile != null){
                    beeOnTile.takeDamage(attackDamage);

                    return true;
                }
                else if (beeOnTile == null){
                    currentPosition.removeInsect(this);
                    this.setPosition(nextTile);
                    nextTile.addInsect(this);
                    return true;
                }
            }
        }

        return false;

    }
    public boolean equals(Object object){
        Hornet bug = (Hornet) object;
        boolean result = super.equals(object);

        return result && bug.attackDamage == this.attackDamage;

    }
    ///step 4

    public static int BASE_FIRE_DMG;

    private boolean isQueen = false;
    private int numQueens = 0;

    public boolean isTheQueen(){
        return isQueen;

    }

    public void promote(){

        if (isQueen == false && numQueens == 0){
            isQueen = true;
            numQueens++;
            //make hornet queen
        }

    }




}
