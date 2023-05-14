using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCodeSolutionsCSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LeetCodeSolutionsCSharp
{
    [TestClass]
    public class ExcelSheetColumnTitleTests
    {
        [TestMethod]
        public void TestConvertToTitle()
        {
            // Arrange
            var excelSheet = new ExcellSheetColumTitle();

            // Act
            var title1 = excelSheet.ConvertToTitle(1);
            var title2 = excelSheet.ConvertToTitle(28);
            var title3 = excelSheet.ConvertToTitle(701);
            var title4 = excelSheet.ConvertToTitle(2147483647);

            // Assert
            Assert.AreEqual("A", title1);
            Assert.AreEqual("AB", title2);
            Assert.AreEqual("ZY", title3);
            Assert.AreEqual("FXSHRXW", title4);
        }
    }
}
