import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    // Stores the smaller half (largest element on top)
    private PriorityQueue<Integer> maxHeap;

    // Stores the larger half (smallest element on top)
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to max heap
        maxHeap.offer(num);

        // Step 2: Move largest to min heap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance sizes
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */