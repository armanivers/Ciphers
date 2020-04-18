package ciphers;

import java.util.HashMap;
import java.util.Map;

public class CipherCaeser {
	
	//HashMap
	private Map<Character, Integer> alphabet;
	
	//Ecnryption Array
	private final static char encryptionArr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public CipherCaeser() {
		
		//Create HashMap
		alphabet = new HashMap<Character, Integer>();
		
		//Fill the HashMap
		for(int i = 0; i<26 ; i++) {
			alphabet.put(encryptionArr[i], i);
		}
	}

	
	public int generateEncryptionKey() {
		return 1;//(int) Math.random()*25;
	}
	
	/* Encrypt given text
	 * with the given shift value (encryptionKey)
	 * using the formula newValue = (VurrentValue+Shift Value) % 26
	 * returns encrypted text or null if an error occured (invalid key/empty text)
	 */
	public String encrypt(String rawText,int encryptionKey) {
		
		//check if text and key is valid
		if(encryptionKey < 0 || encryptionKey >25 || rawText.length()<=0) {
			return null;
		}
		
		//convert input to uppercase letters, because of the hashmap
		rawText = rawText.toUpperCase();
		//remove all non alpha chars
		rawText = rawText.replaceAll("\\W", "");
		//create empty String which will be the encrypted text
		String encryptedText = "";
		
		//go through the whole string
		for(int i = 0 ; i < rawText.length() ; i++) {
			//check for whitespace, maybe use string method .trim (faster?)
			if(rawText.charAt(i) == ' ') {
				//if so do nothing and go to the next letter
				continue;
			}
			//otherwise find the key of the letter
			int keyValue = alphabet.get(rawText.charAt(i));
			//and shift the current key value by the encryptionKey value with its corresponding letter and save it to the endresult
			encryptedText += encryptionArr[(keyValue+encryptionKey)%26]; 
		}
		
		return encryptedText;
	}
	
	/* Decrypt given text
	 * with the given shift value (encryptionKey)
	 * using the formula newValue = (VurrentValue-Shift Value) % 26
	 * if newValue < 0 then add 26 to recieve a positive number for modulo operation
	 * returns decryted text or null if an error occured (invalid key/empty text)
	 */
	public String decrypt(String encryptedText,int encryptionKey) {
		
		//check if text and key is valid
		if(encryptionKey < 0 || encryptionKey >25 || encryptedText.length()<=0) {
			return null;
		}
		
		//convert encrypted text to uppercase letters
		encryptedText = encryptedText.toUpperCase();
		//remove all non alpha chars
		encryptedText = encryptedText.replaceAll("\\W", "");
		//create empty String which will be the decrypted text
		String decryptedText = "";
		
		for(int i = 0 ; i < encryptedText.length() ; i++) {
			//check for whitespace, maybe use string method .trim (faster?)
			if(encryptedText.charAt(i) == ' ') {
				//if so do nothing and go to the next letter, shouldn't be the case!
				continue;
			}
			//otherwise find the key of the letter
			int keyValue = alphabet.get(encryptedText.charAt(i));
			//and shift the current key value by the encryptionKey value with its corresponding letter
			int shiftedValue= (keyValue-encryptionKey)%26;
			//returns positive number if shiftedValue is negative
			if(shiftedValue < 0) {
				shiftedValue+=26;
			}
			
			decryptedText += encryptionArr[shiftedValue]; 
		}
		
		return decryptedText;
	}
}
