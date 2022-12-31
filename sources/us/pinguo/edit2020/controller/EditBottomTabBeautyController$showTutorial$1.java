package us.pinguo.edit2020.controller;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$showTutorial$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$showTutorial$1(EditBottomTabBeautyController editBottomTabBeautyController) {
        super(0);
        this.this$0 = editBottomTabBeautyController;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context context = this.this$0.f10330i;
        if (context == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(context);
    }
}
