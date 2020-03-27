package com.example.ringersschool;



import com.example.ringersschool.Model.Student;
import com.example.ringersschool.Model.Students;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    /*@GET("detailsgoschi/{table}")
    Call<List<Check>> getAllPhotos(@Path("table") String path);

*/

    @GET("detailsgoschi/{table}")
    Call<List<Students>> getAllStudents(@Path("table") String path);

}
