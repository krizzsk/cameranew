package us.pinguo.edit2020.widget.adjust;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.e0;
import us.pinguo.edit2020.adapter.m0;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
import us.pinguo.widget.common.guide.GuideHandler;
/* compiled from: PaintEraserAdjustLayout2.kt */
/* loaded from: classes4.dex */
public final class PaintEraserAdjustLayout2 extends LinearLayout {
    public Map<Integer, View> a;
    private a b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private c f10953d;

    /* renamed from: e  reason: collision with root package name */
    private e0 f10954e;

    /* renamed from: f  reason: collision with root package name */
    private m0 f10955f;

    /* renamed from: g  reason: collision with root package name */
    private String f10956g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10957h;

    /* renamed from: i  reason: collision with root package name */
    private int f10958i;

    /* renamed from: j  reason: collision with root package name */
    private int f10959j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10960k;

    /* renamed from: l  reason: collision with root package name */
    private float f10961l;
    private float m;

    /* compiled from: PaintEraserAdjustLayout2.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: PaintEraserAdjustLayout2.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: PaintEraserAdjustLayout2.kt */
    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, String str);

        void b(int i2, String str);
    }

    /* compiled from: PaintEraserAdjustLayout2.kt */
    /* loaded from: classes4.dex */
    public static final class d implements us.pinguo.ui.widget.h {
        d() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            c j2 = PaintEraserAdjustLayout2.this.j();
            if (j2 == null) {
                return;
            }
            j2.b(i2, PaintEraserAdjustLayout2.this.f10956g);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            c j2 = PaintEraserAdjustLayout2.this.j();
            if (j2 == null) {
                return;
            }
            j2.a(i2, PaintEraserAdjustLayout2.this.f10956g);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: PaintEraserAdjustLayout2.kt */
    /* loaded from: classes4.dex */
    public static final class e extends RecyclerView.ItemDecoration {
        final /* synthetic */ String[] a;

        e(String[] strArr) {
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

    /* compiled from: PaintEraserAdjustLayout2.kt */
    /* loaded from: classes4.dex */
    public static final class f implements m0 {
        f() {
        }

        @Override // us.pinguo.edit2020.adapter.m0
        public void a(View view, int i2, String color) {
            s.h(color, "color");
            if (view == null) {
                return;
            }
            PaintEraserAdjustLayout2 paintEraserAdjustLayout2 = PaintEraserAdjustLayout2.this;
            ((RecyclerView) paintEraserAdjustLayout2.a(R.id.rvGraffitiColors)).smoothScrollBy((int) (((view.getX() + (view.getWidth() / 2)) - (n0.i() / 2)) + view.getContext().getResources().getDimensionPixelSize(R.dimen.graffiti_color_padding)), 0);
            m0 h2 = paintEraserAdjustLayout2.h();
            if (h2 == null) {
                return;
            }
            h2.a(view, i2, color);
        }
    }

    public PaintEraserAdjustLayout2(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    public PaintEraserAdjustLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public PaintEraserAdjustLayout2(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    public PaintEraserAdjustLayout2(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new LinkedHashMap();
        this.f10956g = BigAlbumStore.PhotoColumns.SIZE;
        this.f10958i = 50;
        this.f10959j = 100;
    }

    private final void k() {
        ArrayList<String> f2;
        int i2 = R.id.textSelectView;
        String string = us.pinguo.foundation.e.b().getString(R.string.daxiao);
        s.g(string, "getAppContext().getString(R.string.daxiao)");
        String string2 = us.pinguo.foundation.e.b().getString(R.string.str_sticker_opacity);
        s.g(string2, "getAppContext().getStrin…ring.str_sticker_opacity)");
        f2 = u.f(string, string2);
        ((AdjustTextSelectView) a(i2)).setTextList(f2);
        ((AdjustTextSelectView) a(i2)).setTextChangeListener(new PaintEraserAdjustLayout2$initView$1(this));
        ((AdjustTextSelectView) a(i2)).setPredict(new PaintEraserAdjustLayout2$initView$2(this));
        ((StickySeekBar) a(R.id.sbAdjust)).setTrackListener(new d());
        ((ImageView) a(R.id.ivPaint)).performClick();
        e0 e0Var = new e0();
        this.f10954e = e0Var;
        if (e0Var == null) {
            return;
        }
        e0Var.l(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(PaintEraserAdjustLayout2 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.f10957h = false;
        int i2 = R.id.ivPaint;
        ((ImageView) this$0.a(i2)).setImageResource(R.drawable.ic_edit_paint_enable);
        ((ImageView) this$0.a(i2)).setBackground(us.pinguo.edit2020.utils.d.j(R.drawable.bg_tv_paint_or_eraser));
        int i3 = R.id.ivEraser;
        ((ImageView) this$0.a(i3)).setImageResource(R.drawable.ic_edit_brush_unable);
        ((ImageView) this$0.a(i3)).setBackground(null);
        this$0.z(true);
        a aVar = this$0.b;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(PaintEraserAdjustLayout2 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.f10957h = true;
        int i2 = R.id.ivPaint;
        ((ImageView) this$0.a(i2)).setImageResource(R.drawable.ic_edit_paint_unable);
        ((ImageView) this$0.a(i2)).setBackground(null);
        int i3 = R.id.ivEraser;
        ((ImageView) this$0.a(i3)).setImageResource(R.drawable.ic_edit_brush_enable);
        ((ImageView) this$0.a(i3)).setBackground(us.pinguo.edit2020.utils.d.j(R.drawable.bg_tv_paint_or_eraser));
        this$0.e();
        this$0.z(false);
        a aVar = this$0.b;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public static /* synthetic */ void setColors$default(PaintEraserAdjustLayout2 paintEraserAdjustLayout2, String[] strArr, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            strArr = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        paintEraserAdjustLayout2.setColors(strArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(PaintEraserAdjustLayout2 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        b bVar = this$0.c;
        if (bVar == null) {
            return;
        }
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(PaintEraserAdjustLayout2 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        b bVar = this$0.c;
        if (bVar == null) {
            return;
        }
        bVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(PaintEraserAdjustLayout2 this$0, Ref$IntRef index) {
        View view;
        s.h(this$0, "this$0");
        s.h(index, "$index");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) this$0.a(R.id.rvGraffitiColors)).findViewHolderForAdapterPosition(index.element);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    private final void w(int i2) {
        ((StickySeekBar) a(R.id.sbAdjust)).setProgress(i2);
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f10961l = motionEvent.getX();
            this.m = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2 && (Math.abs(motionEvent.getX() - this.f10961l) > 10.0f || Math.abs(motionEvent.getY() - this.m) > 10.0f)) {
            getParent().requestDisallowInterceptTouchEvent(!(Math.abs(motionEvent.getX() - this.f10961l) < Math.abs(motionEvent.getY() - this.m)));
            this.f10961l = motionEvent.getX();
            this.m = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        if (s.c(BigAlbumStore.PhotoColumns.SIZE, this.f10956g)) {
            return;
        }
        this.f10956g = BigAlbumStore.PhotoColumns.SIZE;
        int i2 = R.id.textSelectView;
        String str = ((AdjustTextSelectView) a(i2)).h().get(0);
        s.g(str, "textSelectView.textList[0]");
        ((AdjustTextSelectView) a(i2)).setSelectedText(str);
    }

    public final int f() {
        return this.f10959j;
    }

    public final String g() {
        e0 e0Var = this.f10954e;
        if (e0Var != null) {
            s.e(e0Var);
            if (e0Var.f() >= 0) {
                e0 e0Var2 = this.f10954e;
                s.e(e0Var2);
                int f2 = e0Var2.f();
                e0 e0Var3 = this.f10954e;
                s.e(e0Var3);
                String[] e2 = e0Var3.e();
                if (f2 < (e2 == null ? 0 : e2.length)) {
                    e0 e0Var4 = this.f10954e;
                    s.e(e0Var4);
                    String[] e3 = e0Var4.e();
                    if (e3 == null) {
                        return null;
                    }
                    e0 e0Var5 = this.f10954e;
                    s.e(e0Var5);
                    return e3[e0Var5.f()];
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public final m0 h() {
        return this.f10955f;
    }

    public final int i() {
        return this.f10958i;
    }

    public final c j() {
        return this.f10953d;
    }

    public final boolean l() {
        return this.f10960k;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((ImageView) a(R.id.ivPaint)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout2.r(PaintEraserAdjustLayout2.this, view);
            }
        });
        ((ImageView) a(R.id.ivEraser)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout2.s(PaintEraserAdjustLayout2.this, view);
            }
        });
        ((StickySeekBar) a(R.id.sbAdjust)).setValues(1, 100, 100, null);
        ((ImageView) a(R.id.ivUndo)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout2.t(PaintEraserAdjustLayout2.this, view);
            }
        });
        ((ImageView) a(R.id.ivRedo)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.widget.adjust.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaintEraserAdjustLayout2.u(PaintEraserAdjustLayout2.this, view);
            }
        });
        k();
    }

    public final void setAlphaProgress(int i2) {
        if (s.c("alpha", this.f10956g)) {
            w(i2);
        }
        this.f10959j = i2;
    }

    public final void setAlphaRestrict(boolean z) {
        this.f10960k = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setColors(java.lang.String[] r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2.setColors(java.lang.String[], java.lang.String):void");
    }

    public final void setOnColorItemClickListener(m0 m0Var) {
        this.f10955f = m0Var;
    }

    public final void setOnPaintEraseClickListener(a aVar) {
        this.b = aVar;
    }

    public final void setOnUndoRedoClick(b bVar) {
        this.c = bVar;
    }

    public final void setSizeProgress(int i2) {
        if (s.c(BigAlbumStore.PhotoColumns.SIZE, this.f10956g)) {
            w(i2);
        }
        this.f10958i = i2;
    }

    public final void setTrackSwitchListener(c cVar) {
        this.f10953d = cVar;
    }

    public final void x(String key) {
        s.h(key, "key");
        if (s.c("alpha", this.f10956g)) {
            return;
        }
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        GuideHandler k2 = GuideHandler.k((Activity) context);
        k2.H(key, 1);
        k2.B(GuideHandler.Gravity.RIGHT);
        k2.G(GuideHandler.VGravity.UP);
        k2.w(false);
        k2.A(R.drawable.guide_toast_right);
        k2.z(36, 0);
        k2.F(us.pinguo.foundation.e.b().getString(R.string.guide_transparency));
        k2.x(((AdjustTextSelectView) a(R.id.textSelectView)).i());
    }

    public final void y() {
        w(this.f10958i);
    }

    public final void z(boolean z) {
        ((AdjustTextSelectView) a(R.id.textSelectView)).k(z);
    }

    public /* synthetic */ PaintEraserAdjustLayout2(Context context, AttributeSet attributeSet, int i2, int i3, int i4, o oVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
