import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    private Node [] links;
    private boolean isEnd;

    Node() {
        links = new Node[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    } 

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}


class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++) {
            char chr = word.charAt(i);
            if(!node.containsKey(chr)) {
                node.put(chr, new Node());
            }
            node = node.get(chr);
        }
        node.setEnd();
    }

    public Node searchPrefix(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            char chr = word.charAt(i);
            if(node.containsKey(chr)) {
                node = node.get(chr);
            }
            else return null;
        }
        return node;
    }

    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = searchPrefix(prefix);
        return node != null;
    }

}

class TrieImpl {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> data = Arrays.asList(input.split(" "));
        Trie trie = new Trie();
        for (String s : data) {
            trie.insert(s);
        }

        input = br.readLine();
        int q = Integer.parseInt(input);
        while(q-- > 0) {
            input = br.readLine();
            if(trie.search(input)) {
                System.out.println("String "+ input + " present in the trie");
            }
            else {
                System.out.println("String " + input + " is absent in the trie");
            }
        }
    }
}