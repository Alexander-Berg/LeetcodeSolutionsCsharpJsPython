using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using LeetCodeSolutionsCSharp;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace LeetCodeSolutionsCSharpTests
{
    [TestClass]
    public class BinaryTreePostorderTraversalTests
    {
        [TestMethod]
        public void TestPostorderTraversal_Example1()
        {
            // Arrange
            var root = new TreeNodeP(1);
            root.right = new TreeNodeP(2);
            root.right.left = new TreeNodeP(3);
            var solution = new BinaryTreePostorderTraversal();

            // Act
            var result = solution.PostorderTraversal(root);

            // Assert
            CollectionAssert.AreEqual(new List<int> { 3, 2, 1 }, result);
        }

        [TestMethod]
        public void TestPostorderTraversal_Example2()
        {
            // Arrange
            var root = new TreeNodeP(1);
            root.left = new TreeNodeP(2);
            var solution = new BinaryTreePostorderTraversal();

            // Act
            var result = solution.PostorderTraversal(root);

            // Assert
            CollectionAssert.AreEqual(new List<int> { 2, 1 }, result);
        }

        [TestMethod]
        public void TestPostorderTraversal_EmptyTree()
        {
            // Arrange
            TreeNodeP root = null;
            var solution = new BinaryTreePostorderTraversal();

            // Act
            var result = solution.PostorderTraversal(root);

            // Assert
            CollectionAssert.AreEqual(new List<int>(), result);
        }
    }
}
