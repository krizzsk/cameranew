package us.pinguo.edit2020.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemPaintMaterialBindingImpl.java */
/* loaded from: classes4.dex */
public class l extends k {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10487j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f10488k = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f10489e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final AppCompatImageView f10490f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FilterPackageDownloadView f10491g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final AppCompatImageView f10492h;

    /* renamed from: i  reason: collision with root package name */
    private long f10493i;

    public l(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10487j, f10488k));
    }

    private boolean b(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10493i |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean c(ObservableField<MaterialInstallState> observableField, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10493i |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10493i |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10493i |= 4;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.k
    public void a(@Nullable Material material) {
        this.f10486d = material;
        synchronized (this) {
            this.f10493i |= 16;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10107f);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0157  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.l.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10493i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10493i = 32L;
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
                    return f((ObservableBoolean) obj, i3);
                }
                return g((ObservableBoolean) obj, i3);
            }
            return c((ObservableField) obj, i3);
        }
        return b((ObservableInt) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10107f == i2) {
            a((Material) obj);
            return true;
        }
        return false;
    }

    private l(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (SimpleDraweeView) objArr[1], (AutofitTextView) objArr[6], (AppCompatImageView) objArr[2]);
        this.f10493i = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10489e = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[3];
        this.f10490f = appCompatImageView;
        appCompatImageView.setTag(null);
        FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) objArr[4];
        this.f10491g = filterPackageDownloadView;
        filterPackageDownloadView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) objArr[5];
        this.f10492h = appCompatImageView2;
        appCompatImageView2.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
