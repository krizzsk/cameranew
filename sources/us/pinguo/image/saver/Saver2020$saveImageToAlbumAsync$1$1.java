package us.pinguo.image.saver;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.librouter.b.c.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Saver2020.kt */
@DebugMetadata(c = "us.pinguo.image.saver.Saver2020$saveImageToAlbumAsync$1$1", f = "Saver2020.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class Saver2020$saveImageToAlbumAsync$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $deleteInput;
    final /* synthetic */ boolean $dirty;
    final /* synthetic */ byte[] $editExifData;
    final /* synthetic */ String $inputImage;
    final /* synthetic */ f $location;
    final /* synthetic */ b $orgInfo;
    final /* synthetic */ int $orientation;
    final /* synthetic */ l<String, u> $saveBlock;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Saver2020$saveImageToAlbumAsync$1$1(String str, int i2, f fVar, b bVar, byte[] bArr, boolean z, boolean z2, l<? super String, u> lVar, Continuation<? super Saver2020$saveImageToAlbumAsync$1$1> continuation) {
        super(2, continuation);
        this.$inputImage = str;
        this.$orientation = i2;
        this.$location = fVar;
        this.$orgInfo = bVar;
        this.$editExifData = bArr;
        this.$deleteInput = z;
        this.$dirty = z2;
        this.$saveBlock = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new Saver2020$saveImageToAlbumAsync$1$1(this.$inputImage, this.$orientation, this.$location, this.$orgInfo, this.$editExifData, this.$deleteInput, this.$dirty, this.$saveBlock, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((Saver2020$saveImageToAlbumAsync$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            Saver2020 saver2020 = Saver2020.a;
            String str = this.$inputImage;
            int i3 = this.$orientation;
            f fVar = this.$location;
            b bVar = this.$orgInfo;
            byte[] bArr = this.$editExifData;
            boolean z = this.$deleteInput;
            boolean z2 = this.$dirty;
            this.label = 1;
            obj = saver2020.d(str, i3, fVar, bVar, bArr, z, z2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        this.$saveBlock.invoke((String) obj);
        return u.a;
    }
}
