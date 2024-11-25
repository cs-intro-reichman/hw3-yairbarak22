// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	   System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-15,-3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6  
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int i = 0;
		int m=0;
		if (x2 == 0) return x1;
		else if (x1 == 0) return x2;
		else if (x2 < 0 && x1 > 0) {
			while (x2<0) {
				x2++;
				i++;
			}
			while (m<i) {
				x1--;
				m++;
			}
			return x1;
		}
		else if (x2 < 0 && x1 < 0) {
			while (x2<0) {
				x2++;
				i++;
			}
			while (m<i) {
				x1--;
				m++;
			}
			return x1;
		}
		else {
		while (i < x2) {	
			x1++;
			i++;
		}
		return x1;
	}
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int i = 0;
		int num = 0;
		if (x2 == 0) return x1;
		else if (x1 == 0) {
			while(i < x2) { 
			num--;
			i++;

		}
		return num;
	}
		else if (x2 < 0) {
			int m=0;
			while (x2<0) {
				x2++;
				i++;
			}
			while (m<i) {
				x1++;
				m++;
			}
			return x1;

		}
		else {
		while (i < x2) {
			x1--;
			i++;
		}
		return x1;
	}
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int i = 0;
		int sum = 0;
		if (x1 == 0 || x2 == 0) return 0;
		else if (x2 < 0 && x1 <0) {
			int m=0;
			while (x2<0) {
				x2++;
				m++;
			}
			int l=0;
			while (x1<0) {
				x1++;
				l++;
			}
			sum = 0;
			while (i < m) {
				sum = plus(sum, l);
				i++;
			}
			return sum;

		}	
			else {
		while (i < x2) {
			sum = plus(sum, x1);
			i++;
		}
		return sum;
	}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i = 0;
		int result = x;
		if (n == 0) return 1;
		else if (x<0){
			boolean neg = false;
			int m=0;
			while (x<0) {
				x++;
				m++;
			}
			result = m;
			while (i < (n-1)) {
				result = times(result, m);
				neg = !neg;
				i++;
			}
			if (neg) return result;
			else {
				result = minus(result, times (result, 2));
				return result;
			}
			
			
		}	else {
		while (i < (n-1)) {
			result = times(result, x);
			i++;
		}
		return result;
	}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i = 0;
		if (x1<0 && x2 > 0) {
			int m=0;
			while (x1<0) {
				x1++;
				m++;
			}
			int num =m;
			while (num > 0) {
				num = minus(num, x2);
				i++;
			}
			i = minus(i, times(i,2));
			return i;
		}
		else if (x1<0 && x2 < 0) {
			int m=0;
			while (x1<0) {
				x1++;
				m++;
			}
			int b=0;
			while (x2<0) {
				x2++;
				b++;
			}
			int num = m;
			while (num > 0) {
				num = minus(num, b);
				i++;
			}
			if(num<0) i--;
			
		return i;
		
			
		} else {
		int num = x1;
		while (num > 0) {
			num = minus(num, x2);
			i++;
		}
		if(num<0) i--;
		return i;
	}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int i = 0;
		int num = x1;
		while (num > 0) {
			num = minus(num, x2);
			i++;
		}
		if(num<0) {
		num = plus(num, x2);
		return num;
		}
		else return 0;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 1;
		int num = x;
		while (true) {
			num = div(x, i);
			if (num == i || i >= num) break;
			i++;
			
		}
		return num;
	}	  	  
}