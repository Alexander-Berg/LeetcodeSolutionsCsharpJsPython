using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace LeetCodeSolutionsCSharp
{
    [TestClass]
    public class ContainDuplicateTests
    {
        [TestMethod]
        public void ContainsNearbyDuplicate_ShouldReturnTrue_WhenDuplicatesExistWithinKRange()
        {
            // Arrange
            int[] nums = { 1, 2, 3, 1 };
            int k = 3;
            ContainDuplicate cd = new ContainDuplicate();

            // Act
            bool result = cd.ContainsNearbyDuplicate(nums, k);

            // Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void ContainsNearbyDuplicate_ShouldReturnFalse_WhenNoDuplicatesExistWithinKRange()
        {
            // Arrange
            int[] nums = { 1, 2, 3, 1, 2, 3 };
            int k = 2;
            ContainDuplicate cd = new ContainDuplicate();

            // Act
            bool result = cd.ContainsNearbyDuplicate(nums, k);

            // Assert
            Assert.IsFalse(result);
        }
    }
}
