package us.pinguo.advsdk.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
/* loaded from: classes3.dex */
public class GlobalProvider extends ContentProvider {
    public static Uri b;
    private SharedPreferences a;

    private static void a(Context context) {
        if (b == null) {
            b = Uri.parse("content://" + context.getApplicationContext().getPackageName() + ".GlobalProvider");
        }
    }

    public static int d(Context context, String str, int i2) {
        Cursor h2 = h(context, str);
        if (h2 == null) {
            return i2;
        }
        if (h2.moveToNext()) {
            try {
                i2 = h2.getInt(0);
            } catch (Exception unused) {
            }
        }
        h2.close();
        return i2;
    }

    public static long e(Context context, String str, long j2) {
        Cursor h2 = h(context, str);
        if (h2 == null) {
            return j2;
        }
        if (h2.moveToNext()) {
            try {
                j2 = h2.getLong(0);
            } catch (Exception unused) {
            }
        }
        h2.close();
        return j2;
    }

    public static String f(Context context, String str, String str2) {
        Cursor h2 = h(context, str);
        if (h2 == null) {
            return str2;
        }
        if (h2.moveToNext()) {
            String string = h2.getString(0);
            if (!TextUtils.isEmpty(string)) {
                str2 = string;
            }
        }
        h2.close();
        return str2;
    }

    public static Cursor h(Context context, String... strArr) {
        a(context);
        try {
            return context.getContentResolver().query(b, strArr, null, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Uri j(Context context, ContentValues contentValues) {
        a(context);
        try {
            return context.getContentResolver().insert(b, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Uri k(Context context, String str, long j2) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(str, Long.valueOf(j2));
        return j(context, contentValues);
    }

    public static Uri l(Context context, String str, String str2) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(str, str2);
        return j(context, contentValues);
    }

    protected Cursor b(String[] strArr, String[] strArr2) {
        MatrixCursor matrixCursor = new MatrixCursor(strArr, 1);
        matrixCursor.addRow(strArr2);
        return matrixCursor;
    }

    protected Cursor c(String str, String str2) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{str}, 1);
        if (!TextUtils.isEmpty(str2)) {
            matrixCursor.addRow(new Object[]{str2});
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String queryParameter = str == null ? null : uri.getQueryParameter("key");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        i(queryParameter);
        return 1;
    }

    protected String g(String str, String str2) {
        return this.a.getString(str, str2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "";
    }

    protected void i(String str) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove(str);
        edit.apply();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() > 0) {
            m(contentValues);
            return null;
        }
        String queryParameter = uri.getQueryParameter("key");
        String queryParameter2 = uri.getQueryParameter(FirebaseAnalytics.Param.VALUE);
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        n(queryParameter, queryParameter2);
        return null;
    }

    protected void m(ContentValues contentValues) {
        SharedPreferences.Editor edit = this.a.edit();
        for (String str : contentValues.keySet()) {
            String asString = contentValues.getAsString(str);
            if (!TextUtils.isEmpty(str)) {
                if (asString != null) {
                    edit.putString(str, asString);
                } else {
                    edit.remove(str);
                }
            }
        }
        edit.apply();
    }

    protected void n(String str, String str2) {
        SharedPreferences.Editor edit = this.a.edit();
        if (str2 != null) {
            edit.putString(str, str2);
        } else {
            edit.remove(str);
        }
        edit.apply();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            this.a = getContext().getSharedPreferences("adv_global.sp", 0);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int length = strArr == null ? 0 : strArr.length;
        if (length > 0) {
            String[] strArr3 = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr3[i2] = g(strArr[i2], null);
            }
            return b(strArr, strArr3);
        }
        String queryParameter = uri.getQueryParameter("key");
        return c(queryParameter, TextUtils.isEmpty(queryParameter) ? null : g(queryParameter, null));
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues != null && contentValues.size() > 0) {
            m(contentValues);
            return contentValues.size();
        }
        String queryParameter = uri.getQueryParameter("key");
        String queryParameter2 = uri.getQueryParameter(FirebaseAnalytics.Param.VALUE);
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        n(queryParameter, queryParameter2);
        return 1;
    }
}
