import java.util.Arrays;

public class BigInteger {

	private int [] digits;
	private int signum = 1;

	public int getSignum(){
		return this.signum;
	}

	public int [] getDigits(){
		return this.digits;
	}

	public void setDigits(int [] newDigits){
		this.digits = newDigits;
	}

	public BigInteger (String number){
		String x = "";
		int length = number.length();
		this.digits = new int[length];
		if (number.charAt(0) == '-'){
			x = trimLeadingZeros(number.substring(1,number.length()));
			this.digits = convertToBinaryArray(x);
			this.signum = -1;
		}
		if (x.equals("0")){
			this.signum = 0;
		} else {
			x = trimLeadingZeros(number);
			this.digits = convertToBinaryArray(x);
		}
	}

	public BigInteger (int sign, int [] num){
		this.signum = sign;


		this.digits = num; //copy the array if numbers are changing when they arent supposed to
	}
	
	private static String trimLeadingZeros (String number){
		int index = 0;
		while (number.charAt(index) == '0' && index < number.length()-1){
			index++;
		}
		return number.substring (index, number.length());
	}

	private static int [] appendLeadingZeros (int [] grid, int length){ //append extra zero
		int index = 0;
		int [] rando = new int [length];
		for (int i = 0; i < grid.length; i++){
			rando[i] = grid[i];
		}
		System.out.println("rando: " + Arrays.toString(rando));
		return rando;
	}

	private static int [] stringtoArray (String number){
		int [] result = new int [number.length()];
		int index = 0;
		for (int i = number.length() -1; i >= 0; i--){
			char c = number.charAt(i);
			result[index] = Character.getNumericValue (c);
			if (result[index] < 0 || result[index] > 9){
				throw new IllegalArgumentException();
			}
			index++;
		}
		return result;
	}

	private static String arraytoString (int [] grid){
		String result = "";
		for (int i = grid.length-1; i >= 0; i--){
			result += (grid[i]);
		}
		return result;
	}

	public static boolean isEven(char c){
		if (c == '0' || c == '2' || c == '4' || c == '6' || c == '8'){
			return true;
		} else if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9'){
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static String divideByTwo (String decimalString){
		String result = "";
		boolean nextWasOdd = false;
		for (int i = decimalString.length()-1; i >= 0; i--){
			if (i != 0 && !isEven (decimalString.charAt(i-1))){
				nextWasOdd = true;
				decimalString = decimalString.substring(0, i-1) + Character.getNumericValue(decimalString.charAt(i-1)-1) + (Character.getNumericValue(decimalString.charAt(i)));
			} else { nextWasOdd = false; }
			int num = Character.getNumericValue (decimalString.charAt(i));
			result = num/2 + (nextWasOdd? 5 : 0) + result;
		}
		return trimLeadingZeros(result);
	}

	public int [] convertToBinaryArray (String decimalString){
		int [] binArray = new int[decimalString.length()];
		String result = "";
		if (decimalString.equals("0")){
			result = "0";
		} else {
			for (int i = 0; i < decimalString.length(); i++){
				if (isEven (decimalString.charAt(decimalString.length()-1))){
					result = "0" + result;
				} else {
					result = "1" + result;
				}
				decimalString = divideByTwo(decimalString);
			}
		}
		return stringtoArray(result);
	}

	// public String convertToDecimalString (int [] binArray){
	// 	String result = "";
	// 	int [] binArray = new int [decimalString.length];
	// 	if (new BigInteger(Arrays.toString(binArray).replaceAll("\\[|\\], " , ""))  == new BigInteger("0")){
	// 		result = "0";
	// 	} else {
	// 		int j = 0;
	// 		int [] sum = 0; // sum becomes a bigint! can't store as string, because then i can't add! FUUUUUU
	// 		for (int i = binArray.length-1; i >= 0; i--){
	// 			[i] 
	// 				//i = binArray.length -1
	// 				//start at i (the end of the array, the ones place)
	// 				//multiply that by 2 to the jth power
	// 				//store ^^that value into sum
	// 				//move on to the next left bit (binArray.length -2)
	// 				//j++;
	// 		}
	// 	}
	// }

	public static String addOne (String decimalString){
		if (decimalString.equals("")){
			return "1";
		}
		char lastDigit = decimalString.charAt(decimalString.length()-1);
		if (lastDigit != '9'){
            return decimalString.substring(0,decimalString.length()-1) + (Character.getNumericValue(lastDigit) + 1);
		} else {
			return addOne(decimalString.substring(0, decimalString.length()-1))+ "0";
		}
	}

	// public static String doubleDecimalString (String decimalString){
	// 	String result = "";
	// 	if (decimalString.equals("")){
	// 		return "0";
	// 	}
	// 	char lastDigit = decimalString.charAt(decimalString.length()-1);
	// 	for (int i = decimalString.length()-1; i >= 0; i--){
	// 		int regroupint = Character.getNumericValue(decimalString.charAt(i)) * 2;
	// 		// if (i-2 < 0 || i-1 < 0){
	// 		// 	System.out.println("i: " + i);
	// 		// 	break;
	// 		// }
	// 		if (i > 1 && regroupint > 9){
	// 			result = decimalString.substring(0, i-2) + String.valueOf(Character.getNumericValue(decimalString.length()-1)+1) + String.valueOf(Character.getNumericValue(lastDigit) * 2);
	// 		} else
	// 			System.out.println("lastDigit: " + lastDigit);
	// 			System.out.println("decimalString: " + decimalString);
	// 			result = decimalString.substring(0, i-1) + String.valueOf(Character.getNumericValue(lastDigit) * 2);
	// 		System.out.println("result: " + result);	
	// 		return doubleDecimalString(result);
	// 	}
	// 	return result;
	// }

	public BigInteger add (BigInteger val){
		BigInteger thisNum = new BigInteger(this.signum, this.digits);
		BigInteger valNum = new BigInteger(val.signum, val.digits);
		System.out.println("thisNum: "+ thisNum);
		System.out.println("valNum: " + valNum);
		int sign = 1;
		int [] sum = new int[digits.length > val.digits.length ? digits.length + 1 : val.digits.length +1]; //which is longer, that +1
		if (thisNum.signum == 0){
			return valNum;
		} else if (valNum.signum == 0){
			return thisNum;
		}
		if (thisNum.digits.length != valNum.getDigits().length){
			if (thisNum.digits.length < valNum.getDigits().length){
				thisNum.digits = BigInteger.appendLeadingZeros(thisNum.digits, valNum.getDigits().length);
			} else if (thisNum.digits.length > valNum.digits.length){
				valNum.setDigits(BigInteger.appendLeadingZeros(valNum.getDigits(), thisNum.digits.length));
			}
		}
		if (thisNum.signum != valNum.signum && thisNum.signum != 0 && valNum.signum != 0){
			if (thisNum.signum == -1){
				thisNum.signum = 1;
			}
			if (valNum.signum == -1){
				valNum.signum = 1;
			}
			return thisNum.subtract (valNum);
		}
		int carry = 0;
		for (int i = 0; i < thisNum.digits.length; i++){
			int x = valNum.getDigits()[i] + thisNum.digits[i] + carry;
			if (x > 1){
				carry = 1;
				x = x - 2;
			} else carry = 0;
			sum[i] = x;
		}
		sum [sum.length-1] = carry;
		if (thisNum.signum == -1 && valNum.signum == -1){
			sign = -1;
		}
		else { sign = 1; }
		return new BigInteger (sign, sum);
	}

	public BigInteger subtract (BigInteger val){
		throw new UnsupportedOperationException();
	}

	public BigInteger multiply (BigInteger val){
		//int a = 5;
		//a>>1 = 10 // shifts means double
		//a<<1 = 2 // shifts means halved
		throw new UnsupportedOperationException();
	}

	public BigInteger divide (BigInteger val){
		throw new UnsupportedOperationException();
	}

	public BigInteger remainder (BigInteger val){
		throw new UnsupportedOperationException();
	}

	public String toString (){
		String result = arraytoString(this.digits);
		if (signum == -1){
			result = "-" + result;
		}
		return result;
	}

	public int compareTo (BigInteger val){
		if (this.signum == -1 && val.signum == -1){
			return (new BigInteger(1, val.digits)).compareTo(new BigInteger (1, this.digits));
		}
		if (this.signum != val.signum){
			if (this.signum == -1){
				return -1;
			} else if (this.signum == 1){
				return 1;
				} else if (val.signum == 1){
					return -1;
				} else { return 1; }
		} else if (this.digits.length != val.digits.length){
			if (this.digits.length < val.digits.length){
				return -1;
			} else if (this.digits.length > val.digits.length){
				return 1;
			}
		} else {
			for (int i = this.digits.length - 1; i >= 0; i--){
				if (this.digits[i] > val.digits[i]){
					return 1;
				}
				if (this.digits[i] < val.digits[i]){
					return -1;
				}
			}
			return 0;
		}
		return 0;
	}  

	public boolean equals (Object x){
		if (BigInteger.class.isInstance(x)){
			if (this.signum == ((BigInteger) x).getSignum()){
				if (this.digits.length == ((BigInteger)x).getDigits().length){
					for (int i = this.digits.length - 1; i >= 0; i--){
						if (this.digits[i] == ((BigInteger) x).getDigits()[i]){
							return true;
						} else return false;
					}
				} else return false;
			} else return false;
		} else return false;
		return false;
	}

	//public static final BigInteger ZERO = new BigInteger("0"); //(constants)

	//public static final BigInteger ONE = new BigInteger("1"); //("") new biginterger 10
	//public static final BigInteger TEN = new BigInteger("11111"); //("")
	public static final BigInteger valueOf (long val){
		throw new UnsupportedOperationException();
	} //(static factor)



	public static void main (String [] args){

		// int test = 5;

		// test = test<<1;
		// System.out.println(test);

		// test = test<<1;
		// System.out.println(test);


		



		//BigInteger b = new BigInteger ("598650");  // Halves to 299325
		BigInteger b1 = new BigInteger("0");
		BigInteger b2 = new BigInteger("1");
		// System.out.println(BigInteger.divideByTwo("50"));
		// System.out.println(BigInteger.doubleDecimalString("50"));
		// System.out.println(BigInteger.convertToBinaryArray("8"));
		System.out.println(BigInteger.addOne("50"));
		System.out.println(b1.add(b2));
	}


}
