package com.pinguo.camera360.camera.options;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.camera.view.VipRedeemCodeDialog;
import com.pinguo.camera360.member.MemberRightsActivity;
import com.pinguo.camera360.member.SubscriptionMemberActivity;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.camera360.vip.VipReemCodeInfo;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.ui.view.CommonItemView;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.ui.n0;
import us.pinguo.user.ui.o0;
import us.pinguo.user.v0;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.R;
/* compiled from: MySettingLoginFragment.kt */
/* loaded from: classes3.dex */
public final class MySettingLoginFragment extends SubscriptionFragment implements o0 {
    public Map<Integer, View> a = new LinkedHashMap();
    private final n0 b = new n0();

    /* compiled from: MySettingLoginFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements VipRedeemCodeDialog.a {
        a() {
        }

        @Override // com.pinguo.camera360.camera.view.VipRedeemCodeDialog.a
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MySettingLoginFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(MySettingLoginFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FragmentActivity requireActivity = this$0.requireActivity();
        MyActivity myActivity = requireActivity instanceof MyActivity ? (MyActivity) requireActivity : null;
        if (myActivity != null) {
            MyActivity.C0(myActivity, "Inspire", "us.pinguo.foundation.base.InspireContentActivity", "us.pinguo.inspire.module.message.category.fragment.InspireMsgFragment", null, 8, null);
        }
        us.pinguo.foundation.statistics.h.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(MySettingLoginFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Intent intent = new Intent();
        VipManager vipManager = VipManager.a;
        if (!vipManager.G() && !vipManager.H()) {
            intent.setClass(this$0.requireActivity(), MemberRightsActivity.class);
        } else {
            intent.setClass(this$0.requireActivity(), SubscriptionMemberActivity.class);
            intent.putExtra("subscription_status", true);
        }
        intent.putExtra("source_page", "personal_center");
        intent.putExtra("source_extra", "personal_center");
        if (vipManager.I()) {
            us.pinguo.foundation.statistics.h.a.q0("goto_sub_vip_center", "click");
        } else {
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            cVar.c0("setting");
            cVar.q0("goto_free_trial", "click");
        }
        this$0.startActivityForResult(intent, 1004);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(MySettingLoginFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.b.x0("", "click_exchange_entry");
        FragmentActivity activity = this$0.getActivity();
        kotlin.jvm.internal.s.e(activity);
        kotlin.jvm.internal.s.g(activity, "activity!!");
        VipRedeemCodeDialog vipRedeemCodeDialog = new VipRedeemCodeDialog(activity, 0, 2, null);
        vipRedeemCodeDialog.e(new a());
        vipRedeemCodeDialog.show();
        VdsAgent.showDialog(vipRedeemCodeDialog);
    }

    private final void i0() {
        if (us.pinguo.foundation.g.a()) {
            TextView b = ((CommonItemView) _$_findCachedViewById(R.id.messageView)).b();
            b.setVisibility(8);
            VdsAgent.onSetViewVisibility(b, 8);
            return;
        }
        TextView b2 = ((CommonItemView) _$_findCachedViewById(R.id.messageView)).b();
        b2.setVisibility(8);
        VdsAgent.onSetViewVisibility(b2, 8);
    }

    private final void j0() {
        VipManager vipManager = VipManager.a;
        if (vipManager.I()) {
            if (vipManager.F()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN);
                VipReemCodeInfo s = vipManager.s();
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(kotlin.jvm.internal.s.q(simpleDateFormat.format(new Date((s == null ? 0.0f : s.getExpireTime()) * ((float) 1000))), getString(R.string.out_date)));
            } else if (!vipManager.G() && !vipManager.H()) {
                if (y0.g(getActivity()).d()) {
                    ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(kotlin.jvm.internal.s.q(new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN).format(new Date(y0.g(getActivity()).b * 1000)), getString(R.string.out_date)));
                }
            } else {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - vipManager.z()) / AdvTimeUtils.MILLIS_OF_A_DAY) + 1);
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                String quantityString = getResources().getQuantityString(R.plurals.text_become_member_days, currentTimeMillis);
                kotlin.jvm.internal.s.g(quantityString, "resources.getQuantityStr…become_member_days, days)");
                String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(currentTimeMillis)}, 1));
                kotlin.jvm.internal.s.g(format, "format(format, *args)");
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(format);
            }
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.llVipRedeemCodeLayout);
            linearLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(linearLayout, 8);
        } else {
            ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(getString(R.string.text_myactivity_vip_right));
            LinearLayout llVipRedeemCodeLayout = (LinearLayout) _$_findCachedViewById(R.id.llVipRedeemCodeLayout);
            kotlin.jvm.internal.s.g(llVipRedeemCodeLayout, "llVipRedeemCodeLayout");
            int i2 = CameraBusinessSettingModel.v().C() ? 0 : 8;
            llVipRedeemCodeLayout.setVisibility(i2);
            VdsAgent.onSetViewVisibility(llVipRedeemCodeLayout, i2);
        }
        ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setContetntLeftDrawable(R.drawable.vector_vip);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.subscription_vip_layout);
        linearLayout2.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout2, 0);
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.a;
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

    @Override // us.pinguo.user.ui.o0
    public void dismiss() {
    }

    @Override // us.pinguo.user.ui.o0
    public View getDecorView() {
        return getDecorView();
    }

    @Override // us.pinguo.user.ui.o0
    public Fragment getFragment() {
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.b.A(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            VipManager vipManager = VipManager.a;
            if (!vipManager.G() && !vipManager.H()) {
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(kotlin.jvm.internal.s.q(new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN).format(new Date(y0.g(getActivity()).b * 1000)), getString(R.string.out_date)));
            } else {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - vipManager.z()) / AdvTimeUtils.MILLIS_OF_A_DAY) + 1);
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                String quantityString = getResources().getQuantityString(R.plurals.text_become_member_days, currentTimeMillis);
                kotlin.jvm.internal.s.g(quantityString, "resources.getQuantityStr…become_member_days, days)");
                String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(currentTimeMillis)}, 1));
                kotlin.jvm.internal.s.g(format, "format(format, *args)");
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(format);
            }
        }
        if (i2 == 1006) {
            v0.i(0, 1006);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        PGEventBus.getInstance().b(this);
        this.b.H("personal_center");
        this.b.attachView(this);
        View inflate = inflater.inflate(R.layout.my_setting_login_layout, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        inflate.findViewById(R.id.layout_login).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.camera.options.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MySettingLoginFragment.e0(MySettingLoginFragment.this, view);
            }
        });
        CommonItemView commonItemView = (CommonItemView) inflate.findViewById(R.id.messageView);
        if (commonItemView != null) {
            commonItemView.setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.n
                @Override // us.pinguo.foundation.ui.view.CommonItemView.a
                public final void onItemClick(View view) {
                    MySettingLoginFragment.f0(MySettingLoginFragment.this, view);
                }
            });
        }
        View findViewById = inflate.findViewById(R.id.subscriptionVip);
        kotlin.jvm.internal.s.g(findViewById, "rootView.findViewById(R.id.subscriptionVip)");
        CommonItemView commonItemView2 = (CommonItemView) findViewById;
        commonItemView2.f();
        commonItemView2.setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.k
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MySettingLoginFragment.g0(MySettingLoginFragment.this, view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.vipRedeemCode);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type us.pinguo.foundation.ui.view.CommonItemView");
        ((CommonItemView) findViewById2).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.l
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MySettingLoginFragment.h0(MySettingLoginFragment.this, view);
            }
        });
        return inflate;
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.b.detachView();
        PGEventBus.getInstance().c(this);
        _$_clearFindViewByIdCache();
    }

    public final void onEvent(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        j0();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        j0();
        i0();
        if (VipManager.a.I()) {
            us.pinguo.foundation.statistics.h.a.q0("goto_sub_vip_center", "show");
        } else {
            us.pinguo.foundation.statistics.h.a.q0("goto_free_trial", "show");
        }
    }

    @Override // us.pinguo.user.ui.o0
    public void phoneBind() {
        Intent intent = new Intent();
        intent.setClassName(us.pinguo.foundation.e.b(), "us.pinguo.inspire.PhoneBindActivity");
        startActivityForResult(intent, 1006);
    }
}
