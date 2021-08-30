package com.akgs.algo.threads;

/**
 * Create a OrderedTaskRunner
 *  1. accept(List<Runnable> tasks, Runnable[][] dependencyGraph): Define each task, dependency of each task on other tasks
 *      dependencyGraph is 2d adjacency Matrix, of 0s and 1s, size nxn where n is number of tasks
 *      if tasks = a,b,c and a->b and a->c and c->b
 *      then given dependencyGraph: = [[0,1,1],[0,0,0],[0,1,0]]
 *          a | b | c
 *      a | 0 | 1 | 1
 *      b | 0 | 0 | 0
 *      c | 0 | 1 | 0
 *
 *  2. run(): Runs tasks in order
 */
public class OrderedThreadPool {
}
