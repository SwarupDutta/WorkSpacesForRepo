package spring.poc.custom.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CustomFreeMarkerConfig{
	
	public String getDirList() {
		return dirList;
	}
	public void setDirList(String dirList) {
		this.dirList = dirList;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	private String dirList;
	private String templateName;
	public Map<String, String> getDataModel() {
		return dataModel;
	}
	public void setDataModel(Map<String, String> dataModel) {
		this.dataModel = dataModel;
	}
	private Map<String,String> dataModel;
	
	private Template createAndGetTemplate() throws IOException
	{
		Configuration configuration =createConfiguration();
		Template template=configuration.getTemplate(getTemplateName());
		return template;
	}
	
	private Configuration createConfiguration() throws IOException
	{
			Configuration configuration= new Configuration();
			configuration.setDefaultEncoding("UTF-8");
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			MultiTemplateLoader mtl=createMultiTemplateLoader();
			configuration.setTemplateLoader(mtl);
			return configuration;
	}
	private MultiTemplateLoader createMultiTemplateLoader() throws IOException {
		// TODO Auto-generated method stub

		String dirList[]=getDirList().split(",");
		List<TemplateLoader>listOfTemplateLoader=new ArrayList<TemplateLoader>();
		for(String templateDir:dirList)
		{
			TemplateLoader ftl = new FileTemplateLoader(new File(templateDir));
			listOfTemplateLoader.add(ftl);

		}

		TemplateLoader[] arrayOfTemplateLoader=new TemplateLoader[] {};
		MultiTemplateLoader mtl = new MultiTemplateLoader(listOfTemplateLoader.toArray(arrayOfTemplateLoader));
		
		
		return mtl;
	}
	
	public  void executeFreeMarker() throws TemplateException, IOException
	{
		Template template=createAndGetTemplate();
		Writer console = new OutputStreamWriter(System.out);
		System.out.println("--Console output for first template--");
		template.process(dataModel, console);
	
	}

}
/*

//configuration.setDirectoryForTemplateLoading(new File("../spring-droo/templatedir1"));

		// TODO Auto-generated method stub
		//FileTemplateLoader ftl1 = new FileTemplateLoader(new File("../spring-droo/templatedir1"));
		//FileTemplateLoader ftl2 = new FileTemplateLoader(new File("../spring-droo/templatedir2"));
		//ClassTemplateLoader ctl = new ClassTemplateLoader(getClass(), "/com/example/templates");
		//MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[] { ftl1, ftl2 });

*/
