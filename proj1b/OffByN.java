public class OffByN implements CharacterComparator{
    private int N;

    public OffByN(int N) {
       this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        int[] box = {N, -N, 32 + N, 32 -N, -32 + N, -32 - N}; //'A'-'a' = -32
        for (int i: box) {
            if (diff == i) {
               return true;
            }
        }
        return false;
    }
}
