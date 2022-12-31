package com.pinguo.camera360.member;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.member.dialog.PayFailedSurveyDialog;
import com.tapjoy.TJAdUnitConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.ui.widget.AlphaPressedAutofitTextView;
import vStudio.Android.Camera360.R;
/* compiled from: SubscriptionResultActivity.kt */
/* loaded from: classes3.dex */
public final class SubscriptionResultActivity extends BaseActivity {
    public Map<Integer, View> a = new LinkedHashMap();
    private String b = "";
    private final String c = "sub_sales_page";

    /* renamed from: d  reason: collision with root package name */
    private PayFailedSurveyDialog f6909d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6910e;

    /* compiled from: SubscriptionResultActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements PayFailedSurveyDialog.a {
        a() {
        }

        @Override // com.pinguo.camera360.member.dialog.PayFailedSurveyDialog.a
        public void a() {
            us.pinguo.foundation.statistics.h.a.y0(SubscriptionResultActivity.this.b, SubscriptionResultActivity.this.r0(), TJAdUnitConstants.String.CLOSE);
            SubscriptionResultActivity.this.setResult(0);
            SubscriptionResultActivity.this.finish();
        }

        @Override // com.pinguo.camera360.member.dialog.PayFailedSurveyDialog.a
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(SubscriptionResultActivity this$0, Ref$ObjectRef action, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(action, "$action");
        us.pinguo.foundation.statistics.h.a.y0(this$0.b, this$0.c, (String) action.element);
        this$0.setResult(-1);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(SubscriptionResultActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (!this$0.f6910e && !us.pinguo.foundation.utils.i.c()) {
            PayFailedSurveyDialog payFailedSurveyDialog = this$0.f6909d;
            if (payFailedSurveyDialog != null) {
                payFailedSurveyDialog.show();
                this$0.f6910e = true;
                return;
            }
            kotlin.jvm.internal.s.z("payFailedSurveyDialog");
            throw null;
        }
        us.pinguo.foundation.statistics.h.a.y0(this$0.b, this$0.c, TJAdUnitConstants.String.CLOSE);
        this$0.setResult(0);
        this$0.finish();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        us.pinguo.foundation.statistics.h.a.y0(this.b, this.c, TJAdUnitConstants.String.CLOSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6909d = new PayFailedSurveyDialog(this);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = "";
        setContentView(R.layout.activity_subscription_result);
        PayFailedSurveyDialog payFailedSurveyDialog = this.f6909d;
        if (payFailedSurveyDialog != null) {
            payFailedSurveyDialog.h(new a());
            int i2 = R.id.btn_subs_result_try_again;
            ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubscriptionResultActivity.u0(SubscriptionResultActivity.this, ref$ObjectRef, view);
                }
            });
            int i3 = R.id.tv_try_later;
            ((AlphaPressedAutofitTextView) _$_findCachedViewById(i3)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubscriptionResultActivity.v0(SubscriptionResultActivity.this, view);
                }
            });
            int intExtra = getIntent().getIntExtra("subscription_status", 101);
            if (intExtra == 101) {
                ref$ObjectRef.element = "research";
                this.b = "success_popup";
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result)).setText(getString(R.string.act_subs_result_success));
                ((ImageView) _$_findCachedViewById(R.id.iv_subs_result)).setImageResource(R.drawable.img_subs_result_success);
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setBackground(getResources().getDrawable(R.drawable.shape_purple_button));
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.act_subs_continue));
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result_hint)).setText(getString(R.string.act_subs_result_success_hint));
                AlphaPressedAutofitTextView alphaPressedAutofitTextView = (AlphaPressedAutofitTextView) _$_findCachedViewById(i3);
                alphaPressedAutofitTextView.setVisibility(4);
                VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView, 4);
            } else if (intExtra == 102) {
                ref$ObjectRef.element = "try_again";
                this.b = "fail_popup";
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result)).setText(getString(R.string.act_subs_result_fail));
                ((ImageView) _$_findCachedViewById(R.id.iv_subs_result)).setImageResource(R.drawable.img_subs_result_fail);
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setBackground(getResources().getDrawable(R.drawable.drawable_member_btn_bg));
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.act_subs_try_again));
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result_hint)).setText(getString(R.string.act_subs_result_fail_hint));
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i3)).setText(getString(R.string.update_after));
                AlphaPressedAutofitTextView alphaPressedAutofitTextView2 = (AlphaPressedAutofitTextView) _$_findCachedViewById(i3);
                alphaPressedAutofitTextView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView2, 0);
            } else if (intExtra == 201) {
                ref$ObjectRef.element = "research";
                this.b = "success_popup";
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result)).setText(getString(R.string.act_subs_result_success));
                ((ImageView) _$_findCachedViewById(R.id.iv_subs_result)).setImageResource(R.drawable.img_subs_result_success);
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setBackground(getResources().getDrawable(R.drawable.shape_purple_button));
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.act_subs_continue));
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result_hint)).setText(getString(R.string.act_subs_result_success_hint));
                AlphaPressedAutofitTextView alphaPressedAutofitTextView3 = (AlphaPressedAutofitTextView) _$_findCachedViewById(i3);
                alphaPressedAutofitTextView3.setVisibility(4);
                VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView3, 4);
            } else if (intExtra == 202) {
                ref$ObjectRef.element = "try_again";
                this.b = "fail_popup";
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result)).setText(getString(R.string.act_subs_result_fail));
                ((ImageView) _$_findCachedViewById(R.id.iv_subs_result)).setImageResource(R.drawable.img_subs_result_fail);
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setBackground(getResources().getDrawable(R.drawable.drawable_member_btn_bg));
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.act_subs_try_again));
                ((TextView) _$_findCachedViewById(R.id.tv_subs_result_hint)).setText(getString(R.string.act_subs_result_fail_hint));
                ((AlphaPressedAutofitTextView) _$_findCachedViewById(i3)).setText(getString(R.string.update_after));
                AlphaPressedAutofitTextView alphaPressedAutofitTextView4 = (AlphaPressedAutofitTextView) _$_findCachedViewById(i3);
                alphaPressedAutofitTextView4.setVisibility(0);
                VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView4, 0);
            }
            us.pinguo.foundation.statistics.h.a.y0(this.b, this.c, "show");
            return;
        }
        kotlin.jvm.internal.s.z("payFailedSurveyDialog");
        throw null;
    }

    public final String r0() {
        return this.c;
    }
}
