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
    public class SameTreeSolutionTests
    {
        private SameTreeSolution solution;

        [TestInitialize]
        public void Initialize()
        {
            solution = new SameTreeSolution();
        }

        [TestMethod]
        public void IsSameTree_BothTreesAreNull_ReturnsTrue()
        {
            TreeNode p = null;
            TreeNode q = null;

            bool result = solution.IsSameTree(p, q);

            Assert.IsTrue(result);
        }

        [TestMethod]
        public void IsSameTree_OneTreeIsNull_ReturnsFalse()
        {
            TreeNode p = null;
            TreeNode q = new TreeNode();

            bool result = solution.IsSameTree(p, q);

            Assert.IsFalse(result);
        }

        [TestMethod]
        public void IsSameTree_TreesHaveDifferentValues_ReturnsFalse()
        {
            TreeNode p = new TreeNode(1);
            TreeNode q = new TreeNode(2);

            bool result = solution.IsSameTree(p, q);

            Assert.IsFalse(result);
        }

        [TestMethod]
        public void IsSameTree_TreesHaveSameStructureAndValues_ReturnsTrue()
        {
            TreeNode p = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
            );
            TreeNode q = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
            );

            bool result = solution.IsSameTree(p, q);

            Assert.IsTrue(result);
        }

        [TestMethod]
        public void IsSameTree_TreesHaveSameValuesButDifferentStructure_ReturnsFalse()
        {
            TreeNode p = new TreeNode(1,
                new TreeNode(2),
                null
            );
            TreeNode q = new TreeNode(1,
                null,
                new TreeNode(2)
            );

            bool result = solution.IsSameTree(p, q);

            Assert.IsFalse(result);
        }
    }
}
