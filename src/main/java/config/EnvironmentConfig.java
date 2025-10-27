package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:environment.properties")
public interface EnvironmentConfig extends Config {
    @Key("homepage.url")
    String homepageUrl();

    @Key("ae.email")
    String aeEmail();

    @Key("ae.password")
    String aePassword();

    @Key("mock.first.name")
    String mockFirstName();

    @Key("mock.last.name")
    String mockLastName();

    @Key("mock.password")
    String mockPassword();

}
