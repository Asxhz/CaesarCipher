import java.util.Scanner;
import java.util.Random;

class CaesarCipher {
  char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
      'u', 'v', 'w', 'x', 'y', 'z' };

  public void encrypt(String sentence, int change) {
    sentence = sentence.toLowerCase();
    String ciphered = "";
    String[] sentenceArray = sentence.split("\\s+");
    for (String word : sentenceArray) {
      for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);
        for (int j = 0; j < letters.length; j++) {
          if (letter == letters[j]) {
            int index = j + change;
            if (index > letters.length - 1) {
              index = index - letters.length;
            }
            ciphered += letters[index];
          }
        }
      }
      ciphered += " ";
    }
    System.out.println(ciphered);
    System.out.println(change);
  }
  public void decrypt(String sentence, int change) {
    sentence = sentence.toLowerCase();
    String ciphered = "";
    String[] sentenceArray = sentence.split("\\s+");
    for (String word : sentenceArray) {
      for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);
        for (int j = 0; j < letters.length; j++) {
          if (letter == letters[j]) {
            int index = j - change;
            if (index < 0) {
                index = letters.length + index;
            }
            if (index > letters.length - 1) {
                index = index - letters.length;
            }
            if (index > letters.length - 1) {
              index = index - letters.length;
            }
            ciphered += letters[index];
          }
        }
      }
      ciphered += " ";
    }
    System.out.println(ciphered);
    System.out.println(change);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Would you like to encrypt or decrypt (e/d)?: ");
    String choice = scanner.nextLine();
    System.out.println("Enter the sentence: ");
    String sentence = scanner.nextLine();
    System.out.println("How much shift +1 = (a->b), type 0 for random: ");
    int change = scanner.nextInt();

    CaesarCipher cipher = new CaesarCipher();
    if(choice.equals("e")){
      if (change == 0){
        int rand = (int)(Math.random() * 26);
        change = rand;
      } 
      cipher.encrypt(sentence, change);
    }
    else if(choice.equals("d")){
      if (change == 0){
        int rand = (int)(Math.random() * 26);
        change = rand;
      } 
      cipher.decrypt(sentence, change);
    }


  }
}