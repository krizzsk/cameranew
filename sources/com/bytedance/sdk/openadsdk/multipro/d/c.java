package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
/* compiled from: SPMultiProviderImpl.java */
/* loaded from: classes.dex */
public class c implements com.bytedance.sdk.openadsdk.multipro.a {
    private Context a;

    private Context c() {
        Context context = this.a;
        return context == null ? o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_sp";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Map<String, ?> b;
        if (!uri.getPath().split("/")[2].equals("get_all") || (b = b.b(c(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : b.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            objArr[2] = b.get(str3);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = TypedValues.Custom.S_BOOLEAN;
            } else if (objArr[2] instanceof String) {
                objArr[1] = TypedValues.Custom.S_STRING;
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = Constants.LONG;
            } else if (objArr[2] instanceof Float) {
                objArr[1] = TypedValues.Custom.S_FLOAT;
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            return b.a(o.a(), uri.getQueryParameter("sp_file_name"), str2) + "";
        }
        return "" + b.a(c(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        Object obj = contentValues.get(FirebaseAnalytics.Param.VALUE);
        if (obj != null) {
            b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[2].equals("clean")) {
            b.a(c(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[2];
        if (b.a(c(), uri.getQueryParameter("sp_file_name"), str2)) {
            b.b(c(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        a(uri, contentValues);
        return 0;
    }
}
