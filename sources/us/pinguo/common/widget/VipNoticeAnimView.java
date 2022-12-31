package us.pinguo.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
/* compiled from: VipNoticeAnimView.kt */
/* loaded from: classes4.dex */
public final class VipNoticeAnimView extends FrameLayout implements View.OnClickListener {
    public Map<Integer, View> a;
    private int b;
    private ObjectAnimator c;

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f9974d;

    /* renamed from: e  reason: collision with root package name */
    private v1 f9975e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9976f;

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            VipNoticeAnimView.this.i();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipNoticeAnimView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), us.pinguo.commonui.R.layout.vip_notice_anim_view_layout, this);
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
        ((ImageView) a(us.pinguo.commonui.R.id.iconVip)).setOnClickListener(this);
        ((TextView) a(us.pinguo.commonui.R.id.noticeText)).setOnClickListener(this);
        us.pinguo.foundation.ui.c.b(this, new Runnable() { // from class: us.pinguo.common.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                VipNoticeAnimView.b(VipNoticeAnimView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipNoticeAnimView this$0) {
        s.h(this$0, "this$0");
        this$0.b = ((TextView) this$0.a(us.pinguo.commonui.R.id.noticeText)).getWidth();
        if (this$0.f9976f) {
            this$0.f9976f = false;
            this$0.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        v1 d2;
        d2 = l.d(n0.a(z0.c()), null, null, new VipNoticeAnimView$onTransitionAnimEnd$1(this, null), 3, null);
        this.f9975e = d2;
    }

    public View a(int i2) {
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

    public final int d() {
        return this.b;
    }

    public final ObjectAnimator e() {
        return this.f9974d;
    }

    public final void f() {
        if (getVisibility() == 4) {
            return;
        }
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
        ImageView iconVip = (ImageView) a(us.pinguo.commonui.R.id.iconVip);
        s.g(iconVip, "iconVip");
        iconVip.setVisibility(8);
        VdsAgent.onSetViewVisibility(iconVip, 8);
        int i2 = us.pinguo.commonui.R.id.noticeText;
        TextView noticeText = (TextView) a(i2);
        s.g(noticeText, "noticeText");
        noticeText.setVisibility(0);
        VdsAgent.onSetViewVisibility(noticeText, 0);
        ((TextView) a(i2)).setWidth(this.b);
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f9974d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        v1 v1Var = this.f9975e;
        if (v1Var == null) {
            return;
        }
        v1.a.a(v1Var, null, 1, null);
    }

    public final boolean g() {
        ImageView iconVip = (ImageView) a(us.pinguo.commonui.R.id.iconVip);
        s.g(iconVip, "iconVip");
        return iconVip.getVisibility() == 0;
    }

    public final void j() {
        if (getVisibility() == 0) {
            return;
        }
        if (this.b == 0) {
            this.f9976f = true;
            return;
        }
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", -getWidth(), 0.0f);
        this.c = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(400L);
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        }
        ObjectAnimator objectAnimator2 = this.c;
        if (objectAnimator2 != null) {
            objectAnimator2.addListener(new a());
        }
        ObjectAnimator objectAnimator3 = this.c;
        if (objectAnimator3 == null) {
            return;
        }
        objectAnimator3.start();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        us.pinguo.vip.proxy.c.d(us.pinguo.vip.proxy.c.a, getContext(), null, false, 6, null);
    }

    public final void setJob(v1 v1Var) {
        this.f9975e = v1Var;
    }

    public final void setNeedShowAfterDrawFinish(boolean z) {
        this.f9976f = z;
    }

    public final void setOriginWidth(int i2) {
        this.b = i2;
    }

    public final void setScaleXAnim(ObjectAnimator objectAnimator) {
        this.f9974d = objectAnimator;
    }

    public final void setTransitionAnim(ObjectAnimator objectAnimator) {
        this.c = objectAnimator;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipNoticeAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), us.pinguo.commonui.R.layout.vip_notice_anim_view_layout, this);
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
        ((ImageView) a(us.pinguo.commonui.R.id.iconVip)).setOnClickListener(this);
        ((TextView) a(us.pinguo.commonui.R.id.noticeText)).setOnClickListener(this);
        us.pinguo.foundation.ui.c.b(this, new Runnable() { // from class: us.pinguo.common.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                VipNoticeAnimView.b(VipNoticeAnimView.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipNoticeAnimView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), us.pinguo.commonui.R.layout.vip_notice_anim_view_layout, this);
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
        ((ImageView) a(us.pinguo.commonui.R.id.iconVip)).setOnClickListener(this);
        ((TextView) a(us.pinguo.commonui.R.id.noticeText)).setOnClickListener(this);
        us.pinguo.foundation.ui.c.b(this, new Runnable() { // from class: us.pinguo.common.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                VipNoticeAnimView.b(VipNoticeAnimView.this);
            }
        });
    }
}
