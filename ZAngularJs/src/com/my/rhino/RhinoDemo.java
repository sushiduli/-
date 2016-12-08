package com.my.rhino;

import java.io.FileReader;
import java.util.List;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RhinoDemo {

	public static void main(String[] args) {
		// create ScriptEngineManager
		ScriptEngineManager manager = new ScriptEngineManager();
		// create a JavaScript engine 
		ScriptEngine engine = manager.getEngineByName("js");
		String script = "print ('hello nm')";
		try {
			engine.eval(script);
			System.out.println();
		} catch (ScriptException e) {
			e.printStackTrace();
		}

		try {
			Double hour = (Double) engine.eval("var date = new Date(); date.getHours();");
			System.out.println(hour);
		} catch (ScriptException e) {
			System.err.println(e);
		}

		try {
			FileReader reader = new FileReader("src/com/my/rhino/file.js");
			Double num = (Double) engine.eval(reader);
			System.out.println(num);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			engine.put("a", 1);
			engine.put("b", 5);

			Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
			Object a = bindings.get("a");
			Object b = bindings.get("b");
			System.out.println("a = " + a);
			System.out.println("b = " + b);

			FileReader reader = new FileReader("src/com/my/rhino/vars.js");
			Double num = (Double) engine.eval(reader);
			System.out.println(num);
			reader.close();

			reader = new FileReader("src/com/my/rhino/fun.js");
			// engine.eval("function add (a, b) {c = a + b; return c; }");
			engine.eval(reader);
			Invocable jsInvoke = (Invocable) engine;

			Object result1 = jsInvoke.invokeFunction("add", new Object[] { 10, 5 });
			System.out.println(result1);

			Adder adder = jsInvoke.getInterface(Adder.class);
			int result2 = adder.add(10, 5);
			System.out.println(result2);

			Compilable jsCompile = (Compilable) engine;
			CompiledScript vscript = jsCompile.compile("function hi () {print ('ddddd !'); }; hi ();");

			for (int i = 0; i < 5; i++) {
				vscript.eval();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			FileReader reader = new FileReader("src/com/my/rhino/java.js");
			@SuppressWarnings("unchecked")
			List<String> num = (List<String>) engine.eval(reader);
			System.out.println(); 
			for (String word : num) {
				System.out.print(word);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ScriptEngineFactory> factoryList = manager.getEngineFactories();
		for (ScriptEngineFactory factory : factoryList) {
			System.out.println("=====");
			System.out.println(factory.getEngineName());
			System.out.println(factory.getEngineVersion());
			System.out.println(factory.getLanguageName());
			System.out.println(factory.getLanguageVersion());
			System.out.println(factory.getExtensions());
			System.out.println(factory.getMimeTypes());
			System.out.println(factory.getNames());
		}
	}
}
