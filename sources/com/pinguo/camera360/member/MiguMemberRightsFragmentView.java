package com.pinguo.camera360.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.options.OptionsWebviewActivity;
import com.pinguo.camera360.lib.ui.WebViewActivity;
import com.pinguo.camera360.member.model.MemberPriceInfo;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayCenterParm;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import vStudio.Android.Camera360.R;
/* compiled from: MiguMemberRightsFragmentView.kt */
/* loaded from: classes3.dex */
public final class MiguMemberRightsFragmentView extends BaseMemberRightsFragmentView implements PayCallback, View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    public static final a f6893l = new a(null);

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f6894j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    private RechargeGoodsDiscountInfo f6895k;

    /* compiled from: MiguMemberRightsFragmentView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final MiguMemberRightsFragmentView a(Bundle bundle) {
            MiguMemberRightsFragmentView miguMemberRightsFragmentView = new MiguMemberRightsFragmentView();
            miguMemberRightsFragmentView.setArguments(bundle);
            return miguMemberRightsFragmentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map v0(MiguMemberRightsFragmentView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        HashMap hashMap = new HashMap();
        FragmentActivity activity = this$0.getActivity();
        kotlin.jvm.internal.s.e(activity);
        us.pinguo.user.u0.e(activity.getApplicationContext(), hashMap);
        return hashMap;
    }

    private final void w0() {
        if (User.d().r(false).c()) {
            int i2 = R.id.tv_member_status_hint;
            if (((AutofitTextView) _$_findCachedViewById(i2)) != null) {
                ((AutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.been_member_tips));
                ((AutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.been_member_tips));
            }
            int i3 = R.id.open_migu_member;
            if (((Button) _$_findCachedViewById(i3)) != null) {
                Button button = (Button) _$_findCachedViewById(i3);
                button.setVisibility(8);
                VdsAgent.onSetViewVisibility(button, 8);
            }
            int i4 = R.id.migu_unsubscribe_notice;
            if (((AutofitTextView) _$_findCachedViewById(i4)) != null) {
                AutofitTextView autofitTextView = (AutofitTextView) _$_findCachedViewById(i4);
                autofitTextView.setVisibility(0);
                VdsAgent.onSetViewVisibility(autofitTextView, 0);
            }
            int i5 = R.id.btn_enjoy_migu_immediately;
            if (((Button) _$_findCachedViewById(i5)) != null) {
                Button button2 = (Button) _$_findCachedViewById(i5);
                button2.setVisibility(0);
                VdsAgent.onSetViewVisibility(button2, 0);
                return;
            }
            return;
        }
        int i6 = R.id.tv_member_status_hint;
        if (((AutofitTextView) _$_findCachedViewById(i6)) != null) {
            ((AutofitTextView) _$_findCachedViewById(i6)).setText(getString(R.string.open_migu_member_tips));
        }
        int i7 = R.id.open_migu_member;
        if (((Button) _$_findCachedViewById(i7)) != null) {
            Button button3 = (Button) _$_findCachedViewById(i7);
            button3.setVisibility(0);
            VdsAgent.onSetViewVisibility(button3, 0);
            ((Button) _$_findCachedViewById(i7)).setText(R.string.open_member);
        }
        int i8 = R.id.migu_unsubscribe_notice;
        if (((AutofitTextView) _$_findCachedViewById(i8)) != null) {
            AutofitTextView autofitTextView2 = (AutofitTextView) _$_findCachedViewById(i8);
            autofitTextView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView2, 8);
        }
        int i9 = R.id.btn_enjoy_migu_immediately;
        if (((Button) _$_findCachedViewById(i9)) != null) {
            Button button4 = (Button) _$_findCachedViewById(i9);
            button4.setVisibility(8);
            VdsAgent.onSetViewVisibility(button4, 8);
        }
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, com.pinguo.camera360.member.w0
    public void A(MemberPriceInfo memberPriceInfo) {
        kotlin.jvm.internal.s.h(memberPriceInfo, "memberPriceInfo");
        List<RechargeGoodsDiscountInfo> arrayList = new ArrayList<>();
        if (memberPriceInfo.getList() != null && (!memberPriceInfo.getList().isEmpty())) {
            int i2 = 0;
            int size = memberPriceInfo.getList().size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                int i3 = i2 + 1;
                if ("vip_month_union".equals(memberPriceInfo.getList().get(i2).getProductId())) {
                    arrayList.add(memberPriceInfo.getList().get(i2));
                    break;
                }
                i2 = i3;
            }
            memberPriceInfo.setList(arrayList);
            if (arrayList.size() > 0) {
                this.f6895k = (RechargeGoodsDiscountInfo) kotlin.collections.s.K(arrayList);
            } else {
                this.f6895k = null;
            }
        }
        super.A(memberPriceInfo);
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void H(PayResult payResult) {
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void W() {
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    public void _$_clearFindViewByIdCache() {
        this.f6894j.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.f6894j;
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

    @Override // us.pinguo.paylibcenter.PayCallback
    public void d(PayResult payResult) {
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void e(PayResult payResult) {
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view != null) {
            int id = view.getId();
            if (id == R.id.btn_enjoy_migu_immediately) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("web_view_url", "file:///android_asset/www/migumusic.html");
                startActivity(intent);
            } else if (id != R.id.migu_unsubscribe_notice) {
                if (id != R.id.open_migu_member) {
                    return;
                }
                p0();
                us.pinguo.foundation.statistics.h.a.j("migu", "show");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("towhere", "migu_unsubs_notice");
                intent2.setClass(g(), OptionsWebviewActivity.class);
                startActivity(intent2);
            }
        }
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
        C360MemberPayHelp.getInstance().M(getActivity(), new us.pinguo.paylibcenter.i() { // from class: com.pinguo.camera360.member.x
            @Override // us.pinguo.paylibcenter.i
            public final Map a() {
                Map v0;
                v0 = MiguMemberRightsFragmentView.v0(MiguMemberRightsFragmentView.this);
                return v0;
            }
        }, PayHelp.PAYWAY.MiGuPay);
        C360MemberPayHelp.getInstance().Y(us.pinguo.foundation.d.f10985d ? us.pinguo.foundation.d.b ? 1 : 0 : -1);
        C360MemberPayHelp.getInstance().v(us.pinguo.foundation.d.f10987f);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_migu_member_right_layout, (ViewGroup) null);
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        w0();
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) _$_findCachedViewById(R.id.open_migu_member)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(R.id.btn_enjoy_migu_immediately)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.migu_unsubscribe_notice)).setOnClickListener(this);
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected void q0() {
        C360MemberPayHelp.getInstance().Z(this);
        RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = this.f6895k;
        String productId = rechargeGoodsDiscountInfo == null ? null : rechargeGoodsDiscountInfo.getProductId();
        User.Info h2 = User.d().h();
        kotlin.jvm.internal.s.e(h2);
        PayCenterParm payCenterParm = new PayCenterParm(productId, h2.userId);
        payCenterParm.setPurchaseTag("c360_vip");
        C360MemberPayHelp.getInstance().D(getActivity(), PayHelp.PAYWAY.MiGuPay, payCenterParm, this, "002106B");
        us.pinguo.foundation.statistics.h.a.j("migupay", "click");
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void s() {
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected void s0(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.common.log.a.m("MiguMemberRightsFragmentView", "onEvent SyncVipInfoDoneEvent ", new Object[0]);
        if ("MiguMemberRightsFragmentView".equals(event.a())) {
            w0();
        }
    }
}
