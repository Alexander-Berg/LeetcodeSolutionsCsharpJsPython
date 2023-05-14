describe("wordPattern function", () => {
    test("Returns true for 'abba' and 'dog cat cat dog'", () => {
        const pattern = "abba";
        const str = "dog cat cat dog";
        expect(wordPattern(pattern, str)).toBe(true);
    });

    test("Returns false for 'abba' and 'dog cat cat fish'", () => {
        const pattern = "abba";
        const str = "dog cat cat fish";
        expect(wordPattern(pattern, str)).toBe(false);
    });

    test("Returns false for 'aaaa' and 'dog cat cat dog'", () => {
        const pattern = "aaaa";
        const str = "dog cat cat dog";
        expect(wordPattern(pattern, str)).toBe(false);
    });

    test("Returns false for 'abba' and 'dog dog dog dog'", () => {
        const pattern = "abba";
        const str = "dog dog dog dog";
        expect(wordPattern(pattern, str)).toBe(false);
    });
});
