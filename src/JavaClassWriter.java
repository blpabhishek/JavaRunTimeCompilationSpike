import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import static javax.tools.ToolProvider.getSystemJavaCompiler;


public class JavaClassWriter {
    public static final void main(String [] args) throws IOException {
        final String className = "HelloWorld";
        final String path = "com.tw.prep";
        final String fullClassName = path.replace('.', '/') + "/" + className;
        final StringBuilder source = new StringBuilder();
        source.append("package " + path + ";\n");
        source.append("import java.util.LinkedList; \n");
        source.append("public class " + className + " {\n");
        source.append(" public String toString() {\n");
        source.append(" LinkedList<String> list = new LinkedList<String>();\n");
        source.append("     return \"HelloWorld \";");
        source.append(" }\n");
        source.append("}\n");

        SimpleJavaFileObject simpleJavaFileObject = new SimpleJavaFileObject(URI.create(fullClassName + ".java"), JavaFileObject.Kind.SOURCE) {
            @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                return source;
            }
        };
        JavaCompiler javaCompiler = getSystemJavaCompiler();
        javaCompiler.getTask(null, null, null, null, null, Collections.singletonList(simpleJavaFileObject)).call();
    }

}