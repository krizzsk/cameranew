package com.pinguo.camera360.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.album.animations.StateTransAnim;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public abstract class ActivityState {
    protected RootActivity a;
    protected Bundle b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected c f6289d;

    /* renamed from: e  reason: collision with root package name */
    protected c f6290e;

    /* renamed from: k  reason: collision with root package name */
    protected StateTransAnim f6296k;

    /* renamed from: l  reason: collision with root package name */
    protected AnimatorSet f6297l;
    private com.pinguo.album.views.a m;
    private View n;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6291f = false;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f6292g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6293h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f6294i = false;

    /* renamed from: j  reason: collision with root package name */
    protected StateTransAnim.Transition f6295j = StateTransAnim.Transition.None;
    BroadcastReceiver o = new a();

    /* loaded from: classes3.dex */
    public enum State {
        Normal,
        ResetUI
    }

    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean z = intent.getIntExtra("plugged", 0) != 0;
                if (z != ActivityState.this.f6293h) {
                    ActivityState.this.f6293h = z;
                    ActivityState.this.Y();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActivityState activityState = ActivityState.this;
            activityState.f6297l = null;
            ViewGroup c = activityState.a.C0().c();
            c.setVisibility(8);
            VdsAgent.onSetViewVisibility(c, 8);
            ActivityState.this.a.C0().h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActivityState activityState = ActivityState.this;
            activityState.f6297l = null;
            ViewGroup c = activityState.a.C0().c();
            c.setVisibility(8);
            VdsAgent.onSetViewVisibility(c, 8);
            ActivityState.this.a.C0().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class c {
        public int a;
        public int b = 0;
        public Intent c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(RootActivity rootActivity, Bundle bundle) {
        this.a = rootActivity;
        this.b = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f6292g;
    }

    public boolean C() {
        return this.f6294i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        return this.f6291f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        this.a.E0().d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(Configuration configuration) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(Bundle bundle, Bundle bundle2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H(Menu menu) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        this.f6292g = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        if ((this.c & 4) != 0) {
            this.a.unregisterReceiver(this.o);
        }
        AnimatorSet animatorSet = this.f6297l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f6297l = null;
        this.f6291f = true;
        this.a.C0().f();
        this.n = null;
        K();
    }

    protected void K() {
        StateTransAnim.Transition transition = this.f6295j;
        StateTransAnim.Transition transition2 = StateTransAnim.Transition.None;
        if (transition != transition2) {
            this.a.H0().d("transition-in", this.f6295j);
            com.pinguo.album.views.a aVar = this.m;
            if (aVar != null) {
                com.pinguo.camera360.gallery.ui.w.e(this.a, aVar);
            }
            if (this.a.C0().c().getChildCount() > 0) {
                ViewGroup c2 = this.a.C0().c();
                c2.setVisibility(0);
                VdsAgent.onSetViewVisibility(c2, 0);
            }
            this.f6295j = transition2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L() {
        this.a.N0(w());
        com.pinguo.album.opengles.q qVar = (com.pinguo.album.opengles.q) this.a.H0().b("fade_texture");
        e0 H0 = this.a.H0();
        StateTransAnim.Transition transition = StateTransAnim.Transition.None;
        StateTransAnim.Transition transition2 = (StateTransAnim.Transition) H0.c("transition-in", transition);
        this.f6295j = transition2;
        if (transition2 != transition) {
            this.f6296k = new StateTransAnim(transition2, qVar);
            M();
            this.f6295j = transition;
        }
        this.f6291f = false;
    }

    protected void M() {
        ViewGroup c2 = this.a.C0().c();
        c2.setVisibility(0);
        VdsAgent.onSetViewVisibility(c2, 0);
        Animator r = this.a.C0().c().getChildCount() > 0 ? this.f6296k.r(this.a.C0().c()) : null;
        Animator q = this.f6296k.q(this.a.C0().d());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6297l = animatorSet;
        if (r == null) {
            animatorSet.playTogether(q);
        } else {
            animatorSet.playTogether(r, q);
        }
        this.f6297l.addListener(new b());
        this.f6297l.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(int i2, int i3, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        RootActivity rootActivity = this.a;
        Y();
        c cVar = this.f6289d;
        if (cVar != null) {
            this.f6289d = null;
            O(cVar.a, cVar.b, cVar.c);
        }
        if ((this.c & 4) != 0) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            rootActivity.registerReceiver(this.o, intentFilter);
        }
        L();
        this.a.invalidateOptionsMenu();
        this.a.H0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(com.pinguo.album.views.a aVar) {
        this.m = aVar;
        StateTransAnim stateTransAnim = this.f6296k;
        if (stateTransAnim != null) {
            aVar.C(stateTransAnim);
            this.f6296k = null;
        }
        this.a.E().setContentPane(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(int i2) {
        S(com.pinguo.album.j.a.m(i2));
    }

    protected void S(float[] fArr) {
        this.a.E().setContentPaneBackground(fArr);
    }

    public void T(boolean z, int i2, int i3) {
        V(z, i2, i3, null);
    }

    public void U(boolean z, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        T(z, i2, i3);
        if (z) {
            TextView textView = (TextView) this.n.findViewById(R.id.empty_sub_title);
            textView.setText(i4);
            textView.setOnClickListener(onClickListener);
        }
    }

    public void V(boolean z, int i2, int i3, View.OnClickListener onClickListener) {
        this.a.M0(false);
        View view = this.n;
        boolean z2 = (view == null || view.findViewById(R.id.empty_icon) == null) ? false : true;
        if (!z) {
            if (z2) {
                X(null);
            }
        } else if (z2) {
            ViewGroup d2 = this.a.C0().d();
            d2.setVisibility(0);
            VdsAgent.onSetViewVisibility(d2, 0);
        } else {
            W(R.layout.album_empty_view);
            View view2 = this.n;
            ImageView imageView = (ImageView) view2.findViewById(R.id.empty_icon);
            imageView.setImageResource(i2);
            ((TextView) view2.findViewById(R.id.empty_title)).setText(i3);
            imageView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(int i2) {
        X(this.a.getLayoutInflater().inflate(i2, (ViewGroup) this.a.C0(), false));
    }

    protected void X(View view) {
        this.n = view;
        if (view != null) {
            this.a.C0().b(view);
        } else {
            this.a.C0().g();
        }
    }

    void Y() {
        Window window = this.a.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = this.c;
        if ((i2 & 8) == 0 && (!this.f6293h || (i2 & 4) == 0)) {
            attributes.flags &= -524418;
        } else {
            attributes.flags |= 524417;
        }
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(int i2, Intent intent) {
        c cVar = this.f6290e;
        if (cVar == null) {
            return;
        }
        cVar.b = i2;
        cVar.c = intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(Class<? extends ActivityState> cls, Class<? extends ActivityState> cls2, StateTransAnim.Transition transition) {
        this.f6295j = transition;
    }

    public int w() {
        return -1;
    }

    public Bundle x() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View y() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z() {
        e0 H0 = this.a.H0();
        StateTransAnim.Transition transition = StateTransAnim.Transition.None;
        return H0.c("transition-in", transition) != transition;
    }
}
