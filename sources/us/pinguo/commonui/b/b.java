package us.pinguo.commonui.b;

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
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemSelfdefMakeupBindingImpl.java */
/* loaded from: classes4.dex */
public class b extends a {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10061k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f10062l = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f10063f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FilterPackageDownloadView f10064g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final AppCompatImageView f10065h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatImageView f10066i;

    /* renamed from: j  reason: collision with root package name */
    private long f10067j;

    public b(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10061k, f10062l));
    }

    private boolean c(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.f10067j |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableField<MaterialInstallState> observableField, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.f10067j |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.f10067j |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean h(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.f10067j |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.commonui.b.a
    public void a(@Nullable Boolean bool) {
        this.f10059d = bool;
        synchronized (this) {
            this.f10067j |= 16;
        }
        notifyPropertyChanged(us.pinguo.commonui.a.c);
        super.requestRebind();
    }

    @Override // us.pinguo.commonui.b.a
    public void b(@Nullable SelfDefMakeupMaterial selfDefMakeupMaterial) {
        this.f10060e = selfDefMakeupMaterial;
        synchronized (this) {
            this.f10067j |= 32;
        }
        notifyPropertyChanged(us.pinguo.commonui.a.f10057d);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0110  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.commonui.b.b.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10067j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10067j = 64L;
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
                    return f((ObservableField) obj, i3);
                }
                return g((ObservableBoolean) obj, i3);
            }
            return c((ObservableInt) obj, i3);
        }
        return h((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.commonui.a.c == i2) {
            a((Boolean) obj);
        } else if (us.pinguo.commonui.a.f10057d != i2) {
            return false;
        } else {
            b((SelfDefMakeupMaterial) obj);
        }
        return true;
    }

    private b(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (SimpleDraweeView) objArr[1], (AutofitTextView) objArr[6], (AppCompatImageView) objArr[2]);
        this.f10067j = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10063f = constraintLayout;
        constraintLayout.setTag(null);
        FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) objArr[3];
        this.f10064g = filterPackageDownloadView;
        filterPackageDownloadView.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[4];
        this.f10065h = appCompatImageView;
        appCompatImageView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) objArr[5];
        this.f10066i = appCompatImageView2;
        appCompatImageView2.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
