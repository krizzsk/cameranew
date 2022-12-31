package com.pgadv.ironsource;

import android.content.Context;
import com.pgadv.ironsource.b.b;
import java.util.Map;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGIronSourceControl.java */
/* loaded from: classes3.dex */
public class a extends m {

    /* renamed from: d  reason: collision with root package name */
    public static String f5972d;
    Context c;

    public a(Context context, boolean z, String str) {
        super(context, z);
        this.c = context;
        f5972d = str;
    }

    @Override // us.pinguo.advsdk.a.m
    public us.pinguo.advsdk.a.a a(AdsItem adsItem) {
        String str = adsItem.displayFormat;
        str.hashCode();
        if (str.equals("interstitial")) {
            return new b(adsItem);
        }
        return null;
    }

    @Override // us.pinguo.advsdk.a.m
    public String b() {
        return "34";
    }

    @Override // us.pinguo.advsdk.a.m
    public void c(Context context, Map<String, Object> map) {
    }

    @Override // us.pinguo.advsdk.a.m
    public void d(p pVar) {
        h(pVar);
    }
}
