using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LeetCodeSolutionsCSharp
{
    [TestClass]
    public class PathSumSolutionTests
    {
        [TestMethod]
        public void HasPathSum_ShouldReturnTrue_WhenPathSumEqualsTargetSum()
        {
            // Arrange
            var root = new TreeNodeC(5)
            {
                left = new TreeNodeC(4),
                right = new TreeNodeC(8)
            };
            root.left.left = new TreeNodeC(11);
            root.left.left.left = new TreeNodeC(7);
            root.left.left.right = new TreeNodeC(2);
            root.right.left = new TreeNodeC(13);
            root.right.right = new TreeNodeC(4);
            root.right.right.right = new TreeNodeC(1);
            var solution = new PathSumSolution();

            // Act
            var result = solution.HasPathSum(root, 22);

            // Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void HasPathSum_ShouldReturnFalse_WhenPathSumNotEqualsTargetSum()
        {
            // Arrange
            var root = new TreeNodeC(1);
            root.left = new TreeNodeC(2);
            var solution = new PathSumSolution();

            // Act
            var result = solution.HasPathSum(root, 1);

            // Assert
            Assert.IsFalse(result);
        }

        [TestMethod]
        public void HasPathSum_ShouldReturnFalse_WhenRootIsNull()
        {
            // Arrange
            var solution = new PathSumSolution();

            // Act
            var result = solution.HasPathSum(null, 1);

            // Assert
            Assert.IsFalse(result);
        }
    }
}
