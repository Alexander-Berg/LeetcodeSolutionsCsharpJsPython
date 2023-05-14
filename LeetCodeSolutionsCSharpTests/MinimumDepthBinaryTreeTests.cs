using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LeetCodeSolutionsCSharp.Tests
{
    [TestClass]
    public class MinimumDepthBinaryTreeTests
    {
        [TestMethod]
        public void TestMinDepth_EmptyTree_ShouldReturnZero()
        {
            // Arrange
            TreeNodeB root = null;
            MinimumDepthBinaryTree solution = new MinimumDepthBinaryTree();

            // Act
            int result = solution.MinDepth(root);

            // Assert
            Assert.AreEqual(0, result);
        }

        [TestMethod]
        public void TestMinDepth_RootNodeOnly_ShouldReturnOne()
        {
            // Arrange
            TreeNodeB root = new TreeNodeB(1);
            MinimumDepthBinaryTree solution = new MinimumDepthBinaryTree();

            // Act
            int result = solution.MinDepth(root);

            // Assert
            Assert.AreEqual(1, result);
        }

        [TestMethod]
        public void TestMinDepth_TwoLevelsTree_ShouldReturnTwo()
        {
            // Arrange
            TreeNodeB root = new TreeNodeB(1,
                left: new TreeNodeB(2),
                right: new TreeNodeB(3)
            );
            MinimumDepthBinaryTree solution = new MinimumDepthBinaryTree();

            // Act
            int result = solution.MinDepth(root);

            // Assert
            Assert.AreEqual(2, result);
        }

        [TestMethod]
        public void TestMinDepth_ThreeLevelsTree_ShouldReturnThree()
        {
            // Arrange
            TreeNodeB root = new TreeNodeB(1,
                left: new TreeNodeB(2,
                    left: new TreeNodeB(4),
                    right: null
                ),
                right: new TreeNodeB(3)
            );
            MinimumDepthBinaryTree solution = new MinimumDepthBinaryTree();

            // Act
            int result = solution.MinDepth(root);

            // Assert
            Assert.AreEqual(3, result);
        }

        [TestMethod]
        public void TestMinDepth_ThreeLevelsTree_ShouldReturnTwo()
        {
            // Arrange
            TreeNodeB root = new TreeNodeB(1,
                left: new TreeNodeB(2,
                    left: new TreeNodeB(4),
                    right: null
                ),
                right: null
            );
            MinimumDepthBinaryTree solution = new MinimumDepthBinaryTree();

            // Act
            int result = solution.MinDepth(root);

            // Assert
            Assert.AreEqual(2, result);
        }
    }
}
