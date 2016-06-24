import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import com.sun.tools.javac.api.JavacTool;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.*;
import org.codehaus.janino.JavaSourceClassLoader;
public class MainClass implements Serializable {
    public static void main(String[] args) throws Exception {
        MainClass mainClass = new MainClass();
        mainClass.execute();
    }

    private void execute() throws Exception {
        File janinoSourceDirs = new File("data");
        File[] srcDirs = new File[]{janinoSourceDirs};
        String encoding = null;
        ClassLoader parentClassLoader = getClass().getClassLoader();
        ClassLoader cl = new JavaSourceClassLoader(parentClassLoader, srcDirs, encoding);
        Command command = (Command)cl.loadClass("MyCommand").newInstance();
        command.execute();
    }

}