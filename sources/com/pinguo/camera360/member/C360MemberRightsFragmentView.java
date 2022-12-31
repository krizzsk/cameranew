package com.pinguo.camera360.member;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.FragmentActivity;
import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.options.OptionsWebviewActivity;
import com.pinguo.camera360.member.model.MemberPriceInfo;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.camera360.vip.VipReemCodeInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.ui.widget.AlphaPressedAutofitTextView;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.user.User;
import us.pinguo.user.event.DiscountCodeCheckResult;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.ui.PGLoginMainActivity;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.R;
/* compiled from: C360MemberRightsFragmentView.kt */
/* loaded from: classes3.dex */
public final class C360MemberRightsFragmentView extends BaseMemberRightsFragmentView implements View.OnClickListener, us.pinguo.camera360.shop.manager.v0, us.pinguo.foundation.statistics.e {
    public static final a u = new a(null);

    /* renamed from: k  reason: collision with root package name */
    private TextView f6882k;

    /* renamed from: l  reason: collision with root package name */
    private View f6883l;
    private AppCompatCheckBox m;
    private Bundle n;
    private boolean o;
    private AnimatorSet p;
    private boolean r;
    private ArrayList<String> s;
    private RechargeGoodsDiscountInfo t;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f6881j = new LinkedHashMap();
    private boolean q = true;

    /* compiled from: C360MemberRightsFragmentView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final C360MemberRightsFragmentView a(Bundle bundle) {
            C360MemberRightsFragmentView c360MemberRightsFragmentView = new C360MemberRightsFragmentView();
            c360MemberRightsFragmentView.setArguments(bundle);
            return c360MemberRightsFragmentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: C360MemberRightsFragmentView.kt */
    /* loaded from: classes3.dex */
    public final class b extends ClickableSpan {
        private final String a;
        final /* synthetic */ C360MemberRightsFragmentView b;

        public b(C360MemberRightsFragmentView this$0, String mUrl) {
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
            FragmentActivity activity = this.b.getActivity();
            if (activity == null) {
                return;
            }
            activity.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.s.h(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(Color.argb(255, 21, 116, 255));
            ds.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(FragmentActivity activity, int i2, DialogInterface dialogInterface, int i3) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i3);
        kotlin.jvm.internal.s.h(activity, "$activity");
        if (i3 == -2) {
            activity.setResult(i2);
            activity.finish();
        } else if (i3 != -1) {
        } else {
            us.pinguo.foundation.statistics.h.a.g("", "vip_sub", "show");
            us.pinguo.user.s0.getInstance().a(activity, 205, "vip_sub");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(final C360MemberRightsFragmentView this$0) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator withEndAction;
        ViewPropertyAnimator duration;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        TextView textView = (TextView) this$0._$_findCachedViewById(R.id.txtToast);
        if (textView == null || (animate = textView.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (withEndAction = alpha.withEndAction(new Runnable() { // from class: com.pinguo.camera360.member.m
            @Override // java.lang.Runnable
            public final void run() {
                C360MemberRightsFragmentView.H0(C360MemberRightsFragmentView.this);
            }
        })) == null || (duration = withEndAction.setDuration(200L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C360MemberRightsFragmentView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        TextView textView = (TextView) this$0._$_findCachedViewById(R.id.txtToast);
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map I0(C360MemberRightsFragmentView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        HashMap hashMap = new HashMap();
        us.pinguo.user.u0.e(this$0.g().getApplicationContext(), hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(C360MemberRightsFragmentView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.N0();
    }

    private final void K0() {
        Resources resources;
        String string;
        boolean C;
        String str;
        boolean z;
        Resources resources2;
        String string2;
        boolean C2;
        String v;
        TextView textView = this.f6882k;
        if (textView == null) {
            return;
        }
        String string3 = getResources().getString(R.string.pg_pay_auth_text);
        kotlin.jvm.internal.s.g(string3, "resources.getString(us.p….string.pg_pay_auth_text)");
        FragmentActivity activity = getActivity();
        String str2 = (activity == null || (resources = activity.getResources()) == null || (string = resources.getString(R.string.agreement_dialog_user_agreement)) == null) ? "" : string;
        int i2 = 0;
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
        FragmentActivity activity2 = getActivity();
        String str3 = (activity2 == null || (resources2 = activity2.getResources()) == null || (string2 = resources2.getString(R.string.agreement_dialog_privacy_policy)) == null) ? "" : string2;
        C2 = StringsKt__StringsKt.C(str, str3, false, 2, null);
        if (C2) {
            str = kotlin.text.t.v(str, str3, "<a href='privacy' style='color:#4487F2'>" + str3 + "</a>", false, 4, null);
        } else {
            z2 = z;
        }
        if (!z2) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C360MemberRightsFragmentView.L0(C360MemberRightsFragmentView.this, view);
                }
            });
            return;
        }
        Spanned fromHtml = Html.fromHtml(str);
        Objects.requireNonNull(fromHtml, "null cannot be cast to non-null type android.text.Spannable");
        Spannable spannable = (Spannable) fromHtml;
        textView.setText(spannable);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
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
                spannableStringBuilder.setSpan(new b(this, url), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(C360MemberRightsFragmentView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Intent intent = new Intent();
        intent.setClassName(us.pinguo.util.v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
        intent.putExtra("towhere", "agreement");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.startActivity(intent);
    }

    private final void M0() {
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

    private final void N0() {
        if (this.r) {
            return;
        }
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.p = null;
        AnimatorSet animatorSet2 = new AnimatorSet();
        int i2 = R.id.tlbtn_subscripte;
        ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setScaleX(1.0f);
        ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setScaleY(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item1), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item2), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item3), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item4), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item5), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.vip_fun_item6), "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat((LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7), "alpha", 0.0f, 1.0f);
        ValueAnimator ofFloat8 = ValueAnimator.ofFloat(1.0f, 1.15f, 1.0f);
        ofFloat8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pinguo.camera360.member.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C360MemberRightsFragmentView.O0(C360MemberRightsFragmentView.this, valueAnimator);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat3.setDuration(200L);
        ofFloat4.setDuration(200L);
        ofFloat5.setDuration(200L);
        ofFloat6.setDuration(200L);
        ofFloat7.setDuration(200L);
        ofFloat8.setDuration(600L);
        animatorSet2.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7, ofFloat8);
        animatorSet2.start();
        this.p = animatorSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(C360MemberRightsFragmentView this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = R.id.tlbtn_subscripte;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        ((AlphaPressedAutofitTextView) this$0._$_findCachedViewById(i2)).setScaleX(((Float) animatedValue).floatValue());
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        ((AlphaPressedAutofitTextView) this$0._$_findCachedViewById(i2)).setScaleY(((Float) animatedValue2).floatValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void initData() {
        /*
            r3 = this;
            int r0 = vStudio.Android.Camera360.R.id.tlbtn_subscripte
            android.view.View r0 = r3._$_findCachedViewById(r0)
            us.pinguo.ui.widget.AlphaPressedAutofitTextView r0 = (us.pinguo.ui.widget.AlphaPressedAutofitTextView) r0
            if (r0 != 0) goto Lb
            goto Le
        Lb:
            r0.setOnClickListener(r3)
        Le:
            int r0 = vStudio.Android.Camera360.R.id.ll_subscr_notice
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 != 0) goto L19
            goto L1c
        L19:
            r0.setOnClickListener(r3)
        L1c:
            int r0 = vStudio.Android.Camera360.R.id.tv_united_notice
            android.view.View r1 = r3._$_findCachedViewById(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 != 0) goto L27
            goto L2a
        L27:
            r1.setOnClickListener(r3)
        L2a:
            int r1 = vStudio.Android.Camera360.R.id.agreement_privacy_layout
            android.view.View r1 = r3._$_findCachedViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 != 0) goto L35
            goto L38
        L35:
            r1.setOnClickListener(r3)
        L38:
            android.os.Bundle r1 = r3.n
            if (r1 == 0) goto L63
            kotlin.jvm.internal.s.e(r1)
            java.lang.String r2 = "is_show_united_vip"
            boolean r1 = r1.getBoolean(r2)
            if (r1 == 0) goto L63
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            r0.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r0, r1)
            int r0 = vStudio.Android.Camera360.R.id.tv_or_notice
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r0, r1)
            goto L7f
        L63:
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 8
            r0.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r0, r1)
            int r0 = vStudio.Android.Camera360.R.id.tv_or_notice
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r0, r1)
        L7f:
            int r0 = vStudio.Android.Camera360.R.id.tv_vip_camera360
            android.view.View r0 = r3._$_findCachedViewById(r0)
            us.pinguo.ui.widget.AutofitTextView r0 = (us.pinguo.ui.widget.AutofitTextView) r0
            r1 = 1106247680(0x41f00000, float:30.0)
            r0.setMaxTextSize(r1)
            int r0 = vStudio.Android.Camera360.R.id.tv_subs_vip_descrip
            android.view.View r0 = r3._$_findCachedViewById(r0)
            us.pinguo.ui.widget.AutofitTextView r0 = (us.pinguo.ui.widget.AutofitTextView) r0
            r1 = 1098907648(0x41800000, float:16.0)
            r0.setMaxTextSize(r1)
            int r0 = vStudio.Android.Camera360.R.id.supportText
            android.view.View r0 = r3._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            boolean r1 = us.pinguo.util.p.e()
            if (r1 == 0) goto Lab
            r1 = 2131822557(0x7f1107dd, float:1.9277889E38)
            goto Lae
        Lab:
            r1 = 2131822505(0x7f1107a9, float:1.9277783E38)
        Lae:
            r0.setText(r1)
            us.pinguo.user.event.SyncVipInfoDoneEvent r0 = new us.pinguo.user.event.SyncVipInfoDoneEvent
            r0.<init>()
            r3.s0(r0)
            r3.M0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.member.C360MemberRightsFragmentView.initData():void");
    }

    private final void u0(String str) {
        ArrayList<String> stringArrayListExtra;
        ArrayList<String> arrayList = this.s;
        if (!(arrayList == null || arrayList.isEmpty())) {
            us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
            ArrayList<String> arrayList2 = this.s;
            kotlin.jvm.internal.s.e(arrayList2);
            String str2 = arrayList2.get(0);
            ArrayList<String> arrayList3 = this.s;
            kotlin.jvm.internal.s.e(arrayList3);
            String str3 = arrayList3.get(1);
            ArrayList<String> arrayList4 = this.s;
            kotlin.jvm.internal.s.e(arrayList4);
            String str4 = arrayList4.get(2);
            ArrayList<String> arrayList5 = this.s;
            kotlin.jvm.internal.s.e(arrayList5);
            String str5 = arrayList5.get(3);
            ArrayList<String> arrayList6 = this.s;
            kotlin.jvm.internal.s.e(arrayList6);
            String str6 = arrayList6.get(4);
            ArrayList<String> arrayList7 = this.s;
            kotlin.jvm.internal.s.e(arrayList7);
            String str7 = arrayList7.get(5);
            ArrayList<String> arrayList8 = this.s;
            kotlin.jvm.internal.s.e(arrayList8);
            String str8 = arrayList8.get(6);
            ArrayList<String> arrayList9 = this.s;
            kotlin.jvm.internal.s.e(arrayList9);
            iVar.p(str2, str, str3, str4, str5, str6, str7, str8, arrayList9.get(7));
        }
        FragmentActivity activity = getActivity();
        Intent intent = activity == null ? null : activity.getIntent();
        if (intent == null || (stringArrayListExtra = intent.getStringArrayListExtra("edit_stat_param")) == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.q(VipManager.a.I() ? "vip" : Constants.NORMAL, str, stringArrayListExtra.get(0), stringArrayListExtra.get(1), stringArrayListExtra.get(2), stringArrayListExtra.get(3), stringArrayListExtra.get(4), stringArrayListExtra.get(5), stringArrayListExtra.get(6), stringArrayListExtra.get(7), stringArrayListExtra.get(8), stringArrayListExtra.get(9), stringArrayListExtra.get(10), stringArrayListExtra.get(11), stringArrayListExtra.get(12), stringArrayListExtra.get(13), stringArrayListExtra.get(14), stringArrayListExtra.get(15), stringArrayListExtra.get(16), stringArrayListExtra.get(17), stringArrayListExtra.get(18), stringArrayListExtra.get(19), stringArrayListExtra.get(20), stringArrayListExtra.get(21), stringArrayListExtra.get(22), stringArrayListExtra.get(23), stringArrayListExtra.get(24), stringArrayListExtra.get(25), stringArrayListExtra.get(26), stringArrayListExtra.get(27), stringArrayListExtra.get(28), stringArrayListExtra.get(29), stringArrayListExtra.get(30), stringArrayListExtra.get(31));
    }

    private final ArrayList<String> v0(String str, String str2) {
        if (str != null) {
            if (str.length() == 0) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            if (str2 != null) {
                if (!(str2.length() == 0)) {
                    Pattern compile = Pattern.compile(str2);
                    kotlin.jvm.internal.s.g(compile, "compile(regex)");
                    Matcher matcher = compile.matcher(str);
                    kotlin.jvm.internal.s.g(matcher, "pattern.matcher(str)");
                    while (matcher.find()) {
                        arrayList.add(matcher.group());
                    }
                    return arrayList;
                }
            }
            arrayList.add(str);
            return arrayList;
        }
        return null;
    }

    private final String w0(String str) {
        kotlin.z.d h2;
        String i0;
        String v;
        double d2;
        String v2;
        ArrayList<String> v0 = v0(str, "[0-9][0-9]*\\.[0-9][0-9]*|[0-9][0-9]*");
        Integer valueOf = v0 == null ? null : Integer.valueOf(v0.size());
        kotlin.jvm.internal.s.e(valueOf);
        String str2 = "";
        if (valueOf.intValue() > 0) {
            if (x0(v0.get(0))) {
                String str3 = v0.get(0);
                kotlin.jvm.internal.s.g(str3, "strs[0]");
                double parseDouble = Double.parseDouble(str3) / 12;
                if (str == null) {
                    return null;
                }
                String str4 = v0.get(0);
                kotlin.jvm.internal.s.g(str4, "strs[0]");
                v2 = kotlin.text.t.v(str, str4, String.valueOf(((int) (parseDouble * d2)) / 100), false, 4, null);
                return v2;
            }
            int size = v0.size();
            double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            h2 = kotlin.z.j.h(0, size);
            for (Iterator<Integer> it = h2.iterator(); it.hasNext(); it = it) {
                int nextInt = ((kotlin.collections.h0) it).nextInt();
                String str5 = v0.get(nextInt);
                kotlin.jvm.internal.s.g(str5, "strs[index]");
                d3 += Double.parseDouble(str5) * Math.pow(1000.0d, (size - 1.0d) - nextInt);
                str2 = str2 + v0.get(nextInt) + ',';
            }
            i0 = StringsKt__StringsKt.i0(str2, ",");
            int i2 = (int) (d3 / 12);
            if (str == null) {
                return null;
            }
            v = kotlin.text.t.v(str, i0, String.valueOf(i2), false, 4, null);
            return v;
        }
        return "";
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, com.pinguo.camera360.member.w0
    public void A(MemberPriceInfo memberPriceInfo) {
        kotlin.jvm.internal.s.h(memberPriceInfo, "memberPriceInfo");
        super.A(memberPriceInfo);
        boolean z = true;
        if (memberPriceInfo.getMiguway() != 1 && memberPriceInfo.getMmgzway() != 1) {
            z = false;
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_united_notice);
        if (textView != null) {
            int i2 = z ? 0 : 8;
            textView.setVisibility(i2);
            VdsAgent.onSetViewVisibility(textView, i2);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_or_notice);
        if (textView2 != null) {
            int i3 = z ? 0 : 8;
            textView2.setVisibility(i3);
            VdsAgent.onSetViewVisibility(textView2, i3);
        }
        if (User.d().r(false).d()) {
            AutofitTextView txtLimitedDiscount = (AutofitTextView) _$_findCachedViewById(R.id.txtLimitedDiscount);
            kotlin.jvm.internal.s.g(txtLimitedDiscount, "txtLimitedDiscount");
            txtLimitedDiscount.setVisibility(8);
            VdsAgent.onSetViewVisibility(txtLimitedDiscount, 8);
            return;
        }
        RechargePresenter c0 = c0();
        if (us.pinguo.edit2020.utils.d.d(c0 == null ? null : c0.h())) {
            AutofitTextView txtLimitedDiscount2 = (AutofitTextView) _$_findCachedViewById(R.id.txtLimitedDiscount);
            kotlin.jvm.internal.s.g(txtLimitedDiscount2, "txtLimitedDiscount");
            txtLimitedDiscount2.setVisibility(0);
            VdsAgent.onSetViewVisibility(txtLimitedDiscount2, 0);
        }
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return this.o ? "vip_center_page" : "vip_free_trial_page";
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    public void _$_clearFindViewByIdCache() {
        this.f6881j.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.f6881j;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, com.pinguo.camera360.member.w0
    public String b() {
        RechargeGoodsDiscountInfo d0 = d0();
        if (d0 == null) {
            return null;
        }
        return d0.getProductId();
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected RechargeGoodsDiscountInfo d0() {
        RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = this.t;
        return rechargeGoodsDiscountInfo == null ? super.d0() : rechargeGoodsDiscountInfo;
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, com.pinguo.camera360.member.w0
    public Activity g() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.s.e(activity);
        kotlin.jvm.internal.s.g(activity, "activity!!");
        return activity;
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.camera360.shop.manager.v0
    public void i(boolean z, RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo) {
        String h2;
        if (us.pinguo.foundation.utils.j.a(1000L)) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? new Intent(activity, SubscriptionResultActivity.class) : null;
        int i2 = 201;
        if (z) {
            RechargePresenter c0 = c0();
            if (c0 != null && (h2 = c0.h()) != null) {
                if (h2.length() > 0) {
                    if (kotlin.jvm.internal.s.c(h2, rechargeGoodsDiscountInfo != null ? rechargeGoodsDiscountInfo.getProductId() : null)) {
                        AutofitTextView txtLimitedDiscount = (AutofitTextView) _$_findCachedViewById(R.id.txtLimitedDiscount);
                        kotlin.jvm.internal.s.g(txtLimitedDiscount, "txtLimitedDiscount");
                        txtLimitedDiscount.setVisibility(8);
                        VdsAgent.onSetViewVisibility(txtLimitedDiscount, 8);
                        RechargePresenter c02 = c0();
                        if (c02 != null) {
                            c02.f();
                        }
                    }
                }
            }
            VipManager.a.T(activity, rechargeGoodsDiscountInfo);
            RechargePresenter c03 = c0();
            Objects.requireNonNull(c03, "null cannot be cast to non-null type com.pinguo.camera360.member.RechargePresenter");
            c03.p(z);
            if (intent != null) {
                intent.putExtra("subscription_status", 201);
            }
            if (activity != null) {
                activity.setResult(-1);
            }
            u0("sub_success");
        } else {
            if (intent != null) {
                intent.putExtra("subscription_status", 202);
            }
            u0("sub_failed");
            i2 = 202;
        }
        if (activity != null) {
            activity.startActivityForResult(intent, i2);
        }
        l0(z, rechargeGoodsDiscountInfo);
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    public void k0() {
        View view = this.f6883l;
        if (view != null && view.getVisibility() == 0) {
            AppCompatCheckBox appCompatCheckBox = this.m;
            if (appCompatCheckBox != null) {
                appCompatCheckBox.setVisibility(4);
                VdsAgent.onSetViewVisibility(appCompatCheckBox, 4);
            }
            CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
            us.pinguo.user.u0.o = false;
            us.pinguo.bigdata.a.m(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, final int i3, Intent intent) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (i2 == 201 && i3 == -1) {
            s0(new SyncVipInfoDoneEvent());
            if (!us.pinguo.user.s0.getInstance().e()) {
                us.pinguo.foundation.utils.w.i(activity, R.string.vip_bind_tips_content, R.string.vip_bind_tips_yes, R.string.vip_bind_tips_no, new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.member.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        C360MemberRightsFragmentView.F0(FragmentActivity.this, i3, dialogInterface, i4);
                    }
                });
                return;
            }
            activity.setResult(i3);
            activity.finish();
        } else if (i2 == 202) {
            if (i3 != -1) {
                return;
            }
            q0();
        } else if (i2 == 205) {
            if (i3 == -1) {
                if (User.d().r(false).d() || VipManager.a.F()) {
                    activity.setResult(-1);
                    activity.finish();
                }
            }
        } else if (i2 == 206) {
            if (i3 == -1) {
                TextView txtToast = (TextView) _$_findCachedViewById(R.id.txtToast);
                kotlin.jvm.internal.s.g(txtToast, "txtToast");
                txtToast.setVisibility(0);
                VdsAgent.onSetViewVisibility(txtToast, 0);
                us.pinguo.foundation.utils.f.d(new Runnable() { // from class: com.pinguo.camera360.member.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        C360MemberRightsFragmentView.G0(C360MemberRightsFragmentView.this);
                    }
                }, 2000L);
            }
        } else if (i2 != 203) {
            if (C360MemberPayHelp.getInstance().J(i2, i3, intent)) {
                return;
            }
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            if (User.d().r(false).d() || VipManager.a.F()) {
                activity.setResult(-1);
                activity.finish();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        kotlin.jvm.internal.s.e(view);
        switch (view.getId()) {
            case R.id.agreement_privacy_layout /* 2131296409 */:
                int i2 = R.id.agreement_checkbox;
                ((AppCompatCheckBox) _$_findCachedViewById(i2)).setChecked(!((AppCompatCheckBox) _$_findCachedViewById(i2)).isChecked());
                us.pinguo.user.u0.o = !((AppCompatCheckBox) _$_findCachedViewById(i2)).isChecked();
                return;
            case R.id.ll_subscr_notice /* 2131297413 */:
                FragmentActivity activity = getActivity();
                kotlin.jvm.internal.s.e(activity);
                Intent intent = activity.getIntent();
                kotlin.jvm.internal.s.e(intent);
                if (intent.getBooleanExtra("is_from_notice", false)) {
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("towhere", "member_notice");
                intent2.setClass(requireActivity(), OptionsWebviewActivity.class);
                startActivity(intent2);
                return;
            case R.id.tlbtn_subscripte /* 2131298187 */:
                if (!User.d().r(false).a() && !VipManager.a.F()) {
                    if (us.pinguo.user.s0.getInstance().e()) {
                        q0();
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("from_pay", true);
                    FragmentActivity activity2 = getActivity();
                    kotlin.jvm.internal.s.e(activity2);
                    intent3.setClass(activity2, PGLoginMainActivity.class);
                    FragmentActivity activity3 = getActivity();
                    kotlin.jvm.internal.s.e(activity3);
                    activity3.startActivityForResult(intent3, 206);
                    return;
                } else if (us.pinguo.user.s0.getInstance().e()) {
                    return;
                } else {
                    us.pinguo.foundation.statistics.h.a.g("", "vip_sub", "show");
                    us.pinguo.user.s0.getInstance().a(getActivity(), 205, "vip_sub");
                    return;
                }
            case R.id.tv_united_notice /* 2131298491 */:
                Intent intent4 = new Intent(getActivity(), MemberRightsActivity.class);
                intent4.putExtra("is_from_notice", true);
                startActivity(intent4);
                return;
            default:
                return;
        }
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Intent intent;
        Window window;
        PayHelp.PAYWAY payway;
        super.onCreate(bundle);
        VipManager vipManager = VipManager.a;
        this.o = vipManager.I();
        this.n = getArguments();
        try {
            if (vipManager.G()) {
                payway = PayHelp.PAYWAY.GooglePay;
            } else {
                payway = HuaweiAgent.isHuaweiSupport() ? PayHelp.PAYWAY.HuaweiIAP : PayHelp.PAYWAY.OtherPay;
            }
            C360MemberPayHelp.getInstance().M(getActivity(), new us.pinguo.paylibcenter.i() { // from class: com.pinguo.camera360.member.p
                @Override // us.pinguo.paylibcenter.i
                public final Map a() {
                    Map I0;
                    I0 = C360MemberRightsFragmentView.I0(C360MemberRightsFragmentView.this);
                    return I0;
                }
            }, payway);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(67108864);
        }
        FragmentActivity activity2 = getActivity();
        ArrayList<String> arrayList = null;
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            arrayList = intent.getStringArrayListExtra("camera_stat_attr_subscription");
        }
        this.s = arrayList;
        this.q = true;
        RechargePresenter c0 = c0();
        Objects.requireNonNull(c0, "null cannot be cast to non-null type com.pinguo.camera360.member.RechargePresenter");
        c0.o();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_c360_china_member_layout, (ViewGroup) null);
        this.f6882k = (TextView) inflate.findViewById(R.id.agreement_content);
        this.f6883l = inflate.findViewById(R.id.agreement_privacy_layout);
        this.m = (AppCompatCheckBox) inflate.findViewById(R.id.agreement_checkbox);
        return inflate;
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        RechargePresenter c0 = c0();
        if (c0 != null) {
            c0.l();
        }
        PayHelp.getInstance().t();
        C360MemberPayHelp.getInstance().Z(null);
        if (CameraBusinessSettingModel.v().x()) {
            us.pinguo.user.u0.o = true;
        }
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onEvent(DiscountCodeCheckResult event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (event.d().length() > 0) {
            AutofitTextView txtLimitedDiscount = (AutofitTextView) _$_findCachedViewById(R.id.txtLimitedDiscount);
            kotlin.jvm.internal.s.g(txtLimitedDiscount, "txtLimitedDiscount");
            txtLimitedDiscount.setVisibility(0);
            VdsAgent.onSetViewVisibility(txtLimitedDiscount, 0);
            RechargePresenter c0 = c0();
            if (c0 != null) {
                c0.m(event.d());
            }
            RechargePresenter c02 = c0();
            if (c02 != null) {
                c02.k();
            }
            s0(new SyncVipInfoDoneEvent());
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.p = null;
        this.r = true;
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item1)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item2)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item3)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item4)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item5)).setAlpha(1.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item6)).setAlpha(1.0f);
        ((LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7)).setAlpha(1.0f);
        int i2 = R.id.tlbtn_subscripte;
        ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setScaleX(1.0f);
        ((AlphaPressedAutofitTextView) _$_findCachedViewById(i2)).setScaleY(1.0f);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        View view;
        super.onResume();
        this.o = VipManager.a.I();
        boolean n = User.d().n();
        if (this.o && n) {
            s0(new SyncVipInfoDoneEvent());
        }
        if (n && (view = this.f6883l) != null) {
            view.setVisibility(4);
            VdsAgent.onSetViewVisibility(view, 4);
        }
        if (this.q) {
            FragmentActivity activity = getActivity();
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).postAfterAllInited(new Runnable() { // from class: com.pinguo.camera360.member.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        C360MemberRightsFragmentView.J0(C360MemberRightsFragmentView.this);
                    }
                });
            }
        }
        this.q = false;
        this.r = false;
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        C360MemberPayHelp.getInstance().Z(this);
        initData();
        super.onViewCreated(view, bundle);
        if (us.pinguo.user.util.n.i() && CameraBusinessSettingModel.v().x()) {
            View view2 = this.f6883l;
            if (view2 != null) {
                view2.setVisibility(0);
                VdsAgent.onSetViewVisibility(view2, 0);
            }
            K0();
        } else {
            View view3 = this.f6883l;
            if (view3 != null) {
                view3.setVisibility(4);
                VdsAgent.onSetViewVisibility(view3, 4);
            }
        }
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item1)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item2)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item3)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item4)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item5)).setAlpha(0.0f);
        ((TextView) _$_findCachedViewById(R.id.vip_fun_item6)).setAlpha(0.0f);
        ((LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7)).setAlpha(0.0f);
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected void q0() {
        View view = this.f6883l;
        if (view != null && view.getVisibility() == 0) {
            AppCompatCheckBox appCompatCheckBox = this.m;
            if (appCompatCheckBox != null && appCompatCheckBox.isChecked()) {
                us.pinguo.user.u0.o = false;
            } else {
                us.pinguo.user.u0.o = true;
                return;
            }
        }
        super.q0();
        u0("click_sub_btn");
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected void s0(SyncVipInfoDoneEvent event) {
        long j2;
        kotlin.jvm.internal.s.h(event, "event");
        y0.c r = User.d().r(false);
        if (!r.d() && !VipManager.a.F()) {
            RechargePresenter c0 = c0();
            RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = null;
            String h2 = c0 == null ? null : c0.h();
            String a2 = us.pinguo.repository2020.abtest.c.a.a();
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("testProductId====>", a2), new Object[0]);
            RechargePresenter c02 = c0();
            MemberPriceInfo g2 = c02 == null ? null : c02.g();
            if (g2 != null) {
                if (!(h2 == null || h2.length() == 0)) {
                    RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo2 = null;
                    for (RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo3 : g2.getList()) {
                        if (kotlin.jvm.internal.s.c(rechargeGoodsDiscountInfo3.getProductId(), h2)) {
                            rechargeGoodsDiscountInfo = rechargeGoodsDiscountInfo3;
                        }
                        if (kotlin.jvm.internal.s.c(rechargeGoodsDiscountInfo3.getProductId(), a2) || kotlin.jvm.internal.s.c(rechargeGoodsDiscountInfo3.getProductId(), "vip_month_12")) {
                            rechargeGoodsDiscountInfo2 = rechargeGoodsDiscountInfo3;
                        }
                    }
                    RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo4 = rechargeGoodsDiscountInfo == null ? rechargeGoodsDiscountInfo2 : rechargeGoodsDiscountInfo;
                    if (rechargeGoodsDiscountInfo != null && rechargeGoodsDiscountInfo2 != null && !kotlin.jvm.internal.s.c(rechargeGoodsDiscountInfo, rechargeGoodsDiscountInfo2)) {
                        String price = rechargeGoodsDiscountInfo2.getPrice();
                        String price2 = rechargeGoodsDiscountInfo.getPrice();
                        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                        String string = getString(R.string.huawei_discount_price);
                        kotlin.jvm.internal.s.g(string, "getString(R.string.huawei_discount_price)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{price, price2}, 2));
                        kotlin.jvm.internal.s.g(format, "format(format, *args)");
                        int i2 = us.pinguo.user.util.n.i() ? 7 : 11;
                        SpannableString spannableString = new SpannableString(format);
                        spannableString.setSpan(new StrikethroughSpan(), 0, i2, 33);
                        ((TextView) _$_findCachedViewById(R.id.vip_price)).setText(spannableString);
                    } else if (rechargeGoodsDiscountInfo4 != null) {
                        kotlin.jvm.internal.x xVar2 = kotlin.jvm.internal.x.a;
                        String string2 = getString(R.string.vip_china_price_2);
                        kotlin.jvm.internal.s.g(string2, "getString(R.string.vip_china_price_2)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{rechargeGoodsDiscountInfo4.getPrice(), w0(rechargeGoodsDiscountInfo4.getPrice())}, 2));
                        kotlin.jvm.internal.s.g(format2, "format(format, *args)");
                        ((TextView) _$_findCachedViewById(R.id.vip_price)).setText(format2);
                    }
                } else if (a2 != null) {
                    Iterator<RechargeGoodsDiscountInfo> it = g2.getList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        RechargeGoodsDiscountInfo next = it.next();
                        if (kotlin.jvm.internal.s.c(next.getProductId(), a2)) {
                            this.t = next;
                            break;
                        }
                    }
                    RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo5 = this.t;
                    if (rechargeGoodsDiscountInfo5 != null) {
                        kotlin.jvm.internal.x xVar3 = kotlin.jvm.internal.x.a;
                        String string3 = getString(R.string.vip_china_price_2);
                        kotlin.jvm.internal.s.g(string3, "getString(R.string.vip_china_price_2)");
                        String format3 = String.format(string3, Arrays.copyOf(new Object[]{rechargeGoodsDiscountInfo5.getPrice(), w0(rechargeGoodsDiscountInfo5.getPrice())}, 2));
                        kotlin.jvm.internal.s.g(format3, "format(format, *args)");
                        ((TextView) _$_findCachedViewById(R.id.vip_price)).setText(format3);
                    }
                }
            }
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip)).setText(R.string.vip_fun_desc);
            ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_camera360_vip));
            AlphaPressedAutofitTextView alphaPressedAutofitTextView = (AlphaPressedAutofitTextView) _$_findCachedViewById(R.id.tlbtn_subscripte);
            alphaPressedAutofitTextView.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView, 0);
            TextView textView = (TextView) _$_findCachedViewById(R.id.vip_price);
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
            linearLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(linearLayout, 4);
            return;
        }
        ((AutofitTextView) _$_findCachedViewById(R.id.tv_vip_camera360)).setText(getString(R.string.text_vip_hello));
        if (!us.pinguo.user.s0.getInstance().e()) {
            int i3 = R.id.tlbtn_subscripte;
            ((AlphaPressedAutofitTextView) _$_findCachedViewById(i3)).setText(R.string.vip_bind_user);
            int i4 = R.id.vip_price;
            ((TextView) _$_findCachedViewById(i4)).setText(R.string.vip_bind_msg);
            TextView textView2 = (TextView) _$_findCachedViewById(i4);
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            AlphaPressedAutofitTextView alphaPressedAutofitTextView2 = (AlphaPressedAutofitTextView) _$_findCachedViewById(i3);
            alphaPressedAutofitTextView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView2, 0);
        } else {
            int i5 = R.id.tlbtn_subscripte;
            ((AlphaPressedAutofitTextView) _$_findCachedViewById(i5)).setText(R.string.go_on);
            int i6 = R.id.vip_price;
            ((TextView) _$_findCachedViewById(i6)).setText(R.string.vip_china_price);
            TextView textView3 = (TextView) _$_findCachedViewById(i6);
            textView3.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView3, 4);
            AlphaPressedAutofitTextView alphaPressedAutofitTextView3 = (AlphaPressedAutofitTextView) _$_findCachedViewById(i5);
            alphaPressedAutofitTextView3.setVisibility(4);
            VdsAgent.onSetViewVisibility(alphaPressedAutofitTextView3, 4);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN);
        VipManager vipManager = VipManager.a;
        if (vipManager.F()) {
            VipReemCodeInfo s = vipManager.s();
            j2 = (s == null ? 0.0f : s.getExpireTime()) * 1000;
        } else {
            j2 = r.b * 1000;
        }
        ((AutofitTextView) _$_findCachedViewById(R.id.tv_subs_vip_descrip)).setText(kotlin.jvm.internal.s.q(simpleDateFormat.format(new Date(j2)), getString(R.string.out_date)));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.vip_fun_item7);
        linearLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout2, 0);
    }

    public final boolean x0(Object obj) {
        if (obj != null) {
            try {
                if (Pattern.compile("[0-9][0-9]*\\.[0-9][0-9]*").matcher(obj.toString()).matches()) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
