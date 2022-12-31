package us.pinguo.common.widget.adv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.j;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import us.pinguo.common.widget.tab.k;
import us.pinguo.commonui.R;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: AdRewardView.kt */
/* loaded from: classes4.dex */
public final class AdRewardView extends ConstraintLayout {
    public Map<Integer, View> a;
    private final int b;
    private v1 c;

    /* renamed from: d  reason: collision with root package name */
    private final m0 f9980d;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9981e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdRewardView(Context context) {
        this(context, null);
        s.h(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void D(AdRewardView adRewardView, int i2, kotlin.jvm.b.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        adRewardView.C(i2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(kotlin.jvm.b.a aVar, View view) {
        VdsAgent.lambdaOnClick(view);
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    private final void F(kotlin.jvm.b.a<u> aVar) {
        this.c = j.d(this.f9980d, null, null, new AdRewardView$startCountdown$1(this, aVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(kotlin.jvm.b.a aVar, View view) {
        VdsAgent.lambdaOnClick(view);
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        view.animate().alpha(1.0f).setDuration(300L).setListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(kotlin.jvm.b.a aVar, View view) {
        VdsAgent.lambdaOnClick(view);
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AdRewardView this$0, kotlin.jvm.b.a aVar, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.setVisibility(8);
        VdsAgent.onSetViewVisibility(this$0, 8);
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    public static /* synthetic */ void x(AdRewardView adRewardView, boolean z, int i2, int i3, kotlin.jvm.b.a aVar, kotlin.jvm.b.a aVar2, kotlin.jvm.b.a aVar3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = false;
        }
        if ((i4 & 2) != 0) {
            i2 = R.drawable.icon_ad_free_vip_again;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = R.string.str_first_free_vip;
        }
        adRewardView.w(z, i5, i3, (i4 & 8) != 0 ? null : aVar, (i4 & 16) != 0 ? null : aVar2, (i4 & 32) != 0 ? null : aVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(boolean z, AdRewardView this$0, kotlin.jvm.b.a aVar, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (k.b(k.a, 0, 1, null) || z) {
            return;
        }
        v1 v1Var = this$0.c;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(AdRewardView this$0, kotlin.jvm.b.a aVar, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        v1 v1Var = this$0.c;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    public final void A() {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.interruptDialog);
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        int i2 = R.id.tvLoadingView;
        TvLoadingView tvLoadingView = (TvLoadingView) _$_findCachedViewById(i2);
        tvLoadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(tvLoadingView, 0);
        int i3 = R.id.txt_illustrate;
        TextView textView = (TextView) _$_findCachedViewById(i3);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i3)).setText(us.pinguo.common.utils.k.c(R.string.ads_video_loading));
        ((TvLoadingView) _$_findCachedViewById(i2)).d(false);
        ((TvLoadingView) _$_findCachedViewById(i2)).setType(1);
        ((TvLoadingView) _$_findCachedViewById(i2)).e(true);
    }

    public final void B() {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.interruptDialog);
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        int i2 = R.id.tvLoadingView;
        TvLoadingView tvLoadingView = (TvLoadingView) _$_findCachedViewById(i2);
        tvLoadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(tvLoadingView, 0);
        int i3 = R.id.txt_illustrate;
        TextView textView = (TextView) _$_findCachedViewById(i3);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i3)).setText(us.pinguo.common.utils.k.c(R.string.ads_video_loading_fail));
        ((TvLoadingView) _$_findCachedViewById(i2)).e(false);
        ((TvLoadingView) _$_findCachedViewById(i2)).setType(2);
        ((TvLoadingView) _$_findCachedViewById(i2)).d(true);
    }

    public final void C(int i2, final kotlin.jvm.b.a<u> aVar) {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        TvLoadingView tvLoadingView = (TvLoadingView) _$_findCachedViewById(R.id.tvLoadingView);
        tvLoadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(tvLoadingView, 8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.txt_illustrate);
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        int i3 = R.id.ivClose;
        ImageView ivClose = (ImageView) _$_findCachedViewById(i3);
        s.g(ivClose, "ivClose");
        if (ivClose.getVisibility() == 0) {
            ((ImageView) _$_findCachedViewById(i3)).setVisibility(8);
        }
        j.d(this.f9980d, null, null, new AdRewardView$showUnlockDialog$1(this, null), 3, null);
        if (i2 != 0) {
            ((AutofitTextView) _$_findCachedViewById(R.id.tvContent)).setText(us.pinguo.common.utils.k.c(i2));
        }
        ((TextView) _$_findCachedViewById(R.id.tvUseNow)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.adv.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardView.E(kotlin.jvm.b.a.this, view);
            }
        });
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

    public final void k() {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.adWatchGuideDialog);
        _$_findCachedViewById.setVisibility(8);
        VdsAgent.onSetViewVisibility(_$_findCachedViewById, 8);
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
    }

    public final void l() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        int i2 = R.id.tvLoadingView;
        ((TvLoadingView) _$_findCachedViewById(i2)).e(false);
        ((TvLoadingView) _$_findCachedViewById(i2)).d(false);
        TvLoadingView tvLoadingView = (TvLoadingView) _$_findCachedViewById(i2);
        tvLoadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(tvLoadingView, 8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.txt_illustrate);
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.interruptDialog);
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setVisibility(8);
    }

    public final View m() {
        return _$_findCachedViewById(R.id.adWatchGuideDialog);
    }

    public final void setOnCloseClickListener(final kotlin.jvm.b.a<u> aVar) {
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.adv.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardView.g(kotlin.jvm.b.a.this, view);
            }
        });
        this.f9981e = aVar;
    }

    public final void t(final kotlin.jvm.b.a<u> aVar, final kotlin.jvm.b.a<u> aVar2) {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        TvLoadingView tvLoadingView = (TvLoadingView) _$_findCachedViewById(R.id.tvLoadingView);
        tvLoadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(tvLoadingView, 8);
        TextView textView = (TextView) _$_findCachedViewById(R.id.txt_illustrate);
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        j.d(this.f9980d, null, null, new AdRewardView$showAdInterruptedDialog$1(this, null), 3, null);
        ((TextView) _$_findCachedViewById(R.id.txt_rewatch)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.adv.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardView.u(kotlin.jvm.b.a.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R.id.txt_no_watching)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.adv.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardView.v(AdRewardView.this, aVar2, view);
            }
        });
    }

    public final void w(final boolean z, int i2, int i3, final kotlin.jvm.b.a<u> aVar, final kotlin.jvm.b.a<u> aVar2, kotlin.jvm.b.a<u> aVar3) {
        l();
        int i4 = R.id.adWatchGuideDialog;
        View _$_findCachedViewById = _$_findCachedViewById(i4);
        _$_findCachedViewById.setVisibility(0);
        VdsAgent.onSetViewVisibility(_$_findCachedViewById, 0);
        j(this);
        View _$_findCachedViewById2 = _$_findCachedViewById(i4);
        ((AppCompatImageView) _$_findCachedViewById2.findViewById(R.id.ivFreeVip)).setImageResource(i2);
        ((AutofitTextView) _$_findCachedViewById2.findViewById(R.id.tvDesc)).setText(us.pinguo.common.utils.k.c(i3));
        ((AlphaPressedConstraintLayout) _$_findCachedViewById2.findViewById(R.id.clStart)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.adv.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardView.y(z, this, aVar, view);
            }
        });
        ((TextView) _$_findCachedViewById2.findViewById(R.id.tvCancel)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.adv.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardView.z(AdRewardView.this, aVar2, view);
            }
        });
        if (z) {
            F(aVar3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdRewardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdRewardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = 3;
        this.f9980d = n0.a(z0.c());
        View.inflate(getContext(), R.layout.layout_ad_reward_view, this);
    }
}
