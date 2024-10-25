import java.util.Scanner;
public class Street {
    /**   street lenght of street */
    int street_length;  // of lenght street
    /** left land of street */
    Build [] landleft;
    /** right land of street */
    Build [] landright;
    /** playground land  of street */
    PlayGround[] landplay;
    /**  number Of Playground  of street */
    int numberOfPlayground = 0;
    /**  number Of Buildleft  of street */
    int numberOfBuildleft = 0;
    /**  number Of Buildright  of street */
    int numberOfBuildright = 0;
    /**It  holds the building parts of the Left land */
    int[] controlleft ;
    /**It  holds the building parts of the right land */
    int[] controlright;
    /**It  holds the heights of the Left land */
    int[] heightleft;
    /**It  holds the heights of the Right land */
    int[] heightright;
    /**It  holds  number of total builds*/
    int totalBuild = 0;
    /**It  holds  number of total playgrounds*/
    int totalplaygrounds = 0;

    Scanner input = new Scanner(System.in);

    /**
     * @param street_length lenght of street
     */
    public Street(int street_length) {
        this.street_length = street_length;
        controlleft = new int[street_length] ;
        controlright = new int[street_length];
        heightleft = new int[street_length] ;
        heightright = new int[street_length];
        for (int i = 0; i < street_length-1; i++) {
            controlleft[i] = 0;
            controlright[i] = 0;
        }

    }
    /**
     *  This func. adds buildings in pdf.
     */
    public void driver(){
        addHouse(0,1,7,8,"Tuba Toprak",4,"Pink");
        addHouse(12,1,7,14,"Ali Agaoğlu",5,"White");
        addHouse(40,1,5,5,"Han Derenoglu",2,"Black");
        addMArket(50,1,5,5,"Carrefoursa As.","08:55","23:55");

        addplayground(5,0,1,15);
        addoffice(20,0,10,10,"Finans","Sakıp Sabancı");
        addoffice(45,0,7,5,"Transportation","Turkish Airlines");
    }

    /**
     * it prints the silhouette image.
     */
    public void display_skyline(){

        int highest = heightleft[0];
        int[] temp = new int[street_length];
        int[] temp_free = new int[street_length];

        for (int i = 0; i <street_length ; i++) {
            if(heightleft[i] <= heightright[i])          // en yüksek değerler bir arrayde
                temp[i] =heightright[i];
            if (heightright[i] < heightleft[i])
                temp[i] =heightleft[i];

            if (controlright[i] == 1 || controlleft[i] == 1 )   // hangi yer dolu ,hangi yer boş
                    temp_free[i] = 1;
            if (controlright[i] == 0 && controlleft[i] == 0 )
                temp_free[i] = 0;

        }
        for (int i = 0; i < street_length; i++) {    //en büyük height değeri bulmak için
            if(highest <temp[i])
                highest = temp[i];
        }

        for (int j = highest; 0 < j ; j--) {
            for (int i = 0; i < street_length; i++) {
                if (temp[i] == j) {
                    if(i < street_length-1)
                        if (temp[i] < temp[i + 1])
                            System.out.print("|");
                        else
                            System.out.print("_");
                    else
                        System.out.print("_");
                }
                else if (i == street_length-1 || i == 0) {
                    if (i == 0) {
                        if (temp[i] != 0 && j < temp[i])
                            System.out.print("|");
                        else
                            System.out.print(" ");
                    }
                    else{
                        if (temp[i] != 0 && j < temp[i])
                            System.out.print("|");
                        else
                            System.out.print(" ");
                    }
                }
                else{
                    if (temp[i] <= j && temp[i+1] > j )
                        System.out.print("|");
                    else if (temp[i] >= j && temp[i+1] <= j)
                        System.out.print("|");
                    else
                        System.out.print(" ");
                }

            }
            System.out.print("\n");
        }
        System.out.print("|");
        for (int i = 1; i < street_length-1; i++) {
            if(temp_free[i]==1 &&  temp_free[i+1]==0)
                System.out.print("|");
            else if(temp_free[i] == 0 && temp_free[i+1] == 1)
                System.out.print("|");
            else
                System.out.print("_");
        }
        System.out.print("|");
        System.out.println("\n");
    }

    /**
     * This runs edit mode
     */
    public void editMode(){
        boolean exit1 = true;
        while (exit1){
            System.out.println("----Edit Mode----");
            System.out.println("1- Add Building");
            System.out.println("2- Remove Building");
            System.out.println("3- Back");
            System.out.print("Please enter choice: ");
            int inp = input.nextInt();
            switch (inp){
                case 1 :
                    boolean exit = true;
                    while (exit) {
                        System.out.println("1- House");
                        System.out.println("2- Market");
                        System.out.println("3- Office");
                        System.out.println("4- PlayGround");
                        System.out.println("5- Exit");
                        System.out.print("Please select type Building: ");
                        int type = input.nextInt();
                        int height, rooms, position, side, lenght;
                        String job, owner, open_time, close_time, color;
                        switch (type) {
                            case 1:
                                System.out.print("Please enter position: ");
                                position = input.nextInt();
                                System.out.print("Please select the direction (0-Left ,1- Right): ");
                                side = input.nextInt();
                                System.out.print("Please enter the height: ");
                                height = input.nextInt();
                                System.out.print("Please enter the lenght: ");
                                lenght = input.nextInt();
                                System.out.print("Please enter owner: ");
                                input.nextLine();
                                owner = input.nextLine();
                                System.out.print("Please enter number of rooms: ");
                                rooms = input.nextInt();
                                System.out.print("Please enter color: ");
                                input.nextLine();
                                color = input.nextLine();
                                addHouse(position, side, height, lenght, owner, rooms, color);
                                break;
                            case 2:
                                System.out.print("Please enter position: ");
                                position = input.nextInt();
                                System.out.print("Please select the direction (0-Left ,1- Right): ");
                                side = input.nextInt();
                                System.out.print("Please enter the height: ");
                                height = input.nextInt();
                                System.out.print("Please enter the lenght: ");
                                lenght = input.nextInt();
                                System.out.print("Please enter owner: ");
                                input.nextLine();
                                owner = input.nextLine();
                                System.out.print("Please enter open_time: ");
                                input.nextLine();
                                open_time = input.nextLine();
                                System.out.print("Please enter close_time: ");
                                input.nextLine();
                                close_time = input.nextLine();
                                addMArket(position, side, height, lenght, owner, open_time, close_time);
                                break;
                            case 3:
                                System.out.print("Please enter position: ");
                                position = input.nextInt();
                                System.out.print("Please select the direction (0-Left ,1- Right): ");
                                side = input.nextInt();
                                System.out.print("Please enter the height: ");
                                height = input.nextInt();
                                System.out.print("Please enter the lenght: ");
                                lenght = input.nextInt();
                                System.out.print("Please enter owner: ");
                                input.nextLine();
                                owner = input.nextLine();
                                System.out.print("Please enter job_type: ");
                                job = input.nextLine();
                                addoffice(position, side, height, lenght, job, owner);
                                break;
                            case 4:
                                System.out.print("Please enter position: ");
                                position = input.nextInt();
                                System.out.print("Please select the direction (0-Left ,1- Right): ");
                                side = input.nextInt();
                                System.out.print("Please enter the height: ");
                                height = input.nextInt();
                                System.out.print("Please enter the lenght: ");
                                lenght = input.nextInt();
                                addplayground(position,side,height,lenght);
                                break;
                            case 5:
                                exit = false;
                                break;
                            default:
                                System.out.println("Invalid Choice..");
                        }
                    }
                    break;
                case 2: removebuilds();
                    break;
                case 3 :
                    exit1 = false;
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }


    }

    /**
     * This runs viewing mode
     */
    public void viewingMode(){
        boolean exit1 = true;
        while (exit1){
            System.out.println("----Viewing Mode----");
            System.out.println("1- display the total remaining length of lands on the street");
            System.out.println("2- display the list of buildings on the street.");
            System.out.println("3- display the number and ratio of lenth of playgrounds in the street.");
            System.out.println("4- calculate the total length of street occupied by the markets, houses or offices.");
            System.out.println("5- display the skyline silhouette of the street");
            System.out.println("6- Focus Mode");
            System.out.println("7- Back");
            System.out.print("Please enter choice: ");
            int inp = input.nextInt();
            switch (inp){
                case 1: System.out.println("Length of free land on the street: " + free_land() +" metre2");
                    break;
                case 2: listofBuilding();
                    break;
                case 3: print_playground_feature();
                    break;
                case 4: calculate_lenght_build();
                    break;
                case 5: display_skyline();
                    break;
                case 6:focus();
                    break;
                case 7: exit1 = false;
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }

    /**
     * this run menus
     */
    public void driver_menu(){

        boolean exit2 = true;
        while(exit2){
            System.out.println("-----Welcome to StrangerVille Street-----");
            System.out.println("1-- Edit Mode");
            System.out.println("2-- View Mode");
            System.out.println("3-- Exit");
            System.out.print("Please enter choice: ");
            int inp = input.nextInt();
            switch (inp){
                case 1:editMode();
                    break;
                case 2: viewingMode();
                    break;
                case 3:exit2 = false;
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }
        //printcontrol();
    }

    /**
     * This run focus mode
     */
    public void focus(){
        int choice;
        boolean exit = true;
        while(exit){
            System.out.print("Please select the direction you want to focus on (0-Left Side,1- Right Side,2- Back): ");
            int inp = input.nextInt();
            switch (inp){
                case 0:
                    try {
                        System.out.println("the number of Building on the left of the street: " +(landleft.length));
                        System.out.print("Please select the number of the build you want to focus on: ");
                        choice = input.nextInt();
                        System.out.println(landleft[choice-1].present());
                    } catch (Exception e) {
                        System.out.println("you are trying to call the building that does not exist!!!");
                    }
                    break;
                case 1:
                    try{
                        System.out.println("the number of Building on the left of the street: " +(landright.length));
                        System.out.print("Please select the number of the build you want to focus on: ");
                        choice = input.nextInt();
                        System.out.println(landright[choice-1].present());
                    }catch (Exception de){
                        System.out.println("you are trying to call the building that does not exist!!!");
                    }
                   break;
                case 2: exit = false;
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }

    /**
     * This print list of Building
     */
    public void  listofBuilding(){
        System.out.println("---Buildings to the left of the street---");
        for (int i = 0; i < numberOfBuildleft; i++) {
            System.out.println(landleft[i].toString());
        }
        System.out.println("---Buildings to the right of the street---");
        for (int i = 0; i < numberOfBuildright; i++) {
            System.out.println(landright[i].toString());
        }
    }

    /**
     * This print playground feature
     */
    public void  print_playground_feature(){
        int i;
        for (i = 0; i < landplay.length; i++) {
                System.out.println(i+1 + ". Playground Lenght "+ landplay[i].getWeight());
                totalplaygrounds +=  landplay[i].getWeight();
            }
        System.out.println("There are " + i + " playgrounds on the street.");
        System.out.println("Total length of playgrounds on the street: "+ totalplaygrounds+" metre2");
        System.out.println("Ratio of lenght of playgrounds: " +totalplaygrounds+"/"+2*street_length +" metre2");
    }

    /**
     * This calculate the total length of street occupied by the markets, houses or offices.
     */
    public void calculate_lenght_build(){
        Market market = new Market();
        House  house = new House();
        Office office = new Office();

        int totalhouse = 0;
        int totalmarket = 0;
        int totaloffice = 0;

        for (Build i : landleft) {
            if (i.getClass() == market.getClass())
                totalmarket += i.getWeight();
            if (i.getClass() == office.getClass())
                totaloffice += i.getWeight();
            if (i.getClass() == house.getClass())
                totalhouse += i.getWeight();
        }

        for (Build build : landright) {
            if (build.getClass() == market.getClass())
                totalmarket += build.getWeight();
            if (build.getClass() == office.getClass())
                totaloffice += build.getWeight();
            if (build.getClass() == house.getClass())
                totalhouse += build.getWeight();
        }
        totalBuild = totalmarket +totalhouse+totaloffice;
        System.out.println("Total length of street occupied by Markets: " + totalmarket+" metre2");
        System.out.println("Total length of street occupied by Offices: " + totaloffice +" metre2");
        System.out.println("Total length of street occupied by Houses: " + totalhouse +" metre2");
    }

    /**
     * This return the total remaining length of lands on the street.
     * @return  the empty space on the street
     */
    public int free_land(){
        int temp = totalBuild + totalplaygrounds;
        return 2*street_length - temp;
    }

    /***
     *  this print Arrays containing the street information
     */
    public void printcontrol(){
        for (int i = 0; i < street_length; i++) {
            System.out.println(""+controlleft[i]+heightleft[i]+ "| | | "+ controlright[i]+heightright[i]);
        }
    }

    /**
     *  This function checks if the land is suitable
     * @param control land
     * @param position start position of build
     * @param weight  lenght of build
     * @return true or false
     */
    public boolean controlland(int[] control, int position, int weight){
        int temp = position + weight;
        for (int i = position; i < temp ;i++) {
            if(control[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * this set lands of street.
     * @param control lands of street
     * @param position position of build
     * @param weight position of lenght
     * @param controlheight to hold height
     * @param height height of lenght
     * @param select To separate that add and remove
     */
    public void setcontrol(int[] control, int position, int weight,int[] controlheight,int height,int select){
        int totallenght = position + weight;     // select 1 or 0. 1 add fonk, 0 is remove fonk.
        for (int i = position; i < totallenght ;i++) {
            control[i] = select;
            controlheight[i] = height;
        }
    }

    /**
     * This add house in street.
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param owner  owner of build.
     * @param rooms rooms of build.
     * @param color color of build.
     */
    public void addHouse(int position, int direction, int height, int weight, String owner, int rooms, String color){
        House house = new House(position,direction,height,weight,owner,rooms,color);
        if (setadd(position,direction,height,weight,house))
            System.out.println("A House has been added in  the street.");
    }

    /***
     *  this add market in street.
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param owner owner of build.
     * @param open_time open time of build.
     * @param close_time close time of build.
     */
    public void addMArket(int position, int direction, int height, int weight, String owner, String open_time, String close_time){
        Market market = new Market(position,direction,height,weight,owner,open_time,close_time);
        if (setadd(position,direction,height,weight,market))
            System.out.println("A Market has been added in  the street.");
    }

    /**
     * This add office in street.
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param job_type job type of build.
     * @param owner owner of build.
     */
    public void addoffice(int position, int direction, int height, int weight, String job_type, String owner){
        Office office = new Office(position,direction,height,weight,job_type,owner);
        if (setadd(position,direction,height,weight,office))
            System.out.println("A Office has been added in  the street.");
    }

    /**
     * This set add setting
     * @param position position of build.
     * @param direction direction of build.
     * @param height height of build.
     * @param weight lenght of build.
     * @param build  hold builds in street.
     * @return true or false  whether a building has been added
     */
    public boolean setadd(int position,int direction,int height,int weight,Build build){
        if(direction == 0) {
            if(controlland(controlleft,position,weight)){
                if(numberOfBuildleft == 0 ){
                    landleft = new Build[1];
                    landleft[numberOfBuildleft] = build;
                }else{
                    Build [] temp = new Build[numberOfBuildleft+1];
                    if (numberOfBuildleft >= 0) System.arraycopy(landleft, 0, temp, 0, numberOfBuildleft);
                    temp[numberOfBuildleft] = build;
                    landleft = temp;
                }
                numberOfBuildleft++;
                setcontrol(controlleft,position,weight,heightleft,height,1);
                return true;
            }
            else
                System.out.println("The area you want to build is not available.");
        }
        if (direction == 1){
            if(controlland(controlright,position,weight)){
                if(numberOfBuildright == 0 ){
                    landright = new Build[1];
                    landright[numberOfBuildright] = build;
                }else{
                    Build [] temp = new Build[numberOfBuildright+1];
                    if (numberOfBuildright >= 0) System.arraycopy(landright, 0, temp, 0, numberOfBuildright);
                    temp[numberOfBuildright] = build;
                    landright = temp;
                }
                numberOfBuildright++;
                setcontrol(controlright,position,weight,heightright,height,1);
                return true;
            }
            else
                System.out.println("The area you want to build is not available.");
        }
        return false;
    }

    /**
     * this add playgrouds in street.
     * @param position position of playground.
     * @param direction direction of playground.
     * @param height height of playground.
     * @param weight lenght of playground.
     */
    public void addplayground(int position, int direction, int height, int weight){
        PlayGround ground = new PlayGround(position,direction,1,weight);
        if(direction == 0) {
            if(controlland(controlleft,position,weight)){
                if(numberOfPlayground == 0 ){
                    landplay = new PlayGround[1];
                    landplay[numberOfPlayground] = ground;
                }else{
                    PlayGround [] temp = new PlayGround[numberOfPlayground+1];
                    if (numberOfPlayground >= 0) System.arraycopy(landplay, 0, temp, 0, numberOfPlayground);
                    temp[numberOfPlayground] = ground;
                    landplay = temp;
                }
                numberOfPlayground++;
                setcontrol(controlleft,position,weight,heightleft,height,1);
                System.out.println("A Playground has been added in  the street.");
            }
            else
                System.out.println("The area you want to build is not available.");
        }
        if (direction == 1){
            if(controlland(controlright,position,weight)){
                if(numberOfPlayground == 0 ){
                    landplay = new PlayGround[1];
                    landplay[numberOfPlayground] = ground;
                }else{
                    PlayGround[] temp = new PlayGround[numberOfPlayground+1];
                    if (numberOfPlayground >= 0) System.arraycopy(landplay, 0, temp, 0, numberOfPlayground);
                    temp[numberOfPlayground] = ground;
                    landplay = temp;
                }
                numberOfPlayground++;
                setcontrol(controlright,position,weight,heightright,height,1);
                System.out.println("A Playground has been added in  the street.");
            }
            else
                System.out.println("The area you want to build is not available.");
        }
    }

    /**
     * This remove build in street.
     */
    public void removebuilds(){
        boolean exit = true;
        while (exit) {
            System.out.print("Please select the direction you want to delete on (0-Left Side,1- Right Side,2- Back): ");
            int inp = input.nextInt();
            int choice;
            int index = 0;
            switch (inp) {
                case 0:
                    try {
                        System.out.println("---Buildings to the left of the street---");
                        for (Build i : landleft) {
                            System.out.println(index+". "+i.toString());
                            index++;
                        }
                        System.out.print("Please select the building you want to delete ");
                        choice = input.nextInt();
                        Build[] anotherArray = new Build[street_length];
                        int temp = landleft[choice].getWeight();
                        int pos = landleft[choice].getPosition();
                        for (int i = 0, k = 0; i < landleft.length; i++) {
                            if (i == choice) {
                                continue;
                            }
                            anotherArray[k++] = landleft[i];
                        }
                        landleft = anotherArray;
                        setcontrol(controlleft,pos,temp,heightleft,0,0);
                        numberOfBuildleft--;
                        System.out.println("The building was demolished.");
                    } catch (Exception e) {
                        System.out.println("You entered the wrong index. The building could not be deleted.");
                    }
                    break;
                case 1:
                    try {
                        System.out.println("---Buildings to the right of the street---");
                        for (Build i : landright) {    //to print
                            System.out.println(index+". "+i.toString());
                            index++;
                        }
                        System.out.print("Please select the building you want to delete: ");
                        choice = input.nextInt();
                        Build[] anotherArray = new Build[street_length];
                        int temp = landright[choice].getWeight();
                        int pos = landright[choice].getPosition();
                        for (int i = 0, k = 0; i < landright.length; i++) {
                            if (i == choice) {
                                continue;
                            }
                            anotherArray[k++] = landright[i];
                        }
                        landright = anotherArray;
                        setcontrol(controlright,pos,temp,heightright,0,0);
                        numberOfBuildright--;
                        System.out.println("The building was demolished.");
                    } catch (Exception e) {
                        System.out.println("You entered the wrong index. The building could not be deleted.");
                    }
                    break;
                case 2:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid Choice..");
            }
        }


    }
}
