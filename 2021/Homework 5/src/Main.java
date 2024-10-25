public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        long end = System.nanoTime();
    //Question 1
       HashtableOpen<String, String> ht1 = new HashtableOpen<>();
        ht1.put("Samsun", "Atakum");
        ht1.put("İstanbul","şişli");
        ht1.put("İzmir", "Seferihisar");
        ht1.put("Kocaeli", "Gebze");
        ht1.put("Çanakkale", "Gelibolu");
        ht1.put("Rize", "Çamlıhemşin");

       System.out.println("---------for next Iterator------------ ");
       HashtableOpen<String , String>.MapIterator<String> it = ht1.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println("--------for Prev Iterator----------- ");
        HashtableOpen<String,String>.MapIterator<String> its = ht1.iterator();
         while (its.hasNext())
             System.out.println(its.prev());

        System.out.println("-------for MapIterator (Rize)------------ ");
         HashtableOpen<String, String>.MapIterator<String> itz = ht1.iterator("Rize");
         while (itz.hasNext())
            System.out.println(itz.next());

    //Question 2
    //    To run the example in pdf, the Capacity number  must be 10 in  classes.
    /*
        HashtableOpen<Integer, Integer> openhash = new HashtableOpen<>();
        System.out.println("--------Open Adressing---------------");
        start = System.nanoTime();
        System.out.println("Put:(3,12,13,25,23,51,42)");
        openhash.put(3,3);
        openhash.put(12,12);
        openhash.put(13,13);
        openhash.put(25, 25);
        openhash.put(23,23);
        openhash.put(51,51);
        openhash.put(42,42);
        end = System.nanoTime();
        System.out.println(openhash.toString());
        System.out.println("Open Adressing time (put): "+ (end-start));
        System.out.println("Remove(13)");
        start = System.nanoTime();
        openhash.remove(13);
        end = System.nanoTime();
        System.out.println(openhash.toString());
        System.out.println("Open Adressing time (remove): "+ (end-start));


        ChainLinkList<Integer, Integer> Linkl = new ChainLinkList<>();
        System.out.println("--------linkedlist Chain---------------");
        System.out.println("Put:(3,12,13,25,23,51,42)");
        start = System.nanoTime();
        Linkl.put(3,3);
        Linkl.put(12,12);
        Linkl.put(13,13);
        Linkl.put(25, 25);
        Linkl.put(23,23);
        Linkl.put(51,51);
        Linkl.put(42,42);
        end = System.nanoTime();
        System.out.println(Linkl.toString());
        System.out.println("Linklist  time (put): "+ (end-start));
        System.out.println("Remove(13)");
        start = System.nanoTime();
        Linkl.remove(13);
        end = System.nanoTime();
        System.out.println(Linkl.toString());
        System.out.println("Linklist time (remove): "+ (end-start));


        System.out.println("-------------TreeSet-----------------");
        ChainTreeSet<Integer, Integer> treeSett = new ChainTreeSet<>();
        start = System.nanoTime();
        treeSett.put(3,3);
        treeSett.put(12,12);
        treeSett.put(13,13);
        treeSett.put(25, 25);
        treeSett.put(23,23);
        treeSett.put(51,51);
        treeSett.put(42,42);
        end = System.nanoTime();
        System.out.println(treeSett.toString());
        System.out.println("TreeSet time (put): "+ (end-start));
        start = System.nanoTime();
        treeSett.remove(13);
        end = System.nanoTime();
        System.out.println("Remove(13)");
        System.out.println(treeSett.toString());
        System.out.println("TreeSet time (remove): "+ (end-start));
    */
        HashtableOpen<Integer, Integer> med1 = new HashtableOpen<>();
        ChainLinkList<Integer, Integer> med2 = new ChainLinkList<>();
        ChainTreeSet<Integer, Integer> med3 = new ChainTreeSet<>();


        System.out.println("---------------Small data----------------");
        int a  = 1000;
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(remove) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(remove) " +(end -start));
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(remove) " +(end -start));
        System.out.println("--------------Medium data----------------");
        a  = 1000000;
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(remove) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(remove) " +(end -start));
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(remove) " +(end -start));

        System.out.println("--------------Large data----------------");
        a  = 100000000;
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med1.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("OpenAdreessing time:(remove) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med2.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("Linklist time:(remove) " +(end -start));
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.put(a+i,a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(put) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.get(a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(get) " +(end -start));

        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            med3.remove(a+i);
        }
        end = System.nanoTime();
        System.out.println("TreeSet time:(remove) " +(end -start));
    }
}
