package us.pinguo.camera360.shop.data.m;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.show.y;
/* compiled from: UsedUnityLruCache.kt */
/* loaded from: classes4.dex */
public final class f extends e {
    public f(int i2) {
        super(i2);
    }

    @Override // us.pinguo.camera360.shop.data.m.e
    public void b(String key) {
        s.h(key, "key");
        d.a.c(key);
    }

    @Override // us.pinguo.camera360.shop.data.m.e
    public List<String> c() {
        List<String> b;
        String[] ASSETS_PKG_ZIP_IDS = y.f9660g;
        s.g(ASSETS_PKG_ZIP_IDS, "ASSETS_PKG_ZIP_IDS");
        b = m.b(ASSETS_PKG_ZIP_IDS);
        return b;
    }
}
