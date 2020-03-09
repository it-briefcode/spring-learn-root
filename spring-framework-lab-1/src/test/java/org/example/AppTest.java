package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        long l = System.currentTimeMillis();
        assertTrue( true );
        String str = "9876";
        //System.out.println(str.matches("^[0-9]\\d*$"));
        String reg = "(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3,7}|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){3,7})\\d";
        System.out.println(str.matches(reg));
        System.out.println(System.currentTimeMillis()-l);
    }
}
