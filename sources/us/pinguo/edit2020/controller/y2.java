package us.pinguo.edit2020.controller;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.LowerResolutionCpuMobile;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import java.util.Objects;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.viewmodel.module.EditAutoBeautifyModule;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: EditAutoBeautifyController.kt */
/* loaded from: classes4.dex */
public final class y2 implements e3, us.pinguo.edit2020.b.c {
    private final EditAutoBeautifyModule a;
    private final FrameLayout b;
    private final ConstraintLayout c;

    /* compiled from: EditAutoBeautifyController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        final /* synthetic */ us.pinguo.edit2020.bean.c a;

        a(us.pinguo.edit2020.bean.c cVar) {
            this.a = cVar;
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList()) {
                this.a.k(i2);
                kotlin.jvm.b.l<Float, kotlin.u> i3 = this.a.i();
                if (i3 == null) {
                    return;
                }
                i3.invoke(Float.valueOf(i2 / 100.0f));
            }
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            kotlin.jvm.b.l<Float, kotlin.u> i3;
            this.a.j(i2 != 0);
            this.a.k(i2);
            if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList() || (i3 = this.a.i()) == null) {
                return;
            }
            i3.invoke(Float.valueOf(i2 / 100.0f));
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    public y2(EditAutoBeautifyModule module, FrameLayout flPanelContainer, NumberTipView numberTipView) {
        kotlin.jvm.internal.s.h(module, "module");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(numberTipView, "numberTipView");
        this.a = module;
        this.b = flPanelContainer;
        View inflate = LayoutInflater.from(flPanelContainer.getContext()).inflate(R.layout.layout_auto_beautify, (ViewGroup) flPanelContainer, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.c = constraintLayout;
        StickySeekBar stickySeekBar = (StickySeekBar) constraintLayout.findViewById(R.id.sbBeauty);
        List<us.pinguo.edit2020.bean.c> a2 = module.a();
        us.pinguo.edit2020.bean.c cVar = a2.get(0);
        final us.pinguo.edit2020.bean.c cVar2 = a2.get(1);
        final us.pinguo.edit2020.bean.c cVar3 = a2.get(2);
        stickySeekBar.setDefaultProgress(cVar.h());
        stickySeekBar.setProgress(cVar.g());
        stickySeekBar.setTrackListener(new a(cVar));
        ((SwitchCompat) constraintLayout.findViewById(R.id.switchShape)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.edit2020.controller.p0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                y2.a(us.pinguo.edit2020.bean.c.this, compoundButton, z);
            }
        });
        ((SwitchCompat) constraintLayout.findViewById(R.id.switchMakeup)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.edit2020.controller.o0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                y2.c(us.pinguo.edit2020.bean.c.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(us.pinguo.edit2020.bean.c funcShape, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(funcShape, "$funcShape");
        int i2 = z ? 100 : 0;
        funcShape.j(z);
        funcShape.k(i2);
        kotlin.jvm.b.l<Float, kotlin.u> i3 = funcShape.i();
        if (i3 != null) {
            i3.invoke(Float.valueOf(i2 / 100.0f));
        }
        us.pinguo.foundation.statistics.h.b.d0(funcShape.f(), z ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off", "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(us.pinguo.edit2020.bean.c funcMakeup, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(funcMakeup, "$funcMakeup");
        int i2 = z ? 100 : 0;
        funcMakeup.j(z);
        funcMakeup.k(i2);
        kotlin.jvm.b.l<Float, kotlin.u> i3 = funcMakeup.i();
        if (i3 != null) {
            i3.invoke(Float.valueOf(i2 / 100.0f));
        }
        us.pinguo.foundation.statistics.h.b.d0(funcMakeup.f(), z ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off", "click");
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return c.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return c.a.c(this);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        return true;
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        this.a.c();
        ((SwitchCompat) this.c.findViewById(R.id.switchShape)).setChecked(false);
        ((SwitchCompat) this.c.findViewById(R.id.switchMakeup)).setChecked(false);
        ((StickySeekBar) this.c.findViewById(R.id.sbBeauty)).setProgress(this.a.a().get(0).h());
        FrameLayout frameLayout = this.b;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        layoutParams2.topToBottom = -1;
        frameLayout.setLayoutParams(layoutParams2);
        this.b.removeAllViews();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return c.a.b(this);
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        this.a.c();
        ((SwitchCompat) this.c.findViewById(R.id.switchShape)).setChecked(false);
        ((SwitchCompat) this.c.findViewById(R.id.switchMakeup)).setChecked(false);
        ((StickySeekBar) this.c.findViewById(R.id.sbBeauty)).setProgress(this.a.a().get(0).h());
        FrameLayout frameLayout = this.b;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        layoutParams2.topToBottom = -1;
        frameLayout.setLayoutParams(layoutParams2);
        this.b.removeAllViews();
    }

    public final void h(boolean z) {
        if (z) {
            ConstraintLayout constraintLayout = this.c;
            int i2 = R.id.switchShape;
            ((SwitchCompat) constraintLayout.findViewById(i2)).setEnabled(true);
            ((SwitchCompat) this.c.findViewById(i2)).setClickable(true);
            ConstraintLayout constraintLayout2 = this.c;
            int i3 = R.id.switchMakeup;
            ((SwitchCompat) constraintLayout2.findViewById(i3)).setEnabled(true);
            ((SwitchCompat) this.c.findViewById(i3)).setClickable(true);
            ((StickySeekBar) this.c.findViewById(R.id.sbBeauty)).setEnabled(true);
            return;
        }
        ((SwitchCompat) this.c.findViewById(R.id.switchShape)).setClickable(false);
        ((SwitchCompat) this.c.findViewById(R.id.switchMakeup)).setClickable(false);
        ((StickySeekBar) this.c.findViewById(R.id.sbBeauty)).setEnabled(false);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return c.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return null;
    }

    @Override // us.pinguo.edit2020.b.c
    public void z(String str) {
        us.pinguo.edit2020.bean.c cVar = this.a.a().get(0);
        kotlin.jvm.b.l<Float, kotlin.u> i2 = cVar.i();
        if (i2 != null) {
            i2.invoke(Float.valueOf(cVar.g() / 100.0f));
        }
        cVar.j(true);
        kotlin.jvm.b.l<Float, kotlin.u> i3 = this.a.a().get(1).i();
        if (i3 != null) {
            i3.invoke(Float.valueOf(0.0f));
        }
        kotlin.jvm.b.l<Float, kotlin.u> i4 = this.a.a().get(2).i();
        if (i4 != null) {
            i4.invoke(Float.valueOf(0.0f));
        }
        if (this.c.getParent() == null) {
            FrameLayout frameLayout = this.b;
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
            layoutParams2.topToBottom = R.id.unityContainer;
            frameLayout.setLayoutParams(layoutParams2);
            this.b.addView(this.c);
        }
    }
}
