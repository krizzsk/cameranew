package us.pinguo.edit2020.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.bugly.crashreport.CrashReport;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.edit2020.utils.ScreenshotDetector;
/* compiled from: ScreenshotObserver.kt */
@DebugMetadata(c = "us.pinguo.edit2020.utils.ScreenshotDetector$start$observer$1$onChange$1", f = "ScreenshotObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class ScreenshotDetector$start$observer$1$onChange$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ScreenshotDetector$start$observer$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotDetector$start$observer$1$onChange$1(ContentResolver contentResolver, Uri uri, ScreenshotDetector$start$observer$1 screenshotDetector$start$observer$1, Continuation<? super ScreenshotDetector$start$observer$1$onChange$1> continuation) {
        super(2, continuation);
        this.$contentResolver = contentResolver;
        this.$uri = uri;
        this.this$0 = screenshotDetector$start$observer$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new ScreenshotDetector$start$observer$1$onChange$1(this.$contentResolver, this.$uri, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((ScreenshotDetector$start$observer$1$onChange$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            try {
                Cursor query = this.$contentResolver.query(this.$uri, ScreenshotDetector.a(), null, null, "date_added DESC");
                if (query != null) {
                    ScreenshotDetector$start$observer$1 screenshotDetector$start$observer$1 = this.this$0;
                    if (query.moveToFirst()) {
                        String path = query.getString(query.getColumnIndex("_data"));
                        if (!s.c(screenshotDetector$start$observer$1.a(), path) && ScreenshotDetector.a.a(ScreenshotDetector.b, path)) {
                            us.pinguo.common.log.a.e(path, new Object[0]);
                            s.g(path, "path");
                            screenshotDetector$start$observer$1.c(path);
                            l<String, u> b = screenshotDetector$start$observer$1.b();
                            if (b != null) {
                                b.invoke(path);
                            }
                        }
                    }
                    u uVar = u.a;
                    kotlin.io.b.a(query, null);
                }
            } catch (Exception e2) {
                CrashReport.postCatchedException(e2);
                e2.printStackTrace();
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
