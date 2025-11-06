public class MyThread extends Thread{

    public MyThread(String name){
        super(name);

        // super(name) calls the thread constructor to set a readable name for this thread
    }

    @Override
    public void run(){
        //run() is the entry point that the thread executes after you call start()

        for (int i = 0;i<10;i++){

            System.out.println(Thread.currentThread().getName() + " : " + i );

        }
    }
}
