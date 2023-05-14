describe("countBits", () => {
    test("returns an empty array when n is less than 0", () => {
        expect(countBits(-1)).toEqual([]);
    });

    test("returns [0] when n is 0", () => {
        expect(countBits(0)).toEqual([0]);
    });

    test("returns [0,1,1] when n is 2", () => {
        expect(countBits(2)).toEqual([0, 1, 1]);
    });

    test("returns [0,1,1,2,1,2] when n is 5", () => {
        expect(countBits(5)).toEqual([0, 1, 1, 2, 1, 2]);
    });
});
