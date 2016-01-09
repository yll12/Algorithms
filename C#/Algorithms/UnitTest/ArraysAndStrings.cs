using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTest
{
    [TestClass]
    public class ArraysAndStrings
    {
        [TestMethod]
        public void isUnique1()
        {
            // arrange
            string x = "abcdefghijklmn";

            bool actual = Algorithms.ArraysAndStrings.isUnique(x);

            Assert.IsTrue(actual);
        }

        [TestMethod]
        public void isUnique2()
        {
            // arrange
            string x = "abcdefzhijklmnf";

            bool actual = Algorithms.ArraysAndStrings.isUnique(x);

            Assert.IsFalse(actual);
        }

        [TestMethod]
        public void isUnique3()
        {
            // arrange
            string x = "12./[]_+9gf";

            bool actual = Algorithms.ArraysAndStrings.isUnique(x);

            Assert.IsTrue(actual);
        }

        [TestMethod]
        public void isUnique4()
        {
            // arrange
            string x = "1";

            bool actual = Algorithms.ArraysAndStrings.isUnique(x);

            Assert.IsTrue(actual);
        }

        [TestMethod]
        public void isPermutation1()
        {
            string x = "ab1406";
            string y = "0ba146";

            bool actual = Algorithms.ArraysAndStrings.isPermutation(x, y);

            Assert.IsTrue(actual);
        }

        [TestMethod]
        public void isPermutation2()
        {
            string x = "ab1406";
            string y = "ab1455";

            bool actual = Algorithms.ArraysAndStrings.isPermutation(x, y);

            Assert.IsFalse(actual);
        }

        [TestMethod]
        public void isPermutation3()
        {
            string x = "";
            string y = "";

            bool actual = Algorithms.ArraysAndStrings.isPermutation(x, y);

            Assert.IsTrue(actual);
        }

        [TestMethod]
        public void isPermutation4()
        {
            string x = " ";
            string y = " ";

            bool actual = Algorithms.ArraysAndStrings.isPermutation(x, y);

            Assert.IsTrue(actual);
        }

        [TestMethod]
        public void URLify1()
        {
            string x = "Mr John Smith    ";
            char[] y = x.ToCharArray();
            Algorithms.ArraysAndStrings.URLify(y, 13);
            string expected = "Mr%20John%20Smith";
            string actual = new string(y);
            Assert.AreEqual(actual, expected);
        }

        [TestMethod]
        public void URLify2()
        {
            string x = "Mr";
            char[] y = x.ToCharArray();
            Algorithms.ArraysAndStrings.URLify(y, 2);
            string expected = "Mr";
            string actual = new string(y);
            Assert.AreEqual(actual, expected);
        }
    }
}
