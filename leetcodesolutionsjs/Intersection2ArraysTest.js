describe("intersection", () => {
    it("returns the common elements between two arrays", () => {
        const nums1 = [1, 2, 2, 1];
        const nums2 = [2, 2];
        const expected = [2];

        const result = intersection(nums1, nums2);

        expect(result).toEqual(expected);
    });

    it("returns an empty array if there are no common elements", () => {
        const nums1 = [1, 2, 3, 4];
        const nums2 = [5, 6, 7, 8];
        const expected = [];

        const result = intersection(nums1, nums2);

        expect(result).toEqual(expected);
    });

    it("handles empty arrays", () => {
        const nums1 = [];
        const nums2 = [1, 2, 3];
        const expected = [];

        const result = intersection(nums1, nums2);

        expect(result).toEqual(expected);
    });

    it("handles arrays with duplicate elements", () => {
        const nums1 = [1, 2, 2, 3];
        const nums2 = [2, 2, 3];
        const expected = [2, 3];

        const result = intersection(nums1, nums2);

        expect(result).toEqual(expected);
    });
});
