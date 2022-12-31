package us.pinguo.edit2020.view.menuview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.common.widget.g;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.a0;
import us.pinguo.edit2020.bean.h;
/* compiled from: BeautyMenuView.kt */
/* loaded from: classes4.dex */
public final class BeautyMenuView extends ConstraintLayout {
    public Map<Integer, View> a;
    private a0<h> b;
    private a c;

    /* compiled from: BeautyMenuView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyMenuView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        h(context);
    }

    private final void h(Context context) {
        View.inflate(context, R.layout.layout_common_simple_recyclerlist, this);
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

    public final a g() {
        return this.c;
    }

    public final void i(ArrayList<h> dataList) {
        s.h(dataList, "dataList");
        a0<h> a0Var = this.b;
        if (a0Var == null) {
            EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(getContext(), 0, false);
            int i2 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i2)).setLayoutManager(editFunctionLayoutManager);
            RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) _$_findCachedViewById(i2)).getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            a0<h> a0Var2 = new a0<>();
            a0Var2.A(new BeautyMenuView$refreshData$1(this));
            a0.u(a0Var2, dataList, null, true, 2, null);
            ((RecyclerView) _$_findCachedViewById(i2)).setAdapter(a0Var2);
            g gVar = new g();
            int itemCount = a0Var2.getItemCount();
            Context context = getContext();
            s.g(context, "context");
            Context context2 = ((RecyclerView) _$_findCachedViewById(i2)).getContext();
            s.g(context2, "recyclerView.context");
            gVar.a(context, itemCount, editFunctionLayoutManager.a(context2, itemCount));
            ((RecyclerView) _$_findCachedViewById(i2)).addItemDecoration(gVar);
            this.b = a0Var2;
            return;
        }
        a0.u(a0Var, dataList, null, true, 2, null);
    }

    public final void setItemClickListener(a aVar) {
        this.c = aVar;
    }

    public final void setMAdapter(a0<h> a0Var) {
        this.b = a0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyMenuView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        h(context);
    }
}
