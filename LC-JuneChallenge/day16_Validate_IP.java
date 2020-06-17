/**
Problem - Validate IP Address

Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

Example -

Input: "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".

Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
**/

/**
Solution -
The below solution maily uses regex for checking the format.
**/
class Solution {
    public String validIPAddress(String IP) {
        
        int last  = IP.length() - 1;
		
		//initial checks that directly makes IP invalid
        if(IP.length() == 0 || IP.charAt(0) == '.' || IP.charAt(last) == '.' || IP.charAt(0) == ':' || IP.charAt(last) == ':'){
            return "Neither";
        }
        
		//segregating IPv4 and IPv6
        if(IP.contains(".")){
            String[] comp = IP.split("[.]");            
            if(comp.length != 4){
                return "Neither";
            }
            for(String i: comp){     
                 try{
                     int num = Integer.parseInt(i);
    
                     if(num < 0 || num > 255 || (i.length() > 1 && num >= 0 && i.charAt(0) == '0') || (!i.matches("[0-9]+"))){
                         return "Neither";
                     }
					
                 }catch(NumberFormatException e){
                     
                     return "Neither";
                 }
                 
            }            
            return "IPv4";
        }else{
            String[] comp = IP.split("[:]");
            if(comp.length != 8){
                return "Neither";
            }            
            for(String c: comp){
                if(c.length() > 4 || !c.matches("[0-9a-fA-F]+")){
                    return "Neither";
                }
            }
            return "IPv6";
        }
    }
}

