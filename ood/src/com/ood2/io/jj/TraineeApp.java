package com.ood2.io.jj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TraineeApp {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		
		Academy academy=new Academy("Beach Tower","Esplanade","City","773673");
		
		List<String> skills=new ArrayList<>();
		skills.add("Java");
		skills.add("HTML");
		skills.add("CSS");
		
		
		Map<String,String> trainingPeriod=new HashMap<String,String>();
		trainingPeriod.put("13Sept2021", "03Dec2021");
		
		Trainee trainee=new Trainee(111,"John Doe",academy,"jd@jd.com","Java",skills,false, trainingPeriod);
		System.out.println("Trainee object: "+trainee);
		File jsonFile=new File("trainee.json");
		mapper.writeValue(jsonFile, trainee);
		
		
		String jsonTrainee=mapper.writeValueAsString(trainee);
		System.out.println("Json Trainee: "+jsonTrainee);
		//DeSerialization
		Trainee deSerializedTrainee=mapper.readValue(jsonFile, Trainee.class);
		System.out.println("DeSerialized Trainee: "+deSerializedTrainee);
		
		// read specific data from json
		JsonNode root=mapper.readTree(jsonFile);
		JsonNode skillNode=root.path("skillSet");
		Iterator<JsonNode> elements=skillNode.elements();
		while(elements.hasNext()) {
			System.out.println(elements.next());
		}
		
		Map<String, Object> ds=mapper.readValue(jsonFile, HashMap.class);
		System.out.println(ds);

	}

}
