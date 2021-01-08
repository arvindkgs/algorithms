package com.akgs.algo.paypal;

class MyPriorityThreadPool {
    
    public static void main(String[] args) {
        //Priority Thread pool executor
        //Params: addTask(Runnable task, int priority)
        /**
         * 
         * class MyPriorityThreadPool {
         *  List<MyRunnable> tasks;
         *  int poolSize;
         *  class MyRunnable implements Comparator{
         *      int priority;
         *      Runnable task;
         *      int compare(Object o){
         *          return compare(o.priority, this.priority);
         *      }
         *  }
         *  PriorityQueue<MyRunnable> tasks;
         *  BlockingQueue<tasks> 
         *  void addTask(Runnable task, int pri){
         *      tasks.push(new MyRunnable(task, pri));
         *  }
         *  
         *  public(int poolSize){
         *    tasks = new List<Runnable>();
         *    new Thread()  
         *  }
         *  
         * }
         * 
         */
    }
}