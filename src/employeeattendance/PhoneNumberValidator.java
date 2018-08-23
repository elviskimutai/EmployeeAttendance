/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeattendance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AnonymousHacker
 */
public class PhoneNumberValidator {
    public static boolean phone_validation(String pne){
    boolean status;
    String PnePtn="^[0-9.()-]{10,25}$";
    Pattern ptn=Pattern.compile(PnePtn);
    Matcher mtc=ptn.matcher(pne);
    if(mtc.matches()){
        status= true;
    }else{
        status= false;
    }
    return status;
    }
}
