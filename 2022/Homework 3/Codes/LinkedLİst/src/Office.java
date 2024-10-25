public class Office extends  Build {
    /**job type  of office */
    String job_type;
    /**owner  of office */
    String owner;
    /**
     * This is constructor
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param job_type job type of build.
     * @param owner owner of build.
     */
    public Office(int position, int direction, int height, int weight, String job_type, String owner) {
        super(position, direction, height, weight);
        this.job_type = job_type;
        this.owner = owner;
    }

    /**
     * Empty constructor
     */
    public Office() {}

    /**
     * get job type
     * @return job type
     */
    public String getJob_type() {
        return job_type;
    }

    /**
     * set job type
     * @param job_type of street
     */
    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    /**
     * get owner
     * @return owner of office
     */
    public String getOwner() {
        return owner;
    }

    /**
     * set owner
     * @param owner of office
     */
    public void setOwner(String owner) {
        this.owner = owner;
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
     *This print information of office.
     * @return print
     */
    @Override
    public String toString() {
        String yon;
        if(direction == 0 )
            yon ="Left";
        else
            yon ="Right";
        return "Office---> " +
                "position= " + position +
                ", direction= " + yon +
                ", height= " + height +
                ", weight= " + weight +
                ", job_type= '" + job_type + '\'' +
                ", owner= '" + owner + '\'';
    }
    /**
     * this present job type of office.
     * @return job type
     */
    @Override
    public String present() {
        return "Job Types: "+job_type;
    }
}
