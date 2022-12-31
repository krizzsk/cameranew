package us.pinguo.edit2020.widget.adjust;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.e0;
import us.pinguo.edit2020.adapter.m0;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: PaintEraserAdjustLayout.kt */
/* loaded from: classes4.dex */
public final class PaintEraserAdjustLayout extends LinearLayout {
    public Map<Integer, View> a;
    private a b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private e0 f10949d;

    /* renamed from: e  reason: collision with root package name */
    private m0 f10950e;

    /* renamed from: f  reason: collision with root package name */
    private float f10951f;

    /* renamed from: g  reason: collision with root package name */
    private float f10952g;

    /* compiled from: PaintEraserAdjustLayout.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: PaintEraserAdjustLayout.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: PaintEraserAdjustLayout.kt */
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        final /* synthetic */ String[] a;

        c(String[] strArr) {
            this.a = strArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            s.h(outRect, "outRect");
            s.h(view, "view");
            s.h(parent, "parent");
            s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = n0.c(12);
            }
            if (childAdapterPosition == this.a.length - 1) {
                outRect.right = n0.c(12);
            }
        }
    }

    /* compiled from: PaintEraserAdjustLayout.kt */
    /* loaded from: classes4.dex */
    public static final class d implements m0 {
        d() {
        }

        @Override // us.pinguo.edit2020.adapter.m0
        public void a(View view, int i2, String color) {
            s.h(color, "color");
            if (view == null) {
                return;
            }
            PaintEraserAdjustLayout paintEraserAdjustLayout = PaintEraserAdjustLayout.this;
            ((RecyclerView) paintEraserAdjustLayout.a(R.id.rvGraffitiColors)).smoothScrollBy((int) (((view.getX() + (view.getWidth() / 2)) - (n0.i() / 2)) + view.getContext().getResources().getDimensionPixelSize(R.dimen.graffiti_color_padding)), 0);
            m0 b = paintEraserAdjustLayout.b();
            if (b == null) {
                return;
            }
            b.a(view, i2, color);
        }
    }

    public PaintEraserAdjustLayout(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public PaintEraserAdjustLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public PaintEraserAdjustLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    public PaintEraserAdjustLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new LinkedHashMap();
    }

    private final void c() {
        ((TextView) a(R.id.tvPaint)).performClick();
        e0 e0Var = new e0();
        this.f10949d = e0Var;
        if (e0Var == null) {
            return;
        }
        e0Var.l(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PaintEraserAdjustLayout this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        int i2 = R.id.tvPaint;
        ((TextView) this$0.a(i2)).setBackground(this$0.getResources().getDrawable(R.drawable.bg_tv_paint_or_eraser));
        ((TextView) this$0.a(i2)).setTextColor(this$0.getResources().getColor(R.color.color_camera_theme_black));
        int i3 = R.id.tvEraser;
        ((TextView) this$0.a(i3)).setBackground(null);
        ((TextView) this$0.a(i3)).setTextColor(this$0.getResources().getColor(R.color.color_camera_theme_dark));
        a aVar = this$0.b;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(PaintEraserAdjustLayout this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        int i2 = R.id.tvPaint;
        ((TextView) this$0.a(i2)).setBackground(null);
        ((TextView) this$0.a(i2)).setTextColor(this$0.getResources().getColor(R.color.color_camera_theme_dark));
        int i3 = R.id.tvEraser;
        ((TextView) this$0.a(i3)).setBackground(this$0.getResources().getDrawable(R.drawable.bg_tv_paint_or_eraser));
        ((TextView) this$0.a(i3)).setTextColor(this$0.getResources().getColor(R.color.color_camera_theme_black));
        a aVar = this$0.b;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(PaintEraserAdjustLayout this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        b bVar = this$0.c;
        if (bVar == null) {
            return;
        }
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(PaintEraserAdjustLayout this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        b bVar = this$0.c;
        if (bVar == null) {
            return;
        }
        bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(PaintEraserAdjustLayout this$0, Ref$IntRef index) {
        View view;
        s.h(this$0, "this$0");
        s.h(index, "$index");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) this$0.a(R.id.rvGraffitiColors)).findViewHolderForAdapterPosition(index.element);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    public static /* synthetic */ void setColors$default(PaintEraserAdjustLayout paintEraserAdjustLayout, String[] strArr, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            strArr = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        paintEraserAdjustLayout.setColors(strArr, str);
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

    public final m0 b() {
        return this.f10950e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f10951f = motionEvent.getX();
            this.f10952g = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2 && (Math.abs(motionEvent.getX() - this.f10951f) > 10.0f || Math.abs(motionEvent.getY() - this.f10952g) > 10.0f)) {
            getParent().requestDisallowInterceptTouchEvent(!(Math.abs(motionEvent.getX() - this.f10951f) < Math.abs(motionEvent.getY() - this.f10952g)));
            this.f10951f = motionEvent.getX();
            this.f10952g = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void m() {
        int i2 = R.id.tvPaint;
        ((TextView) a(i2)).setBackground(null);
        ((TextView) a(i2)).setTextColor(getResources().getColor(R.color.color_camera_theme_dark));
        int i3 = R.id.tvEraser;
        ((TextView) a(i3)).setBackground(getResources().getDrawable(R.drawable.bg_tv_paint_or_eraser));
        ((TextView) a(i3)).setTextColor(getResources().getColor(R.color.color_camera_theme_black));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((TextView) a(R.id.tvPaint)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout.i(PaintEraserAdjustLayout.this, view);
            }
        });
        ((TextView) a(R.id.tvEraser)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout.j(PaintEraserAdjustLayout.this, view);
            }
        });
        ((StickySeekBar) a(R.id.sbAdjust)).setValues(1, 100, 100, null);
        ((ImageView) a(R.id.ivUndo)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout.k(PaintEraserAdjustLayout.this, view);
            }
        });
        ((ImageView) a(R.id.ivRedo)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout.l(PaintEraserAdjustLayout.this, view);
            }
        });
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setColors(java.lang.String[] r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout.setColors(java.lang.String[], java.lang.String):void");
    }

    public final void setOnColorItemClickListener(m0 m0Var) {
        this.f10950e = m0Var;
    }

    public final void setOnPaintEraseClickListener(a aVar) {
        this.b = aVar;
    }

    public final void setOnUndoRedoClick(b bVar) {
        this.c = bVar;
    }

    public final void setTrackListener(us.pinguo.ui.widget.h hVar) {
        ((StickySeekBar) a(R.id.sbAdjust)).setTrackListener(hVar);
    }

    public /* synthetic */ PaintEraserAdjustLayout(Context context, AttributeSet attributeSet, int i2, int i3, int i4, o oVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
