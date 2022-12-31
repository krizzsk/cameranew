package com.mob.tools.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.mob.tools.MobLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public class BitmapHelper {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static int maxBitmapHeight;
    private static int maxBitmapWidth;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapWidth = max;
        maxBitmapHeight = max;
    }

    public static Bitmap blur(Bitmap bitmap, int i2, int i3) {
        float f2 = i3;
        Bitmap createBitmap = Bitmap.createBitmap((int) ((bitmap.getWidth() / f2) + 0.5f), (int) ((bitmap.getHeight() / f2) + 0.5f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f3 = 1.0f / f2;
        canvas.scale(f3, f3);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        blur(createBitmap, (int) ((i2 / f2) + 0.5f), true);
        return createBitmap;
    }

    private static boolean bytesStartWith(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static Bitmap captureView(View view, int i2, int i3) throws Throwable {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i2) {
        return compressByQuality(bitmap, i2, false);
    }

    public static Bitmap cropBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5) throws Throwable {
        int width = (bitmap.getWidth() - i2) - i4;
        int height = (bitmap.getHeight() - i3) - i5;
        if (width == bitmap.getWidth() && height == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, -i2, -i3, new Paint());
        return createBitmap;
    }

    public static String downloadBitmap(Context context, final String str) throws Throwable {
        final String cachePath = ResHelper.getCachePath(context, "images");
        File file = new File(cachePath, Data.MD5(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        final HashMap hashMap = new HashMap();
        new NetworkHelper().rawGet(str, new HttpResponseCallback() { // from class: com.mob.tools.utils.BitmapHelper.1
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode == 200) {
                    String fileName = BitmapHelper.getFileName(httpConnection, str);
                    File file2 = new File(cachePath, fileName);
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        Bitmap bitmap = BitmapHelper.getBitmap(new FilterInputStream(httpConnection.getInputStream()) { // from class: com.mob.tools.utils.BitmapHelper.1.1
                            @Override // java.io.FilterInputStream, java.io.InputStream
                            public long skip(long j2) throws IOException {
                                long j3 = 0;
                                while (j3 < j2) {
                                    long skip = ((FilterInputStream) this).in.skip(j2 - j3);
                                    if (skip == 0) {
                                        break;
                                    }
                                    j3 += skip;
                                }
                                return j3;
                            }
                        }, 1);
                        if (bitmap == null || bitmap.isRecycled()) {
                            return;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        if (!fileName.toLowerCase().endsWith(".gif") && !fileName.toLowerCase().endsWith(".png")) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                        } else {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        hashMap.put("bitmap", file2.getAbsolutePath());
                        return;
                    } catch (Throwable th) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        throw th;
                    }
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("error", sb.toString());
                hashMap2.put("status", Integer.valueOf(responseCode));
                throw new Throwable(new Hashon().fromHashMap(hashMap2));
            }
        }, (NetworkHelper.NetworkTimeOut) null);
        return (String) hashMap.get("bitmap");
    }

    public static int[] fixRect(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        if (iArr[0] / iArr[1] > iArr2[0] / iArr2[1]) {
            iArr3[0] = iArr2[0];
            iArr3[1] = (int) (((iArr[1] * iArr2[0]) / iArr[0]) + 0.5f);
        } else {
            iArr3[1] = iArr2[1];
            iArr3[0] = (int) (((iArr[0] * iArr2[1]) / iArr[1]) + 0.5f);
        }
        return iArr3;
    }

    public static int[] fixRect_2(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[2];
        if (iArr[0] / iArr[1] > iArr2[0] / iArr2[1]) {
            iArr3[1] = iArr2[1];
            iArr3[0] = (int) (((iArr[0] * iArr2[1]) / iArr[1]) + 0.5f);
        } else {
            iArr3[0] = iArr2[0];
            iArr3[1] = (int) (((iArr[1] * iArr2[0]) / iArr[0]) + 0.5f);
        }
        return iArr3;
    }

    public static Bitmap getBitmap(String str, int i2) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmap(new File(str), i2);
    }

    public static Bitmap getBitmapByCompressQuality(String str, int i2, int i3, int i4, long j2) throws Throwable {
        Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i2, i3);
        i4 = (i4 < 10 || i4 > 100) ? 100 : 100;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
        bitmapByCompressSize.compress(bmpFormat, i4, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (j2 < 10240) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused) {
            }
            return decodeByteArray;
        }
        while (byteArray.length > j2 && i4 >= 11) {
            byteArrayOutputStream.reset();
            i4 -= 6;
            bitmapByCompressSize.compress(bmpFormat, i4, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        if (i4 != 100) {
            bitmapByCompressSize = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable unused2) {
        }
        return bitmapByCompressSize;
    }

    public static Bitmap getBitmapByCompressSize(String str, int i2, int i3) throws Throwable {
        int i4;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        if (i2 <= 1 || i3 <= 1) {
            i4 = 1;
        } else {
            float f2 = 1.0f;
            float min = (Math.min(i5, i6) * 1.0f) / Math.min(i2, i3);
            float max = (Math.max(i5, i6) * 1.0f) / Math.max(i2, i3);
            float f3 = i5 / i6;
            if (f3 <= 2.0f && f3 >= 0.5d) {
                float min2 = Math.min(min, max);
                while (true) {
                    float f4 = f2 * 2.0f;
                    if (f4 > min2) {
                        break;
                    }
                    f2 = f4;
                }
            } else {
                while (true) {
                    float f5 = f2 * 2.0f;
                    if (f5 > min) {
                        break;
                    }
                    f2 = f5;
                }
            }
            i4 = (int) f2;
        }
        int i7 = i4 >= 1 ? i4 : 1;
        while (true) {
            if (i5 / i7 <= maxBitmapWidth && i6 / i7 <= maxBitmapHeight) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
                options2.inSampleSize = i7;
                return BitmapFactory.decodeFile(str, options2);
            }
            i7++;
        }
    }

    public static Bitmap.CompressFormat getBmpFormat(byte[] bArr) {
        String mime = getMime(bArr);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        return mime != null ? (mime.endsWith(Emoticon.TYPE_PNG) || mime.endsWith(Emoticon.TYPE_GIF)) ? Bitmap.CompressFormat.PNG : compressFormat : compressFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFileName(HttpConnection httpConnection, String str) throws Throwable {
        String str2;
        List<String> list;
        int lastIndexOf;
        List<String> list2;
        String[] split;
        Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
        if (headerFields == null || (list2 = headerFields.get("Content-Disposition")) == null || list2.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (String str3 : list2.get(0).split(";")) {
                if (str3.trim().startsWith("filename")) {
                    str2 = str3.split("=")[1];
                    if (str2.startsWith("\"") && str2.endsWith("\"")) {
                        str2 = str2.substring(1, str2.length() - 1);
                    }
                }
            }
        }
        if (str2 == null) {
            String MD5 = Data.MD5(str);
            if (headerFields == null || (list = headerFields.get(HttpRequest.HEADER_CONTENT_TYPE)) == null || list.size() <= 0) {
                return MD5;
            }
            String str4 = list.get(0);
            String trim = str4 == null ? "" : str4.trim();
            if (trim.startsWith("image/")) {
                String substring = trim.substring(6);
                StringBuilder sb = new StringBuilder();
                sb.append(MD5);
                sb.append(".");
                if ("jpeg".equals(substring)) {
                    substring = "jpg";
                }
                sb.append(substring);
                return sb.toString();
            }
            int lastIndexOf2 = str.lastIndexOf(47);
            String substring2 = lastIndexOf2 > 0 ? str.substring(lastIndexOf2 + 1) : null;
            if (substring2 == null || substring2.length() <= 0 || (lastIndexOf = substring2.lastIndexOf(46)) <= 0 || substring2.length() - lastIndexOf >= 10) {
                return MD5;
            }
            return MD5 + substring2.substring(lastIndexOf);
        }
        return str2;
    }

    public static String getMime(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return getMime(bArr);
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return "";
        }
    }

    public static boolean isBlackBitmap(Bitmap bitmap) throws Throwable {
        if (bitmap == null || bitmap.isRecycled()) {
            return true;
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= width) {
                break;
            } else if ((iArr[i2] & ViewCompat.MEASURED_SIZE_MASK) != 0) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        return !z;
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static int mixAlpha(int i2, int i3) {
        int i4 = i2 >>> 24;
        int i5 = 255 - i4;
        return ((((((i2 & 16711680) >>> 16) * i4) + (((16711680 & i3) >>> 16) * i5)) / 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((((((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) * i4) + (((65280 & i3) >>> 8) * i5)) / 255) << 8) | (((i4 * (i2 & 255)) + (i5 * (i3 & 255))) / 255);
    }

    public static Bitmap roundBitmap(Bitmap bitmap, int i2, int i3, float f2, float f3, float f4, float f5) throws Throwable {
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        if (width == i2 && height == i3) {
            createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect2 = new Rect(0, 0, i2, i3);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float[] fArr = {f2, f2, f3, f3, f4, f4, f5, f5};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF(0.0f, 0.0f, 0.0f, 0.0f), fArr));
        shapeDrawable.setBounds(rect2);
        shapeDrawable.draw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, FileUtils.getFileByPath(str), compressFormat, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) throws Throwable {
        String cachePath = ResHelper.getCachePath(context, "images");
        String str = compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".jpg";
        File file = new File(cachePath, String.valueOf(System.currentTimeMillis()) + str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(compressFormat, i2, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static String saveBitmapByCompress(String str, int i2, int i3, int i4) throws Throwable {
        Bitmap bitmapByCompressSize = getBitmapByCompressSize(str, i2, i3);
        if (i4 > 100) {
            i4 = 100;
        } else if (i4 < 10) {
            i4 = 10;
        }
        Bitmap.CompressFormat bmpFormat = getBmpFormat(str);
        String str2 = bmpFormat == Bitmap.CompressFormat.PNG ? ".png" : ".jpg";
        String parent = new File(str).getParent();
        File file = new File(parent, String.valueOf(System.currentTimeMillis()) + str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmapByCompressSize.compress(bmpFormat, i4, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static String saveViewToImage(View view) throws Throwable {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        return saveViewToImage(view, width, height);
    }

    public static Bitmap scaleBitmapByHeight(Context context, int i2, int i3) throws Throwable {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
        boolean z = i3 != decodeResource.getHeight();
        Bitmap scaleBitmapByHeight = scaleBitmapByHeight(decodeResource, i3);
        if (z) {
            decodeResource.recycle();
        }
        return scaleBitmapByHeight;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        boolean z2;
        if (isEmptyBitmap(bitmap) || !FileUtils.createFileByDeleteOldFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                z2 = bitmap.compress(compressFormat, 100, bufferedOutputStream2);
                if (z) {
                    try {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            MobLog.getInstance().d(th);
                            FileUtils.closeIO(bufferedOutputStream);
                            return z2;
                        } catch (Throwable th2) {
                            FileUtils.closeIO(bufferedOutputStream);
                            throw th2;
                        }
                    }
                }
                FileUtils.closeIO(bufferedOutputStream2);
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                z2 = false;
                MobLog.getInstance().d(th);
                FileUtils.closeIO(bufferedOutputStream);
                return z2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return z2;
    }

    public static Bitmap getBitmap(File file, int i2) throws Throwable {
        if (file == null || !file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Bitmap bitmap = getBitmap(fileInputStream, i2);
        fileInputStream.close();
        return bitmap;
    }

    public static String saveViewToImage(View view, int i2, int i3) throws Throwable {
        Bitmap captureView = captureView(view, i2, i3);
        if (captureView == null || captureView.isRecycled()) {
            return null;
        }
        String cachePath = ResHelper.getCachePath(view.getContext(), "screenshot");
        File file = new File(cachePath, String.valueOf(System.currentTimeMillis()) + ".jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        captureView.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return file.getAbsolutePath();
    }

    public static Bitmap.CompressFormat getBmpFormat(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith(Emoticon.TYPE_PNG) && !lowerCase.endsWith(Emoticon.TYPE_GIF)) {
            if (!lowerCase.endsWith("jpg") && !lowerCase.endsWith("jpeg") && !lowerCase.endsWith("bmp") && !lowerCase.endsWith("tif")) {
                String mime = getMime(str);
                if (!mime.endsWith(Emoticon.TYPE_PNG) && !mime.endsWith(Emoticon.TYPE_GIF)) {
                    return Bitmap.CompressFormat.JPEG;
                }
                return Bitmap.CompressFormat.PNG;
            }
            return Bitmap.CompressFormat.JPEG;
        }
        return Bitmap.CompressFormat.PNG;
    }

    public static Bitmap scaleBitmapByHeight(Bitmap bitmap, int i2) throws Throwable {
        return Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * i2) / bitmap.getHeight(), i2, true);
    }

    private static String getMime(byte[] bArr) {
        byte[] bArr2 = {-1, -40, -1, -31};
        if (bytesStartWith(bArr, new byte[]{-1, -40, -1, -32}) || bytesStartWith(bArr, bArr2)) {
            return "jpg";
        }
        if (bytesStartWith(bArr, new byte[]{-119, 80, 78, 71})) {
            return Emoticon.TYPE_PNG;
        }
        if (bytesStartWith(bArr, "GIF".getBytes())) {
            return Emoticon.TYPE_GIF;
        }
        if (bytesStartWith(bArr, "BM".getBytes())) {
            return "bmp";
        }
        return (bytesStartWith(bArr, new byte[]{73, 73, 42}) || bytesStartWith(bArr, new byte[]{77, 77, 42})) ? "tif" : "";
    }

    public static Bitmap getBitmap(InputStream inputStream, int i2) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j2) {
        return compressByQuality(bitmap, j2, false);
    }

    public static String saveBitmap(Context context, Bitmap bitmap) throws Throwable {
        return saveBitmap(context, bitmap, Bitmap.CompressFormat.JPEG, 80);
    }

    private static Bitmap blur(Bitmap bitmap, int i2, boolean z) {
        int[] iArr;
        int i3 = i2;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i3 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, i7, 3);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = copy;
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i3;
            int i26 = 0;
            while (i25 <= i3) {
                int i27 = i6;
                int[] iArr9 = iArr6;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i25, 0))];
                int[] iArr10 = iArr8[i25 + i3];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i12 - Math.abs(i25);
                i26 += iArr10[0] * abs;
                i17 += iArr10[1] * abs;
                i18 += iArr10[2] * abs;
                if (i25 > 0) {
                    i22 += iArr10[0];
                    i23 += iArr10[1];
                    i24 += iArr10[2];
                } else {
                    i19 += iArr10[0];
                    i20 += iArr10[1];
                    i21 += iArr10[2];
                }
                i25++;
                i6 = i27;
                iArr6 = iArr9;
            }
            int i29 = i6;
            int[] iArr11 = iArr6;
            int i30 = i3;
            int i31 = i26;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i31];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i18];
                int i33 = i31 - i19;
                int i34 = i17 - i20;
                int i35 = i18 - i21;
                int[] iArr12 = iArr8[((i30 - i3) + i7) % i7];
                int i36 = i19 - iArr12[0];
                int i37 = i20 - iArr12[1];
                int i38 = i21 - iArr12[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr11[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr11[i32]];
                iArr12[0] = (i39 & 16711680) >> 16;
                iArr12[1] = (i39 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[2] = i39 & 255;
                int i40 = i22 + iArr12[0];
                int i41 = i23 + iArr12[1];
                int i42 = i24 + iArr12[2];
                i31 = i33 + i40;
                i17 = i34 + i41;
                i18 = i35 + i42;
                i30 = (i30 + 1) % i7;
                int[] iArr13 = iArr8[i30 % i7];
                i19 = i36 + iArr13[0];
                i20 = i37 + iArr13[1];
                i21 = i38 + iArr13[2];
                i22 = i40 - iArr13[0];
                i23 = i41 - iArr13[1];
                i24 = i42 - iArr13[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            copy = bitmap2;
            height = i16;
            i6 = i29;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i43 = i6;
        int[] iArr14 = iArr6;
        int i44 = height;
        int[] iArr15 = iArr7;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i7;
            int[] iArr16 = iArr2;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = i46;
            int i56 = i46 * width;
            int i57 = 0;
            int i58 = 0;
            while (i55 <= i3) {
                int i59 = width;
                int max = Math.max(0, i56) + i45;
                int[] iArr17 = iArr8[i55 + i3];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i55);
                i57 += iArr3[max] * abs2;
                i58 += iArr4[max] * abs2;
                i48 += iArr5[max] * abs2;
                if (i55 > 0) {
                    i52 += iArr17[0];
                    i53 += iArr17[1];
                    i54 += iArr17[2];
                } else {
                    i49 += iArr17[0];
                    i50 += iArr17[1];
                    i51 += iArr17[2];
                }
                int i60 = i43;
                if (i55 < i60) {
                    i56 += i59;
                }
                i55++;
                i43 = i60;
                width = i59;
            }
            int i61 = width;
            int i62 = i43;
            int i63 = i3;
            int i64 = i45;
            int i65 = i58;
            int i66 = i44;
            int i67 = i57;
            int i68 = 0;
            while (i68 < i66) {
                iArr16[i64] = (iArr16[i64] & ViewCompat.MEASURED_STATE_MASK) | (iArr15[i67] << 16) | (iArr15[i65] << 8) | iArr15[i48];
                int i69 = i67 - i49;
                int i70 = i65 - i50;
                int i71 = i48 - i51;
                int[] iArr18 = iArr8[((i63 - i3) + i47) % i47];
                int i72 = i49 - iArr18[0];
                int i73 = i50 - iArr18[1];
                int i74 = i51 - iArr18[2];
                if (i45 == 0) {
                    iArr14[i68] = Math.min(i68 + i12, i62) * i61;
                }
                int i75 = iArr14[i68] + i45;
                iArr18[0] = iArr3[i75];
                iArr18[1] = iArr4[i75];
                iArr18[2] = iArr5[i75];
                int i76 = i52 + iArr18[0];
                int i77 = i53 + iArr18[1];
                int i78 = i54 + iArr18[2];
                i67 = i69 + i76;
                i65 = i70 + i77;
                i48 = i71 + i78;
                i63 = (i63 + 1) % i47;
                int[] iArr19 = iArr8[i63];
                i49 = i72 + iArr19[0];
                i50 = i73 + iArr19[1];
                i51 = i74 + iArr19[2];
                i52 = i76 - iArr19[0];
                i53 = i77 - iArr19[1];
                i54 = i78 - iArr19[2];
                i64 += i61;
                i68++;
                i3 = i2;
            }
            i45++;
            i3 = i2;
            i43 = i62;
            i44 = i66;
            i7 = i47;
            iArr2 = iArr16;
            width = i61;
        }
        int i79 = width;
        bitmap3.setPixels(iArr2, 0, i79, 0, 0, i79, i44);
        return bitmap3;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j2, boolean z) {
        byte[] byteArray;
        if (isEmptyBitmap(bitmap) || j2 <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j2) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j2) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    i4 = (i3 + i2) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
                    int i5 = (byteArrayOutputStream.size() > j2 ? 1 : (byteArrayOutputStream.size() == j2 ? 0 : -1));
                    if (i5 == 0) {
                        break;
                    } else if (i5 > 0) {
                        i2 = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                if (i2 == i4 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap getBitmap(String str) throws Throwable {
        return getBitmap(str, 1);
    }

    public static Bitmap getBitmap(Context context, String str) throws Throwable {
        return getBitmap(downloadBitmap(context, str));
    }
}
