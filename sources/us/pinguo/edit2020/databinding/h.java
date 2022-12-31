package us.pinguo.edit2020.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.repository2020.entity.Material;
/* compiled from: ItemMaterialCategoryBindingImpl.java */
/* loaded from: classes4.dex */
public class h extends g {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f10473f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f10474g = null;
    @NonNull
    private final ConstraintLayout c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f10475d;

    /* renamed from: e  reason: collision with root package name */
    private long f10476e;

    public h(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10473f, f10474g));
    }

    private boolean c(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.edit2020.a.a) {
            synchronized (this) {
                this.f10476e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.databinding.g
    public void a(@Nullable Material material) {
        this.b = material;
        synchronized (this) {
            this.f10476e |= 4;
        }
        notifyPropertyChanged(us.pinguo.edit2020.a.f10106e);
        super.requestRebind();
    }

    @Override // us.pinguo.edit2020.databinding.g
    public void b(@Nullable Integer num) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (androidx.databinding.ViewDataBinding.safeUnbox(r4 != null ? r4.getVip() : null) == 1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r13 = this;
            monitor-enter(r13)
            long r0 = r13.f10476e     // Catch: java.lang.Throwable -> L57
            r2 = 0
            r13.f10476e = r2     // Catch: java.lang.Throwable -> L57
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L57
            us.pinguo.repository2020.entity.Material r4 = r13.b
            r5 = 13
            long r5 = r5 & r0
            r7 = 12
            r9 = 0
            int r10 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r10 == 0) goto L3f
            long r5 = r0 & r7
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L2b
            if (r4 == 0) goto L22
            java.lang.Integer r5 = r4.getVip()
            goto L23
        L22:
            r5 = r11
        L23:
            int r5 = androidx.databinding.ViewDataBinding.safeUnbox(r5)
            r6 = 1
            if (r5 != r6) goto L2b
            goto L2c
        L2b:
            r6 = 0
        L2c:
            if (r4 == 0) goto L32
            androidx.databinding.ObservableBoolean r11 = r4.isSelected()
        L32:
            r13.updateRegistration(r9, r11)
            if (r11 == 0) goto L3e
            boolean r9 = r11.get()
            r5 = r9
            r9 = r6
            goto L40
        L3e:
            r9 = r6
        L3f:
            r5 = 0
        L40:
            long r0 = r0 & r7
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L4f
            com.facebook.drawee.view.SimpleDraweeView r0 = r13.a
            us.pinguo.edit2020.databinding.PaintMaterialBindingAdapter.c(r0, r4)
            android.widget.ImageView r0 = r13.f10475d
            us.pinguo.edit2020.databinding.PaintMaterialBindingAdapter.h(r0, r9)
        L4f:
            if (r10 == 0) goto L56
            androidx.constraintlayout.widget.ConstraintLayout r0 = r13.c
            us.pinguo.edit2020.databinding.PaintMaterialBindingAdapter.a(r0, r5)
        L56:
            return
        L57:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L57
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.h.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10476e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10476e = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return c((ObservableBoolean) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.edit2020.a.f10108g == i2) {
            b((Integer) obj);
        } else if (us.pinguo.edit2020.a.f10106e != i2) {
            return false;
        } else {
            a((Material) obj);
        }
        return true;
    }

    private h(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (SimpleDraweeView) objArr[1]);
        this.f10476e = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.c = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f10475d = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
