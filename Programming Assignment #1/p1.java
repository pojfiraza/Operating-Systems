import java.util.ArrayList;

class p1
{   
public static void main(String[] args) throws InterruptedException
    {
        ArrayList<String> data = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
            data.add(Integer.toString(i));
        Runner.array = data;
        System.out.println(data);
        Thread full = new Thread (new Runner("FULL"), "Producer");
        Thread empty = new Thread (new Runner("EMPTY"), "Consumer");
        full.start();
        empty.start();
        full.join(); empty.join();

    }
}

class Runner implements Runnable
{
    public static ArrayList<String> array = new ArrayList<>();
    final String s;
    Runner (String val) {
        this.s = val;
    }
    public void run()
    {
        for (int i = 0; i < array.size(); i++) {
            synchronized (array) {
                try
                {
                    //Algorithm
                  int x = array.size()-1; 
                  if(s.equals("FULL")){
                       array.notifyAll(); 
                       if(array.get(i).equals("EMPTY"))break;
                       array.set(i, s);           
                       array.wait();
                  }
                  else{
                       array.notifyAll();
                       if(array.get(x-i).equals("FULL"))break;
                       array.set(x-i, s);
                       array.wait();
                  }
                  System.out.println(array);
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.getMessage());
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+" terminated.");
    }
}    