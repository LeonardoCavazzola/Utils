package utils.dotenv;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import utils.dotenv.DotenvScanner;

@Configuration
public class DotenvConfig implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        DotenvScanner.scanProperties("./.env");
    }
}
