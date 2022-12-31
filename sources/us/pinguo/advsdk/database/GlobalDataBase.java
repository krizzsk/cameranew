package us.pinguo.advsdk.database;

import android.content.Context;
import us.pinguo.advsdk.a.f;
/* loaded from: classes3.dex */
public class GlobalDataBase implements f {
    private Context a;

    public GlobalDataBase(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // us.pinguo.advsdk.a.f
    public int a(String str, int i2) {
        return GlobalProvider.d(this.a, str, i2);
    }

    @Override // us.pinguo.advsdk.a.f
    public String b(String str, String str2) {
        return GlobalProvider.f(this.a, str, str2);
    }

    @Override // us.pinguo.advsdk.a.f
    public void c(String str, long j2) {
        GlobalProvider.k(this.a, str, j2);
    }

    @Override // us.pinguo.advsdk.a.f
    public long d(String str, long j2) {
        return GlobalProvider.e(this.a, str, j2);
    }

    @Override // us.pinguo.advsdk.a.f
    public void e(String str, String str2) {
        GlobalProvider.l(this.a, str, str2);
    }
}
