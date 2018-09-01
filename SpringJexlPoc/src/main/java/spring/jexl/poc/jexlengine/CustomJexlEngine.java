package spring.jexl.poc.jexlengine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.commons.jexl2.Script;

import spring.jexl.poc.params.ParamClass;

public class CustomJexlEngine {
	

	private JexlEngine jexlEngine;
	
	private File scriptFile;
	private Map<String,Object> jexlContextMap;
	
	public void evaluateExpression()
	{
		JexlContext jexlContext= new MapContext(jexlContextMap);
		

		Expression jexlEpression=jexlEngine.createExpression("X=ObjectOne.getN()+ObjectTwo.getN()");
		jexlEpression.evaluate(jexlContext);
		System.out.println(jexlContextMap.get("X"));
	}
	public void executeScript() throws IOException
	{
		JexlContext jexlContext= new MapContext(jexlContextMap);

		Script script=jexlEngine.createScript(scriptFile);
		script.execute(jexlContext);
		System.out.println(jexlContextMap.get("X1"));

	}
	public void executeScriptForEach() throws IOException
	{
		List<ParamClass> listOfParamClass=new ArrayList<ParamClass>();
		ParamClass paramClassOne=new ParamClass();
		paramClassOne.setN(10);
		ParamClass paramClassTwo=new ParamClass();
		paramClassTwo.setN(20);
		ParamClass paramClassThree=new ParamClass();
		paramClassThree.setN(30);

		listOfParamClass.add(paramClassOne);
		listOfParamClass.add(paramClassTwo);
		listOfParamClass.add(paramClassThree);


		jexlContextMap.put("listOfObjects",listOfParamClass);
		JexlContext jexlContext= new MapContext(jexlContextMap);

		Script script=jexlEngine.createScript(scriptFile);
		script.execute(jexlContext);
		System.out.println(jexlContextMap.get("sum"));

	}
	
	public JexlEngine getJexlEngine() {
		return jexlEngine;
	}
	public void setJexlEngine(JexlEngine jexlEngine) {
		this.jexlEngine = jexlEngine;
	}
	public File getScriptFile() {
		return scriptFile;
	}
	public void setScriptFile(File scriptFile) {
		this.scriptFile = scriptFile;
	}
	public Map<String, Object> getJexlContextMap() {
		return jexlContextMap;
	}
	public void setJexlContextMap(Map<String, Object> jexlContextMap) {
		this.jexlContextMap = jexlContextMap;
	}

}
