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
    public class MyStackQueueTests
    {
        [TestMethod]
        public void TestPushAndPop()
        {
            MyStackQueue stackQueue = new MyStackQueue();
            stackQueue.Push(1);
            stackQueue.Push(2);
            stackQueue.Push(3);

            Assert.AreEqual(3, stackQueue.Pop());
            Assert.AreEqual(2, stackQueue.Pop());
            Assert.AreEqual(1, stackQueue.Pop());
        }

        [TestMethod]
        public void TestTop()
        {
            MyStackQueue stackQueue = new MyStackQueue();
            stackQueue.Push(1);
            stackQueue.Push(2);
            stackQueue.Push(3);

            Assert.AreEqual(3, stackQueue.Top());
            Assert.AreEqual(3, stackQueue.Top());
        }

        [TestMethod]
        public void TestEmpty()
        {
            MyStackQueue stackQueue = new MyStackQueue();
            Assert.IsTrue(stackQueue.Empty());

            stackQueue.Push(1);
            Assert.IsFalse(stackQueue.Empty());

            stackQueue.Pop();
            Assert.IsTrue(stackQueue.Empty());
        }
    }
}
