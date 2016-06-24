import com.sun.tools.javac.main.JavaCompiler;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.commons.compiler.samples.ClassBodyDemo;
import org.codehaus.commons.compiler.samples.ScriptDemo;
import org.codehaus.commons.compiler.samples.ShippingCost;
import org.codehaus.janino.ScriptEvaluator;

import java.lang.reflect.InvocationTargetException;

public class ScriptEval  {
    public static void main(String[] args) throws CompileException, InvocationTargetException {
        ScriptEvaluator se = new ScriptEvaluator();
        se.cook(" "
                +"for (int i = 0; i < 3; i++) {"
                +"System.out.println(\"Hai\"); }"
        );
        se.evaluate(null);

    }
}
