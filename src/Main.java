public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new MyThread("Thread1"); // t1 enters the state called NEW
        t1.run(); // the run executes on the main method
        // this is a sequential program that doesn't run in a seperate program. if you want to run it in a seperate way you should call the start()
        t1.start(); // the thread t1 enters the RUNNABLE state

        Runnable t2 = new RunnableClass();
        Thread thread2 = new Thread(t2, "Thread2");
        thread2.start();


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

        // anonymous Runnable example : (Thread 3)

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }, "Thread 3");
        thread3.start();

        //anonymous Runnable using Lambda (Thread 4)

        Thread thread4 = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "Thread 4");
        thread4.start();

    }
    }
