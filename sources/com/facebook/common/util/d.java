package com.facebook.common.util;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nullable;
/* compiled from: UriUtil.java */
/* loaded from: classes.dex */
public class d {
    private static final Uri a;

    static {
        Uri uri = ContactsContract.AUTHORITY_URI;
        com.facebook.infer.annotation.a.a(uri);
        a = Uri.withAppendedPath(uri, "display_photo");
    }

    @Nullable
    public static AssetFileDescriptor a(ContentResolver contentResolver, Uri uri) {
        if (j(uri)) {
            try {
                return contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Nullable
    public static String b(ContentResolver contentResolver, Uri uri) {
        int columnIndex;
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        String string = null;
        if (j(uri)) {
            try {
                Cursor query = contentResolver.query(uri, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                            string = query.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                    return string;
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } else if (k(uri)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    @Nullable
    public static String c(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static Uri d(File file) {
        return Uri.fromFile(file);
    }

    public static Uri e(int i2) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i2)).build();
    }

    public static boolean f(@Nullable Uri uri) {
        return "data".equals(c(uri));
    }

    public static boolean g(@Nullable Uri uri) {
        return "asset".equals(c(uri));
    }

    public static boolean h(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean i(Uri uri) {
        if (uri.getPath() != null && j(uri) && "com.android.contacts".equals(uri.getAuthority())) {
            String path = uri.getPath();
            String path2 = a.getPath();
            com.facebook.infer.annotation.a.a(path2);
            return !path.startsWith(path2);
        }
        return false;
    }

    public static boolean j(@Nullable Uri uri) {
        return FirebaseAnalytics.Param.CONTENT.equals(c(uri));
    }

    public static boolean k(@Nullable Uri uri) {
        return "file".equals(c(uri));
    }

    public static boolean l(@Nullable Uri uri) {
        return "res".equals(c(uri));
    }

    public static boolean m(@Nullable Uri uri) {
        String c = c(uri);
        return "https".equals(c) || "http".equals(c);
    }

    public static boolean n(@Nullable Uri uri) {
        return "android.resource".equals(c(uri));
    }

    @Nullable
    public static URL o(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }
}
