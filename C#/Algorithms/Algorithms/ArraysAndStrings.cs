using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithms
{
    public class ArraysAndStrings
    {
        public static bool isUnique(string x) {
            // Can only make unique string up to length 128 
            // with only 128 different characters 
            if (x.Length > 128)
            {
                return false;
            }
            bool[] char_set = new bool[130];
            foreach (char i in x) {
                if (char_set[i])
                {
                    return false;
                }
                char_set[i] = true;
            }
            return true;
        }

        public static bool isPermutation(string x, string y)
        {
            int x_length = x.Length;
            int y_length = y.Length;
            if (x_length != y_length)
            {
                return false;
            }
            int[] letters = new int[128];
            foreach (char i in x)
            {
                letters[i]++;
            }

            for (int i = 0; i < y_length; i++)
            {
                letters[y[i]]--;
                if (letters[y[i]] < 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
