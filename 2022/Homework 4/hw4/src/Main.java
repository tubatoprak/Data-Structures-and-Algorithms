import java.util.ArrayList;

/***
 * @author Tuba Toprak
 * Recursive - homework 4
 */
public class Main {

    public static void main(String[] args) {
        question1();
        question2();
        question3();
        question5();
    }

    /**
     * prepares and runs for the first question
     */
    static void question1(){
        System.out.println("----------Question 1 Testing----------");
        String str="gebze teknik üniversitesi";
        String sub =  "teknik";
        int result = q1(str,sub,str.length());
        System.out.println("Big String: "+str);
        System.out.println("Query String: "+ sub);
        if(result == -1)
            System.out.println("Query string doesn’t occur in the big string");
        else
            System.out.println("index of the ith occurrence of the query string: "+ result);

    }

    /**
     * Recursive function to question 1
     * @param s2 big string
     * @param s1 query string
     * @param size collected pluses
     * @return -1 if there is an error or 0 is returned.
     */
    static int q1(String s2, String s1,int size){
        if(s1.isEmpty() || s2.isEmpty()) //teta 1
            return -1;
        if(s2.length() == 1) // teta 1
            return (-size);
        if(s2.startsWith(s1))     //best = teta1 worst = teta n time comp = o (n)
            return 0;
        else
            return 1 + q1(s2.substring(1),s1,size);  //t(n) = t(n-1) + teta1 = teta(n)
    }

    /**
     * prepares and runs for the second question
     */
    static void question2(){
        System.out.println("----------Question 2 Testing----------");
        int[] arr = {1,2,5,9,21,25,26,28,30,36,39,41,59,60};
        int minumum =21;
        int maximum = 25;
        int result = q2(minumum,maximum,arr,0,arr.length-1);
        System.out.print("array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.print("\nRange: "+minumum+ " - "+ maximum);
        if(result == 0)
            System.out.println("\nNo numbers in this range");
        else
            System.out.println("\nResult: "+ result);

    }

    /**
     * Recursive function to question 2
     * @param minimum number
     * @param maximum number
     * @param arr array
     * @param start start position
     * @param end end position
     * @return base case or recursive function
     */
    static int q2(int minimum, int maximum, int[] arr, int start,int end){
        if (start > end)  //teta1
            return 0;   //teta1   best teta1 worst (teta log n) time com = o (log n)
        int mid = (start + end) / 2;  //teta1
        if (arr[mid] <= maximum && minimum <= arr[mid])  //teta1
            return 1 + q2(minimum,maximum,arr, mid+1, end) + q2(minimum,maximum,arr, start,mid-1); //t(n) = tetal (log(n)
        return  q2(minimum,maximum,arr, mid+1, end) +  q2(minimum,maximum,arr, start,mid-1); //teta log n
    }

    /**
     * prepares and runs for the three question
     */
    static void question3(){
        System.out.println("----------Question 3 Testing----------");
        int[] arr = {2,5,10,8,4,41,1,2,3,5};
        ArrayList<Integer> temp = new ArrayList<>();

        int target = 11;
        System.out.print ("Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("\nSum: "+ target);
        q3(arr,target,0,0,0,temp);

        System.out.println("\nSum: 22");
        q3(arr,22,0,0,0,temp);

        System.out.println("\nSum: 50");
        q3(arr,50,0,0,0,temp);

        System.out.println("\nSum: 7");
        q3(arr,7,0,0,0,temp);

        System.out.println("\nSum: 13");
        q3(arr,13,0,0,0,temp);

    }

    /**
     * Recursive function to question 3
     * @param arr array
     * @param target given sum
     * @param index index of array
     * @param end  end position
     * @param sum  collected numbers
     * @param temp temporary arraylist
     * @return base case or recursive function
     */
    static int q3(int[] arr, int target, int index, int end, int sum,ArrayList<Integer> temp) {

        if(index > arr.length){   // teta1
            System.out.println("There is no subarray");
            return -1;
        }
        if(end < arr.length) {
            sum = sum + arr[end];
            temp.add(arr[end]);
            end++;
            if(sum == target)
            {
                System.out.println(""+temp.toString());
                return 0;
            }
            else  // teta1
                return q3(arr,target,index,end,sum,temp);  //teta n  //best teta n worst teta n
        }
        else{
            end = index;
            sum = 0;
            temp.clear();
            index++;
            return  q3(arr,target,index,end, sum,temp); // teta n
        }
    }

    /**
     * prepares and runs for the five question
     */
    static void question5(){
        System.out.println("----------Question 5 Testing----------");
        int blocksize = 3;
        int array_lenght = 6;
        System.out.println("Lenght of block : "+ blocksize);
        System.out.println("Lenght of array: "+array_lenght );
        int result = q5(array_lenght+1,0,blocksize);
        if(result == -1)
            System.out.println("The block size or the length of the array was entered incorrectly.");
    }

    /**
     * Print function for the 5th question
     * @param result array to print
     */
    static void q4_print(ArrayList<Integer> result){
        System.out.println("\n------------------------");
        for (Integer integer : result) {
            if (integer == 1)
                System.out.print("| X ");
            else
                System.out.print("|   ");
        }
    }

    /**
     * Recursive function to question 5
     * @param array_lenght lenght of cells
     * @param index index of cell
     * @param blocksize lenght o block
     * @return base case or recursive function
     */
    static int q5(int array_lenght, int index, int blocksize){

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < array_lenght ; i++) {
            result.add(0); //teta1
        }
        if(blocksize < 3)
            return -1;
        if(array_lenght == 0)  //teta1
            return -1;
        if(blocksize == array_lenght)  //teta1
            return 0;
        if(index < (array_lenght- blocksize) && blocksize < array_lenght){  //teta1
            result.set(index,1);  //teta1
            for (int i = 0; i < blocksize; i++) {  //teta n
                result.set(index+i,1);
            }
            q4_print(result);  //o (n)
            return q5(array_lenght, index+1,  blocksize);  //t(n) = t(n-1) + teta(n) = teta(n^2)
        }
        index = 0;
        return q5(array_lenght, index,blocksize+1); //best case teta1 worst teta(n^2)
    }
}
