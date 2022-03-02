import jsonEqual.JsonEqual;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JsonEqualTets {


    @Test
    public void blankString(){
        JsonEqual jsonEqual =new JsonEqual();
        Assertions.assertFalse(jsonEqual.equalJson(" ","sdf"),"Error resultado equivocado ");
    }

    @Test
    public void wrongJson(){
        JsonEqual jsonEqual=new JsonEqual();
        Assertions.assertFalse(jsonEqual.equalJson("sdf","fds"),"Error resultado equivocado");

    }

    @Test
    public void differentJson(){
        JSONObject body1 =new JSONObject();
        body1.put("Nombre","Manuel");
        body1.put("Apellido","Valenzuela");
        body1.put("Edad",21);

        JSONObject body2=new JSONObject();
        body1.put("Nombre","Carlos");
        body1.put("Apellido","Valenzuela");
        body1.put("Edad",21);

        JsonEqual jsonEqual =new JsonEqual();
        Assertions.assertFalse(jsonEqual.equalJson(body1.toString(),body2.toString()),"Error resultado equivocado");

    }

    @Test
    public void sameJson(){
        JSONObject body1 =new JSONObject();
        body1.put("Nombre","Manuel");
        body1.put("Apellido","Valenzuela");
        body1.put("Edad",21);
        


        JSONObject body2=new JSONObject();
        body2.put("Nombre","Manuel");
        body2.put("Apellido","Valenzuela");
        body2.put("Edad",21);


        JsonEqual jsonEqual =new JsonEqual();
        Assertions.assertTrue(jsonEqual.equalJson(body1.toString(),body2.toString()),"Error resultado equivocado");

    }

    @Test
    public void sameJsonwithoutARow(){
        JSONObject body1 =new JSONObject();
        body1.put("Nombre","Manuel");
        body1.put("Apellido","Valenzuela");
        body1.put("Edad",21);



        JSONObject body2=new JSONObject();
        body2.put("Nombre","Manuel");
        body2.put("Apellido","Valenzuela");


        JsonEqual jsonEqual =new JsonEqual();
        Assertions.assertFalse(jsonEqual.equalJson(body1.toString(),body2.toString()),"Error resultado equivocado");

    }
    @Test
    public void extraRow(){
        JSONObject body1 =new JSONObject();
        body1.put("Nombre","Manuel");
        body1.put("Apellido","Valenzuela");
        body1.put("Edad",21);



        JSONObject body2=new JSONObject();
        body2.put("Nombre","Manuel");
        body2.put("Apellido","Valenzuela");
        body1.put("Edad",21);
        body1.put("Carrera","Ing de sistemas");


        JsonEqual jsonEqual =new JsonEqual();
        Assertions.assertFalse(jsonEqual.equalJson(body1.toString(),body2.toString()),"Error resultado equivocado");

    }
}
