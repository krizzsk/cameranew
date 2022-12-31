package us.pinguo.camera2020.f;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.camera2020.R;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: PanelMakeupSelectorBindingImpl.java */
/* loaded from: classes2.dex */
public class h extends g {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    private long w;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.tbBeauty, 12);
        sparseIntArray.put(R.id.vBeautyTabTheme, 13);
        sparseIntArray.put(R.id.clAdjust, 14);
        sparseIntArray.put(R.id.flSeekBar, 15);
        sparseIntArray.put(R.id.flRecyclerView, 16);
        sparseIntArray.put(R.id.rvStyleMakeup, 17);
        sparseIntArray.put(R.id.rvSelfDefMakeup, 18);
        sparseIntArray.put(R.id.rvBeauty, 19);
        sparseIntArray.put(R.id.clColors, 20);
        sparseIntArray.put(R.id.rvColors, 21);
        sparseIntArray.put(R.id.llBeautyHint, 22);
        sparseIntArray.put(R.id.llHint, 23);
    }

    public h(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 24, x, y));
    }

    private boolean k(ObservableInt observableInt, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.w |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.w |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean m(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.w |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean n(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.w |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean o(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.w |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean p(ObservableBoolean observableBoolean, int i2) {
        if (i2 == us.pinguo.camera2020.e.a) {
            synchronized (this) {
                this.w |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.camera2020.f.g
    public void b(@Nullable ObservableInt observableInt) {
        updateRegistration(2, observableInt);
        this.r = observableInt;
        synchronized (this) {
            this.w |= 4;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.b);
        super.requestRebind();
    }

    @Override // us.pinguo.camera2020.f.g
    public void c(@Nullable BeautyData beautyData) {
        this.q = beautyData;
        synchronized (this) {
            this.w |= 64;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9143e);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.f.h.executeBindings():void");
    }

    @Override // us.pinguo.camera2020.f.g
    public void f(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(5, observableBoolean);
        this.t = observableBoolean;
        synchronized (this) {
            this.w |= 32;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9145g);
        super.requestRebind();
    }

    @Override // us.pinguo.camera2020.f.g
    public void g(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(4, observableBoolean);
        this.s = observableBoolean;
        synchronized (this) {
            this.w |= 16;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9146h);
        super.requestRebind();
    }

    @Override // us.pinguo.camera2020.f.g
    public void h(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.u = observableBoolean;
        synchronized (this) {
            this.w |= 1;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9148j);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.w != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.w = 128L;
        }
        requestRebind();
    }

    @Override // us.pinguo.camera2020.f.g
    public void j(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.v = observableBoolean;
        synchronized (this) {
            this.w |= 2;
        }
        notifyPropertyChanged(us.pinguo.camera2020.e.f9149k);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return false;
                            }
                            return l((ObservableBoolean) obj, i3);
                        }
                        return m((ObservableBoolean) obj, i3);
                    }
                    return n((ObservableBoolean) obj, i3);
                }
                return k((ObservableInt) obj, i3);
            }
            return p((ObservableBoolean) obj, i3);
        }
        return o((ObservableBoolean) obj, i3);
    }

    public void q(@Nullable ObservableBoolean observableBoolean) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (us.pinguo.camera2020.e.f9148j == i2) {
            h((ObservableBoolean) obj);
        } else if (us.pinguo.camera2020.e.f9149k == i2) {
            j((ObservableBoolean) obj);
        } else if (us.pinguo.camera2020.e.b == i2) {
            b((ObservableInt) obj);
        } else if (us.pinguo.camera2020.e.f9143e == i2) {
            c((BeautyData) obj);
        } else if (us.pinguo.camera2020.e.f9147i == i2) {
            q((ObservableBoolean) obj);
        } else if (us.pinguo.camera2020.e.f9146h == i2) {
            g((ObservableBoolean) obj);
        } else if (us.pinguo.camera2020.e.f9145g != i2) {
            return false;
        } else {
            f((ObservableBoolean) obj);
        }
        return true;
    }

    private h(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ConstraintLayout) objArr[14], (ConstraintLayout) objArr[20], (FrameLayout) objArr[16], (FrameLayout) objArr[15], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[3], (AppCompatImageView) objArr[1], (AppCompatImageView) objArr[2], (LinearLayout) objArr[22], (LinearLayout) objArr[23], (ConstraintLayout) objArr[0], (RecyclerView) objArr[19], (RecyclerView) objArr[21], (RecyclerView) objArr[18], (RecyclerView) objArr[17], (StickySeekBar) objArr[4], (View) objArr[12], (TextView) objArr[9], (TextView) objArr[11], (TextView) objArr[10], (AutofitTextView) objArr[8], (TextView) objArr[6], (View) objArr[5], (View) objArr[13]);
        this.w = -1L;
        this.c.setTag(null);
        this.f9162d.setTag(null);
        this.f9163e.setTag(null);
        this.f9164f.setTag(null);
        this.f9165g.setTag(null);
        this.f9166h.setTag(null);
        this.f9168j.setTag(null);
        this.f9169k.setTag(null);
        this.f9170l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
