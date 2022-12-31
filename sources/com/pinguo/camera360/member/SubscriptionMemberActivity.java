package com.pinguo.camera360.member;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import com.pinguo.camera360.camera.options.OptionsWebviewActivity;
import com.pinguo.camera360.camera.peanut.view.VipTimeCountDownView;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.camera360.ui.view.VipItemProductView;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.camera360.vip.VipReemCodeInfo;
import com.zhy.android.percent.support.PercentRelativeLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.paylibcenter.OrderHelp;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.repository2020.abtest.ABTestManager;
import us.pinguo.repository2020.abtest.HWPriceTestManager;
import us.pinguo.repository2020.abtest.PriceAbTestManager;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* compiled from: SubscriptionMemberActivity.kt */
/* loaded from: classes3.dex */
public final class SubscriptionMemberActivity extends BaseToolbarActivity implements View.OnClickListener, y0<e1>, us.pinguo.foundation.statistics.e {

    /* renamed from: g  reason: collision with root package name */
    private boolean f6903g;

    /* renamed from: h  reason: collision with root package name */
    private x0 f6904h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6905i;

    /* renamed from: k  reason: collision with root package name */
    private us.pinguo.repository2020.abtest.g f6907k;

    /* renamed from: l  reason: collision with root package name */
    private SubscriptionRewardAdvController f6908l;
    private boolean m;
    private AnimatorSet n;
    private boolean p;
    private ArrayList<String> q;
    private TextView s;
    private View t;
    private AppCompatCheckBox u;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f6902f = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    private String f6906j = "yearly_vip_2399";
    private boolean o = true;
    private final b r = new b(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubscriptionMemberActivity.kt */
    /* loaded from: classes3.dex */
    public final class a extends ClickableSpan {
        private final String a;
        final /* synthetic */ SubscriptionMemberActivity b;

        public a(SubscriptionMemberActivity this$0, String mUrl) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(mUrl, "mUrl");
            this.b = this$0;
            this.a = mUrl;
        }

        @Override // android.text.style.ClickableSpan
        @Instrumented
        public void onClick(View widget) {
            VdsAgent.onClick(this, widget);
            kotlin.jvm.internal.s.h(widget, "widget");
            Intent intent = new Intent();
            intent.setClassName(us.pinguo.util.v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
            intent.putExtra("towhere", this.a);
            this.b.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.s.h(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(Color.argb(255, 21, 116, 255));
            ds.setUnderlineText(false);
        }
    }

    /* compiled from: SubscriptionMemberActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.s.h(msg, "msg");
            if (msg.what == 2449) {
                VipManager vipManager = VipManager.a;
                if (!vipManager.I() && vipManager.i() != 4 && com.pinguo.camera360.vip.e.a.a() && !HuaweiAgent.isHuaweiSupport()) {
                    SubscriptionMemberActivity.this.f6905i = true;
                }
                SubscriptionMemberActivity.this.Q();
            }
        }
    }

    /* compiled from: SubscriptionMemberActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c implements TextWatcher {
        final /* synthetic */ TextView a;

        c(TextView textView) {
            this.a = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextView textView = this.a;
            if (textView == null) {
                return;
            }
            textView.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView, 4);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(String str) {
        ArrayList<String> arrayList = this.q;
        if (arrayList == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.p(arrayList.get(0), str, arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7));
    }

    private final void D0() {
        VipManager vipManager = VipManager.a;
        if (vipManager.i() != 4 || System.currentTimeMillis() < vipManager.X()) {
            return;
        }
        vipManager.W(0);
        vipManager.V(false);
        vipManager.m();
        com.pinguo.camera360.adv.c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(AlertDialog alertDialog) {
        if (alertDialog.isShowing()) {
            Context context = alertDialog.getContext();
            kotlin.jvm.internal.s.g(context, "progressDialog.context");
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                alertDialog.dismiss();
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(String str) {
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("edit_stat_param");
        if (stringArrayListExtra == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.q(VipManager.a.I() ? "vip" : Constants.NORMAL, str, stringArrayListExtra.get(0), stringArrayListExtra.get(1), stringArrayListExtra.get(2), stringArrayListExtra.get(3), stringArrayListExtra.get(4), stringArrayListExtra.get(5), stringArrayListExtra.get(6), stringArrayListExtra.get(7), stringArrayListExtra.get(8), stringArrayListExtra.get(9), stringArrayListExtra.get(10), stringArrayListExtra.get(11), stringArrayListExtra.get(12), stringArrayListExtra.get(13), stringArrayListExtra.get(14), stringArrayListExtra.get(15), stringArrayListExtra.get(16), stringArrayListExtra.get(17), stringArrayListExtra.get(18), stringArrayListExtra.get(19), stringArrayListExtra.get(20), stringArrayListExtra.get(21), stringArrayListExtra.get(22), stringArrayListExtra.get(23), stringArrayListExtra.get(24), stringArrayListExtra.get(25), stringArrayListExtra.get(26), stringArrayListExtra.get(27), stringArrayListExtra.get(28), stringArrayListExtra.get(29), stringArrayListExtra.get(30), stringArrayListExtra.get(31));
    }

    private final String G0() {
        return this.m ? "camera" : us.pinguo.vip.proxy.c.a.b() ? "edit" : "vip_center";
    }

    private final boolean H0() {
        return us.pinguo.repository2020.abtest.i.a.b() && !VipManager.f(VipManager.a, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(SubscriptionMemberActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.d1();
    }

    private final void R0() {
        AlphaPressedConstraintLayout alphaPressedConstraintLayout = (AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte);
        alphaPressedConstraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout, 8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_camera360_vip));
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
        relativeLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(relativeLayout, 8);
        AutofitTextView autofitTextView = (AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip);
        autofitTextView.setVisibility(0);
        VdsAgent.onSetViewVisibility(autofitTextView, 0);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
        linearLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(linearLayout, 4);
        Y0();
    }

    private final void S0() {
        String string;
        boolean C;
        String str;
        boolean z;
        String string2;
        boolean C2;
        String v;
        TextView textView = this.s;
        if (textView != null) {
            String string3 = getResources().getString(R.string.pg_pay_auth_text);
            kotlin.jvm.internal.s.g(string3, "resources.getString(us.p….string.pg_pay_auth_text)");
            Resources resources = getResources();
            String str2 = (resources == null || (string = resources.getString(R.string.agreement_dialog_user_agreement)) == null) ? "" : string;
            C = StringsKt__StringsKt.C(string3, str2, false, 2, null);
            boolean z2 = true;
            if (C) {
                v = kotlin.text.t.v(string3, str2, "<a href='agreement' style='color:#4487F2'>" + str2 + "</a>", false, 4, null);
                str = v;
                z = true;
            } else {
                str = string3;
                z = false;
            }
            Resources resources2 = getResources();
            String str3 = (resources2 == null || (string2 = resources2.getString(R.string.agreement_dialog_privacy_policy)) == null) ? "" : string2;
            C2 = StringsKt__StringsKt.C(str, str3, false, 2, null);
            if (C2) {
                str = kotlin.text.t.v(str, str3, "<a href='privacy' style='color:#4487F2'>" + str3 + "</a>", false, 4, null);
            } else {
                z2 = z;
            }
            if (!z2) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.p0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubscriptionMemberActivity.T0(SubscriptionMemberActivity.this, view);
                    }
                });
                return;
            } else {
                W0(textView, str);
                return;
            }
        }
        kotlin.jvm.internal.s.z("mAgreementText");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(SubscriptionMemberActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Intent intent = new Intent();
        intent.setClassName(us.pinguo.util.v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
        intent.putExtra("towhere", "agreement");
        this$0.startActivity(intent);
    }

    private final void U0() {
        String string = getResources().getString(R.string.subscription_notice, "<a href='subscription_notice'>", "<a href='privacy'>", "</a>");
        kotlin.jvm.internal.s.g(string, "resources.getString(\n   …         \"</a>\"\n        )");
        int c2 = us.pinguo.foundation.utils.n0.c(12);
        int i2 = R.id.tv_subscr_notice;
        ViewGroup.LayoutParams layoutParams = ((AutofitTextView) _$_findCachedViewById(i2)).getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(c2, c2, c2, c2 * 2);
        ((AutofitTextView) _$_findCachedViewById(i2)).setLayoutParams(marginLayoutParams);
        AutofitTextView tv_subscr_notice = (AutofitTextView) _$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(tv_subscr_notice, "tv_subscr_notice");
        W0(tv_subscr_notice, string);
    }

    private final void W0(TextView textView, String str) {
        Spanned fromHtml = Html.fromHtml(str);
        Objects.requireNonNull(fromHtml, "null cannot be cast to non-null type android.text.Spannable");
        Spannable spannable = (Spannable) fromHtml;
        textView.setText(spannable);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            int i2 = 0;
            URLSpan[] urls = (URLSpan[]) spannable.getSpans(0, text.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            kotlin.jvm.internal.s.g(urls, "urls");
            int length = urls.length;
            while (i2 < length) {
                URLSpan uRLSpan = urls[i2];
                i2++;
                String url = uRLSpan.getURL();
                kotlin.jvm.internal.s.g(url, "url.url");
                spannableStringBuilder.setSpan(new a(this, url), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    private final void X0() {
        String v;
        String v2;
        String v3;
        String string = getResources().getString(R.string.vip_fun_item_text3);
        kotlin.jvm.internal.s.g(string, "resources.getString(R.string.vip_fun_item_text3)");
        v = kotlin.text.t.v(string, "100+", "<font color='#B499EE'>100+</font>", false, 4, null);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item3)).setText(Html.fromHtml(v));
        String string2 = getResources().getString(R.string.vip_fun_item_text4);
        kotlin.jvm.internal.s.g(string2, "resources.getString(R.string.vip_fun_item_text4)");
        v2 = kotlin.text.t.v(string2, "200+", "<font color='#B499EE'>200+</font>", false, 4, null);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item4)).setText(Html.fromHtml(v2));
        String string3 = getResources().getString(R.string.vip_fun_item_text5);
        kotlin.jvm.internal.s.g(string3, "resources.getString(R.string.vip_fun_item_text5)");
        v3 = kotlin.text.t.v(string3, "600+", "<font color='#B499EE'>600+</font>", false, 4, null);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item5)).setText(Html.fromHtml(v3));
    }

    private final void Y0() {
        String format;
        String str = this.f6906j;
        VipManager vipManager = VipManager.a;
        String x = vipManager.x();
        if (x != null) {
            this.f6906j = x;
        }
        if (us.pinguo.util.p.c() && us.pinguo.repository2020.abtest.j.a.c()) {
            String r = vipManager.r(str);
            String r2 = vipManager.r(this.f6906j);
            String a2 = com.pinguo.camera360.i.a.a(this.f6906j, r2);
            if (H0()) {
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                String string = getString(R.string.vip_for_month);
                kotlin.jvm.internal.s.g(string, "getString(R.string.vip_for_month)");
                String format2 = String.format(string, Arrays.copyOf(new Object[]{r}, 1));
                kotlin.jvm.internal.s.g(format2, "format(format, *args)");
                ((AutofitTextView) _$_findCachedViewById(R.id.tvAdPurchasePrice)).setText(format2);
            }
            if (kotlin.jvm.internal.s.c(str, this.f6906j)) {
                AutofitTextView autofitTextView = (AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub);
                if (kotlin.jvm.internal.s.c("$23.99", r2)) {
                    kotlin.jvm.internal.x xVar2 = kotlin.jvm.internal.x.a;
                    String string2 = getString(R.string.vip_gp_price);
                    kotlin.jvm.internal.s.g(string2, "getString(R.string.vip_gp_price)");
                    format = String.format(string2, Arrays.copyOf(new Object[]{r2, a2}, 2));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                } else {
                    kotlin.jvm.internal.x xVar3 = kotlin.jvm.internal.x.a;
                    String string3 = getString(R.string.pay_wall_price_month_after);
                    kotlin.jvm.internal.s.g(string3, "getString(R.string.pay_wall_price_month_after)");
                    format = String.format(string3, Arrays.copyOf(new Object[]{r2}, 1));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                }
                autofitTextView.setText(format);
                return;
            }
            kotlin.jvm.internal.x xVar4 = kotlin.jvm.internal.x.a;
            String string4 = getString(R.string.huawei_discount_price);
            kotlin.jvm.internal.s.g(string4, "getString(R.string.huawei_discount_price)");
            String format3 = String.format(string4, Arrays.copyOf(new Object[]{r, r2}, 2));
            kotlin.jvm.internal.s.g(format3, "format(format, *args)");
            int i2 = us.pinguo.user.util.n.i() ? 7 : 11;
            SpannableString spannableString = new SpannableString(format3);
            spannableString.setSpan(new StrikethroughSpan(), 0, i2, 33);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub)).setText(spannableString);
            return;
        }
        String r3 = vipManager.r(str);
        String a3 = com.pinguo.camera360.i.a.a(str, r3);
        if (kotlin.jvm.internal.s.c(str, this.f6906j)) {
            if (H0()) {
                kotlin.jvm.internal.x xVar5 = kotlin.jvm.internal.x.a;
                String string5 = getString(R.string.vip_for_2399);
                kotlin.jvm.internal.s.g(string5, "getString(R.string.vip_for_2399)");
                String format4 = String.format(string5, Arrays.copyOf(new Object[]{r3}, 1));
                kotlin.jvm.internal.s.g(format4, "format(format, *args)");
                ((AutofitTextView) _$_findCachedViewById(R.id.tvAdPurchasePrice)).setText(format4);
                return;
            }
            kotlin.jvm.internal.x xVar6 = kotlin.jvm.internal.x.a;
            String string6 = getString(R.string.vip_gp_price);
            kotlin.jvm.internal.s.g(string6, "getString(textRes)");
            String format5 = String.format(string6, Arrays.copyOf(new Object[]{r3, a3}, 2));
            kotlin.jvm.internal.s.g(format5, "format(format, *args)");
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub)).setText(format5);
            return;
        }
        String r4 = vipManager.r(this.f6906j);
        if (H0()) {
            kotlin.jvm.internal.x xVar7 = kotlin.jvm.internal.x.a;
            String string7 = getString(R.string.vip_for_2399);
            kotlin.jvm.internal.s.g(string7, "getString(R.string.vip_for_2399)");
            String format6 = String.format(string7, Arrays.copyOf(new Object[]{r4}, 1));
            kotlin.jvm.internal.s.g(format6, "format(format, *args)");
            ((AutofitTextView) _$_findCachedViewById(R.id.tvAdPurchasePrice)).setText(format6);
            return;
        }
        String r5 = vipManager.r(this.f6906j);
        kotlin.jvm.internal.x xVar8 = kotlin.jvm.internal.x.a;
        String string8 = getString(R.string.huawei_discount_price);
        kotlin.jvm.internal.s.g(string8, "getString(R.string.huawei_discount_price)");
        String format7 = String.format(string8, Arrays.copyOf(new Object[]{r3, r5}, 2));
        kotlin.jvm.internal.s.g(format7, "format(format, *args)");
        int i3 = us.pinguo.user.util.n.i() ? 7 : 11;
        SpannableString spannableString2 = new SpannableString(format7);
        spannableString2.setSpan(new StrikethroughSpan(), 0, i3, 33);
        ((AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub)).setText(spannableString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(SubscriptionMemberActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void a1() {
        View decorView;
        us.pinguo.foundation.statistics.h.b.r("", "click_exchange_entry");
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_vip_redeem_code);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.transparent));
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(o0.a);
        TextView textView = (TextView) dialog.findViewById(R.id.atvTitle);
        if (textView != null) {
            textView.setText(R.string.text_enter_discount_code);
        }
        final TextView textView2 = (TextView) dialog.findViewById(R.id.tvRedeemCodeErrorHint);
        final EditText editText = (EditText) dialog.findViewById(R.id.etRedeemCode);
        Button button = (Button) dialog.findViewById(R.id.btnComplete);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.n0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubscriptionMemberActivity.c1(editText, this, dialog, textView2, view);
                }
            });
        }
        if (editText != null) {
            editText.addTextChangedListener(new c(textView2));
        }
        if (isFinishing()) {
            return;
        }
        dialog.show();
        VdsAgent.showDialog(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(DialogInterface dialogInterface) {
        us.pinguo.foundation.statistics.h.b.r("", "user_close_exchange_view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(EditText editText, SubscriptionMemberActivity this$0, Dialog dialog, TextView textView, View view) {
        Editable editableText;
        String obj;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(dialog, "$dialog");
        String str = "";
        us.pinguo.foundation.statistics.h.b.r("", "click_exchange_btn");
        AlertDialog p = us.pinguo.foundation.utils.w.p(view.getContext(), -999);
        if (editText != null && (editableText = editText.getEditableText()) != null && (obj = editableText.toString()) != null) {
            str = obj;
        }
        x0 x0Var = this$0.f6904h;
        if (x0Var == null) {
            return;
        }
        x0Var.a(this$0.f6906j, str, new SubscriptionMemberActivity$showDiscountCodeCheckDialog$2$1(this$0, p, str, editText, dialog, textView));
    }

    private final void d1() {
        if (this.p) {
            return;
        }
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.n = null;
        AnimatorSet animatorSet2 = new AnimatorSet();
        int i2 = R.id.tv_subscr_7days_trial;
        ((AutofitTextView) _$_findCachedViewById(i2)).setScaleX(1.0f);
        ((AutofitTextView) _$_findCachedViewById(i2)).setScaleY(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item1), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item2), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item3), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item4), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item5), "alpha", 0.0f, 1.0f);
        int i3 = R.id.vip_fun_item6;
        ObjectAnimator ofFloat6 = ((TextView) _$_findCachedViewById(i3)).getVisibility() == 0 ? ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(i3), "alpha", 0.0f, 1.0f) : null;
        int i4 = R.id.vip_fun_item7;
        ObjectAnimator ofFloat7 = ((LinearLayout) _$_findCachedViewById(i4)).getVisibility() == 0 ? ObjectAnimator.ofFloat((LinearLayout) _$_findCachedViewById(i4), "alpha", 0.0f, 1.0f) : null;
        ValueAnimator ofFloat8 = ValueAnimator.ofFloat(1.0f, 1.12f, 1.0f);
        ofFloat8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pinguo.camera360.member.m0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubscriptionMemberActivity.e1(SubscriptionMemberActivity.this, valueAnimator);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(200L);
        ofFloat5.setDuration(200L);
        if (ofFloat6 != null) {
            ofFloat6.setDuration(200L);
        }
        if (ofFloat7 != null) {
            ofFloat7.setDuration(200L);
        }
        ofFloat8.setDuration(600L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        arrayList.add(ofFloat5);
        if (ofFloat6 != null) {
            arrayList.add(ofFloat6);
        }
        if (ofFloat7 != null) {
            arrayList.add(ofFloat7);
        }
        arrayList.add(ofFloat8);
        animatorSet2.playSequentially(arrayList);
        animatorSet2.start();
        this.n = animatorSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(SubscriptionMemberActivity this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.tv_subscr_7days_trial;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        ((AutofitTextView) this$0._$_findCachedViewById(i2)).setScaleX(((Float) animatedValue).floatValue());
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        ((AutofitTextView) this$0._$_findCachedViewById(i2)).setScaleY(((Float) animatedValue2).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(SubscriptionMemberActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.monthly;
        ((VipItemProductView) this$0._$_findCachedViewById(i2)).setChecked(true);
        ((VipItemProductView) this$0._$_findCachedViewById(R.id.years)).setChecked(false);
        if (((VipItemProductView) this$0._$_findCachedViewById(i2)).g() != null) {
            VipItemProductView vipItemProductView = (VipItemProductView) this$0._$_findCachedViewById(i2);
            String g2 = vipItemProductView == null ? null : vipItemProductView.g();
            kotlin.jvm.internal.s.e(g2);
            this$0.f6906j = g2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(SubscriptionMemberActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ((VipItemProductView) this$0._$_findCachedViewById(R.id.monthly)).setChecked(false);
        int i2 = R.id.years;
        ((VipItemProductView) this$0._$_findCachedViewById(i2)).setChecked(true);
        if (((VipItemProductView) this$0._$_findCachedViewById(i2)).g() != null) {
            VipItemProductView vipItemProductView = (VipItemProductView) this$0._$_findCachedViewById(i2);
            String g2 = vipItemProductView == null ? null : vipItemProductView.g();
            kotlin.jvm.internal.s.e(g2);
            this$0.f6906j = g2;
        }
    }

    private final void initView() {
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte)).setOnClickListener(this);
        ((CardView) _$_findCachedViewById(R.id.txt_buy_VIP)).setOnClickListener(this);
        ((CardView) _$_findCachedViewById(R.id.txt_update_to_vip_free)).setOnClickListener(this);
        ((TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setMaxTextSize(30.0f);
        ((AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip)).setMaxTextSize(16.0f);
        X0();
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return this.f6903g ? "vip_center_page" : "vip_free_trial_page";
    }

    @Override // com.pinguo.camera360.member.y0
    public void Q() {
        String a2;
        CharSequence charSequence;
        String v;
        String v2;
        VipManager vipManager = VipManager.a;
        if (vipManager.i() == 4) {
            setResult(-1);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
            AlphaPressedConstraintLayout alphaPressedConstraintLayout = (AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte);
            alphaPressedConstraintLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout, 0);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subscr_7days_trial)).setText(getString(R.string.go_on));
            AutofitTextView autofitTextView = (AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip);
            autofitTextView.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView, 8);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
            relativeLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(relativeLayout, 0);
            int i2 = R.id.view_vip_count_down;
            ((VipTimeCountDownView) _$_findCachedViewById(i2)).setCellBackground(R.drawable.time_count_down_bg_dark);
            ((VipTimeCountDownView) _$_findCachedViewById(i2)).setCellWidth(us.pinguo.foundation.t.b.a.c(this, 17.0f));
            ((VipTimeCountDownView) _$_findCachedViewById(i2)).setDotDrawable(R.drawable.time_count_down_dot_white);
            ((VipTimeCountDownView) _$_findCachedViewById(i2)).setDotSize(new Pair<>(Float.valueOf(us.pinguo.foundation.t.b.a.c(this, 2.0f)), Float.valueOf(us.pinguo.foundation.t.b.a.c(this, 8.0f))));
            ((VipTimeCountDownView) _$_findCachedViewById(i2)).setNumTextTypeSize(us.pinguo.foundation.t.b.a.q(this, 16.0f));
            ((VipTimeCountDownView) _$_findCachedViewById(i2)).setRemainingTimeInMillis(vipManager.X() - System.currentTimeMillis());
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout, 4);
            Y0();
        } else if (vipManager.F()) {
            setResult(-1);
            int i3 = R.id.tlbtn_subscripte;
            AlphaPressedConstraintLayout alphaPressedConstraintLayout2 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i3);
            alphaPressedConstraintLayout2.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout2, 0);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
            constraintLayout2.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout2, 8);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subscr_7days_trial)).setText(getString(R.string.act_subs_free_trial_7days));
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_vip_hello));
            AlphaPressedConstraintLayout alphaPressedConstraintLayout3 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i3);
            alphaPressedConstraintLayout3.setVisibility(8);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout3, 8);
            AutofitTextView autofitTextView2 = (AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub);
            autofitTextView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView2, 8);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getString(R.string.date_format_pattern));
            VipReemCodeInfo s = vipManager.s();
            String format = simpleDateFormat.format(new Date((s == null ? 0.0f : s.getExpireTime()) * ((float) 1000)));
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
            relativeLayout2.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout2, 8);
            int i4 = R.id.tv_subs_vip_descrip;
            AutofitTextView autofitTextView3 = (AutofitTextView) _$_findCachedViewById(i4);
            autofitTextView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView3, 0);
            ((AutofitTextView) _$_findCachedViewById(i4)).setText(kotlin.jvm.internal.s.q(format, getString(R.string.out_date)));
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout2.setVisibility(0);
            VdsAgent.onSetViewVisibility(linearLayout2, 0);
        } else if (vipManager.D()) {
            setResult(-1);
            int i5 = R.id.tlbtn_subscripte;
            AlphaPressedConstraintLayout alphaPressedConstraintLayout4 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i5);
            alphaPressedConstraintLayout4.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout4, 0);
            ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
            constraintLayout3.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout3, 8);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subscr_7days_trial)).setText(getString(R.string.act_subs_free_trial_7days));
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_vip_hello));
            AlphaPressedConstraintLayout alphaPressedConstraintLayout5 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i5);
            alphaPressedConstraintLayout5.setVisibility(8);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout5, 8);
            AutofitTextView autofitTextView4 = (AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub);
            autofitTextView4.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView4, 8);
            String format2 = new SimpleDateFormat(getString(R.string.date_format_pattern)).format(new Date(us.pinguo.user.y0.g(this).b * 1000));
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
            relativeLayout3.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout3, 8);
            int i6 = R.id.tv_subs_vip_descrip;
            AutofitTextView autofitTextView5 = (AutofitTextView) _$_findCachedViewById(i6);
            autofitTextView5.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView5, 0);
            ((AutofitTextView) _$_findCachedViewById(i6)).setText(kotlin.jvm.internal.s.q(format2, getString(R.string.out_date)));
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout3.setVisibility(0);
            VdsAgent.onSetViewVisibility(linearLayout3, 0);
        } else if (vipManager.I()) {
            setResult(-1);
            int i7 = R.id.tlbtn_subscripte;
            AlphaPressedConstraintLayout alphaPressedConstraintLayout6 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i7);
            alphaPressedConstraintLayout6.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout6, 0);
            ConstraintLayout constraintLayout4 = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
            constraintLayout4.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout4, 8);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subscr_7days_trial)).setText(getString(R.string.act_subs_free_trial_7days));
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_vip_hello));
            AlphaPressedConstraintLayout alphaPressedConstraintLayout7 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i7);
            alphaPressedConstraintLayout7.setVisibility(8);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout7, 8);
            AutofitTextView autofitTextView6 = (AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub);
            autofitTextView6.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView6, 8);
            String format3 = new SimpleDateFormat(getString(R.string.date_format_pattern)).format(new Date(vipManager.z()));
            int currentTimeMillis = (int) (((System.currentTimeMillis() - vipManager.z()) / AdvTimeUtils.MILLIS_OF_A_DAY) + 1);
            RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
            relativeLayout4.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout4, 8);
            int i8 = R.id.tv_subs_vip_descrip;
            AutofitTextView autofitTextView7 = (AutofitTextView) _$_findCachedViewById(i8);
            autofitTextView7.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView7, 0);
            StringBuilder sb = new StringBuilder();
            kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
            String string = getString(R.string.text_open_subscr);
            kotlin.jvm.internal.s.g(string, "getString(R.string.text_open_subscr)");
            String format4 = String.format(string, Arrays.copyOf(new Object[]{format3}, 1));
            kotlin.jvm.internal.s.g(format4, "format(format, *args)");
            sb.append(format4);
            sb.append(" (");
            String quantityString = getResources().getQuantityString(R.plurals.text_become_member_days, currentTimeMillis);
            kotlin.jvm.internal.s.g(quantityString, "resources.getQuantityStr…become_member_days, days)");
            String format5 = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(currentTimeMillis)}, 1));
            kotlin.jvm.internal.s.g(format5, "format(format, *args)");
            sb.append(format5);
            sb.append(") ");
            ((AutofitTextView) _$_findCachedViewById(i8)).setText(sb.toString());
            LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout4.setVisibility(0);
            VdsAgent.onSetViewVisibility(linearLayout4, 0);
        } else if (this.f6905i) {
            AlphaPressedConstraintLayout alphaPressedConstraintLayout8 = (AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte);
            alphaPressedConstraintLayout8.setVisibility(8);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout8, 8);
            ConstraintLayout constraintLayout5 = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
            constraintLayout5.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout5, 0);
            Y0();
            RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
            relativeLayout5.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout5, 8);
            AutofitTextView autofitTextView8 = (AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip);
            autofitTextView8.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView8, 0);
            LinearLayout linearLayout5 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout5.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout5, 4);
        } else if (HuaweiAgent.isHuaweiSupport()) {
            String o = ABTestManager.a.o("huawei_vip_sub_pcr_test");
            int i9 = R.id.tv_subscr_7days_trial;
            ViewGroup.LayoutParams layoutParams = ((AutofitTextView) _$_findCachedViewById(i9)).getLayoutParams();
            kotlin.jvm.internal.s.g(layoutParams, "tv_subscr_7days_trial.layoutParams");
            String x = vipManager.x();
            if ((x == null || x.length() == 0) && kotlin.jvm.internal.s.c("VIP_page_word_month_year", o)) {
                int i10 = R.id.monthly;
                ViewGroup.LayoutParams layoutParams2 = ((VipItemProductView) _$_findCachedViewById(i10)).getLayoutParams();
                kotlin.jvm.internal.s.g(layoutParams2, "monthly.layoutParams");
                int i11 = R.id.years;
                ViewGroup.LayoutParams layoutParams3 = ((VipItemProductView) _$_findCachedViewById(i11)).getLayoutParams();
                kotlin.jvm.internal.s.g(layoutParams3, "years.layoutParams");
                layoutParams2.height = us.pinguo.foundation.t.b.a.a(this, us.pinguo.foundation.t.b.a.n(this, layoutParams2.width) * 1.2f);
                layoutParams3.height = us.pinguo.foundation.t.b.a.a(this, us.pinguo.foundation.t.b.a.n(this, layoutParams3.width) * 1.2f);
                ((VipItemProductView) _$_findCachedViewById(i10)).setLayoutParams(layoutParams2);
                ((VipItemProductView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams3);
                layoutParams.height = us.pinguo.foundation.t.b.a.a(this, 36.0f);
                ((AutofitTextView) _$_findCachedViewById(i9)).setLayoutParams(layoutParams);
                List<PayHelp.l> v3 = vipManager.v();
                if (v3 != null) {
                    for (PayHelp.l lVar : v3) {
                        if (kotlin.jvm.internal.s.c("c360_vip_subs_monthly", lVar.a)) {
                            int i12 = R.id.monthly;
                            String string2 = getResources().getString(R.string.vip_product_monthly);
                            kotlin.jvm.internal.s.g(string2, "resources.getString(R.string.vip_product_monthly)");
                            ((VipItemProductView) _$_findCachedViewById(i12)).setTitle(string2);
                            String str = lVar.b;
                            kotlin.jvm.internal.s.g(str, "it.price");
                            v2 = kotlin.text.t.v(str, ".00", "", false, 4, null);
                            ((VipItemProductView) _$_findCachedViewById(i12)).setPrice(v2);
                            String string3 = getResources().getString(R.string.mothly);
                            kotlin.jvm.internal.s.g(string3, "resources.getString(R.string.mothly)");
                            ((VipItemProductView) _$_findCachedViewById(i12)).setDuration(string3);
                            ((VipItemProductView) _$_findCachedViewById(i12)).h();
                            ((VipItemProductView) _$_findCachedViewById(i12)).setProductId(lVar.a);
                        }
                        if (kotlin.jvm.internal.s.c("yearly_vip_2399", lVar.a)) {
                            int i13 = R.id.years;
                            String string4 = getResources().getString(R.string.vip_product_years);
                            kotlin.jvm.internal.s.g(string4, "resources.getString(R.string.vip_product_years)");
                            ((VipItemProductView) _$_findCachedViewById(i13)).setTitle(string4);
                            String string5 = getResources().getString(R.string.discount);
                            kotlin.jvm.internal.s.g(string5, "resources.getString(R.string.discount)");
                            ((VipItemProductView) _$_findCachedViewById(i13)).setDiscount(string5);
                            String str2 = lVar.b;
                            kotlin.jvm.internal.s.g(str2, "it.price");
                            v = kotlin.text.t.v(str2, ".00", "", false, 4, null);
                            ((VipItemProductView) _$_findCachedViewById(i13)).setPrice(v);
                            String string6 = getResources().getString(R.string.years);
                            kotlin.jvm.internal.s.g(string6, "resources.getString(R.string.years)");
                            ((VipItemProductView) _$_findCachedViewById(i13)).setDuration(string6);
                            ((VipItemProductView) _$_findCachedViewById(i13)).setProductId(lVar.a);
                        }
                    }
                } else {
                    String string7 = getResources().getString(R.string.vip_product_monthly);
                    kotlin.jvm.internal.s.g(string7, "resources.getString(R.string.vip_product_monthly)");
                    ((VipItemProductView) _$_findCachedViewById(i10)).setTitle(string7);
                    String string8 = getResources().getString(R.string.vip_mothly_price);
                    kotlin.jvm.internal.s.g(string8, "resources.getString(R.string.vip_mothly_price)");
                    ((VipItemProductView) _$_findCachedViewById(i10)).setPrice(string8);
                    String string9 = getResources().getString(R.string.mothly);
                    kotlin.jvm.internal.s.g(string9, "resources.getString(R.string.mothly)");
                    ((VipItemProductView) _$_findCachedViewById(i10)).setDuration(string9);
                    ((VipItemProductView) _$_findCachedViewById(i10)).h();
                    ((VipItemProductView) _$_findCachedViewById(i10)).setProductId("c360_vip_subs_monthly");
                    String string10 = getResources().getString(R.string.vip_product_years);
                    kotlin.jvm.internal.s.g(string10, "resources.getString(R.string.vip_product_years)");
                    ((VipItemProductView) _$_findCachedViewById(i11)).setTitle(string10);
                    String string11 = getResources().getString(R.string.discount);
                    kotlin.jvm.internal.s.g(string11, "resources.getString(R.string.discount)");
                    ((VipItemProductView) _$_findCachedViewById(i11)).setDiscount(string11);
                    String string12 = getResources().getString(R.string.vip_years_price);
                    kotlin.jvm.internal.s.g(string12, "resources.getString(R.string.vip_years_price)");
                    ((VipItemProductView) _$_findCachedViewById(i11)).setPrice(string12);
                    String string13 = getResources().getString(R.string.years);
                    kotlin.jvm.internal.s.g(string13, "resources.getString(R.string.years)");
                    ((VipItemProductView) _$_findCachedViewById(i11)).setDuration(string13);
                    ((VipItemProductView) _$_findCachedViewById(i11)).setProductId("yearly_vip_2399");
                }
                int i14 = R.id.years;
                ((VipItemProductView) _$_findCachedViewById(i14)).setChecked(true);
                ((VipItemProductView) _$_findCachedViewById(R.id.monthly)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.q0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubscriptionMemberActivity.f1(SubscriptionMemberActivity.this, view);
                    }
                });
                ((VipItemProductView) _$_findCachedViewById(i14)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.l0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubscriptionMemberActivity.g1(SubscriptionMemberActivity.this, view);
                    }
                });
                AutofitTextView autofitTextView9 = (AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub);
                autofitTextView9.setVisibility(8);
                VdsAgent.onSetViewVisibility(autofitTextView9, 8);
                LinearLayout linearLayout6 = (LinearLayout) _$_findCachedViewById(R.id.vip_product_item_layout);
                linearLayout6.setVisibility(0);
                VdsAgent.onSetViewVisibility(linearLayout6, 0);
            } else {
                int i15 = R.id.tv_sub_after_7d_auto_sub;
                AutofitTextView autofitTextView10 = (AutofitTextView) _$_findCachedViewById(i15);
                autofitTextView10.setVisibility(0);
                VdsAgent.onSetViewVisibility(autofitTextView10, 0);
                LinearLayout linearLayout7 = (LinearLayout) _$_findCachedViewById(R.id.vip_product_item_layout);
                linearLayout7.setVisibility(8);
                VdsAgent.onSetViewVisibility(linearLayout7, 8);
                layoutParams.height = us.pinguo.foundation.t.b.a.a(this, 48.0f);
                ((AutofitTextView) _$_findCachedViewById(i9)).setLayoutParams(layoutParams);
                if (x == null || x.length() == 0) {
                    t0 t0Var = t0.a;
                    if (t0Var.d()) {
                        RechargeGoodsDiscountInfo b2 = t0Var.b();
                        if (b2 != null) {
                            this.f6906j = "yearly_vip_2399";
                            kotlin.jvm.internal.x xVar2 = kotlin.jvm.internal.x.a;
                            String string14 = getString(R.string.huawei_discount_price);
                            kotlin.jvm.internal.s.g(string14, "getString(R.string.huawei_discount_price)");
                            String format6 = String.format(string14, Arrays.copyOf(new Object[]{b2.getOriginalPrice(), b2.getPrice()}, 2));
                            kotlin.jvm.internal.s.g(format6, "format(format, *args)");
                            int i16 = us.pinguo.user.util.n.i() ? 7 : 11;
                            SpannableString spannableString = new SpannableString(format6);
                            spannableString.setSpan(new StrikethroughSpan(), 0, i16, 33);
                            ((AutofitTextView) _$_findCachedViewById(i15)).setText(spannableString);
                            kotlin.u uVar = kotlin.u.a;
                        }
                    }
                }
                String a3 = HWPriceTestManager.a.a();
                String str3 = a3 != null ? a3 : "yearly_vip_2399";
                if (x == null || x.length() == 0) {
                    x = str3;
                }
                this.f6906j = x;
                us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("hw product id==>", x), new Object[0]);
                String str4 = null;
                String str5 = null;
                if (vipManager.v() != null) {
                    for (PayHelp.l lVar2 : vipManager.v()) {
                        us.pinguo.common.log.a.k("hw price===>" + ((Object) lVar2.b) + "====>" + ((Object) lVar2.a), new Object[0]);
                        if (kotlin.jvm.internal.s.c(str3, lVar2.a)) {
                            str4 = lVar2.b;
                        }
                        if (kotlin.jvm.internal.s.c(this.f6906j, lVar2.a)) {
                            str5 = lVar2.b;
                        }
                    }
                }
                if (str5 == null || str5.length() == 0) {
                    str5 = VipManager.a.w();
                }
                if (kotlin.jvm.internal.s.c(str3, this.f6906j)) {
                    kotlin.jvm.internal.x xVar3 = kotlin.jvm.internal.x.a;
                    String string15 = getString(R.string.vip_for_2399);
                    kotlin.jvm.internal.s.g(string15, "getString(R.string.vip_for_2399)");
                    charSequence = String.format(string15, Arrays.copyOf(new Object[]{str5}, 1));
                    kotlin.jvm.internal.s.g(charSequence, "format(format, *args)");
                } else {
                    kotlin.jvm.internal.x xVar4 = kotlin.jvm.internal.x.a;
                    String string16 = getString(R.string.huawei_discount_price);
                    kotlin.jvm.internal.s.g(string16, "getString(R.string.huawei_discount_price)");
                    String format7 = String.format(string16, Arrays.copyOf(new Object[]{str4, str5}, 2));
                    kotlin.jvm.internal.s.g(format7, "format(format, *args)");
                    int i17 = us.pinguo.user.util.n.i() ? 7 : 11;
                    SpannableString spannableString2 = new SpannableString(format7);
                    spannableString2.setSpan(new StrikethroughSpan(), 0, i17, 33);
                    charSequence = spannableString2;
                }
                ((AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub)).setText(charSequence);
            }
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subscr_7days_trial)).setText(getString(R.string.go_on));
            RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
            relativeLayout6.setVisibility(8);
            VdsAgent.onSetViewVisibility(relativeLayout6, 8);
            LinearLayout linearLayout8 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout8.setVisibility(8);
            VdsAgent.onSetViewVisibility(linearLayout8, 8);
            AutofitTextView autofitTextView11 = (AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip);
            autofitTextView11.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView11, 0);
            int i18 = R.id.tlbtn_subscripte;
            AlphaPressedConstraintLayout alphaPressedConstraintLayout9 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i18);
            alphaPressedConstraintLayout9.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout9, 0);
            ConstraintLayout constraintLayout6 = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
            constraintLayout6.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout6, 8);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_camera360_vip));
            AlphaPressedConstraintLayout alphaPressedConstraintLayout10 = (AlphaPressedConstraintLayout) _$_findCachedViewById(i18);
            alphaPressedConstraintLayout10.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout10, 0);
        } else {
            this.f6907k = PriceAbTestManager.a.g();
            String str6 = "yearly_vip_2399_3dayfree";
            if (us.pinguo.util.p.c()) {
                str6 = us.pinguo.repository2020.abtest.j.a.b();
            } else {
                us.pinguo.repository2020.abtest.g gVar = this.f6907k;
                if (gVar != null && (a2 = gVar.a()) != null) {
                    str6 = a2;
                }
            }
            this.f6906j = str6;
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subscr_7days_trial)).setText(getString(R.string.act_subs_free_trial_7days));
            if (H0()) {
                R0();
                ((AutofitTextView) _$_findCachedViewById(R.id.tvAdUsedFor)).setText(us.pinguo.edit2020.utils.d.k(R.string.update_vip_for_free));
            } else {
                AlphaPressedConstraintLayout alphaPressedConstraintLayout11 = (AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte);
                alphaPressedConstraintLayout11.setVisibility(0);
                VdsAgent.onSetViewVisibility(alphaPressedConstraintLayout11, 0);
                ConstraintLayout constraintLayout7 = (ConstraintLayout) _$_findCachedViewById(R.id.tlbtn_subscripte_new);
                constraintLayout7.setVisibility(8);
                VdsAgent.onSetViewVisibility(constraintLayout7, 8);
                ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_camera360_vip));
                AutofitTextView autofitTextView12 = (AutofitTextView) _$_findCachedViewById(R.id.tv_sub_after_7d_auto_sub);
                autofitTextView12.setVisibility(0);
                VdsAgent.onSetViewVisibility(autofitTextView12, 0);
                RelativeLayout relativeLayout7 = (RelativeLayout) _$_findCachedViewById(R.id.rl_time_count_down_area);
                relativeLayout7.setVisibility(8);
                VdsAgent.onSetViewVisibility(relativeLayout7, 8);
                AutofitTextView autofitTextView13 = (AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip);
                autofitTextView13.setVisibility(0);
                VdsAgent.onSetViewVisibility(autofitTextView13, 0);
                LinearLayout linearLayout9 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
                linearLayout9.setVisibility(4);
                VdsAgent.onSetViewVisibility(linearLayout9, 4);
                Y0();
            }
        }
        VipManager vipManager2 = VipManager.a;
        if (vipManager2.I()) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon);
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            ((ImageView) _$_findCachedViewById(R.id.vDivider)).setVisibility(8);
            AutofitTextView autofitTextView14 = (AutofitTextView) _$_findCachedViewById(R.id.txtLimitedDiscount);
            if (autofitTextView14 == null) {
                return;
            }
            autofitTextView14.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView14, 8);
        } else if (us.pinguo.edit2020.utils.d.d(vipManager2.x())) {
            TextView txtSubtitleCoupon = (TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon);
            kotlin.jvm.internal.s.g(txtSubtitleCoupon, "txtSubtitleCoupon");
            txtSubtitleCoupon.setVisibility(8);
            VdsAgent.onSetViewVisibility(txtSubtitleCoupon, 8);
            ImageView vDivider = (ImageView) _$_findCachedViewById(R.id.vDivider);
            kotlin.jvm.internal.s.g(vDivider, "vDivider");
            vDivider.setVisibility(8);
            VdsAgent.onSetViewVisibility(vDivider, 8);
            AutofitTextView autofitTextView15 = (AutofitTextView) _$_findCachedViewById(R.id.txtLimitedDiscount);
            if (autofitTextView15 == null) {
                return;
            }
            autofitTextView15.setVisibility(0);
            VdsAgent.onSetViewVisibility(autofitTextView15, 0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon);
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            TextView s0 = s0();
            if (s0 != null && s0.getVisibility() == 0) {
                ((ImageView) _$_findCachedViewById(R.id.vDivider)).setVisibility(0);
            } else {
                ((ImageView) _$_findCachedViewById(R.id.vDivider)).setVisibility(8);
            }
        }
    }

    @Override // com.pinguo.camera360.member.a1
    /* renamed from: V0 */
    public void D(e1 presenter) {
        kotlin.jvm.internal.s.h(presenter, "presenter");
        this.f6904h = presenter;
        presenter.p(new SubscriptionMemberActivity$setPresenter$1(this));
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.f6902f;
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

    @Override // com.pinguo.camera360.member.y0
    public String b() {
        return this.f6906j;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z = true;
        }
        if (z) {
            onUserInteraction();
        }
        if (getWindow().superDispatchTouchEvent(motionEvent)) {
            return true;
        }
        return onTouchEvent(motionEvent);
    }

    @Override // com.pinguo.camera360.member.y0
    public Activity g() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i2 != 102) {
            if (PayHelp.getInstance().J(i2, i3, intent)) {
                return;
            }
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            x0 x0Var = this.f6904h;
            Objects.requireNonNull(x0Var, "null cannot be cast to non-null type com.pinguo.camera360.member.SubscribePresenter");
            ((e1) x0Var).b(this.f6906j);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        SubscriptionRewardAdvController subscriptionRewardAdvController;
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.txtSubtitleCoupon) {
            a1();
        } else if (valueOf != null && valueOf.intValue() == R.id.tlbtn_subscripte) {
            VipManager vipManager = VipManager.a;
            String str = vipManager.H() ? "Huawei" : "Google";
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            cVar.t("", str, this.f6906j, "click");
            if (vipManager.i() == 4) {
                cVar.z();
            }
            if (us.pinguo.foundation.utils.j.a(1000L)) {
                return;
            }
            View view2 = this.t;
            if (view2 != null) {
                if (view2.getVisibility() == 0) {
                    AppCompatCheckBox appCompatCheckBox = this.u;
                    if (appCompatCheckBox == null) {
                        kotlin.jvm.internal.s.z("mAgreementCheckBox");
                        throw null;
                    } else if (appCompatCheckBox.isChecked()) {
                        us.pinguo.user.u0.o = false;
                        AppCompatCheckBox appCompatCheckBox2 = this.u;
                        if (appCompatCheckBox2 != null) {
                            appCompatCheckBox2.setVisibility(4);
                            VdsAgent.onSetViewVisibility(appCompatCheckBox2, 4);
                            CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
                            us.pinguo.user.u0.o = false;
                            us.pinguo.bigdata.a.m(true);
                        } else {
                            kotlin.jvm.internal.s.z("mAgreementCheckBox");
                            throw null;
                        }
                    } else {
                        us.pinguo.user.u0.o = true;
                        Toast makeText = Toast.makeText(this, (int) R.string.pls_check_box_msg, 1);
                        makeText.show();
                        VdsAgent.showToast(makeText);
                        return;
                    }
                }
                if (t0.a.d()) {
                    String x = vipManager.x();
                    if (x == null) {
                        x = "yearly_vip_discount";
                    }
                    this.f6906j = x;
                }
                x0 x0Var = this.f6904h;
                kotlin.jvm.internal.s.e(x0Var);
                x0Var.b(this.f6906j);
                F0("click_sub_btn");
                C0("click_sub_btn");
                return;
            }
            kotlin.jvm.internal.s.z("mAgreementLayout");
            throw null;
        } else if (valueOf != null && valueOf.intValue() == R.id.ll_subscr_notice) {
            Intent intent = new Intent();
            intent.putExtra("towhere", VipHalfScreenController.URL_SERVICE_PROTOCOL);
            intent.setClass(this, OptionsWebviewActivity.class);
            startActivity(intent);
        } else if (valueOf != null && valueOf.intValue() == R.id.txt_buy_VIP) {
            if (us.pinguo.foundation.utils.j.a(1000L)) {
                return;
            }
            View view3 = this.t;
            if (view3 != null) {
                if (view3.getVisibility() == 0) {
                    AppCompatCheckBox appCompatCheckBox3 = this.u;
                    if (appCompatCheckBox3 == null) {
                        kotlin.jvm.internal.s.z("mAgreementCheckBox");
                        throw null;
                    } else if (appCompatCheckBox3.isChecked()) {
                        us.pinguo.user.u0.o = false;
                        AppCompatCheckBox appCompatCheckBox4 = this.u;
                        if (appCompatCheckBox4 != null) {
                            appCompatCheckBox4.setVisibility(4);
                            VdsAgent.onSetViewVisibility(appCompatCheckBox4, 4);
                            CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
                            us.pinguo.bigdata.a.m(true);
                        } else {
                            kotlin.jvm.internal.s.z("mAgreementCheckBox");
                            throw null;
                        }
                    } else {
                        us.pinguo.user.u0.o = true;
                        Toast makeText2 = Toast.makeText(this, (int) R.string.pls_check_box_msg, 1);
                        makeText2.show();
                        VdsAgent.showToast(makeText2);
                        return;
                    }
                }
                x0 x0Var2 = this.f6904h;
                kotlin.jvm.internal.s.e(x0Var2);
                x0Var2.b(this.f6906j);
                F0("click_sub_btn");
                C0("click_sub_btn");
                us.pinguo.foundation.statistics.h.a.f0();
                us.pinguo.foundation.statistics.h.b.Q(null, G0(), null, "sub");
                return;
            }
            kotlin.jvm.internal.s.z("mAgreementLayout");
            throw null;
        } else if (valueOf == null || valueOf.intValue() != R.id.txt_update_to_vip_free || (subscriptionRewardAdvController = this.f6908l) == null) {
        } else {
            subscriptionRewardAdvController.s("vip_page");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.member.BaseToolbarActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        User.Info h2;
        this.mEnableBaseNotch = false;
        super.onCreate(bundle);
        D0();
        VipManager vipManager = VipManager.a;
        if (!vipManager.I() && vipManager.i() != 4 && com.pinguo.camera360.vip.e.a.a() && !HuaweiAgent.isHuaweiSupport()) {
            com.pinguo.camera360.adv.c.i();
            this.f6905i = true;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        new e1(this);
        initView();
        x0 x0Var = this.f6904h;
        Objects.requireNonNull(x0Var, "null cannot be cast to non-null type com.pinguo.camera360.member.SubscribePresenter");
        ((e1) x0Var).k();
        this.q = getIntent().getStringArrayListExtra("camera_stat_attr_subscription");
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item1)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item2)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item3)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item4)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item5)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item6)).setAlpha(0.0f);
        ((LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7)).setAlpha(0.0f);
        int i2 = R.id.tv_subscr_7days_trial;
        ((AutofitTextView) _$_findCachedViewById(i2)).setScaleX(1.0f);
        ((AutofitTextView) _$_findCachedViewById(i2)).setScaleY(1.0f);
        this.o = true;
        View findViewById = findViewById(R.id.agreement_content);
        kotlin.jvm.internal.s.g(findViewById, "findViewById(R.id.agreement_content)");
        this.s = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.agreement_privacy_layout);
        kotlin.jvm.internal.s.g(findViewById2, "findViewById(R.id.agreement_privacy_layout)");
        this.t = findViewById2;
        View findViewById3 = findViewById(R.id.agreement_checkbox);
        kotlin.jvm.internal.s.g(findViewById3, "findViewById(R.id.agreement_checkbox)");
        this.u = (AppCompatCheckBox) findViewById3;
        if (!HuaweiAgent.isHuaweiSupport() && !HuaweiAgent.isHuaweiPhone()) {
            View view = this.t;
            if (view != null) {
                view.setVisibility(8);
                VdsAgent.onSetViewVisibility(view, 8);
                U0();
            } else {
                kotlin.jvm.internal.s.z("mAgreementLayout");
                throw null;
            }
        } else {
            if (CameraBusinessSettingModel.v().x()) {
                View view2 = this.t;
                if (view2 != null) {
                    view2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(view2, 0);
                    S0();
                } else {
                    kotlin.jvm.internal.s.z("mAgreementLayout");
                    throw null;
                }
            } else {
                View view3 = this.t;
                if (view3 == null) {
                    kotlin.jvm.internal.s.z("mAgreementLayout");
                    throw null;
                } else {
                    view3.setVisibility(8);
                    VdsAgent.onSetViewVisibility(view3, 8);
                }
            }
            ((LinearLayout) _$_findCachedViewById(R.id.ll_subscr_notice)).setOnClickListener(this);
        }
        ((TextView) _$_findCachedViewById(R.id.supportText)).setText((vipManager.H() && us.pinguo.util.p.e()) ? R.string.vip_wx_code : R.string.vip_email_code);
        OrderHelp.getInstance().e(this, (!User.d().n() || (h2 = User.d().h()) == null) ? null : h2.userId, 0, null, null, null, null);
        if (us.pinguo.repository2020.abtest.i.a.b()) {
            PercentRelativeLayout root = (PercentRelativeLayout) _$_findCachedViewById(R.id.root);
            kotlin.jvm.internal.s.g(root, "root");
            SubscriptionRewardAdvController subscriptionRewardAdvController = new SubscriptionRewardAdvController(root, this);
            subscriptionRewardAdvController.n();
            this.f6908l = subscriptionRewardAdvController;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.member.BaseToolbarActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        x0 x0Var = this.f6904h;
        Objects.requireNonNull(x0Var, "null cannot be cast to non-null type com.pinguo.camera360.member.SubscribePresenter");
        ((e1) x0Var).n();
        this.r.removeMessages(2449);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.p = true;
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item1)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item2)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item3)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item4)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item5)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item6)).setAlpha(1.0f);
        ((LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7)).setAlpha(1.0f);
        int i2 = R.id.tv_subscr_7days_trial;
        ((AutofitTextView) _$_findCachedViewById(i2)).setScaleX(1.0f);
        ((AutofitTextView) _$_findCachedViewById(i2)).setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.f6903g = VipManager.a.I();
        super.onResume();
        if (this.o) {
            postAfterAllInited(new Runnable() { // from class: com.pinguo.camera360.member.k0
                @Override // java.lang.Runnable
                public final void run() {
                    SubscriptionMemberActivity.Q0(SubscriptionMemberActivity.this);
                }
            });
        }
        this.o = false;
        this.p = false;
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    protected int q0() {
        return R.layout.activity_subscription_member_gp;
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    public void w0() {
        Toolbar r0 = r0();
        kotlin.jvm.internal.s.e(r0);
        r0.setNavigationIcon(R.drawable.vip_purchase_back);
        Toolbar r02 = r0();
        kotlin.jvm.internal.s.e(r02);
        r02.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubscriptionMemberActivity.Z0(SubscriptionMemberActivity.this, view);
            }
        });
    }
}
