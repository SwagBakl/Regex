package Content;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        fetchFindString();
        fetchFindingSymbols();
        fetchEmailPhoneIp();

    }

    private static void fetchFindString(){

        String text = "<User> is located in <city>";
        Pattern pattern = Pattern.compile("<.+>");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }


    }

    private static void fetchFindingSymbols(){

        String text = "Hey i'm here from 9 A.M.";
        Pattern pattern = Pattern.compile("\\W$");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }

    private static void fetchEmailPhoneIp(){
        String text = "Hey my email: den@gmail.com, my phone number is 678-22-12 and of course my ip is 192.168.1.1";
        Pattern email = Pattern.compile("[^\\s]+@[^\\s\\.]+\\.[a-z]+");
        Pattern phone = Pattern.compile("((\\+?7|8)[ \\-] ?)?((\\(\\d{3}\\))|(\\d{3}))?([ \\-])?(\\d{3}[\\- ]?\\d{2}[\\- ]?\\d{2})");
        Pattern ip = Pattern.compile("\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
        Matcher emailMatcher = email.matcher(text);
        Matcher phoneMatcher = phone.matcher(text);
        Matcher ipMatcher = ip.matcher(text);
        while (emailMatcher.find()){
            System.out.println(text.substring(emailMatcher.start(), emailMatcher.end()));
        }

        while (phoneMatcher.find()){
            System.out.println(text.substring(phoneMatcher.start(), phoneMatcher.end()));
        }

        while (ipMatcher.find()){
            System.out.println(text.substring(ipMatcher.start(), ipMatcher.end()));
        }
    }

}
