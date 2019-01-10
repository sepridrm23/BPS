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
    @POST("sdatapemerintahan.php")
    Call<Value<DataPemerintahan>> sdatapemerintahan(@Field("xkey") String xkey,
                                                    @Field("id") String id);

    @FormUrlEncoded
    @POST("sanggotadprd.php")
    Call<Value<AnggotaDPRD>> sanggotadprd(@Field("xkey") String xkey,
                                          @Field("id") String id);

    @FormUrlEncoded
    @POST("sanggotadewan.php")
    Call<Value<AnggotaDewan>> sanggotadewan(@Field("xkey") String xkey,
                                            @Field("id") String id);

    @FormUrlEncoded
    @POST("slapanganusaha.php")
    Call<Value<LapanganUsaha>> slapanganusaha(@Field("xkey") String xkey,
                                              @Field("id") String id);

    @FormUrlEncoded
    @POST("sdatapenduduk.php")
    Call<Value<DataPenduduk>> sdatapenduduk(@Field("xkey") String xkey,
                                            @Field("id") String id);

}