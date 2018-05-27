package movies.com.androidmovieapp.service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movies.com.androidmovieapp.util.Properties;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieService {
    private Retrofit retrofit = null;

    Gson gson = new GsonBuilder().serializeNulls().create();
    public MovieDbApi getAPI() {

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Properties.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit.create(MovieDbApi.class);
    }
}
