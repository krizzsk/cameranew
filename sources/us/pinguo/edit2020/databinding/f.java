package us.pinguo.edit2020.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
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
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemMaterialBindingImpl.java */
/* loaded from: classes4.dex */
public class f extends e {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10467h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f10468i = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f10469d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ProgressBar f10470e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final AppCompatImageView f10471f;

    /* renamed from: g  reason: collision with root package name */
    private long f10472g;

    public f(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10467h, f10468i));
    }

    private boolean b(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10472g |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean c(ObservableField<MaterialInstallState> observableField, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10472g |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10472g |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10472g |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.e
    public void a(@Nullable Material material) {
        this.c = material;
        synchronized (this) {
            this.f10472g |= 16;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10106e);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.f.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10472g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10472g = 32L;
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
            a((Material) obj);
            return true;
        }
        return false;
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (SimpleDraweeView) objArr[1], (AutofitTextView) objArr[4]);
        this.f10472g = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10469d = constraintLayout;
        constraintLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) objArr[2];
        this.f10470e = progressBar;
        progressBar.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[3];
        this.f10471f = appCompatImageView;
        appCompatImageView.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
