package com.bridgelabz.programs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClinicManager {

	Scanner scanner;	//	scanner to get user input
	
	ClinicManager() {
		scanner = new Scanner(System.in);
	}
	
	/** Asks user to choose between doctor and patient **/
	void askUser() {
		System.out.println("Whom do you want to search?");
		System.out.println("1. Doctor");
		System.out.println("2. Patient");
		
		int choice = scanner.nextInt();
		//calls method depending upon user's input
		switch (choice) {
		case 1:
			askDoctorInput();
			break;

		default:
			askPatientInput();
			break;
		}
	}

	/** Gets user's input to search for a doctor **/
	void askDoctorInput() {
		System.out.println("Search doctor by:");
		System.out.println("1. Name");
		System.out.println("2. ID");
		System.out.println("3. Specialization");
		System.out.println("4. Availability");
		int choice = scanner.nextInt();
		doctorChoice(choice);
	}

	/** Gets user's input to search for a patient **/
	void askPatientInput() {
		System.out.println("Search patient by:");
		System.out.println("1. Name");
		System.out.println("2. ID");
		System.out.println("3. Mobile Number");
		int choice = scanner.nextInt();
		patientChoice(choice);
	}

	/** Reads doctor's data from json file **/
	void readDoctorData(String key, String value) {
		JSONParser parser = new JSONParser();	//	parser to read from json file
		try {
			//	adds json data to json array
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Sid/doctors.txt"));
			//	iterator to iterate json data
			Iterator iterator = jsonArray.iterator();
			//	json objects top store json data from array
			JSONObject jsonObject, lastJasonObject = null;
			
			//	iterates over json array
			while (iterator.hasNext()) {
				//	checks if data given by user matches with any json object
				//	and if present prints it
				if ((jsonObject = (JSONObject) iterator.next()).get(key).equals(value)) {
					lastJasonObject = jsonObject;
					System.out.println("\nDoctor Information:");
					System.out.println("ID: " + jsonObject.get("id") + "\t");
					System.out.println("Name: " + jsonObject.get("name") + "\t");
					System.out.println("Specialization: " + jsonObject.get("specialization") + "\t");
					System.out.println("Availability: " + jsonObject.get("availability") + "\t");
					System.out.println("Number of Patients: " + jsonObject.get("patients") + "\n");
				}
			}

			//	asks user if want to take an appointment
			System.out.println("Do you want to take an appointment?[y/n]");
			String response = scanner.next();
			if (response.equals("y")) {
				makeAppointment(lastJasonObject);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	/** Reads patient data from json file **/
	void readPatientData(String key, String value) {
		JSONParser parser = new JSONParser();	//parser to read json file
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Sid/patients.txt"));
			Iterator iterator = jsonArray.iterator();
			JSONObject jsonObject;
			while (iterator.hasNext()) {
				if ((jsonObject = (JSONObject) iterator.next()).containsValue(value)) {
					System.out.println("\nPatient Information:");
					System.out.println("ID: " + jsonObject.get("id") + "\t");
					System.out.println("Name: " + jsonObject.get("name") + "\t");
					System.out.println("Mobile Number: " + jsonObject.get("mobile number") + "\t");
					System.out.println("Age: " + jsonObject.get("age") + "\n");
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	/** Gets user's input according to his choice **/
	void doctorChoice(int choice) {
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.print("Enter name:");
			readDoctorData("name", scanner.nextLine());
			break;
		case 2:
			System.out.print("Enter ID:");
			readDoctorData("id", scanner.next());
			break;
		case 3:
			System.out.print("Enter speacialization:");
			readDoctorData("specialization", scanner.next());
			break;
		case 4:
			System.out.print("Enter availability::");
			readDoctorData("availability", scanner.next());
			break;
		}
	}

	/** Gets user's input according to his choice **/
	void patientChoice(int choice) {
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.print("Enter name:");
			readPatientData("name", scanner.nextLine());
			break;
		case 2:
			System.out.print("Enter ID:");
			readPatientData("id", scanner.next());
			break;
		case 3:
			System.out.print("Enter mobile number:");
			readPatientData("mobile number", scanner.next());
			break;
		}
	}

	/** If doctor is not busy then makes an appointment**/
	void makeAppointment(JSONObject doctorJsonObject) {

		String numberOfPatients = (String) doctorJsonObject.get("patients");
		long patients = Long.parseLong(numberOfPatients);
		if (patients == 5) {	//	doctor is busy 
			System.out.println("Sorry!!! Doctor is busy today. Make an appointment tomorrow.");
		} else {	// doctor is not busy. Increases number of patients and updates json file	
			String id = getRandomId();	//generates random id
			updatePatientData(id);	//	updates patient json file
			numberOfPatients = String.valueOf((patients + 1));
			doctorJsonObject.put("patients", numberOfPatients);
			updateDoctorData(doctorJsonObject);
			System.out.println("You have got an appointment. Your Patient ID is " + id + "\n");
			askUser();
		}

	}

	/** Updates patient's data **/
	void updatePatientData(String id){
		System.out.println("Enter your name, mobile number, age: ");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("name", scanner.next());
		jsonObject.put("mobile number", scanner.next());
		jsonObject.put("age", scanner.next());

		JSONParser parser = new JSONParser();	//parser to read the file
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Sid/patients.txt"));
			jsonArray.add(jsonObject);
			PrintWriter printWriter = null;	//	print writer to write to the file
			File file = new File("/home/bridgeit/Sid/patients.txt");
			try {
				printWriter = new PrintWriter(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printWriter.write(jsonArray.toJSONString());	//writes data to the file
			printWriter.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/** Updates doctor's data **/
	void updateDoctorData(JSONObject doctorJsonObject) {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) parser.parse(new FileReader("/home/bridgeit/Sid/doctors.txt"));

			JSONArray updatedArray = new JSONArray();	// new array with updated elements
			Iterator iterator = jsonArray.iterator();

			//	iterates over array
			while (iterator.hasNext()) {
				JSONObject object = (JSONObject) iterator.next();
				if (object.get("id").equals(doctorJsonObject.get("id"))) {
					updatedArray.add(doctorJsonObject);
				} else {
					updatedArray.add(object);
				}
			}
			PrintWriter printWriter = null;
			File file = new File("/home/bridgeit/Sid/doctors.txt");
			try {
				printWriter = new PrintWriter(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printWriter.write(updatedArray.toJSONString());
			printWriter.close();
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
	}

	/** Generates a random ID for patient **/
	String getRandomId() {
		Random random = new Random();
		return String.valueOf(random.nextInt(1000)+ 1);
	}
}
