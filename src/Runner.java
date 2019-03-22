import textprocessing.Trie;
import trees.*;

public class Runner {
    public static void main(String[] args) {
        int[] array = {54, 45, 63, 36, 51, 61, 18, 39, 47, 52,};
        Trie trie = new Trie();
        trie.insert("Sachin", "Vishal", "suchita", "sachmmmm");
        for (String s : trie.autoCompleteWords("sa"))
            System.out.println(s);
    }
}
