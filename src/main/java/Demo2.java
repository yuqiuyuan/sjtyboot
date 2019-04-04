import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo2 implements Runnable {
    public static void main(String[] args) {
//        for (int i=0;i<1000;i++){
//            System.out.println(15&i);
//        HashSet<Integer> set = new HashSet();
//        set.add(1);
//        set.add(2);
//        set.forEach((s)->System.out.println(s));
//        Iterator i= set.iterator();
//        while (i.hasNext()){
//            System.out.println(i.next());
//        }
//        HashMap<Integer,Object> map = new HashMap<>();
//        ArrayList list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        LinkedList linkedList = new LinkedList();
//        linkedList.add(4);
//        Vector v = new Vector();
//        v.add(1);
//        v.add(2);
//        v.forEach((e)->System.out.println(e));
        try {
            Demo2 d = new Demo2();
            new Thread(d).start();
            d.wait();
            d.notifyAll();
            d.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("OK");
    }

    private void testThreadTest(){
        try {
//            ThreadPoolExecutor
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


