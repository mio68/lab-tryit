package mio68.lab.tryit.Strings;

public class StripAndTrim {

    public static void main(String[] args) {
        String s = "\u2001\tHello!\t\u2001";
        System.out.printf("original:[%s]%n",s);

        System.out.printf("strip:[%s]%n",s.strip());
        System.out.printf("trim:[%s]%n",s.trim());
        System.out.printf("strip leading:[%s]%n",s.stripLeading());
        System.out.printf("strip trailing:[%s]%n",s.stripTrailing());

    }

}
