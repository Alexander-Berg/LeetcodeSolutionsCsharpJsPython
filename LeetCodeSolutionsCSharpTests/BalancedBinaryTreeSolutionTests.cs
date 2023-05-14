using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LeetCodeSolutionsCSharp;
using Microsoft.VisualStudio.TestTools.UnitTesting;

[TestClass]
public class BalancedBinaryTreeSolutionTests
{
    [TestMethod]
    public void TestIsBalanced_ReturnsTrueForNull()
    {
        // Arrange
        var solution = new BalancedBinaryTreeSolution();

        // Act
        bool isBalanced = solution.IsBalanced(null);

        // Assert
        Assert.IsTrue(isBalanced);
    }

    [TestMethod]
    public void TestIsBalanced_ReturnsTrueForSingleRootNode()
    {
        // Arrange
        var root = new TreeNodeN(5);
        var solution = new BalancedBinaryTreeSolution();

        // Act
        bool isBalanced = solution.IsBalanced(root);

        // Assert
        Assert.IsTrue(isBalanced);
    }

    [TestMethod]
    public void TestIsBalanced_ReturnsTrueForBalancedTree()
    {
        // Arrange
        var root = new TreeNodeN(5,
            new TreeNodeN(3,
                new TreeNodeN(1),
                new TreeNodeN(4)),
            new TreeNodeN(7,
                new TreeNodeN(6),
                new TreeNodeN(8)));
        var solution = new BalancedBinaryTreeSolution();

        // Act
        bool isBalanced = solution.IsBalanced(root);

        // Assert
        Assert.IsTrue(isBalanced);
    }

    [TestMethod]
    public void TestIsBalanced_ReturnsFalseForUnbalancedTree()
    {
        // Arrange
        var root = new TreeNodeN(5,
            new TreeNodeN(3,
                new TreeNodeN(1,
                    new TreeNodeN(0)),
                null),
            new TreeNodeN(7,
                new TreeNodeN(6),
                new TreeNodeN(8)));
        var solution = new BalancedBinaryTreeSolution();

        // Act
        bool isBalanced = solution.IsBalanced(root);

        // Assert
        Assert.IsFalse(isBalanced);
    }
}
