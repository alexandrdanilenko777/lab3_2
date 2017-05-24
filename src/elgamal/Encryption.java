package elgamal;

public class Encryption { 

	private int randomNumber = 0; 
	private int cipherTextOne = 0; 
	private int cipherTextTwo = 0; 
	
	private int [] cipherTextTwoArray = null;
	
	@SuppressWarnings("unused")
	private String Message = "";
	private EncryptionKey encryptionKey = new EncryptionKey(); 
	public Encryption() { 
		super(); 
	}
	
	public void createCipherTextOne() {
		int primeNumber = this.encryptionKey.getPrimeNumber(); 
		int generator= this.encryptionKey.getGenerator(); 
		this.cipherTextOne = getModValue(generator,primeNumber,randomNumber); 
		//this.cipherTextOne =(Math.pow(generator,randomNumber))%publicKey; 
	} 

	public int createCipherTextTwo(int message) { 
		int primeNumber = this.encryptionKey.getPrimeNumber(); 
		
		@SuppressWarnings("unused")
		int generator= this.encryptionKey.getGenerator(); 
		int randomNumber =this.randomNumber; 
		// int powerValue = randomNumber*primeNumber; 
		int powerValue = getModValue(encryptionKey.getPublicKey(),primeNumber,randomNumber); 
		this.cipherTextTwo = (message*powerValue)%primeNumber; 
		//this.cipherTextTwo = (message*getMadValue(generator,primeNumber,randomNumber))%primeNumber; 

		//this.cipherTextOne =(Math.pow(generator,randomNumber))%publicKey; 
		return cipherTextTwo;
	}
	
	public void initializeEncryption(EncryptionKey encryptionKey,String encryptionMessage) { 
		this.encryptionKey =encryptionKey; 
		this.randomNumber =(int)((this.encryptionKey.getPrimeNumber()-2)*(Math.random())); 
		this.Message = encryptionMessage; 
	}
	
	public int getModValue(int tempGenerator , int modNumber, int power) { 
		int ReturnModValue = 1; 
		for(int i =0;i < power; i++) { 
			ReturnModValue =(ReturnModValue*tempGenerator) % (modNumber); 
		} 
		return ReturnModValue; 
	} 
	
	public int getCipherTextOne() { 
		return this.cipherTextOne; 
	} 

	public int getCipherTextTwo() { 
		return this.cipherTextTwo; 
	} 

	public int[] getCipherTextTwoArray() { 
		return this.cipherTextTwoArray; 
	} 

	public void encrypt(String Message) { 
		this.createCipherTextOne(); 
		int length = Message.length(); 
		//int [] Ascii = new int[Message.]; 
		cipherTextTwoArray = new int[length];
		for (int i = 0 ; i< length ; i++) {
			cipherTextTwoArray[i] = this.createCipherTextTwo((int)Message.charAt(i));
		}
	}
	
} 