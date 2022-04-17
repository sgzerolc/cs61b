public class Palindrome {
    public Deque<Character> wordToDeque(String Word) {
        LinkedListDeque<Character> words = new LinkedListDeque<Character>();
        int i = 0;
        while (i < Word.length()) {
            words.addLast(Word.charAt(i));
            i += 1; // always set iterative term to stop
        }
        return words;
    }

    private boolean ispal(Deque<Character> word, int leng) {
        if (leng == 0 || leng == 1) {
            return true;
        }
        Character first = word.removeFirst();
        Character last = word.removeLast();
        return first == last && ispal(word, leng - 2); // it can be reduced to one line(above 2 lines), but I don't wanna.
    }

    public boolean isPalindrome(String word) {
        int length = word.length();
        Deque<Character> toconsider = wordToDeque(word);
        return ispal(toconsider, length);
    }

    private boolean ispal(Deque<Character> word, int leng, CharacterComparator offby) {
       if (leng == 0 || leng == 1) {
           return true;
       }
       Character first = word.removeFirst();
       Character last = word.removeLast();
       return offby.equalChars(first, last) && ispal(word, leng - 2, offby);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int length = word.length();
        Deque<Character> toconsider = wordToDeque(word);
        CharacterComparator offbyone = new OffByOne();
        return ispal(toconsider, length, offbyone);

    }
}
