package assignment1;

public abstract class Insect {

        private Tile position;
        private int hp; //healthpoints


        public Insect( Tile position , int hp){
            this.position = position;
            this.hp = hp;
            if ( position.addInsect(this) == false){
                throw new IllegalArgumentException("Cannot add insect.");
            }


            ///when an insect with a specified position is created, such insect is also added to the corresponding tile.
             //if bee cannot do it throw illegalargumentexception
        }
        public final Tile getPosition(){

            return this.position;
        }
        public final int getHealth(){

            return this.hp;
        }

        public void setPosition(Tile updatedPosition){
            this.position = updatedPosition;
            //updates the value stored in the appropriate field.
        }
        public void takeDamage(int damageReceived){
            this.hp -= damageReceived;
            if (this.hp <= 0 ){
                this.position.removeInsect(this);
                this.position = null;
            }

        }
        public abstract boolean takeAction();

        public boolean equals(Object object){
            if (object instanceof Insect){
                Insect x = (Insect) object;
                return this.position == x.position && this.hp == x.hp;

            }
            else{
            return false;
            }

        }
        public void regenerateHealth(double percentHealth){
            this.hp =  (int)(this.hp + (percentHealth*this.hp));
        }


}
