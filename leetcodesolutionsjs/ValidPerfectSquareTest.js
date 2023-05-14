describe("isPerfectSquare", () => {
    test("returns true for perfect squares", () => {
        expect(isPerfectSquare(4)).toBe(true);
        expect(isPerfectSquare(9)).toBe(true);
        expect(isPerfectSquare(16)).toBe(true);
        expect(isPerfectSquare(25)).toBe(true);
        expect(isPerfectSquare(36)).toBe(true);
    });

    test("returns false for non-perfect squares", () => {
        expect(isPerfectSquare(2)).toBe(false);
        expect(isPerfectSquare(10)).toBe(false);
        expect(isPerfectSquare(15)).toBe(false);
        expect(isPerfectSquare(20)).toBe(false);
        expect(isPerfectSquare(30)).toBe(false);
    });
});