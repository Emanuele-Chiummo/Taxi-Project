package it.parthenope.taxi.dto;

import it.parthenope.taxi.model.Taxi;

public class EmailDto {
	
	
	private Integer id;
	private String sender;
    private String subject;
    private String body;
    private String state;
    private Taxi taxi;
    
    
    

	
	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getSender() {
		return sender;
	}





	public void setSender(String sender) {
		this.sender = sender;
	}





	public String getSubject() {
		return subject;
	}





	public void setSubject(String subject) {
		this.subject = subject;
	}





	public String getBody() {
		return body;
	}





	public void setBody(String body) {
		this.body = body;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public Taxi getTaxi() {
		return taxi;
	}





	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}





	@Override
    public String toString() {
        return "EmailDto{" +
                "id=" + id +
                ", from='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", state='" + state + '\'' +
                ", taxi=" + taxi +
                '}';
    }
    

    
    
}
