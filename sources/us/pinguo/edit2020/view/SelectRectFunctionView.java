package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: SelectRectFunctionView.kt */
/* loaded from: classes4.dex */
public final class SelectRectFunctionView extends ConstraintLayout implements View.OnClickListener {
    public Map<Integer, View> a;
    private final int b;
    private PointF c;

    /* renamed from: d  reason: collision with root package name */
    private PointF f10727d;

    /* renamed from: e  reason: collision with root package name */
    private PointF f10728e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f10729f;

    /* renamed from: g  reason: collision with root package name */
    private a f10730g;

    /* compiled from: SelectRectFunctionView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void c();

        void h();

        void l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRectFunctionView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.b = us.pinguo.util.g.a(context2, 20.0f);
        View.inflate(getContext(), R.layout.select_rect_function_view_layout, this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconEdit)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconCopy)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconTop)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconBottom)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textEdit)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textCopy)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textTop)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textBottom)).setOnClickListener(this);
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
    }

    private final boolean g(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int i2 = R.id.contentView;
        int measuredWidth = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredWidth();
        int measuredHeight = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredHeight();
        int width = getWidth();
        int height = getHeight();
        float f2 = pointF2.x;
        float f3 = pointF.x;
        float f4 = 2;
        float f5 = measuredWidth / 2;
        boolean z = (f2 + f3) / f4 > f5 && ((float) width) - ((f2 + f3) / f4) > f5;
        float f6 = pointF3.y;
        float f7 = measuredHeight;
        int i3 = this.b;
        boolean z2 = (f6 + f7) + ((float) i3) < ((float) height);
        if (z && z2) {
            ((ConstraintLayout) _$_findCachedViewById(i2)).layout((int) (((f2 + f3) / f4) - f5), (int) (i3 + f6), (int) (((f2 + f3) / f4) + f5), (int) (f6 + i3 + f7));
            return true;
        }
        return false;
    }

    private final boolean h(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int i2 = R.id.contentView;
        int measuredWidth = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredWidth();
        int measuredHeight = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredHeight();
        float f2 = pointF2.x;
        float f3 = pointF.x;
        float f4 = 2;
        float f5 = measuredWidth / 2;
        float f6 = pointF.y;
        float f7 = pointF3.y;
        float f8 = measuredHeight / 2;
        ((ConstraintLayout) _$_findCachedViewById(i2)).layout((int) (((f2 + f3) / f4) - f5), (int) (((f6 + f7) / f4) - f8), (int) (((f2 + f3) / f4) + f5), (int) (((f6 + f7) / f4) + f8));
        return true;
    }

    private final boolean l(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int i2 = R.id.contentView;
        int measuredWidth = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredWidth();
        int measuredHeight = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredHeight();
        float f2 = pointF.x;
        int i3 = this.b;
        float f3 = measuredWidth;
        if ((f2 - ((float) i3)) - f3 > 0.0f) {
            float f4 = pointF2.y;
            float f5 = pointF4.y;
            float f6 = 2;
            float f7 = measuredHeight / 2;
            ((ConstraintLayout) _$_findCachedViewById(i2)).layout((int) ((f2 - i3) - f3), (int) (((f4 + f5) / f6) - f7), (int) (f2 - i3), (int) (((f4 + f5) / f6) + f7));
            return true;
        }
        return false;
    }

    private final boolean m(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int i2 = R.id.contentView;
        int measuredWidth = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredWidth();
        int measuredHeight = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredHeight();
        int width = getWidth();
        getHeight();
        float f2 = pointF2.x;
        int i3 = this.b;
        float f3 = measuredWidth;
        if ((((float) i3) + f2) + f3 < ((float) width)) {
            float f4 = pointF2.y;
            float f5 = pointF4.y;
            float f6 = 2;
            float f7 = measuredHeight / 2;
            ((ConstraintLayout) _$_findCachedViewById(i2)).layout((int) (i3 + f2), (int) (((f4 + f5) / f6) - f7), (int) (f2 + i3 + f3), (int) (((f4 + f5) / f6) + f7));
            return true;
        }
        return false;
    }

    private final boolean o(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        int i2 = R.id.contentView;
        int measuredWidth = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredWidth();
        int measuredHeight = ((ConstraintLayout) _$_findCachedViewById(i2)).getMeasuredHeight();
        int width = getWidth();
        getHeight();
        float f2 = pointF2.x;
        float f3 = pointF.x;
        float f4 = 2;
        float f5 = measuredWidth / 2;
        boolean z = (f2 + f3) / f4 > f5 && ((float) width) - ((f2 + f3) / f4) > f5;
        float f6 = pointF.y;
        int i3 = this.b;
        boolean z2 = f6 > ((float) (measuredHeight + i3));
        if (z && z2) {
            ((ConstraintLayout) _$_findCachedViewById(i2)).layout((int) (((f2 + f3) / f4) - f5), (int) ((f6 - measuredHeight) - i3), (int) (((f2 + f3) / f4) + f5), (int) (f6 - i3));
            return true;
        }
        return false;
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

    public final void i() {
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
    }

    public final void j() {
        if (getVisibility() == 0) {
            i();
        }
    }

    public final void k(boolean z, boolean z2) {
        if (z) {
            us.pinguo.foundation.utils.q qVar = us.pinguo.foundation.utils.q.a;
            Context context = getContext();
            kotlin.jvm.internal.s.g(context, "context");
            int i2 = R.color.edit_function_select;
            int i3 = R.drawable.edit_select_rect_func_top;
            AppCompatImageView iconTop = (AppCompatImageView) _$_findCachedViewById(R.id.iconTop);
            kotlin.jvm.internal.s.g(iconTop, "iconTop");
            qVar.a(context, i2, i3, iconTop);
            ((AutofitTextView) _$_findCachedViewById(R.id.textTop)).setTextColor(ContextCompat.getColor(getContext(), i2));
        } else {
            us.pinguo.foundation.utils.q qVar2 = us.pinguo.foundation.utils.q.a;
            Context context2 = getContext();
            kotlin.jvm.internal.s.g(context2, "context");
            int i4 = R.color.edit_function_unselect;
            int i5 = R.drawable.edit_select_rect_func_top;
            AppCompatImageView iconTop2 = (AppCompatImageView) _$_findCachedViewById(R.id.iconTop);
            kotlin.jvm.internal.s.g(iconTop2, "iconTop");
            qVar2.a(context2, i4, i5, iconTop2);
            ((AutofitTextView) _$_findCachedViewById(R.id.textTop)).setTextColor(ContextCompat.getColor(getContext(), i4));
        }
        if (z2) {
            us.pinguo.foundation.utils.q qVar3 = us.pinguo.foundation.utils.q.a;
            Context context3 = getContext();
            kotlin.jvm.internal.s.g(context3, "context");
            int i6 = R.color.edit_function_select;
            int i7 = R.drawable.edit_select_rect_func_bottom;
            AppCompatImageView iconBottom = (AppCompatImageView) _$_findCachedViewById(R.id.iconBottom);
            kotlin.jvm.internal.s.g(iconBottom, "iconBottom");
            qVar3.a(context3, i6, i7, iconBottom);
            ((AutofitTextView) _$_findCachedViewById(R.id.textBottom)).setTextColor(ContextCompat.getColor(getContext(), i6));
            return;
        }
        us.pinguo.foundation.utils.q qVar4 = us.pinguo.foundation.utils.q.a;
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        int i8 = R.color.edit_function_unselect;
        int i9 = R.drawable.edit_select_rect_func_bottom;
        AppCompatImageView iconBottom2 = (AppCompatImageView) _$_findCachedViewById(R.id.iconBottom);
        kotlin.jvm.internal.s.g(iconBottom2, "iconBottom");
        qVar4.a(context4, i8, i9, iconBottom2);
        ((AutofitTextView) _$_findCachedViewById(R.id.textBottom)).setTextColor(ContextCompat.getColor(getContext(), i8));
    }

    public final void n(PointF leftTop, PointF rightTop, PointF leftBottom, PointF rightBottom) {
        kotlin.jvm.internal.s.h(leftTop, "leftTop");
        kotlin.jvm.internal.s.h(rightTop, "rightTop");
        kotlin.jvm.internal.s.h(leftBottom, "leftBottom");
        kotlin.jvm.internal.s.h(rightBottom, "rightBottom");
        this.c = leftTop;
        this.f10728e = leftBottom;
        this.f10727d = rightTop;
        this.f10729f = rightBottom;
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        if (m(leftTop, rightTop, leftBottom, rightBottom) || l(leftTop, rightTop, leftBottom, rightBottom)) {
            return;
        }
        if ((leftTop.y + leftBottom.y) / 2 < getHeight() / 2) {
            if (g(leftTop, rightTop, leftBottom, rightBottom) || o(leftTop, rightTop, leftBottom, rightBottom)) {
                return;
            }
        } else if (o(leftTop, rightTop, leftBottom, rightBottom) || g(leftTop, rightTop, leftBottom, rightBottom)) {
            return;
        }
        if (h(leftTop, rightTop, leftBottom, rightBottom)) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0098, code lost:
        if (r5.intValue() != r0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0082  */
    @Override // android.view.View.OnClickListener
    @com.growingio.android.sdk.instrumentation.Instrumented
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            com.growingio.android.sdk.autoburry.VdsAgent.onClick(r4, r5)
            if (r5 != 0) goto L7
            r5 = 0
            goto Lf
        L7:
            int r5 = r5.getId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        Lf:
            int r0 = us.pinguo.edit2020.R.id.iconEdit
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L16
            goto L1e
        L16:
            int r3 = r5.intValue()
            if (r3 != r0) goto L1e
        L1c:
            r0 = 1
            goto L2b
        L1e:
            int r0 = us.pinguo.edit2020.R.id.textEdit
            if (r5 != 0) goto L23
            goto L2a
        L23:
            int r3 = r5.intValue()
            if (r3 != r0) goto L2a
            goto L1c
        L2a:
            r0 = 0
        L2b:
            if (r0 == 0) goto L38
            us.pinguo.edit2020.view.SelectRectFunctionView$a r5 = r4.f10730g
            if (r5 != 0) goto L33
            goto La5
        L33:
            r5.h()
            goto La5
        L38:
            int r0 = us.pinguo.edit2020.R.id.iconCopy
            if (r5 != 0) goto L3d
            goto L45
        L3d:
            int r3 = r5.intValue()
            if (r3 != r0) goto L45
        L43:
            r0 = 1
            goto L52
        L45:
            int r0 = us.pinguo.edit2020.R.id.textCopy
            if (r5 != 0) goto L4a
            goto L51
        L4a:
            int r3 = r5.intValue()
            if (r3 != r0) goto L51
            goto L43
        L51:
            r0 = 0
        L52:
            if (r0 == 0) goto L5d
            us.pinguo.edit2020.view.SelectRectFunctionView$a r5 = r4.f10730g
            if (r5 != 0) goto L59
            goto La5
        L59:
            r5.c()
            goto La5
        L5d:
            int r0 = us.pinguo.edit2020.R.id.iconTop
            if (r5 != 0) goto L62
            goto L6a
        L62:
            int r3 = r5.intValue()
            if (r3 != r0) goto L6a
        L68:
            r0 = 1
            goto L77
        L6a:
            int r0 = us.pinguo.edit2020.R.id.textTop
            if (r5 != 0) goto L6f
            goto L76
        L6f:
            int r3 = r5.intValue()
            if (r3 != r0) goto L76
            goto L68
        L76:
            r0 = 0
        L77:
            if (r0 == 0) goto L82
            us.pinguo.edit2020.view.SelectRectFunctionView$a r5 = r4.f10730g
            if (r5 != 0) goto L7e
            goto La5
        L7e:
            r5.l()
            goto La5
        L82:
            int r0 = us.pinguo.edit2020.R.id.iconBottom
            if (r5 != 0) goto L87
            goto L8f
        L87:
            int r3 = r5.intValue()
            if (r3 != r0) goto L8f
        L8d:
            r1 = 1
            goto L9b
        L8f:
            int r0 = us.pinguo.edit2020.R.id.textBottom
            if (r5 != 0) goto L94
            goto L9b
        L94:
            int r5 = r5.intValue()
            if (r5 != r0) goto L9b
            goto L8d
        L9b:
            if (r1 == 0) goto La5
            us.pinguo.edit2020.view.SelectRectFunctionView$a r5 = r4.f10730g
            if (r5 != 0) goto La2
            goto La5
        La2:
            r5.a()
        La5:
            r4.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.SelectRectFunctionView.onClick(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        super.onLayout(z, i2, i3, i4, i5);
        PointF pointF4 = this.c;
        if (pointF4 == null || (pointF = this.f10728e) == null || (pointF2 = this.f10727d) == null || (pointF3 = this.f10729f) == null) {
            return;
        }
        if (getVisibility() == 0) {
            n(pointF4, pointF2, pointF, pointF3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i();
        return false;
    }

    public final void setFunctionClickListener(a listener) {
        kotlin.jvm.internal.s.h(listener, "listener");
        this.f10730g = listener;
    }

    public final void setFunctionListener(a aVar) {
        this.f10730g = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRectFunctionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.b = us.pinguo.util.g.a(context2, 20.0f);
        View.inflate(getContext(), R.layout.select_rect_function_view_layout, this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconEdit)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconCopy)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconTop)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconBottom)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textEdit)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textCopy)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textTop)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textBottom)).setOnClickListener(this);
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRectFunctionView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.b = us.pinguo.util.g.a(context2, 20.0f);
        View.inflate(getContext(), R.layout.select_rect_function_view_layout, this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconEdit)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconCopy)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconTop)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(R.id.iconBottom)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textEdit)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textCopy)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textTop)).setOnClickListener(this);
        ((AutofitTextView) _$_findCachedViewById(R.id.textBottom)).setOnClickListener(this);
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
    }
}
