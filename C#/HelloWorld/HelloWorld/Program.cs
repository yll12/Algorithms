using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    class Program
    {
        static int Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            Console.WriteLine("You entered the following {0} command line arguments:",
                args.Length );
            foreach (string s in args)
			{
                Console.WriteLine(s);
			}
            return 0;
        }
    }
}
