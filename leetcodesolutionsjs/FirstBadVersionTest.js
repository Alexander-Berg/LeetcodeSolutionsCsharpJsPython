describe("solution", () => {
    test("should return the first bad version", () => {
        // Define a mock function for the isBadVersion parameter
        const isBadVersion = jest.fn((version) => version >= 4);

        // Call the solution function with a range of versions
        const findBadVersion = solution(isBadVersion);
        const n = 8;
        const result = findBadVersion(n);

        // Check that the mock function was called a minimal number of times
        expect(isBadVersion.mock.calls.length).toBeLessThanOrEqual(Math.ceil(Math.log2(n)));

        // Check that the correct version was returned
        expect(result).toBe(4);
    });
});
