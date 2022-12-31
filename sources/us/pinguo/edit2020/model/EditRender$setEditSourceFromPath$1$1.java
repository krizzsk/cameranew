package us.pinguo.edit2020.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.Size;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.foundation.statistics.h;
import us.pinguo.memorytest.MemoryTest;
import us.pinguo.performance.manager.PerformanceLevelManager;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditRender.kt */
@DebugMetadata(c = "us.pinguo.edit2020.model.EditRender$setEditSourceFromPath$1$1", f = "EditRender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditRender$setEditSourceFromPath$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $exifOrientation;
    final /* synthetic */ boolean $isInitPath;
    final /* synthetic */ boolean $isPngOrJpeg;
    final /* synthetic */ Size $it;
    final /* synthetic */ String $path;
    final /* synthetic */ Size $pictureSize;
    final /* synthetic */ String $tempPath;
    int label;
    final /* synthetic */ EditRender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditRender$setEditSourceFromPath$1$1(Size size, EditRender editRender, boolean z, boolean z2, String str, String str2, Size size2, int i2, Continuation<? super EditRender$setEditSourceFromPath$1$1> continuation) {
        super(2, continuation);
        this.$it = size;
        this.this$0 = editRender;
        this.$isInitPath = z;
        this.$isPngOrJpeg = z2;
        this.$path = str;
        this.$tempPath = str2;
        this.$pictureSize = size2;
        this.$exifOrientation = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditRender$setEditSourceFromPath$1$1(this.$it, this.this$0, this.$isInitPath, this.$isPngOrJpeg, this.$path, this.$tempPath, this.$pictureSize, this.$exifOrientation, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditRender$setEditSourceFromPath$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            boolean z = false;
            us.pinguo.common.log.a.c(s.q("sourceSize:", this.$it), new Object[0]);
            kotlin.jvm.b.a<u> E = this.this$0.E();
            if (E != null) {
                E.invoke();
            }
            if (this.$isInitPath && !this.$isPngOrJpeg) {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.$path);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.$tempPath), 8192);
                try {
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    decodeFile.recycle();
                    u uVar = u.a;
                    kotlin.io.b.a(bufferedOutputStream, null);
                } finally {
                }
            }
            Integer h2 = PerformanceLevelManager.a.h();
            int intValue = h2 == null ? 0 : h2.intValue();
            int max = Math.max(this.$it.getWidth(), this.$it.getHeight());
            float f2 = max <= intValue ? 1.0f : intValue / max;
            int width = (int) (this.$it.getWidth() * f2);
            int height = (int) (this.$it.getHeight() * f2);
            int i2 = width * height * 4 * 8;
            us.pinguo.util.d.e(1);
            if (MemoryTest.mmapTest(i2) && MemoryTest.mallocTest(i2) && MemoryTest.kgslAlloc(i2) && MemoryTest.kgslAlloc2(i2)) {
                z = true;
            } else {
                us.pinguo.util.d.e(0);
                Log.d("MemoryTest", "failed");
                width = (int) (width * 0.7f);
                height = (int) (height * 0.7f);
            }
            this.this$0.F0(new Size(width, height));
            UnityEditCaller.Common.setEditSourceFromPath(this.$tempPath, this.$pictureSize, this.$exifOrientation, Boxing.boxInt(Math.max(width, height)));
            l<Boolean, u> D = this.this$0.D();
            if (D != null) {
                D.invoke(Boxing.boxBoolean(z));
            }
            if (this.$isInitPath) {
                h.b.V(String.valueOf(this.$it.getHeight()), String.valueOf(this.$it.getWidth()), String.valueOf(this.$it.getWidth() * this.$it.getHeight()), "import");
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
