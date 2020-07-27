import java.util.*;

public class WordFrequencyGame {

    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final String SPACE_REGEX = "\\s+";
    private static final String LINE_BREAK_DELIMITER = "\n";
    public static final String BLANK_SPACE = " ";


    public String getResult(String sentence) {
            try {
                List<WordInfo> wordInfoList = generateWordFrequencyList(sentence);
                wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
                return generateWordInfoFrequencyString(wordInfoList);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
    }

    private List<WordInfo> generateWordFrequencyList(String sentence) {
        List<String> strings = Arrays.asList(sentence.split(SPACE_REGEX));
        List<WordInfo> wordInfos = new ArrayList<>();
        for (String uniqueWord : new HashSet<>(strings)) {
            long count = strings.stream().filter(word -> word.equals(uniqueWord)).count();
            WordInfo wordInfo = new WordInfo(uniqueWord, (int) count);
            wordInfos.add(wordInfo);
        }
        return wordInfos;
    }

    private String generateWordInfoFrequencyString(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(LINE_BREAK_DELIMITER);
        for (WordInfo w : wordInfoList) {
            String s = w.getValue() + BLANK_SPACE + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }
}
