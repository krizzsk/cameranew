package com.pinguo.camera360.member;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import vStudio.Android.Camera360.R;
/* compiled from: NewPayWallActivity.kt */
/* loaded from: classes3.dex */
final class NewPayWallActivity$sloganList$2 extends Lambda implements kotlin.jvm.b.a<ArrayList<String>> {
    final /* synthetic */ NewPayWallActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewPayWallActivity$sloganList$2(NewPayWallActivity newPayWallActivity) {
        super(0);
        this.this$0 = newPayWallActivity;
    }

    @Override // kotlin.jvm.b.a
    public final ArrayList<String> invoke() {
        ArrayList<String> f2;
        f2 = kotlin.collections.u.f(this.this$0.getString(R.string.pay_wall_tool_slogan), this.this$0.getString(R.string.pay_wall_filter_slogan), this.this$0.getString(R.string.pay_wall_portrait_slogan));
        return f2;
    }
}
