/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.WoordenAction;

/**
 *
 * @author Bob
 */
public class WoordenControllerTest {
    
    private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    private static final WoordenAction WA = new WoordenAction();
    
    
    public WoordenControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAantal() {
        //@return aantal woorden
        int aantal = WA.aantal(DEFAULT_TEXT, false);
        //@return aantal unieke woorden
        int aantalUniek = WA.aantal(DEFAULT_TEXT, true);
        
        assertEquals(aantal, 68);
        assertEquals(aantalUniek, 28);
    }
    
    @Test
    public void testSorteer() {
        //@return gesorteerde woorden
        Set<String> gesorteerd = WA.sorteer(DEFAULT_TEXT, true);
        //@return gesorteerde woorden omgekeerd
        Set<String> gesorteerdOmgekeerd = WA.sorteer(DEFAULT_TEXT, false);
        
        assertEquals(gesorteerd.toArray()[0], "als");
        assertEquals(gesorteerdOmgekeerd.toArray()[0], "één");
    }
    
    @Test
    public void testFrequentie() {
        //@return frequentie per woord
        List<Map.Entry<String, Integer>> frequentie = WA.frequentie(DEFAULT_TEXT);
        int test = -1;
        for (Map.Entry<String, Integer> e : frequentie){
            if (e.getKey().equals("hoedje")){
                test = e.getValue();
                break;
            }
        }
        
        assertEquals(test, 10);
    }
    
    @Test
    public void testConcordatie() {
        //@return concordatie per woord
        Map<String, LinkedList<Integer>> concordatie = WA.concordatie(DEFAULT_TEXT);
        LinkedList<Integer> test = new LinkedList<>();
        test.add(4);
        test.add(9);
        test.add(14);
        test.add(19);
        
        assertEquals(concordatie.get("papier"), test);
    }
}
