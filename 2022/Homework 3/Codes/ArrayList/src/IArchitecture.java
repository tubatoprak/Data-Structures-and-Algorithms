public interface IArchitecture  {
    /**
     * get position
     * @return  start position
     */
    int getPosition();
    /**
     * set position
     * @param position of build
     */
    void setPosition(int position);
    /**
     * get direction
     * @return direction
     */
    int getDirection();
    /**
     * set direction
     * @param direction of house
     */
    void setDirection(int direction);
    /**
     * get height
     * @return height
     */
    int getHeight();
    /**
     * set height
     * @param height of build
     */
    void setHeight(int height);
    /**
     * get lenght
     * @return weight  lenght of build.
     */
    int getWeight();
    /**
     * set lenght
     * @param weight  lenght of house
     */
    void setWeight(int weight);
    /**
     * this present lenght of build.
     * @return lenght
     */
    String present();
    /**
     *This print information of build/playground.
     * @return print
     */
    String toString();
}
