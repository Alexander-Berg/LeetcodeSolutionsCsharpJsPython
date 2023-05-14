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
    public class RemoveLinkedListElementsTests
    {
        [TestMethod]
        public void Test_RemoveElements_RemovesAllOccurrencesOfVal()
        {
            // Arrange
            var list = new ListNodeB(1, new ListNodeB(2, new ListNodeB(6, new ListNodeB(3, new ListNodeB(4, new ListNodeB(5, new ListNodeB(6)))))));
            var val = 6;
            var solution = new RemoveLinkedListElements();

            // Act
            var result = solution.RemoveElements(list, val);

            // Assert
            Assert.AreEqual(1, result.val);
            Assert.AreEqual(2, result.next.val);
            Assert.AreEqual(3, result.next.next.val);
            Assert.AreEqual(4, result.next.next.next.val);
            Assert.AreEqual(5, result.next.next.next.next.val);
            Assert.IsNull(result.next.next.next.next.next);
        }

        [TestMethod]
        public void Test_RemoveElements_RemovesFirstElement()
        {
            // Arrange
            var list = new ListNodeB(1, new ListNodeB(2, new ListNodeB(3)));
            var val = 1;
            var solution = new RemoveLinkedListElements();

            // Act
            var result = solution.RemoveElements(list, val);

            // Assert
            Assert.AreEqual(2, result.val);
            Assert.AreEqual(3, result.next.val);
            Assert.IsNull(result.next.next);
        }

        [TestMethod]
        public void Test_RemoveElements_RemovesLastElement()
        {
            // Arrange
            var list = new ListNodeB(1, new ListNodeB(2, new ListNodeB(3)));
            var val = 3;
            var solution = new RemoveLinkedListElements();

            // Act
            var result = solution.RemoveElements(list, val);

            // Assert
            Assert.AreEqual(1, result.val);
            Assert.AreEqual(2, result.next.val);
            Assert.IsNull(result.next.next);
        }

        [TestMethod]
        public void Test_RemoveElements_RemovesAllElements()
        {
            // Arrange
            var list = new ListNodeB(1, new ListNodeB(1, new ListNodeB(1)));
            var val = 1;
            var solution = new RemoveLinkedListElements();

            // Act
            var result = solution.RemoveElements(list, val);

            // Assert
            Assert.IsNull(result);
        }

        [TestMethod]
        public void Test_RemoveElements_EmptyList()
        {
            // Arrange
            ListNodeB list = null;
            var val = 1;
            var solution = new RemoveLinkedListElements();

            // Act
            var result = solution.RemoveElements(list, val);

            // Assert
            Assert.IsNull(result);
        }
    }
}
