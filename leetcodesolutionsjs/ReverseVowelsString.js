/**
 * @param {string} s
 * @return {string}
 */
/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    let str = s.split('') //string to array as string is immuteable
    let left = 0; // left pointer as it starts at zero
    let right = str.length -1 // right pointer which is at last index

    while(left<right){
// We will check if number is vowel on left side
        while(left<right){
            if(!isVowel(str[left])){
                left++ // move to next value on left side
            }else{
                break; // break the loop if we found a vowel
            }
        }
// we will check if number is vowel on right side
        while(left<right){
            if(!isVowel(str[right])){
                right -- // move to next value on right side
            }else{
                break
            }

        }
// if they are vowel so we will swap them
        let temp = str[left]
        str[left] =str[right]
        str[right] = temp
        left++
        right--
    }
    return str.join('') // we'll make an array again
};

// Is vowel function to check if a vowel exists
let isVowel = (letter)=>{
    let vowel = 'aeiou'
    return vowel.includes(letter.toLowerCase())
}