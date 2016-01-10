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

        public static void URLify(char[] x, int length)
        {
            int spaceCount = 0;
            for (int i = 0; i < length; i++)
            {
                if (x[i] == ' ')
                {
                    spaceCount += 1;
                }
            }

            int newLength = length + spaceCount * 2;

            for (int j = length - 1; j >= 0; j--) 
            {
                if (x[j] == ' ')
                {
                    x[newLength - 1] = '0';
                    x[newLength - 2] = '2';
                    x[newLength - 3] = '%';
                    newLength -= 3;
                }
                else
                {
                    x[newLength - 1] = x[j];
                    newLength -= 1;
                }

            }

        }

    }
}
