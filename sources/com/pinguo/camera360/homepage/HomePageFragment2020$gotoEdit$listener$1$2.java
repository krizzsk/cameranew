package com.pinguo.camera360.homepage;

import android.net.Uri;
import kotlin.jvm.internal.Lambda;
/* compiled from: HomePageFragment2020.kt */
/* loaded from: classes3.dex */
final class HomePageFragment2020$gotoEdit$listener$1$2 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ HomePageFragment2020 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageFragment2020$gotoEdit$listener$1$2(HomePageFragment2020 homePageFragment2020) {
        super(0);
        this.this$0 = homePageFragment2020;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.pinguo.camera360.j.a.a(this.this$0.getActivity(), Uri.parse("app://camera360/edit"));
        us.pinguo.foundation.statistics.h.a.s();
    }
}
