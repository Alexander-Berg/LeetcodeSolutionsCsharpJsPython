describe('binaryTreePaths', () => {
    test('should return ["1->2->5", "1->3"] for [1,2,3,null,5]', () => {
        // Define the input binary tree
        const root = {
            val: 1,
            left: {
                val: 2,
                left: null,
                right: {
                    val: 5,
                    left: null,
                    right: null
                }
            },
            right: {
                val: 3,
                left: null,
                right: null
            }
        };
        // Call the function and check the output
        expect(binaryTreePaths(root)).toEqual(["1->2->5", "1->3"]);
    });

    test('should return [] for null input', () => {
        expect(binaryTreePaths(null)).toEqual([]);
    });

    test('should return ["0"] for [0]', () => {
        const root = { val: 0, left: null, right: null };
        expect(binaryTreePaths(root)).toEqual(["0"]);
    });

    // Add more tests as needed
});
