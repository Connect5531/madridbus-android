package com.quoders.apps.madridbus.domain.network;

import com.quoders.apps.madridbus.model.rest.ListLineInfoEmt;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface EmtRestApi {

    /**
     * Get list of all Madrid Bus lines service
     *
     * @param idClient The user Id
     * @param passKey Password
     * @param SelectDate Date
     * @return Observable with  the line list object
     */
    @FormUrlEncoded
    @POST("/emt-proxy-server/last/bus/GetListLines.php")
    Observable<ListLineInfoEmt> getListLines(@Field("idClient") String idClient, @Field("passKey") String passKey, @Field("SelectDate") String SelectDate);

}

