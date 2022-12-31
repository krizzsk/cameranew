package us.pinguo.edit2020.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.widget.adjust.AdjustTextSelectView;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout2;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: LayoutAdjustPaintStyleBindingImpl.java */
/* loaded from: classes4.dex */
public class p extends o {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10505h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f10506i;

    /* renamed from: g  reason: collision with root package name */
    private long f10507g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10506i = sparseIntArray;
        sparseIntArray.put(R.id.clUndoRedo, 3);
        sparseIntArray.put(R.id.ivSwitchFace, 4);
        sparseIntArray.put(R.id.llGraffitiColors, 5);
        sparseIntArray.put(R.id.rvGraffitiColors, 6);
        sparseIntArray.put(R.id.llAdjust, 7);
        sparseIntArray.put(R.id.hideableAdjust, 8);
        sparseIntArray.put(R.id.textSelectView, 9);
        sparseIntArray.put(R.id.sbAdjust, 10);
        sparseIntArray.put(R.id.flContainer, 11);
        sparseIntArray.put(R.id.ivPaint, 12);
        sparseIntArray.put(R.id.ivEraser, 13);
    }

    public p(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f10505h, f10506i));
    }

    private boolean c(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10507g |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10507g |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.o
    public void a(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.f10504f = observableBoolean;
        synchronized (this) {
            this.f10507g |= 2;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.c);
        super.requestRebind();
    }

    @Override // us.pinguo.edit2020.databinding.o
    public void b(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.f10503e = observableBoolean;
        synchronized (this) {
            this.f10507g |= 1;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10105d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        Drawable drawable;
        Context context;
        int i2;
        synchronized (this) {
            j2 = this.f10507g;
            this.f10507g = 0L;
        }
        ObservableBoolean observableBoolean = this.f10503e;
        ObservableBoolean observableBoolean2 = this.f10504f;
        Drawable drawable2 = null;
        int i3 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean z = observableBoolean != null ? observableBoolean.get() : false;
            if (i3 != 0) {
                j2 |= z ? 64L : 32L;
            }
            if (z) {
                context = this.f10502d.getContext();
                i2 = R.drawable.ic_inner_undo_enable;
            } else {
                context = this.f10502d.getContext();
                i2 = R.drawable.ic_inner_undo_unable;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
        } else {
            drawable = null;
        }
        int i4 = ((j2 & 6) > 0L ? 1 : ((j2 & 6) == 0L ? 0 : -1));
        if (i4 != 0) {
            boolean z2 = observableBoolean2 != null ? observableBoolean2.get() : false;
            if (i4 != 0) {
                j2 |= z2 ? 16L : 8L;
            }
            drawable2 = AppCompatResources.getDrawable(this.c.getContext(), z2 ? R.drawable.ic_inner_redo_enable : R.drawable.ic_inner_redo_unable);
        }
        if ((6 & j2) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.c, drawable2);
        }
        if ((j2 & 5) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f10502d, drawable);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10507g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10507g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return c((ObservableBoolean) obj, i3);
        }
        return f((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10105d == i2) {
            b((ObservableBoolean) obj);
        } else if (us.pinguo.edit2020.a.c != i2) {
            return false;
        } else {
            a((ObservableBoolean) obj);
        }
        return true;
    }

    private p(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (PaintEraserAdjustLayout2) objArr[0], (ConstraintLayout) objArr[3], (FrameLayout) objArr[11], (LinearLayout) objArr[8], (ImageView) objArr[13], (ImageView) objArr[12], (ImageView) objArr[2], (ImageView) objArr[4], (ImageView) objArr[1], (LinearLayout) objArr[7], (LinearLayout) objArr[5], (RecyclerView) objArr[6], (StickySeekBar) objArr[10], (AdjustTextSelectView) objArr[9]);
        this.f10507g = -1L;
        this.a.setTag(null);
        this.c.setTag(null);
        this.f10502d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
