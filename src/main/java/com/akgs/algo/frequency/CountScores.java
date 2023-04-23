package com.akgs.algo.frequency;

import java.util.*;

public class CountScores {
    public static void main(String[] args) {
        final int[] ints = Arrays.stream(List.of(330, 730, 825).toArray()).mapToInt(i -> (int) i).toArray();
        for ( String s: solution(ints)) {
            System.out.println(s);
        }
    }

    public static String[] solution(int[] scores) {
        final List<String> strings = new ArrayList<>();
        Map<String, Integer> freqLevels = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            categoriseScore(scores[i], freqLevels);
        }
        freqLevels.entrySet().stream().sorted(((o1, o2) -> {
            int comp = o2.getValue().compareTo(o1.getValue());
            if (comp != 0)
                return comp;
            return compareLevel(o2.getKey(), o1.getKey());
        })).forEach(entry -> {
            strings.add(entry.getKey() + " - " + entry.getValue());
        });

        return strings.stream().toArray(String[]::new);
    }

    public static int compareLevel (String l1, String l2) {
        return levelToInt(l1).compareTo(levelToInt(l2));
    }

    private static Integer levelToInt(String l1) {
        switch (l1) {
            case "Elite": return 5;
            case "Excellent": return 4;
            case "Good": return 3;
            case "Fair": return 2;
            case "Poor": return 1;
        }
        return 0;
    }

    public static void categoriseScore(int score, Map<String, Integer> freqLevels) {
        if (score >= 300 && score < 600) {
            incrementFreqMap("Poor",freqLevels);
        } else if (score >= 600 && score <700) {
            incrementFreqMap("Fair",freqLevels);
        } else if (score >= 700 && score <750) {
            incrementFreqMap("Good",freqLevels);
        } else if (score >= 750 && score <800) {
            incrementFreqMap("Excellent",freqLevels);
        } else if (score >= 800){
            incrementFreqMap("Elite",freqLevels);
        }
    }

    private static void incrementFreqMap(String level, Map<String, Integer> freqLevels) {
        int count = freqLevels.getOrDefault(level,0);
        freqLevels.put(level, count+1);
    }
}
