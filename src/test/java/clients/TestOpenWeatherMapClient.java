package clients;

import com.dawidrichert.clients.OpenWeatherMapClient;
import com.dawidrichert.models.CurrentWeatherData;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TestOpenWeatherMapClient extends Mockito {

    @Test
    public void getCurrentWeather_ShouldReturn_Null_When_CityNameIsIncorrect() {
        OpenWeatherMapClient openWeatherMapClient = new OpenWeatherMapClient();

        CurrentWeatherData data = openWeatherMapClient.getCurrentWeather("InvalidName");

        assertEquals(null, data);
    }
}
