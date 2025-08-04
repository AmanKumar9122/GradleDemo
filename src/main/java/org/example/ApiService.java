import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts/1") // You can change the path as needed
    Call<ResponseBody> getRawResponse();
}
