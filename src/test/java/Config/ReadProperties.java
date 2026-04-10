    package Config;

    import Utils.WebBasePage;
    import org.openqa.selenium.WebDriver;

    import java.io.*;
    import java.util.Properties;

    public class ReadProperties  {
        public Properties properties;

        private final String filePath = "src/test/java/Config/runConfig.properties";

        public ReadProperties() {
            BufferedReader reader;
            try {

              reader = new BufferedReader((new FileReader(filePath)));
              properties = new Properties();
              try{
                  properties.load(reader);
                  reader.close();
              }catch (FileNotFoundException e){
                  e.printStackTrace();
              }
            } catch (IOException e) {
                System.err.println("Exception occurred: " + e.getMessage());
            }
        }

        public String getWebUrl() {
            String url = properties.getProperty("webURL");
            if (url != null)
                return url;
            else
                throw new RuntimeException("web url not specified in the Configuration.properties file.");
        }
        public String getFEUrl() {
            String url = properties.getProperty("feURL");
            if (url != null)
                return url;
            else
                throw new RuntimeException("web url not specified in the Configuration.properties file.");
        }
        public String[] getAdminCredentials() {

            String user = properties.getProperty("userName");
            String password = properties.getProperty("passWord");

            if( (user != null) && (password != null)) {
                String credentials[] = new String[] {user,password};
                return credentials;
            }else
                throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

        public String[] getFrontendredentials() {

            String user = properties.getProperty("frontendUserName");
            String password = properties.getProperty("frontendPassWord");

            if( (user != null) && (password != null)) {
                String credentials[] = new String[] {user,password};
                return credentials;
            }else
                throw new RuntimeException("url not specified in the Configuration.properties file.");
        }

    }
