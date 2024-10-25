public class Build  implements IArchitecture{
    /** position of Buiild */
    int position;
    /** direction of Buiild */
    int direction;
    /**  height of Buiild */
    int height;
    /** lenght of Buiild */
    int weight;

    /**
     *This constructor
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     */
    public Build(int position, int direction, int height, int weight) {
        this.position = position;
        this.direction = direction;
        this.height = height;
        this.weight = weight;
    }

    /**
     *empty constructor
     */
    public Build() {}
    /**
     * get position
     * @return  start position
     */
    public int getPosition() {return position;
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
     * this present lenght of build.
     * @return lenght
     */
    @Override
    public String present() {return "Height: "+ height;}
    /**
     *This print information of build.
     * @return print
     */
    @Override
    public String toString() {
        String yon;
        if(direction == 0 )
            yon ="Left";
        else
            yon ="Right";
        return "Build---> " +
                "position= " + position +
                ", direction= " + yon +
                ", height= " + height +
                ", weight= " + weight +
                '}';
    }
}
