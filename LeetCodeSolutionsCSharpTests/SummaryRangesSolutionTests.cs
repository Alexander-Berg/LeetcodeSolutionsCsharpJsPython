using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LeetCodeSolutionsCSharp
{
    [TestClass]
    public class SummaryRangesSolutionTests
    {
        [TestMethod]
        public void TestSummaryRanges()
        {
            // Arrange
            SummaryRangesSolution solution = new SummaryRangesSolution();
            int[] nums1 = new int[] { 0, 1, 2, 4, 5, 7 };
            int[] nums2 = new int[] { 0, 2, 3, 4, 6, 8, 9 };
            int[] nums3 = new int[] { };
            int[] nums4 = new int[] { -1 };
            int[] nums5 = new int[] { 0 };

            // Act
            IList<string> result1 = solution.SummaryRanges(nums1);
            IList<string> result2 = solution.SummaryRanges(nums2);
            IList<string> result3 = solution.SummaryRanges(nums3);
            IList<string> result4 = solution.SummaryRanges(nums4);
            IList<string> result5 = solution.SummaryRanges(nums5);

            // Assert
            CollectionAssert.AreEqual(new List<string> { "0->2", "4->5", "7" }, (System.Collections.ICollection)result1);
            CollectionAssert.AreEqual(new List<string> { "0", "2->4", "6", "8->9" }, (System.Collections.ICollection)result2);
            CollectionAssert.AreEqual(new List<string> { }, (System.Collections.ICollection)result3);
            CollectionAssert.AreEqual(new List<string> { "-1" }, (System.Collections.ICollection)result4);
            CollectionAssert.AreEqual(new List<string> { "0" }, (System.Collections.ICollection)result5);
        }
    }
}
