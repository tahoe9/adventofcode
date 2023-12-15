package adventofcode;

public class E208ImplementTrie {

    class Trie {
        TrieNode root = null;

        class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord = false;
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode runner = root;

            for(char c : word.toCharArray()) {
                TrieNode child = runner.children[c - 'a'];
                if (child == null) {child = new TrieNode(); runner.children[c - 'a'] = child;}

                runner = child;
            }

            runner.isWord = true;
        }

        public boolean search(String word) {
            TrieNode runner = root;

            for(char c : word.toCharArray()) {
                TrieNode child = runner.children[c - 'a'];
                if (child == null) return false;

                runner = child;
            }

            return runner.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode runner = root;

            for(char c : prefix.toCharArray()) {
                TrieNode child = runner.children[c - 'a'];
                if (child == null) return false;

                runner = child;
            }

            return true;
        }
    }

    public static void main(String[] strings) {
        E208ImplementTrie solution = new E208ImplementTrie();
        Trie trie = solution.new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }

}
