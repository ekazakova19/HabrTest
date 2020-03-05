package Helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CookieManager {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(CookieManager.class);
    private static final String FILE_PATH="Cookies.data";


    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }


    public void saveCookiesToFile(){
        try {
            File cookieFile = new File(FILE_PATH);
            if(cookieFile.exists()){
                cookieFile.delete();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(cookieFile));
            for (Cookie ck : driver.manage().getCookies()) {
                writer.write((ck.getName() + ";" + ck.getValue() + ";"
                        + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                writer.newLine();
            }
            writer.close();
            logger.info("Cookies has been written successfully {}",cookieFile.getPath());

        } catch (IOException e) {
            logger.warn("Not possible to write cookie due to error {} ", e);
            e.printStackTrace();
        }
    }

    public Set<Cookie> readCookiesFromFile(){
        Set<Cookie> cookies = new HashSet<>();
        try {
            File cookieFile = new File(FILE_PATH);
            if(cookieFile.exists()){
                BufferedReader reader = new BufferedReader(new FileReader(cookieFile));
                String line;
                while ((line = reader.readLine())!=null){
                    StringTokenizer token = new StringTokenizer(line,";");
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    String expirity = token.nextToken();
                    boolean isSecure = Boolean.valueOf(token.nextToken());
                    Cookie cookie = new Cookie(name,value,domain,path,null,isSecure);
                    cookies.add(cookie);
                }
            }
        } catch (IOException e) {
            logger.warn("Not possible to read cookie file due to error {} ", e);
            e.printStackTrace();
        }
        return cookies;
    }

    public void addCookiesToDriver(Set<Cookie> cookies){
        for(Cookie item : cookies){
            driver.manage().addCookie(item);
        }
    }
}
