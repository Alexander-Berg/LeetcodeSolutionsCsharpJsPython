using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    public class SummaryRangesSolution
    {
        public IList<string> SummaryRanges(int[] nums)
        {
            var result =
                from i in Enumerable.Range(0, nums.Length)
                let num = nums[i]
                group num by num - i into range
                let a = range.First()
                let b = range.Last()
                select a == b ? $"{a}" : $"{a}->{b}";

            return result.ToList();
        }
    }
}
