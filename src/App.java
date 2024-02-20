import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
    public static void main(String[] args) throws Exception {
        // * 要發送請求的網址
        String[] url = new String[] { "curl", "-X", "GET",
                "https://opendata.cwa.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWA-58A66B99-FFDC-44AA-A26F-4E7F83AE2A50&format=JSON&locationName=%E6%96%B0%E7%AB%B9%E5%B8%82",
                "-H", "accept: application/json" };
        // * 建立請求的執行緒
        ProcessBuilder processBuilder = new ProcessBuilder(url);
        // * 執行請求
        Process process = processBuilder.start();
        // * 將請求的結果讀出為輸入串流
        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
        // * 將輸入串流用讀取緩衝物件控制
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // * 請求後的回傳資料
        String line = bufferedReader.readLine();
        // * 解析出來為可處理的字串
        // while ((line = bufferedReader.readLine()) != null) {
        // stringBuilder.append(line);
        // stringBuilder.append(System.getProperty("line.sparator"));
        // }
        // System.out.println(stringBuilder.toString());
        // ! 若回傳只有單一字串可直接取出
        System.out.println(line);
        // * 將JSON從字串解析為JSON物件
        JSONObject js = (JSONObject) new JSONParser().parse(line);
        System.out.printf("success: %s", js.get("success"));
    }
}
