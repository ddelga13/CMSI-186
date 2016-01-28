public class DatesDistance{
	public static void main (String [] args){
		long d0 = Long.parseLong (args[0]);
		long m0 = Long.parseLong (args[1]);
		long y0 = Long.parseLong (args[2]);
		long d1 = Long.parseLong (args[3]);
		long m1 = Long.parseLong (args[4]);
		long y1 = Long.parseLong (args[5]);
		if (isRealDate (d0, m0, y0) && isRealDate (d1, m1, y1)){		
				System.out.println (distance (d0, m0, y0, d1, m1, y1));
		} else {
		 	System.out.println ("Invalid entry.");
		 }
	}
	public static boolean isCommonYear (long year){
		if (year % 4 != 0){
			return true;
		}
		else if (year % 100 != 0){
			return false;
		}
		else if (year % 400 != 0){
			return true;
		}
		else
			return false;
	}
	public static long monthLength (long month, long year){
		if ((month == 2) && (isCommonYear(year))){
			return (28);
		}
		else if (month == 2){
			return (29);
		}
		else if ((month == 4)
			|| (month == 6)
				|| (month == 9)
					|| (month == 11)){
			return (30);
		}
		else return (31);
	}
	public static boolean isRealDate (long day, long month, long year){
		if ((day < 0)
		|| (day > 31)
				|| (month < 0)
				|| (month > 12)
					|| (year < 0)){
			return false;
		}
		else if (monthLength (month, year) < day)
			return false;
		else return true;
	}
	public static long distance (long day0, long month0, long year0, long day1, long month1, long year1){
		long totaldays = 0;
		long leapdays = 0;
		if (year0 < year1){
			long daysLeftInMonth0 = (monthLength (month0, year0) - day0);
			long sum0 = 0;
			for (long i = month0 + 1; i <= 12; i++){
				sum0 = sum0 + (monthLength (i, year0));
			}
			long daysLeftInYear0 = daysLeftInMonth0 + sum0;
			long sum1 = 0;
			for (long j = 1; j < month1; j++){
				sum1 = sum1 + (monthLength (j, year1));
			}
			long daysLeftInYear1 = sum1 + day1;
			long floatingDays = daysLeftInYear0 + daysLeftInYear1;

			for (long i = year0; i < year1; i++){
				if (!isCommonYear (i)){
					leapdays = leapdays + 1;
				}
			}
			totaldays = leapdays + (year1 - year0) * 365;
			return totaldays + floatingDays;
		}
		if (year1 < year0){
			long daysLeftInMonth1 = (monthLength (month1, year1) - day1);
			long sum1 = 0;
			for (long i = month1 + 1; i <= 12; i++){
				sum1 = sum1 + (monthLength (i, year1));
			}
			long daysLeftInYear1 = daysLeftInMonth1 + sum1;
			long sum0 = 0;
			for (long j = 1; j < month1; j++){
				sum0 = sum0 + (monthLength (j, year0));
			}
			long daysLeftInYear0 = sum0 + day0;
			long floatingDays = daysLeftInYear1 + daysLeftInYear0;

			for (long i = year1; i < year0; i++){
				if (!isCommonYear (i)){
					leapdays = leapdays + 1;
				}
			}
			totaldays = leapdays + (year0 - year1) * 365;
			return totaldays + floatingDays;
		}
		else {
			if (month0 < month1){
				long daysLeftInMonth0 = (monthLength (month0, year0) - day0);
				long sum0 = 0;
				for (long i = month0; i <= month1; i++){
					sum0 = sum0 + (monthLength (i, year0));
				}
				return daysLeftInMonth0 + sum0 + day1;
			}
			if (month1 < month0){
				long daysLeftInMonth1 = (monthLength (month1, year1) - day1);
				long sum1 = 0;
				for (long i = month1; i <= month0; i++){
					sum1 = sum1 + (monthLength (i, year1));
				}
				return daysLeftInMonth1 + sum1 + day0;
			}
			else {
				return Math.abs(day1 - day0);
			}
		}
	}
}

// example: (DateDistance 24 1 2016 28 7 1999)
// example: (DateDistance 17 6 1999 28 7 1999)
