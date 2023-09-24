
import io.restassured.response.Response;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import static io.restassured.RestAssured.*;


public class test {
    @Test
    void testGetRequest() {
        Response response = get("https://www.almosafer.com/api/system/currency/list");
        System.out.println("Status Code" + response.getStatusCode());
        System.out.println("Body" + response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    @Parameters({ "pId" , "hotelId"})
    void testPOSTRequest(@Optional String hotelId, @Optional String pId) {

        String baseUrl = "https://www.almosafer.com/api/enigma/cart";
        String requestBody = "{\"pId\":\"" + pId + "\",\"hotelId\":\"" + hotelId + "\",\"packageId\":\"0cbc3981-6b7c-4bab-8518-48757f3d53d3\"}";
        Response response = given()
                .baseUri(baseUrl)
                .headers(
                        "authority", "www.almosafer.com",
                        "accept", "application/json, text/javascript",
                        "x-api-key", "apikey-hotel",
                        "x-app-name", "ct-web-hotels-desktop",
                        "x-bt", "next",
                        "x-currency", "SAR",
                        "x-locale", "en",
                        "x-platform", "web",
                        "x-tz", "Asia/Amman"
                )
                .body(requestBody)
                .post();


        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }
}

