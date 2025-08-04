//package org.example;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//import java.io.IOException;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//
//        OkHttpClient client = new OkHttpClient(); // this library help us to make http calls easily.
//
//        String url = "https://fakestoreapi.com/products/1";
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        try(Response response = client.newCall(request).execute()) {
//            if(!response.isSuccessful()){
//                System.out.println("Something went wrong!!!");
//            }
//            System.out.println(response.body().string());
//        }catch(IOException ex){
//                ex.printStackTrace();
//        }
//    }
//}

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") // Base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<ResponseBody> call = api.getRawResponse();

        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                String responseData = response.body().string();
                System.out.println("Raw Response:\n" + responseData);
            } else {
                System.out.println("Request failed with status: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

