package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Canvas.kt */
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect clipRect, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(clipRect, "clipRect");
        s.h(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(matrix, "matrix");
        s.h(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            matrix = new Matrix();
        }
        s.h(canvas, "<this>");
        s.h(matrix, "matrix");
        s.h(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f2, float f3, float f4, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f2, float f3, float f4, l block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withSave(Canvas canvas, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withScale(Canvas canvas, float f2, float f3, float f4, float f5, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f2, float f3, float f4, float f5, l block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f5 = 0.0f;
        }
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f2, float f3, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f2, float f3, l block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f2, float f3, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f2, float f3, l block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF clipRect, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(clipRect, "clipRect");
        s.h(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, int i2, int i3, int i4, int i5, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.clipRect(i2, i3, i4, i5);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, float f2, float f3, float f4, float f5, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(block, "block");
        int save = canvas.save();
        canvas.clipRect(f2, f3, f4, f5);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(Canvas canvas, Path clipPath, l<? super Canvas, u> block) {
        s.h(canvas, "<this>");
        s.h(clipPath, "clipPath");
        s.h(block, "block");
        int save = canvas.save();
        canvas.clipPath(clipPath);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }
}
