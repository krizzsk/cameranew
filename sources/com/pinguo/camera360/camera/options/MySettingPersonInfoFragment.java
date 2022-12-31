package com.pinguo.camera360.camera.options;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import rx.functions.Action1;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.ui.view.CommonItemView;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.profile.GeoManager;
import us.pinguo.inspire.module.profile.InspireLocationManager;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.loader.ProfileLoader;
import us.pinguo.user.model.ProfileAuthorInfo;
import us.pinguo.user.model.ProfileEntry;
import us.pinguo.user.y0;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* compiled from: MySettingPersonInfoFragment.kt */
/* loaded from: classes3.dex */
public final class MySettingPersonInfoFragment extends SubscriptionFragment {
    public Map<Integer, View> a = new LinkedHashMap();

    /* compiled from: MySettingPersonInfoFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements VipRedeemCodeDialog.a {
        a() {
        }

        @Override // com.pinguo.camera360.camera.view.VipRedeemCodeDialog.a
        public void a() {
        }
    }

    private final void a0() {
        ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.q
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MySettingPersonInfoFragment.b0(MySettingPersonInfoFragment.this, view);
            }
        });
        CommonItemView commonItemView = (CommonItemView) _$_findCachedViewById(R.id.vipRedeemCode);
        if (commonItemView == null) {
            return;
        }
        commonItemView.setOnItemClickListener(new CommonItemView.a() { // from class: com.pinguo.camera360.camera.options.o
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                MySettingPersonInfoFragment.c0(MySettingPersonInfoFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(MySettingPersonInfoFragment this$0, View view) {
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
        this$0.startActivityForResult(intent, 1004);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(MySettingPersonInfoFragment this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.b.x0("", "click_exchange_entry");
        FragmentActivity requireActivity = this$0.requireActivity();
        kotlin.jvm.internal.s.g(requireActivity, "requireActivity()");
        VipRedeemCodeDialog vipRedeemCodeDialog = new VipRedeemCodeDialog(requireActivity, 0, 2, null);
        vipRedeemCodeDialog.e(new a());
        vipRedeemCodeDialog.show();
        VdsAgent.showDialog(vipRedeemCodeDialog);
    }

    private final void d0(String str) {
        if (str == null) {
            return;
        }
        addSubscription(new ProfileLoader().a(str).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MySettingPersonInfoFragment.e0(MySettingPersonInfoFragment.this, (ProfileEntry) obj);
            }
        }, u.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MySettingPersonInfoFragment this$0, ProfileEntry profileEntry) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if ((profileEntry == null ? null : profileEntry.authorInfo) != null) {
            User.Info h2 = User.d().h();
            if (h2 != null) {
                h2.mark = profileEntry.authorInfo.mark;
            }
            User.v(h2);
        }
        this$0.u0(profileEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(MySettingPersonInfoFragment this$0, us.pinguo.inspire_proxy.a.a aVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    private final void r0() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.user.event.a.class).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.s
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MySettingPersonInfoFragment.s0(MySettingPersonInfoFragment.this, (us.pinguo.user.event.a) obj);
            }
        }, p.a));
    }

    private final void registerFeedDeleteEvent() {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire_proxy.a.a.class).subscribe(new Action1() { // from class: com.pinguo.camera360.camera.options.w
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MySettingPersonInfoFragment.p0(MySettingPersonInfoFragment.this, (us.pinguo.inspire_proxy.a.a) obj);
            }
        }, t.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(MySettingPersonInfoFragment this$0, us.pinguo.user.event.a aVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        Inspire.f(th);
    }

    private final void u0(ProfileEntry profileEntry) {
        ProfileAuthorInfo profileAuthorInfo;
        y0();
        if (profileEntry == null || (profileAuthorInfo = profileEntry.authorInfo) == null) {
            return;
        }
        int i2 = profileAuthorInfo.gender;
        if (i2 == 1) {
            int i3 = R.id.profile_user_gender;
            ((ImageView) _$_findCachedViewById(i3)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(i3)).setImageResource(R.drawable.profile_gender_mile);
        } else if (i2 == 2) {
            int i4 = R.id.profile_user_gender;
            ((ImageView) _$_findCachedViewById(i4)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(i4)).setImageResource(R.drawable.profile_gender_femile);
        } else {
            ((ImageView) _$_findCachedViewById(R.id.profile_user_gender)).setVisibility(8);
        }
        int i5 = R.id.profile_geo;
        TextView textView = (TextView) _$_findCachedViewById(i5);
        InspireGeo inspireGeo = profileAuthorInfo.geo;
        textView.setText(inspireGeo == null ? "" : inspireGeo.toString());
        int i6 = R.id.profile_avatar;
        ((PortraitImageView) _$_findCachedViewById(i6)).setUserType(profileAuthorInfo.type);
        ((PortraitImageView) _$_findCachedViewById(i6)).invalidate();
        if (profileAuthorInfo.geo != null) {
            TextView textView2 = (TextView) _$_findCachedViewById(i5);
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            InspireLocationManager inspireLocationManager = InspireLocationManager.getInstance();
            InspireGeo inspireGeo2 = profileAuthorInfo.geo;
            inspireLocationManager.getGeo(inspireGeo2.country, inspireGeo2.province, inspireGeo2.city, new InspireLocationManager.LocationResultListener() { // from class: com.pinguo.camera360.camera.options.r
                @Override // us.pinguo.inspire.module.profile.InspireLocationManager.LocationResultListener
                public final void onResult(InspireGeo inspireGeo3) {
                    MySettingPersonInfoFragment.v0(MySettingPersonInfoFragment.this, inspireGeo3);
                }
            });
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(i5);
        textView3.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView3, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(MySettingPersonInfoFragment this$0, InspireGeo inspireGeo) {
        String inspireGeo2;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        TextView textView = (TextView) this$0._$_findCachedViewById(R.id.profile_geo);
        String str = "";
        if (inspireGeo != null && (inspireGeo2 = inspireGeo.toString()) != null) {
            str = inspireGeo2;
        }
        textView.setText(str);
    }

    private final void w0() {
        if (User.d().n()) {
            User.Info h2 = User.d().h();
            d0(h2 == null ? null : h2.userId);
        }
    }

    private final void x0() {
        if (us.pinguo.foundation.g.a()) {
            TextView b = ((CommonItemView) _$_findCachedViewById(R.id.messageView)).b();
            b.setVisibility(0);
            VdsAgent.onSetViewVisibility(b, 0);
        } else {
            TextView b2 = ((CommonItemView) _$_findCachedViewById(R.id.messageView)).b();
            b2.setVisibility(8);
            VdsAgent.onSetViewVisibility(b2, 8);
        }
        if (us.pinguo.foundation.g.b() > 0) {
            ((CommonItemView) _$_findCachedViewById(R.id.follow)).setRightCount(us.pinguo.foundation.g.b(), true);
        } else {
            ((CommonItemView) _$_findCachedViewById(R.id.follow)).setRightCount(0);
        }
    }

    private final void y0() {
        User d2 = User.d();
        if (!d2.n() || d2.h() == null) {
            return;
        }
        int i2 = R.id.profile_avatar;
        ((PortraitImageView) _$_findCachedViewById(i2)).setUserId(d2.h().userId);
        ((PortraitImageView) _$_findCachedViewById(i2)).setImageUri(d2.h().avatar, R.drawable.default_avatar);
        ((TextView) _$_findCachedViewById(R.id.profile_user_name)).setText(d2.h().nickname);
        if (TextUtils.isEmpty(d2.h().description)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.profile_motto);
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
            return;
        }
        int i3 = R.id.profile_motto;
        TextView textView2 = (TextView) _$_findCachedViewById(i3);
        textView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView2, 0);
        ((TextView) _$_findCachedViewById(i3)).setText(d2.h().description);
    }

    private final void z0() {
        VipManager vipManager = VipManager.a;
        if (vipManager.I()) {
            if (vipManager.F()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN);
                VipReemCodeInfo s = vipManager.s();
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(kotlin.jvm.internal.s.q(simpleDateFormat.format(new Date((s == null ? 0.0f : s.getExpireTime()) * 1000)), getString(R.string.out_date)));
            } else if ((vipManager.G() || vipManager.H()) && !y0.g(getActivity()).d()) {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - vipManager.z()) / AdvTimeUtils.MILLIS_OF_A_DAY) + 1);
                kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                String quantityString = getResources().getQuantityString(R.plurals.text_become_member_days, currentTimeMillis);
                kotlin.jvm.internal.s.g(quantityString, "resources.getQuantityStr…become_member_days, days)");
                String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(currentTimeMillis)}, 1));
                kotlin.jvm.internal.s.g(format, "format(format, *args)");
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(format);
            } else if (y0.g(getActivity()).d()) {
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(kotlin.jvm.internal.s.q(new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN).format(new Date(y0.g(getActivity()).b * 1000)), getString(R.string.out_date)));
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            VipManager vipManager = VipManager.a;
            int z = (int) (((currentTimeMillis - vipManager.z()) / AdvTimeUtils.MILLIS_OF_A_DAY) + 1);
            if (!vipManager.G() && !vipManager.H()) {
                ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(kotlin.jvm.internal.s.q(new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN).format(new Date(y0.g(getActivity()).b * 1000)), getString(R.string.out_date)));
                return;
            }
            kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
            String quantityString = getResources().getQuantityString(R.plurals.text_become_member_days, z);
            kotlin.jvm.internal.s.g(quantityString, "resources.getQuantityStr…_become_member_days,days)");
            String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(z)}, 1));
            kotlin.jvm.internal.s.g(format, "format(format, *args)");
            ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).setRightCount2(format);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        super.onCreateView(inflater, viewGroup, bundle);
        PGEventBus.getInstance().b(this);
        registerFeedDeleteEvent();
        r0();
        return inflater.inflate(R.layout.personal_info_layout, (ViewGroup) null);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GeoManager.unsubscription();
        PGEventBus.getInstance().c(this);
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onEvent(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        z0();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        z0();
        x0();
        w0();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        w0();
        ((CommonItemView) _$_findCachedViewById(R.id.subscriptionVip)).f();
        a0();
    }
}
