public class PlayGround implements IArchitecture {
    /** position of playground */
    int position;
    /** direction of playground */
    int direction;
    /**  height of playground */
    int height;
    /**  lenght of playground */
    int weight; // lenght
    /**
     * This Constructor
     * @param position position of playground.
     * @param direction direction of playground.
     * @param height height of playground.
     * @param weight lenght of playground.
     */
    public PlayGround(int position, int direction, int height, int weight) {
        this.position = position;
        this.direction = direction;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Empty Constructor
     */
    public PlayGround() {}
    /**
     * get direction
     * @return direction
     */
    public int getPosition() {
        return position;
    }
    /**
     * set position
     * @param position of build
     */
    public void setPosition(int position) {
        this.position = position;
    }
    /**
     * get direction
     * @return direction
     */
    public int getDirection() {
        return direction;
    }
    /**
     * set direction
     * @param direction of house
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    /**
     * get height
     * @return height
     */
    public int getHeight() {
        return height;
    }
    /**
     * set height
     * @param height of build
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * get lenght
     * @return weight  lenght of build.
     */
    public int getWeight() {
        return weight;
    }
    /**
     * set lenght
     * @param weight  lenght of house
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     *This print information of playground.
     * @return print
     */
    @Override
    public String toString() {
        String yon;
        if(direction == 0 )
            yon ="Left";
        else
            yon ="Right";
        return "PlayGround---> " +
                "position= " + position +
                ", direction= " + yon +
                ", height= " + height +
                ", weight= " + weight +
                '}';
    }
    /**
     * this present lenght of playground.
     * @return lenght
     */
    @Override
    public String present() {
        return "Playground Lenght: "+ weight;
    }
}
