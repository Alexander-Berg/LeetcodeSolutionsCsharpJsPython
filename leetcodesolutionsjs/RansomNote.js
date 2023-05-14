/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
const canConstruct = (ransomNote, magazine) => {
    const vocab = {};

    for (let letter of magazine) {
        vocab[letter] = ++vocab[letter] || 1;
    }

    for (let letter of ransomNote) {
        if (vocab[letter] === 0 || !vocab[letter]) {
            return false;
        }
        vocab[letter]--;
    }

    return true;
};