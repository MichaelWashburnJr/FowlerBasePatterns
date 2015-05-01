import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;

/**
 * Mapper.java connects to an XML document containing
 * information about pet objects. Pet objects themselves
 * do not know how to read/update/delete from the XML document
 * so the mapper is used
 */
public class Mapper {
	private String filepath = "Pets.xml";

	/**
	 * Search the XML document by name and return a pet object if the name is found
	 * @param petName - the name to search XML for 
	 * @return A pet object or null
	 */
	public Pet getPetByName(String petName){
		try {
			// open a XML document and create an xpath
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();		
			Document doc = builder.parse(filepath);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			
			// get the node with the correct pet name
			XPathExpression expr = xpath.compile("/pets/pet[@name='" + petName + "']/type/text()");
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			
			if (nodes.getLength() == 0){
				return null;
			}
			
			/*
			 * The following blocks get the traits of a pet in the xml document
			 */
			String type = expr.evaluate(doc, XPathConstants.STRING).toString();
			
			expr = xpath.compile("/pets/pet[@name='" + petName + "']/weight/text()");
			Float weight = Float.parseFloat(expr.evaluate(doc, XPathConstants.STRING).toString());
			
			expr = xpath.compile("/pets/pet[@name='" + petName + "']/age/text()");	
			int age = Integer.parseInt(expr.evaluate(doc, XPathConstants.STRING).toString());
	        
			expr = xpath.compile("/pets/pet[@name='" + petName + "']/friendly/text()");	
			boolean friendly = Boolean.parseBoolean(expr.evaluate(doc, XPathConstants.STRING).toString());
			
			// return a pet object with the found traits from above
			return new Pet(petName,type,weight,age,friendly);
	       
		
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * A method to update the xml record given a pet object.
	 * It cannot update the name of a pet, because it depends on the name to
	 * find the xml node. 
	 * @param pet
	 */
	public void updatePetRecords(Pet pet){
		
		String petName = pet.getName();
		try {
			// open a XML document and create an xpath
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();		
			Document doc = builder.parse(filepath);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			
			/*
			 * The following blocks get the current value of a pet's trait in the xml document
			 * and then set it to the value of the passed pet object
			 */
			XPathExpression expr = xpath.compile("/pets/pet[@name='" + petName + "']/type/text()");
			Node node = ((NodeList) expr.evaluate(doc, XPathConstants.NODESET)).item(0);
			node.setTextContent(pet.getType());
			
			expr = xpath.compile("/pets/pet[@name='" + petName + "']/weight/text()");
			node = ((NodeList) expr.evaluate(doc, XPathConstants.NODESET)).item(0);
			node.setTextContent(Float.toString(pet.getWeight()));
			
			expr = xpath.compile("/pets/pet[@name='" + petName + "']/age/text()");
			node = ((NodeList) expr.evaluate(doc, XPathConstants.NODESET)).item(0);
			node.setTextContent(Integer.toString(pet.getAge()));
			
			expr = xpath.compile("/pets/pet[@name='" + petName + "']/friendly/text()");
			node = ((NodeList) expr.evaluate(doc, XPathConstants.NODESET)).item(0);
			node.setTextContent(Boolean.toString(pet.isFriendly()));
			
			// save the result
		    Transformer xformer = TransformerFactory.newInstance().newTransformer();
		    xformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    xformer.setOutputProperty(OutputKeys.INDENT, "yes");
			xformer.transform(new DOMSource(doc), new StreamResult(new File(filepath)));
			
		
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
			
		return;
	}
	
	/**
	 * Add a pet object to the xml document
	 * @param pet
	 */
	public void addPet(Pet pet){
		
		try{
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance(); 
			domFactory.setIgnoringComments(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder(); 
			Document doc = builder.parse(new File(filepath)); 
	
			NodeList nodes = doc.getElementsByTagName("pet");
	
			/*
			 * The following blocks add tags and their values based on the pet objects values
			 */
			Element topNode = doc.createElement("pet"); 
			topNode.setAttribute("name", pet.getName());
			
			Text typeValue = doc.createTextNode(pet.getType()); 
			Element typeNode = doc.createElement("type");
			typeNode.appendChild(typeValue);
			topNode.appendChild(typeNode); 
			
			Text weightValue = doc.createTextNode(Float.toString(pet.getWeight())); 
			Element weightNode = doc.createElement("weight");
			weightNode.appendChild(weightValue);
			topNode.appendChild(weightNode); 
			
			Text ageValue = doc.createTextNode(Integer.toString(pet.getAge())); 
			Element ageNode = doc.createElement("age");
			ageNode.appendChild(ageValue);
			topNode.appendChild(ageNode); 
			
			Text friendlyValue = doc.createTextNode(Boolean.toString(pet.isFriendly())); 
			Element friendlyNode = doc.createElement("friendly");
			friendlyNode.appendChild(friendlyValue);
			topNode.appendChild(friendlyNode); 
				
			// add the top node
			nodes.item(0).getParentNode().insertBefore(topNode, nodes.item(0));
			
			// save the result
		    Transformer xformer = TransformerFactory.newInstance().newTransformer();
		    xformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    xformer.setOutputProperty(OutputKeys.INDENT, "yes");
			xformer.transform(new DOMSource(doc), new StreamResult(new File(filepath)));
		
		} catch (IOException e){
			e.printStackTrace();
		} catch (SAXException e){
			e.printStackTrace();
		} catch (ParserConfigurationException e){
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) { 
			e.printStackTrace();
		}
		
	}
	/**
	 * Given a pet object, remove that pet from the xml document
	 * @param pet
	 */
	public void deletePet(Pet pet){
		try{
			// open a XML document and create an xpath
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();		
			Document doc = builder.parse(filepath);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			
			// get the node with the correct pet name
			XPathExpression expr = xpath.compile("/pets/pet[@name='" + pet.getName() + "']");
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			
			// delete the node
			if (nodes.getLength() > 0){
				nodes.item(0).getParentNode().removeChild(nodes.item(0));
			}
			
			// clean up white space left from delete
			XPath xp = XPathFactory.newInstance().newXPath();
			NodeList nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", doc, XPathConstants.NODESET);

			// clean up white space left from delete
			for (int i=0; i < nl.getLength(); ++i) {
			    Node node = nl.item(i);
			    node.getParentNode().removeChild(node);
			}
			// save the result
		    Transformer xformer = TransformerFactory.newInstance().newTransformer();
		    xformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    xformer.setOutputProperty(OutputKeys.INDENT, "yes");
			xformer.transform(new DOMSource(doc), new StreamResult(new File(filepath)));
			
			
		
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
