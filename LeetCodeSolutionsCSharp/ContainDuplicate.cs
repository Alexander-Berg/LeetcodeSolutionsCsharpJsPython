using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    public class ContainDuplicate
    {
        public bool ContainsNearbyDuplicate(int[] nums, int k)
        {
            Dictionary<int, int> d = new Dictionary<int, int>();

            for (int i = 0; i < nums.Length; i++)
            {
                if (d.ContainsKey(nums[i]))
                {
                    if (i - d[nums[i]] <= k) return true;
                    d[nums[i]] = i;
                }
                else
                {
                    d.Add(nums[i], i);
                }
            }

            return false;
        }
    }
}
