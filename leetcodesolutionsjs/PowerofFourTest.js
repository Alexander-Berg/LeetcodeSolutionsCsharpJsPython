describe("isPowerOfFour", () => {
    test("returns false for n=0", () => {
        expect(isPowerOfFour(0)).toBe(false);
    });

    test("returns true for n=1", () => {
        expect(isPowerOfFour(1)).toBe(true);
    });

    test("returns true for n=4", () => {
        expect(isPowerOfFour(4)).toBe(true);
    });

    test("returns false for n=5", () => {
        expect(isPowerOfFour(5)).toBe(false);
    });

    test("returns false for n=16", () => {
        expect(isPowerOfFour(16)).toBe(true);
    });

    test("returns false for n=17", () => {
        expect(isPowerOfFour(17)).toBe(false);
    });
});
