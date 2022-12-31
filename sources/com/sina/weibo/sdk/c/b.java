package com.sina.weibo.sdk.c;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.File;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes3.dex */
public final class b {
    public static boolean a(Context context, Uri uri) {
        String c = c(context, uri);
        if (!TextUtils.isEmpty(c)) {
            File file = new File(c);
            if (b(file)) {
                return false;
            }
            String a = a(file);
            return !TextUtils.isEmpty(a) && a.startsWith("image/");
        }
        throw new IllegalArgumentException("get image path is null");
    }

    public static boolean b(Context context, Uri uri) {
        String str;
        String c = c(context, uri);
        if (!TextUtils.isEmpty(c)) {
            File file = new File(c);
            if (b(file)) {
                return false;
            }
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                String substring = name.substring(lastIndexOf);
                if (!TextUtils.isEmpty(substring) || substring.length() >= 2) {
                    str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1).toLowerCase());
                    return TextUtils.isEmpty(str) && str.startsWith("video/");
                }
            }
            str = "*/*";
            if (TextUtils.isEmpty(str)) {
            }
        }
        throw new IllegalArgumentException("get video path is null");
    }

    @TargetApi(19)
    private static String c(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
            } else {
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = split2[0];
                    if (QiniuAuthToken.TYPE_IMAGE.equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return a(context, uri2, "_id=?", new String[]{split2[1]});
                }
            }
        } else if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                return uri.getLastPathSegment();
            }
            return d(context, uri);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String d(Context context, Uri uri) {
        String uri2 = uri.toString();
        return new File(context.getExternalFilesDir(null), uri2.substring(uri2.lastIndexOf("/"))).getAbsolutePath();
    }

    public static long e(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        }
        return 0L;
    }

    private static String a(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(absolutePath, options);
            String str = options.outMimeType;
            if (!str.contains("jpg") && !str.contains(Emoticon.TYPE_GIF) && !str.contains(Emoticon.TYPE_PNG)) {
                if (!str.contains("jpeg")) {
                    return null;
                }
            }
            return "image/*";
        } catch (Exception unused) {
            return "*/*";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r7 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r7 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        return d(r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            if (r7 == 0) goto L2b
            boolean r10 = r7.moveToFirst()     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            if (r10 == 0) goto L2b
            int r10 = r7.getColumnIndexOrThrow(r0)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            java.lang.String r8 = r7.getString(r10)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2e
            if (r7 == 0) goto L28
            r7.close()
        L28:
            return r8
        L29:
            goto L35
        L2b:
            if (r7 == 0) goto L3a
            goto L37
        L2e:
            r8 = move-exception
            if (r7 == 0) goto L34
            r7.close()
        L34:
            throw r8
        L35:
            if (r7 == 0) goto L3a
        L37:
            r7.close()
        L3a:
            java.lang.String r8 = d(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.c.b.a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    private static boolean b(File file) {
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
}
