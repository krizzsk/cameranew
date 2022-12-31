package us.pinguo.edit2020.viewmodel.module;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.util.v;
/* compiled from: EditHistoryModule.kt */
/* loaded from: classes4.dex */
public final class e {
    private final String a;
    private final us.pinguo.edit2020.manager.c b;

    public e(List<HistoryRecord> list, int i2) {
        String file = us.pinguo.foundation.n.a.a(v.a(), "pgEditCache").toString();
        s.g(file, "getDiskCacheDir(UtilCont…IT_CACHE_NAME).toString()");
        this.a = file;
        this.b = new us.pinguo.edit2020.manager.c(file, list, i2);
    }

    public final us.pinguo.edit2020.manager.c a() {
        return this.b;
    }

    public final List<x> b() {
        return this.b.i();
    }

    public final boolean c() {
        return this.b.k();
    }
}
