package DataStructure.queue;

//目前数组使用一次就不能用，没有达到复用的效果
//将这个数组使用算法，改进成一个环形的数组 取模：%
class ArrayQueue {
    private int maxSize;//容量
    private int front;//队列首位元素的前一位下标（注意：并不是队首元素的下标）
    private int rear;//队列末尾元素的下标（注意：就是队尾元素的下标）
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        arr = new int[maxSize];
    }

    //判断当前队列是否满
    public boolean isFull() {
        return front == maxSize - 1;
    }

    //判断当前是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //入队,在队尾加上
    public void put(int e){
        //如果队列满了，抛出异常
        if(isFull()){
            System.out.println("当前队列已满！添加元素失败！");
            return;
        }
        rear++;//队尾下标加一
        arr[rear]=e;
    }

    //出队，取队首
    public int take(){
        if(isEmpty()){
            //通过抛异常出来
            throw new RuntimeException("当前队列为空");
        }
        front++;
        return arr[front];
    }

    //显示队列中的数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("当前队列为空");
            return;
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.printf("a[%d]=%d",i,arr[i]);
        }
    }

    //显示队头,注意不是取数据
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("当前队列为空");
        }
        return arr[front+1];
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(10);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        queue.showQueue();

    }
}

