package vStudio.Android.Camera360.guide.pageview;

import android.animation.Animator;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.widget.tab.k;
import us.pinguo.foundation.video.FixedRateVideoView2;
import us.pinguo.ui.widget.AlphaPressedConstraintLayout;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.util.h;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
import vStudio.Android.Camera360.guide.GuideFragment;
import vStudio.Android.Camera360.guide.view.IndicatorView2;
/* compiled from: PayWallGuideFragment.kt */
/* loaded from: classes7.dex */
public final class PayWallGuideFragment extends GuideFragment {

    /* renamed from: d  reason: collision with root package name */
    private int f12620d;

    /* renamed from: e  reason: collision with root package name */
    private e f12621e;
    public Map<Integer, View> c = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private final List<f> f12622f = h0();

    /* compiled from: PayWallGuideFragment.kt */
    /* loaded from: classes7.dex */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PayWallGuideFragment payWallGuideFragment = PayWallGuideFragment.this;
            int i2 = R.id.guideTitle2;
            if (((AutofitTextView) payWallGuideFragment._$_findCachedViewById(i2)) == null) {
                return;
            }
            PayWallGuideFragment payWallGuideFragment2 = PayWallGuideFragment.this;
            AutofitTextView guideTitle2 = (AutofitTextView) payWallGuideFragment2._$_findCachedViewById(i2);
            s.g(guideTitle2, "guideTitle2");
            PayWallGuideFragment payWallGuideFragment3 = PayWallGuideFragment.this;
            int i3 = R.id.guideDesc2;
            AutofitTextView guideDesc2 = (AutofitTextView) payWallGuideFragment3._$_findCachedViewById(i3);
            s.g(guideDesc2, "guideDesc2");
            payWallGuideFragment2.p0(guideTitle2, guideDesc2, (f) PayWallGuideFragment.this.f12622f.get(PayWallGuideFragment.this.f12620d));
            AutofitTextView guideTitle22 = (AutofitTextView) PayWallGuideFragment.this._$_findCachedViewById(i2);
            s.g(guideTitle22, "guideTitle2");
            guideTitle22.setVisibility(0);
            VdsAgent.onSetViewVisibility(guideTitle22, 0);
            AutofitTextView guideDesc22 = (AutofitTextView) PayWallGuideFragment.this._$_findCachedViewById(i3);
            s.g(guideDesc22, "guideDesc2");
            guideDesc22.setVisibility(0);
            VdsAgent.onSetViewVisibility(guideDesc22, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private final void g0() {
        float f2 = -us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b());
        ((AutofitTextView) _$_findCachedViewById(R.id.guideTitle)).animate().translationX(f2).start();
        ((AutofitTextView) _$_findCachedViewById(R.id.guideDesc)).animate().translationX(f2).setListener(new a());
    }

    private final List<f> h0() {
        ArrayList f2;
        ArrayList f3;
        if (j0()) {
            Uri parse = Uri.parse("android.resource://vStudio.Android.Camera360/2131755014");
            s.g(parse, "parse(\"android.resource:….raw.pay_wall_slim_short)");
            Uri parse2 = Uri.parse("android.resource://vStudio.Android.Camera360/2131755012");
            s.g(parse2, "parse(\"android.resource:…aw.pay_wall_makeup_short)");
            f3 = u.f(new f(parse, R.drawable.ic_pay_wall_guide_slim, us.pinguo.edit2020.utils.d.k(R.string.pay_wall_slim_title), us.pinguo.edit2020.utils.d.k(R.string.pay_wall_slim_desc)), new f(parse2, R.drawable.ic_pay_wall_guide_slim, us.pinguo.edit2020.utils.d.k(R.string.pay_wall_makeup_title), us.pinguo.edit2020.utils.d.k(R.string.pay_wall_makeup_desc)));
            return f3;
        }
        Uri parse3 = Uri.parse("android.resource://vStudio.Android.Camera360/2131755013");
        s.g(parse3, "parse(\"android.resource:…/\" + R.raw.pay_wall_slim)");
        Uri parse4 = Uri.parse("android.resource://vStudio.Android.Camera360/2131755011");
        s.g(parse4, "parse(\"android.resource:… + R.raw.pay_wall_makeup)");
        f2 = u.f(new f(parse3, R.drawable.ic_pay_wall_guide_slim, us.pinguo.edit2020.utils.d.k(R.string.pay_wall_slim_title), us.pinguo.edit2020.utils.d.k(R.string.pay_wall_slim_desc)), new f(parse4, R.drawable.ic_pay_wall_guide_slim, us.pinguo.edit2020.utils.d.k(R.string.pay_wall_makeup_title), us.pinguo.edit2020.utils.d.k(R.string.pay_wall_makeup_desc)));
        return f2;
    }

    private final float i0() {
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        int g2 = h.g(b);
        Context b2 = us.pinguo.foundation.e.b();
        s.g(b2, "getAppContext()");
        return g2 / h.i(b2);
    }

    private final boolean j0() {
        return i0() == 1.7777778f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(PayWallGuideFragment this$0) {
        s.h(this$0, "this$0");
        this$0.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PayWallGuideFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (k.b(k.a, 0, 1, null)) {
            return;
        }
        int i2 = this$0.f12620d;
        if (i2 == 0) {
            this$0.f12620d = i2 + 1;
            this$0.g0();
            this$0.o0();
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        us.pinguo.foundation.l.c.b(activity, new PayWallGuideFragment$onViewCreated$3$1(this$0), this$0.getResources().getInteger(R.integer.mb_animation));
    }

    private final void o0() {
        IndicatorView2 indicatorView2 = (IndicatorView2) _$_findCachedViewById(R.id.indicator);
        if (indicatorView2 != null) {
            indicatorView2.selectIndex(this.f12620d);
        }
        FixedRateVideoView2 fixedRateVideoView2 = (FixedRateVideoView2) _$_findCachedViewById(R.id.videoView);
        if (fixedRateVideoView2 == null) {
            return;
        }
        fixedRateVideoView2.y();
        fixedRateVideoView2.setVideoURI(this.f12622f.get(this.f12620d).b());
        fixedRateVideoView2.setLooping(true);
        fixedRateVideoView2.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(TextView textView, TextView textView2, f fVar) {
        textView.setText(fVar.c());
        textView2.setText(fVar.a());
    }

    private final void q0() {
        Context b = us.pinguo.foundation.e.b();
        ((FixedRateVideoView2) _$_findCachedViewById(R.id.videoView)).setRate(us.pinguo.foundation.t.b.a.j(b) / (us.pinguo.foundation.t.b.a.h(b) * 0.6f));
    }

    public void _$_clearFindViewByIdCache() {
        this.c.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.c;
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

    @Override // vStudio.Android.Camera360.guide.GuideFragment
    public void b0() {
        FragmentActivity activity;
        e eVar = this.f12621e;
        if (eVar != null) {
            eVar.c(false);
            e eVar2 = this.f12621e;
            if (eVar2 == null) {
                s.z("guideModel");
                throw null;
            } else if (!eVar2.e() || (activity = getActivity()) == null) {
                return;
            } else {
                us.pinguo.foundation.l.c.b(activity, new PayWallGuideFragment$updateFinish$1(this), getResources().getInteger(R.integer.mb_animation));
                return;
            }
        }
        s.z("guideModel");
        throw null;
    }

    @Override // vStudio.Android.Camera360.guide.GuideFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type vStudio.Android.Camera360.GuideControl.GuideActionListener");
        this.f12621e = new e((a.InterfaceC0470a) activity, this.a);
        l.d(n0.a(z0.c()), null, null, new PayWallGuideFragment$onCreate$1(bundle, this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_pay_wall_guide, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Window window;
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(128);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(128);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        s.h(view, "view");
        super.onViewCreated(view, bundle);
        if (j0()) {
            int i2 = R.id.videoView;
            FixedRateVideoView2 videoView = (FixedRateVideoView2) _$_findCachedViewById(i2);
            s.g(videoView, "videoView");
            ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = us.pinguo.foundation.t.b.a.h(us.pinguo.foundation.e.b());
            layoutParams2.bottomToBottom = -1;
            layoutParams2.topToTop = R.id.root_res_0x7f09060e;
            ((FixedRateVideoView2) _$_findCachedViewById(i2)).setRate(1.0f);
            videoView.setLayoutParams(layoutParams2);
        } else {
            q0();
        }
        AutofitTextView guideTitle = (AutofitTextView) _$_findCachedViewById(R.id.guideTitle);
        s.g(guideTitle, "guideTitle");
        AutofitTextView guideDesc = (AutofitTextView) _$_findCachedViewById(R.id.guideDesc);
        s.g(guideDesc, "guideDesc");
        p0(guideTitle, guideDesc, this.f12622f.get(this.f12620d));
        ((FixedRateVideoView2) _$_findCachedViewById(R.id.videoView)).post(new Runnable() { // from class: vStudio.Android.Camera360.guide.pageview.a
            @Override // java.lang.Runnable
            public final void run() {
                PayWallGuideFragment.m0(PayWallGuideFragment.this);
            }
        });
        ((AlphaPressedConstraintLayout) _$_findCachedViewById(R.id.alphaLayout)).setOnClickListener(new View.OnClickListener() { // from class: vStudio.Android.Camera360.guide.pageview.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayWallGuideFragment.n0(PayWallGuideFragment.this, view2);
            }
        });
    }
}
