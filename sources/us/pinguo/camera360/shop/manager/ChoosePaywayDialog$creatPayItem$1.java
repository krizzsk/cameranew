package us.pinguo.camera360.shop.manager;

import kotlin.jvm.internal.FunctionReferenceImpl;
import us.pinguo.paylibcenter.PayHelp;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChoosePaywayDialog.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class ChoosePaywayDialog$creatPayItem$1 extends FunctionReferenceImpl implements kotlin.jvm.b.p<PayHelp.PAYWAY, String, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ChoosePaywayDialog$creatPayItem$1(Object obj) {
        super(2, obj, ChoosePaywayDialog.class, "clickEvent", "clickEvent(Lus/pinguo/paylibcenter/PayHelp$PAYWAY;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(PayHelp.PAYWAY payway, String str) {
        invoke2(payway, str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PayHelp.PAYWAY p0, String str) {
        kotlin.jvm.internal.s.h(p0, "p0");
        ((ChoosePaywayDialog) this.receiver).m(p0, str);
    }
}
