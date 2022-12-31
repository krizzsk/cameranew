package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.widget.g;
import us.pinguo.edit2020.adapter.o0;
import us.pinguo.edit2020.bean.m0;
import us.pinguo.edit2020.widget.CenterLayoutManager;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: BeautySkinColorView.kt */
/* loaded from: classes4.dex */
public final class BeautySkinColorView extends FrameLayout {
    private final int a;
    private o0 b;
    private RecyclerView c;

    /* renamed from: d  reason: collision with root package name */
    private CenterLayoutManager f10790d;

    /* renamed from: e  reason: collision with root package name */
    private int f10791e;

    /* renamed from: f  reason: collision with root package name */
    private l<? super m0, u> f10792f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeautySkinColorView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeautySkinColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ BeautySkinColorView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void e(Context context) {
        RecyclerView recyclerView = new RecyclerView(context);
        this.c = recyclerView;
        if (recyclerView != null) {
            addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
            setBackgroundColor(-1);
            return;
        }
        s.z("recyclerView");
        throw null;
    }

    private final void g() {
        ArrayList<m0> f2;
        o0 o0Var = this.b;
        if (o0Var == null || (f2 = o0Var.f()) == null) {
            return;
        }
        for (m0 m0Var : f2) {
            m0Var.i(false);
        }
    }

    private final void h(int i2) {
        ArrayList<m0> f2;
        o0 o0Var = this.b;
        if (o0Var == null || (f2 = o0Var.f()) == null) {
            return;
        }
        int i3 = 0;
        for (Object obj : f2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.s.n();
                throw null;
            }
            m0 m0Var = (m0) obj;
            if (i2 != i3) {
                m0Var.g().setCurrentValue(50);
            }
            i3 = i4;
        }
    }

    private final void j(m0 m0Var, int i2) {
        m0Var.i(true);
        m0Var.g().setCurrentValue(i2);
    }

    public final int b() {
        return this.f10791e;
    }

    public final l<m0, u> c() {
        return this.f10792f;
    }

    public final Pair<m0, Integer> d() {
        o0 o0Var = this.b;
        if (o0Var == null) {
            return null;
        }
        return o0Var.j();
    }

    public final void f(ArrayList<m0> dataList) {
        s.h(dataList, "dataList");
        ArrayList<m0> arrayList = new ArrayList<>();
        arrayList.add(new m0(us.pinguo.repository2020.l.n.a(), false, 2, null));
        arrayList.addAll(dataList);
        o0 o0Var = this.b;
        if (o0Var == null) {
            Context context = getContext();
            s.g(context, "context");
            CenterLayoutManager centerLayoutManager = new CenterLayoutManager(context, 0, false);
            this.f10790d = centerLayoutManager;
            RecyclerView recyclerView = this.c;
            if (recyclerView == null) {
                s.z("recyclerView");
                throw null;
            } else if (centerLayoutManager != null) {
                recyclerView.setLayoutManager(centerLayoutManager);
                RecyclerView recyclerView2 = this.c;
                if (recyclerView2 != null) {
                    RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
                    SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
                    if (simpleItemAnimator != null) {
                        simpleItemAnimator.setSupportsChangeAnimations(false);
                    }
                    o0 o0Var2 = new o0();
                    o0Var2.n(new BeautySkinColorView$refreshData$1$1(this, o0Var2));
                    o0Var2.m(arrayList, Integer.valueOf(this.a));
                    RecyclerView recyclerView3 = this.c;
                    if (recyclerView3 != null) {
                        recyclerView3.setAdapter(o0Var2);
                        g gVar = new g();
                        Context context2 = getContext();
                        s.g(context2, "context");
                        int itemCount = o0Var2.getItemCount();
                        CenterLayoutManager centerLayoutManager2 = this.f10790d;
                        if (centerLayoutManager2 != null) {
                            Context context3 = getContext();
                            s.g(context3, "context");
                            gVar.a(context2, itemCount, centerLayoutManager2.a(context3, o0Var2.getItemCount()));
                            RecyclerView recyclerView4 = this.c;
                            if (recyclerView4 != null) {
                                recyclerView4.addItemDecoration(gVar);
                                this.b = o0Var2;
                                return;
                            }
                            s.z("recyclerView");
                            throw null;
                        }
                        s.z("layoutManager");
                        throw null;
                    }
                    s.z("recyclerView");
                    throw null;
                }
                s.z("recyclerView");
                throw null;
            } else {
                s.z("layoutManager");
                throw null;
            }
        }
        o0Var.m(arrayList, Integer.valueOf(this.a));
    }

    public final void i() {
        ArrayList<m0> f2;
        o0 o0Var = this.b;
        if (o0Var == null || (f2 = o0Var.f()) == null) {
            return;
        }
        int i2 = 0;
        for (Object obj : f2) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                m0 m0Var = (m0) obj;
                boolean z = true;
                if (i2 != 1) {
                    z = false;
                }
                m0Var.i(z);
                m0Var.g().setCurrentValue(50);
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    public final void k(m0 m0Var) {
        o0 o0Var = this.b;
        if (o0Var == null) {
            return;
        }
        int i2 = 1;
        if (m0Var != null) {
            o0Var.f().get(0).i(false);
            if (s.c(PortalFollowFeeds.TYPE_NONE, m0Var.f())) {
                m0 m0Var2 = o0Var.f().get(1);
                s.g(m0Var2, "it.dataList[1]");
                j(m0Var2, 50);
            } else {
                g();
                i2 = o0Var.h(m0Var);
                if (-1 != b()) {
                    m0 m0Var3 = o0Var.f().get(i2);
                    s.g(m0Var3, "it.dataList[p]");
                    j(m0Var3, b());
                } else {
                    m0 m0Var4 = o0Var.f().get(i2);
                    s.g(m0Var4, "it.dataList[p]");
                    j(m0Var4, m0Var.g().getCurrentValue());
                }
                h(i2);
            }
        } else {
            g();
            o0Var.f().get(1).i(true);
            setAllSkinColorValue(50);
        }
        if (i2 == -1) {
            return;
        }
        CenterLayoutManager centerLayoutManager = this.f10790d;
        if (centerLayoutManager != null) {
            Context context = getContext();
            s.g(context, "context");
            centerLayoutManager.b(context, i2, 100.0f);
            l<m0, u> c = c();
            if (c != null) {
                c.invoke(o0Var.g(i2));
            }
            o0Var.notifyItemRangeChanged(0, o0Var.getItemCount());
            return;
        }
        s.z("layoutManager");
        throw null;
    }

    public final void setAllSkinColorValue(int i2) {
        ArrayList<m0> f2;
        o0 o0Var = this.b;
        if (o0Var == null || (f2 = o0Var.f()) == null) {
            return;
        }
        for (m0 m0Var : f2) {
            m0Var.g().setCurrentValue(i2);
        }
    }

    public final void setLastSelectedBeautyValue(int i2) {
        this.f10791e = i2;
    }

    public final void setOnSelectedListener(l<? super m0, u> lVar) {
        this.f10792f = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautySkinColorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = 1;
        this.f10791e = -1;
        e(context);
    }
}
