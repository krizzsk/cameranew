package com.shizhefei.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.shizhefei.view.indicator.a;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
/* loaded from: classes3.dex */
public class RecyclerIndicatorView extends RecyclerView implements com.shizhefei.view.indicator.a {
    private a.b a;
    private b b;
    private LinearLayoutManager c;

    /* renamed from: d  reason: collision with root package name */
    private float f7136d;

    /* renamed from: e  reason: collision with root package name */
    private int f7137e;

    /* renamed from: f  reason: collision with root package name */
    private a.c f7138f;

    /* renamed from: g  reason: collision with root package name */
    private ScrollBar f7139g;

    /* renamed from: h  reason: collision with root package name */
    private a.d f7140h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f7141i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7142j;

    /* renamed from: k  reason: collision with root package name */
    private int f7143k;

    /* renamed from: l  reason: collision with root package name */
    private int f7144l;
    private int m;
    private int n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScrollBar.Gravity.values().length];
            a = iArr;
            try {
                iArr[ScrollBar.Gravity.CENTENT_BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScrollBar.Gravity.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScrollBar.Gravity.TOP_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM_FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private a.b a;
        private View.OnClickListener b = new View$OnClickListenerC0250b();

        /* loaded from: classes3.dex */
        class a extends RecyclerView.ViewHolder {
            a(b bVar, View view) {
                super(view);
            }
        }

        /* renamed from: com.shizhefei.view.indicator.RecyclerIndicatorView$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class View$OnClickListenerC0250b implements View.OnClickListener {
            View$OnClickListenerC0250b() {
            }

            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                if (RecyclerIndicatorView.this.f7142j) {
                    RecyclerIndicatorView.this.setCurrentItem(((Integer) view.getTag()).intValue(), true);
                }
            }
        }

        public b(a.b bVar) {
            this.a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            LinearLayout linearLayout = (LinearLayout) viewHolder.itemView;
            View childAt = linearLayout.getChildAt(0);
            linearLayout.removeAllViews();
            linearLayout.addView(this.a.b(i2, childAt, linearLayout));
            linearLayout.setTag(Integer.valueOf(i2));
            linearLayout.setOnClickListener(this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            return new a(this, linearLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            int layoutPosition = viewHolder.getLayoutPosition();
            View childAt = ((LinearLayout) viewHolder.itemView).getChildAt(0);
            childAt.setSelected(RecyclerIndicatorView.this.m == layoutPosition);
            if (RecyclerIndicatorView.this.f7140h != null) {
                if (RecyclerIndicatorView.this.m == layoutPosition) {
                    RecyclerIndicatorView.this.f7140h.onTransition(childAt, layoutPosition, 1.0f);
                } else {
                    RecyclerIndicatorView.this.f7140h.onTransition(childAt, layoutPosition, 0.0f);
                }
            }
        }
    }

    public RecyclerIndicatorView(Context context) {
        super(context);
        this.f7137e = -1;
        this.f7141i = new int[]{-1, -1};
        this.f7142j = true;
        init();
    }

    private void e(Canvas canvas) {
        int height;
        int g2;
        float measuredWidth;
        b bVar = this.b;
        if (bVar == null || this.f7139g == null || bVar.getItemCount() == 0) {
            return;
        }
        int i2 = a.a[this.f7139g.c().ordinal()];
        if (i2 != 1 && i2 != 2) {
            height = (i2 == 3 || i2 == 4) ? 0 : getHeight() - this.f7139g.b(getHeight());
        } else {
            height = (getHeight() - this.f7139g.b(getHeight())) / 2;
        }
        if (this.f7143k == 0) {
            View findViewByPosition = this.c.findViewByPosition(this.m);
            g2 = g(this.m, 0.0f, true);
            if (findViewByPosition == null) {
                return;
            }
            measuredWidth = findViewByPosition.getLeft();
        } else {
            View findViewByPosition2 = this.c.findViewByPosition(this.f7144l);
            g2 = g(this.f7144l, this.f7136d, true);
            if (findViewByPosition2 == null) {
                return;
            }
            measuredWidth = (findViewByPosition2.getMeasuredWidth() * this.f7136d) + findViewByPosition2.getLeft();
        }
        int width = this.f7139g.a().getWidth();
        int save = canvas.save();
        canvas.translate(measuredWidth + ((g2 - width) / 2), height);
        canvas.clipRect(0, 0, width, this.f7139g.a().getHeight());
        this.f7139g.a().draw(canvas);
        canvas.restoreToCount(save);
    }

    private int g(int i2, float f2, boolean z) {
        ScrollBar scrollBar = this.f7139g;
        if (scrollBar == null) {
            return 0;
        }
        View a2 = scrollBar.a();
        if (a2.isLayoutRequested() || z) {
            View findViewByPosition = this.c.findViewByPosition(i2);
            View findViewByPosition2 = this.c.findViewByPosition(i2 + 1);
            if (findViewByPosition != null) {
                int width = (int) ((findViewByPosition.getWidth() * (1.0f - f2)) + (findViewByPosition2 == null ? 0.0f : findViewByPosition2.getWidth() * f2));
                int d2 = this.f7139g.d(width);
                int b2 = this.f7139g.b(getHeight());
                a2.measure(d2, b2);
                a2.layout(0, 0, d2, b2);
                return width;
            }
        }
        return this.f7139g.a().getWidth();
    }

    private void i(int i2) {
        View f2 = f(this.n);
        if (f2 != null) {
            f2.setSelected(false);
        }
        View f3 = f(i2);
        if (f3 != null) {
            f3.setSelected(true);
        }
    }

    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.c = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
    }

    private void j(int i2) {
        if (this.f7140h == null) {
            return;
        }
        View f2 = f(this.n);
        if (f2 != null) {
            this.f7140h.onTransition(f2, this.n, 0.0f);
        }
        View f3 = f(i2);
        if (f3 != null) {
            this.f7140h.onTransition(f3, i2, 1.0f);
        }
    }

    @Override // com.shizhefei.view.indicator.a
    public int a() {
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        ScrollBar scrollBar = this.f7139g;
        if (scrollBar != null && scrollBar.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
            e(canvas);
        }
        super.dispatchDraw(canvas);
        ScrollBar scrollBar2 = this.f7139g;
        if (scrollBar2 == null || scrollBar2.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
            return;
        }
        e(canvas);
    }

    public View f(int i2) {
        LinearLayout linearLayout = (LinearLayout) this.c.findViewByPosition(i2);
        return linearLayout != null ? linearLayout.getChildAt(0) : linearLayout;
    }

    protected void h(int i2, float f2) {
        int i3;
        int[] iArr;
        View findViewByPosition = this.c.findViewByPosition(i2);
        int i4 = i2 + 1;
        View findViewByPosition2 = this.c.findViewByPosition(i4);
        if (findViewByPosition != null) {
            float measuredWidth = getMeasuredWidth() / 2.0f;
            float measuredWidth2 = measuredWidth - (findViewByPosition.getMeasuredWidth() / 2.0f);
            if (findViewByPosition2 != null) {
                measuredWidth2 -= ((findViewByPosition.getMeasuredWidth() - (measuredWidth - (findViewByPosition2.getMeasuredWidth() / 2.0f))) + measuredWidth2) * f2;
            }
            i3 = (int) measuredWidth2;
        } else {
            i3 = 0;
        }
        if (this.f7140h != null) {
            for (int i5 : this.f7141i) {
                View f3 = f(i5);
                if (i5 != i2 && i5 != i4 && f3 != null) {
                    this.f7140h.onTransition(f3, i5, 0.0f);
                }
            }
            View f4 = f(this.n);
            if (f4 != null) {
                this.f7140h.onTransition(f4, this.n, 0.0f);
            }
            this.c.scrollToPositionWithOffset(i2, i3);
            View f5 = f(i2);
            if (f5 != null) {
                this.f7140h.onTransition(f5, i2, 1.0f - f2);
                this.f7141i[0] = i2;
            }
            View f6 = f(i4);
            if (f6 != null) {
                this.f7140h.onTransition(f6, i4, f2);
                this.f7141i[1] = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = this.f7137e;
        if (i6 != -1) {
            this.c.findViewByPosition(i6);
            h(this.f7137e, 0.0f);
            this.f7137e = -1;
        }
    }

    @Override // com.shizhefei.view.indicator.a
    public void onPageScrollStateChanged(int i2) {
        this.f7143k = i2;
    }

    @Override // com.shizhefei.view.indicator.a
    public void onPageScrolled(int i2, float f2, int i3) {
        this.f7144l = i2;
        this.f7136d = f2;
        ScrollBar scrollBar = this.f7139g;
        if (scrollBar != null) {
            scrollBar.onPageScrolled(i2, f2, i3);
        }
        h(i2, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a.b bVar = this.a;
        if (bVar == null || bVar.a() <= 0) {
            return;
        }
        h(this.m, 0.0f);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setAdapter(a.b bVar) {
        this.a = bVar;
        b bVar2 = new b(bVar);
        this.b = bVar2;
        setAdapter(bVar2);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setItemClickable(boolean z) {
        this.f7142j = z;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setOnItemSelectListener(a.c cVar) {
        this.f7138f = cVar;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setOnTransitionListener(a.d dVar) {
        this.f7140h = dVar;
        i(this.m);
        j(this.m);
    }

    @Override // com.shizhefei.view.indicator.a
    public void setScrollBar(ScrollBar scrollBar) {
        this.f7139g = scrollBar;
    }

    @Override // com.shizhefei.view.indicator.a
    public void setCurrentItem(int i2, boolean z) {
        this.n = this.m;
        this.m = i2;
        if (this.f7143k == 0) {
            h(i2, 0.0f);
            i(i2);
            this.f7137e = i2;
        } else if (this.f7138f == null) {
            i(i2);
        }
        a.c cVar = this.f7138f;
        if (cVar != null) {
            cVar.a(f(i2), this.m, this.n);
        }
    }

    public RecyclerIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7137e = -1;
        this.f7141i = new int[]{-1, -1};
        this.f7142j = true;
        init();
    }

    public RecyclerIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7137e = -1;
        this.f7141i = new int[]{-1, -1};
        this.f7142j = true;
        init();
    }
}
