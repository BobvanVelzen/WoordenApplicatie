/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Bob
 */
public class WoordenAction {
    public int aantal(String input, boolean unique) {
        String[] words = getWords(input);
        if (unique) {return new TreeSet<>(Arrays.asList(words)).size();}
        else return words.length;
    }
    
    public Set<String> sorteer(String input, boolean order){
        TreeSet<String> words = new TreeSet<>(Arrays.asList(getWords(input)));
        if (order) {return words;}
        else return words.descendingSet();
    }
    
    public List<Map.Entry<String, Integer>> frequentie(String input){
        String[] words = getWords(input);
        Map<String, Integer> frequenty = new TreeMap<>();
        for (String s : words)
            frequenty.put(s, 1 + (frequenty.containsKey(s) ? frequenty.get(s) : 0));
        return sortByValue(frequenty);
    }
    
    public TreeMap<String, LinkedList<Integer>> concordatie(String input){
        TreeMap<String, LinkedList<Integer>> concordatie = new TreeMap<>();
        String[] sentences = getSentences(input);
        for (int i = 0; i < sentences.length; i++)
            for (String word : sentences[i].split("\\s+")){
                if (!concordatie.containsKey(word) || concordatie.get(word) == null){
                    LinkedList references = new LinkedList<>();
                    references.add(i + 1);
                    concordatie.put(word, references);
                }
                else{
                    LinkedList references = concordatie.get(word);
                    references.add(i + 1);
                }
            }
        concordatie.remove("");
        return concordatie;
    }
        
    private String[] getWords(String text){
        String input = text.toLowerCase();
        input = input.replaceAll("\\p{P}", "");
        String[] words = input.split("\\s+");
        return words;
    }
    
    private String[] getSentences(String text){
        String input = text.toLowerCase();
        input = input.replaceAll("\\p{P}", "");
        String[] sentences = input.split("\n");
        return sentences;
    }
    
    private List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> unsortMap)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());
        Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o1.getValue().compareTo(o2.getValue()));
        return list;
    }
}
