package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.LanFitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: SkinToneAdjustView.kt */
/* loaded from: classes4.dex */
public final class SkinToneAdjustView extends ConstraintLayout {
    public Map<Integer, View> a;
    private String b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f10740d;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.jvm.b.l<? super String, kotlin.u> f10741e;

    /* renamed from: f  reason: collision with root package name */
    private a f10742f;

    /* compiled from: SkinToneAdjustView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, int i2);

        void b(String str, int i2);
    }

    /* compiled from: SkinToneAdjustView.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.ui.widget.h {
        b() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            a h2 = SkinToneAdjustView.this.h();
            if (h2 == null) {
                return;
            }
            h2.a(SkinToneAdjustView.this.g(), i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            a h2 = SkinToneAdjustView.this.h();
            if (h2 == null) {
                return;
            }
            h2.b(SkinToneAdjustView.this.g(), i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SkinToneAdjustView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SkinToneAdjustView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ SkinToneAdjustView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void i() {
        ((LanFitTextView) _$_findCachedViewById(R.id.tvHardness)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkinToneAdjustView.j(SkinToneAdjustView.this, view);
            }
        });
        ((LanFitTextView) _$_findCachedViewById(R.id.tvWarm)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SkinToneAdjustView.k(SkinToneAdjustView.this, view);
            }
        });
        ((StickySeekBar) _$_findCachedViewById(R.id.sbAdjust)).setTrackListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(SkinToneAdjustView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b = "hardness";
        this$0.p();
        kotlin.jvm.b.l<? super String, kotlin.u> lVar = this$0.f10741e;
        if (lVar == null) {
            return;
        }
        lVar.invoke(this$0.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SkinToneAdjustView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b = "warm";
        this$0.p();
        kotlin.jvm.b.l<? super String, kotlin.u> lVar = this$0.f10741e;
        if (lVar == null) {
            return;
        }
        lVar.invoke(this$0.b);
    }

    private final void n() {
        p();
    }

    private final void p() {
        if (kotlin.jvm.internal.s.c("hardness", this.b)) {
            int i2 = R.id.tvHardness;
            ((LanFitTextView) _$_findCachedViewById(i2)).setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_black));
            ((LanFitTextView) _$_findCachedViewById(i2)).setBackgroundResource(R.drawable.bg_tv_paint_or_eraser);
            int i3 = R.id.tvWarm;
            ((LanFitTextView) _$_findCachedViewById(i3)).setBackground(null);
            ((LanFitTextView) _$_findCachedViewById(i3)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_dark));
            return;
        }
        int i4 = R.id.tvWarm;
        ((LanFitTextView) _$_findCachedViewById(i4)).setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_black));
        ((LanFitTextView) _$_findCachedViewById(i4)).setBackgroundResource(R.drawable.bg_tv_paint_or_eraser);
        int i5 = R.id.tvHardness;
        ((LanFitTextView) _$_findCachedViewById(i5)).setBackground(null);
        ((LanFitTextView) _$_findCachedViewById(i5)).setTextColor(ContextCompat.getColor(getContext(), R.color.color_camera_theme_dark));
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

    public final String g() {
        return this.b;
    }

    public final a h() {
        return this.f10742f;
    }

    public final void o(boolean z) {
        View viewMask = _$_findCachedViewById(R.id.viewMask);
        kotlin.jvm.internal.s.g(viewMask, "viewMask");
        int i2 = z ? 0 : 8;
        viewMask.setVisibility(i2);
        VdsAgent.onSetViewVisibility(viewMask, i2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        n();
        i();
    }

    public final void q(String type) {
        kotlin.jvm.internal.s.h(type, "type");
        this.b = type;
        p();
    }

    public final void setOnSeekbarChangeListener(a aVar) {
        this.f10742f = aVar;
    }

    public final void setOnToggleSwitch(kotlin.jvm.b.l<? super String, kotlin.u> lVar) {
        this.f10741e = lVar;
    }

    public final void setSeekBarValue(int i2, int i3, int i4, int i5) {
        if (kotlin.jvm.internal.s.c("hardness", this.b)) {
            int i6 = R.id.sbAdjust;
            ((StickySeekBar) _$_findCachedViewById(i6)).setValues(i2, i3, i4, Integer.valueOf(i5));
            ((StickySeekBar) _$_findCachedViewById(i6)).setTrackColor(this.c);
            ((StickySeekBar) _$_findCachedViewById(i6)).setDotStyle(StickySeekBar.DefaultDotStyle.NONE);
            return;
        }
        int i7 = R.id.sbAdjust;
        ((StickySeekBar) _$_findCachedViewById(i7)).setValues(i2, i3, i4, Integer.valueOf(i5));
        int[] iArr = this.f10740d;
        ((StickySeekBar) _$_findCachedViewById(i7)).setTrackColor(Arrays.copyOf(iArr, iArr.length));
        ((StickySeekBar) _$_findCachedViewById(i7)).setDotStyle(StickySeekBar.DefaultDotStyle.CIRCLE);
        ((StickySeekBar) _$_findCachedViewById(i7)).setDotColor(us.pinguo.edit2020.utils.d.h(R.color.primary_text_enable));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinToneAdjustView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = "hardness";
        this.c = us.pinguo.edit2020.utils.d.h(R.color.edit_seekbar_default);
        this.f10740d = new int[]{us.pinguo.edit2020.utils.d.h(R.color.skin_color_start_color), us.pinguo.edit2020.utils.d.h(R.color.skin_color_middle_color), us.pinguo.edit2020.utils.d.h(R.color.skin_color_end_color)};
    }
}
