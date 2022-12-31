package com.pinguo.camera360.member;

import kotlin.jvm.internal.Lambda;
/* compiled from: C360MemberRepository.kt */
/* loaded from: classes3.dex */
final class C360MemberRepository$syncVipExpireTimeFromServer$1 extends Lambda implements kotlin.jvm.b.p<Boolean, Exception, kotlin.u> {
    public static final C360MemberRepository$syncVipExpireTimeFromServer$1 INSTANCE = new C360MemberRepository$syncVipExpireTimeFromServer$1();

    C360MemberRepository$syncVipExpireTimeFromServer$1() {
        super(2);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, Exception exc) {
        invoke(bool.booleanValue(), exc);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, Exception exc) {
        if (exc != null) {
            us.pinguo.common.log.a.e(exc.getMessage(), new Object[0]);
        }
    }
}
