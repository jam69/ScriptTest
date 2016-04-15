/*
 *  Copyright &copy; Indra 2016
 */
package com.jam69.scripttest;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler;
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jamartinm
 */
public class Main
{

    private static final Logger log = LoggerFactory.getLogger("TextJEXLS");

    private ScriptEngineManager factory = new ScriptEngineManager();

    private static final int n = 100000; // numero de pruebas

    public static void main(String[] args) throws Exception
    {
        log.debug("Hola");

        Main m = new Main();
//        m.testJS();
//        m.testJEXL();
      //  m.testScript("JS", "script103.js");
     //   m.testScript("JEXL", "script103.jexl");
  //      m.testJava();
        m.testJavaCompiler("TestCompiler.java");
        m.testJava();
//        m.testJavaCompiler("TestCompiler.java");
//        m.testJavaCompiler("TestCompiler.java");
//          m.testJava();
//        m.testJavaCompiler("TestCompiler.java");
//        m.testJava();
//        m.testJavaCompiler("TestCompiler.java");
//        m.testJavaCompiler("TestCompiler.java");
//          m.testJava();
//        m.testJavaCompiler("TestCompiler.java");
//        m.testJava();
//        m.testJavaCompiler("TestCompiler.java");
//        m.testJavaCompiler("TestCompiler.java");

        //m.testJXLS();
    }

    private List<ResultBean> generateBigSample(int n) throws IOException
    {
        List<ResultBean> ret = new ArrayList<>();
        List<ResultBean> aux = generateSample();
        for (int i = 0; i < n; i++)
        {
            ret.addAll(aux);
        }
        return ret;
    }

    private List<ResultBean> generateSample() throws IOException
    {
        JsonFactory f = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper();
        JsonParser jp = f.createJsonParser(new File("ResultBean.json"));
        jp.nextToken();
        List<ResultBean> ret = new ArrayList<>();
        while (jp.nextToken() == JsonToken.START_OBJECT)
        {
            ResultBean r = mapper.readValue(jp, ResultBean.class);
            ret.add(r);
        }
        return ret;

    }

 

    public void testJS() throws ScriptException
    {
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("print('Hello, World')");
    }

    public void testJEXL() throws ScriptException
    {
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JEXL");
        engine.put("log", log);
        engine.put("r", new ResultBean());
        // evaluate JavaScript code from String
        engine.eval("log.info('Hello, World');r.agencyTxt='kk';log.info('r='+r.agencyTxt); ");
    }

    public void testJava() throws IOException
    {
        List<ResultBean> all = generateBigSample(n);
        long t = System.currentTimeMillis();
        Xx x = new Xx();
        x.setCompInfo(new CompInfo());
        x.setKmInfo(new KmInfo());
        int sum = 0;
        for (ResultBean r : all)
        {
            x.doIt(r);
            sum += r.getBalance();
        }
        log.info("Java tarda:" + (System.currentTimeMillis() - t) + " ms");
        log.info("Balance sum=" + sum);

    }

    public void testScript(String language, String fileName) throws ScriptException, FileNotFoundException, IOException
    {

        log.info("Starting");
        List<ResultBean> all = generateBigSample(n);
        long t = System.currentTimeMillis();

        ScriptEngine engine = factory.getEngineByName(language);
        log.info("Engine found:" + engine.toString());

            //Reader reader = new FileReader("script103.js");
        String script = String.join("\n", Files.readAllLines(Paths.get(fileName)));

        engine.put("log", log);
        engine.put("compInfo", new CompInfo());
        engine.put("kmInfo", new KmInfo());
        engine.put("kmInfoTh", new KmInfo());
        engine.put("kmReal", new KmInfo());

        //engine.eval(reader);
        engine.eval(script);
        int sum = 0;
        for (ResultBean r : all)
        {

            engine.put("v", r);
            engine.eval("doIt()");
            sum += r.getBalance();
        }
        log.info("Compiled tarda:" + (System.currentTimeMillis() - t) + " ms");
        log.info("Balance sum=" + sum);

    }

    public void testJavaCompiler(String fileName) throws ScriptException, FileNotFoundException, IOException
    {
        try{
        log.info("Starting");
        List<ResultBean> all = generateBigSample(n);
        //long t = System.currentTimeMillis();

         long t = System.currentTimeMillis();

        String source = String.join("\n", Files.readAllLines(Paths.get(fileName)));

        String className="com.jam69.scripttest.TestCompiler";
        JavaSourceCompiler javaSourceCompiler = new JavaSourceCompilerImpl();
        JavaSourceCompiler.CompilationUnit compilationUnit = javaSourceCompiler.createCompilationUnit();
        //compilationUnit.addClassPathEntry("C:/tools/WildFly-Eclipse/wildfly-8.2.0.Final/bin/content/gsi.ear/compensation-web.war/WEB-INF/lib/compensation-beans-1.0.0-SNAPSHOT.jar");
        compilationUnit.addJavaSource(className, source);
        ClassLoader classLoader = javaSourceCompiler.compile(compilationUnit);
        

        log.info("Compilar tarda:" + (System.currentTimeMillis() - t) + " ms");
         t = System.currentTimeMillis();

        Class processorClass = classLoader.loadClass(className);
        Test1  processorInstance= (Test1)processorClass.newInstance();
        processorInstance.setCompInfo(new CompInfo());
        processorInstance.setKmInfo(new KmInfo());
        log.info("Compiled and Ready:" );
         int sum = 0;
        for (ResultBean r : all)
        {
         //   log.info("Input"+r);
            processorInstance.doIt(r);
            sum += r.getBalance();
         //   log.info("Output"+r);
        }
        log.info("Compiled tarda:" + (System.currentTimeMillis() - t) + " ms");
        log.info("Balance sum=" + sum);

    }
    catch ( Exception e)
     {
     System.out.println("Error:" + e);
        e.printStackTrace();
    }
    }

//   public void test(){    // JEXL 3.0
//         // Create or retrieve an engine
//    JexlEngine jexl = new JexlBuilder().create();
//
//    // Create an expression
//    String jexlExp = "foo.innerFoo.bar()";
//    JexlExpression e = jexl.createExpression( jexlExp );
//
//    // Create a context and add data
//    JexlContext jc = new MapContext();
//    jc.set("foo", new Foo() );
//
//    // Now evaluate the expression, getting the result
//    Object o = e.evaluate(jc);  // Create or retrieve an engine
//    JexlEngine jexl = new JexlBuilder().create();
//
//    // Create an expression
//    String jexlExp = "foo.innerFoo.bar()";
//    JexlExpression e = jexl.createExpression( jexlExp );
//
//    // Create a context and add data
//    JexlContext jc = new MapContext();
//    jc.set("foo", new Foo() );
//
//    // Now evaluate the expression, getting the result
//    Object o = e.evaluate(jc);
//   }
}
