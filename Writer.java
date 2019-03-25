class Writer implements Runnable{
    private int number;
    private DataFile df;
    
    Writer(int number, DataFile df){
        this.number = number;
        this.df = df;
    }

    public void run(){
        System.out.println("writer"+number+"apply for wirting");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        df.startWrite();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        df.endWrite();
    }
}