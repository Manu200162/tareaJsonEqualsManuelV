package jsonEqual;

import java.util.Arrays;

public class JsonEqual {

    public boolean equalJson(String expected, String actual) {
        if(expected.isBlank() || actual.isBlank()){
            return false;
        }

        if(expected.length() != actual.length()){
            return false;
        }

        String [] expectedJson = expected.split(",");
        String [] actualJson = actual.split(",");

        if(expectedJson.length != actualJson.length){
            return false;
        }
        for(int i = 0 ; i<actualJson.length ; i++){
            String [] actualResult = actualJson[i].split(":");
            String [] expResult = expectedJson[i].split(":");
            if(actualResult[0].equals(expResult[0])){
                if(!(actualResult[1].equals(expResult[1]))){
                    return false;
                }
            }else{
                return false;
            }
        }
            return true;
    }
}
