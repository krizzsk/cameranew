package com.pinguo.camera360.member;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.member.model.MemberPriceInfo;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.camera360.member.w0;
import com.pinguo.camera360.vip.VipManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.inspire.Inspire;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.user.User;
import us.pinguo.user.event.PayClickEvent;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.ui.FastLoginDialog;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.R;
/* compiled from: BaseMemberRightsFragmentView.kt */
/* loaded from: classes3.dex */
public class BaseMemberRightsFragmentView extends BaseFragment implements us.pinguo.paylibcenter.e, w0<RechargePresenter>, us.pinguo.camera360.shop.manager.v0 {
    private RecyclerView b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f6866d;

    /* renamed from: e  reason: collision with root package name */
    private BottomSheetDialog f6867e;

    /* renamed from: g  reason: collision with root package name */
    private CompositeSubscription f6869g;

    /* renamed from: h  reason: collision with root package name */
    private RechargePresenter f6870h;

    /* renamed from: i  reason: collision with root package name */
    private DividerItemDecoration f6871i;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final int f6868f = 5;

    private final void a0() {
        BottomSheetDialog bottomSheetDialog;
        BottomSheetDialog bottomSheetDialog2 = this.f6867e;
        if (bottomSheetDialog2 != null) {
            kotlin.jvm.internal.s.e(bottomSheetDialog2);
            if (!bottomSheetDialog2.isShowing() || (bottomSheetDialog = this.f6867e) == null) {
                return;
            }
            bottomSheetDialog.dismiss();
        }
    }

    private final void addSubscription(Subscription subscription) {
        if (this.f6869g == null) {
            this.f6869g = new CompositeSubscription();
        }
        CompositeSubscription compositeSubscription = this.f6869g;
        kotlin.jvm.internal.s.e(compositeSubscription);
        compositeSubscription.add(subscription);
    }

    private final long b0() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 24);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    private final void e0() {
        View inflate = View.inflate(getActivity(), R.layout.dialog_c360_member_price_layout, null);
        this.b = (RecyclerView) inflate.findViewById(R.id.c360_recharge_detail_list);
        this.c = inflate.findViewById(R.id.open_member);
        View findViewById = inflate.findViewById(R.id.vip_title);
        kotlin.jvm.internal.s.g(findViewById, "priceView.findViewById(R.id.vip_title)");
        TextView textView = (TextView) findViewById;
        this.f6866d = textView;
        if (this instanceof C360MemberRightsFragmentView) {
            if (textView == null) {
                kotlin.jvm.internal.s.z("mVipTitle");
                throw null;
            }
            textView.setText(R.string.c360_vip_title);
        } else if (this instanceof MiguMemberRightsFragmentView) {
            if (textView == null) {
                kotlin.jvm.internal.s.z("mVipTitle");
                throw null;
            }
            textView.setText(R.string.migu_vip_title);
        } else if (this instanceof MMMemberRightsFragmentView) {
            if (textView == null) {
                kotlin.jvm.internal.s.z("mVipTitle");
                throw null;
            }
            textView.setText(R.string.mm_vip_title);
        }
        View view = this.c;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.member.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseMemberRightsFragmentView.f0(BaseMemberRightsFragmentView.this, view2);
                }
            });
        }
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(g());
        this.f6867e = bottomSheetDialog;
        if (bottomSheetDialog == null) {
            return;
        }
        bottomSheetDialog.setContentView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(BaseMemberRightsFragmentView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.q0();
        this$0.a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(BaseMemberRightsFragmentView this$0, us.pinguo.foundation.r.b bVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (us.pinguo.foundation.utils.j.a(1000L)) {
            return;
        }
        int i2 = bVar.a.getInt(FastLoginDialog.KEY_REQ_CODE);
        if (User.d().r(false).d()) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (i2 != 203) {
            this$0.q0();
        }
        if (i2 == 203) {
            us.pinguo.foundation.utils.j0.d(this$0.getString(R.string.text_resume_purchase_success));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(BaseMemberRightsFragmentView this$0, RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            us.pinguo.foundation.d.f10992k = true;
            this$0.i(true, rechargeGoodsDiscountInfo);
            return;
        }
        us.pinguo.foundation.d.f10992k = false;
        this$0.i(false, rechargeGoodsDiscountInfo);
    }

    private final void registerLoginEvent() {
        Subscription subscription = us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: com.pinguo.camera360.member.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                BaseMemberRightsFragmentView.m0(BaseMemberRightsFragmentView.this, (us.pinguo.foundation.r.b) obj);
            }
        }, d.a);
        kotlin.jvm.internal.s.g(subscription, "subscription");
        addSubscription(subscription);
    }

    @Override // com.pinguo.camera360.member.w0
    public void A(MemberPriceInfo memberPriceInfo) {
        String h2;
        kotlin.jvm.internal.s.h(memberPriceInfo, "memberPriceInfo");
        RechargePresenter rechargePresenter = this.f6870h;
        List<RechargeGoodsDiscountInfo> list = null;
        if (rechargePresenter != null && (h2 = rechargePresenter.h()) != null) {
            List<RechargeGoodsDiscountInfo> list2 = memberPriceInfo.getList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (kotlin.jvm.internal.s.c(h2, ((RechargeGoodsDiscountInfo) obj).getProductId())) {
                    arrayList.add(obj);
                }
            }
            list = arrayList;
        }
        RecyclerView recyclerView = this.b;
        boolean z = false;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        }
        if ((list == null || list.isEmpty()) ? true : true) {
            list = memberPriceInfo.getList();
        }
        d1 d1Var = new d1(list);
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(d1Var);
        }
        RecyclerView recyclerView3 = this.b;
        if (recyclerView3 != null) {
            DividerItemDecoration dividerItemDecoration = this.f6871i;
            kotlin.jvm.internal.s.e(dividerItemDecoration);
            recyclerView3.removeItemDecoration(dividerItemDecoration);
        }
        RecyclerView recyclerView4 = this.b;
        if (recyclerView4 != null) {
            DividerItemDecoration dividerItemDecoration2 = this.f6871i;
            kotlin.jvm.internal.s.e(dividerItemDecoration2);
            recyclerView4.addItemDecoration(dividerItemDecoration2);
        }
        RechargePresenter rechargePresenter2 = this.f6870h;
        if (rechargePresenter2 == null) {
            return;
        }
        rechargePresenter2.c(memberPriceInfo);
    }

    @Override // us.pinguo.paylibcenter.e
    public void S(Activity activity, String str, PayCallback payCallback) {
        Intent intent = new Intent(activity, PayChinaMobileWebViewActivity.class);
        intent.putExtra("url", str);
        if (activity == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f6868f);
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    @Override // com.pinguo.camera360.member.w0
    public String b() {
        return w0.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RechargePresenter c0() {
        return this.f6870h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RechargeGoodsDiscountInfo d0() {
        RecyclerView recyclerView = this.b;
        RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
        d1 d1Var = adapter instanceof d1 ? (d1) adapter : null;
        if (d1Var == null) {
            return null;
        }
        return d1Var.e();
    }

    @Override // com.pinguo.camera360.member.w0
    public Activity g() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.s.e(activity);
        kotlin.jvm.internal.s.g(activity, "activity!!");
        return activity;
    }

    @Override // us.pinguo.camera360.shop.manager.v0
    public void i(boolean z, RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo) {
        if (z) {
            y0.c r = User.d().r(false);
            long b0 = b0();
            if (r.b == 0) {
                r.b = b0;
            }
            Integer valueOf = rechargeGoodsDiscountInfo == null ? null : Integer.valueOf(rechargeGoodsDiscountInfo.getMonth());
            kotlin.jvm.internal.s.e(valueOf);
            us.pinguo.user.y0.o(getActivity(), 1, (valueOf.intValue() * 60 * 60 * 24 * 30) + r.b);
            User.d().r(true);
            RechargePresenter rechargePresenter = this.f6870h;
            Objects.requireNonNull(rechargePresenter, "null cannot be cast to non-null type com.pinguo.camera360.member.RechargePresenter");
            rechargePresenter.p(z);
            us.pinguo.common.log.a.k("curNightTime = " + b0 + " product.month = " + rechargeGoodsDiscountInfo.getMonth() + "vipInfo.vipExpire =  " + r.b, new Object[0]);
            CameraBusinessSettingModel.v().G("key_sync_vip_time", 0L);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        l0(z, rechargeGoodsDiscountInfo);
    }

    public void k0() {
    }

    public final void l0(boolean z, RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo) {
        String stringExtra;
        String stringExtra2;
        FragmentActivity activity = getActivity();
        Intent intent = activity == null ? null : activity.getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("source_page")) == null || (stringExtra2 = intent.getStringExtra("source_extra")) == null) {
            return;
        }
        if (z) {
            us.pinguo.foundation.statistics.h.a.v0("vip_sub_success_action", rechargeGoodsDiscountInfo != null ? rechargeGoodsDiscountInfo.getProductId() : null, stringExtra, stringExtra2, "sub_success", "1");
        } else {
            us.pinguo.foundation.statistics.h.a.v0("vip_sub_success_action", rechargeGoodsDiscountInfo != null ? rechargeGoodsDiscountInfo.getProductId() : null, stringExtra, stringExtra2, "false", "1");
        }
    }

    @Override // com.pinguo.camera360.member.a1
    /* renamed from: o0 */
    public void D(RechargePresenter presenter) {
        kotlin.jvm.internal.s.h(presenter, "presenter");
        this.f6870h = presenter;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new RechargePresenter(this);
        registerLoginEvent();
        PGEventBus.getInstance().b(this);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CompositeSubscription compositeSubscription = this.f6869g;
        if (compositeSubscription != null) {
            kotlin.jvm.internal.s.e(compositeSubscription);
            compositeSubscription.unsubscribe();
            this.f6869g = null;
        }
        PGEventBus.getInstance().c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onEvent(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        s0(event);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), 1);
        this.f6871i = dividerItemDecoration;
        if (dividerItemDecoration != null) {
            FragmentActivity activity = getActivity();
            kotlin.jvm.internal.s.e(activity);
            dividerItemDecoration.setDrawable(activity.getResources().getDrawable(R.drawable.divide_line));
        }
        e0();
        RechargePresenter rechargePresenter = this.f6870h;
        if (rechargePresenter == null) {
            return;
        }
        rechargePresenter.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0() {
        if (!us.pinguo.util.q.f(getActivity())) {
            Toast makeText = Toast.makeText(getActivity(), (int) R.string.network_error, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        } else if (!us.pinguo.user.s0.getInstance().e()) {
            us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
            us.pinguo.user.s0.getInstance().a(getActivity(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
        } else {
            BottomSheetDialog bottomSheetDialog = this.f6867e;
            if (bottomSheetDialog == null) {
                return;
            }
            bottomSheetDialog.show();
            VdsAgent.showDialog(bottomSheetDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q0() {
        final RechargeGoodsDiscountInfo d0 = d0();
        if (d0 != null) {
            VipManager.a.S(d0.getProductId());
            if (us.pinguo.foundation.d.f10991j) {
                us.pinguo.foundation.utils.w.l(getActivity(), "模拟国内支付", "支付成功", "支付失败", new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.member.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        BaseMemberRightsFragmentView.r0(BaseMemberRightsFragmentView.this, d0, dialogInterface, i2);
                    }
                });
                return;
            }
            RechargePresenter rechargePresenter = this.f6870h;
            if (rechargePresenter == null) {
                return;
            }
            rechargePresenter.n(d0, this);
        }
    }

    protected void s0(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t0() {
        RechargePresenter rechargePresenter = this.f6870h;
        if (rechargePresenter == null) {
            return;
        }
        rechargePresenter.q();
    }

    public final void onEvent(PayClickEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        k0();
    }
}
