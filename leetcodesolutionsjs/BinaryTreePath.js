/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    let paths = [];

    function preOrder(node,currPath){
        if(node){
            currPath.push(node.val);
            if(node.left==null && node.right==null){
                paths.push([...currPath]);
            }
            preOrder(node.left,[...currPath]);
            preOrder(node.right,[...currPath]);
        }
    }
    preOrder(root,[]);
    let ans = paths.map(path => path.join("->"))
    return ans;
};