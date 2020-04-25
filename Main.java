import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {

    private static int calcNumEdits(String a, String b) {
        if (a.length() != b.length() || a.length() == 0) {
            return -1;
        }

        //sort the words alphabetically
        char[] array = a.toCharArray();
        Arrays.sort(array);
        a = new String(array);

        array = b.toCharArray();
        Arrays.sort(array);
        b = new String(array);

        int diff = 0;
        int bPos = 0;

        for (int aPos = 0; aPos < a.length(); aPos++) {

            if (a.charAt(aPos) == b.charAt(bPos)) {
                bPos++;
            } else {
                char aLetter = a.charAt(aPos);
                boolean matchFound = false;

                for (int i = bPos + 1; i < b.length() && !matchFound; i++) {
                    char bLetter = b.charAt(i);

                    if (aLetter == bLetter) {
                        StringBuilder builder = new StringBuilder(b);
                        //move bLetter up to bPos, shift others down
                        builder.deleteCharAt(i);
                        builder.insert(bPos, bLetter);
                        b = builder.toString();
                        bPos++;
                        matchFound = true;
                    }

                }

                if (!matchFound) {
                    diff++;
                }

            }

        }

        return diff;
    }

    private static Character getFirstRecurringChar(String s) {
        HashSet<Character> alreadySeen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (alreadySeen.contains(c)) {
                return c;
            }

            alreadySeen.add(c);
        }
        return null;
    }

    private static int calculateMaxFloorWhereEggIntact(int numFloors) {
        Random r = new Random();
        int rand = r.nextInt(numFloors);
        int partition = (int)Math.sqrt(numFloors);
        for (int i = 1; i <= partition; i++) {
            if (i >= rand) {

            }
        }
        return 0;
    }

    private static int calculateOneEgg(int start, int end, int x) {
        for (int i = start; i <= end; i++) {
            if (i == x) {
                return i;
            }
        }
        return 0;
    }

    private static int numMovesForBishop(int src, int dest) {
        int x1 = src % 8;
        int y1 = src / 8;
        int x2 = dest % 8;
        int y2 = dest / 8;
        if ((x1 + y1) % 2 != (x2 + y2) % 2) {
            return -1;
        }
        int slope = (y2 - y1) / (x2 - x1);
        if (Math.abs(slope) == 1) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        String a = "nate";
        String b = "nb";

        System.out.println("Num diff: " + calcNumEdits(a, b));
        System.out.println(getFirstRecurringChar(b));


    }

}
