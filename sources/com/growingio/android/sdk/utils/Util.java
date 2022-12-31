package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsSeekBar;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.work.PeriodicWorkRequest;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.ActionStruct;
import com.growingio.android.sdk.models.ViewAttrs;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.utils.CustomerInterface;
import com.tencent.smtt.sdk.ValueCallback;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(12)
/* loaded from: classes2.dex */
public class Util {
    private static final int MAX_CONTENT_LENGTH = 100;
    private static Set<Integer> mBlackListId;
    private static SparseArray<String> mIdMap;
    public static final Matcher ID_PATTERN_MATCHER = Pattern.compile("#[\\+\\.a-zA-Z0-9_-]+").matcher("");
    private static LruCache<Class, String> sClassNameCache = new LruCache<>(100);

    public static int calcBannerItemPosition(@NonNull List list, int i2) {
        return i2 % list.size();
    }

    @TargetApi(19)
    public static void callJavaScript(View view, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("try{(function(){");
        sb.append(str);
        sb.append("(");
        int length = objArr.length;
        String str2 = "";
        int i2 = 0;
        while (i2 < length) {
            String str3 = objArr[i2];
            sb.append(str2);
            if (str3 instanceof String) {
                sb.append("'");
                String replace = ((String) str3).replace("'", "'");
                StringBuilder sb2 = new StringBuilder();
                GJSONStringer.stringWithoutQuotation(sb2, replace);
                str3 = sb2.toString();
            }
            sb.append(str3);
            if (str3 instanceof String) {
                sb.append("'");
            }
            i2++;
            str2 = ",";
        }
        sb.append(");})()}catch(ex){console.log(ex);}");
        try {
            String sb3 = sb.toString();
            if (view instanceof WebView) {
                WebView webView = (WebView) view;
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript(sb3, null);
                } else {
                    webView.loadUrl("javascript:" + sb3);
                }
            } else if (ClassExistHelper.instanceOfX5WebView(view)) {
                ((com.tencent.smtt.sdk.WebView) view).evaluateJavascript(sb3, (ValueCallback) null);
            }
        } catch (Exception e2) {
            LogUtil.d("WebView", "call javascript failed ", e2);
        }
    }

    public static int dp2Px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String encryptContent(String str) {
        CustomerInterface.Encryption encryptEntity = CoreInitialize.config().getEncryptEntity();
        if (encryptEntity != null && !TextUtils.isEmpty(str)) {
            try {
                return encryptEntity.encrypt(str);
            } catch (Exception unused) {
                LogUtil.e("加密失败", "V字段加密算法崩溃，传回content");
            }
        }
        return str;
    }

    public static CharSequence getEditTextText(TextView textView) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mText");
            declaredField.setAccessible(true);
            return (CharSequence) declaredField.get(textView);
        } catch (Throwable th) {
            LogUtil.d("Util", th);
            return null;
        }
    }

    public static String getIdName(View view, boolean z) {
        String resourceEntryName;
        Object tag = view.getTag(AbstractGrowingIO.GROWING_VIEW_ID_KEY);
        if (tag instanceof String) {
            return (String) tag;
        }
        if (z) {
            return null;
        }
        if (mIdMap == null) {
            mIdMap = new SparseArray<>();
        }
        if (mBlackListId == null) {
            mBlackListId = new HashSet();
        }
        int id = view.getId();
        if (id > 2130706432 && !mBlackListId.contains(Integer.valueOf(id))) {
            String str = mIdMap.get(id);
            if (str != null) {
                return str;
            }
            synchronized (Util.class) {
                try {
                    try {
                        resourceEntryName = view.getResources().getResourceEntryName(id);
                        mIdMap.put(id, resourceEntryName);
                    } catch (Exception unused) {
                        mBlackListId.add(Integer.valueOf(id));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return resourceEntryName;
        }
        return null;
    }

    public static Throwable getLastCause(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public static Bundle getMetaData(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            return bundle == null ? new Bundle() : bundle;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Can't configure GrowingIO with package name " + packageName, e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r3 == null) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getProcessNameForDB(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 > r2) goto L27
            r2 = 19
            if (r0 < r2) goto L27
            java.lang.String r0 = "android.app.ActivityThread"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L23
            java.lang.String r2 = "currentProcessName"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L23
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r4)     // Catch: java.lang.Exception -> L23
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L23
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L23
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L23
            goto L28
        L23:
            r0 = move-exception
            com.growingio.android.sdk.utils.LogUtil.d(r0)
        L27:
            r0 = r1
        L28:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L7a
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "/proc/"
            r3.append(r4)
            int r4 = android.os.Process.myPid()
            r3.append(r4)
            java.lang.String r4 = "/cmdline"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L72
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L72
        L5f:
            r3.close()     // Catch: java.io.IOException -> L63
            goto L7a
        L63:
            goto L7a
        L65:
            r1 = move-exception
            goto L6c
        L67:
            r5 = move-exception
            goto L74
        L69:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L6c:
            com.growingio.android.sdk.utils.LogUtil.d(r1)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L7a
            goto L5f
        L72:
            r5 = move-exception
            r1 = r3
        L74:
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.io.IOException -> L79
        L79:
            throw r5
        L7a:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L9d
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L8b
            goto L9d
        L8b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = "."
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            return r5
        L9d:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.utils.Util.getProcessNameForDB(android.content.Context):java.lang.String");
    }

    @TargetApi(9)
    public static int getScreenOrientation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (((rotation == 0 || rotation == 2) && i3 > i2) || ((rotation == 1 || rotation == 3) && i2 > i3)) {
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation == 3) {
                            return 8;
                        }
                    }
                    return 9;
                }
                return 0;
            }
            return 1;
        }
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation == 2) {
                    return 8;
                }
                if (rotation == 3) {
                    return 9;
                }
            }
            return 1;
        }
        return 0;
    }

    public static String getSimpleClassName(Class cls) {
        String str = sClassNameCache.get(cls);
        if (TextUtils.isEmpty(str)) {
            str = cls.getSimpleName();
            if (TextUtils.isEmpty(str)) {
                str = ViewNode.ANONYMOUS_CLASS_NAME;
            }
            synchronized (Util.class) {
                sClassNameCache.put(cls, str);
            }
            ClassExistHelper.checkCustomRecyclerView(cls, str);
        }
        return str;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            LogUtil.d("Util", e2);
            return 0;
        }
    }

    public static String getViewContent(View view, String str) {
        CharSequence editTextText;
        Object tag = view.getTag(AbstractGrowingIO.GROWING_CONTENT_KEY);
        if (tag != null) {
            str = String.valueOf(tag);
        } else {
            String str2 = "";
            if (view instanceof EditText) {
                if (view.getTag(AbstractGrowingIO.GROWING_TRACK_TEXT) != null) {
                    EditText editText = (EditText) view;
                    if (!isPasswordInputType(editText.getInputType()) && (editTextText = getEditTextText(editText)) != null) {
                        str2 = editTextText.toString();
                    }
                }
            } else if (view instanceof RatingBar) {
                str2 = String.valueOf(((RatingBar) view).getRating());
            } else if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                Object selectedItem = spinner.getSelectedItem();
                if (selectedItem instanceof String) {
                    str2 = (String) selectedItem;
                } else {
                    View selectedView = spinner.getSelectedView();
                    if (selectedView instanceof TextView) {
                        TextView textView = (TextView) selectedView;
                        if (textView.getText() != null) {
                            str2 = textView.getText().toString();
                        }
                    }
                }
            } else if (view instanceof SeekBar) {
                str2 = String.valueOf(((SeekBar) view).getProgress());
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                View findViewById = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                if (findViewById instanceof RadioButton) {
                    RadioButton radioButton = (RadioButton) findViewById;
                    if (radioButton.getText() != null) {
                        str2 = radioButton.getText().toString();
                    }
                }
            } else if (view instanceof TextView) {
                TextView textView2 = (TextView) view;
                if (textView2.getText() != null) {
                    str2 = textView2.getText().toString();
                }
            } else if (view instanceof ImageView) {
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                }
            } else {
                boolean z = view instanceof WebView;
                if ((z && !WebViewUtil.isDestroyed((WebView) view)) || ClassExistHelper.instanceOfX5WebView(view)) {
                    Object tag2 = view.getTag(AbstractGrowingIO.GROWING_WEB_VIEW_URL);
                    if (tag2 == null) {
                        if (!ThreadUtils.runningOnUiThread()) {
                            postCheckWebViewStatus(view);
                            throw new RuntimeException("WebView getUrl must called on UI Thread");
                        } else if (z) {
                            tag2 = ((WebView) view).getUrl();
                        } else {
                            tag2 = ((com.tencent.smtt.sdk.WebView) view).getUrl();
                        }
                    }
                    if (tag2 instanceof String) {
                        str2 = (String) tag2;
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                if (str == null) {
                    if (view.getContentDescription() != null) {
                        str = view.getContentDescription().toString();
                    }
                }
            }
            str = str2;
        }
        return truncateViewContent(str);
    }

    @TargetApi(14)
    public static String getViewName(View view) {
        return ((view instanceof Switch) || (view instanceof ToggleButton)) ? "开关" : view instanceof CheckBox ? "复选框" : view instanceof RadioGroup ? "单选框" : view instanceof Button ? "按钮" : view instanceof EditText ? "输入框" : view instanceof ImageView ? "图片" : ((view instanceof WebView) || ClassExistHelper.instanceOfX5WebView(view)) ? "H5元素" : view instanceof TextView ? "文字" : "其他元素";
    }

    public static void getVisibleRectOnScreen(View view, Rect rect, boolean z, int[] iArr) {
        if (z) {
            view.getGlobalVisibleRect(rect);
            return;
        }
        if (iArr == null || iArr.length != 2) {
            iArr = new int[2];
        }
        view.getLocationOnScreen(iArr);
        rect.set(0, 0, view.getWidth(), view.getHeight());
        rect.offset(iArr[0], iArr[1]);
    }

    public static boolean isHttpUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(Constants.HTTP_PROTOCOL_PREFIX);
    }

    public static boolean isHttpsUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX);
    }

    public static boolean isIdentifyPatternServerXPath(String str, String str2) {
        if (str == null || str2 == null) {
            return str == str2;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < str2.length()) {
            if (i3 == str.length()) {
                return false;
            }
            char charAt = str.charAt(i3);
            char charAt2 = str2.charAt(i2);
            if (charAt == charAt2) {
                i3++;
            } else if (charAt != '*' || (('0' > charAt2 && charAt2 != '-') || charAt2 > '9')) {
                if (charAt != '*' || charAt2 != ']') {
                    return false;
                }
                i3++;
                i2--;
            }
            i2++;
        }
        return i3 == str.length();
    }

    public static boolean isIdentifyXPath(String str, String str2) {
        if (str.charAt(0) == '*') {
            if (GConfig.USE_ID) {
                return str2.endsWith(str.substring(1));
            }
            return false;
        } else if (str.charAt(0) == '/') {
            return isIdentifyPatternServerXPath(str, str2) || str.equals(ID_PATTERN_MATCHER.reset(str2).replaceAll(""));
        } else {
            return false;
        }
    }

    public static boolean isIgnoredView(View view) {
        return view.getTag(AbstractGrowingIO.GROWING_IGNORE_VIEW_KEY) != null;
    }

    public static boolean isInSampling(String str, double d2) {
        char[] charArray;
        if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        if (d2 >= 0.9999d) {
            return true;
        }
        long j2 = (long) ((d2 + (1.0f / ((float) 100000))) * 100000);
        long j3 = 1;
        for (int length = md5(str).toCharArray().length - 1; length >= 0; length--) {
            j3 = ((j3 * 256) + charArray[length]) % 100000;
        }
        return j3 < j2;
    }

    public static boolean isInstant(JSONObject jSONObject, ArrayList<ViewAttrs> arrayList, String str) throws JSONException {
        String str2;
        String str3;
        Iterator<ViewAttrs> it = arrayList.iterator();
        while (it.hasNext()) {
            ViewAttrs next = it.next();
            if (next.webElem && next.domain.equals(str) && ((str2 = next.xpath) == null || isIdentifyXPath(str2, jSONObject.getString("x")))) {
                String str4 = next.index;
                if (str4 == null || str4.equals(String.valueOf(jSONObject.optInt("idx", -1)))) {
                    String str5 = next.content;
                    if (str5 == null || str5.equals(jSONObject.optString("v"))) {
                        String str6 = next.href;
                        if (str6 == null) {
                            return true;
                        }
                        if (str6.equals(jSONObject.optString(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H)) && ((str3 = next.query) == null || str3.equals(jSONObject.optString("q")))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isListView(View view) {
        return (view instanceof AdapterView) || ClassExistHelper.instanceOfAndroidXRecyclerView(view) || ClassExistHelper.instanceOfAndroidXViewPager(view) || ClassExistHelper.instanceOfSupportRecyclerView(view) || ClassExistHelper.instanceOfSupportViewPager(view);
    }

    public static boolean isPackageManagerDiedException(Throwable th) {
        Throwable lastCause;
        if (!(th instanceof RuntimeException) || th.getMessage() == null || (!(th.getMessage().contains("Package manager has died") || th.getMessage().contains("DeadSystemException")) || (lastCause = getLastCause(th)) == null)) {
            return false;
        }
        return (lastCause instanceof DeadObjectException) || lastCause.getClass().getName().equals("android.os.TransactionTooLargeException");
    }

    @TargetApi(11)
    public static boolean isPasswordInputType(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18 || i3 == 145;
    }

    public static boolean isTrackWebView(View view) {
        return view.getTag(AbstractGrowingIO.GROWING_TRACK_WEB_VIEW) != null;
    }

    public static boolean isViewClickable(View view) {
        return view.isClickable() || (view instanceof RadioGroup) || (view instanceof Spinner) || (view instanceof AbsSeekBar) || (view.getParent() != null && (view.getParent() instanceof AdapterView) && ((AdapterView) view.getParent()).isClickable());
    }

    @TargetApi(9)
    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.adjust.sdk.Constants.MD5);
            messageDigest.update(str.getBytes(Charset.forName("US-ASCII")), 0, str.length());
            byte[] digest = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, digest);
            return String.format("%0" + (digest.length << 1) + "x", bigInteger);
        } catch (Throwable th) {
            LogUtil.d("util", th);
            return "";
        }
    }

    private static void postCheckWebViewStatus(final View view) {
        LogUtil.d("GIO.Util", "postCheckWebViewStatus: ", view);
        ThreadUtils.postOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.utils.Util.1
            @Override // java.lang.Runnable
            public void run() {
                String url;
                View view2 = view;
                if (view2 instanceof WebView) {
                    url = ((WebView) view2).getUrl();
                } else {
                    url = ClassExistHelper.instanceOfX5WebView(view2) ? view.getUrl() : null;
                }
                if (url != null) {
                    view.setTag(AbstractGrowingIO.GROWING_WEB_VIEW_URL, url);
                }
            }
        });
    }

    @TargetApi(9)
    public static void saveToFile(byte[] bArr, String str) throws IOException {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    LogUtil.i("Util", e2.getMessage());
                }
                file.setReadable(true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        LogUtil.i("Util", e3.getMessage());
                    }
                    file.setReadable(true);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void sendMessage(Handler handler, int i2, Object... objArr) {
        if (handler != null) {
            handler.obtainMessage(i2, objArr).sendToTarget();
        }
    }

    public static boolean shouldSetLocation(double d2, double d3, double d4, double d5, long j2, long j3) {
        double abs = Math.abs(d2 - d4) + Math.abs(d3 - d5);
        if (abs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        return abs > 0.05d || j2 - j3 > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public static int sp2Px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static String truncateViewContent(String str) {
        if (str == null) {
            return "";
        }
        if (!TextUtils.isEmpty(str) && str.length() > 100) {
            str = str.substring(0, 100);
        }
        return encryptContent(str);
    }

    public static void getVisibleRectOnScreen(View view, Rect rect, boolean z) {
        getVisibleRectOnScreen(view, rect, z, null);
    }

    public static boolean isInstant(ActionStruct actionStruct, ArrayList<ViewAttrs> arrayList) {
        Iterator<ViewAttrs> it = arrayList.iterator();
        while (it.hasNext()) {
            ViewAttrs next = it.next();
            if (!next.webElem) {
                String str = next.xpath;
                if (str != null) {
                    LinkedString linkedString = actionStruct.xpath;
                    if (!isIdentifyXPath(str, linkedString == null ? null : linkedString.toStringValue())) {
                        continue;
                    }
                }
                String str2 = next.index;
                if (str2 == null || str2.equals(String.valueOf(actionStruct.index))) {
                    String str3 = next.content;
                    if (str3 == null || str3.equals(actionStruct.content)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @TargetApi(9)
    public static void saveToFile(InputStream inputStream, String str) throws IOException {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                int read = inputStream.read(bArr);
                while (read > 0) {
                    fileOutputStream2.write(bArr, 0, read);
                    read = inputStream.read(bArr);
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    LogUtil.d("Util", e2);
                }
                file.setReadable(true);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        LogUtil.d("Util", e3);
                    }
                    file.setReadable(true);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
