class DataFile{
    private int count=0;
    static int reading=0;
    static int writing=0;
    static int WriteReady = 0;

    public DataFile(){}
    
    public synchronized int startRead(){
        while(writing == 1||WriteReady > 0){
            try{
                System.out.println(Thread.currentThread().getName()+"is waiting");
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"begin read");
        count++;
        if(count == 1){
            reading = 1;
        }
        return count;
    }

    public synchronized int endRead(){
        count--;
        if(count == 0){
            reading = 0;
        }
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"have read");
        return count;
    }

    public synchronized void startWrite(){
    	WriteReady++;
        while(reading == 1 ||  writing == 1){
            try{
                System.out.println(Thread.currentThread().getName()+"is waiting");
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"begin read");
        writing = 1;
    }

    public synchronized void endWrite()
    {
        writing = 0;
        WriteReady--;
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"have writed");
    }
    
    

}