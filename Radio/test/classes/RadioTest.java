package classes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RadioTest {

    //Prueba de metodo getFrecuency. Verifica si esta en fm o en am, al retornar false esta en am
    @Test
    public void test(){
        Radio test = new Radio();
        Boolean  result = test.getFrecuency();
        assertEquals(false, result);
    }

    //Prueba de metodo getState. Verifica si el radio esta encendido o apagado. False es apagado.
    @Test
    public void test2(){
        Radio test2 = new Radio();
        Boolean result2 = test2.getState();
        assertEquals(false, result2);
    }

    @Test
    public void test3(){
        Radio test3 = new Radio();
        double result3 = test3.getStation();
        assertEquals(550.0, result3, 600.0);
    }
}