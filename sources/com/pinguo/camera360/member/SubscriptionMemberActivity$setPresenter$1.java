package com.pinguo.camera360.member;

import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionMemberActivity.kt */
/* loaded from: classes3.dex */
public final class SubscriptionMemberActivity$setPresenter$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ SubscriptionMemberActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionMemberActivity$setPresenter$1(SubscriptionMemberActivity subscriptionMemberActivity) {
        super(1);
        this.this$0 = subscriptionMemberActivity;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        AutofitTextView autofitTextView;
        String str = z ? "sub_success" : "sub_failed";
        this.this$0.F0(str);
        this.this$0.C0(str);
        if (!z || (autofitTextView = (AutofitTextView) this.this$0._$_findCachedViewById(R.id.txtLimitedDiscount)) == null) {
            return;
        }
        autofitTextView.setVisibility(8);
        VdsAgent.onSetViewVisibility(autofitTextView, 8);
    }
}
