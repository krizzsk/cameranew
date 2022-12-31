package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: EditUserOperationController.kt */
/* loaded from: classes4.dex */
public final class c0 {
    private final ViewGroup a;
    private final AppCompatImageView b;
    private final AppCompatImageView c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCompatImageView f10743d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f10744e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f10745f;

    /* renamed from: g  reason: collision with root package name */
    private p0 f10746g;

    /* renamed from: h  reason: collision with root package name */
    private m0 f10747h;

    /* compiled from: EditUserOperationController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        a() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            m0 j2 = c0.this.j();
            if (j2 == null) {
                return;
            }
            j2.l(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            m0 j2 = c0.this.j();
            if (j2 == null) {
                return;
            }
            j2.h(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            m0 j2 = c0.this.j();
            if (j2 == null) {
                return;
            }
            j2.i(f2);
        }
    }

    public c0(ViewGroup container, AppCompatImageView iconUndo, AppCompatImageView iconRedo, AppCompatImageView showOriginPicBt, ImageView iconInnerUndo, ImageView iconInnerRedo) {
        kotlin.jvm.internal.s.h(container, "container");
        kotlin.jvm.internal.s.h(iconUndo, "iconUndo");
        kotlin.jvm.internal.s.h(iconRedo, "iconRedo");
        kotlin.jvm.internal.s.h(showOriginPicBt, "showOriginPicBt");
        kotlin.jvm.internal.s.h(iconInnerUndo, "iconInnerUndo");
        kotlin.jvm.internal.s.h(iconInnerRedo, "iconInnerRedo");
        this.a = container;
        this.b = iconUndo;
        this.c = iconRedo;
        this.f10743d = showOriginPicBt;
        this.f10744e = iconInnerUndo;
        this.f10745f = iconInnerRedo;
        ((StickySeekBar) container.findViewById(R.id.seekBar)).setTrackListener(new a());
        ((SwitchCompat) container.findViewById(R.id.switchToggle)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.edit2020.view.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                c0.a(c0.this, compoundButton, z);
            }
        });
        iconUndo.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c0.b(c0.this, view);
            }
        });
        iconRedo.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c0.c(c0.this, view);
            }
        });
        iconInnerUndo.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c0.d(c0.this, view);
            }
        });
        iconInnerRedo.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c0.e(c0.this, view);
            }
        });
        showOriginPicBt.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.edit2020.view.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f2;
                f2 = c0.f(c0.this, view, motionEvent);
                return f2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(c0 this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        p0 p0Var = this$0.f10746g;
        if (p0Var != null) {
            p0Var.t(z);
        }
        if (z) {
            ((TextView) this$0.a.findViewById(R.id.txtToggleHint)).setText(us.pinguo.repository2020.R.string.toggle_enabled);
        } else {
            ((TextView) this$0.a.findViewById(R.id.txtToggleHint)).setText(us.pinguo.repository2020.R.string.toggle_disabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c0 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        p0 p0Var = this$0.f10746g;
        if (p0Var == null) {
            return;
        }
        p0Var.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c0 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        p0 p0Var = this$0.f10746g;
        if (p0Var == null) {
            return;
        }
        p0Var.P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c0 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        p0 p0Var = this$0.f10746g;
        if (p0Var == null) {
            return;
        }
        p0Var.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c0 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        p0 p0Var = this$0.f10746g;
        if (p0Var == null) {
            return;
        }
        p0Var.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(c0 this$0, View view, MotionEvent motionEvent) {
        p0 p0Var;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            p0 p0Var2 = this$0.f10746g;
            if (p0Var2 != null) {
                p0Var2.k(true);
            }
        } else if ((action == 1 || action == 3) && (p0Var = this$0.f10746g) != null) {
            p0Var.k(false);
        }
        return true;
    }

    public final void A(String str) {
        kotlin.jvm.internal.s.h(str, "str");
        ((TextView) this.a.findViewById(R.id.seekbarName)).setText(str);
    }

    public final void B(int... colors) {
        kotlin.jvm.internal.s.h(colors, "colors");
        ((StickySeekBar) this.a.findViewById(R.id.seekBar)).setTrackColor(Arrays.copyOf(colors, colors.length));
    }

    public final void C(boolean z) {
        StickySeekBar stickySeekBar = (StickySeekBar) this.a.findViewById(R.id.seekBar);
        kotlin.jvm.internal.s.g(stickySeekBar, "container.seekBar");
        int i2 = z ^ true ? 4 : 0;
        stickySeekBar.setVisibility(i2);
        VdsAgent.onSetViewVisibility(stickySeekBar, i2);
    }

    public final void D(p0 p0Var) {
        this.f10746g = p0Var;
    }

    public final void E() {
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup, 0);
    }

    public final void F(boolean z) {
        ImageView imageView = this.f10744e;
        int i2 = z ? 0 : 8;
        imageView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(imageView, i2);
        ImageView imageView2 = this.f10745f;
        int i3 = z ? 0 : 8;
        imageView2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(imageView2, i3);
    }

    public final void G() {
        RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.flSeekBar);
        kotlin.jvm.internal.s.g(relativeLayout, "container.flSeekBar");
        relativeLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(relativeLayout, 4);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.a.findViewById(R.id.clToggleLayout);
        kotlin.jvm.internal.s.g(constraintLayout, "container.clToggleLayout");
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
    }

    public final void H(boolean z) {
        if (z) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            return;
        }
        this.b.setVisibility(4);
        this.c.setVisibility(4);
    }

    public final void I(int i2, int i3, int i4, int i5) {
        ((StickySeekBar) this.a.findViewById(R.id.seekBar)).setValues(i2, i3, i4, Integer.valueOf(i5));
    }

    public final void J(boolean z, boolean z2) {
        this.f10744e.setImageResource(z ? R.drawable.ic_inner_undo_enable : R.drawable.ic_inner_undo_unable);
        this.f10745f.setImageResource(z2 ? R.drawable.ic_inner_redo_enable : R.drawable.ic_inner_redo_unable);
    }

    public final ViewGroup g() {
        return this.a;
    }

    public final ImageView h() {
        return this.f10745f;
    }

    public final ImageView i() {
        return this.f10744e;
    }

    public final m0 j() {
        return this.f10747h;
    }

    public final void k() {
        ViewGroup viewGroup = this.a;
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
    }

    public final boolean l() {
        StickySeekBar stickySeekBar = (StickySeekBar) this.a.findViewById(R.id.seekBar);
        kotlin.jvm.internal.s.g(stickySeekBar, "container.seekBar");
        if (stickySeekBar.getVisibility() == 0) {
            RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.flSeekBar);
            kotlin.jvm.internal.s.g(relativeLayout, "container.flSeekBar");
            if (relativeLayout.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void s(int i2) {
        this.f10743d.animate().translationY(i2).setDuration(200L).start();
    }

    public final void t(boolean z, boolean z2) {
        Context b = us.pinguo.foundation.e.b();
        Drawable drawable = ContextCompat.getDrawable(b, R.drawable.ic_edit_undo);
        if (drawable == null) {
            return;
        }
        drawable.setTint(us.pinguo.edit2020.utils.d.h(z ? R.color.edit_item_enable : R.color.edit_item_unable));
        this.b.setImageDrawable(drawable);
        Drawable drawable2 = ContextCompat.getDrawable(b, R.drawable.ic_edit_redo);
        if (drawable2 == null) {
            return;
        }
        drawable2.setTint(us.pinguo.edit2020.utils.d.h(z2 ? R.color.edit_item_enable : R.color.edit_item_unable));
        this.c.setImageDrawable(drawable2);
    }

    public final void u(boolean z) {
        if (z) {
            this.f10743d.setVisibility(0);
        } else {
            this.f10743d.setVisibility(4);
        }
    }

    public final void v(m0 m0Var) {
        this.f10747h = m0Var;
    }

    public final void w(int i2) {
        RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.flSeekBar);
        relativeLayout.setVisibility(i2);
        VdsAgent.onSetViewVisibility(relativeLayout, i2);
    }

    public final void x(boolean z) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.a.findViewById(R.id.clToggleLayout);
        kotlin.jvm.internal.s.g(constraintLayout, "container.clToggleLayout");
        constraintLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(constraintLayout, 4);
        RelativeLayout relativeLayout = (RelativeLayout) this.a.findViewById(R.id.flSeekBar);
        kotlin.jvm.internal.s.g(relativeLayout, "container.flSeekBar");
        int i2 = z ? 0 : 8;
        relativeLayout.setVisibility(i2);
        VdsAgent.onSetViewVisibility(relativeLayout, i2);
    }

    public final void y(StickySeekBar.DefaultDotStyle style) {
        kotlin.jvm.internal.s.h(style, "style");
        ((StickySeekBar) this.a.findViewById(R.id.seekBar)).setDotStyle(style);
    }

    public final void z(boolean z) {
        TextView textView = (TextView) this.a.findViewById(R.id.seekbarName);
        kotlin.jvm.internal.s.g(textView, "container.seekbarName");
        int i2 = z ? 0 : 8;
        textView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(textView, i2);
    }
}
