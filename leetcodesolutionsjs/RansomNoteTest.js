describe('canConstruct', () => {
    test('returns true when ransom note can be constructed from magazine', () => {
        expect(canConstruct('aa', 'aab')).toBe(true);
        expect(canConstruct('aa', 'aaaa')).toBe(true);
        expect(canConstruct('abc', 'abcdef')).toBe(true);
        expect(canConstruct('abca', 'aabbc')).toBe(true);
    });

    test('returns false when ransom note cannot be constructed from magazine', () => {
        expect(canConstruct('aaa', 'aab')).toBe(false);
        expect(canConstruct('aa', 'a')).toBe(false);
        expect(canConstruct('abc', 'defg')).toBe(false);
        expect(canConstruct('abc', 'abbc')).toBe(false);
    });
});
