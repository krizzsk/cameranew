package cn.sharesdk.framework.loopshare.watermark;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Pair;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.h;
import com.mob.tools.log.NLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
/* loaded from: classes.dex */
public class FirstPic {

    /* loaded from: classes.dex */
    public interface AnalyzeCallback {
        void onAnalyzeFailed();

        void onAnalyzeSuccess(Bitmap bitmap, String str);
    }

    public static void a(final Context context, final ReadQrImageListener readQrImageListener) {
        if (Build.VERSION.SDK_INT <= 24) {
            if (readQrImageListener != null) {
                readQrImageListener.onFailed(new Throwable("The minimum version supported for this feature is 7.0"), -2);
                return;
            }
            return;
        }
        if (context == null) {
            if (readQrImageListener == null) {
                return;
            }
            readQrImageListener.onFailed(new Throwable("Please set Contenxt"), -4);
        }
        new Thread() { // from class: cn.sharesdk.framework.loopshare.watermark.FirstPic.1
            /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: all -> 0x008b, TryCatch #0 {all -> 0x008b, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x0011, B:12:0x0021, B:14:0x0047, B:18:0x005e, B:15:0x004f, B:17:0x0053, B:19:0x007b, B:21:0x007f, B:9:0x0018), top: B:28:0x0004 }] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x007b A[Catch: all -> 0x008b, TryCatch #0 {all -> 0x008b, blocks: (B:3:0x0004, B:5:0x000a, B:8:0x0011, B:12:0x0021, B:14:0x0047, B:18:0x005e, B:15:0x004f, B:17:0x0053, B:19:0x007b, B:21:0x007f, B:9:0x0018), top: B:28:0x0004 }] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r9 = this;
                    java.lang.String r0 = "ShareSDK"
                    r1 = 0
                    r2 = 1
                    boolean r3 = cn.sharesdk.framework.loopshare.watermark.e.b()     // Catch: java.lang.Throwable -> L8b
                    if (r3 != 0) goto L18
                    boolean r3 = cn.sharesdk.framework.loopshare.watermark.e.a()     // Catch: java.lang.Throwable -> L8b
                    if (r3 == 0) goto L11
                    goto L18
                L11:
                    android.content.Context r3 = r1     // Catch: java.lang.Throwable -> L8b
                    android.util.Pair r3 = cn.sharesdk.framework.loopshare.watermark.FirstPic.b(r3)     // Catch: java.lang.Throwable -> L8b
                    goto L1e
                L18:
                    android.content.Context r3 = r1     // Catch: java.lang.Throwable -> L8b
                    android.util.Pair r3 = cn.sharesdk.framework.loopshare.watermark.FirstPic.a(r3)     // Catch: java.lang.Throwable -> L8b
                L1e:
                    r4 = -1
                    if (r3 == 0) goto L7b
                    java.lang.Object r3 = r3.second     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L8b
                    com.mob.tools.log.NLog r5 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L8b
                    java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L8b
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
                    r7.<init>()     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r8 = " 相册第一张图片的路径为: "
                    r7.append(r8)     // Catch: java.lang.Throwable -> L8b
                    r7.append(r3)     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L8b
                    r6[r1] = r7     // Catch: java.lang.Throwable -> L8b
                    r5.d(r0, r6)     // Catch: java.lang.Throwable -> L8b
                    boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L8b
                    if (r5 != 0) goto L4f
                    android.content.Context r4 = r1     // Catch: java.lang.Throwable -> L8b
                    cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener r5 = r2     // Catch: java.lang.Throwable -> L8b
                    cn.sharesdk.framework.loopshare.watermark.FirstPic.a(r4, r3, r5)     // Catch: java.lang.Throwable -> L8b
                    goto L5e
                L4f:
                    cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener r5 = r2     // Catch: java.lang.Throwable -> L8b
                    if (r5 == 0) goto L5e
                    java.lang.Throwable r6 = new java.lang.Throwable     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r7 = "读取相册图片失败"
                    r6.<init>(r7)     // Catch: java.lang.Throwable -> L8b
                    r5.onFailed(r6, r4)     // Catch: java.lang.Throwable -> L8b
                L5e:
                    com.mob.tools.log.NLog r4 = cn.sharesdk.framework.utils.SSDKLog.b()     // Catch: java.lang.Throwable -> L8b
                    java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L8b
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
                    r6.<init>()     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r7 = "pairPath: "
                    r6.append(r7)     // Catch: java.lang.Throwable -> L8b
                    r6.append(r3)     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L8b
                    r5[r1] = r3     // Catch: java.lang.Throwable -> L8b
                    r4.d(r0, r5)     // Catch: java.lang.Throwable -> L8b
                    goto Lb1
                L7b:
                    cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener r3 = r2     // Catch: java.lang.Throwable -> L8b
                    if (r3 == 0) goto Lb1
                    java.lang.Throwable r5 = new java.lang.Throwable     // Catch: java.lang.Throwable -> L8b
                    java.lang.String r6 = "读取截屏相册图片失败，请检查是否有图片"
                    r5.<init>(r6)     // Catch: java.lang.Throwable -> L8b
                    r3.onFailed(r5, r4)     // Catch: java.lang.Throwable -> L8b
                    goto Lb1
                L8b:
                    r3 = move-exception
                    com.mob.tools.log.NLog r4 = cn.sharesdk.framework.utils.SSDKLog.b()
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "解析二维码异常 "
                    r5.append(r6)
                    r5.append(r3)
                    java.lang.String r5 = r5.toString()
                    r2[r1] = r5
                    r4.e(r0, r2)
                    cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener r0 = r2
                    if (r0 == 0) goto Lb1
                    r1 = -3
                    r0.onFailed(r3, r1)
                Lb1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.loopshare.watermark.FirstPic.AnonymousClass1.run():void");
            }
        }.start();
    }

    public static Pair<Long, String> b(Context context) {
        try {
            String c = c();
            String[] strArr = {"_data", "date_modified"};
            String[] strArr2 = {a(Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera")};
            String[] strArr3 = {a(c)};
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "bucket_id = ?", strArr2, "date_modified DESC");
            Pair<Long, String> pair = query.moveToFirst() ? new Pair<>(Long.valueOf(query.getLong(query.getColumnIndex("date_modified"))), query.getString(query.getColumnIndex("_data"))) : null;
            Cursor query2 = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "bucket_id = ?", strArr3, "date_modified DESC");
            Pair<Long, String> pair2 = query2.moveToFirst() ? new Pair<>(Long.valueOf(query2.getLong(query2.getColumnIndex("date_modified"))), query2.getString(query2.getColumnIndex("_data"))) : null;
            if (!query2.isClosed()) {
                query2.close();
            }
            if (pair != null && pair2 != null) {
                return ((Long) pair.first).longValue() > ((Long) pair2.first).longValue() ? pair : pair2;
            } else if (pair == null || pair2 != null) {
                if (pair != null || pair2 == null) {
                    return null;
                }
                return pair2;
            } else {
                return pair;
            }
        } catch (Throwable th) {
            SSDKLog.b().w("getLatestPhoto catch: " + th);
            return null;
        }
    }

    private static String c() {
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM/Screenshots";
        if (new File(str).exists()) {
            return str;
        }
        return Environment.getExternalStorageDirectory().toString() + "/Pictures/Screenshots";
    }

    public static Pair<Long, String> a(Context context) {
        String a;
        try {
            if (e.b()) {
                a = b();
            } else {
                a = e.a() ? a() : null;
            }
            String[] strArr = {"_data", "date_modified"};
            String[] strArr2 = {a(a)};
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "bucket_id = ?", strArr2, "date_modified DESC");
            if (query.moveToFirst()) {
                new Pair(Long.valueOf(query.getLong(query.getColumnIndex("date_modified"))), query.getString(query.getColumnIndex("_data")));
            }
            Cursor query2 = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "bucket_id = ?", strArr2, "date_modified DESC");
            Pair<Long, String> pair = query2.moveToFirst() ? new Pair<>(Long.valueOf(query2.getLong(query2.getColumnIndex("date_modified"))), query2.getString(query2.getColumnIndex("_data"))) : null;
            if (!query2.isClosed()) {
                query2.close();
            }
            if (pair != null) {
                return pair;
            }
            return null;
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.w("getOVLatestPhoto catch: " + th);
            return null;
        }
    }

    private static String b() {
        return Environment.getExternalStorageDirectory().toString() + "/Screenshot";
    }

    private static String a(String str) {
        return String.valueOf(str.toLowerCase().hashCode());
    }

    private static String a() {
        return Environment.getExternalStorageDirectory().toString() + "/Pictures/Screenshots";
    }

    private static Bitmap a(Context context, Uri uri, ReadQrImageListener readQrImageListener) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (IOException e2) {
            if (readQrImageListener != null) {
                SSDKLog.b().e(OnekeyShare.SHARESDK_TAG, " getBitmapFromPath catch ");
                readQrImageListener.onFailed(e2, -1);
                return null;
            }
            return null;
        }
    }

    public static Uri a(Context context, String str) {
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            int i2 = query.getInt(query.getColumnIndex("_id"));
            Uri parse = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(parse, "" + i2);
        } else if (new File(str).exists()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            return null;
        }
    }

    public static void a(Context context, String str, ReadQrImageListener readQrImageListener) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap a = a(context, a(context, str), readQrImageListener);
        options.inJustDecodeBounds = false;
        int i2 = (int) (options.outHeight / 400.0f);
        options.inSampleSize = i2 > 0 ? i2 : 1;
        a(a, readQrImageListener);
    }

    public static void a(Bitmap bitmap, ReadQrImageListener readQrImageListener) {
        if (bitmap == null && readQrImageListener != null) {
            readQrImageListener.onFailed(new Throwable("读取相册图片失败"), -1);
            return;
        }
        Bitmap a = a(bitmap);
        int width = a.getWidth();
        int height = a.getHeight();
        int[] iArr = new int[width * height];
        a.getPixels(iArr, 0, width, 0, 0, width, height);
        com.google.zxing.n.a aVar = new com.google.zxing.n.a();
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        DecodeHintType decodeHintType = DecodeHintType.TRY_HARDER;
        Boolean bool = Boolean.TRUE;
        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) bool);
        enumMap.put((EnumMap) DecodeHintType.PURE_BARCODE, (DecodeHintType) bool);
        enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) "utf-8");
        try {
            com.google.zxing.g a2 = aVar.a(new com.google.zxing.b(new h(new com.google.zxing.f(width, height, iArr))));
            if (readQrImageListener != null) {
                readQrImageListener.onSucessed(a2.b());
            }
        } catch (ChecksumException e2) {
            NLog b = SSDKLog.b();
            b.e(OnekeyShare.SHARESDK_TAG, "解析二维码异常 " + e2);
            if (readQrImageListener != null) {
                readQrImageListener.onFailed(e2, -3);
            }
        } catch (FormatException e3) {
            NLog b2 = SSDKLog.b();
            b2.e(OnekeyShare.SHARESDK_TAG, "解析二维码异常 " + e3);
            if (readQrImageListener != null) {
                readQrImageListener.onFailed(e3, -3);
            }
        } catch (NotFoundException e4) {
            NLog b3 = SSDKLog.b();
            b3.e(OnekeyShare.SHARESDK_TAG, "解析二维码异常 " + e4);
            if (readQrImageListener != null) {
                readQrImageListener.onFailed(e4, -3);
            }
        } catch (Throwable th) {
            NLog b4 = SSDKLog.b();
            b4.e(OnekeyShare.SHARESDK_TAG, "解析二维码异常 " + th);
            if (readQrImageListener != null) {
                readQrImageListener.onFailed(th, -3);
            }
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        int i2 = 90;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 50) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            i2 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }
}
