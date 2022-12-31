package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a a;
    private final b b;
    private final Paint c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FrameNeededResult.values().length];
            a = iArr;
            try {
                iArr[FrameNeededResult.REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FrameNeededResult.NOT_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FrameNeededResult.ABORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FrameNeededResult.SKIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2, Bitmap bitmap);

        @Nullable
        com.facebook.common.references.a<Bitmap> b(int i2);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, b bVar) {
        this.a = aVar;
        this.b = bVar;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        int i2 = animatedDrawableFrameInfo.a;
        int i3 = animatedDrawableFrameInfo.b;
        canvas.drawRect(i2, i3, i2 + animatedDrawableFrameInfo.c, i3 + animatedDrawableFrameInfo.f2663d, this.c);
    }

    private FrameNeededResult b(int i2) {
        AnimatedDrawableFrameInfo c = this.a.c(i2);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = c.f2665f;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (c(c)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean c(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.a == 0 && animatedDrawableFrameInfo.b == 0 && animatedDrawableFrameInfo.c == this.a.h() && animatedDrawableFrameInfo.f2663d == this.a.g();
    }

    private boolean d(int i2) {
        if (i2 == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo c = this.a.c(i2);
        AnimatedDrawableFrameInfo c2 = this.a.c(i2 - 1);
        if (c.f2664e == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && c(c)) {
            return true;
        }
        return c2.f2665f == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && c(c2);
    }

    private void e(Bitmap bitmap) {
        com.facebook.imagepipeline.h.a c;
        d i2 = this.a.i();
        if (i2 == null || (c = i2.c()) == null) {
            return;
        }
        c.b(bitmap);
    }

    private int f(int i2, Canvas canvas) {
        while (i2 >= 0) {
            int i3 = a.a[b(i2).ordinal()];
            if (i3 == 1) {
                AnimatedDrawableFrameInfo c = this.a.c(i2);
                com.facebook.common.references.a<Bitmap> b2 = this.b.b(i2);
                if (b2 != null) {
                    try {
                        canvas.drawBitmap(b2.A(), 0.0f, 0.0f, (Paint) null);
                        if (c.f2665f == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                            a(canvas, c);
                        }
                        return i2 + 1;
                    } finally {
                        b2.close();
                    }
                } else if (d(i2)) {
                    return i2;
                }
            } else if (i3 == 2) {
                return i2 + 1;
            } else {
                if (i3 == 3) {
                    return i2;
                }
            }
            i2--;
        }
        return 0;
    }

    public void g(int i2, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int f2 = !d(i2) ? f(i2 - 1, canvas) : i2; f2 < i2; f2++) {
            AnimatedDrawableFrameInfo c = this.a.c(f2);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = c.f2665f;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (c.f2664e == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, c);
                }
                this.a.d(f2, canvas);
                this.b.a(f2, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, c);
                }
            }
        }
        AnimatedDrawableFrameInfo c2 = this.a.c(i2);
        if (c2.f2664e == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, c2);
        }
        this.a.d(i2, canvas);
        e(bitmap);
    }
}
