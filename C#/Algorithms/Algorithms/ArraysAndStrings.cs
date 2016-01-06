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


    }
}
