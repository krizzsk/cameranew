package us.pinguo.edit2020.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.edit2020.R;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: AdvanceStickerAdjustView.kt */
/* loaded from: classes4.dex */
public final class AdvanceStickerAdjustView extends ConstraintLayout {
    public Map<Integer, View> a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private String f10601d;

    /* renamed from: e  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Integer, kotlin.u> f10602e;

    /* renamed from: f  reason: collision with root package name */
    private kotlin.jvm.b.l<? super us.pinguo.edit2020.model.f.a, kotlin.u> f10603f;

    /* renamed from: g  reason: collision with root package name */
    private i0 f10604g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f10605h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10606i;

    /* renamed from: j  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> f10607j;

    /* compiled from: AdvanceStickerAdjustView.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        a() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (kotlin.jvm.internal.s.c(AdvanceStickerAdjustView.this.f10601d, Frame.PARAM_KEY_OPACITY)) {
                AdvanceStickerAdjustView.this.setCurrentOpacity(i2);
            } else {
                AdvanceStickerAdjustView.this.setCurrentPaintSize(i2);
            }
            i0 n = AdvanceStickerAdjustView.this.n();
            if (n == null) {
                return;
            }
            n.b(i2, kotlin.jvm.internal.s.c(AdvanceStickerAdjustView.this.f10601d, Frame.PARAM_KEY_OPACITY));
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            i0 n = AdvanceStickerAdjustView.this.n();
            if (n == null) {
                return;
            }
            n.a(i2, kotlin.jvm.internal.s.c(AdvanceStickerAdjustView.this.f10601d, Frame.PARAM_KEY_OPACITY));
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            ((StickySeekBar) AdvanceStickerAdjustView.this._$_findCachedViewById(R.id.seekBar)).i();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ kotlin.jvm.b.a a;

        public c(kotlin.jvm.b.a aVar) {
            this.a = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdvanceStickerAdjustView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdvanceStickerAdjustView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ AdvanceStickerAdjustView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void o() {
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvanceStickerAdjustView.p(AdvanceStickerAdjustView.this, view);
            }
        });
        ((ScrollableTextListView) _$_findCachedViewById(R.id.overlayList)).setOnTextClick(new AdvanceStickerAdjustView$initListener$2(this));
        ((StickySeekBar) _$_findCachedViewById(R.id.seekBar)).setTrackListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AdvanceStickerAdjustView this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.b.a<kotlin.u> aVar = this$0.f10605h;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    private final void s() {
        if (kotlin.jvm.internal.s.c(BigAlbumStore.PhotoColumns.SIZE, this.f10601d)) {
            int i2 = this.b;
            int i3 = R.id.seekBar;
            if (i2 == ((StickySeekBar) _$_findCachedViewById(i3)).e()) {
                return;
            }
            ((StickySeekBar) _$_findCachedViewById(i3)).setValues(0, 100, this.b, null);
            return;
        }
        int i4 = this.c;
        int i5 = R.id.seekBar;
        if (i4 == ((StickySeekBar) _$_findCachedViewById(i5)).e()) {
            return;
        }
        ((StickySeekBar) _$_findCachedViewById(i5)).setValues(0, 100, this.c, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f10601d = BigAlbumStore.PhotoColumns.SIZE;
            ((AutofitTextView) _$_findCachedViewById(R.id.tvAdjustName)).setText(us.pinguo.edit2020.utils.d.k(R.string.edit_size));
            Group refAdjustView = (Group) _$_findCachedViewById(R.id.refAdjustView);
            kotlin.jvm.internal.s.g(refAdjustView, "refAdjustView");
            refAdjustView.setVisibility(0);
            VdsAgent.onSetViewVisibility(refAdjustView, 0);
            ScrollableTextListView overlayList = (ScrollableTextListView) _$_findCachedViewById(R.id.overlayList);
            kotlin.jvm.internal.s.g(overlayList, "overlayList");
            overlayList.setVisibility(4);
            VdsAgent.onSetViewVisibility(overlayList, 4);
            s();
        } else if (i2 != 2) {
            Group refAdjustView2 = (Group) _$_findCachedViewById(R.id.refAdjustView);
            kotlin.jvm.internal.s.g(refAdjustView2, "refAdjustView");
            refAdjustView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(refAdjustView2, 4);
            ScrollableTextListView overlayList2 = (ScrollableTextListView) _$_findCachedViewById(R.id.overlayList);
            kotlin.jvm.internal.s.g(overlayList2, "overlayList");
            overlayList2.setVisibility(0);
            VdsAgent.onSetViewVisibility(overlayList2, 0);
        } else {
            this.f10601d = Frame.PARAM_KEY_OPACITY;
            ((AutofitTextView) _$_findCachedViewById(R.id.tvAdjustName)).setText(us.pinguo.edit2020.utils.d.k(R.string.str_sticker_opacity));
            Group refAdjustView3 = (Group) _$_findCachedViewById(R.id.refAdjustView);
            kotlin.jvm.internal.s.g(refAdjustView3, "refAdjustView");
            refAdjustView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(refAdjustView3, 0);
            ScrollableTextListView overlayList3 = (ScrollableTextListView) _$_findCachedViewById(R.id.overlayList);
            kotlin.jvm.internal.s.g(overlayList3, "overlayList");
            overlayList3.setVisibility(4);
            VdsAgent.onSetViewVisibility(overlayList3, 4);
            s();
        }
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

    public final void i(Integer num, Float f2) {
        us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var;
        int i2;
        if (this.f10606i && (a0Var = this.f10607j) != null) {
            this.f10606i = false;
            if (us.pinguo.edit2020.utils.d.d(f2)) {
                kotlin.jvm.internal.s.e(f2);
                this.c = (int) (f2.floatValue() * 100);
            }
            s();
            int l2 = a0Var.l();
            i2 = kotlin.collections.u.i(a0Var.h());
            if (l2 == i2) {
                setStickerInfo(num, f2);
            }
        }
    }

    public final BasicBrushMode j() {
        if (!us.pinguo.edit2020.utils.d.e(this.f10607j)) {
            us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var = this.f10607j;
            kotlin.jvm.internal.s.e(a0Var);
            if (a0Var.l() != -1) {
                us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var2 = this.f10607j;
                kotlin.jvm.internal.s.e(a0Var2);
                return a0Var2.l() == 0 ? BasicBrushMode.Erasing : BasicBrushMode.Brush;
            }
        }
        return BasicBrushMode.Erasing;
    }

    public final int k() {
        return this.b;
    }

    public final kotlin.jvm.b.l<us.pinguo.edit2020.model.f.a, kotlin.u> l() {
        return this.f10603f;
    }

    public final kotlin.jvm.b.l<Integer, kotlin.u> m() {
        return this.f10602e;
    }

    public final i0 n() {
        return this.f10604g;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        o();
        s();
    }

    public final void r(List<us.pinguo.edit2020.bean.p0> data, List<us.pinguo.edit2020.model.f.a> blendList) {
        kotlin.jvm.internal.s.h(data, "data");
        kotlin.jvm.internal.s.h(blendList, "blendList");
        us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var = this.f10607j;
        if (a0Var == null) {
            EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(getContext(), 0, false);
            int i2 = R.id.recyclerView;
            ((RecyclerView) _$_findCachedViewById(i2)).setLayoutManager(editFunctionLayoutManager);
            us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
            Context context = getContext();
            kotlin.jvm.internal.s.g(context, "context");
            int size = data.size();
            Context context2 = getContext();
            kotlin.jvm.internal.s.g(context2, "context");
            gVar.a(context, size, editFunctionLayoutManager.a(context2, data.size()));
            ((RecyclerView) _$_findCachedViewById(i2)).addItemDecoration(gVar);
            us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var2 = new us.pinguo.edit2020.adapter.a0<>();
            a0Var2.A(new AdvanceStickerAdjustView$refreshData$1$1(this, blendList));
            this.f10607j = a0Var2;
            ((RecyclerView) _$_findCachedViewById(i2)).setAdapter(this.f10607j);
            us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var3 = this.f10607j;
            kotlin.jvm.internal.s.e(a0Var3);
            us.pinguo.edit2020.adapter.a0.u(a0Var3, data, 0, false, 4, null);
            return;
        }
        kotlin.jvm.internal.s.e(a0Var);
        us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.p0> a0Var4 = this.f10607j;
        kotlin.jvm.internal.s.e(a0Var4);
        us.pinguo.edit2020.adapter.a0.u(a0Var, data, Integer.valueOf(a0Var4.l()), false, 4, null);
    }

    public final void setCurrentOpacity(int i2) {
        this.c = i2;
    }

    public final void setCurrentPaintSize(int i2) {
        this.b = i2;
    }

    public final void setOnBlendTypeChange(kotlin.jvm.b.l<? super us.pinguo.edit2020.model.f.a, kotlin.u> lVar) {
        this.f10603f = lVar;
    }

    public final void setOnCloseAction(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.f10605h = aVar;
    }

    public final void setOnFunctionClick(kotlin.jvm.b.l<? super Integer, kotlin.u> lVar) {
        this.f10602e = lVar;
    }

    public final void setOnSeekBarChange(i0 i0Var) {
        this.f10604g = i0Var;
    }

    public final void setRevertOrForward(boolean z) {
        this.f10606i = z;
    }

    public final void setStickerInfo(Integer num, Float f2) {
        int i2 = 0;
        if (us.pinguo.edit2020.utils.d.d(num)) {
            Iterator<f0> it = ((ScrollableTextListView) _$_findCachedViewById(R.id.overlayList)).b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                int i3 = i2 + 1;
                int value = ((us.pinguo.edit2020.model.f.a) it.next()).b().getValue();
                if (num != null && value == num.intValue()) {
                    break;
                }
                i2 = i3;
            }
            if (i2 != -1) {
                int i4 = R.id.overlayList;
                ((ScrollableTextListView) _$_findCachedViewById(i4)).f(i2);
                ((ScrollableTextListView) _$_findCachedViewById(i4)).e(i2);
            }
        } else {
            int i5 = R.id.overlayList;
            ((ScrollableTextListView) _$_findCachedViewById(i5)).f(0);
            ((ScrollableTextListView) _$_findCachedViewById(i5)).e(0);
        }
        if (us.pinguo.edit2020.utils.d.d(f2)) {
            kotlin.jvm.internal.s.e(f2);
            this.c = (int) (f2.floatValue() * 100);
        }
    }

    public final void t() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "translationY", us.pinguo.common.widget.i.a.b(188), 0.0f);
        kotlin.jvm.internal.s.g(animator, "animator");
        animator.addListener(new b());
        animator.setDuration(250L);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    public final void u(kotlin.jvm.b.a<kotlin.u> onEnd) {
        kotlin.jvm.internal.s.h(onEnd, "onEnd");
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "translationY", 0.0f, us.pinguo.common.widget.i.a.b(188));
        kotlin.jvm.internal.s.g(animator, "animator");
        animator.addListener(new c(onEnd));
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(250L);
        animator.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvanceStickerAdjustView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = 30;
        this.c = 20;
        this.f10601d = BigAlbumStore.PhotoColumns.SIZE;
    }
}
