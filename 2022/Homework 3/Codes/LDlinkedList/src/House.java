public class House extends Build {
    /**owner  of house */
    String owner;
    /**number of rooms  of house */
    int number_of_rooms;
    /**color  of house */
    String color;

    /**
     * Constructor
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param owner  owner of build.
     * @param number_of_rooms rooms of build.
     * @param color color of build.
     */
    public House(int position, int direction, int height, int weight,String owner, int number_of_rooms, String color) {
        super(position,direction,height,weight);
        this.owner = owner;
        this.number_of_rooms = number_of_rooms;
        this.color = color;
    }

    /**
     * Empty Constructor
     */
    public House() {}

    /**
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /***
     * Set owner
     * @param owner of house
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * get number of rooms
     * @return  number of rooms
     */
    public int getNumber_of_rooms() {
        return number_of_rooms;
    }

    /**
     * set  number of rooms
     * @param number_of_rooms of house
     */
    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    /**
     * get color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * set color
     * @param color of house
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get position
     * @return  start position
     */
    @Override
    public int getPosition() {
        return super.getPosition();
    }

    /**
     * set position
     * @param position of house
     */
    @Override
    public void setPosition(int position) {
        super.setPosition(position);
    }

    /**
     * get direction
     * @return direction
     */
    @Override
    public int getDirection() {
        return super.getDirection();
    }

    /**
     * set direction
     * @param direction of house
     */
    @Override
    public void setDirection(int direction) {
        super.setDirection(direction);
    }

    /**
     * get height
     * @return height
     */
    @Override
    public int getHeight() {
        return super.getHeight();
    }

    /**
     * set height
     * @param height of build
     */
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    /**
     * get lenght
     * @return weight  lenght of build.
     */
    @Override
    public int getWeight() {
        return super.getWeight();
    }

    /**
     * set lenght
     * @param weight  lenght of house
     */
    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    /**
     *This print information of house.
     * @return print
     */
    @Override
    public String toString() {
        String yon;
        if(direction == 0 )
            yon ="Left";
        else
            yon ="Right";
        return "House---> " +
                "position= " + position +
                ", direction= " + yon +
                ", height= " + height +
                ", weight= " + weight +
                ", owner= '" + owner + '\'' +
                ", number_of_rooms= " + number_of_rooms +
                ", color= '" + color + '\'' +
                ' ';
    }
    /**
     * this present owner of house.
     * @return owner
     */
    @Override
    public String present() {
        return "Owner: "+ owner;
    }
}
