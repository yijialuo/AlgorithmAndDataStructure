package dataStructure.queue;

import java.util.Scanner;

//循环队列
//该队列，实际容量大小为maxSize-1,因为有一个空位作为标志
class CircularQueue {
    private int maxSize;
    private int front;//指向队头元素，初始为0，（注意：指向的就是队列头）
    private int reat;//指向队未元素的后一个，初始为0，（注意：指向的并不是队末元素，而是队末后一个单元）
    private int[] arr;

    public CircularQueue(int maxSize) {
        maxSize++;//多添加一个空位，给reat
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断当前队列是否为空
    public boolean isEmpty() {
        return front == reat;
    }

    //判断当前队列是否满
    public boolean isFull() {
        return (reat + 1) % maxSize == front;
    }

    //添加队列
    public void put(int e) {
        if (isFull()) {
            //如果队列满，添加失败
            System.out.println("队列已满");
            return;
        }
        arr[reat] = e;
        //注意：循环队列，不能reat++,一直加下去数字肯定会越界，应该取模运算
        //reat++;
        reat = (reat + 1) % maxSize;
    }


    //取队列
    public int get() {
        if (isEmpty()) {
            //如果队列为空，取队列失败
            throw new RuntimeException("队列为空");
        }
        //注意：先用临时值存下返回值，因为front还要移动
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //打印队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列为空！");
            return;
        }
        int validNum = validNum();
        for (int i = front; i < front + validNum; i++) {
            //不能arr[front],因为循环，front+validNum会数组越界
            System.out.println(arr[i % maxSize]);
        }
    }

    //队列的有效数据个数
    public int validNum() {
        return (reat + maxSize - front) % maxSize;
    }

    //队列头数据
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有队头数据");
        }
        return arr[front];
    }
}

public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(4);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输入一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("p(put):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    circularQueue.showQueue();
                    break;
                case 'p':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circularQueue.put(value);
                    break;
                case 'g':
                    try {
                        int res = circularQueue.get();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circularQueue.peek();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
            }
        }
    }
}
