package elgamal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
//import java.util.Arrays; 
import java.util.Vector; 
//import java.util.*; 

public class ElGamal {
	
	public ElGamal() {
		super();
	}
	
	public static void main(String[] args) throws FileNotFoundException { 
		Vector<?> primeVector = new Vector<Object>(); 
		//Vector primeVector = new Vector();
	Generator generator = new Generator(); 
	int primeNumber = 0; 
	while (primeVector.isEmpty()) { 
		primeNumber = generator.createPrimeNumber(1000, 9000); 
		//System.out.println("--------Prime Number--------"); 
		//System.out.println("Prime Number : " + primeNumber); 
		//Vector pnVector = generator.createPrimeNumberVector(1000, 2357); 
		primeVector = generator.createGenerator(primeNumber); 
		} 
	
	generator.initializeGenerator(Integer.parseInt(primeVector.elementAt(0).toString()), primeNumber); 
	
	//print PrimeNumber and generator in files
	PrintStream in_console = System.out;
	File file1 = new File("generator-g");
	FileOutputStream fos = new FileOutputStream(file1);
	PrintStream in_file = new PrintStream(fos);
	System.setOut(in_file);
	System.out.println(generator.getGenerator());
	//Integer w = Integer.valueOf(generator.getGenerator());
	//String outputHex1 = Integer.toHexString(w);
	//System.out.println(outputHex1);
	File file2 = new File("prime-mod-p");
	FileOutputStream fos2 = new FileOutputStream(file2);
	PrintStream in_file2 = new PrintStream(fos2);
	System.setOut(in_file2);
	String outputHex2 = Integer.toHexString(primeNumber);
	System.out.println(outputHex2);
	
	
	
	//exit from filePrint, print to console
	System.setOut(in_console);
	
	
	
	System.out.println("--------Generator--------"); 
	System.out.println("Generator : " + generator.getGenerator()); 
	System.out.println("Prime Number : " + generator.getPrimeNumber()); 

	// Create Encryption and Decryption keys
	
	Keys keys = new Keys(); 
	keys.initializeKeys(generator.getGenerator(), generator.getPrimeNumber()); 
	EncryptionKey encryptionKey = keys.getEncryptionKey(); 
	DecryptionKey decryptionKey = keys.getDecryptionKey(); 

	System.out.println("--------EncryptionKey--------"); 
	System.out.println("Public Key : " + encryptionKey.getPublicKey()); 
	System.out.println("Generator :" + encryptionKey.getGenerator()); 
	System.out.println("Prime Number : " + encryptionKey.getPrimeNumber()); 
	
	System.out.println("--------DecryptionKey--------"); 
	System.out.println("Private Key : " + decryptionKey.getPrivateKey()); 
	System.out.println("Prime Number : " + decryptionKey.getPrimeNumber()); 
	
	
	
	// Initialize Encryption
	
	String encryptionMessage = "Hello World !!!"; 
	Encryption encryption = new Encryption(); 
	encryption.initializeEncryption(encryptionKey, encryptionMessage); 
	encryption.encrypt(encryptionMessage);
	
	//print message in file
	PrintStream in_console_3 = System.out;
	File file3 = new File("message");
	FileOutputStream fos3 = new FileOutputStream(file3);
	PrintStream in_file_3 = new PrintStream(fos3);
	System.setOut(in_file_3);
	System.out.println(encryptionMessage);
	System.setOut(in_console_3);
	
	
	//continue
	System.out.println("--------Encryption--------"); 
	System.out.println("Encryption Message :" + encryptionMessage); 
	System.out.println("CipherTextOne : " + encryption.getCipherTextOne()); 
	System.out.print("CipherTextTwo : ");
	
	for (int i = 0; i < encryption.getCipherTextTwoArray().length; i++) {
		System.out.print(encryption.getCipherTextTwoArray()[i] + " ");
	}
	System.out.println(""); 
	

	// Initialize Decryption 
	
	Decryption decryption = new Decryption(); 
	decryption.initializeDecryption(decryptionKey); 
	int[] mes = decryption.decrypt(encryption.getCipherTextOne(), 
	encryption.getCipherTextTwoArray());
	
	System.out.println("--------Decryption--------"); 
	String message = ""; 
	@SuppressWarnings("unused")
	int ASCII = 0; 
	System.out.print("Decryption Message :");
	
	for (int i = 0; i < mes.length; i++) {
		message += "" + ((char) mes[i]); 
		System.out.print(mes[i] + " "); 
	} 
	System.out.println(""); 
	
	decryption.setMessage(message); 
	System.out.println("Final Message : " + decryption.getMessage());
	
	} 

}
