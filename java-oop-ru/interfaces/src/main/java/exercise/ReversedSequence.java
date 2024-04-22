package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    /*int length();
    CharSequence subSequence(int start, int end);
    char charAt(int index);
    public String toString();*/
    String seq;
    ReversedSequence(String str) {
        this.seq = new StringBuilder(str).reverse().toString();
    }
    @Override
    public String toString() {
        return seq;
    }
    @Override
    public int length() {
        return seq.length();
    }

    @Override
    public char charAt(int index) {
        return seq.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return seq.subSequence(start, end);
    }
}
// END
