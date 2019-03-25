class Reader implements Runnable{
    private int number;
    private DataFile df;

    Reader(int number, DataFile df){
        this.number = number;
        this.df = df;
    }

    public void run(){
        System.out.println("reader"+number+"apply for reading");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        df.startRead();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        df.endRead();
    }
}