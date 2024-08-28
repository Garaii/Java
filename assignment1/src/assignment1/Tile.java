package assignment1;

public class Tile {
    private int food;
    private boolean hasBeeHive;
    private boolean hasHornetNest;

    private boolean isOnPath;
    private Tile pathToHive;
    private Tile pathToNest;
    private HoneyBee bee;
    private SwarmOfHornets hornets;

    public Tile(){
        this.food = 0;
        this.hasBeeHive = false;
        this.hasHornetNest = false;
        this.isOnPath = false;
        this.pathToHive = null;
        this.pathToNest = null;
        this.bee = null;
        this.hornets = new SwarmOfHornets();

    }
    public Tile(int food, boolean hasBeeHive,boolean hasHornetNest,boolean isOnPath, Tile pathToHive,
                Tile pathToNest,HoneyBee bee,SwarmOfHornets positionHornets ){

        this.food = food;
        this.hasBeeHive = hasBeeHive;
        this.hasHornetNest = hasHornetNest;
        this.isOnPath = isOnPath;
        this.pathToHive = pathToHive;
        this.pathToNest = pathToNest;
        this.bee = bee;
        if (positionHornets == null){
            this.hornets = new SwarmOfHornets();
        }else{
            this.hornets = positionHornets;
        }


    }
    public boolean isHive(){
        return hasBeeHive;
    }
    public boolean isNest(){
        return hasHornetNest;
    }

    public void buildHive(){
        hasBeeHive = true;
    }
    public void buildNest(){
        hasHornetNest = true;
    }

    public boolean isOnThePath(){
        return isOnPath;
    }

    public Tile towardTheHive(){
        if(isOnPath && pathToHive !=null && !hasBeeHive ){
            return pathToHive;
        }
        return null;
    }
    public Tile towardTheNest(){
        if(isOnPath && pathToNest != null && !hasHornetNest){
            return pathToNest;
        }
        return null;
    }

    public void createPath(Tile pathToHive, Tile pathToNest){
        // cant be null and not have hive or null and not nest
        this.isOnPath = true;
        this.pathToHive = pathToHive;
        this.pathToNest = pathToNest;

        if (this.pathToHive == null && isHive() == false){
            throw new IllegalArgumentException("This tile is not part" +
                    " of the path to the hive");
        }
        if (this.pathToNest == null && isNest() == false){
            throw new IllegalArgumentException("This tile is not part" +
                    " of the path to the nest");
        }

    }



    public int collectFood(){
        int takeFood = food;
        food = 0;
        return takeFood;
    }
    public void storeFood(int amountFood){
        this.food += amountFood;
    }
    public int getNumOfHornets(){
        return hornets.sizeOfSwarm();
    }
    public HoneyBee getBee(){
        return bee;
    }
    public Hornet getHornet(){
       Hornet[] hornetArr = hornets.getHornets();
       if (hornetArr.length > 0){
           return hornetArr[0];
       }
       return null;
    }
    public Hornet[] getHornets(){
        return hornets.getHornets(); /////
    }


    //step 2
    public boolean addInsect(Insect insect){
        if ( insect instanceof HoneyBee && bee == null && hasHornetNest == false){
            bee = (HoneyBee) insect;
            return true;
        } else if (insect instanceof Hornet && isOnPath == true) {
            hornets.addHornet((Hornet) insect);
            return true;
        }
        return false;
    }
    public boolean removeInsect(Insect insect){
        if (insect instanceof HoneyBee && bee == insect){
            bee = null;
        }

        else if (insect instanceof Hornet){
            hornets.removeHornet((Hornet) insect);
        }
        return false;
    }
    ////Step 4
    private boolean onFire = false;

    public void setOnFire() {
        this.onFire = true;
    }
    public boolean  isOnFire(){
        return onFire;
    }

}
