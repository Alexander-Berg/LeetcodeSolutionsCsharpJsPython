using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LeetCodeSolutionsCSharp;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace LeetCodeSolutionsCSharp
{
    [TestClass]
    public class AddBinarySolutionTests
    {
        [TestMethod]
        public void TestAddBinary()
        {
            AddBinarySolution solution = new AddBinarySolution();

            string a = "101";
            string b = "1101";
            string expected = "10010";
            string actual = solution.AddBinary(a, b);
            Assert.AreEqual(expected, actual);

            a = "11";
            b = "1";
            expected = "100";
            actual = solution.AddBinary(a, b);
            Assert.AreEqual(expected, actual);

            a = "0";
            b = "0";
            expected = "0";
            actual = solution.AddBinary(a, b);
            Assert.AreEqual(expected, actual);

            a = "1111111";
            b = "1111111";
            expected = "11111110";
            actual = solution.AddBinary(a, b);
            Assert.AreEqual(expected, actual);
        }
    }
}

