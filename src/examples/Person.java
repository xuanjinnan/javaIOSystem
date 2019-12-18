package examples;

import nu.xom.Element;

public class Person {
	private String first,last;
	public Person(String fiirst, String last) {
		super();
		this.first = fiirst;
		this.last = last;
	}
	// Produce an XML Element form this Person Object:
	public Element getXML() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		person.appendChild(firstName);
		person.appendChild(lastName);
		return person;
	}
	//Constructor to restore a person from an XML Element
	public Person(Element person) {
		first = person.getFirstChildElement("first").getValue();
		last = person.getFirstChildElement("last").getValue();
	}
	public String toString() {
		return first + " " + last;
	}
	//Make it human-0readalbe
}
