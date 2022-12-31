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
import us.pinguo.edit2020.widget.CollectAnimImageView;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemMaterialTemplateBindingImpl.java */
/* loaded from: classes4.dex */
public class j extends i {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10479k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f10480l = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f10481f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final AppCompatImageView f10482g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final FilterPackageDownloadView f10483h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatImageView f10484i;

    /* renamed from: j  reason: collision with root package name */
    private long f10485j;

    public j(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10479k, f10480l));
    }

    private boolean b(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10485j |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean c(ObservableField<MaterialInstallState> observableField, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10485j |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10485j |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10485j |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean h(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10485j |= 4;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.i
    public void a(@Nullable Material material) {
        this.f10478e = material;
        synchronized (this) {
            this.f10485j |= 32;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10106e);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.j.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10485j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10485j = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return false;
                        }
                        return b((ObservableInt) obj, i3);
                    }
                    return g((ObservableBoolean) obj, i3);
                }
                return h((ObservableBoolean) obj, i3);
            }
            return c((ObservableField) obj, i3);
        }
        return f((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10106e == i2) {
            a((Material) obj);
            return true;
        }
        return false;
    }

    private j(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (CollectAnimImageView) objArr[7], (SimpleDraweeView) objArr[1], (AutofitTextView) objArr[6], (AppCompatImageView) objArr[2]);
        this.f10485j = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10481f = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[3];
        this.f10482g = appCompatImageView;
        appCompatImageView.setTag(null);
        FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) objArr[4];
        this.f10483h = filterPackageDownloadView;
        filterPackageDownloadView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) objArr[5];
        this.f10484i = appCompatImageView2;
        appCompatImageView2.setTag(null);
        this.c.setTag(null);
        this.f10477d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
