package us.pinguo.edit2020.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableInt;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import kotlin.jvm.internal.s;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.common.widget.WaterFillingView;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.entity.Material;
/* compiled from: PaintMaterialBindingAdapter.kt */
/* loaded from: classes4.dex */
public final class PaintMaterialBindingAdapter {
    @BindingAdapter({"isSelected"})
    public static final void a(ConstraintLayout view, boolean z) {
        s.h(view, "view");
        if (z) {
            view.setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.white));
        } else {
            view.setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.transparent));
        }
    }

    @BindingAdapter({"materialMask"})
    public static final void b(View view, boolean z) {
        s.h(view, "view");
        int i2 = z ? 0 : 4;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ac, code lost:
        if (r0 == true) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    @androidx.databinding.BindingAdapter({"paintMaterialIcon"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(com.facebook.drawee.view.SimpleDraweeView r8, us.pinguo.repository2020.entity.Material r9) {
        /*
            java.lang.String r0 = "view"
            kotlin.jvm.internal.s.h(r8, r0)
            java.lang.String r0 = "paintMaterial"
            kotlin.jvm.internal.s.h(r9, r0)
            us.pinguo.repository2020.manager.MaterialDataManager r0 = us.pinguo.repository2020.manager.MaterialDataManager.a
            us.pinguo.repository2020.s r0 = r0.d()
            java.util.ArrayList r0 = r0.a()
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L22
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L22
        L20:
            r0 = 0
            goto L41
        L22:
            java.util.Iterator r0 = r0.iterator()
        L26:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L20
            java.lang.Object r1 = r0.next()
            us.pinguo.repository2020.entity.Mosaic r1 = (us.pinguo.repository2020.entity.Mosaic) r1
            java.lang.String r1 = r1.getPid()
            java.lang.String r4 = r9.getPid()
            boolean r1 = kotlin.jvm.internal.s.c(r1, r4)
            if (r1 == 0) goto L26
            r0 = 1
        L41:
            java.lang.String r1 = "drawable"
            if (r0 == 0) goto L5e
            android.content.res.Resources r0 = r8.getResources()
            java.lang.String r9 = r9.getPid()
            android.content.Context r2 = r8.getContext()
            java.lang.String r2 = r2.getPackageName()
            int r9 = r0.getIdentifier(r9, r1, r2)
            r8.setImageResource(r9)
            goto Le0
        L5e:
            com.facebook.drawee.generic.b r0 = new com.facebook.drawee.generic.b
            android.content.res.Resources r4 = r8.getResources()
            r0.<init>(r4)
            com.facebook.drawee.generic.a r0 = r0.a()
            int r4 = us.pinguo.edit2020.R.drawable.ic_placeholder_logo
            r0.y(r4)
            r0.B(r4)
            r8.setHierarchy(r0)
            java.lang.String r0 = r9.getIcon()
            r4 = 0
            r5 = 2
            if (r0 != 0) goto L80
        L7e:
            r0 = 0
            goto L89
        L80:
            java.lang.String r6 = "https://"
            boolean r0 = kotlin.text.l.C(r0, r6, r3, r5, r4)
            if (r0 != r2) goto L7e
            r0 = 1
        L89:
            if (r0 == 0) goto L93
            java.lang.String r9 = r9.getIcon()
            r8.setImageURI(r9)
            goto Le0
        L93:
            java.lang.String r0 = r9.getIcon()
            if (r0 != 0) goto L9b
        L99:
            r2 = 0
            goto Lae
        L9b:
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r6 = r6.getAbsolutePath()
            java.lang.String r7 = "getExternalStorageDirectory().absolutePath"
            kotlin.jvm.internal.s.g(r6, r7)
            boolean r0 = kotlin.text.l.C(r0, r6, r3, r5, r4)
            if (r0 != r2) goto L99
        Lae:
            if (r2 == 0) goto Lc9
            java.lang.String r9 = r9.getIcon()
            java.lang.String r0 = "file:///"
            java.lang.String r9 = kotlin.jvm.internal.s.q(r0, r9)
            android.net.Uri r9 = android.net.Uri.parse(r9)
            com.facebook.imagepipeline.core.h r0 = com.facebook.drawee.backends.pipeline.c.a()
            r0.a(r9)
            r8.setImageURI(r9)
            goto Le0
        Lc9:
            android.content.res.Resources r0 = r8.getResources()
            java.lang.String r9 = r9.getIcon()
            android.content.Context r2 = r8.getContext()
            java.lang.String r2 = r2.getPackageName()
            int r9 = r0.getIdentifier(r9, r1, r2)
            r8.setImageResource(r9)
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.PaintMaterialBindingAdapter.c(com.facebook.drawee.view.SimpleDraweeView, us.pinguo.repository2020.entity.Material):void");
    }

    @BindingAdapter({"progress"})
    public static final void d(FilterPackageDownloadView view, ObservableInt observableInt) {
        s.h(view, "view");
        view.setDownloadProgress(observableInt == null ? 0 : observableInt.get());
    }

    @BindingAdapter({"blurMaterialIcon", "blurProgress", "isSelected"})
    public static final void e(WaterFillingView view, Material material, Integer num, Boolean bool) {
        s.h(view, "view");
        s.h(material, "material");
        String icon = material.getIcon();
        if (icon == null) {
            return;
        }
        us.pinguo.util.e.a.h(icon, new PaintMaterialBindingAdapter$setBlurMaterialIcon$1(view, num, bool));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        if (r0 == true) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
    @androidx.databinding.BindingAdapter({"blurShapeIcon", "isSelected"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(com.facebook.drawee.view.SimpleDraweeView r7, us.pinguo.repository2020.entity.Material r8, java.lang.Boolean r9) {
        /*
            java.lang.String r0 = "view"
            kotlin.jvm.internal.s.h(r7, r0)
            java.lang.String r0 = "paintMaterial"
            kotlin.jvm.internal.s.h(r8, r0)
            com.facebook.drawee.generic.b r0 = new com.facebook.drawee.generic.b
            android.content.res.Resources r1 = r7.getResources()
            r0.<init>(r1)
            com.facebook.drawee.generic.a r0 = r0.a()
            int r1 = us.pinguo.edit2020.R.drawable.ic_placeholder_logo
            r0.y(r1)
            r0.B(r1)
            r7.setHierarchy(r0)
            java.lang.String r0 = r8.getIcon()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L2e
        L2c:
            r0 = 0
            goto L37
        L2e:
            java.lang.String r5 = "https://"
            boolean r0 = kotlin.text.l.C(r0, r5, r4, r2, r1)
            if (r0 != r3) goto L2c
            r0 = 1
        L37:
            if (r0 == 0) goto L41
            java.lang.String r8 = r8.getIcon()
            r7.setImageURI(r8)
            goto L85
        L41:
            java.lang.String r0 = r8.getIcon()
            if (r0 != 0) goto L49
        L47:
            r3 = 0
            goto L5c
        L49:
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.String r6 = "getExternalStorageDirectory().absolutePath"
            kotlin.jvm.internal.s.g(r5, r6)
            boolean r0 = kotlin.text.l.C(r0, r5, r4, r2, r1)
            if (r0 != r3) goto L47
        L5c:
            if (r3 == 0) goto L6c
            java.lang.String r8 = r8.getIcon()
            java.lang.String r0 = "file:///"
            java.lang.String r8 = kotlin.jvm.internal.s.q(r0, r8)
            r7.setImageURI(r8)
            goto L85
        L6c:
            android.content.res.Resources r0 = r7.getResources()
            java.lang.String r8 = r8.getIcon()
            android.content.Context r1 = r7.getContext()
            java.lang.String r1 = r1.getPackageName()
            java.lang.String r2 = "drawable"
            int r8 = r0.getIdentifier(r8, r2, r1)
            r7.setImageResource(r8)
        L85:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r8 = kotlin.jvm.internal.s.c(r9, r8)
            if (r8 == 0) goto L94
            int r8 = us.pinguo.edit2020.R.color.color_camera_theme_black
            int r8 = us.pinguo.edit2020.utils.d.h(r8)
            goto L9a
        L94:
            int r8 = us.pinguo.edit2020.R.color.color_camera_theme_dark
            int r8 = us.pinguo.edit2020.utils.d.h(r8)
        L9a:
            android.graphics.drawable.Drawable r9 = r7.getDrawable()
            r9.setTint(r8)
            int r9 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r9 < r0) goto Lae
            android.content.res.ColorStateList r8 = android.content.res.ColorStateList.valueOf(r8)
            r7.setForegroundTintList(r8)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.databinding.PaintMaterialBindingAdapter.f(com.facebook.drawee.view.SimpleDraweeView, us.pinguo.repository2020.entity.Material, java.lang.Boolean):void");
    }

    @BindingAdapter({"isDark", "isSelected"})
    public static final void g(TextView view, boolean z, boolean z2) {
        s.h(view, "view");
        if (!z2) {
            view.setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_dark));
        } else if (z) {
            view.setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_black));
        } else {
            view.setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_light));
        }
    }

    @BindingAdapter({TJAdUnitConstants.String.VISIBLE})
    public static final void h(View view, boolean z) {
        s.h(view, "view");
        int i2 = z ? 0 : 8;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }
}
