package api.page;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.given;
 
public class AddBoook {
 
    @Test
 
    public void AddBook() {
 
// TODO Auto-generated method stub
 
//BaseURL or Host
 
        RestAssured.baseURI="http://216.10.245.166";
     //   RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
 
 
//Parametros con given
 
        Response res =given().
 

                body(AddBoook.addBookBody()).
 
                when().
 
                get("/Library/Addbook.php").
 
                then().log().body().
 
                assertThat().statusCode(200).
                extract().response();
 
                
 
        JsonPath jsp = rawToJson(res);
 
        jsp.get("ID");
 
        System.out.println(jsp.get("ID").toString());
// 
 
 
    }
 
 
    public static String addBookBody() {
 
        String PayloadAddBook = "{" +
 
                "\"name\":\"Learn Davids book\"," +
 
                "\"isbn\":\"bcdea\"," +
 
                "\"aisle\":\"223t\"," +
 
                "\"author\":\"David Her\"" +
 
                "}";
 
        return PayloadAddBook;
 
    }
 
    public static XmlPath rawToXml(Response rawdata) {
 
        String Sresponse = rawdata.asString();
 
        XmlPath xp = new XmlPath(Sresponse);
 
        return xp;
 
 
 
    }
 
    public static JsonPath rawToJson(Response rawdata) {
 
        String Sresponse = rawdata.asString();
 
        JsonPath xp = new JsonPath(Sresponse);
 
        return xp;
 
 
 
    }
 
 
 
 
 
}