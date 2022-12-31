package us.pinguo.admobvista;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advsdk.a.o;
/* loaded from: classes3.dex */
public class PGAdvStatitics implements o {
    private Context a;

    public PGAdvStatitics(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // us.pinguo.advsdk.a.o
    public boolean a(String str) {
        return false;
    }

    @Override // us.pinguo.advsdk.a.o
    public String b() {
        return "";
    }

    @Override // us.pinguo.advsdk.a.o
    public void c(String str, String str2, String str3, String str4, String str5) {
    }

    @Override // us.pinguo.advsdk.a.o
    public boolean d() {
        return false;
    }

    @Override // us.pinguo.advsdk.a.o
    public void e(String str, String str2) {
        AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(str, str2);
    }

    @Override // us.pinguo.advsdk.a.o
    public void f(String str, Bundle bundle) {
    }

    @Override // us.pinguo.advsdk.a.o
    public void g(o oVar) {
    }

    @Override // us.pinguo.advsdk.a.o
    public void h(String str, JSONObject jSONObject) {
    }

    @Override // us.pinguo.advsdk.a.o
    public void i(Context context, int i2, String[] strArr) {
    }
}
