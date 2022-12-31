package us.pinguo.smaato;

import android.content.Context;
import java.util.Map;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGSmaatoControl.java */
/* loaded from: classes6.dex */
public class a extends m {
    private Context c;

    /* renamed from: d  reason: collision with root package name */
    private String f11972d;

    public a(Context context, boolean z, String str) {
        super(context, z);
        this.c = context;
        this.f11972d = str;
    }

    @Override // us.pinguo.advsdk.a.m
    public us.pinguo.advsdk.a.a a(AdsItem adsItem) {
        String str = adsItem.displayFormat;
        str.hashCode();
        if (!str.equals("interstitial")) {
            return new c(adsItem, this.f11972d);
        }
        return new us.pinguo.smaato.d.b(adsItem, this.f11972d);
    }

    @Override // us.pinguo.advsdk.a.m
    public String b() {
        return "35";
    }

    @Override // us.pinguo.advsdk.a.m
    public void c(Context context, Map<String, Object> map) {
    }

    @Override // us.pinguo.advsdk.a.m
    public void d(p pVar) {
        h(pVar);
    }
}
