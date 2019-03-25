class Main{
    public static void main(String[] args){
        DataFile df = new DataFile();

        Reader r1 = new Reader(1,df);
        Reader r2 = new Reader(2,df);
        Reader r3 = new Reader(3,df);
        Writer w1 = new Writer(1,df);
        Writer w2 = new Writer(2,df);
        Writer w3 = new Writer(3,df);

        Thread t1 = new Thread(r1,"reader1");
        Thread t2 = new Thread(r2,"reader2");
        Thread t3 = new Thread(r3,"reader3");
        Thread t4 = new Thread(w1,"writer1");
        Thread t5 = new Thread(w2,"writer2");
        Thread t6 = new Thread(w3,"writer3");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}