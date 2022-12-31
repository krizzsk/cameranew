package com.pinguo.camera360.member;

import android.app.Dialog;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.user.event.DiscountCodeCheckResult;
import vStudio.Android.Camera360.R;
/* compiled from: MemberRightsActivity.kt */
/* loaded from: classes3.dex */
final class MemberRightsActivity$showDiscountCodeCheckDialog$2$1 extends Lambda implements kotlin.jvm.b.p<Boolean, String, kotlin.u> {
    final /* synthetic */ String $code;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ EditText $etRedeemCode;
    final /* synthetic */ AlertDialog $progressDialog;
    final /* synthetic */ TextView $tvRedeemCodeErrorHint;
    final /* synthetic */ MemberRightsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRightsActivity$showDiscountCodeCheckDialog$2$1(AlertDialog alertDialog, String str, MemberRightsActivity memberRightsActivity, EditText editText, Dialog dialog, TextView textView) {
        super(2);
        this.$progressDialog = alertDialog;
        this.$code = str;
        this.this$0 = memberRightsActivity;
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
        this.$progressDialog.dismiss();
        if (z) {
            us.pinguo.foundation.statistics.h.b.r(this.$code, "exchange_success");
            Toast makeText = Toast.makeText(this.this$0, (int) R.string.toast_coupon_check_success, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
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
            PGEventBus.getInstance().a(new DiscountCodeCheckResult(result));
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
