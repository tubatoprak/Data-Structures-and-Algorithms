public class Market extends Build {
    /**owner  of market */
    String owner;
    /**open time  of market */
    String open_time;
    /**close time  of market */
    String close_time;

    /***
     *  this constructor
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param owner owner of build.
     * @param open_time open time of build.
     * @param close_time close time of build.
     */
    public Market(int position, int direction, int height, int weight, String owner, String open_time, String close_time) {
        super(position, direction, height, weight);
        this.owner = owner;
        this.open_time = open_time;
        this.close_time = close_time;
    }

    /**
     * empty constructor
     */
    public Market() {}

    /**
     * get owner
     * @return owner of market
     */
    public String getOwner() {
        return owner;
    }

    /**
     * set owner
     * @param owner of market
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * get open time
     * @return open time of market
     */
    public String getOpen_time() {
        return open_time;
    }

    /**
     * set open time
     * @param open_time of market
     */
    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    /**
     * get close time
     * @return close time of market
     */
    public String getClose_time() {
        return close_time;
    }

    /**
     * set close time of market
     * @param close_time of market
     */
    public void setClose_time(String close_time) {
        this.close_time = close_time;
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
     * @param position of build
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
     *This print information of market.
     * @return print
     */
    @Override
    public String toString() {
        String yon;
        if(direction == 0 )
            yon ="Left";
        else
            yon ="Right";
        return "Market---> " +
                "position= " + position +
                ", direction= " + yon +
                ", height= " + height +
                ", weight= " + weight +
                ", owner= '" + owner + '\'' +
                ", open_time= '" + open_time + '\'' +
                ", close_time= '" + close_time + '\'';
    }
    /**
     * this present close time of market.
     * @return close time
     */
    @Override
    public String present() {
        return "Close Time: "+ close_time;
    }
}
