using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;

namespace LeetCodeSolutionsCSharpTests
{
    [TestClass]
    public class IsomorphicStringsTests
    {
        private readonly IsomorphicStrings _isomorphicStrings;

        public IsomorphicStringsTests()
        {
            _isomorphicStrings = new IsomorphicStrings();
        }

        [TestMethod]
        public void IsIsomorphic_ShouldReturnTrue_WhenGivenEmptyStrings()
        {
            // Arrange
            string s = "";
            string t = "";

            // Act
            bool result = _isomorphicStrings.IsIsomorphic(s, t);

            // Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void IsIsomorphic_ShouldReturnTrue_WhenGivenStringsOfSameLengthAndMapping()
        {
            // Arrange
            string s = "egg";
            string t = "add";

            // Act
            bool result = _isomorphicStrings.IsIsomorphic(s, t);

            // Assert
            Assert.IsTrue(result);
        }

        [TestMethod]
        public void IsIsomorphic_ShouldReturnFalse_WhenGivenStringsOfSameLengthAndNonMapping()
        {
            // Arrange
            string s = "foo";
            string t = "bar";

            // Act
            bool result = _isomorphicStrings.IsIsomorphic(s, t);

            // Assert
            Assert.IsFalse(result);
        }

        [TestMethod]
        public void IsIsomorphic_ShouldReturnFalse_WhenGivenStringsOfDifferentLength()
        {
            // Arrange
            string s = "ab";
            string t = "abc";

            // Act
            bool result = _isomorphicStrings.IsIsomorphic(s, t);

            // Assert
            Assert.IsFalse(result);
        }
    }
}
