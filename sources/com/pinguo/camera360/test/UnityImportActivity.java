package com.pinguo.camera360.test;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.z0;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* compiled from: UnityImportActivity.kt */
/* loaded from: classes3.dex */
public final class UnityImportActivity extends BaseActivity {
    private AlertDialog b;
    private String[] c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f6977d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean[] f6978e;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f6979f = "/sdcard/Camera360/unity/";

    /* renamed from: g  reason: collision with root package name */
    private final Paint f6980g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    private float f6981h = 2.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(UnityImportActivity this$0, View view, boolean z) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (z) {
            return;
        }
        this$0.f6979f = this$0.w0(((EditText) this$0._$_findCachedViewById(R.id.unity_dir)).getText().toString());
        ((TextView) this$0._$_findCachedViewById(R.id.unity_info)).setText(this$0.v0(this$0.f6979f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(Boolean[] bools, DialogInterface dialogInterface, int i2, boolean z) {
        kotlin.jvm.internal.s.h(bools, "$bools");
        bools[i2] = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(UnityImportActivity this$0, String[] zips, Boolean[] bools, String[] names, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(zips, "$zips");
        kotlin.jvm.internal.s.h(bools, "$bools");
        kotlin.jvm.internal.s.h(names, "$names");
        this$0.c = zips;
        this$0.f6978e = bools;
        this$0.f6977d = names;
        StringBuilder sb = new StringBuilder();
        int length = zips.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            Boolean bool = bools[i3];
            if (bool != null && bool.booleanValue()) {
                sb.append(this$0.z0(this$0.f6979f, zips[i3]));
                sb.append('\n');
            }
            i3 = i4;
        }
        ((TextView) this$0._$_findCachedViewById(R.id.unity_import_paths)).setText(sb);
        ((Button) this$0._$_findCachedViewById(R.id.unity_import)).setEnabled(this$0.r0(this$0.f6978e));
        AlertDialog alertDialog = this$0.b;
        if (alertDialog == null) {
            return;
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(UnityImportActivity this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        AlertDialog alertDialog = this$0.b;
        if (alertDialog == null) {
            return;
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N0(File file, String name) {
        boolean m;
        kotlin.jvm.internal.s.g(name, "name");
        m = kotlin.text.t.m(name, ".zip", false, 2, null);
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(List unityList, final UnityImportActivity this$0) {
        kotlin.jvm.internal.s.h(unityList, "$unityList");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Iterator it = unityList.iterator();
        while (it.hasNext()) {
            final v0 v0Var = (v0) it.next();
            this$0.x0(v0Var);
            this$0.runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.k0
                @Override // java.lang.Runnable
                public final void run() {
                    UnityImportActivity.P0(UnityImportActivity.this, v0Var);
                }
            });
        }
        this$0.runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.test.q0
            @Override // java.lang.Runnable
            public final void run() {
                UnityImportActivity.Q0(UnityImportActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(UnityImportActivity this$0, v0 unityInfo) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(unityInfo, "$unityInfo");
        ((TextView) this$0._$_findCachedViewById(R.id.unity_info)).append(kotlin.jvm.internal.s.q(unityInfo.a(), "  import success!!\n"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(UnityImportActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.isDestroyed()) {
            return;
        }
        Toast makeText = Toast.makeText(this$0, "素材全部导入完成", 1);
        makeText.show();
        VdsAgent.showToast(makeText);
        ((Button) this$0._$_findCachedViewById(R.id.unity_import)).setEnabled(true);
        ((Button) this$0._$_findCachedViewById(R.id.unity_select)).setEnabled(true);
        ((EditText) this$0._$_findCachedViewById(R.id.unity_dir)).setEnabled(true);
    }

    private final List<String> s0(String[] strArr) {
        int o;
        boolean x;
        ArrayList<String> arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            String substring = str.substring(0, str.length() - 4);
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
        }
        o = kotlin.collections.v.o(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(o);
        for (String str2 : arrayList) {
            x = kotlin.text.t.x(str2, "unity_", false, 2, null);
            if (x) {
                str2 = str2.substring(6);
                kotlin.jvm.internal.s.g(str2, "this as java.lang.String).substring(startIndex)");
            }
            arrayList2.add(str2);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap t0(String str) {
        int i2;
        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = new Rect();
        this.f6980g.setTextSize(this.f6981h * 3);
        this.f6980g.getTextBounds(str, 0, str.length(), rect);
        int i3 = 1;
        if (((float) rect.width()) > ((float) rect.height()) * 2.5f) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            this.f6980g.getTextBounds(str, 0, 0, rect);
            this.f6980g.getTextBounds(str, 0, str.length(), rect2);
            while (rect.width() < rect2.width() && (i2 = i3 + 1) < str.length()) {
                this.f6980g.getTextBounds(str, 0, i3, rect);
                this.f6980g.getTextBounds(str, i3, str.length(), rect2);
                i3 = i2;
            }
            int i4 = i3 - 1;
            this.f6980g.getTextBounds(str, 0, i4, rect);
            while (rect.width() < 160) {
                Paint paint = this.f6980g;
                paint.setTextSize(paint.getTextSize() + this.f6981h);
                this.f6980g.getTextBounds(str, 0, i4, rect);
            }
            while (rect.width() > 180) {
                Paint paint2 = this.f6980g;
                paint2.setTextSize(paint2.getTextSize() - this.f6981h);
                this.f6980g.getTextBounds(str, 0, i4, rect);
            }
            this.f6980g.getTextBounds(str, 0, i4, rect);
            this.f6980g.getTextBounds(str, i4, str.length(), rect2);
            String substring = str.substring(0, i4);
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            canvas.drawText(substring, ((200 - rect.width()) / 2) - rect.left, (100 - rect.height()) - rect.top, this.f6980g);
            String substring2 = str.substring(i4);
            kotlin.jvm.internal.s.g(substring2, "this as java.lang.String).substring(startIndex)");
            canvas.drawText(substring2, ((200 - rect2.width()) / 2) - rect2.left, 100 - rect2.top, this.f6980g);
        } else {
            while (rect.width() < 180 && rect.height() < 60) {
                Paint paint3 = this.f6980g;
                paint3.setTextSize(paint3.getTextSize() + this.f6981h);
                this.f6980g.getTextBounds(str, 0, str.length(), rect);
            }
            while (true) {
                if (rect.width() <= 190 && rect.height() <= 90) {
                    break;
                }
                Paint paint4 = this.f6980g;
                paint4.setTextSize(paint4.getTextSize() - this.f6981h);
                this.f6980g.getTextBounds(str, 0, str.length(), rect);
            }
            canvas.drawText(str, ((200 - rect.width()) / 2) - rect.left, ((200 - rect.height()) / 2) - rect.top, this.f6980g);
        }
        kotlin.jvm.internal.s.g(bitmap, "bitmap");
        return bitmap;
    }

    private final void y0() {
        this.f6980g.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f2 = getResources().getDisplayMetrics().density;
        this.f6981h = f2;
        this.f6980g.setTextSize(f2 * 3);
        this.f6980g.setAntiAlias(true);
        this.f6980g.setStrokeWidth(this.f6981h);
    }

    public final void J0(View view, final String[] zips) {
        kotlin.jvm.internal.s.h(view, "view");
        kotlin.jvm.internal.s.h(zips, "zips");
        Object[] array = s0(zips).toArray(new String[0]);
        kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final String[] strArr = (String[]) array;
        final Boolean[] boolArr = new Boolean[zips.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择安装的素材");
        builder.setMultiChoiceItems(strArr, (boolean[]) null, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.pinguo.camera360.test.n0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                UnityImportActivity.K0(boolArr, dialogInterface, i2, z);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.test.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UnityImportActivity.L0(UnityImportActivity.this, zips, boolArr, strArr, dialogInterface, i2);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.test.m0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UnityImportActivity.M0(UnityImportActivity.this, dialogInterface, i2);
            }
        });
        AlertDialog create = builder.create();
        this.b = create;
        if (create == null) {
            return;
        }
        create.show();
        VdsAgent.showDialog(create);
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_unity_import);
        ((TextView) _$_findCachedViewById(R.id.unity_info)).setText(v0(this.f6979f));
        ((Button) _$_findCachedViewById(R.id.unity_import)).setEnabled(false);
        ((EditText) _$_findCachedViewById(R.id.unity_dir)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pinguo.camera360.test.p0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                UnityImportActivity.I0(UnityImportActivity.this, view, z);
            }
        });
        y0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.camera360.shop.data.i.e().s();
    }

    public final boolean r0(Boolean[] boolArr) {
        if (boolArr == null) {
            return false;
        }
        int length = boolArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Boolean bool = boolArr[i2];
            if (bool != null && bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<v0> u0(String[] strArr, String[] strArr2, Boolean[] boolArr) {
        List<v0> h2;
        List<v0> h3;
        List<v0> h4;
        if (boolArr == null) {
            h4 = kotlin.collections.u.h();
            return h4;
        } else if (strArr == null) {
            h3 = kotlin.collections.u.h();
            return h3;
        } else if (strArr2 == null) {
            h2 = kotlin.collections.u.h();
            return h2;
        } else if (boolArr.length == strArr.length && strArr.length == strArr2.length) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int length = boolArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                Boolean bool = boolArr[i2];
                if (bool != null && bool.booleanValue()) {
                    arrayList.add(new v0(strArr[i2], z0(this.f6979f, strArr2[i2])));
                }
                i2 = i3;
            }
            return arrayList;
        } else {
            throw new IllegalArgumentException("error size, pls check!");
        }
    }

    public final void unityImport(View view) {
        kotlin.jvm.internal.s.h(view, "view");
        this.f6979f = w0(((EditText) _$_findCachedViewById(R.id.unity_dir)).getText().toString());
        ((TextView) _$_findCachedViewById(R.id.unity_info)).setText(v0(this.f6979f));
        File file = new File(this.f6979f);
        if (!file.exists()) {
            Toast makeText = Toast.makeText(this, kotlin.jvm.internal.s.q("找不到文件夹", this.f6979f), 0);
            makeText.show();
            VdsAgent.showToast(makeText);
            return;
        }
        String[] zips = file.list(o0.a);
        kotlin.jvm.internal.s.g(zips, "zips");
        if (zips.length == 0) {
            Toast makeText2 = Toast.makeText(this, "没有需要安装的素材", 0);
            makeText2.show();
            VdsAgent.showToast(makeText2);
            return;
        }
        J0(view, zips);
    }

    public final void unityInstall(View view) {
        kotlin.jvm.internal.s.h(view, "view");
        final List<v0> u0 = u0(this.f6977d, this.c, this.f6978e);
        if (u0.isEmpty()) {
            Toast makeText = Toast.makeText(this, "无导入的数据", 0);
            makeText.show();
            VdsAgent.showToast(makeText);
            return;
        }
        ((Button) _$_findCachedViewById(R.id.unity_import)).setEnabled(false);
        ((Button) _$_findCachedViewById(R.id.unity_select)).setEnabled(false);
        ((EditText) _$_findCachedViewById(R.id.unity_dir)).setEnabled(false);
        ((TextView) _$_findCachedViewById(R.id.unity_info)).setText("");
        new Thread(new Runnable() { // from class: com.pinguo.camera360.test.j0
            @Override // java.lang.Runnable
            public final void run() {
                UnityImportActivity.O0(u0, this);
            }
        }).start();
    }

    public final String v0(String path) {
        kotlin.jvm.internal.s.h(path, "path");
        return "请将Unity素材放在【" + path + "】下";
    }

    public final String w0(String dir) {
        kotlin.jvm.internal.s.h(dir, "dir");
        return TextUtils.isEmpty(dir) ? "/sdcard/Camera360/unity/" : dir.charAt(0) == '/' ? dir : kotlin.jvm.internal.s.q("/sdcard/", dir);
    }

    public final void x0(v0 info) {
        kotlin.jvm.internal.s.h(info, "info");
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new UnityImportActivity$import$1(info, this, null), 3, null);
    }

    public final String z0(String root, String name) {
        boolean m;
        kotlin.jvm.internal.s.h(root, "root");
        kotlin.jvm.internal.s.h(name, "name");
        m = kotlin.text.t.m(root, "/", false, 2, null);
        if (m) {
            return kotlin.jvm.internal.s.q(root, name);
        }
        return root + '/' + name;
    }
}
