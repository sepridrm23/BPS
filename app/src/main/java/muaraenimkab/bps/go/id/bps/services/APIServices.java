package muaraenimkab.bps.go.id.bps.services;

import muaraenimkab.bps.go.id.bps.models.AnggotaDPRD;
import muaraenimkab.bps.go.id.bps.models.AnggotaDewan;
import muaraenimkab.bps.go.id.bps.models.DataPenduduk;
import muaraenimkab.bps.go.id.bps.models.LapanganUsaha;
import muaraenimkab.bps.go.id.bps.models.Menu;
import muaraenimkab.bps.go.id.bps.models.Value;
import muaraenimkab.bps.go.id.bps.models.ValueArr;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServices {

    @FormUrlEncoded
    @POST("getmenu.php")
    Call<Value<Menu>> getmenu(@Field("xkey") String xkey);

    @FormUrlEncoded
    @POST("getsubmenu.php")
    Call<Value<Menu>> getsubmenu(@Field("xkey") String xkey,
                                 @Field("subid") String subid);

    @FormUrlEncoded
    @POST("getsearchsubmenu.php")
    Call<Value<Menu>> getsearchsubmenu(@Field("xkey") String xkey,
                                 @Field("search") String search);

    @FormUrlEncoded
    @POST("getdetail.php")
    Call<ValueArr> getdetail(@Field("xkey") String xkey,
                             @Field("id") String id);

    @FormUrlEncoded
    @POST("getpencarian.php")
    Call<ValueArr> getpencarian(@Field("xkey") String xkey,
                                @Field("id") String id,
                                @Field("spinner") String spinner,
                                @Field("edittext") String edittext);
//
//    @FormUrlEncoded
//    @POST("getdatapemerintahan.php")
//    Call<ValueArr> getdatapemerintahan(@Field("xkey") String xkey);

//    @FormUrlEncoded
//    @POST("getanggotadprd.php")
//    Call<Value<AnggotaDPRD>> getanggotadprd(@Field("xkey") String xkey);
//
//    @FormUrlEncoded
//    @POST("getanggotadewan.php")
//    Call<Value<AnggotaDewan>> getanggotadewan(@Field("xkey") String xkey);
//
//    @FormUrlEncoded
//    @POST("getlapanganusaha.php")
//    Call<Value<LapanganUsaha>> getlapanganusaha(@Field("xkey") String xkey);
//
//    @FormUrlEncoded
//    @POST("getdatapenduduk.php")
//    Call<Value<DataPenduduk>> getdatapenduduk(@Field("xkey") String xkey);

}