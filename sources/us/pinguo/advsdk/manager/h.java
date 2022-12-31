package us.pinguo.advsdk.manager;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;
import us.pinguo.advsdk.a.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PgAdvStatiticsManager.java */
/* loaded from: classes3.dex */
public class h implements o {
    o a;

    @Override // us.pinguo.advsdk.a.o
    public boolean a(String str) {
        o oVar = this.a;
        if (oVar == null) {
            return false;
        }
        return oVar.a(str);
    }

    @Override // us.pinguo.advsdk.a.o
    public String b() {
        o oVar = this.a;
        return oVar == null ? "" : oVar.b();
    }

    @Override // us.pinguo.advsdk.a.o
    public void c(String str, String str2, String str3, String str4, String str5) {
        o oVar = this.a;
        if (oVar == null) {
            return;
        }
        oVar.c(str, str2, str3, str4, str5);
    }

    @Override // us.pinguo.advsdk.a.o
    public boolean d() {
        o oVar = this.a;
        if (oVar == null) {
            return false;
        }
        return oVar.d();
    }

    @Override // us.pinguo.advsdk.a.o
    public void e(String str, String str2) {
        o oVar = this.a;
        if (oVar == null) {
            return;
        }
        oVar.e(str, str2);
    }

    @Override // us.pinguo.advsdk.a.o
    public void f(String str, Bundle bundle) {
        o oVar = this.a;
        if (oVar == null) {
            return;
        }
        oVar.f(str, bundle);
    }

    @Override // us.pinguo.advsdk.a.o
    public void g(o oVar) {
        if (this.a != null) {
            return;
        }
        this.a = oVar;
    }

    @Override // us.pinguo.advsdk.a.o
    public void h(String str, JSONObject jSONObject) {
        o oVar = this.a;
        if (oVar == null) {
            return;
        }
        oVar.h(str, jSONObject);
    }

    @Override // us.pinguo.advsdk.a.o
    public void i(Context context, int i2, String[] strArr) {
        new c(context, i2, strArr).execute();
    }
}
