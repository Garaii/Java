package assignment1;

public class Test {
    public static void main(String[] args) {
        Hornet hornet1 = new Hornet(new Tile(),0,0);
        Hornet hornet2 = new Hornet(new Tile(),0,0);
        Hornet hornet3 = new Hornet(new Tile(),0,0);
        Hornet hornet4 = new Hornet(new Tile(),0,0);
        Hornet hornet5 = new Hornet(new Tile(),0,0);

        SwarmOfHornets firstSwarm= new SwarmOfHornets();
        firstSwarm.addHornet(hornet1);
        firstSwarm.addHornet(hornet2);
        firstSwarm.addHornet(hornet3);
        firstSwarm.addHornet(hornet4);
        firstSwarm.addHornet(hornet5);
        firstSwarm.removeHornet(hornet2);
        firstSwarm.sizeOfSwarm();
    }
}
