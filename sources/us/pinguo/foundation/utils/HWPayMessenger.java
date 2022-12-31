package us.pinguo.foundation.utils;

import rx.subjects.BehaviorSubject;
/* loaded from: classes4.dex */
public class HWPayMessenger {
    private BehaviorSubject<Boolean> a;

    /* loaded from: classes4.dex */
    private static class b {
        private static final HWPayMessenger a = new HWPayMessenger();
    }

    public static HWPayMessenger getInstance() {
        return b.a;
    }

    public void a() {
        this.a = null;
    }

    public BehaviorSubject<Boolean> b() {
        if (this.a == null) {
            this.a = BehaviorSubject.create();
        }
        return this.a;
    }

    private HWPayMessenger() {
    }
}
