import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

public class NewClass {
    public static void main(String[] args) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, "data/MyCommand.java");

        if(compilationResult == 0) {
            byte[] bytes = Files.readAllBytes(Paths.get("data/MyCommand.class"));
            FileOutputStream fout = new FileOutputStream("data/foo.jar");
            JarOutputStream jarOut = new JarOutputStream(fout);
            jarOut.putNextEntry(new ZipEntry("com/foo/"));
            jarOut.putNextEntry(new ZipEntry("com/foo/MyCommand.class"));
            jarOut.write(bytes);
            jarOut.closeEntry();
            jarOut.close();
            fout.close();
        }
    }
}
