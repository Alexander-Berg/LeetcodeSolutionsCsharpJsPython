describe('addDigits', () => {
    test('returns 0 for NaN or 0 input', () => {
        expect(addDigits(NaN)).toBe(0);
        expect(addDigits(0)).toBe(0);
    });

    test('returns the input number for single-digit numbers', () => {
        expect(addDigits(1)).toBe(1);
        expect(addDigits(9)).toBe(9);
    });

    test('returns the correct digital root for multi-digit numbers', () => {
        expect(addDigits(38)).toBe(2);
        expect(addDigits(1234)).toBe(1);
        expect(addDigits(987654321)).toBe(9);
    });
});

