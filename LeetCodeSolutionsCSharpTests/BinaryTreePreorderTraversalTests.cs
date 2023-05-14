using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace LeetCodeSolutionsCSharp.Tests
{
    [TestClass]
    public class BinaryTreePreorderTraversalTests
    {
        [TestMethod]
        public void PreorderTraversal_ShouldReturnCorrectList_WhenGivenValidTree()
        {
            // Arrange
            var root = new TreeNodeO(1, new TreeNodeO(2), new TreeNodeO(3));
            var expectedList = new List<int> { 1, 2, 3 };
            var preorderTraversal = new BinaryTreePreorderTraversal();

            // Act
            var actualList = preorderTraversal.PreorderTraversal(root);

            // Assert
            CollectionAssert.AreEqual(expectedList, (System.Collections.ICollection)actualList);
        }

        [TestMethod]
        public void PreorderTraversal_ShouldReturnEmptyList_WhenGivenNullTree()
        {
            // Arrange
            var root = (TreeNodeO)null;
            var expectedList = new List<int>();
            var preorderTraversal = new BinaryTreePreorderTraversal();

            // Act
            var actualList = preorderTraversal.PreorderTraversal(root);

            // Assert
            CollectionAssert.AreEqual(expectedList, (System.Collections.ICollection)actualList);
        }
    }
}
