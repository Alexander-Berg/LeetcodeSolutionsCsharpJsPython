using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    public class ExcellSheetColumTitle
    {
        public string ConvertToTitle(int columnNumber)
        {
            var A = (int)'A';

            var res = new StringBuilder();
            while (columnNumber-- > 0)
            {
                res.Insert(0, ((char)(A + columnNumber % 26)));
                columnNumber /= 26;
            }

            return res.ToString();
        }
    }
}
