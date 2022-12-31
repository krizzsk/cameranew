package com.pinguo.camera360.member;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.member.model.MemberPriceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.payssion.PayssionManager;
import us.pinguo.ui.b.a;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.R;
/* compiled from: MemberRightsActivity.kt */
/* loaded from: classes3.dex */
public final class MemberRightsActivity extends BaseToolbarActivity implements w0<RechargePresenter> {

    /* renamed from: g  reason: collision with root package name */
    private MemberPriceInfo f6888g;

    /* renamed from: h  reason: collision with root package name */
    private v0 f6889h;

    /* renamed from: j  reason: collision with root package name */
    private a.C0454a f6891j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6892k;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f6887f = new LinkedHashMap();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Fragment> f6890i = new ArrayList<>(3);

    /* compiled from: MemberRightsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a implements TextWatcher {
        final /* synthetic */ TextView a;

        a(TextView textView) {
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
    public static final void A0(MemberRightsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (us.pinguo.user.s0.getInstance().e()) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.g("", "vip_sub", "show");
        us.pinguo.user.s0.getInstance().a(this$0, 203, "vip_sub");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(MemberRightsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(MemberRightsActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void K0() {
        View decorView;
        us.pinguo.foundation.statistics.h.b.r("", "click_exchange_entry");
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_vip_redeem_code);
        Window window = dialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(t.a);
        TextView textView = (TextView) dialog.findViewById(R.id.atvTitle);
        if (textView != null) {
            textView.setText(R.string.text_enter_discount_code);
        }
        final TextView textView2 = (TextView) dialog.findViewById(R.id.tvRedeemCodeErrorHint);
        if (textView2 != null) {
            textView2.setText(R.string.hint_incorrect_discount_code);
        }
        final EditText editText = (EditText) dialog.findViewById(R.id.etRedeemCode);
        Button button = (Button) dialog.findViewById(R.id.btnComplete);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberRightsActivity.M0(editText, this, textView2, dialog, view);
                }
            });
        }
        if (editText != null) {
            editText.addTextChangedListener(new a(textView2));
        }
        if (isFinishing()) {
            return;
        }
        dialog.show();
        VdsAgent.showDialog(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(DialogInterface dialogInterface) {
        us.pinguo.foundation.statistics.h.b.r("", "user_close_exchange_view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(EditText editText, MemberRightsActivity this$0, TextView textView, Dialog dialog, View view) {
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
        String b = this$0.b();
        if (b == null || b.length() == 0) {
            p.dismiss();
            if (textView != null) {
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
            }
            if (textView == null) {
                return;
            }
            textView.setText(R.string.hint_incorrect_discount_code);
            return;
        }
        v0 v0Var = this$0.f6889h;
        if (v0Var == null) {
            return;
        }
        v0Var.a(b, str, new MemberRightsActivity$showDiscountCodeCheckDialog$2$1(p, str, this$0, editText, dialog, textView));
    }

    private final void y0() {
        a.C0454a c0454a;
        a.C0454a c0454a2 = this.f6891j;
        if (c0454a2 != null) {
            Boolean valueOf = c0454a2 == null ? null : Boolean.valueOf(c0454a2.b());
            kotlin.jvm.internal.s.e(valueOf);
            if (!valueOf.booleanValue() || (c0454a = this.f6891j) == null) {
                return;
            }
            c0454a.a();
        }
    }

    @Override // com.pinguo.camera360.member.w0
    public void A(MemberPriceInfo memberPriceInfo) {
        kotlin.jvm.internal.s.h(memberPriceInfo, "memberPriceInfo");
    }

    @Override // com.pinguo.camera360.member.a1
    /* renamed from: H0 */
    public void D(RechargePresenter presenter) {
        kotlin.jvm.internal.s.h(presenter, "presenter");
        this.f6889h = presenter;
    }

    public final void J0() {
        a.C0454a c0454a = this.f6891j;
        if (c0454a == null) {
            return;
        }
        c0454a.e();
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.f6887f;
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

    @Override // com.pinguo.camera360.member.w0
    public String b() {
        Object obj;
        Iterator<T> it = this.f6890i.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Fragment) obj) instanceof C360MemberRightsFragmentView) {
                break;
            }
        }
        C360MemberRightsFragmentView c360MemberRightsFragmentView = obj instanceof C360MemberRightsFragmentView ? (C360MemberRightsFragmentView) obj : null;
        if (c360MemberRightsFragmentView == null) {
            return null;
        }
        return c360MemberRightsFragmentView.b();
    }

    @Override // com.pinguo.camera360.member.w0
    public Activity g() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        PayssionManager.INSTANCE.handleActitvityResult(i2, i3, intent);
        if (i2 == 201 && i3 == -1) {
            v0 v0Var = this.f6889h;
            RechargePresenter rechargePresenter = v0Var instanceof RechargePresenter ? (RechargePresenter) v0Var : null;
            if (rechargePresenter != null) {
                rechargePresenter.f();
            }
        }
        ArrayList<Fragment> arrayList = this.f6890i;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (Fragment fragment : this.f6890i) {
            if (fragment instanceof C360MemberRightsFragmentView) {
                fragment.onActivityResult(i2, i3, intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.member.BaseToolbarActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6892k = false;
        PGEventBus.getInstance().b(this);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(1280);
        }
        new RechargePresenter(this);
        this.f6891j = us.pinguo.ui.b.a.b(this, getString(R.string.load_more));
        z0();
        ((TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberRightsActivity.G0(MemberRightsActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.pinguo.camera360.member.BaseToolbarActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PGEventBus.getInstance().c(this);
    }

    public final void onEvent(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.common.log.a.m("MemberRightsActivity", "onEvent SyncVipInfoDoneEvent ", new Object[0]);
        z0();
        y0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!User.d().n() && !User.d().r(false).d()) {
            TextView s0 = s0();
            if (s0 == null) {
                return;
            }
            s0.setVisibility(0);
            VdsAgent.onSetViewVisibility(s0, 0);
            return;
        }
        TextView s02 = s0();
        if (s02 == null) {
            return;
        }
        s02.setVisibility(4);
        VdsAgent.onSetViewVisibility(s02, 4);
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    protected int q0() {
        return R.layout.activity_member_right_layout;
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    public void w0() {
        if (this.f6892k) {
            Toolbar r0 = r0();
            kotlin.jvm.internal.s.e(r0);
            r0.setNavigationIcon(R.drawable.back_white);
            TextView t0 = t0();
            if (t0 != null) {
                t0.setTextColor(-1);
            }
            TextView s0 = s0();
            if (s0 != null) {
                s0.setTextColor(-1);
            }
            ((TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon)).setTextColor(-1);
            ((ImageView) _$_findCachedViewById(R.id.vDivider)).setColorFilter(-1);
        } else {
            Toolbar r02 = r0();
            kotlin.jvm.internal.s.e(r02);
            r02.setNavigationIcon(R.drawable.vip_purchase_back);
            TextView t02 = t0();
            if (t02 != null) {
                t02.setTextColor(-12827572);
            }
            TextView s02 = s0();
            if (s02 != null) {
                s02.setTextColor(-8092540);
            }
            ((TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon)).setTextColor(-8092540);
            ((ImageView) _$_findCachedViewById(R.id.vDivider)).setColorFilter(-8092540);
        }
        Toolbar r03 = r0();
        kotlin.jvm.internal.s.e(r03);
        r03.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberRightsActivity.I0(MemberRightsActivity.this, view);
            }
        });
    }

    public final void z0() {
        boolean z;
        boolean z2;
        v0 v0Var = this.f6889h;
        Objects.requireNonNull(v0Var, "null cannot be cast to non-null type com.pinguo.camera360.member.RechargePresenter");
        this.f6888g = ((RechargePresenter) v0Var).g();
        y0.c r = User.d().r(false);
        if (this.f6890i.size() == 0) {
            if (r.a()) {
                ((ImageView) _$_findCachedViewById(R.id.head_bg)).setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, 0, 0, 0);
                ((ViewPager) _$_findCachedViewById(R.id.member_view_pager)).setLayoutParams(layoutParams);
                this.f6890i.add(C360MemberRightsFragmentView.u.a(null));
            } else if (r.c()) {
                int i2 = R.id.head_bg;
                ((ImageView) _$_findCachedViewById(i2)).setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(3, ((ImageView) _$_findCachedViewById(i2)).getId());
                layoutParams2.setMargins(us.pinguo.foundation.t.b.a.a(this, 20.0f), -us.pinguo.foundation.t.b.a.a(this, 90.0f), us.pinguo.foundation.t.b.a.a(this, 20.0f), 0);
                ((ViewPager) _$_findCachedViewById(R.id.member_view_pager)).setLayoutParams(layoutParams2);
                this.f6890i.add(MiguMemberRightsFragmentView.f6893l.a(null));
                this.f6892k = true;
            } else if (r.b()) {
                int i3 = R.id.head_bg;
                ((ImageView) _$_findCachedViewById(i3)).setVisibility(0);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(3, ((ImageView) _$_findCachedViewById(i3)).getId());
                layoutParams3.setMargins(us.pinguo.foundation.t.b.a.a(this, 20.0f), -us.pinguo.foundation.t.b.a.a(this, 90.0f), us.pinguo.foundation.t.b.a.a(this, 20.0f), 0);
                ((ViewPager) _$_findCachedViewById(R.id.member_view_pager)).setLayoutParams(layoutParams3);
                this.f6890i.add(MMMemberRightsFragmentView.f6884l.a(null));
                this.f6892k = true;
            } else if (!getIntent().getBooleanExtra("is_from_notice", false)) {
                ((ImageView) _$_findCachedViewById(R.id.head_bg)).setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams4.setMargins(0, 0, 0, 0);
                ((ViewPager) _$_findCachedViewById(R.id.member_view_pager)).setLayoutParams(layoutParams4);
                Bundle bundle = new Bundle();
                MemberPriceInfo memberPriceInfo = this.f6888g;
                if (!(memberPriceInfo != null && memberPriceInfo.getMiguway() == 1)) {
                    MemberPriceInfo memberPriceInfo2 = this.f6888g;
                    if (!(memberPriceInfo2 != null && memberPriceInfo2.getMmgzway() == 1)) {
                        z2 = false;
                        bundle.putBoolean("is_show_united_vip", z2);
                        this.f6890i.add(C360MemberRightsFragmentView.u.a(bundle));
                    }
                }
                z2 = true;
                bundle.putBoolean("is_show_united_vip", z2);
                this.f6890i.add(C360MemberRightsFragmentView.u.a(bundle));
            } else {
                int i4 = R.id.head_bg;
                ((ImageView) _$_findCachedViewById(i4)).setVisibility(0);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams5.addRule(3, ((ImageView) _$_findCachedViewById(i4)).getId());
                layoutParams5.setMargins(us.pinguo.foundation.t.b.a.a(this, 20.0f), -us.pinguo.foundation.t.b.a.a(this, 90.0f), us.pinguo.foundation.t.b.a.a(this, 20.0f), 0);
                int i5 = R.id.member_view_pager;
                ((ViewPager) _$_findCachedViewById(i5)).setLayoutParams(layoutParams5);
                MemberPriceInfo memberPriceInfo3 = this.f6888g;
                if (memberPriceInfo3 != null && memberPriceInfo3.getMiguway() == 1) {
                    this.f6890i.add(MiguMemberRightsFragmentView.f6893l.a(null));
                    this.f6892k = true;
                }
                MemberPriceInfo memberPriceInfo4 = this.f6888g;
                if (memberPriceInfo4 != null && memberPriceInfo4.getMmgzway() == 1) {
                    this.f6890i.add(MMMemberRightsFragmentView.f6884l.a(null));
                    this.f6892k = true;
                }
                if (this.f6890i.size() == 0) {
                    ((ImageView) _$_findCachedViewById(i4)).setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams6.setMargins(0, 0, 0, 0);
                    ((ViewPager) _$_findCachedViewById(i5)).setLayoutParams(layoutParams6);
                    this.f6890i.add(C360MemberRightsFragmentView.u.a(null));
                }
            }
            int i6 = R.id.member_view_pager;
            ((ViewPager) _$_findCachedViewById(i6)).setPageMargin(getResources().getDimensionPixelSize(R.dimen.vip_viewpager_content_margin));
            if (this.f6890i.size() > 0) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                kotlin.jvm.internal.s.g(supportFragmentManager, "supportFragmentManager");
                ((ViewPager) _$_findCachedViewById(i6)).setAdapter(new z0(supportFragmentManager, this.f6890i));
            }
            PagerAdapter adapter = ((ViewPager) _$_findCachedViewById(i6)).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            loop0: while (true) {
                z = false;
                for (Fragment fragment : this.f6890i) {
                    if (r.d()) {
                        if (this.f6890i.size() == 1) {
                            if (fragment instanceof C360MemberRightsFragmentView) {
                                if (r.a()) {
                                    break;
                                }
                            }
                            if (fragment instanceof MiguMemberRightsFragmentView) {
                                if (r.c()) {
                                    break;
                                }
                            }
                            if ((fragment instanceof MMMemberRightsFragmentView) && r.b()) {
                                break;
                            }
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            if (z) {
                this.f6890i.clear();
                z0();
            }
        }
        if (!us.pinguo.user.s0.getInstance().e()) {
            TextView s0 = s0();
            if (s0 != null) {
                s0.setText(getString(R.string.text_restoring_purchases));
            }
            TextView s02 = s0();
            if (s02 != null) {
                s02.setVisibility(0);
                VdsAgent.onSetViewVisibility(s02, 0);
            }
            TextView s03 = s0();
            if (s03 != null) {
                s03.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MemberRightsActivity.A0(MemberRightsActivity.this, view);
                    }
                });
            }
        } else {
            TextView s04 = s0();
            if (s04 != null) {
                s04.setVisibility(8);
                VdsAgent.onSetViewVisibility(s04, 8);
            }
        }
        if (!User.d().r(false).d()) {
            v0 v0Var2 = this.f6889h;
            RechargePresenter rechargePresenter = v0Var2 instanceof RechargePresenter ? (RechargePresenter) v0Var2 : null;
            if (!us.pinguo.edit2020.utils.d.d(rechargePresenter != null ? rechargePresenter.h() : null)) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon);
                textView.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView, 0);
                TextView s05 = s0();
                if (s05 != null && s05.getVisibility() == 0) {
                    ((ImageView) _$_findCachedViewById(R.id.vDivider)).setVisibility(0);
                    return;
                } else {
                    ((ImageView) _$_findCachedViewById(R.id.vDivider)).setVisibility(8);
                    return;
                }
            }
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.txtSubtitleCoupon);
        textView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView2, 8);
        ((ImageView) _$_findCachedViewById(R.id.vDivider)).setVisibility(8);
    }
}
