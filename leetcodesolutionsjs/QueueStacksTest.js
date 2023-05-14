describe('MyQueue', () => {
    let queue;

    beforeEach(() => {
        queue = new MyQueue();
    });

    it('should push elements to the queue', () => {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        expect(queue.firstStack).toEqual([1, 2, 3]);
    });

    it('should pop elements from the queue', () => {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        expect(queue.pop()).toEqual(1);
        expect(queue.pop()).toEqual(2);
        expect(queue.firstStack).toEqual([]);
        expect(queue.secondStack).toEqual([3]);
    });

    it('should peek the element at the front of the queue', () => {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        expect(queue.peek()).toEqual(1);
        expect(queue.firstStack).toEqual([1, 2, 3]);
        expect(queue.secondStack).toEqual([]);
    });

    it('should return true if the queue is empty', () => {
        expect(queue.empty()).toEqual(true);
        queue.push(1);
        expect(queue.empty()).toEqual(false);
        queue.pop();
        expect(queue.empty()).toEqual(true);
    });
});
