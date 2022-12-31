package us.pinguo.interaction;

import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
/* compiled from: MarketFilter.kt */
/* loaded from: classes4.dex */
public final class h0 {
    public static final h0 a = new h0();
    private static final boolean b = "VIVO应用商店".equals(us.pinguo.foundation.utils.i.a());
    private static Integer c;

    private h0() {
    }

    public final void a() {
        int c2 = c() + 1;
        c = Integer.valueOf(c2);
        CameraBusinessSettingModel.v().F("key_market_filter", c2);
    }

    public final boolean b() {
        return b && c() < 5;
    }

    public final int c() {
        Integer num = c;
        return num == null ? CameraBusinessSettingModel.v().n("key_market_filter", 0) : num.intValue();
    }

    public final void d() {
        c = 1;
        CameraBusinessSettingModel.v().F("key_market_filter", 1);
    }
}
