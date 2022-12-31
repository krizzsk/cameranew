package us.pinguo.processor.k;

import kotlin.jvm.internal.s;
/* compiled from: IProcessorOldProxy.kt */
/* loaded from: classes6.dex */
public final class a implements c {
    @Override // us.pinguo.processor.k.c
    public boolean a(us.pinguo.processor.d makeInfo) {
        s.h(makeInfo, "makeInfo");
        return false;
    }

    @Override // us.pinguo.processor.k.c
    public void b() {
    }

    @Override // us.pinguo.processor.k.c
    public boolean c(String key) {
        s.h(key, "key");
        return false;
    }

    @Override // us.pinguo.processor.k.c
    public void d(byte[] jpg, us.pinguo.processor.d makeInfo, d callback) {
        s.h(jpg, "jpg");
        s.h(makeInfo, "makeInfo");
        s.h(callback, "callback");
        callback.a(null, null);
    }

    @Override // us.pinguo.processor.k.c
    public boolean e() {
        return false;
    }
}
