package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.Facial3DFunctionConfig;
import us.pinguo.edit2020.bean.q;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.LanFitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: Facial3DAdjustView.kt */
/* loaded from: classes4.dex */
public final class Facial3DAdjustView extends ConstraintLayout {
    public Map<Integer, View> a;
    private String b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.edit2020.bean.q f10662d;

    /* compiled from: Facial3DAdjustView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void b(int i2);

        void c(int i2);
    }

    /* compiled from: Facial3DAdjustView.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Facial3DFunctionConfig.values().length];
            iArr[Facial3DFunctionConfig.ALL3D.ordinal()] = 1;
            iArr[Facial3DFunctionConfig.ONLY3D.ordinal()] = 2;
            iArr[Facial3DFunctionConfig.COLOR_AND_3D.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: Facial3DAdjustView.kt */
    /* loaded from: classes4.dex */
    public static final class c implements us.pinguo.ui.widget.h {
        c() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (kotlin.jvm.internal.s.c(Facial3DAdjustView.this.h(), "contour")) {
                us.pinguo.edit2020.bean.q g2 = Facial3DAdjustView.this.g();
                if (g2 != null) {
                    g2.o(i2);
                }
            } else {
                us.pinguo.edit2020.bean.q g3 = Facial3DAdjustView.this.g();
                if (g3 != null) {
                    g3.p(i2);
                }
            }
            a i3 = Facial3DAdjustView.this.i();
            if (i3 == null) {
                return;
            }
            i3.b(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (kotlin.jvm.internal.s.c(Facial3DAdjustView.this.h(), "contour")) {
                us.pinguo.edit2020.bean.q g2 = Facial3DAdjustView.this.g();
                if (g2 != null) {
                    g2.o(i2);
                }
            } else {
                us.pinguo.edit2020.bean.q g3 = Facial3DAdjustView.this.g();
                if (g3 != null) {
                    g3.p(i2);
                }
            }
            a i3 = Facial3DAdjustView.this.i();
            if (i3 == null) {
                return;
            }
            i3.c(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Facial3DAdjustView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Facial3DAdjustView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ Facial3DAdjustView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void j() {
        ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setTrackListener(new c());
        ((LanFitTextView) _$_findCachedViewById(R.id.tvAdjust3D)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Facial3DAdjustView.k(Facial3DAdjustView.this, view);
            }
        });
        ((LanFitTextView) _$_findCachedViewById(R.id.tvAdjustColor)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Facial3DAdjustView.l(Facial3DAdjustView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Facial3DAdjustView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b = "contour";
        this$0.p("contour");
        us.pinguo.edit2020.bean.q qVar = this$0.f10662d;
        if (qVar == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.k(this$0.h(), qVar.f(), "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Facial3DAdjustView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b = TypedValues.Custom.S_COLOR;
        this$0.p(TypedValues.Custom.S_COLOR);
        us.pinguo.edit2020.bean.q qVar = this$0.f10662d;
        if (qVar == null) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.k(this$0.h(), qVar.f(), "click");
    }

    private final void p(String str) {
        if (kotlin.jvm.internal.s.c(str, "contour")) {
            int i2 = R.id.tvAdjust3D;
            ((LanFitTextView) _$_findCachedViewById(i2)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_black));
            ((LanFitTextView) _$_findCachedViewById(i2)).setBackgroundResource(R.drawable.bg_tv_paint_or_eraser);
            int i3 = R.id.tvAdjustColor;
            ((LanFitTextView) _$_findCachedViewById(i3)).setBackground(null);
            ((LanFitTextView) _$_findCachedViewById(i3)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_dark));
            us.pinguo.edit2020.bean.q qVar = this.f10662d;
            if (qVar == null) {
                return;
            }
            if (kotlin.jvm.internal.s.c(qVar.f(), "yanjing")) {
                q.a aVar = us.pinguo.edit2020.bean.q.f10240g;
                ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setValues(aVar.b().getFirst().intValue(), aVar.b().getSecond().intValue(), qVar.j(), aVar.b().getThird());
                return;
            }
            ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setValues(qVar.n(), qVar.m(), qVar.j(), Integer.valueOf(qVar.l()));
            return;
        }
        int i4 = R.id.tvAdjustColor;
        ((LanFitTextView) _$_findCachedViewById(i4)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_black));
        ((LanFitTextView) _$_findCachedViewById(i4)).setBackgroundResource(R.drawable.bg_tv_paint_or_eraser);
        int i5 = R.id.tvAdjust3D;
        ((LanFitTextView) _$_findCachedViewById(i5)).setBackground(null);
        ((LanFitTextView) _$_findCachedViewById(i5)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_dark));
        us.pinguo.edit2020.bean.q qVar2 = this.f10662d;
        if (qVar2 == null) {
            return;
        }
        ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setValues(qVar2.n(), qVar2.m(), qVar2.k(), Integer.valueOf(qVar2.l()));
    }

    private final void q(int i2, int i3) {
        StickySeekBar seekBar = (StickySeekBar) _$_findCachedViewById(R.id.seekBar);
        kotlin.jvm.internal.s.g(seekBar, "seekBar");
        ViewGroup.LayoutParams layoutParams = seekBar.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(i2);
        layoutParams2.setMarginEnd(i3);
        seekBar.setLayoutParams(layoutParams2);
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

    public final us.pinguo.edit2020.bean.q g() {
        return this.f10662d;
    }

    public final String h() {
        return this.b;
    }

    public final a i() {
        return this.c;
    }

    public final void o() {
        this.f10662d = null;
        this.b = "contour";
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        j();
    }

    public final void setCurrent3DFunction(us.pinguo.edit2020.bean.q qVar) {
        this.f10662d = qVar;
    }

    public final void setCurrentConfigType(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.b = str;
    }

    public final void setCurrentFunction(us.pinguo.edit2020.bean.q function) {
        kotlin.jvm.internal.s.h(function, "function");
        this.f10662d = function;
        q.a aVar = us.pinguo.edit2020.bean.q.f10240g;
        int i2 = b.a[aVar.c(function.f()).ordinal()];
        if (i2 == 1) {
            AutofitTextView tv3D = (AutofitTextView) _$_findCachedViewById(R.id.tv3D);
            kotlin.jvm.internal.s.g(tv3D, "tv3D");
            tv3D.setVisibility(4);
            VdsAgent.onSetViewVisibility(tv3D, 4);
            LinearLayout llColorAndFilter = (LinearLayout) _$_findCachedViewById(R.id.llColorAndFilter);
            kotlin.jvm.internal.s.g(llColorAndFilter, "llColorAndFilter");
            llColorAndFilter.setVisibility(4);
            VdsAgent.onSetViewVisibility(llColorAndFilter, 4);
            q(us.pinguo.common.widget.i.a.a(Double.valueOf(47.5d)), us.pinguo.common.widget.i.a.a(Double.valueOf(47.5d)));
            this.b = "contour";
            ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setValues(function.n(), function.m(), function.j(), Integer.valueOf(function.l()));
        } else if (i2 == 2) {
            AutofitTextView tv3D2 = (AutofitTextView) _$_findCachedViewById(R.id.tv3D);
            kotlin.jvm.internal.s.g(tv3D2, "tv3D");
            tv3D2.setVisibility(0);
            VdsAgent.onSetViewVisibility(tv3D2, 0);
            LinearLayout llColorAndFilter2 = (LinearLayout) _$_findCachedViewById(R.id.llColorAndFilter);
            kotlin.jvm.internal.s.g(llColorAndFilter2, "llColorAndFilter");
            llColorAndFilter2.setVisibility(4);
            VdsAgent.onSetViewVisibility(llColorAndFilter2, 4);
            q(us.pinguo.common.widget.i.a.a(60), us.pinguo.common.widget.i.a.a(12));
            this.b = "contour";
            ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setValues(function.n(), function.m(), function.j(), Integer.valueOf(function.l()));
        } else if (i2 != 3) {
        } else {
            AutofitTextView tv3D3 = (AutofitTextView) _$_findCachedViewById(R.id.tv3D);
            kotlin.jvm.internal.s.g(tv3D3, "tv3D");
            tv3D3.setVisibility(4);
            VdsAgent.onSetViewVisibility(tv3D3, 4);
            LinearLayout llColorAndFilter3 = (LinearLayout) _$_findCachedViewById(R.id.llColorAndFilter);
            kotlin.jvm.internal.s.g(llColorAndFilter3, "llColorAndFilter");
            llColorAndFilter3.setVisibility(0);
            VdsAgent.onSetViewVisibility(llColorAndFilter3, 0);
            q(us.pinguo.common.widget.i.a.a(114), us.pinguo.common.widget.i.a.a(12));
            String a2 = aVar.a(function.f());
            this.b = a2;
            p(a2);
        }
    }

    public final void setOnTrackListener(a aVar) {
        this.c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Facial3DAdjustView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = "contour";
    }
}
