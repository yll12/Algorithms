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
    }
}
