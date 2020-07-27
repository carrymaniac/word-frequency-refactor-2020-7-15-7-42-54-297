import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr) {


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {
                List<WordInfo> wordInfoList = generateWordFrequencyList(inputStr);

                wordInfoList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                return generateWordInfoFrequencyString(wordInfoList);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private List<WordInfo> generateWordFrequencyList(String sentence){
        List<String> strings = Arrays.asList(sentence.split("\\s+"));
        List<WordInfo> list = new ArrayList<>();
        for(String uniqueWord:new HashSet<>(strings)){
            long count = strings.stream().filter(word -> word.equals(uniqueWord)).count();
            WordInfo wordInfo = new WordInfo(uniqueWord,(int)count);
            list.add(wordInfo);
        }
        return list;
    }
    private String generateWordInfoFrequencyString(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WordInfo w : wordInfoList) {
            String s = w.getValue() + " " +w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }
}
