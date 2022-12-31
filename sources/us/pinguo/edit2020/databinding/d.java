package us.pinguo.edit2020.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.common.widget.WaterFillingView;
import us.pinguo.repository2020.entity.Material;
/* compiled from: ItemBackgroundBlurShapeBindingImpl.java */
/* loaded from: classes4.dex */
public class d extends c {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10463f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f10464g = null;
    @NonNull
    private final ConstraintLayout b;
    @NonNull
    private final SimpleDraweeView c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final WaterFillingView f10465d;

    /* renamed from: e  reason: collision with root package name */
    private long f10466e;

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10463f, f10464g));
    }

    private boolean b(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10466e |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean c(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10466e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.c
    public void a(@Nullable Material material) {
        this.a = material;
        synchronized (this) {
            this.f10466e |= 4;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10106e);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [us.pinguo.edit2020.databinding.c, us.pinguo.edit2020.databinding.d, androidx.databinding.ViewDataBinding] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        ?? r5;
        ObservableInt observableInt;
        synchronized (this) {
            j2 = this.f10466e;
            this.f10466e = 0L;
        }
        Material material = this.a;
        int i2 = ((15 & j2) > 0L ? 1 : ((15 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            ObservableBoolean observableBoolean = null;
            if (material != null) {
                observableBoolean = material.isSelected();
                observableInt = material.getDownloadProgress();
            } else {
                observableInt = null;
            }
            updateRegistration(0, observableBoolean);
            updateRegistration(1, observableInt);
            r7 = observableBoolean != null ? observableBoolean.get() : false;
            r5 = observableInt != null ? observableInt.get() : false;
        } else {
            r5 = 0;
        }
        if ((j2 & 13) != 0) {
            PaintMaterialBindingAdapter.f(this.c, material, Boolean.valueOf(r7));
        }
        if (i2 != 0) {
            PaintMaterialBindingAdapter.e(this.f10465d, material, Integer.valueOf((int) r5), Boolean.valueOf(r7));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10466e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10466e = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return b((ObservableInt) obj, i3);
        }
        return c((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10106e == i2) {
            a((Material) obj);
            return true;
        }
        return false;
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f10466e = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) objArr[1];
        this.c = simpleDraweeView;
        simpleDraweeView.setTag(null);
        WaterFillingView waterFillingView = (WaterFillingView) objArr[2];
        this.f10465d = waterFillingView;
        waterFillingView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
