/**
 * @param {number} num
 * @return {boolean}
 */
function isPerfectSquare(num) {
    let low = 1;
    let high = num;

    while (low <= high) {
        const mid = Math.floor((low + high) / 2);
        const sqr = mid * mid;

        if (sqr < num) {
            low = mid + 1;
        }
        else if (sqr > num) {
            high = mid - 1;
        }
        else {
            return true;
        }
    }

    return false;
};