package mio68.lab.tryit.mix;

public class MultilineStrings {

    public static void main(String[] args) {
        String html = """
                <html>
                    <head>
                        <title>This is simple HTML page</html>
                    </head>
                    <body>
                        <h2>This is header 2</h2>
                        <p>Put any text right here.</p>
                    </body>
                </html>
                """;

        System.out.println(String.format("[%s]",html));
    }
}
