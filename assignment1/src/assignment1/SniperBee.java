package assignment1;

public class SniperBee extends HoneyBee{
    private int attackDamage;
    private int piercingPower;
    private boolean isAiming = true; ///ARE WE STARTING WITH AIMING

    public static int BASE_HEALTH;
    public static int BASE_COST;

    private boolean shooting;

    public SniperBee(Tile position, int attackDamage, int piercingPower){
        super(position, BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
        this.piercingPower = piercingPower;
        this.shooting = false;
    }


    public boolean takeAction(){
        if (this.getPosition().isOnThePath() && !this.shooting){
            this.shooting = true;
        }
        else if (this.getPosition().isOnThePath() && this.shooting){
            this.shooting = false;
            Tile next = this.getPosition().towardTheNest();
            while (next.getNumOfHornets() == 0){
                next = this.getPosition().towardTheNest();
            }
            if (next.isNest()){
                return false;
            }
            int min = Math.min(this.piercingPower, next.getNumOfHornets());
            Hornet[] hornetsSwarm = next.getHornets();
            for (int i = 0; i < min; i++){
                hornetsSwarm[i].takeDamage(this.attackDamage);
            }return true; }
        return false;
    }
}

