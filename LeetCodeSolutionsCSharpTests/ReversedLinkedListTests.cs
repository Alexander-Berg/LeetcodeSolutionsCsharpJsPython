using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


[TestClass]
public class ReversedLinkedListTests
{
    [TestMethod]
    public void TestReverseList_Null()
    {
        // Arrange
        ListNodeX head = null;
        ReversedLinkedList solution = new ReversedLinkedList();

        // Act
        ListNodeX result = solution.ReverseList(head);

        // Assert
        Assert.IsNull(result);
    }

    [TestMethod]
    public void TestReverseList_OneNode()
    {
        // Arrange
        ListNodeX head = new ListNodeX(1);
        ReversedLinkedList solution = new ReversedLinkedList();

        // Act
        ListNodeX result = solution.ReverseList(head);

        // Assert
        Assert.AreEqual(1, result.val);
        Assert.IsNull(result.next);
    }

    [TestMethod]
    public void TestReverseList_MultipleNodes()
    {
        // Arrange
        ListNodeX head = new ListNodeX(1, new ListNodeX(2, new ListNodeX(3)));
        ReversedLinkedList solution = new ReversedLinkedList();

        // Act
        ListNodeX result = solution.ReverseList(head);

        // Assert
        Assert.AreEqual(3, result.val);
        Assert.AreEqual(2, result.next.val);
        Assert.AreEqual(1, result.next.next.val);
        Assert.IsNull(result.next.next.next);
    }
}
