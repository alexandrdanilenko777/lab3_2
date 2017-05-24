package elgamal; 

public class Decryption { 
	private DecryptionKey decryptionKey = null; 
	private String message =""; 

	public Decryption() { 
		super();
	}
	
	public long FindInverse(long a, long b) { 
		long q =1; 
		long temp = 0; 
		long r = 1; 
		long sign = 1; 
		long store = a; 
		long s =0; 
		
		while(b!=0) { 
			q=a/b; 
			temp = r; 
			r = temp*q+s; 
			s= temp; 
			temp = b; 
			b = a- q*temp; 
			a = temp; 
			sign =- sign; 
		}
		
		long answer = (r-(sign*s))%store; 
		return answer;
	}
	
	public void initializeDecryption(DecryptionKey decryptionKey) { 
		this.decryptionKey =decryptionKey; 
	} 
	
	public DecryptionKey getDecryptionKey() { 
		if(decryptionKey != null) { 
			return this.decryptionKey; 
		}else{ 
			this.decryptionKey = new DecryptionKey (); 
			return this.decryptionKey; 
		}
	}
	
	public int getModValue(int tempGenerator , int modNumber, int power) { 
		int ReturnModValue = 1; 
		for(int i =0;i < power; i++) { 
			ReturnModValue =(ReturnModValue*tempGenerator) % (modNumber); 
		} 	
		return ReturnModValue; 
	} 
	
	public int[] decrypt(int cipherTextOne , int [] cipherTextTwoArray) { 
		int []InverseValue2 = new int[cipherTextTwoArray.length]; 
		long InverseValue = FindInverse(this.decryptionKey.getPrimeNumber(),cipherTextOne); 
		int InverseValue1 =getModValue((int)InverseValue, this.decryptionKey.getPrimeNumber(), this.decryptionKey.getPrivateKey()); 
		for(int i =0; i< cipherTextTwoArray.length ;i++) {
			InverseValue2[i] = (InverseValue1*cipherTextTwoArray[i])%decryptionKey.getPrimeNumber(); 
		}
		return InverseValue2; 
	}
	
	public String getMessage(){ 
		return this.message; 
	} 
	
	public void setMessage(String message){ 
		this.message = message; 
	} 
	
}