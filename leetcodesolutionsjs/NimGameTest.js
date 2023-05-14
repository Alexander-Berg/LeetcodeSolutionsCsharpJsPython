describe('canWinNim', () => {
    it('returns true for n = 1', () => {
        expect(canWinNim(1)).toBe(true);
    });

    it('returns true for n = 2', () => {
        expect(canWinNim(2)).toBe(true);
    });

    it('returns true for n = 3', () => {
        expect(canWinNim(3)).toBe(true);
    });

    it('returns false for n = 4', () => {
        expect(canWinNim(4)).toBe(false);
    });

    it('returns true for n = 5', () => {
        expect(canWinNim(5)).toBe(true);
    });

    it('returns true for n = 6', () => {
        expect(canWinNim(6)).toBe(true);
    });

    it('returns true for n = 7', () => {
        expect(canWinNim(7)).toBe(true);
    });

    it('returns false for n = 8', () => {
        expect(canWinNim(8)).toBe(false);
    });

    // Add more test cases as needed
});
