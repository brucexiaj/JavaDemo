package com.java.temp;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * java类简单作用描述
 *
 * @author Yinbin
 * @version 1.0
 */
public class VolatileDemo implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);

    public Set<Integer> set = new HashSet<>();

    @Override
    public void run() {
        while (i.getAndIncrement() < 10) {
            set.add(i.get());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        VolatileDemo demo = new VolatileDemo();

        Thread thread1 = new Thread(demo);
        thread1.setName("Thread-1");
        Thread thread2 = new Thread(demo);
        thread2.setName("Thread-2");
        Thread thread3 = new Thread(demo);
        thread3.setName("Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        List<Integer> list = new ArrayList<>(demo.set);
        int a = list.size();
        int b = demo.set.size();
        System.out.println("==> " + a + "  == " + b);
        if (a != b) {
            list.forEach(System.out::println);
            System.out.println("===================");
            demo.set.forEach(System.out::println);
            System.out.println("===================");
        }
    }
}

