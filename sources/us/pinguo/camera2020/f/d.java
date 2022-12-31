package us.pinguo.camera2020.f;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import us.pinguo.camera2020.R;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: ItemMakeupBindingImpl.java */
/* loaded from: classes2.dex */
public class d extends c {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f9153l = null;
    @Nullable
    private static final SparseIntArray m;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f9154g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final AutofitTextView f9155h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatImageView f9156i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ImageView f9157j;

    /* renamed from: k  reason: collision with root package name */
    private long f9158k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.llContainer, 8);
    }

    public d(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9153l, m));
    }

    private boolean c(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.f9158k |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean f(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.f9158k |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean g(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.f9158k |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean h(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.f9158k |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean j(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.f9158k |= 4;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.camera2020.f.c
    public void a(@Nullable BeautyData beautyData) {
        this.f9151e = beautyData;
        synchronized (this) {
            this.f9158k |= 32;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.c);
        super.requestRebind();
    }

    @Override // us.pinguo.camera2020.f.c
    public void b(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(2, observableBoolean);
        this.f9152f = observableBoolean;
        synchronized (this) {
            this.f9158k |= 4;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9142d);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e0  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.f.d.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9158k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9158k = 64L;
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
                        return h((ObservableBoolean) obj, i3);
                    }
                    return f((ObservableBoolean) obj, i3);
                }
                return j((ObservableBoolean) obj, i3);
            }
            return c((ObservableBoolean) obj, i3);
        }
        return g((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.camera2020.e.c == i2) {
            a((BeautyData) obj);
        } else if (us.pinguo.camera2020.e.f9142d != i2) {
            return false;
        } else {
            b((ObservableBoolean) obj);
        }
        return true;
    }

    private d(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (AppCompatImageView) objArr[5], (AppCompatImageView) objArr[3], (LinearLayout) objArr[8], (SwitchMaterial) objArr[1], (AutofitTextView) objArr[6]);
        this.f9158k = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9154g = linearLayout;
        linearLayout.setTag(null);
        AutofitTextView autofitTextView = (AutofitTextView) objArr[2];
        this.f9155h = autofitTextView;
        autofitTextView.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) objArr[4];
        this.f9156i = appCompatImageView;
        appCompatImageView.setTag(null);
        ImageView imageView = (ImageView) objArr[7];
        this.f9157j = imageView;
        imageView.setTag(null);
        this.c.setTag(null);
        this.f9150d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
