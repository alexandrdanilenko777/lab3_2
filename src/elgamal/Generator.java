package elgamal; 

import java.util.Vector; 
 
public class Generator { 
	private int primeNumber = 0; 
	private int generator = 0; 
	
	public Generator() { 
		super(); 
	}
	
	public Vector<String> createGenerator(int primeNumber) { 
		Vector<String> aa = new Vector<String>(); 
		int tempGenerator = 0; 
		//old value 2 
		for ( tempGenerator =1 ; tempGenerator< primeNumber ;tempGenerator++ ) {
			boolean valueGenerated = false; 
			int[] TempArray = new int[primeNumber - 1]; 
			int ReturnModValue = 1; 
			for (int tempVal = 1; tempVal < primeNumber; tempVal++) { 
				// Return the Mod value 
				ReturnModValue = getModValue(tempGenerator, primeNumber, tempVal,ReturnModValue); 
				// Check the Mod value , if it is equal to 1 and not the last number 
				if(ReturnModValue == 1 && tempVal!=primeNumber-1) { 
					break; 
				} 
				
				// Compare it with other mod values 
				boolean temp = compareValue(TempArray, ReturnModValue , tempVal); 
	
				// Add the Mod values to a array 
				TempArray[tempVal - 1] = ReturnModValue; 
	
				if (temp == true) { 
					break; 
				}
				
				// If this is a generator set the flag true 
				if(tempVal == primeNumber-1 && TempArray[tempVal-1]==1) {
					valueGenerated= true; 
					break;
				}
			}
			
			// Add the Generator to the Veсtor 
			if(valueGenerated==true) { 
				aa.addElement(String.valueOf(tempGenerator)); 
				break;
			}
		}
		return aa;
		
		//return tempGenerator;
	}
	
	public int getModValue(int tempGenerator , int primeNumber, int tempVal, int ReturnModValue) { 
		int anu =(ReturnModValue*tempGenerator) % (primeNumber); 
		return anu; 
	} 
	
	public boolean compareValue(int TempArray[],int ReturnModValue, int tempVal) { 
		for ( int i =0 ; i< TempArray.length ;i++) {
			if(TempArray[i] ==ReturnModValue ) { 
				return true; 
			}
		}
		return false;
	} 
	
	public int createPrimeNumber(int StartNumber , int EndNumber) { 
		double x =0; 
		while (true) { 
			double PrimeNumber =StartNumber+ (EndNumber - StartNumber)*Math.random(); 
			int PrimeNumber1 =(int)PrimeNumber; 
			//double x = (Math.pow(2,PrimeNumber1-1))%PrimeNumber1; 
			x = getTotalModValue(2,PrimeNumber1,PrimeNumber1-1); 
			if(x==1) {
				return PrimeNumber1;
			}
		}
	}
	
	@SuppressWarnings("unused")
	public Vector<String> createPrimeNumberVector(int StartNumber , int EndNumber) { 
		Vector<String> aa = new Vector<String>(); 
		double x =0; 
		double y =0; 
		double xfinal =0; 
		int ans =0; 
		for ( int i =StartNumber ; i<=EndNumber ; i++) { 
			// int index = i/1000; 
			// x = (Math.pow(2,1000))%i; 
			// y = (Math.pow(2,i-1-(index*1000)))%i; 
			// xfinal =Math.pow(x,index); 
			// ans = (xfinal*y)%i; 
			ans = getTotalModValue(2,i,i-1); 
			if(ans==1) { 
				aa.addElement(String.valueOf(i));
			} 
		}
		return aa;
	}
	
	public int getTotalModValue(int tempGenerator , int modNumber, int power) {
		int ReturnModValue = 1; 
		for(int i =0;i < power; i++) {
			ReturnModValue =(ReturnModValue*tempGenerator) % (modNumber);
		}
		return ReturnModValue;
	}
	
	public void setPrimeNumber(int primeNumber) { 
		this.primeNumber = primeNumber; 
	}
	
	public void setGenerator(int generator) { 
		this.generator = generator; 
	}
	
	public int getPrimeNumber() { 
		return primeNumber; 
	}
	
	public int getGenerator() { 
		return generator; 
	}
	
	public void initializeGenerator(int generator,int primeNumber) { 
		setPrimeNumber(primeNumber); 
		setGenerator(generator); 
	}
} 