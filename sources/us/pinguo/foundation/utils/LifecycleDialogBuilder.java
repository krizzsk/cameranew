package us.pinguo.foundation.utils;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import java.lang.reflect.Field;
/* compiled from: LifecycleAwareDialog.kt */
/* loaded from: classes4.dex */
public final class LifecycleDialogBuilder extends AlertDialog.Builder {
    private boolean a;
    private DialogInterface.OnCancelListener b;
    private DialogInterface.OnDismissListener c;

    /* renamed from: d  reason: collision with root package name */
    private DialogInterface.OnKeyListener f11103d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleDialogBuilder(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: a */
    public LifecycleAwareDialog create() {
        Class superclass = LifecycleDialogBuilder.class.getSuperclass();
        Field declaredField = superclass == null ? null : superclass.getDeclaredField("mTheme");
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        Object obj = declaredField == null ? null : declaredField.get(this);
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int intValue = num == null ? 0 : num.intValue();
        Context context = getContext();
        kotlin.jvm.internal.s.g(context, "context");
        LifecycleAwareDialog lifecycleAwareDialog = new LifecycleAwareDialog(context, intValue);
        Field declaredField2 = superclass == null ? null : superclass.getDeclaredField("P");
        if (declaredField2 == null) {
            return lifecycleAwareDialog;
        }
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(this);
        if (obj2 == null) {
            return lifecycleAwareDialog;
        }
        Class<?> cls = obj2.getClass();
        Class superclass2 = LifecycleAwareDialog.class.getSuperclass();
        Field declaredField3 = superclass2 != null ? superclass2.getDeclaredField("mAlert") : null;
        if (declaredField3 == null) {
            return lifecycleAwareDialog;
        }
        declaredField3.setAccessible(true);
        Object obj3 = declaredField3.get(lifecycleAwareDialog);
        cls.getDeclaredMethod("apply", obj3.getClass()).invoke(obj2, obj3);
        lifecycleAwareDialog.setCancelable(this.a);
        if (this.a) {
            lifecycleAwareDialog.setCanceledOnTouchOutside(true);
        }
        lifecycleAwareDialog.setOnCancelListener(this.b);
        lifecycleAwareDialog.setOnDismissListener(this.c);
        DialogInterface.OnKeyListener onKeyListener = this.f11103d;
        if (onKeyListener != null) {
            lifecycleAwareDialog.setOnKeyListener(onKeyListener);
        }
        return lifecycleAwareDialog;
    }

    public LifecycleDialogBuilder b(boolean z) {
        this.a = z;
        super.setCancelable(z);
        return this;
    }

    public LifecycleDialogBuilder c(DialogInterface.OnCancelListener onCancelListener) {
        this.b = onCancelListener;
        super.setOnCancelListener(onCancelListener);
        return this;
    }

    public LifecycleDialogBuilder d(DialogInterface.OnDismissListener onDismissListener) {
        this.c = onDismissListener;
        super.setOnDismissListener(onDismissListener);
        return this;
    }

    public LifecycleDialogBuilder e(DialogInterface.OnKeyListener onKeyListener) {
        this.f11103d = onKeyListener;
        super.setOnKeyListener(onKeyListener);
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: f */
    public LifecycleAwareDialog show() {
        LifecycleAwareDialog create = create();
        create.show();
        return create;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setCancelable(boolean z) {
        b(z);
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        c(onCancelListener);
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        d(onDismissListener);
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        e(onKeyListener);
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleDialogBuilder(Context context, int i2) {
        super(context, i2);
        kotlin.jvm.internal.s.h(context, "context");
    }
}
