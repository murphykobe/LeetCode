// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
//
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//
// 	I can be placed before V (5) and X (10) to make 4 and 9. 
// 	X can be placed before L (50) and C (100) to make 40 and 90. 
// 	C can be placed before D (500) and M (1000) to make 400 and 900.
//
//
// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
// Example 1:
//
//
// Input: 3
// Output: "III"
//
// Example 2:
//
//
// Input: 4
// Output: "IV"
//
// Example 3:
//
//
// Input: 9
// Output: "IX"
//
// Example 4:
//
//
// Input: 58
// Output: "LVIII"
// Explanation: L = 50, V = 5, III = 3.
//
//
// Example 5:
//
//
// Input: 1994
// Output: "MCMXCIV"
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//


class Solution {
    public String intToRoman(int num) {
        StringBuilder ans=new StringBuilder();
        int[] digits=new int[4];
        digits[0]=((int)num/1000)*1000;
        digits[1]=((int)(num-digits[0])/100)*100;
        digits[2]=((int)(num-digits[1]-digits[0])/10)*10;
        digits[3]=((int)(num-digits[2]-digits[1]-digits[0])%10);
        if(digits[0]>0){
            for(int i=0;i<digits[0]/1000;i++){
                ans.append("M");
            }
        }
        if(digits[1]>=0 && digits[1]<=300){
            for(int i=0;i<digits[1]/100;i++){
                ans.append("C");
            }
        }
        if(digits[1]/100==4){
                ans.append("CD");
        }
        if(digits[1]>=500 && digits[1]<=800){
                ans.append("D");
            for(int i=0;i<digits[1]/100-5;i++){
                ans.append("C");
            }
        }
        if(digits[1]>800 && digits[1]<1000){
            for(int i=0;i<10-digits[1]/100;i++){
                ans.append("C");
            }
                ans.append("M");
        }
        
        if(digits[2]>0 && digits[2]<=30){
            for(int i=0;i<digits[2]/10;i++){
                ans.append("X");
            }
        }
        if(digits[2]/10==4){
            ans.append("XL");
        }
         
        if(digits[2]>=50 && digits[2]<=80){
                ans.append("L");
            for(int i=0;i<digits[2]/10-5;i++){
                ans.append("X");
            }
        }
        if(digits[2]>80 && digits[2]<100){
            for(int i=0;i<10-digits[2]/10;i++){
                ans.append("X");
            }
                ans.append("C");
        }
        
        if(digits[3]>0 && digits[3]<=3){
            for(int i=0;i<digits[3];i++){
                ans.append("I");
            }
        }
        
        if(digits[3]==4){
            ans.append("IV");
        }
        
        if(digits[3]>=5 && digits[3]<=8){
                ans.append("V");
            for(int i=0;i<digits[3]-5;i++){
                ans.append("I");
            }
        }
        if(digits[3]>8 && digits[3]<10){
            for(int i=0;i<10-digits[3];i++){
                ans.append("I");
            }
                ans.append("X");
        }
        
        
        return ans.toString();
    }
}
