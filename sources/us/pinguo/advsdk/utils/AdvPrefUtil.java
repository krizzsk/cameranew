package us.pinguo.advsdk.utils;

import android.content.Context;
import us.pinguo.advsdk.database.MyPreferencesDatabase;
/* loaded from: classes3.dex */
public class AdvPrefUtil {
    private static AdvPrefUtil b;
    private us.pinguo.advsdk.a.f a;

    private AdvPrefUtil() {
    }

    public static AdvPrefUtil getInstance() {
        if (b == null) {
            b = new AdvPrefUtil();
        }
        return b;
    }

    public int a(String str, int i2) {
        us.pinguo.advsdk.a.f fVar = this.a;
        return fVar == null ? i2 : fVar.a(str, i2);
    }

    public long b(String str) {
        us.pinguo.advsdk.a.f fVar = this.a;
        if (fVar == null) {
            return 0L;
        }
        return fVar.d(str, 0L);
    }

    public long c(String str, long j2) {
        us.pinguo.advsdk.a.f fVar = this.a;
        return fVar == null ? j2 : fVar.d(str, j2);
    }

    public String d(String str) {
        us.pinguo.advsdk.a.f fVar = this.a;
        return fVar == null ? "" : fVar.b(str, "");
    }

    public String e(String str, String str2) {
        us.pinguo.advsdk.a.f fVar = this.a;
        return fVar == null ? str2 : fVar.b(str, str2);
    }

    public void f(Context context) {
        if (this.a == null) {
            this.a = new MyPreferencesDatabase(context);
        }
    }

    public void g(String str, long j2) {
        us.pinguo.advsdk.a.f fVar = this.a;
        if (fVar == null) {
            return;
        }
        fVar.c(str, j2);
    }

    public void h(String str, String str2) {
        us.pinguo.advsdk.a.f fVar = this.a;
        if (fVar == null || str == null) {
            return;
        }
        fVar.e(str, str2);
    }
}
