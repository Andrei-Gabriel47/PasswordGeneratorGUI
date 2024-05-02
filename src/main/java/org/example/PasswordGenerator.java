package org.example;

import java.util.Random;
import java.util.random.RandomGenerator;

public class PasswordGenerator
{
    public static String Lowercase="qwertyuiopasdfghjklzxcvbnm";
    public static String Uppercase="QWERTYUIOPASDFGHJKLZXCVBNM";
    public static String Numbers="0123456789";
    public static String Symbols="`~!@#$%^&*()-_+{}|<>?/,.';][=";

    private Random random;
    public PasswordGenerator()
    {
        random = new Random();
    }

    public String generatePassword(int Lenght,boolean includeUppercase,boolean includeLowercase, boolean IncludeNumbers, boolean IncludeSymbols)
    {
       StringBuilder passwordBuilder = new StringBuilder();
       String validChar ="";
       if(includeLowercase) validChar+=Lowercase;
       if(includeUppercase) validChar+=Uppercase;
       if(IncludeNumbers) validChar+=Numbers;
       if(IncludeSymbols) validChar+=Symbols;

       //generating the actual password
        for(int i=0;i<Lenght;i++)
        {
            int randomIndex = random.nextInt(validChar.length()-1);
            char randomChar = validChar.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }
}
