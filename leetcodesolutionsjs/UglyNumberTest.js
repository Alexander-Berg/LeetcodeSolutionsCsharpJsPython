describe("isUgly", () => {
    test("returns true for an ugly number", () => {
        expect(isUgly(6)).toBe(true);
    });

    test("returns false for a non-ugly number", () => {
        expect(isUgly(14)).toBe(false);
    });

    test("returns true for an ugly number equal to 1", () => {
        expect(isUgly(1)).toBe(true);
    });

    test("returns true for an ugly number in the array", () => {
        expect(isUgly(3)).toBe(true);
    });

    test("returns true for an ugly number not in the array", () => {
        expect(isUgly(25)).toBe(true);
    });

    test("returns true for an ugly number that can be factored into an ugly number", () => {
        expect(isUgly(1000)).toBe(true);
    });

    test("returns false for a non-ugly number that can be factored into an ugly number", () => {
        expect(isUgly(42)).toBe(false);
    });

    test("returns false for zero", () => {
        expect(isUgly(0)).toBe(false);
    });

    test("returns false for a negative number", () => {
        expect(isUgly(-6)).toBe(false);
    });
});
