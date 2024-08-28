package assignment1;

public class SwarmOfHornets {
    private  Hornet[] hornets;
    private int size;
    public SwarmOfHornets() {
        this.size = 0;/////size should be 0
        this.hornets = new Hornet[0];

    }
    public int sizeOfSwarm(){

        return size;
    }
    public Hornet[] getHornets() {
        Hornet[] tempHornets = new Hornet[size];
        for (int i=0; i<size ; i++){
            if (hornets[i] != null){
                tempHornets[i] = hornets[i];

            }
        }
        return tempHornets;
    }

    public Hornet getFirstHornet(){
        if (size > 0){
            return this.hornets[0];
    }
        return null;
    }

    public void addHornet(Hornet newHornet) {
        if (newHornet.isTheQueen()){
            for (Hornet h : hornets){
                h.regenerateHealth(QUEEN_BOOST);
            }
        }
        if(this.size == this.hornets.length){// both arrays are of same size
            resize();
            size = size + 1;

            this.hornets[(this.size)-1] = newHornet;
        }
        if (this.size < this.hornets.length){
            this.hornets[this.size] = newHornet;
        }


    }
    private void resize(){
        Hornet[] bigger = new Hornet[hornets.length*2 +1];
        for (int i=0; i<size ; i++){
            bigger[i] = hornets[i];
        }
        hornets = bigger;
    }

    public boolean removeHornet(Hornet remHornet){
        /////////////////////////////
        for (int i = 0; i < size; size++){
            if (hornets[i] == remHornet){

                for (int j = i; j< size - 1; j++){

                    hornets[j] = hornets[j+1];
                }
                hornets[size-1] = null;
                size = size -1;
                return true;
            }

        }
        return false;
    }

    public static double QUEEN_BOOST;


}
