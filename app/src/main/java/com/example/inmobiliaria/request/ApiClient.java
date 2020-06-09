package com.example.inmobiliaria.request;

import android.util.Log;

import com.example.inmobiliaria.modelos.ContratoAlquiler;
import com.example.inmobiliaria.modelos.Inmueble;
import com.example.inmobiliaria.modelos.Propietario;
import com.example.inmobiliaria.modelos.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH="http://192.168.0.16:45455/api/";
    private static  MyApiInterface myApiInteface;

    public static MyApiInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }

    public interface MyApiInterface {

        @POST("Propietario/login")
        Call<String> loginPropietario(@Body Usuario u);

        @GET("Propietario")
        Call<Propietario> obtenerPropietario(@Header("Authorization")String token);

        @GET("Inmueble")
        Call<List<Inmueble>> obtenerMisInmuebles(@Header("Authorization")String token);

        @PUT("Inmueble/{id}")
        Call<Inmueble> editarInmueble(@Header("Authorization")String token, @Path("id") int id, @Body Inmueble i);

        @PUT("Propietario/{id}")
        Call<Propietario> editarPropietario(@Header("Authorization")String token, @Path("id") int id, @Body Propietario p);

        @GET("ContratoAlquiler/{id}")
        Call<ContratoAlquiler>  obtenerContratoPorInmueble(@Header("Authorization")String token, @Path("id") int id);

        @DELETE("Inmueble/{id}")
        Call<String> borrarInmueble(@Header("Authorization")String token, @Path("id") int id);

        @POST("Inmueble")
        Call<Inmueble> agregarInmueble(@Header("Authorization")String token, @Body Inmueble inm);

    }

}
