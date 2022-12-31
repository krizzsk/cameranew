package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Shader.kt */
/* loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, l<? super Matrix, u> block) {
        s.h(shader, "<this>");
        s.h(block, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        block.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
