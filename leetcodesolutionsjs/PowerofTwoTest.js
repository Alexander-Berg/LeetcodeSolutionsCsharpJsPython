describe("isPowerOfTwo", () => {
    test("returns true for powers of two", () => {
        expect(isPowerOfTwo(1)).toBe(true);
        expect(isPowerOfTwo(2)).toBe(true);
        expect(isPowerOfTwo(4)).toBe(true);
        expect(isPowerOfTwo(8)).toBe(true);
        expect(isPowerOfTwo(16)).toBe(true);
    });

    test("returns false for non-powers of two", () => {
        expect(isPowerOfTwo(0)).toBe(false);
        expect(isPowerOfTwo(3)).toBe(false);
        expect(isPowerOfTwo(5)).toBe(false);
        expect(isPowerOfTwo(7)).toBe(false);
        expect(isPowerOfTwo(15)).toBe(false);
    });
});
