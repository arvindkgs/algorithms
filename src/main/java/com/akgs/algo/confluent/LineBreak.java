import java.util.HashSet;

class Scratch {
    public static void main(String[] args) {
        //Line Break at 18 characters
        System.out.println("Test case 1: Split at 18");
        lineBreak("123456789012345678 123456789012345678");
        System.out.println("Test case 2: Split at 18 with whitespace");
        lineBreak("123456789012345678     123456789012345678");
        System.out.println("Test case 3: Split at 18 with whitespace at start");
        lineBreak("   123456789012345678     123456789012345678");
        System.out.println("Test case 4: Split at 18 with whitespace at end");
        lineBreak("123456789012345678     123456789012345678    ");
        System.out.println("Test case 5: Split at 18 with only whitespace");
        lineBreak("   ");
        System.out.println("Test case 6: Split at 18 with no whitespace");
        lineBreak("123456789012345678");
        System.out.println("Test case 7: Split at 18 with no whitespace");
        lineBreak("123456789012345678");
        String paragraph = "  Thrown to indicate that an index of some sort (such as to an array, to a" +
                " * string, or to a vector) is out of range. Test whether this paragraph is split into multiple lines. Each line should have only eighteen characters if ending in whitespace else ends at next whitespace";
        //lineBreak(paragraph);
    }
    
    //find . -regex "*.java" -exec grep -iHn 'pattern' '{}' \;

    private static void lineBreak(String paragraph) {
        int char_count = 0;
        HashSet<Character> whitespaces = new HashSet<>();
        whitespaces.add(' ');
        whitespaces.add('\n');
        whitespaces.add('.');
        whitespaces.add(',');
        int strt = 0;
        int i=0;
        while(i< paragraph.length()){
            char c = paragraph.charAt(i);
            if(char_count >= 18 && whitespaces.contains(c)){
                System.out.println(paragraph.substring(strt, i+1));
                char_count = 0;
                strt = i + 1;
                while(strt < paragraph.length() && whitespaces.contains(paragraph.charAt(strt))){
                    strt++;
                }
                i = strt - 1;
            }
            i++;
            char_count++;
        }
        if(strt < paragraph.length()){
            System.out.println(paragraph.substring(strt, paragraph.length()));
        }
    }
}