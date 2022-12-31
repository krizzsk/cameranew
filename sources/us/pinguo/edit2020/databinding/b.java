package us.pinguo.edit2020.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.edit2020.view.CircleImageView;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemBackgroundBlurLensBindingImpl.java */
/* loaded from: classes4.dex */
public class b extends a {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10456j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f10457k = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f10458e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f10459f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FilterPackageDownloadView f10460g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final AppCompatImageView f10461h;

    /* renamed from: i  reason: collision with root package name */
    private long f10462i;

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10456j, f10457k));
    }

    private boolean b(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10462i |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean c(ObservableField<MaterialInstallState> observableField, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10462i |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10462i |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10462i |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.a
    public void a(@Nullable BackgroundBlur backgroundBlur) {
        this.f10455d = backgroundBlur;
        synchronized (this) {
            this.f10462i |= 16;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10106e);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.b.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10462i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10462i = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return b((ObservableInt) obj, i3);
                }
                return f((ObservableBoolean) obj, i3);
            }
            return g((ObservableBoolean) obj, i3);
        }
        return c((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10106e == i2) {
            a((BackgroundBlur) obj);
            return true;
        }
        return false;
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (CircleImageView) objArr[1], (AutofitTextView) objArr[6], (AppCompatImageView) objArr[3]);
        this.f10462i = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10458e = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f10459f = imageView;
        imageView.setTag(null);
        FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) objArr[4];
        this.f10460g = filterPackageDownloadView;
        filterPackageDownloadView.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[5];
        this.f10461h = appCompatImageView;
        appCompatImageView.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
