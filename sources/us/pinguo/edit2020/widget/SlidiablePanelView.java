package us.pinguo.edit2020.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.n0;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.repository2020.entity.Graffiti;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.Mosaic;
import us.pinguo.repository2020.entity.PaintMaterial;
import us.pinguo.repository2020.manager.MaterialDataManager;
/* compiled from: SlidiablePanelView.kt */
/* loaded from: classes4.dex */
public final class SlidiablePanelView extends ConstraintLayout {
    public Map<Integer, View> a;
    private final FunctionType b;
    private Boolean c;

    /* renamed from: d  reason: collision with root package name */
    private BottomSheetBehavior<View> f10930d;

    /* renamed from: e  reason: collision with root package name */
    private n0.b f10931e;

    /* renamed from: f  reason: collision with root package name */
    private final View f10932f;

    /* renamed from: g  reason: collision with root package name */
    private n0 f10933g;

    /* renamed from: h  reason: collision with root package name */
    private n0 f10934h;

    /* renamed from: i  reason: collision with root package name */
    private int f10935i;

    /* compiled from: SlidiablePanelView.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.MOSAIC.ordinal()] = 1;
            iArr[FunctionType.GRAFFITI.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: SlidiablePanelView.kt */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        final /* synthetic */ float a;

        b(float f2) {
            this.a = f2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            s.h(outRect, "outRect");
            s.h(view, "view");
            s.h(parent, "parent");
            s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition > 5) {
                outRect.top = (int) (this.a * 2);
            }
            if (childAdapterPosition % 5 == 0) {
                float f2 = this.a;
                outRect.left = (int) (1.4f * f2);
                outRect.right = (int) f2;
                return;
            }
            float f3 = this.a;
            outRect.left = (int) f3;
            outRect.right = (int) f3;
        }
    }

    /* compiled from: SlidiablePanelView.kt */
    /* loaded from: classes4.dex */
    public static final class c implements n0.b {
        final /* synthetic */ RecyclerView b;

        c(RecyclerView recyclerView) {
            this.b = recyclerView;
        }

        @Override // us.pinguo.edit2020.adapter.n0.b
        public void a(View view, int i2, PaintMaterial paintMaterial) {
            s.h(paintMaterial, "paintMaterial");
            n0.b j2 = SlidiablePanelView.this.j();
            if (j2 != null) {
                j2.a(view, i2, paintMaterial);
            }
            SlidiablePanelView.this.f10935i = i2;
            Rect rect = new Rect();
            if (view != null) {
                view.getGlobalVisibleRect(rect);
            }
            if (view != null && rect.height() < SlidiablePanelView.this.getContext().getResources().getDimensionPixelSize(R.dimen.paint_material_rv_item_size) && !this.b.canScrollVertically(-1)) {
                SlidiablePanelView.this.i();
                return;
            }
            Float valueOf = view == null ? null : Float.valueOf(view.getY());
            this.b.smoothScrollBy(0, (int) (valueOf == null ? 0 - this.b.getY() : valueOf.floatValue()));
        }
    }

    public /* synthetic */ SlidiablePanelView(Context context, AttributeSet attributeSet, int i2, FunctionType functionType, Boolean bool, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2, functionType, (i3 & 16) != 0 ? Boolean.TRUE : bool);
    }

    private final void l(RecyclerView recyclerView) {
        float i2 = (us.pinguo.foundation.utils.n0.i() - (getContext().getResources().getDimensionPixelSize(R.dimen.paint_material_rv_item_size) * 5.0f)) / 12.0f;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addItemDecoration(new b(i2));
    }

    private final void m(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
        n0 n0Var = adapter instanceof n0 ? (n0) adapter : null;
        if (n0Var == null) {
            return;
        }
        n0Var.k(new c(recyclerView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(SlidiablePanelView this$0) {
        View view;
        s.h(this$0, "this$0");
        int i2 = R.id.rvMaterial;
        n0 n0Var = ((RecyclerView) this$0._$_findCachedViewById(i2)).getVisibility() == 0 ? this$0.f10933g : this$0.f10934h;
        if (((RecyclerView) this$0._$_findCachedViewById(i2)).getVisibility() != 0) {
            i2 = R.id.rvCreativityMaterial;
        }
        RecyclerView recyclerView = (RecyclerView) this$0._$_findCachedViewById(i2);
        boolean z = false;
        int f2 = n0Var == null ? 0 : n0Var.f();
        this$0.f10935i = f2;
        List<PaintMaterial> e2 = n0Var == null ? null : n0Var.e();
        if (e2 != null && f2 >= 0 && (!e2.isEmpty())) {
            ObservableBoolean isSelected = e2.get(this$0.f10935i).isSelected();
            if (isSelected != null && isSelected.get()) {
                z = true;
            }
            if (!z) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this$0.f10935i);
                if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
                    return;
                }
                view.performClick();
                return;
            }
            n0.b j2 = this$0.j();
            if (j2 == null) {
                return;
            }
            int i3 = this$0.f10935i;
            j2.a(null, i3, e2.get(i3));
        }
    }

    public static /* synthetic */ void setPanelHeight$default(SlidiablePanelView slidiablePanelView, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        slidiablePanelView.setPanelHeight(bool);
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

    public final void a() {
        CoordinatorLayout slidableView = (CoordinatorLayout) _$_findCachedViewById(R.id.slidableView);
        s.g(slidableView, "slidableView");
        slidableView.setVisibility(8);
        VdsAgent.onSetViewVisibility(slidableView, 8);
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 0) {
            motionEvent.getRawX();
            motionEvent.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            motionEvent.getRawX();
            motionEvent.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            motionEvent.getRawX();
            motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void h() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.f10930d;
        boolean z = false;
        if (bottomSheetBehavior2 != null && bottomSheetBehavior2.C() == 4) {
            z = true;
        }
        if (z || (bottomSheetBehavior = this.f10930d) == null) {
            return;
        }
        bottomSheetBehavior.V(4);
    }

    public final void i() {
        BottomSheetBehavior<View> bottomSheetBehavior;
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.f10930d;
        boolean z = false;
        if (bottomSheetBehavior2 != null && bottomSheetBehavior2.C() == 3) {
            z = true;
        }
        if (z || (bottomSheetBehavior = this.f10930d) == null) {
            return;
        }
        bottomSheetBehavior.V(3);
    }

    public final n0.b j() {
        return this.f10931e;
    }

    public final View k() {
        return this.f10932f;
    }

    public final void p(int i2) {
        if (i2 == 0) {
            int i3 = R.id.rvMaterial;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i3);
            recyclerView.setVisibility(0);
            VdsAgent.onSetViewVisibility(recyclerView, 0);
            ((RecyclerView) _$_findCachedViewById(i3)).setNestedScrollingEnabled(true);
            int i4 = R.id.rvCreativityMaterial;
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(i4);
            recyclerView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(recyclerView2, 4);
            ((RecyclerView) _$_findCachedViewById(i4)).setNestedScrollingEnabled(false);
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(i3);
        } else if (i2 != 1) {
        } else {
            int i5 = R.id.rvMaterial;
            RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(i5);
            recyclerView4.setVisibility(4);
            VdsAgent.onSetViewVisibility(recyclerView4, 4);
            ((RecyclerView) _$_findCachedViewById(i5)).setNestedScrollingEnabled(false);
            int i6 = R.id.rvCreativityMaterial;
            RecyclerView recyclerView5 = (RecyclerView) _$_findCachedViewById(i6);
            recyclerView5.setVisibility(0);
            VdsAgent.onSetViewVisibility(recyclerView5, 0);
            ((RecyclerView) _$_findCachedViewById(i6)).setNestedScrollingEnabled(true);
            RecyclerView recyclerView6 = (RecyclerView) _$_findCachedViewById(i6);
        }
    }

    public final void setOnPaintItemClick(n0.b bVar) {
        this.f10931e = bVar;
    }

    public final void setPanelHeight(Boolean bool) {
        Boolean bool2 = Boolean.TRUE;
        if (s.c(bool, bool2)) {
            ((CoordinatorLayout) _$_findCachedViewById(R.id.slidableView)).setLayoutParams(new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.graffiti_slidiable_panel_height)));
            BottomSheetBehavior<View> bottomSheetBehavior = this.f10930d;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.R(getContext().getResources().getDimensionPixelSize(R.dimen.graffiti_slidiable_half_height));
            }
        } else {
            ((CoordinatorLayout) _$_findCachedViewById(R.id.slidableView)).setLayoutParams(new FrameLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.mosaic_slidiable_panel_height)));
            BottomSheetBehavior<View> bottomSheetBehavior2 = this.f10930d;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.R(getContext().getResources().getDimensionPixelSize(R.dimen.mosaic_slidiable_half_height));
            }
        }
        LinearLayout llGraffitiColors = (LinearLayout) _$_findCachedViewById(R.id.llGraffitiColors);
        s.g(llGraffitiColors, "llGraffitiColors");
        int i2 = s.c(bool, bool2) ? 0 : 8;
        llGraffitiColors.setVisibility(i2);
        VdsAgent.onSetViewVisibility(llGraffitiColors, i2);
    }

    public final void show() {
        CoordinatorLayout slidableView = (CoordinatorLayout) _$_findCachedViewById(R.id.slidableView);
        s.g(slidableView, "slidableView");
        slidableView.setVisibility(0);
        VdsAgent.onSetViewVisibility(slidableView, 0);
        RecyclerView rvMaterial = (RecyclerView) _$_findCachedViewById(R.id.rvMaterial);
        s.g(rvMaterial, "rvMaterial");
        us.pinguo.foundation.ui.c.b(rvMaterial, new Runnable() { // from class: us.pinguo.edit2020.widget.i
            @Override // java.lang.Runnable
            public final void run() {
                SlidiablePanelView.o(SlidiablePanelView.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidiablePanelView(Context context, AttributeSet attributeSet, int i2, FunctionType functionType, Boolean bool) {
        super(context, attributeSet, i2);
        List W;
        List W2;
        List<Graffiti> packages;
        List W3;
        Integer brushSourceType;
        s.h(context, "context");
        s.h(functionType, "functionType");
        this.a = new LinkedHashMap();
        this.b = functionType;
        this.c = bool;
        r7 = null;
        n0 n0Var = null;
        View inflate = ViewGroup.inflate(context, R.layout.layout_slidiable_panel, null);
        this.f10932f = inflate;
        addView(inflate);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 5);
        int i3 = R.id.rvMaterial;
        ((RecyclerView) _$_findCachedViewById(i3)).setLayoutManager(gridLayoutManager);
        int i4 = R.id.rvCreativityMaterial;
        ((RecyclerView) _$_findCachedViewById(i4)).setLayoutManager(gridLayoutManager2);
        l((RecyclerView) _$_findCachedViewById(i3));
        l((RecyclerView) _$_findCachedViewById(i4));
        BottomSheetBehavior<View> y = BottomSheetBehavior.y((LinearLayout) _$_findCachedViewById(R.id.llBottomSheetBehavior));
        this.f10930d = y;
        if (y != null) {
            y.V(5);
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this.f10930d;
        boolean z = false;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.P(false);
        }
        int i5 = a.a[functionType.ordinal()];
        if (i5 == 1) {
            MaterialDataManager materialDataManager = MaterialDataManager.a;
            MaterialResponse<Mosaic> value = materialDataManager.f().getValue();
            List<Mosaic> packages2 = value != null ? value.getPackages() : null;
            if (!((packages2 == null || packages2.isEmpty()) ? true : true)) {
                W2 = c0.W(packages2);
                this.f10934h = new n0(W2);
            }
            W = c0.W(materialDataManager.d().a());
            n0Var = new n0(W);
        } else if (i5 == 2) {
            MaterialResponse<Graffiti> value2 = MaterialDataManager.a.b().getValue();
            if (value2 == null || (packages = value2.getPackages()) == null) {
                W3 = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : packages) {
                    if ((s.c(this.c, Boolean.FALSE) && (brushSourceType = ((Graffiti) obj).getBrushSourceType()) != null && brushSourceType.intValue() == 103) ? false : true) {
                        arrayList.add(obj);
                    }
                }
                W3 = c0.W(arrayList);
            }
            if (W3 != null) {
                n0Var = new n0(y.c(W3));
            }
        }
        this.f10933g = n0Var;
        int i6 = R.id.rvMaterial;
        ((RecyclerView) _$_findCachedViewById(i6)).setAdapter(this.f10933g);
        if (this.f10934h != null) {
            int i7 = R.id.rvCreativityMaterial;
            ((RecyclerView) _$_findCachedViewById(i7)).setAdapter(this.f10934h);
            m((RecyclerView) _$_findCachedViewById(i7));
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(i6);
        m((RecyclerView) _$_findCachedViewById(i6));
    }
}
