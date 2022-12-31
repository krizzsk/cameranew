package us.pinguo.commonui.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
/* compiled from: ItemStyleMakeupNoneBinding.java */
/* loaded from: classes4.dex */
public abstract class e extends ViewDataBinding {
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final ImageView b;
    @Bindable
    protected ObservableBoolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Object obj, View view, int i2, FrameLayout frameLayout, ImageView imageView) {
        super(obj, view, i2);
        this.a = frameLayout;
        this.b = imageView;
    }

    public abstract void a(@Nullable ObservableBoolean observableBoolean);
}
