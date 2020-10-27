package com.example.lms.function;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class SubString {
    public boolean isSubstring(
            String s1, String s2)
    {
        int firstString = s1.length();
        int secondString = s2.length();


        for (int i = 0; i <= secondString - firstString; i++) {
            int j;

            for (j = 0; j < firstString; j++)
                if (s2.charAt(i + j)
                        != s1.charAt(j))
                    break;

            if (j == firstString)
                return true;
        }

        return false;
    }
}
