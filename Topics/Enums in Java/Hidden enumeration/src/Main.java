public class Main {

    public static void main(String[] args) {

        int count=0;
        for (Secret s:
             Secret.values()) {
            if (s.name().indexOf("STAR") != -1) {
                count++;
            }

        }
        System.out.println(count);

    }
}

/*
enum Secret {
    STAR, CRASH, START, STAROPRAMEN
}

 */

