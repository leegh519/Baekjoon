import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        String patternString = "<[[a-z]?[0-9]?\\s?]*>|\\w+|\\s+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String s = matcher.group();
            if (s.charAt(0) == '<') {
                sb.append(s);
            } else {
                for (int i = s.length() - 1; i >= 0; i--) {
                    sb.append(s.charAt(i));
                }
            }

        }
        System.out.println(sb);
    }

}
