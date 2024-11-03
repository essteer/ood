package ood2.io.jj;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//id, stream and its getters and setters not included in de/serialization
@JsonIgnoreProperties({"id","stream"}) //ignore more than 1 properties

public class Trainee {
	@JsonIgnore //only id
	private int id;
	private String name;
	private Academy academy;
	private String email;
	private String stream;
	private List<String> skillset;
	private boolean signOff;
	private Map<String, String> trainingPeriod;
	

	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonCreator //consider this constructor for de/serialization
	public Trainee (@JsonProperty("id") int id, @JsonProperty("traineeName") String name, @JsonProperty("academyAddress") Academy academy, @JsonProperty("email") String email, @JsonProperty("stream") String stream, @JsonProperty("skillSet") List<String> skillset,
			@JsonProperty ("signedOff")boolean signOff, @JsonProperty("duration") Map<String, String> trainingPeriod) {
		super();
		this.id = id;
		this.name = name;
		this.academy = academy;
		this.email = email;
		this.stream = stream;
		this.skillset = skillset;
		this.signOff = signOff;
		this.trainingPeriod = trainingPeriod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	@JsonProperty("skillSet")
	public List<String> getSkillset() {
		return skillset;
	}

	public void setSkillset(List<String> skillset) {
		this.skillset = skillset;
	}

	public boolean isSignOff() {
		return signOff;
	}

	public void setSignOff(boolean signOff) {
		this.signOff = signOff;
	}

	public Map<String, String> getTrainingPeriod() {
		return trainingPeriod;
	}

	public void setTrainingPeriod(Map<String, String> trainingPeriod) {
		this.trainingPeriod = trainingPeriod;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", academy=" + academy + ", email=" + email + ", stream="
				+ stream + ", skillset=" + skillset + ", signOff=" + signOff + ", trainingPeriod=" + trainingPeriod
				+ "]";
	}

}
