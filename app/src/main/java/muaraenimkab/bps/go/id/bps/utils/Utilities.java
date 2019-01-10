package muaraenimkab.bps.go.id.bps.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.Random;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import muaraenimkab.bps.go.id.bps.models.User;
import okhttp3.OkHttpClient;

public class Utilities {
    private static String server = "http://www.mance.muaraenimkab.go.id/";

    public static String getBaseURLUser() {
        return server + "android/user/";
    }

    public static String getURLImageIklan() {
        return server + "wp/gambar_iklan/";
    }

//    public static void showAsToast(Context context, String text) {
//        if (context != null) {
//            if (mToast != null) mToast.cancel();
//            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
//            mToast.show();
//        }
//    }

//    public static String formatDatabaseTimeStamp(String tanggalKonfirmasi) {
//        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
//        Date testDate = null;
//        try {
//            testDate = sdf.parse(tanggalKonfirmasi);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        return formatter.format(testDate);
//    }

//    public static boolean isNetworkAvailable(Context context) {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        assert connectivityManager != null;
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }

    public static void setUser(Context context, User user) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString("xUser", json);
        prefsEditor.apply();
    }

    public static void signOutUser(Context context) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        prefsEditor.putBoolean("xLogin", false);
        prefsEditor.apply();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static User getUser(Context context) {
        if (isLogin(context)) {
            SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);

            Gson gson = new Gson();
            String json = mPrefs.getString("xUser", "");
            return gson.fromJson(json, User.class);
        } else {
            return new User();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void hideKeyboard(Activity context) {
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        Objects.requireNonNull(imm).toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
    }

    public static Boolean isLogin(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean("xLogin", false);
    }

    public static Boolean isFirstLaunch(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean("xFirstLaunch", false);
    }

    public static void setFirstLaunch(Context context) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        prefsEditor.putBoolean("xFirstLaunch", true);
        prefsEditor.apply();
    }

//    public static String getToken() {
//        String token = FirebaseInstanceId.getInstance().getToken();
//        if (token == null) {
//            token = "";
//        }
//        return token;
//    }

    public static String getArrayByteFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        //return stream.toByteArray();
        return Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT);
    }


    public static String getRandom(int x) {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwqyz";
        final int N = alphabet.length();
        Random r = new Random();
        StringBuilder alpha = new StringBuilder();
        for (int i = 0; i < x; i++) {
            alpha.append(alphabet.charAt(r.nextInt(N)));
        }
        return alpha.toString();
    }

    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @SuppressLint("BadHostnameVerifier")
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
