package us.pinguo.advsdk.a;

import android.content.Context;
import java.util.Map;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: IPgSdkControl.java */
/* loaded from: classes3.dex */
public abstract class m {
    protected boolean a;
    protected Context b;

    public m(Context context, boolean z) {
        this.a = true;
        this.b = null;
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.a = z;
    }

    public abstract a a(AdsItem adsItem);

    public abstract String b();

    public abstract void c(Context context, Map<String, Object> map);

    public abstract void d(p pVar);

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.a;
    }

    public void g(p pVar) {
        if (pVar != null) {
            pVar.a(b());
        }
    }

    public void h(p pVar) {
        if (pVar != null) {
            pVar.b(b());
        }
    }
}
