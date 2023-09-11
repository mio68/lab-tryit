package mio68.lab.tryit.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exs {

    public static void main(String[] args) {
        try {
            dangerous();
        }
        catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        catch (RuntimeException e) {

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dangerous() throws RuntimeException,
            FileNotFoundException,
            Exception,
            IOException {

    }
}
