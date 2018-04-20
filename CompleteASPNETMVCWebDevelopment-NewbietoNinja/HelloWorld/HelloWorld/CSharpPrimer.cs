using System;
using System.Collections.Generic;
using System.Linq;


namespace CSharpPrimer
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("##### Topic 1 - Variable basics #####");
            //Topic 1 - Variable basics
            string myValue = "1";
            string anotherValue = "2";

            int number1 = 1;
            int number2 = 5;

            Console.WriteLine(number1.ToString() + number2.ToString());
            Console.WriteLine(myValue + anotherValue);

            int converted = 0;

            string stringVar = "One";
            bool status = Int32.TryParse(stringVar, out converted);
            Console.WriteLine(converted);

            stringVar = "1";
            status = Int32.TryParse(stringVar, out converted);
            Console.WriteLine(converted);
            Console.ReadLine();


            Console.WriteLine("##### Topic 2 - Real world use case (perhaps) - variables and type conversion #####");
            //Topic 2 - Real world use case (perhaps) - variables and
            //  type conversion 
            int num1 = 0;
            int num2 = 0;
            int answer = 0;

            Console.WriteLine("Enter a number");
            string sNum1 = Console.ReadLine();

            Console.WriteLine("Enter another number");
            string sNum2 = Console.ReadLine();

            Int32.TryParse(sNum1, out num1);
            Int32.TryParse(sNum2, out num2);

            answer = num1 + num2;

            Console.WriteLine("The answer is " + answer);
            Console.ReadLine();


            Console.WriteLine("##### Topic 3 - User defined datatypes #####");
            //Topic 3 - User defined datatypes
            //PetStruct dog;
              // If you want to use a struct internally, you don't need to use 
              //   the 'new' keyword. But if you're passing it around, you need
              //   to use new. Note that even with new, it's still pass by value
            PetStruct dog = new PetStruct(); 
            dog.Type = PetType.Dog;
            dog.HasFur = true;
            dog.Legs = 4;

            PetClass duck = new PetClass();
            //PetClass duck; //"Use of unassigned local variable duck"
              //A difference between struct and class:
              //  Struct is a value type - can be declared like any other type.
              //  Class is a reference type - needs to be instantiated. 
              //  Therefore can have constructors.
            duck.Type = PetType.Duck;
            duck.HasFur = false;
            duck.Legs = 2;

            Console.WriteLine("a " + dog.Type + " has " + dog.Legs + " legs");
            Console.WriteLine("a " + duck.Type + " has " + duck.Legs + " legs");

            MultiplyLegs(dog, duck);

            Console.WriteLine("a " + dog.Type + " has " + dog.Legs + " legs");
            Console.WriteLine("a " + duck.Type + " has " + duck.Legs + " legs");
            Console.ReadLine();


            Console.WriteLine("##### Topic 4 - Arrays, Lists, and Dictionaries #####");
            //Topic 4 - Arrays, Lists, and Dictionaries
            // Note: You can't sort these arrays "automatically"
            //   For that you'll need datatypes from Collections.
            int[] intArray = new int[5];
            string[] stringArray = new string[5];

            int[] populatedArray = new int[] { 0, 1, 2, 3, 4, 5};
            string[] populatedStringArray = new string[] { "One", "Two", "Three" };

            intArray[0] = 5;
            intArray[2] = 15;

            int firstValue = intArray[0];

            // Multidimensional arrays
            int[,] multiInt = new int[2, 3];

            int[,] multiPopulatedInt = { 
                                        {1, 2, 3},
                                        {4, 5, 6}
                                       };

            int firstMultiValue = multiPopulatedInt[0, 0]; //1
            int anotherMultiValue = multiPopulatedInt[1, 2]; //6

            Console.WriteLine(firstMultiValue);
            Console.WriteLine(anotherMultiValue);

            List<string> listOfStrings = new List<string>();

            listOfStrings.Add("first String");
            listOfStrings.Add("second String");
            listOfStrings.Insert(0, "Inserted String");
            //Console.WriteLine(listOfStrings.ToString()); // won't work
            //Console.WriteLine(listOfStrings); // won't work, same as above
            PrintList(listOfStrings);

            listOfStrings.Sort();
            PrintList(listOfStrings);

            listOfStrings.Remove("first String");
            listOfStrings.RemoveAt(0);
            PrintList(listOfStrings);

            // Accessing list elements
            var theFirstString = listOfStrings[0];

            Dictionary<string, string> names = new Dictionary<string, string>();
            names.Add("James", "Bond");
            names.Add("Money", "Penny");

            Console.WriteLine("The name is " + names["James"]);
            //Console.WriteLine(names.ToString()); // won't work
            //Console.WriteLine(names; // won't work, same as above
            PrintDictionary(names);

            names.Remove("James");
            PrintDictionary(names);

            // No Sort for a dict. But you could sort the keys in a separate
            //    list if you wanted to.
            Console.ReadLine();


            Console.WriteLine("##### Topic 5 - LINQ (a query language that can be used to find elements within Lists) #####");
            //Topic 5 - LINQ - a query language that can be used to find 
            //  elements within Lists. e.g. Returning a subset of a list based 
            //  on a certain filter.

            // Syntax:
            //List<PetClass> results = from x in list
            //                         where x = filter
            //                         select x
            List<PetClass> pets = new List<PetClass>();
            pets.Add(new PetClass { HasFur = false, Legs = 2, Name = "Donald", Type = PetType.Duck });
            pets.Add(new PetClass { HasFur = true, Legs = 4, Name = "Pluto", Type = PetType.Dog });

            List<PetClass> results = (from p in pets
                                      where p.Type == PetType.Dog
                                      select p).ToList();
            // The query within the bracket returns an IEnumerable, not a List
            Console.WriteLine("found " + results.Count + " dogs.");

            // Example 2
            PetClass result = (from p in pets
                                      where p.Name == "Pluto"
                               select p).FirstOrDefault();
            Console.WriteLine("result: " + result.Name);

            PetClass resultMissing = (from p in pets
                               where p.Name == "Saturn"
                               select p).FirstOrDefault();
            //Console.WriteLine("result: " + resultMissing.Name);
            //  gives: System.NullReferenceException
            //         "Object reference not set to an instance of an object."

            // Lambda Query
            results = pets.Where(p => p.Type == PetType.Dog).ToList();
            Console.WriteLine("found " + results.Count + " dogs.");

            result = pets.Where(p => p.Name == "Pluto").FirstOrDefault();
            Console.WriteLine("result: " + result.Name);

            // For shorter queries the Lambda expressions are easier to read
            // For more complex queries, the longer forms may be preferred
            Console.ReadLine();
           

            Console.WriteLine("##### Program ends #####");

        }

        // TODO: How could you keep this method generic?
        static void PrintDictionary(Dictionary<string, string> dict) {
            foreach (KeyValuePair<string, string> pair in dict)
            {
                Console.Write("{0}=>{1},", pair.Key, pair.Value);
            }
            Console.WriteLine();
        }

        // TODO: How could you keep this method generic?
        static void PrintList(List<string> list) {
            list.ForEach(item => Console.Write(item + ","));
            Console.WriteLine();
        }

        static void MultiplyLegs(PetStruct petStruct, PetClass petClass) {
            petStruct.Legs *= 2;
            petClass.Legs *= 2;

            Console.WriteLine("Internal Method - A " + petStruct.Type + " has " + petStruct.Legs + " legs.");
            Console.WriteLine("Internal Method - A " + petClass.Type + " has " + petClass.Legs + " legs.");
        }

        class PetClass
        {
            public int Legs;
            public PetType Type;
            public string Name;
            public bool HasFur;
        }

        struct PetStruct
        {
            public int Legs;
            public PetType Type;
            public string Name;
            public bool HasFur;
        }

        /*
         * Enums: Also user defined types, but instead of having properties 
         * and methods, it has a list of values that are available for the 
         * program to choose.
        */
        enum PetType {
            Dog, 
            Duck
        }

    }
}
