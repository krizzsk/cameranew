package com.pinguo.camera360.member;

import android.app.Dialog;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.ui.widget.AutofitTextView;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionMemberActivity.kt */
/* loaded from: classes3.dex */
public final class SubscriptionMemberActivity$showDiscountCodeCheckDialog$2$1 extends Lambda implements kotlin.jvm.b.p<Boolean, String, kotlin.u> {
    final /* synthetic */ String $code;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ EditText $etRedeemCode;
    final /* synthetic */ AlertDialog $progressDialog;
    final /* synthetic */ TextView $tvRedeemCodeErrorHint;
    final /* synthetic */ SubscriptionMemberActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionMemberActivity$showDiscountCodeCheckDialog$2$1(SubscriptionMemberActivity subscriptionMemberActivity, AlertDialog alertDialog, String str, EditText editText, Dialog dialog, TextView textView) {
        super(2);
        this.this$0 = subscriptionMemberActivity;
        this.$progressDialog = alertDialog;
        this.$code = str;
        this.$etRedeemCode = editText;
        this.$dialog = dialog;
        this.$tvRedeemCodeErrorHint = textView;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool, String str) {
        invoke(bool.booleanValue(), str);
        return kotlin.u.a;
    }

    public final void invoke(boolean z, String result) {
        kotlin.jvm.internal.s.h(result, "result");
        SubscriptionMemberActivity subscriptionMemberActivity = this.this$0;
        AlertDialog progressDialog = this.$progressDialog;
        kotlin.jvm.internal.s.g(progressDialog, "progressDialog");
        subscriptionMemberActivity.E0(progressDialog);
        if (z) {
            us.pinguo.foundation.statistics.h.b.r(this.$code, "exchange_success");
            us.pinguo.foundation.utils.k0.a.a(R.string.toast_coupon_check_success);
            AutofitTextView autofitTextView = (AutofitTextView) this.this$0._$_findCachedViewById(R.id.txtLimitedDiscount);
            if (autofitTextView != null) {
                autofitTextView.setVisibility(0);
                VdsAgent.onSetViewVisibility(autofitTextView, 0);
            }
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.txtSubtitleCoupon);
            if (textView != null) {
                textView.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView, 8);
            }
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(R.id.vDivider);
            if (imageView != null) {
                imageView.setVisibility(8);
                VdsAgent.onSetViewVisibility(imageView, 8);
            }
            Object systemService = this.this$0.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(this.$etRedeemCode.getWindowToken(), 0);
            this.$dialog.dismiss();
            this.this$0.Q();
            return;
        }
        TextView textView2 = this.$tvRedeemCodeErrorHint;
        if (textView2 != null) {
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
        }
        TextView textView3 = this.$tvRedeemCodeErrorHint;
        if (textView3 == null) {
            return;
        }
        textView3.setText(result);
    }
}
