using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
  
    public class MyStackQueue
    {

        Queue<int> q1 = new Queue<int>();
        Queue<int> q2 = new Queue<int>();
        public MyStackQueue()
        {
        }

        public void Push(int x)
        {
            q1.Enqueue(x);
        }

        public int Pop()
        {
            Queue<int> temp = new Queue<int>();
            while (q1.Count() > 1)
            {
                q2.Enqueue(q1.Dequeue());
            }
            int t = q1.Dequeue();
            temp = q2;
            q2 = q1;
            q1 = temp;
            return t;
        }

        public int Top()
        {
            Queue<int> temp = new Queue<int>();
            while (q1.Count() > 1)
            {
                q2.Enqueue(q1.Dequeue());
            }
            int t = q1.Dequeue();
            q2.Enqueue(t);
            temp = q2;
            q2 = q1;
            q1 = temp;
            return t;
        }

        public bool Empty()
        {
            if (q1.Count() > 0)
                return false;
            else
                return true;
        }
    }

}

/* Your MyStack object will be instantiated and called as such:
  MyStackF obj = new MyStackF();
  obj.Push(x);
    int param_2 = obj.Pop();
  int param_3 = obj.Top();
  bool param_4 = obj.Empty();
  public class MyStackF
  {
  }
*/
