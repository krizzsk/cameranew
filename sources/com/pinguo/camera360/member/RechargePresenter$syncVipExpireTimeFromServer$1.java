package com.pinguo.camera360.member;

import kotlin.jvm.internal.Lambda;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.user.event.PayClickEvent;
/* compiled from: RechargePresenter.kt */
/* loaded from: classes3.dex */
final class RechargePresenter$syncVipExpireTimeFromServer$1 extends Lambda implements kotlin.jvm.b.p<Boolean, Exception, kotlin.u> {
    public static final RechargePresenter$syncVipExpireTimeFromServer$1 INSTANCE = new RechargePresenter$syncVipExpireTimeFromServer$1();

    RechargePresenter$syncVipExpireTimeFromServer$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, Exception exc) {
        invoke(bool.booleanValue(), exc);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, Exception exc) {
        if (z) {
            PGEventBus.getInstance().a(new PayClickEvent(true));
        }
    }
}
