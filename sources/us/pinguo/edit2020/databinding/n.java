package us.pinguo.edit2020.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: LayoutAdjustPaintBindingImpl.java */
/* loaded from: classes4.dex */
public class n extends m {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10499j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f10500k;

    /* renamed from: i  reason: collision with root package name */
    private long f10501i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10500k = sparseIntArray;
        sparseIntArray.put(R.id.clUndoRedo, 4);
        sparseIntArray.put(R.id.ivSwitchFace, 5);
        sparseIntArray.put(R.id.ivAdjustFace, 6);
        sparseIntArray.put(R.id.ivBackgroundHide, 7);
        sparseIntArray.put(R.id.llGraffitiColors, 8);
        sparseIntArray.put(R.id.rvGraffitiColors, 9);
        sparseIntArray.put(R.id.llAdjust, 10);
        sparseIntArray.put(R.id.hideableAdjust, 11);
        sparseIntArray.put(R.id.tvPaint, 12);
        sparseIntArray.put(R.id.vDivider, 13);
        sparseIntArray.put(R.id.tvEraser, 14);
        sparseIntArray.put(R.id.sbAdjust, 15);
        sparseIntArray.put(R.id.tvSelectFaceHint, 16);
    }

    public n(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f10499j, f10500k));
    }

    private boolean b(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10501i |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean c(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10501i |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10501i |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.m
    public void a(@Nullable ObservableInt observableInt) {
        updateRegistration(2, observableInt);
        this.f10496f = observableInt;
        synchronized (this) {
            this.f10501i |= 4;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        Drawable drawable;
        int i2;
        boolean z;
        Context context;
        int i3;
        Context context2;
        int i4;
        synchronized (this) {
            j2 = this.f10501i;
            this.f10501i = 0L;
        }
        ObservableBoolean observableBoolean = this.f10497g;
        ObservableBoolean observableBoolean2 = this.f10498h;
        ObservableInt observableInt = this.f10496f;
        Drawable drawable2 = null;
        int i5 = 0;
        int i6 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
        if (i6 != 0) {
            boolean z2 = observableBoolean != null ? observableBoolean.get() : false;
            if (i6 != 0) {
                j2 |= z2 ? 512L : 256L;
            }
            if (z2) {
                context2 = this.c.getContext();
                i4 = R.drawable.ic_inner_undo_enable;
            } else {
                context2 = this.c.getContext();
                i4 = R.drawable.ic_inner_undo_unable;
            }
            drawable = AppCompatResources.getDrawable(context2, i4);
        } else {
            drawable = null;
        }
        int i7 = ((j2 & 10) > 0L ? 1 : ((j2 & 10) == 0L ? 0 : -1));
        if (i7 != 0) {
            boolean z3 = observableBoolean2 != null ? observableBoolean2.get() : false;
            if (i7 != 0) {
                j2 |= z3 ? 128L : 64L;
            }
            if (z3) {
                context = this.b.getContext();
                i3 = R.drawable.ic_inner_redo_enable;
            } else {
                context = this.b.getContext();
                i3 = R.drawable.ic_inner_redo_unable;
            }
            drawable2 = AppCompatResources.getDrawable(context, i3);
        }
        int i8 = ((j2 & 12) > 0L ? 1 : ((j2 & 12) == 0L ? 0 : -1));
        if (i8 != 0) {
            i2 = observableInt != null ? observableInt.get() : 0;
            z = i2 != 0;
            if (i8 != 0) {
                j2 = z ? j2 | 32 : j2 | 16;
            }
        } else {
            i2 = 0;
            z = false;
        }
        boolean z4 = ((j2 & 32) == 0 || i2 == 3) ? false : true;
        int i9 = ((j2 & 12) > 0L ? 1 : ((j2 & 12) == 0L ? 0 : -1));
        if (i9 != 0) {
            if (!z) {
                z4 = false;
            }
            if (i9 != 0) {
                j2 |= z4 ? 2048L : 1024L;
            }
            if (z4) {
                i5 = 8;
            }
        }
        if ((j2 & 10) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable2);
        }
        if ((j2 & 9) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.c, drawable);
        }
        if ((j2 & 12) != 0) {
            LinearLayout linearLayout = this.f10494d;
            linearLayout.setVisibility(i5);
            VdsAgent.onSetViewVisibility(linearLayout, i5);
        }
    }

    public void g(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.f10498h = observableBoolean;
        synchronized (this) {
            this.f10501i |= 2;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.c);
        super.requestRebind();
    }

    public void h(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.f10497g = observableBoolean;
        synchronized (this) {
            this.f10501i |= 1;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10105d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10501i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10501i = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return b((ObservableInt) obj, i3);
            }
            return c((ObservableBoolean) obj, i3);
        }
        return f((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10105d == i2) {
            h((ObservableBoolean) obj);
        } else if (us.pinguo.edit2020.a.c == i2) {
            g((ObservableBoolean) obj);
        } else if (us.pinguo.edit2020.a.b != i2) {
            return false;
        } else {
            a((ObservableInt) obj);
        }
        return true;
    }

    private n(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (PaintEraserAdjustLayout) objArr[0], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[11], (ImageView) objArr[6], (ImageView) objArr[7], (ImageView) objArr[2], (ImageView) objArr[5], (ImageView) objArr[1], (LinearLayout) objArr[10], (LinearLayout) objArr[8], (LinearLayout) objArr[3], (RecyclerView) objArr[9], (StickySeekBar) objArr[15], (TextView) objArr[14], (TextView) objArr[12], (AutofitTextView) objArr[16], (View) objArr[13]);
        this.f10501i = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.f10494d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
