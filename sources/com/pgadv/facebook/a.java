package com.pgadv.facebook;

import android.app.Application;
import android.content.Context;
import com.tapjoy.TapjoyConstants;
import d.g.d.d;
import java.util.Map;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGFBControl.java */
/* loaded from: classes3.dex */
public class a extends m {
    public a(Application application, boolean z) {
        super(application, z);
    }

    @Override // us.pinguo.advsdk.a.m
    public us.pinguo.advsdk.a.a a(AdsItem adsItem) {
        String str = adsItem.displayFormat;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    c = 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals(TapjoyConstants.TJC_PLUGIN_NATIVE)) {
                    c = 1;
                    break;
                }
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new d.g.c.b(adsItem, new d.g.b(true));
            case 1:
                return new c(adsItem, new d.g.b(true));
            case 2:
                return new d(adsItem, new d.g.b(false));
            default:
                return new c(adsItem, new d.g.b(true));
        }
    }

    @Override // us.pinguo.advsdk.a.m
    public String b() {
        return "1";
    }

    @Override // us.pinguo.advsdk.a.m
    public void c(Context context, Map<String, Object> map) {
    }

    @Override // us.pinguo.advsdk.a.m
    public void d(p pVar) {
        h(pVar);
        us.pinguo.advsdk.utils.b.a("facebook  init success");
    }

    @Override // us.pinguo.advsdk.a.m
    public boolean e() {
        return false;
    }
}
