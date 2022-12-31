package us.pinguo.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import com.adjust.sdk.Constants;
/* loaded from: classes6.dex */
public class PushPreference {
    private SharedPreferences a;
    private SharedPreferences.Editor b;

    @TargetApi(11)
    public PushPreference(Context context) {
        this.a = null;
        this.b = null;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constants.PUSH, 4);
        this.a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public void a() {
        this.b.apply();
    }

    public int b(String str, int i2) {
        return this.a.getInt(str, i2);
    }

    public long c(String str, long j2) {
        return this.a.getLong(str, j2);
    }

    public String d(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void e(String str, boolean z) {
        this.b.putBoolean(str, z);
    }

    public void f(String str, int i2) {
        this.b.putInt(str, i2);
    }

    public void g(String str, long j2) {
        this.b.putLong(str, j2);
    }

    public void h(String str, String str2) {
        this.b.putString(str, str2);
    }
}
