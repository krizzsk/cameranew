package us.pinguo.common.widget.banner2;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: ViewPager2Banner.kt */
/* loaded from: classes4.dex */
public final class ViewPager2Banner extends FrameLayout {
    private long a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private d<?> f10003d;

    /* renamed from: e  reason: collision with root package name */
    private final b f10004e;

    /* renamed from: f  reason: collision with root package name */
    private final a f10005f;

    /* renamed from: g  reason: collision with root package name */
    private final f f10006g;

    /* renamed from: h  reason: collision with root package name */
    private q<? super Integer, ? super Float, ? super Integer, u> f10007h;

    /* renamed from: i  reason: collision with root package name */
    private l<? super Integer, u> f10008i;

    /* compiled from: ViewPager2Banner.kt */
    /* loaded from: classes4.dex */
    public final class a extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ ViewPager2Banner a;

        public a(ViewPager2Banner this$0) {
            s.h(this$0, "this$0");
            this.a = this$0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.a.r();
        }
    }

    /* compiled from: ViewPager2Banner.kt */
    /* loaded from: classes4.dex */
    public final class b implements Runnable {
        final /* synthetic */ ViewPager2Banner a;

        public b(ViewPager2Banner this$0) {
            s.h(this$0, "this$0");
            this.a = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.b && this.a.o()) {
                ViewPager2Banner viewPager2Banner = this.a;
                ViewPager2Banner.setCurrentItem$default(viewPager2Banner, viewPager2Banner.j(), false, 2, null);
            }
            this.a.q();
        }
    }

    /* compiled from: ViewPager2Banner.kt */
    /* loaded from: classes4.dex */
    public final class c extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ ViewPager2Banner a;

        public c(ViewPager2Banner this$0) {
            s.h(this$0, "this$0");
            this.a = this$0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            if (f2 == 0.0f) {
                this.a.c = i2;
                if (this.a.m() > 1) {
                    if (this.a.c != this.a.m() - 1) {
                        if (this.a.c == 0) {
                            ViewPager2Banner viewPager2Banner = this.a;
                            viewPager2Banner.setCurrentItem(viewPager2Banner.m() - 2, false);
                        }
                    } else {
                        this.a.setCurrentItem(1, false);
                    }
                }
            }
            q<Integer, Float, Integer, u> k2 = this.a.k();
            if (k2 == null) {
                return;
            }
            k2.invoke(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            this.a.c = i2;
            l<Integer, u> l2 = this.a.l();
            if (l2 == null) {
                return;
            }
            l2.invoke(Integer.valueOf(i2));
        }
    }

    /* compiled from: ViewPager2Banner.kt */
    /* loaded from: classes4.dex */
    public final class d<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
        private final RecyclerView.Adapter<VH> a;
        final /* synthetic */ ViewPager2Banner b;

        public d(ViewPager2Banner this$0, RecyclerView.Adapter<VH> adapter) {
            s.h(this$0, "this$0");
            s.h(adapter, "adapter");
            this.b = this$0;
            this.a = adapter;
            adapter.registerAdapterDataObserver(this$0.f10005f);
        }

        private final int e(int i2) {
            if (this.a.getItemCount() > 1) {
                if (i2 <= 0 || i2 >= getItemCount() - 1) {
                    if (i2 == 0) {
                        return this.a.getItemCount() - 1;
                    }
                    if (i2 == getItemCount() - 1) {
                        return 0;
                    }
                    return i2;
                }
                return i2 - 1;
            }
            return i2;
        }

        public final RecyclerView.Adapter<VH> f() {
            return this.a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.a.getItemCount() > 1) {
                return this.a.getItemCount() + 2;
            }
            return this.a.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return this.a.getItemViewType(e(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH holder, int i2) {
            s.h(holder, "holder");
            this.a.onBindViewHolder(holder, e(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup parent, int i2) {
            s.h(parent, "parent");
            VH onCreateViewHolder = this.a.onCreateViewHolder(parent, i2);
            s.g(onCreateViewHolder, "adapter.onCreateViewHolder(parent, viewType)");
            return onCreateViewHolder;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Banner(Context context) {
        this(context, null, 0, 0, 14, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPager2Banner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
        s.h(context, "context");
    }

    public /* synthetic */ ViewPager2Banner(Context context, AttributeSet attributeSet, int i2, int i3, int i4, o oVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    private final ViewPager2 i() {
        return (ViewPager2) this.f10006g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        d<?> dVar = this.f10003d;
        if (dVar == null) {
            return 0;
        }
        return dVar.getItemCount();
    }

    private final void n(ViewPager2 viewPager2) {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            if (obj != null) {
                Context context = viewPager2.getContext();
                s.g(context, "viewPager.context");
                ViewPager2BannerLayoutManager viewPager2BannerLayoutManager = new ViewPager2BannerLayoutManager(context, (LinearLayoutManager) obj, viewPager2);
                viewPager2BannerLayoutManager.setOrientation(0);
                declaredField.set(viewPager2, viewPager2BannerLayoutManager);
                Field declaredField2 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(viewPager2);
                Field declaredField3 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField3.setAccessible(true);
                declaredField3.set(obj2, viewPager2BannerLayoutManager);
                Field declaredField4 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
                declaredField4.setAccessible(true);
                Object obj3 = declaredField4.get(viewPager2);
                Field declaredField5 = obj3.getClass().getDeclaredField("mLayoutManager");
                declaredField5.setAccessible(true);
                declaredField5.set(obj3, viewPager2BannerLayoutManager);
                Field declaredField6 = ViewPager2.class.getDeclaredField("mRecyclerView");
                declaredField6.setAccessible(true);
                Object obj4 = declaredField6.get(viewPager2);
                if (obj4 != null) {
                    ((RecyclerView) obj4).setLayoutManager(viewPager2BannerLayoutManager);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        if (i().isShown()) {
            Object systemService = getContext().getSystemService("power");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            if (((PowerManager) systemService).isInteractive()) {
                Rect rect = new Rect();
                boolean localVisibleRect = i().getLocalVisibleRect(rect);
                if (((rect.width() * rect.height()) * 1.0f) / (getWidth() * getHeight()) < 0.5f) {
                    return false;
                }
                return localVisibleRect;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        removeCallbacks(this.f10004e);
        postDelayed(this.f10004e, this.a);
    }

    public static /* synthetic */ void setCurrentItem$default(ViewPager2Banner viewPager2Banner, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        viewPager2Banner.setCurrentItem(i2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ViewPager2Banner this$0) {
        s.h(this$0, "this$0");
        this$0.setCurrentItem(1, false);
        this$0.u();
    }

    private final void u() {
        this.b = true;
        q();
    }

    private final void v() {
        this.b = false;
        removeCallbacks(this.f10004e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getActionMasked());
        if (valueOf != null && valueOf.intValue() == 0) {
            v();
        } else if ((valueOf != null && valueOf.intValue() == 1) || ((valueOf != null && valueOf.intValue() == 3) || (valueOf != null && valueOf.intValue() == 4))) {
            u();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void h(RecyclerView.ItemDecoration decor) {
        s.h(decor, "decor");
        i().addItemDecoration(decor);
    }

    public final int j() {
        return this.c + 1;
    }

    public final q<Integer, Float, Integer, u> k() {
        return this.f10007h;
    }

    public final l<Integer, u> l() {
        return this.f10008i;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.c = savedState.a();
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentItem(this.c, false);
            u();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c(this.c);
        return savedState;
    }

    public final void r() {
        d<?> dVar = this.f10003d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        s();
    }

    public final void s() {
        post(new Runnable() { // from class: us.pinguo.common.widget.banner2.b
            @Override // java.lang.Runnable
            public final void run() {
                ViewPager2Banner.t(ViewPager2Banner.this);
            }
        });
    }

    public final void setAdapter(RecyclerView.Adapter<?> adapter) {
        RecyclerView.Adapter<?> f2;
        s.h(adapter, "adapter");
        d<?> dVar = this.f10003d;
        if (dVar != null && (f2 = dVar.f()) != null) {
            f2.unregisterAdapterDataObserver(this.f10005f);
        }
        this.f10003d = new d<>(this, adapter);
        i().setAdapter(this.f10003d);
        s();
    }

    public final void setCurrentItem(int i2, boolean z) {
        i().setCurrentItem(i2, z);
    }

    public final void setInterval(long j2) {
        this.a = j2;
    }

    public final void setOnPageScrolled(q<? super Integer, ? super Float, ? super Integer, u> qVar) {
        this.f10007h = qVar;
    }

    public final void setOnPageSelected(l<? super Integer, u> lVar) {
        this.f10008i = lVar;
    }

    public final void setOrientation(int i2) {
        i().setOrientation(i2);
    }

    public final void setPageTransformer(ViewPager2.PageTransformer transformer) {
        s.h(transformer, "transformer");
        i().setPageTransformer(transformer);
    }

    /* compiled from: ViewPager2Banner.kt */
    /* loaded from: classes4.dex */
    public static final class SavedState extends View.BaseSavedState {
        public static final a CREATOR = new a(null);
        private int mCurrentItem;

        /* compiled from: ViewPager2Banner.kt */
        /* loaded from: classes4.dex */
        public static final class a implements Parcelable.Creator<SavedState> {
            private a() {
            }

            public /* synthetic */ a(o oVar) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                s.h(parcel, "parcel");
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source) {
            super(source);
            s.h(source, "source");
            b(source);
        }

        private final void b(Parcel parcel) {
            this.mCurrentItem = parcel.readInt();
        }

        public final int a() {
            return this.mCurrentItem;
        }

        public final void c(int i2) {
            this.mCurrentItem = i2;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            s.h(out, "out");
            super.writeToParcel(out, i2);
            out.writeInt(this.mCurrentItem);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Banner(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        f b2;
        s.h(context, "context");
        new LinkedHashMap();
        this.a = 3000L;
        this.b = true;
        this.c = -1;
        this.f10004e = new b(this);
        this.f10005f = new a(this);
        b2 = h.b(new ViewPager2Banner$mViewPager2$2(context));
        this.f10006g = b2;
        i().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        i().setOffscreenPageLimit(1);
        i().registerOnPageChangeCallback(new c(this));
        n(i());
        addView(i());
    }
}
