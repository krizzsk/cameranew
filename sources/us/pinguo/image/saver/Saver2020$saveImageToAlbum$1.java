package us.pinguo.image.saver;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Saver2020.kt */
@DebugMetadata(c = "us.pinguo.image.saver.Saver2020", f = "Saver2020.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4}, l = {93, 96, 103, 125, 213}, m = "saveImageToAlbum", n = {"this", "inputImage", FirebaseAnalytics.Param.LOCATION, "dirPath", "relativePath", "version", "resolver", "suffix", "orgJpgData", "exifData", "exifInfo", "orgName", "orgDestPath", "orientation", "deleteInput", "dirty", "date", "orgOrientation", "orgDate", "this", "inputImage", FirebaseAnalytics.Param.LOCATION, "dirPath", "relativePath", "version", "resolver", "suffix", "orgJpgData", "exifData", "exifInfo", "orgName", "orgDestPath", "tmpJpg", "tmpJpg2", "orientation", "deleteInput", "dirty", "date", "orgOrientation", "orgDate", "this", "inputImage", FirebaseAnalytics.Param.LOCATION, "dirPath", "relativePath", "version", "resolver", "suffix", "orgJpgData", "exifData", "exifInfo", "orgName", "orgDestPath", "tmpJpg2", "orientation", "deleteInput", "dirty", "date", "orgOrientation", "orgDate", "this", "inputImage", FirebaseAnalytics.Param.LOCATION, "dirPath", "relativePath", "version", "resolver", "suffix", "exifData", "orientation", "deleteInput", "dirty", "date", "destPath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "Z$0", "Z$1", "J$0", "I$1", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "Z$0", "Z$1", "J$0", "I$1", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "Z$0", "Z$1", "J$0", "I$1", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "Z$0", "Z$1", "J$0", "L$0"})
/* loaded from: classes4.dex */
public final class Saver2020$saveImageToAlbum$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Saver2020 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Saver2020$saveImageToAlbum$1(Saver2020 saver2020, Continuation<? super Saver2020$saveImageToAlbum$1> continuation) {
        super(continuation);
        this.this$0 = saver2020;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d2 = this.this$0.d(null, 0, null, null, null, false, false, this);
        return d2;
    }
}
