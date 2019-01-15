package muaraenimkab.bps.go.id.bps.services;

import muaraenimkab.bps.go.id.bps.models.AnggotaDPRD;
import muaraenimkab.bps.go.id.bps.models.AnggotaDewan;
import muaraenimkab.bps.go.id.bps.models.DataPemerintahan;
import muaraenimkab.bps.go.id.bps.models.DataPenduduk;
import muaraenimkab.bps.go.id.bps.models.LapanganUsaha;
import muaraenimkab.bps.go.id.bps.models.Menu;
import muaraenimkab.bps.go.id.bps.models.Value;
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
    @POST("getdatapemerintahan.php")
    Call<Value<DataPemerintahan>> getdatapemerintahan(@Field("xkey") String xkey);

    @FormUrlEncoded
    @POST("getanggotadprd.php")
    Call<Value<AnggotaDPRD>> getanggotadprd(@Field("xkey") String xkey);

    @FormUrlEncoded
    @POST("getanggotadewan.php")
    Call<Value<AnggotaDewan>> getanggotadewan(@Field("xkey") String xkey);

    @FormUrlEncoded
    @POST("getlapanganusaha.php")
    Call<Value<LapanganUsaha>> getlapanganusaha(@Field("xkey") String xkey);

    @FormUrlEncoded
    @POST("getdatapenduduk.php")
    Call<Value<DataPenduduk>> getdatapenduduk(@Field("xkey") String xkey);

}