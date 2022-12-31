package us.pinguo.image.saver;

import android.graphics.Point;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.librouter.b.c.f;
/* compiled from: Saver2020.kt */
/* loaded from: classes4.dex */
public final class Saver2020 {
    public static final Saver2020 a = new Saver2020();
    private static final ExecutorService b = Executors.newSingleThreadExecutor();
    private static Point c;

    private Saver2020() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:20|21|22|(11:(1:24)(2:70|(14:72|26|27|28|30|31|32|33|34|(5:47|(1:49)(3:(1:56)(1:59)|57|58)|50|(1:52)(1:54)|53)(1:36)|37|38|39|(2:41|(1:43)(3:44|15|16))(1:45)))|30|31|32|33|34|(0)(0)|37|38|39|(0)(0))|25|26|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x087a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x087c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x087d, code lost:
        r53 = r9;
        r19 = r11;
        r54 = r13;
        r25 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0885, code lost:
        r0.printStackTrace();
        r19 = r19;
        r53 = r53;
        r54 = r54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x05e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x07fd A[Catch: all -> 0x0866, TRY_LEAVE, TryCatch #26 {all -> 0x0866, blocks: (B:220:0x07f6, B:236:0x0856, B:223:0x07fd, B:231:0x081f, B:235:0x082b, B:230:0x081c, B:227:0x0807, B:229:0x0817, B:228:0x0811), top: B:286:0x07f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0494 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0516 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0544  */
    /* JADX WARN: Type inference failed for: r10v8, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r14v22, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r19v1, types: [us.pinguo.image.saver.e.a] */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r53v5 */
    /* JADX WARN: Type inference failed for: r53v6 */
    /* JADX WARN: Type inference failed for: r56v4 */
    /* JADX WARN: Type inference failed for: r56v5 */
    /* JADX WARN: Type inference failed for: r56v6 */
    /* JADX WARN: Type inference failed for: r56v9 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r53, int r54, us.pinguo.librouter.b.c.f r55, us.pinguo.image.saver.b r56, byte[] r57, boolean r58, boolean r59, kotlin.coroutines.Continuation<? super java.lang.String> r60) {
        /*
            Method dump skipped, instructions count: 2234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.image.saver.Saver2020.d(java.lang.String, int, us.pinguo.librouter.b.c.f, us.pinguo.image.saver.b, byte[], boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String inputImage, int i2, f fVar, b bVar, byte[] bArr, boolean z, boolean z2, l saveBlock) {
        s.h(inputImage, "$inputImage");
        s.h(saveBlock, "$saveBlock");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new Saver2020$saveImageToAlbumAsync$1$1(inputImage, i2, fVar, bVar, bArr, z, z2, saveBlock, null), 3, null);
    }

    public final Point b() {
        return c;
    }

    public final void e(final String inputImage, final int i2, final f fVar, final b bVar, final byte[] bArr, final boolean z, final boolean z2, final l<? super String, u> saveBlock) {
        s.h(inputImage, "inputImage");
        s.h(saveBlock, "saveBlock");
        b.execute(new Runnable() { // from class: us.pinguo.image.saver.a
            @Override // java.lang.Runnable
            public final void run() {
                Saver2020.g(inputImage, i2, fVar, bVar, bArr, z, z2, saveBlock);
            }
        });
    }
}
