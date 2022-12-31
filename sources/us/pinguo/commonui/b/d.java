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
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemStyleMakeupBindingImpl.java */
/* loaded from: classes4.dex */
public class d extends c {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts n = null;
    @Nullable
    private static final SparseIntArray o = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f10070f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FilterPackageDownloadView f10071g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final AppCompatImageView f10072h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatImageView f10073i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final AppCompatImageView f10074j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final AppCompatImageView f10075k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final AppCompatImageView f10076l;
    private long m;

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, n, o));
    }

    private boolean c(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.m |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableField<MaterialInstallState> observableField, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.m |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.m |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean h(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.commonui.a.a) {
            synchronized (this) {
                this.m |= 8;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.commonui.b.c
    public void a(@Nullable Boolean bool) {
        this.f10068d = bool;
        synchronized (this) {
            this.m |= 16;
        }
        notifyPropertyChanged(us.pinguo.commonui.a.c);
        super.requestRebind();
    }

    @Override // us.pinguo.commonui.b.c
    public void b(@Nullable StyleMakeup styleMakeup) {
        this.f10069e = styleMakeup;
        synchronized (this) {
            this.m |= 32;
        }
        notifyPropertyChanged(us.pinguo.commonui.a.f10058e);
        super.requestRebind();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
        if (r7 != false) goto L84;
     */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.commonui.b.d.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 64L;
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
                    return h((ObservableBoolean) obj, i3);
                }
                return g((ObservableBoolean) obj, i3);
            }
            return c((ObservableInt) obj, i3);
        }
        return f((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.commonui.a.c == i2) {
            a((Boolean) obj);
        } else if (us.pinguo.commonui.a.f10058e != i2) {
            return false;
        } else {
            b((StyleMakeup) obj);
        }
        return true;
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (SimpleDraweeView) objArr[1], (AutofitTextView) objArr[9], (AppCompatImageView) objArr[2]);
        this.m = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10070f = constraintLayout;
        constraintLayout.setTag(null);
        FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) objArr[3];
        this.f10071g = filterPackageDownloadView;
        filterPackageDownloadView.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[4];
        this.f10072h = appCompatImageView;
        appCompatImageView.setTag(null);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) objArr[5];
        this.f10073i = appCompatImageView2;
        appCompatImageView2.setTag(null);
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) objArr[6];
        this.f10074j = appCompatImageView3;
        appCompatImageView3.setTag(null);
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) objArr[7];
        this.f10075k = appCompatImageView4;
        appCompatImageView4.setTag(null);
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) objArr[8];
        this.f10076l = appCompatImageView5;
        appCompatImageView5.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
