package com.pinguo.camera360.member;

import android.content.DialogInterface;
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
import com.pinguo.camera360.member.model.MemberPriceInfo;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayCenterParm;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.R;
/* compiled from: MMMemberRightsFragmentView.kt */
/* loaded from: classes3.dex */
public final class MMMemberRightsFragmentView extends BaseMemberRightsFragmentView implements PayCallback, View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    public static final a f6884l = new a(null);

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f6885j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    private RechargeGoodsDiscountInfo f6886k;

    /* compiled from: MMMemberRightsFragmentView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final MMMemberRightsFragmentView a(Bundle bundle) {
            MMMemberRightsFragmentView mMMemberRightsFragmentView = new MMMemberRightsFragmentView();
            mMMemberRightsFragmentView.setArguments(bundle);
            return mMMemberRightsFragmentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(MMMemberRightsFragmentView this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -2) {
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            FragmentActivity activity = this$0.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.pinguo.camera360.member.MemberRightsActivity");
            ((MemberRightsActivity) activity).J0();
            this$0.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map x0(FragmentActivity tmpActivity) {
        kotlin.jvm.internal.s.h(tmpActivity, "$tmpActivity");
        HashMap hashMap = new HashMap();
        us.pinguo.user.u0.e(tmpActivity.getApplicationContext(), hashMap);
        return hashMap;
    }

    private final void y0() {
        y0.c r = User.d().r(false);
        if (r.b()) {
            int i2 = R.id.tv_member_status_hint;
            if (((AutofitTextView) _$_findCachedViewById(i2)) != null) {
                ((AutofitTextView) _$_findCachedViewById(i2)).setText(getString(R.string.been_member_tips));
            }
            int i3 = R.id.open_mm_member;
            if (((Button) _$_findCachedViewById(i3)) != null) {
                Button button = (Button) _$_findCachedViewById(i3);
                button.setVisibility(8);
                VdsAgent.onSetViewVisibility(button, 8);
            }
            int i4 = R.id.unsubscribe_mm_member;
            if (((Button) _$_findCachedViewById(i4)) != null) {
                if (r.b <= (System.currentTimeMillis() / 1000) + 5184000) {
                    Button button2 = (Button) _$_findCachedViewById(i4);
                    button2.setVisibility(8);
                    VdsAgent.onSetViewVisibility(button2, 8);
                    return;
                }
                Button button3 = (Button) _$_findCachedViewById(i4);
                button3.setVisibility(0);
                VdsAgent.onSetViewVisibility(button3, 0);
                return;
            }
            return;
        }
        int i5 = R.id.tv_member_status_hint;
        if (((AutofitTextView) _$_findCachedViewById(i5)) != null) {
            ((AutofitTextView) _$_findCachedViewById(i5)).setText(getString(R.string.open_member_tips));
        }
        int i6 = R.id.open_mm_member;
        if (((Button) _$_findCachedViewById(i6)) != null) {
            Button button4 = (Button) _$_findCachedViewById(i6);
            button4.setVisibility(0);
            VdsAgent.onSetViewVisibility(button4, 0);
        }
        int i7 = R.id.unsubscribe_mm_member;
        if (((Button) _$_findCachedViewById(i7)) != null) {
            Button button5 = (Button) _$_findCachedViewById(i7);
            button5.setVisibility(8);
            VdsAgent.onSetViewVisibility(button5, 8);
        }
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, com.pinguo.camera360.member.w0
    public void A(MemberPriceInfo memberPriceInfo) {
        kotlin.jvm.internal.s.h(memberPriceInfo, "memberPriceInfo");
        List<RechargeGoodsDiscountInfo> arrayList = new ArrayList<>();
        if (memberPriceInfo.getList() != null && memberPriceInfo.getList().size() > 0) {
            int i2 = 0;
            int size = memberPriceInfo.getList().size();
            while (true) {
                if (i2 >= size) {
                    break;
                }
                int i3 = i2 + 1;
                if ("vip_month_union_mmgz".equals(memberPriceInfo.getList().get(i2).getProductId())) {
                    arrayList.add(memberPriceInfo.getList().get(i2));
                    break;
                }
                i2 = i3;
            }
            memberPriceInfo.setList(arrayList);
            if (arrayList.size() > 0) {
                this.f6886k = (RechargeGoodsDiscountInfo) kotlin.collections.s.K(arrayList);
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
        this.f6885j.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.f6885j;
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
            if (id == R.id.mm_unsubscribe_notice) {
                Intent intent = new Intent();
                intent.putExtra("towhere", "mm_unsubs_notice");
                intent.setClass(g(), OptionsWebviewActivity.class);
                startActivity(intent);
            } else if (id == R.id.open_mm_member) {
                p0();
                us.pinguo.foundation.statistics.h.a.j("mmpay", "show");
            } else if (id != R.id.unsubscribe_mm_member) {
            } else {
                us.pinguo.foundation.utils.w.l(getActivity(), getString(R.string.text_mm_cancel_confirm), getString(R.string.confirm), getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.member.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        MMMemberRightsFragmentView.w0(MMMemberRightsFragmentView.this, dialogInterface, i2);
                    }
                });
            }
        }
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        C360MemberPayHelp.getInstance().M(activity, new us.pinguo.paylibcenter.i() { // from class: com.pinguo.camera360.member.q
            @Override // us.pinguo.paylibcenter.i
            public final Map a() {
                Map x0;
                x0 = MMMemberRightsFragmentView.x0(FragmentActivity.this);
                return x0;
            }
        }, PayHelp.PAYWAY.MMPay);
        C360MemberPayHelp.getInstance().Y(us.pinguo.foundation.d.f10985d ? us.pinguo.foundation.d.b ? 1 : 0 : -1);
        C360MemberPayHelp.getInstance().v(us.pinguo.foundation.d.f10987f);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_mm_member_right_layout, (ViewGroup) null);
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        y0();
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) _$_findCachedViewById(R.id.open_mm_member)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(R.id.unsubscribe_mm_member)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.mm_unsubscribe_notice)).setOnClickListener(this);
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected void q0() {
        C360MemberPayHelp.getInstance().Z(this);
        RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = this.f6886k;
        String productId = rechargeGoodsDiscountInfo == null ? null : rechargeGoodsDiscountInfo.getProductId();
        User.Info h2 = User.d().h();
        kotlin.jvm.internal.s.e(h2);
        PayCenterParm payCenterParm = new PayCenterParm(productId, h2.userId);
        payCenterParm.setPurchaseTag("c360_vip");
        C360MemberPayHelp.getInstance().D(getActivity(), PayHelp.PAYWAY.MMPay, payCenterParm, this, "148679");
        us.pinguo.foundation.statistics.h.a.j("mmpay", "click");
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void s() {
    }

    @Override // com.pinguo.camera360.member.BaseMemberRightsFragmentView
    protected void s0(SyncVipInfoDoneEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.common.log.a.m("MemberRightsActivity", "onEvent SyncVipInfoDoneEvent ", new Object[0]);
        if ("MMMemberRightsFragmentView".equals(event.a())) {
            y0();
        }
    }
}
