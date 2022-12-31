package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class DataBindingUtil {
    private static DataBinderMapper sMapper = new DataBinderMapperImpl();
    private static DataBindingComponent sDefaultComponent = null;

    private DataBindingUtil() {
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view) {
        return (T) bind(view, sDefaultComponent);
    }

    private static <T extends ViewDataBinding> T bindToAddedViews(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i2, int i3) {
        int childCount = viewGroup.getChildCount();
        int i4 = childCount - i2;
        if (i4 == 1) {
            return (T) bind(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i3);
        }
        View[] viewArr = new View[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            viewArr[i5] = viewGroup.getChildAt(i5 + i2);
        }
        return (T) bind(dataBindingComponent, viewArr, i3);
    }

    @Nullable
    public static String convertBrIdToString(int i2) {
        return sMapper.convertBrIdToString(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r3 == (-1)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1.indexOf(47, r3 + 1) == (-1)) goto L15;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T extends androidx.databinding.ViewDataBinding> T findBinding(@androidx.annotation.NonNull android.view.View r9) {
        /*
        L0:
            r0 = 0
            if (r9 == 0) goto L5a
            androidx.databinding.ViewDataBinding r1 = androidx.databinding.ViewDataBinding.getBinding(r9)
            if (r1 == 0) goto La
            return r1
        La:
            java.lang.Object r1 = r9.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L4d
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "layout"
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L4d
            java.lang.String r2 = "_0"
            boolean r2 = r1.endsWith(r2)
            if (r2 == 0) goto L4d
            r2 = 6
            char r2 = r1.charAt(r2)
            r3 = 7
            r4 = 47
            int r3 = r1.indexOf(r4, r3)
            r5 = 1
            r6 = -1
            r7 = 0
            if (r2 != r4) goto L3b
            if (r3 != r6) goto L38
            goto L39
        L38:
            r5 = 0
        L39:
            r7 = r5
            goto L4a
        L3b:
            r8 = 45
            if (r2 != r8) goto L4a
            if (r3 == r6) goto L4a
            int r3 = r3 + 1
            int r1 = r1.indexOf(r4, r3)
            if (r1 != r6) goto L38
            goto L39
        L4a:
            if (r7 == 0) goto L4d
            return r0
        L4d:
            android.view.ViewParent r9 = r9.getParent()
            boolean r1 = r9 instanceof android.view.View
            if (r1 == 0) goto L58
            android.view.View r9 = (android.view.View) r9
            goto L0
        L58:
            r9 = r0
            goto L0
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.DataBindingUtil.findBinding(android.view.View):androidx.databinding.ViewDataBinding");
    }

    @Nullable
    public static <T extends ViewDataBinding> T getBinding(@NonNull View view) {
        return (T) ViewDataBinding.getBinding(view);
    }

    @Nullable
    public static DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i2, @Nullable ViewGroup viewGroup, boolean z) {
        return (T) inflate(layoutInflater, i2, viewGroup, z, sDefaultComponent);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i2) {
        return (T) setContentView(activity, i2, sDefaultComponent);
    }

    public static void setDefaultComponent(@Nullable DataBindingComponent dataBindingComponent) {
        sDefaultComponent = dataBindingComponent;
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view, DataBindingComponent dataBindingComponent) {
        T t = (T) getBinding(view);
        if (t != null) {
            return t;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            int layoutId = sMapper.getLayoutId((String) tag);
            if (layoutId != 0) {
                return (T) sMapper.getDataBinder(dataBindingComponent, view, layoutId);
            }
            throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
        }
        throw new IllegalArgumentException("View is not a binding layout");
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i2, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        boolean z2 = viewGroup != null && z;
        int childCount = z2 ? viewGroup.getChildCount() : 0;
        View inflate = layoutInflater.inflate(i2, viewGroup, z);
        if (z2) {
            return (T) bindToAddedViews(dataBindingComponent, viewGroup, childCount, i2);
        }
        return (T) bind(dataBindingComponent, inflate, i2);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i2, @Nullable DataBindingComponent dataBindingComponent) {
        activity.setContentView(i2);
        return (T) bindToAddedViews(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        return (T) sMapper.getDataBinder(dataBindingComponent, viewArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View view, int i2) {
        return (T) sMapper.getDataBinder(dataBindingComponent, view, i2);
    }
}
