package us.pinguo.inspire.model;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
/* compiled from: StickerWorksLoader.kt */
/* loaded from: classes9.dex */
public final class StickerWorksLoader {
    public static final StickerWorksLoader INSTANCE = new StickerWorksLoader();
    private static final String URL = kotlin.jvm.internal.s.q(Inspire.f11205f, "/camera360/work/stickerWork");

    private StickerWorksLoader() {
    }

    public final Observable<StickerWorks> loadWorks(String stickerId) {
        kotlin.jvm.internal.s.h(stickerId, "stickerId");
        Observable<StickerWorks> observeOn = us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<StickerWorks>>() { // from class: us.pinguo.inspire.model.StickerWorksLoader$loadWorks$request$1
        }.url(URL).put("stickerId", stickerId).build()).map(new Payload()).observeOn(AndroidSchedulers.mainThread());
        kotlin.jvm.internal.s.g(observeOn, "create<BaseResponse<Stic…dSchedulers.mainThread())");
        return observeOn;
    }
}
