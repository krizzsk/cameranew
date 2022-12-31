package us.pinguo.inspire.widget.JellyViewPager;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes9.dex */
public class VoteViewPager extends ViewPager {
    private static float E = 500.0f;
    private static float F = 0.0f;
    private static float G = 15.0f;
    private float A;
    private float B;
    private boolean C;
    private boolean D;
    private float a;
    private VelocityTracker b;
    private PagerAdapter c;

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.rebound.d f11323d;

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.rebound.d f11324e;

    /* renamed from: f  reason: collision with root package name */
    private com.facebook.rebound.d f11325f;

    /* renamed from: g  reason: collision with root package name */
    private final com.facebook.rebound.a f11326g;

    /* renamed from: h  reason: collision with root package name */
    private final b f11327h;

    /* renamed from: i  reason: collision with root package name */
    private View f11328i;

    /* renamed from: j  reason: collision with root package name */
    private View f11329j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f11330k;

    /* renamed from: l  reason: collision with root package name */
    private int f11331l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private ViewPager.OnPageChangeListener q;
    private d r;
    private SparseArray<Object> s;
    private com.facebook.rebound.e t;
    private com.facebook.rebound.e u;
    private com.facebook.rebound.e v;
    private com.facebook.rebound.e w;
    private boolean x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends com.facebook.rebound.c {
        private b() {
        }

        @Override // com.facebook.rebound.f
        public void a(com.facebook.rebound.d dVar) {
            VoteViewPager.this.v();
            if (VoteViewPager.this.f11328i == null) {
                return;
            }
            float c = (float) dVar.c();
            String e2 = dVar.e();
            if (e2.equals(VoteViewPager.this.f11324e.e())) {
                VoteViewPager.this.f11328i.setTranslationX(c);
                VoteViewPager voteViewPager = VoteViewPager.this;
                voteViewPager.E(c, voteViewPager.p);
                VoteViewPager voteViewPager2 = VoteViewPager.this;
                voteViewPager2.f11329j = voteViewPager2.z();
                if (VoteViewPager.this.f11329j != null && !VoteViewPager.this.m) {
                    float abs = ((Math.abs(c) / VoteViewPager.this.p) * 0.5f) + 0.5f;
                    VoteViewPager.this.f11329j.setScaleX(abs);
                    VoteViewPager.this.f11329j.setScaleY(abs);
                    VoteViewPager.this.f11329j.setTranslationX(-VoteViewPager.this.o);
                }
                if (dVar.g()) {
                    if (c >= VoteViewPager.this.p) {
                        VoteViewPager.this.D();
                        if (VoteViewPager.this.f11329j != null) {
                            VoteViewPager.this.f11329j.setTranslationX(0.0f);
                        }
                        if (VoteViewPager.this.r != null) {
                            VoteViewPager.this.r.a(VoteViewPager.this.f11331l);
                        }
                    } else if (c <= (-VoteViewPager.this.p)) {
                        VoteViewPager.this.D();
                        if (VoteViewPager.this.f11329j != null) {
                            VoteViewPager.this.f11329j.setTranslationX(0.0f);
                        }
                        if (VoteViewPager.this.r != null) {
                            VoteViewPager.this.r.d(VoteViewPager.this.f11331l);
                        }
                    }
                }
            } else if (e2.equals(VoteViewPager.this.f11323d.e())) {
                if (!VoteViewPager.this.m || VoteViewPager.this.f11329j == null) {
                    return;
                }
                VoteViewPager.this.f11329j.setScaleX(c);
                VoteViewPager.this.f11329j.setScaleY(c);
            } else if (e2.equals(VoteViewPager.this.f11325f.e())) {
                VoteViewPager.this.f11328i.setRotation(c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c implements ViewPager.OnPageChangeListener {
        private c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (VoteViewPager.this.q != null) {
                VoteViewPager.this.q.onPageSelected(i2);
            }
            if (VoteViewPager.this.f11328i != null) {
                VoteViewPager.this.f11328i.setTranslationX(0.0f);
                VoteViewPager.this.f11328i.setRotation(0.0f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(int i2);

        void b();

        void c(float f2, float f3);

        void d(int i2);

        void e();
    }

    /* loaded from: classes9.dex */
    private class e extends PagerAdapter {
        private e() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            VoteViewPager.this.s.remove(i2);
            VoteViewPager.this.c.destroyItem(viewGroup, i2, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            VoteViewPager.this.c.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return VoteViewPager.this.c.getCount();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            Object instantiateItem = VoteViewPager.this.c.instantiateItem(viewGroup, i2);
            VoteViewPager.this.setObjectForPosition(instantiateItem, i2);
            VoteViewPager.this.G((View) instantiateItem, i2);
            return instantiateItem;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return VoteViewPager.this.c.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            VoteViewPager.this.f11331l = -1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            VoteViewPager.this.c.setPrimaryItem(viewGroup, i2, obj);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
    }

    public VoteViewPager(Context context) {
        super(context);
        this.f11326g = us.pinguo.inspire.widget.JellyViewPager.b.g();
        this.f11327h = new b();
        this.f11330k = new Rect();
        this.f11331l = -1;
        this.m = false;
        this.s = new SparseArray<>();
        this.t = new com.facebook.rebound.e(360.0d, 14.0d);
        this.u = new com.facebook.rebound.e(76.0d, 6.5d);
        com.facebook.rebound.e eVar = com.facebook.rebound.e.c;
        this.v = eVar;
        this.w = eVar;
        C(context);
    }

    private void C(Context context) {
        super.setOnPageChangeListener(new c());
        setChildrenDrawingOrderEnabled(true);
        this.f11323d = this.f11326g.c();
        this.f11324e = this.f11326g.c();
        this.f11325f = this.f11326g.c();
        this.f11323d.n(new com.facebook.rebound.e(160.0d, 11.0d));
        this.f11325f.n(this.w);
        this.f11324e.n(this.v);
        this.f11323d.a(this.f11327h);
        this.f11324e.a(this.f11327h);
        this.f11325f.a(this.f11327h);
        this.a = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        super.setCurrentItem(this.f11331l + 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(float f2, float f3) {
        d dVar = this.r;
        if (dVar != null) {
            dVar.c(f2, f3);
        }
    }

    private void F() {
        this.f11324e.n(this.v);
        this.f11325f.n(this.w);
        if (this.f11324e.g()) {
            this.f11324e.i();
            this.f11324e.k(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f11324e.l(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f11324e.a(this.f11327h);
        }
        if (this.f11325f.g()) {
            this.f11325f.i();
            this.f11325f.k(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f11325f.l(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.f11325f.a(this.f11327h);
        }
        this.f11323d.i();
        this.f11323d.k(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.f11323d.l(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.f11323d.a(this.f11327h);
        if (z() != null) {
            this.f11329j.setScaleX(1.0f);
            this.f11329j.setScaleY(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(View view, int i2) {
        if (view == null) {
            return;
        }
        if (i2 == getCurrentItem()) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else {
            view.setScaleX(0.5f);
            view.setScaleY(0.5f);
        }
        view.setRotation(0.0f);
    }

    private void H() {
        d dVar = this.r;
        if (dVar != null) {
            dVar.e();
        }
    }

    private void I() {
        d dVar = this.r;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u(float r9, float r10) {
        /*
            r8 = this;
            com.facebook.rebound.d r0 = r8.f11325f
            com.facebook.rebound.e r1 = r8.u
            r0.n(r1)
            com.facebook.rebound.d r0 = r8.f11324e
            r1 = 1
            r0.m(r1)
            float r0 = us.pinguo.inspire.widget.JellyViewPager.VoteViewPager.E
            float r2 = -r0
            r3 = 0
            r4 = 0
            r6 = 0
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 < 0) goto L58
            float r2 = us.pinguo.inspire.widget.JellyViewPager.VoteViewPager.F
            float r7 = -r2
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 >= 0) goto L20
            goto L58
        L20:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L39
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 <= 0) goto L29
            goto L39
        L29:
            com.facebook.rebound.d r9 = r8.f11324e
            r9.m(r6)
            com.facebook.rebound.d r9 = r8.f11325f
            r9.m(r6)
            com.facebook.rebound.d r9 = r8.f11325f
            r9.l(r4)
            goto L77
        L39:
            boolean r9 = r8.B()
            if (r9 == 0) goto L4d
            int r9 = r8.p
            float r9 = (float) r9
            com.facebook.rebound.d r10 = r8.f11325f
            r10.m(r1)
            com.facebook.rebound.d r10 = r8.f11325f
            r10.j()
            goto L78
        L4d:
            com.facebook.rebound.d r9 = r8.f11325f
            r9.m(r6)
            com.facebook.rebound.d r9 = r8.f11325f
            r9.l(r4)
            goto L77
        L58:
            boolean r9 = r8.A()
            if (r9 == 0) goto L6d
            int r9 = r8.p
            int r9 = -r9
            float r9 = (float) r9
            com.facebook.rebound.d r10 = r8.f11325f
            r10.m(r1)
            com.facebook.rebound.d r10 = r8.f11325f
            r10.j()
            goto L78
        L6d:
            com.facebook.rebound.d r9 = r8.f11325f
            r9.m(r6)
            com.facebook.rebound.d r9 = r8.f11325f
            r9.l(r4)
        L77:
            r9 = 0
        L78:
            int r10 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r10 != 0) goto L84
            com.facebook.rebound.d r0 = r8.f11324e
            r0.m(r6)
            r8.m = r6
            goto L9d
        L84:
            android.view.View r0 = r8.z()
            r8.f11329j = r0
            if (r0 == 0) goto L9d
            com.facebook.rebound.d r1 = r8.f11323d
            float r0 = r0.getScaleX()
            double r2 = (double) r0
            r1.k(r2)
            com.facebook.rebound.d r0 = r8.f11323d
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r0.l(r1)
        L9d:
            if (r10 != 0) goto La7
            com.facebook.rebound.d r10 = r8.f11324e
            com.facebook.rebound.e r0 = r8.t
            r10.n(r0)
            goto Lae
        La7:
            com.facebook.rebound.d r10 = r8.f11324e
            com.facebook.rebound.e r0 = r8.v
            r10.n(r0)
        Lae:
            com.facebook.rebound.d r10 = r8.f11324e
            double r0 = (double) r9
            r10.l(r0)
            int r10 = r8.p
            float r0 = (float) r10
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 != 0) goto Lbf
            r8.H()
            goto Lc8
        Lbf:
            int r10 = -r10
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 != 0) goto Lc8
            r8.I()
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.widget.JellyViewPager.VoteViewPager.u(float, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f11331l != getCurrentItem()) {
            this.f11331l = getCurrentItem();
            this.f11328i = y();
        }
    }

    private void w() {
        View y = y();
        if (y != null) {
            this.f11330k.set(y.getLeft(), y.getTop(), y.getRight(), y.getBottom());
            this.f11330k.offset((int) y.getTranslationX(), (int) y.getTranslationY());
        }
        this.f11330k.offset(-getScrollX(), -getScrollY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View z() {
        View x = x(this.f11331l + 1);
        View view = this.f11329j;
        if (x != view && view != null) {
            view.setScaleX(1.0f);
            this.f11329j.setScaleY(1.0f);
            this.f11329j.setTranslationX(0.0f);
        }
        this.f11329j = x;
        return x;
    }

    public boolean A() {
        return true;
    }

    public boolean B() {
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (getChildAt(i3) == y()) {
            return i2 - 1;
        }
        if (getChildAt(i3) == x(getCurrentItem() + 1)) {
            return i2 - 2;
        }
        return 0;
    }

    @Override // android.view.View
    public boolean isPressed() {
        return this.x;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
        }
        this.b.addMovement(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    return Math.abs(x - this.z) > this.a;
                } else if (action != 3) {
                    return false;
                }
            }
            VelocityTracker velocityTracker = this.b;
            velocityTracker.computeCurrentVelocity(1000);
            float xVelocity = velocityTracker.getXVelocity();
            VelocityTracker velocityTracker2 = this.b;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.b = null;
            }
            return xVelocity > E;
        }
        this.y = motionEvent.getY();
        this.z = motionEvent.getX();
        F();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f11328i == null) {
            View y = y();
            this.f11328i = y;
            if (y != null) {
                y.setScaleX(1.0f);
                this.f11328i.setScaleY(1.0f);
                w();
            }
        }
        this.n = getHeight();
        int width = getWidth();
        this.o = width;
        this.p = (int) (width * 1.3f);
        F = (width * 1.0f) / 3.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r2 != 3) goto L11;
     */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.widget.JellyViewPager.VoteViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.c = pagerAdapter;
        super.setAdapter(new e());
    }

    @Override // androidx.viewpager.widget.ViewPager
    @Deprecated
    public void setCurrentItem(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager
    @Deprecated
    public void setCurrentItem(int i2, boolean z) {
    }

    public void setObjectForPosition(Object obj, int i2) {
        this.s.put(Integer.valueOf(i2).intValue(), obj);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.q = onPageChangeListener;
    }

    public void setVoteListener(d dVar) {
        this.r = dVar;
    }

    public View x(int i2) {
        Object obj = this.s.get(Integer.valueOf(i2).intValue());
        if (obj == null) {
            return null;
        }
        if (obj instanceof View) {
            return (View) obj;
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getView();
        }
        return null;
    }

    public View y() {
        return x(getCurrentItem());
    }

    public VoteViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11326g = us.pinguo.inspire.widget.JellyViewPager.b.g();
        this.f11327h = new b();
        this.f11330k = new Rect();
        this.f11331l = -1;
        this.m = false;
        this.s = new SparseArray<>();
        this.t = new com.facebook.rebound.e(360.0d, 14.0d);
        this.u = new com.facebook.rebound.e(76.0d, 6.5d);
        com.facebook.rebound.e eVar = com.facebook.rebound.e.c;
        this.v = eVar;
        this.w = eVar;
        C(context);
    }
}
