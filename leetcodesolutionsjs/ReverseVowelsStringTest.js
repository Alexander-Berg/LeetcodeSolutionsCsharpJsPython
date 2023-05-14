describe('reverseVowels', () => {
    test('should return empty string for empty string input', () => {
        expect(reverseVowels('')).toBe('');
    });

    test('should return input string if no vowels are present', () => {
        expect(reverseVowels('bcd')).toBe('bcd');
    });

    test('should reverse only vowels in input string', () => {
        expect(reverseVowels('hello')).toBe('holle');
    });

    test('should reverse only vowels in input string with uppercase letters', () => {
        expect(reverseVowels('hEllo')).toBe('hollE');
    });

    test('should reverse all vowels in input string', () => {
        expect(reverseVowels('aeiou')).toBe('uoiea');
    });

    test('should reverse all vowels in input string with uppercase letters', () => {
        expect(reverseVowels('AEIOU')).toBe('UOIEA');
    });

    test('should handle input string with mixed vowels and non-vowels', () => {
        expect(reverseVowels('aBcdeEfghiIjkoO')).toBe('oBcdiEfghaIjkOe');
    });
});
