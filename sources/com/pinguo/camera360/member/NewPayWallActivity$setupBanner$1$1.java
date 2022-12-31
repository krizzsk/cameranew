package com.pinguo.camera360.member;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import vStudio.Android.Camera360.R;
/* compiled from: NewPayWallActivity.kt */
/* loaded from: classes3.dex */
final class NewPayWallActivity$setupBanner$1$1 extends Lambda implements kotlin.jvm.b.l<us.pinguo.common.widget.banner2.c, kotlin.u> {
    final /* synthetic */ List<Integer> $list;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPayWallActivity$setupBanner$1$1(List<Integer> list) {
        super(1);
        this.$list = list;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.common.widget.banner2.c cVar) {
        invoke2(cVar);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.common.widget.banner2.c config) {
        kotlin.jvm.internal.s.h(config, "$this$config");
        b1 b1Var = new b1();
        b1Var.r(this.$list);
        config.f(b1Var);
        config.h(3000L);
        int a = us.pinguo.common.widget.i.a.a(20);
        config.g(new us.pinguo.common.widget.banner2.e(false, 9, 0, 0, -1, us.pinguo.edit2020.utils.d.h(R.color.primary_text_disabled_material_dark), us.pinguo.common.widget.i.a.a(8), 0, a, 141, null));
    }
}
