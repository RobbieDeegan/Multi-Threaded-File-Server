package ie.gmit.sw.client.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLParser {
	private Context ctx;

	public XMLParser(Context ctx) {
		super();
		this.ctx = ctx;
	}
	
	public void init() throws Throwable{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Context.CONFIG_FILE);
		
		Element root = doc.getDocumentElement(); 
		NodeList children = root.getChildNodes(); 
		
		for (int i = 0; i < children.getLength(); i++){ 
			Node next = children.item(i); 
			
			if (next instanceof Element){ 
				Element e = (Element) next; 
				
				if (e.getNodeName().equals("database")){ 
					NamedNodeMap atts = e.getAttributes(); 
					
					for (int j = 0; j < atts.getLength(); j++){ 
						if (atts.item(j).getNodeName().equals("host")){ 
							ctx.setHost(atts.item(j).getNodeValue());
						}else if (atts.item(j).getNodeName().equals("port")){ 
							ctx.setPort(Integer.parseInt(atts.item(j).getNodeValue()));
						}
					}
				}
			}
		}		
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}
}

