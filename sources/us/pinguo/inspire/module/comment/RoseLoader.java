package us.pinguo.inspire.module.comment;

import java.util.Random;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.inspire.Inspire;
/* compiled from: RoseLoader.kt */
/* loaded from: classes9.dex */
public final class RoseLoader {
    public static final RoseLoader INSTANCE = new RoseLoader();
    private static final String ROSE_URL = kotlin.jvm.internal.s.q(Inspire.f11205f, "/camera360/rec/list");
    private static int roseNum;

    private RoseLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshRose$lambda-0  reason: not valid java name */
    public static final RoseResp m160refreshRose$lambda0(RoseResp roseResp) {
        roseNum = roseResp.getRoseNum();
        return roseResp;
    }

    public final int getRoseNum() {
        return roseNum;
    }

    public final Observable<RoseResp> refreshRose() {
        Observable<RoseResp> observeOn = Observable.just(new RoseResp(new Random().nextInt(100))).map(o1.a).observeOn(AndroidSchedulers.mainThread());
        kotlin.jvm.internal.s.g(observeOn, "just(RoseResp(Random().n…dSchedulers.mainThread())");
        return observeOn;
    }

    public final void setRoseNum(int i2) {
        roseNum = i2;
    }
}
