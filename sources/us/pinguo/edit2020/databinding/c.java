package us.pinguo.edit2020.databinding;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import us.pinguo.repository2020.entity.Material;
/* compiled from: ItemBackgroundBlurShapeBinding.java */
/* loaded from: classes4.dex */
public abstract class c extends ViewDataBinding {
    @Bindable
    protected Material a;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public abstract void a(@Nullable Material material);
}
