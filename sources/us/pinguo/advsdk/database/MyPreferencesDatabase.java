package us.pinguo.advsdk.database;

import android.content.Context;
import android.content.SharedPreferences;
import us.pinguo.advsdk.a.f;
/* loaded from: classes3.dex */
public class MyPreferencesDatabase implements f {
    private SharedPreferences a;

    public MyPreferencesDatabase(Context context) {
        if (context != null) {
            this.a = context.getSharedPreferences("sdk_ad_pref", 0);
        }
    }

    @Override // us.pinguo.advsdk.a.f
    public int a(String str, int i2) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences == null ? i2 : sharedPreferences.getInt(str, i2);
    }

    @Override // us.pinguo.advsdk.a.f
    public String b(String str, String str2) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    @Override // us.pinguo.advsdk.a.f
    public void c(String str, long j2) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || str == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j2);
        edit.apply();
    }

    @Override // us.pinguo.advsdk.a.f
    public long d(String str, long j2) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences == null ? j2 : sharedPreferences.getLong(str, j2);
    }

    @Override // us.pinguo.advsdk.a.f
    public void e(String str, String str2) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null || str == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
