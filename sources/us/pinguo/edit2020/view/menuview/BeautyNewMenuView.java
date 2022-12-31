package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.common.widget.g;
import us.pinguo.edit2020.adapter.a0;
import us.pinguo.edit2020.bean.h;
/* compiled from: BeautyNewMenuView.kt */
/* loaded from: classes4.dex */
public final class BeautyNewMenuView extends FrameLayout {
    private a0<h> a;
    private final RecyclerView b;
    private a c;

    /* compiled from: BeautyNewMenuView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f(h hVar);

        void g(h hVar);
    }

    /* compiled from: BeautyNewMenuView.kt */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            s.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                BeautyNewMenuView.this.c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            s.h(recyclerView, "recyclerView");
            if (i2 == 0 && i3 == 0) {
                BeautyNewMenuView.this.c();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeautyNewMenuView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BeautyNewMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ BeautyNewMenuView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(h hVar) {
        a aVar = this.c;
        if (aVar == null) {
            return;
        }
        String g2 = hVar.g();
        if (g2 != null) {
            switch (g2.hashCode()) {
                case -1655346876:
                    if (g2.equals("facial_3D")) {
                        aVar.a();
                        return;
                    }
                    break;
                case -1225514539:
                    if (g2.equals("one_key_beauty")) {
                        aVar.b();
                        return;
                    }
                    break;
                case -1081519863:
                    if (g2.equals("makeup")) {
                        aVar.e();
                        return;
                    }
                    break;
                case -664214525:
                    if (g2.equals("facial_feature")) {
                        aVar.d();
                        return;
                    }
                    break;
                case 1628840913:
                    if (g2.equals("hand_shape")) {
                        aVar.c();
                        return;
                    }
                    break;
                case 2037392116:
                    if (g2.equals("skin_tone")) {
                        aVar.g(hVar);
                        return;
                    }
                    break;
            }
        }
        aVar.f(hVar);
    }

    public final void b() {
        this.b.addOnScrollListener(new b());
    }

    public final void c() {
        a0<h> a0Var = this.a;
        ArrayList<h> h2 = a0Var == null ? null : a0Var.h();
        if (h2 == null || h2.isEmpty()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.b.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1 || findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return;
        }
        while (true) {
            int i2 = findFirstVisibleItemPosition + 1;
            us.pinguo.foundation.statistics.h.b.m0(us.pinguo.edit2020.repository.a.e(h2.get(findFirstVisibleItemPosition).f()), null, "show");
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return;
            }
            findFirstVisibleItemPosition = i2;
        }
    }

    public final void e(ArrayList<h> dataList) {
        s.h(dataList, "dataList");
        a0<h> a0Var = this.a;
        if (a0Var == null) {
            EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(getContext(), 0, false);
            this.b.setLayoutManager(editFunctionLayoutManager);
            RecyclerView.ItemAnimator itemAnimator = this.b.getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            a0<h> a0Var2 = new a0<>();
            a0Var2.A(new BeautyNewMenuView$refreshData$1$1(this));
            a0.u(a0Var2, dataList, null, true, 2, null);
            this.b.setAdapter(a0Var2);
            g gVar = new g();
            int itemCount = a0Var2.getItemCount();
            Context context = getContext();
            s.g(context, "context");
            Context context2 = this.b.getContext();
            s.g(context2, "recyclerView.context");
            gVar.a(context, itemCount, editFunctionLayoutManager.a(context2, itemCount));
            this.b.addItemDecoration(gVar);
            this.a = a0Var2;
            return;
        }
        a0.u(a0Var, dataList, null, true, 2, null);
    }

    public final void setOnItemChangeListener(a aVar) {
        this.c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyNewMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        RecyclerView recyclerView = new RecyclerView(context);
        this.b = recyclerView;
        addView(recyclerView);
    }
}
