# Basic Queue Implementation in Java using Arrays.

Constant time access for enqueue, dequeue.

* The Queue DS implemented with the help of arrays
* Constant running time for enqueue, dequeue, size and capacity
* Space requirement  = O(size) where size = size of queue
*
* 2 global indices are maintained: start and end.
* De-queue is done at start and it returns null if queue is empty
* Enqueue is done at end position and returns true if success and false otherwise
* size stores the size of the queue
* capacity stores the current capacity of the queue


The constant runtime is achieved by the virtue that when en-queueing, the start need not be moved
and when de-queueing, the end shouldn't be either, ie. once an element is enqueued, it stays at the same
place in the array throughout its lifetime

An entensive test suite is provided which covers the testing of nitty gritties of the algorithm
Its well documented too.


## Run

Enter **Queue** directory and type:

1. `javac -classpath lib/junit-4.10.jar src/*.java`

2. `java -cp .:./src:lib/junit-4.10.jar org.junit.runner.JUnitCore QueueTest`

Download [JUnit4.10](https://cloud.github.com/downloads/junit-team/junit/junit-4.10.jar) here

