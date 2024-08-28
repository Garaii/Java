/**
 * Your name here:
 * Your McGill ID here:
 **/
package assignment2;
public class SolitaireCipher {
    public Deck key;

    public SolitaireCipher (Deck key) {
        this.key = new Deck(key); // deep copy of the deck
    }

    /*
     * TODO: Generates a keystream of the given size
     */
    public int[] getKeystream(int size) {
        /**** ADD CODE HERE ****/
        int[] keyStream = new int[size];

        for (int i = 0; i< size; i++){
        keyStream[i] = key.generateNextKeystreamValue();
        }
        return keyStream;
    }

    /*
     * TODO: Encodes the input message using the algorithm described in the pdf.
     */
    public String encode(String msg) {
        /**** ADD CODE HERE ****/
        msg = msg.replaceAll("[^a-zA-Z]", "");
        msg = msg.toUpperCase();

        String encoded = "";
        int [] keyStream = getKeystream(msg.length());

        for (int i = 0; i < msg.length(); i++) {
            int letter = msg.charAt(i) - 'A';
            int keyStreamValue = keyStream[i];
            int encodedLetter = (letter + keyStreamValue ) % 26;
            encoded += (char) (encodedLetter + 'A');
        }
        return encoded;
    }

    /*
     * TODO: Decodes the input message using the algorithm described in the pdf.
     */
    public String decode(String msg) {
        /**** ADD CODE HERE ****/
        int[] keyStream = getKeystream(msg.length());
        String decoded = "";

        for (int i = 0; i < msg.length(); i++) {
            int letter = msg.charAt(i) + 'A';
            int keyStreamValue = keyStream[i];
            int decodedLetter = (letter - keyStreamValue + 26) % 26;
            decoded += (char) (decodedLetter + 'A');
        }
        return decoded;
    }



}
