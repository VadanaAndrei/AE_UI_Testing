package config;
import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    private static final EnvironmentConfig envConfig = ConfigFactory.create(EnvironmentConfig.class);
    private static final RunConfiguration runConfig = ConfigFactory.create(RunConfiguration.class);

    public static EnvironmentConfig environment() {
        return envConfig;
    }

    public static RunConfiguration run() {
        return runConfig;
    }
}
