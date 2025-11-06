public class RunnableClass implements Runnable{

    @Override
    public void run(){
        // Runnable is a functional interface with a single run() method

        for (int i = 0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " : " + i );
        }
    }
}
