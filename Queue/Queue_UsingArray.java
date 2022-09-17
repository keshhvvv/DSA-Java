package Queue;

public class Queue_UsingArray
{
    private int[] queue;
    private int frontEnd;//Index of the element present at the front end.
    private int rearEnd;//Index of the element present at the rear end.
    private int size;

    public Queue_UsingArray()
    {
        queue=new int[5];
        frontEnd=-1;
        rearEnd=-1;
        size=0;
    }
    public Queue_UsingArray(int capacity)
    {
        queue=new int[capacity];
        frontEnd=-1;
        rearEnd=-1;
        size=0;
    }


    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public void enqueue(int data) throws QueueLimitOutOfBound {
        if (size>=queue.length){
            throw new QueueLimitOutOfBound();
        }

        if (frontEnd == -1){
            frontEnd=0;
        }
//        rearEnd++;
//        //This means that there is empty space present at the starting of the array.
//        if (rearEnd == queue.length){
//            rearEnd=0;
//        }

        //The fine way to do this is using modulo operator.
        rearEnd = (rearEnd+1) % queue.length;
        //when rearEnd == queue.length, then the remainder=0, and rearEnd set to 0.

        queue[rearEnd]=data;
        size++;
    }

    public void dequeue() throws QueueEmptyException {
        if (size==0){
            throw new QueueEmptyException();
        }
        System.out.println(queue[frontEnd]+" element is dequeued");
        queue[frontEnd]=0;
//        frontEnd++;
//        if (frontEnd == queue.length){
//            frontEnd=0;
//            //This will make circular queue possible.
//        }

        //The fine way of doing this is using modulo operator.
        frontEnd = (frontEnd+1) % queue.length;
        //This will again set the frontEnd to 0 when its equal to queue length.
        //ANd this will only happen when the size is not equal to queue length, means there is space in queue.


        size--;
        //When the size of the queue becomes 0.
        if (size==0){
            frontEnd=-1;
            rearEnd=-1;
        }
    }

    public int front()
    {
        return queue[frontEnd];
    }

    public void print()
    {
        for(int data:queue){
            System.out.print(data+"<-");
        }System.out.println("\n");
    }
}
