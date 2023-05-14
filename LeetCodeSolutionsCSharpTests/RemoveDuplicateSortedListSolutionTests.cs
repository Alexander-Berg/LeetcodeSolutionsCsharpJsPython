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
public class RemoveDuplicateSortedListSolutionTests
{
    [TestMethod]
    public void Test1()
    {
        // Arrange
        var node1 = new ListNode(1);
        var node2 = new ListNode(1);
        var node3 = new ListNode(2);
        var node4 = new ListNode(3);
        var node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        var solution = new RemoveDuplicateSortedListSolution();

        // Act
        var result = solution.DeleteDuplicates(node1);

        // Assert
        Assert.AreEqual(1, result.val);
        Assert.AreEqual(2, result.next.val);
        Assert.AreEqual(3, result.next.next.val);
        Assert.IsNull(result.next.next.next);
    }

    [TestMethod]
    public void Test2()
    {
        // Arrange
        var node1 = new ListNode(1);
        var node2 = new ListNode(1);
        var node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        var solution = new RemoveDuplicateSortedListSolution();

        // Act
        var result = solution.DeleteDuplicates(node1);

        // Assert
        Assert.AreEqual(1, result.val);
        Assert.IsNull(result.next);
    }

    [TestMethod]
    public void Test3()
    {
        // Arrange
        var node1 = new ListNode(1);
        var node2 = new ListNode(2);
        var node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        var solution = new RemoveDuplicateSortedListSolution();

        // Act
        var result = solution.DeleteDuplicates(node1);

        // Assert
        Assert.AreEqual(1, result.val);
        Assert.AreEqual(2, result.next.val);
        Assert.AreEqual(3, result.next.next.val);
        Assert.IsNull(result.next.next.next);
    }
}
