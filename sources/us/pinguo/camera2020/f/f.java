package us.pinguo.camera2020.f;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
/* compiled from: LayoutCellFrameItemBindingImpl.java */
/* loaded from: classes2.dex */
public class f extends e {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f9159e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f9160f = null;

    /* renamed from: d  reason: collision with root package name */
    private long f9161d;

    public f(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f9159e, f9160f));
    }

    @Override // us.pinguo.camera2020.f.e
    public void a(@Nullable us.pinguo.camera2020.view.s2.a aVar) {
        this.c = aVar;
        synchronized (this) {
            this.f9161d |= 1;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9144f);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f9161d;
            this.f9161d = 0L;
        }
        us.pinguo.camera2020.view.s2.a aVar = this.c;
        if ((j2 & 3) != 0) {
            b.a(this.a, aVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9161d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9161d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.camera2020.e.f9144f == i2) {
            a((us.pinguo.camera2020.view.s2.a) obj);
            return true;
        }
        return false;
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatImageView) objArr[1], (RelativeLayout) objArr[0]);
        this.f9161d = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
