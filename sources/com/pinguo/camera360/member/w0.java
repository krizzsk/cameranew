package com.pinguo.camera360.member;

import android.app.Activity;
import com.pinguo.camera360.member.model.MemberPriceInfo;
/* compiled from: RechargeMvpContract.kt */
/* loaded from: classes3.dex */
public interface w0<RechargePresenter> extends a1<RechargePresenter> {

    /* compiled from: RechargeMvpContract.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <RechargePresenter> String a(w0<? super RechargePresenter> w0Var) {
            kotlin.jvm.internal.s.h(w0Var, "this");
            return null;
        }
    }

    void A(MemberPriceInfo memberPriceInfo);

    String b();

    Activity g();
}
