/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function(pattern, str) {
    s= str.split(' ')
    if(s.length != pattern.length) return false;
    var map = new Map();
    for(var i=0;i<pattern.length;i++){
        if(map.has(pattern[i])){
            if(map.get(pattern[i]) != s[i]) return false;
        }
        else{
            for(const x of map.values()){
                if(x == s[i]) return false;
            }
            map.set(pattern[i], s[i]);
        }
    }
    return true;
};