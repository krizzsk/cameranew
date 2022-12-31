package us.pinguo.camera2020.f;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
/* compiled from: LayoutCellFrameItemBinding.java */
/* loaded from: classes2.dex */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final AppCompatImageView a;
    @NonNull
    public final RelativeLayout b;
    @Bindable
    protected us.pinguo.camera2020.view.s2.a c;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Object obj, View view, int i2, AppCompatImageView appCompatImageView, RelativeLayout relativeLayout) {
        super(obj, view, i2);
        this.a = appCompatImageView;
        this.b = relativeLayout;
    }

    public abstract void a(@Nullable us.pinguo.camera2020.view.s2.a aVar);
}
