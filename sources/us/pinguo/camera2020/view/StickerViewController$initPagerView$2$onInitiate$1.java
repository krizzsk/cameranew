package us.pinguo.camera2020.view;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: StickerViewController.kt */
/* loaded from: classes3.dex */
/* synthetic */ class StickerViewController$initPagerView$2$onInitiate$1 extends FunctionReferenceImpl implements kotlin.jvm.b.p<Integer, String, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerViewController$initPagerView$2$onInitiate$1(Object obj) {
        super(2, obj, StickerViewController.class, "handleStickerItemClicked", "handleStickerItemClicked(ILjava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, String str) {
        invoke(num.intValue(), str);
        return kotlin.u.a;
    }

    public final void invoke(int i2, String p1) {
        kotlin.jvm.internal.s.h(p1, "p1");
        ((StickerViewController) this.receiver).u(i2, p1);
    }
}
