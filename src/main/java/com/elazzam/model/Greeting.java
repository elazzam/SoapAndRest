package com.elazzam.model;

//used by rest ws. for soap is generated automaticaly from wsdl or xsd
/*
 * Spring uses the Jackson JSON library to automatically marshal instances of type Greeting into JSON.
 * {
    "id": 1,
    "content": "Hello, World!"
	}
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
