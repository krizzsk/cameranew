package com.pinguo.album.data.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
/* compiled from: AlbumBitmapUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static byte[] a(Bitmap bitmap) {
        return b(bitmap, 90);
    }

    public static byte[] b(Bitmap bitmap, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int c(float f2) {
        com.pinguo.album.j.a.a(f2 > 0.0f);
        int max = Math.max(1, (int) Math.ceil(1.0f / f2));
        if (max <= 8) {
            return com.pinguo.album.j.a.p(max);
        }
        return ((max + 7) / 8) * 8;
    }

    public static int d(float f2) {
        int floor = (int) Math.floor(1.0f / f2);
        if (floor <= 1) {
            return 1;
        }
        if (floor <= 8) {
            return com.pinguo.album.j.a.q(floor);
        }
        return (floor / 8) * 8;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0133: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:79:0x0133 */
    public static Bitmap e(String str) {
        Class<?> cls;
        Object obj;
        Object obj2;
        Bitmap decodeByteArray;
        Object obj3 = null;
        try {
            try {
                try {
                    cls = Class.forName("android.media.MediaMetadataRetriever");
                } catch (Throwable th) {
                    th = th;
                    obj3 = obj2;
                }
            } catch (ClassNotFoundException e2) {
                e = e2;
                cls = null;
                obj = null;
            } catch (IllegalAccessException e3) {
                e = e3;
                cls = null;
                obj = null;
            } catch (IllegalArgumentException unused) {
                cls = null;
                obj = null;
            } catch (InstantiationException e4) {
                e = e4;
                cls = null;
                obj = null;
            } catch (NoSuchMethodException e5) {
                e = e5;
                cls = null;
                obj = null;
            } catch (RuntimeException unused2) {
                cls = null;
                obj = null;
            } catch (InvocationTargetException e6) {
                e = e6;
                cls = null;
                obj = null;
            } catch (Throwable th2) {
                th = th2;
                cls = null;
            }
            try {
                obj = cls.newInstance();
                try {
                    cls.getMethod("setDataSource", String.class).invoke(obj, str);
                    if (Build.VERSION.SDK_INT <= 9) {
                        Bitmap bitmap = (Bitmap) cls.getMethod("captureFrame", new Class[0]).invoke(obj, new Object[0]);
                        if (obj != null) {
                            try {
                                cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                            } catch (Exception unused3) {
                            }
                        }
                        return bitmap;
                    }
                    byte[] bArr = (byte[]) cls.getMethod("getEmbeddedPicture", new Class[0]).invoke(obj, new Object[0]);
                    if (bArr != null && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                        if (obj != null) {
                            try {
                                cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                            } catch (Exception unused4) {
                            }
                        }
                        return decodeByteArray;
                    }
                    Bitmap bitmap2 = (Bitmap) cls.getMethod("getFrameAtTime", new Class[0]).invoke(obj, new Object[0]);
                    if (obj != null) {
                        try {
                            cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                        } catch (Exception unused5) {
                        }
                    }
                    return bitmap2;
                } catch (ClassNotFoundException e7) {
                    e = e7;
                    us.pinguo.common.log.a.e("createVideoThumbnail", e);
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                } catch (IllegalAccessException e8) {
                    e = e8;
                    us.pinguo.common.log.a.e("createVideoThumbnail", e);
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                } catch (IllegalArgumentException unused6) {
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                } catch (InstantiationException e9) {
                    e = e9;
                    us.pinguo.common.log.a.e("createVideoThumbnail", e);
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                } catch (NoSuchMethodException e10) {
                    e = e10;
                    us.pinguo.common.log.a.e("createVideoThumbnail", e);
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                } catch (RuntimeException unused7) {
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                } catch (InvocationTargetException e11) {
                    e = e11;
                    us.pinguo.common.log.a.e("createVideoThumbnail", e);
                    if (obj != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                    }
                    return null;
                }
            } catch (ClassNotFoundException e12) {
                e = e12;
                obj = null;
            } catch (IllegalAccessException e13) {
                e = e13;
                obj = null;
            } catch (IllegalArgumentException unused8) {
                obj = null;
            } catch (InstantiationException e14) {
                e = e14;
                obj = null;
            } catch (NoSuchMethodException e15) {
                e = e15;
                obj = null;
            } catch (RuntimeException unused9) {
                obj = null;
            } catch (InvocationTargetException e16) {
                e = e16;
                obj = null;
            } catch (Throwable th3) {
                th = th3;
                if (obj3 != null) {
                    try {
                        cls.getMethod("release", new Class[0]).invoke(obj3, new Object[0]);
                    } catch (Exception unused10) {
                    }
                }
                throw th;
            }
        } catch (Exception unused11) {
        }
    }

    private static Bitmap.Config f(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    public static boolean g(String str) {
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).equals("image/jpeg");
    }

    public static Bitmap h(Bitmap bitmap, int i2, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i2 && height == i2) {
            return bitmap;
        }
        float min = i2 / Math.min(width, height);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i2, f(bitmap));
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate((i2 - round) / 2.0f, (i2 - round2) / 2.0f);
        canvas.scale(min, min);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap i(Bitmap bitmap, float f2, boolean z) {
        int round = Math.round(bitmap.getWidth() * f2);
        int round2 = Math.round(bitmap.getHeight() * f2);
        if (round == bitmap.getWidth() && round2 == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, f(bitmap));
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(f2, f2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap j(Bitmap bitmap, int i2, boolean z) {
        float f2 = i2;
        float min = Math.min(f2 / bitmap.getWidth(), f2 / bitmap.getHeight());
        return min >= 1.0f ? bitmap : i(bitmap, min, z);
    }

    public static Bitmap k(Bitmap bitmap, int i2, int i3, float f2, int i4, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i4 == 90 || i4 == 270) {
            int i5 = i3 + i2;
            i2 = i5 - i2;
            i3 = i5 - i2;
        }
        float f3 = width / height;
        us.pinguo.common.log.a.k("resizeSameRadioAndCropCenter w = " + width + " h = " + height + " newSize = " + i3 + " oldBmpRadio = " + f3 + " imageRotation = " + i4, new Object[0]);
        if (Math.abs(f3 - f2) <= 0.001d) {
            return bitmap;
        }
        float max = Math.max(i3, i2) / Math.min(width, height);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, f(bitmap));
        int round = Math.round(bitmap.getWidth() * max);
        int round2 = Math.round(bitmap.getHeight() * max);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate((i2 - round) / 2.0f, (i3 - round2) / 2.0f);
        canvas.scale(max, max);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        us.pinguo.common.log.a.k("resizeSameRadioAndCropCenter scale = " + max + " size = " + i2 + " width = " + round + " height = " + round2 + " target = " + createBitmap.getWidth() + "/" + createBitmap.getHeight(), new Object[0]);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap l(Bitmap bitmap, int i2, boolean z) {
        if (bitmap == null || i2 == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
