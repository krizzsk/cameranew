package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.LanFitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: ManualMattingView.kt */
/* loaded from: classes4.dex */
public final class ManualMattingView extends ConstraintLayout {
    public Map<Integer, View> a;
    private kotlin.jvm.b.p<? super Integer, ? super us.pinguo.edit2020.bean.c0, kotlin.u> b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private String f10703d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.edit2020.bean.c0 f10704e;

    /* renamed from: f  reason: collision with root package name */
    private int f10705f;

    /* renamed from: g  reason: collision with root package name */
    private int f10706g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.h0 f10707h;

    /* compiled from: ManualMattingView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, us.pinguo.edit2020.bean.c0 c0Var);

        void b(boolean z, us.pinguo.edit2020.bean.c0 c0Var);
    }

    /* compiled from: ManualMattingView.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.ui.widget.h {
        b() {
        }

        private final boolean a() {
            us.pinguo.edit2020.adapter.h0 h0Var = ManualMattingView.this.f10707h;
            return 1 == (h0Var == null ? -1 : h0Var.l());
        }

        private final void d(int i2) {
            us.pinguo.edit2020.bean.c0 c0Var = ManualMattingView.this.f10704e;
            if (c0Var == null) {
                return;
            }
            ManualMattingView manualMattingView = ManualMattingView.this;
            if (!kotlin.jvm.internal.s.c(BigAlbumStore.PhotoColumns.SIZE, manualMattingView.f10703d)) {
                if (kotlin.jvm.internal.s.c("hardness", manualMattingView.f10703d)) {
                    c0Var.l(i2);
                    return;
                }
                return;
            }
            c0Var.m(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("onTrackStop==>", Integer.valueOf(i2)), new Object[0]);
            if (ManualMattingView.this.f10704e == null) {
                return;
            }
            d(i2);
            a m = ManualMattingView.this.m();
            if (m == null) {
                return;
            }
            boolean a = a();
            us.pinguo.edit2020.bean.c0 c0Var = ManualMattingView.this.f10704e;
            if (c0Var == null) {
                return;
            }
            m.a(a, c0Var);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("onTracking==>", Integer.valueOf(i2)), new Object[0]);
            if (ManualMattingView.this.f10704e == null) {
                return;
            }
            d(i2);
            a m = ManualMattingView.this.m();
            if (m == null) {
                return;
            }
            boolean a = a();
            us.pinguo.edit2020.bean.c0 c0Var = ManualMattingView.this.f10704e;
            if (c0Var == null) {
                return;
            }
            m.b(a, c0Var);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManualMattingView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ManualMattingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ ManualMattingView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void A() {
        B(this.f10703d);
    }

    private final void B(String str) {
        if (kotlin.jvm.internal.s.c(str, BigAlbumStore.PhotoColumns.SIZE)) {
            int i2 = R.id.tvSize;
            ((LanFitTextView) _$_findCachedViewById(i2)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_black));
            ((LanFitTextView) _$_findCachedViewById(i2)).setBackgroundResource(R.drawable.bg_tv_paint_or_eraser);
            int i3 = R.id.tvHardness;
            ((LanFitTextView) _$_findCachedViewById(i3)).setBackground(null);
            ((LanFitTextView) _$_findCachedViewById(i3)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_dark));
            return;
        }
        int i4 = R.id.tvHardness;
        ((LanFitTextView) _$_findCachedViewById(i4)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_black));
        ((LanFitTextView) _$_findCachedViewById(i4)).setBackgroundResource(R.drawable.bg_tv_paint_or_eraser);
        int i5 = R.id.tvSize;
        ((LanFitTextView) _$_findCachedViewById(i5)).setBackground(null);
        ((LanFitTextView) _$_findCachedViewById(i5)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_dark));
    }

    private final void o() {
        ((LanFitTextView) _$_findCachedViewById(R.id.tvSize)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualMattingView.p(ManualMattingView.this, view);
            }
        });
        ((LanFitTextView) _$_findCachedViewById(R.id.tvHardness)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManualMattingView.q(ManualMattingView.this, view);
            }
        });
        ((StickySeekBar) _$_findCachedViewById(R.id.sbAdjust)).setTrackListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ManualMattingView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f10703d = BigAlbumStore.PhotoColumns.SIZE;
        this$0.B(BigAlbumStore.PhotoColumns.SIZE);
        this$0.z(this$0.f10704e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ManualMattingView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f10703d = "hardness";
        this$0.B("hardness");
        this$0.z(this$0.f10704e);
    }

    public static /* synthetic */ void v(ManualMattingView manualMattingView, ArrayList arrayList, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = 1;
        }
        manualMattingView.u(arrayList, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(us.pinguo.edit2020.bean.c0 c0Var) {
        z(c0Var);
        this.f10704e = c0Var;
    }

    private final void z(us.pinguo.edit2020.bean.c0 c0Var) {
        if (c0Var != null) {
            if (kotlin.jvm.internal.s.c(BigAlbumStore.PhotoColumns.SIZE, this.f10703d)) {
                ((StickySeekBar) _$_findCachedViewById(R.id.sbAdjust)).setValues(0, 100, c0Var.h(), Integer.valueOf(c0Var.j()));
            } else {
                ((StickySeekBar) _$_findCachedViewById(R.id.sbAdjust)).setValues(0, 100, c0Var.g(), Integer.valueOf(c0Var.i()));
            }
        }
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

    public final int k() {
        us.pinguo.edit2020.bean.c0 c0Var = this.f10704e;
        int h2 = c0Var == null ? 25 : c0Var.h();
        this.f10705f = h2;
        return h2;
    }

    public final kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.c0, kotlin.u> l() {
        return this.b;
    }

    public final a m() {
        return this.c;
    }

    public final us.pinguo.edit2020.bean.c0 n() {
        us.pinguo.edit2020.adapter.h0 h0Var = this.f10707h;
        if (h0Var == null) {
            return null;
        }
        return h0Var.k();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        A();
        o();
    }

    public final boolean r() {
        return kotlin.jvm.internal.s.c(this.f10703d, BigAlbumStore.PhotoColumns.SIZE);
    }

    public final void setCurrentBrushSize(int i2) {
        this.f10705f = i2;
        us.pinguo.edit2020.bean.c0 c0Var = this.f10704e;
        if (c0Var != null) {
            c0Var.m(i2);
        }
        ((StickySeekBar) _$_findCachedViewById(R.id.sbAdjust)).setProgress(this.f10705f);
    }

    public final void setDefaultBrushSize(int i2) {
        this.f10706g = i2;
        us.pinguo.edit2020.bean.c0 c0Var = this.f10704e;
        if (c0Var != null) {
            c0Var.o(i2);
        }
        ((StickySeekBar) _$_findCachedViewById(R.id.sbAdjust)).setDefaultProgress(this.f10706g);
    }

    public final void setOnItemChangedListener(kotlin.jvm.b.p<? super Integer, ? super us.pinguo.edit2020.bean.c0, kotlin.u> pVar) {
        this.b = pVar;
    }

    public final void setOnTrackListener(a aVar) {
        this.c = aVar;
    }

    public final void setOnlySize(boolean z) {
        if (z) {
            LanFitTextView tvHardness = (LanFitTextView) _$_findCachedViewById(R.id.tvHardness);
            kotlin.jvm.internal.s.g(tvHardness, "tvHardness");
            tvHardness.setVisibility(8);
            VdsAgent.onSetViewVisibility(tvHardness, 8);
            ((LinearLayout) _$_findCachedViewById(R.id.llContainer)).setBackground(null);
            int i2 = R.id.tvSize;
            ((LanFitTextView) _$_findCachedViewById(i2)).setBackgroundColor(-1);
            ((LanFitTextView) _$_findCachedViewById(i2)).setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_black));
            return;
        }
        ((LinearLayout) _$_findCachedViewById(R.id.llContainer)).setBackgroundResource(R.drawable.bg_paint_and_eraser);
    }

    public final void u(ArrayList<us.pinguo.edit2020.bean.c0> dataList, Integer num) {
        int i2;
        kotlin.jvm.internal.s.h(dataList, "dataList");
        if (this.f10707h == null) {
            int i3 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i3)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            us.pinguo.edit2020.adapter.h0 h0Var = new us.pinguo.edit2020.adapter.h0();
            i2 = kotlin.collections.u.i(dataList);
            h0Var.e(false, 0, i2);
            h0Var.A(new ManualMattingView$refreshData$1$1(dataList, this));
            ((RecyclerView) _$_findCachedViewById(i3)).setAdapter(h0Var);
            us.pinguo.edit2020.adapter.a0.u(h0Var, dataList, num, false, 4, null);
            this.f10707h = h0Var;
            return;
        }
        B(this.f10703d);
        us.pinguo.edit2020.adapter.h0 h0Var2 = this.f10707h;
        if (h0Var2 == null) {
            return;
        }
        us.pinguo.edit2020.adapter.a0.u(h0Var2, dataList, num, false, 4, null);
    }

    public final void w(int i2) {
        us.pinguo.edit2020.adapter.h0 h0Var = this.f10707h;
        if (h0Var == null) {
            return;
        }
        h0Var.s(Integer.valueOf(i2));
    }

    public final void x() {
        this.f10703d = BigAlbumStore.PhotoColumns.SIZE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualMattingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.f10703d = BigAlbumStore.PhotoColumns.SIZE;
    }
}
