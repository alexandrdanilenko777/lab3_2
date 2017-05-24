package elgamal; 

public class EncryptionKey { 	

	private int primeNumber = 0; 
	private int publicKey = 0; 
	private int generator = 0;
	
	public EncryptionKey() { 
		super(); 
	}
	
	public int getPrimeNumber() { 
		return primeNumber; 
	}
	
	public int getPublicKey() { 
		return publicKey;
	}
	
	public int getGenerator() { 
		return generator; 
	} 

	public void setPrimeNumber(int primeNumber) { 
		this.primeNumber = primeNumber; 
	} 

	public void setPublicKey(int publicKey) { 
		this.publicKey = publicKey; 
	} 
	
	public void setGenerator(int generator) { 
		this.generator = generator; 
	} 
	
} 