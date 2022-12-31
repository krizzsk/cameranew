package com.facebook.core.internal.logging.dumpsys;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.facebook.core.internal.logging.dumpsys.AndroidRootResolver;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: EndToEndDumpsysHelper.java */
@SuppressLint({"HexColorValueUsage", "CatchGeneralException", "BadMethodUse-java.lang.String.length"})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f2422d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static Method f2423e;
    private final AndroidRootResolver a = new AndroidRootResolver();
    private final c b = new c();
    @Nullable
    private Method c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EndToEndDumpsysHelper.java */
    /* renamed from: com.facebook.core.internal.logging.dumpsys.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0089a {
        @Nullable
        private static Field a;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        @Nullable
        private static JSONObject a(View view) {
            try {
                if (a == null) {
                    Field declaredField = View.class.getDeclaredField("mKeyedTags");
                    a = declaredField;
                    declaredField.setAccessible(true);
                }
                SparseArray sparseArray = (SparseArray) a.get(view);
                if (sparseArray == null || sparseArray.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    int size = sparseArray.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            jSONObject.put(com.facebook.core.internal.logging.dumpsys.b.c(view.getContext(), view.getResources(), sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
                        } catch (JSONException unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                return jSONObject;
            } catch (Exception unused3) {
                return null;
            }
        }

        static void b(PrintWriter printWriter, View view) {
            AccessibilityNodeInfo c;
            if (Build.VERSION.SDK_INT >= 21 && (c = a.c(view)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        jSONObject.put("textColor", textView.getTextColors().getDefaultColor());
                        jSONObject.put("textSize", textView.getTextSize());
                        jSONObject.put(TrackReferenceTypeBox.TYPE1, a.f(textView.getHint(), 100));
                    }
                    JSONObject a2 = a(view);
                    if (a2 != null) {
                        jSONObject.put("keyedTags", a2);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (AccessibilityNodeInfo.AccessibilityAction accessibilityAction : c.getActionList()) {
                        String str = (String) accessibilityAction.getLabel();
                        if (str != null) {
                            jSONArray.put(a.f(str, 50));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    String f2 = a.f(c.getContentDescription(), 50);
                    if (f2 != null && f2.length() > 0) {
                        jSONObject.put("content-description", f2);
                    }
                    jSONObject.put("accessibility-focused", c.isAccessibilityFocused()).put("checkable", c.isCheckable()).put("checked", c.isChecked()).put("class-name", a.f(c.getClassName(), 50)).put(TJAdUnitConstants.String.CLICKABLE, c.isClickable()).put("content-invalid", c.isContentInvalid()).put("dismissable", c.isDismissable()).put("editable", c.isEditable()).put(TJAdUnitConstants.String.ENABLED, c.isEnabled()).put("focusable", c.isFocusable()).put("focused", c.isFocused()).put("long-clickable", c.isLongClickable()).put("multiline", c.isMultiLine()).put("password", c.isPassword()).put("scrollable", c.isScrollable()).put("selected", c.isSelected()).put("visible-to-user", c.isVisibleToUser());
                    if (Build.VERSION.SDK_INT >= 24) {
                        b.a(jSONObject, c);
                    }
                } catch (Exception e2) {
                    try {
                        jSONObject.put("DUMP-ERROR", a.f(e2.getMessage(), 50));
                    } catch (JSONException unused) {
                    }
                }
                printWriter.append(" props=\"").append((CharSequence) jSONObject.toString()).append("\"");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EndToEndDumpsysHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        static void a(JSONObject jSONObject, AccessibilityNodeInfo accessibilityNodeInfo) throws JSONException {
            if (Build.VERSION.SDK_INT < 24) {
                return;
            }
            jSONObject.put("context-clickable", accessibilityNodeInfo.isContextClickable()).put("drawing-order", accessibilityNodeInfo.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfo.isImportantForAccessibility());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static AccessibilityNodeInfo c(View view) {
        if (view == null) {
            return null;
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        try {
            view.onInitializeAccessibilityNodeInfo(obtain);
            return obtain;
        } catch (NullPointerException unused) {
            if (obtain != null) {
                obtain.recycle();
            }
            return null;
        }
    }

    private void d(String str, PrintWriter printWriter, @Nullable View view, int i2, int i3, boolean z, boolean z2) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.print(view.getClass().getName());
        printWriter.print("{");
        printWriter.print(Integer.toHexString(view.hashCode()));
        n(printWriter, view);
        m(printWriter, view, i2, i3);
        o(printWriter, view);
        p(printWriter, view);
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            C0089a.b(printWriter, view);
        }
        printWriter.println("}");
        if (i(view)) {
            l(printWriter, view, str, z2);
        }
        if (z && (view instanceof WebView)) {
            this.b.d((WebView) view);
        }
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + "  ";
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            for (int i4 = 0; i4 < childCount; i4++) {
                d(str2, printWriter, viewGroup.getChildAt(i4), iArr[0], iArr[1], z, z2);
            }
        }
    }

    private void e(String str, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        printWriter.print(str2);
        printWriter.println("Top Level Window View Hierarchy:");
        boolean h2 = h(strArr, "all-roots");
        boolean h3 = h(strArr, "top-root");
        boolean h4 = h(strArr, "webview");
        boolean h5 = h(strArr, "props");
        try {
            List<AndroidRootResolver.c> b2 = this.a.b();
            if (b2 != null && !b2.isEmpty()) {
                Collections.reverse(b2);
                WindowManager.LayoutParams layoutParams = null;
                for (AndroidRootResolver.c cVar : b2) {
                    if (cVar.a.getVisibility() == 0) {
                        if (!h2 && layoutParams != null && Math.abs(cVar.b.type - layoutParams.type) != 1) {
                            break;
                        }
                        d(str2 + "  ", printWriter, cVar.a, 0, 0, h4, h5);
                        layoutParams = cVar.b;
                        if (h3) {
                            break;
                        }
                        str2 = str;
                    }
                }
                this.b.b(printWriter);
            }
        } catch (Exception e2) {
            printWriter.println("Failure in view hierarchy dump: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(@Nullable CharSequence charSequence, int i2) {
        if (charSequence == null || charSequence.length() < 1) {
            return "";
        }
        String replace = charSequence.toString().replace(" \n", " ").replace("\n", " ").replace("\"", "");
        if (charSequence.length() > i2) {
            return replace.substring(0, i2) + "...";
        }
        return replace;
    }

    @Nullable
    @SuppressLint({"PrivateApi", "ReflectionMethodUse"})
    private static String g(View view) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (f2423e == null) {
            f2423e = view.getClass().getDeclaredMethod("getText", new Class[0]);
        }
        Object invoke = f2423e.invoke(view, new Object[0]);
        if (invoke != null) {
            return invoke.toString();
        }
        return null;
    }

    private static boolean h(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean i(View view) {
        for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (cls.getName().equals("com.facebook.litho.LithoView")) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(String str, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length <= 0 || !"e2e".equals(strArr[0])) {
            return false;
        }
        if (f2422d == null) {
            f2422d = new a();
        }
        f2422d.e(str, printWriter, strArr);
        return true;
    }

    private static void k(PrintWriter printWriter, View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            String str = (String) tag;
            if (str.length() <= 0) {
                return;
            }
            printWriter.print(" app:tag/");
            printWriter.print(f(str, 60));
        }
    }

    private void l(PrintWriter printWriter, View view, String str, boolean z) {
        try {
            if (this.c == null) {
                this.c = Class.forName("com.facebook.litho.LithoViewTestHelper").getDeclaredMethod("viewToStringForE2E", View.class, Integer.TYPE, Boolean.TYPE);
            }
            printWriter.append((CharSequence) ((String) this.c.invoke(null, view, Integer.valueOf((str.length() / 2) + 1), Boolean.valueOf(z))));
        } catch (Exception e2) {
            printWriter.append((CharSequence) str).append("Failed litho view sub hierarch dump: ").append((CharSequence) f(e2.getMessage(), 100)).println();
        }
    }

    private static void m(PrintWriter printWriter, View view, int i2, int i3) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        printWriter.print(" ");
        printWriter.print(iArr[0] - i2);
        printWriter.print(",");
        printWriter.print(iArr[1] - i3);
        printWriter.print(PGTransHeader.CONNECTOR);
        printWriter.print((iArr[0] + view.getWidth()) - i2);
        printWriter.print(",");
        printWriter.print((iArr[1] + view.getHeight()) - i3);
    }

    private static void n(PrintWriter printWriter, View view) {
        printWriter.print(" ");
        int visibility = view.getVisibility();
        String str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        if (visibility == 0) {
            printWriter.print(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        } else if (visibility == 4) {
            printWriter.print("I");
        } else if (visibility != 8) {
            printWriter.print(".");
        } else {
            printWriter.print("G");
        }
        printWriter.print(view.isFocusable() ? "F" : ".");
        printWriter.print(view.isEnabled() ? ExifInterface.LONGITUDE_EAST : ".");
        printWriter.print(".");
        printWriter.print(view.isHorizontalScrollBarEnabled() ? "H" : ".");
        if (!view.isVerticalScrollBarEnabled()) {
            str = ".";
        }
        printWriter.print(str);
        printWriter.print(view.isClickable() ? "C" : ".");
        printWriter.print(view.isLongClickable() ? "L" : ".");
        printWriter.print(" ");
        printWriter.print(view.isFocused() ? "F" : ".");
        printWriter.print(view.isSelected() ? ExifInterface.LATITUDE_SOUTH : ".");
        printWriter.print(view.isHovered() ? "H" : ".");
        printWriter.print(view.isActivated() ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ".");
        printWriter.print(view.isDirty() ? "D" : ".");
    }

    private static void o(PrintWriter printWriter, View view) {
        String str;
        try {
            int id = view.getId();
            if (id == -1) {
                k(printWriter, view);
                return;
            }
            printWriter.append(" #");
            printWriter.append((CharSequence) Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id > 0 && resources != null) {
                int i2 = (-16777216) & id;
                if (i2 != 16777216) {
                    str = i2 != 2130706432 ? resources.getResourcePackageName(id) : "app";
                } else {
                    str = TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE;
                }
                printWriter.print(" ");
                printWriter.print(str);
                printWriter.print(":");
                printWriter.print(resources.getResourceTypeName(id));
                printWriter.print("/");
                printWriter.print(resources.getResourceEntryName(id));
                return;
            }
            k(printWriter, view);
        } catch (Exception unused) {
            k(printWriter, view);
        }
    }

    @SuppressLint({"ReflectionMethodUse"})
    private static void p(PrintWriter printWriter, View view) {
        Object tag;
        String trim;
        try {
            if (view instanceof TextView) {
                trim = ((TextView) view).getText().toString();
            } else if (view.getClass().getSimpleName().equals("RCTextView")) {
                trim = g(view);
            } else {
                CharSequence contentDescription = view.getContentDescription();
                String charSequence = contentDescription != null ? contentDescription.toString() : null;
                trim = ((charSequence == null || charSequence.isEmpty()) && (tag = view.getTag()) != null) ? tag.toString().trim() : charSequence;
            }
            if (trim != null && !trim.isEmpty()) {
                printWriter.print(" text=\"");
                printWriter.print(f(trim, 600));
                printWriter.print("\"");
            }
        } catch (Exception unused) {
        }
    }
}
