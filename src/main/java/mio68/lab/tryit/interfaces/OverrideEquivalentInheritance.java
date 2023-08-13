package mio68.lab.tryit.interfaces;


import java.io.IOException;
import java.sql.SQLException;

interface I {
    void m() throws SQLException;
}

interface J {
    void m() throws IOException, SQLException;
}

// It's just OK!
interface K extends I, J {

}

public class OverrideEquivalentInheritance implements K {
    @Override
    public void m() throws SQLException {
        System.out.println("Cool!");
    }
}
