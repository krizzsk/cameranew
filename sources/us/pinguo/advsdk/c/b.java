package us.pinguo.advsdk.c;

import android.app.Application;
import android.content.Context;
import java.util.Map;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGNativeControl.java */
/* loaded from: classes3.dex */
public class b extends m {
    public b(Application application, boolean z) {
        super(application, z);
    }

    @Override // us.pinguo.advsdk.a.m
    public us.pinguo.advsdk.a.a a(AdsItem adsItem) {
        return new c(adsItem);
    }

    @Override // us.pinguo.advsdk.a.m
    public String b() {
        return "0";
    }

    @Override // us.pinguo.advsdk.a.m
    public void c(Context context, Map<String, Object> map) {
    }

    @Override // us.pinguo.advsdk.a.m
    public void d(p pVar) {
        h(pVar);
    }

    @Override // us.pinguo.advsdk.a.m
    public boolean e() {
        return true;
    }
}
