using System;

namespace ProgramFlow
{
    class Program
    {

        static int GetGuess() {
            int result = 0;
            Console.WriteLine("Please guess the number");
            String answer = Console.ReadLine();
            Int32.TryParse(answer, out result);
            return result;
        }

        static void Main(string[] args)
        {
            int ourNumber = 10;
            int guessNumber = 0;

            while (ourNumber != guessNumber)
            {
                guessNumber = GetGuess();

                if (guessNumber == ourNumber)
                {
                    Console.WriteLine("Correct! Well Done!");
                }
                else if (guessNumber > ourNumber)
                {
                    Console.WriteLine("Oops, sorry! Too high!");
                }
                else
                {
                    Console.WriteLine("Oops, sorry! Too low!");
                }
            }

            Console.ReadLine();
            Console.WriteLine("New game.");
            guessNumber = 0;

            //for (int n = 10; n > 0 && ourNumber != guessNumber; n--)
            for (int n = 10; n > 0; n--) {
                guessNumber = GetGuess();

                if (guessNumber == ourNumber)
                {
                    Console.WriteLine("Correct! Well Done!");
                    break;
                }
                else if (guessNumber > ourNumber)
                {
                    Console.WriteLine("Oops, sorry! Too high! You have {0} guesses left", n-1);
                }
                else
                {
                    Console.WriteLine("Oops, sorry! Too low! You have {0} guesses left", n - 1);
                }
            }

            Console.ReadLine();
            Console.WriteLine("New game.");

            // The comparer in the case statement MUST be a constant!
            const int ourConstNumber = 10;
            // const: Once declared, you can't change it
            guessNumber = 0;
            for (int n = 5; n > 0; n--)
            {
                Console.WriteLine("You have {0} guess(es) left", n);
                guessNumber = GetGuess();
                switch (guessNumber) {
                    case (ourConstNumber):
                        Console.WriteLine("Correct! Well Done!");
                        n = 0; // To force break out of for loop
                        break; // breaks out of switch
                    case (1):
                        Console.WriteLine("Oops, sorry! 1 is pretty low!");
                        break;
                    case (20):
                        Console.WriteLine("Oops, sorry! 20 is pretty high!");
                        break;
                    default:
                        if (guessNumber > ourNumber)
                        {
                            Console.WriteLine("Oops, sorry! Too high!");
                        }
                        else
                        {
                            Console.WriteLine("Oops, sorry! Too low!");
                        }
                        break;
                }
            }
        }
    }
}
