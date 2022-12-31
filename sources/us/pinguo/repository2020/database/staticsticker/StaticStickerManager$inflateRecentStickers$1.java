package us.pinguo.repository2020.database.staticsticker;

import androidx.collection.LruCache;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.util.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$inflateRecentStickers$1", f = "StaticStickerManager.kt", i = {0, 0}, l = {315}, m = "invokeSuspend", n = {Material.MATERIAL_RECENT, "recentPath"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
public final class StaticStickerManager$inflateRecentStickers$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StaticStickerManager$inflateRecentStickers$1(Continuation<? super StaticStickerManager$inflateRecentStickers$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerManager$inflateRecentStickers$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StaticStickerManager$inflateRecentStickers$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        LruCache lruCache;
        String str;
        ConcurrentHashMap concurrentHashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            lruCache = StaticStickerManager.m;
            if (lruCache.size() > 0) {
                return u.a;
            }
            String q = s.q(StaticStickerManager.a.u(), "recent_static_sticker_ids.txt");
            this.L$0 = lruCache;
            this.L$1 = q;
            this.label = 1;
            Object q2 = FileUtils.q(q, this);
            if (q2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = q;
            obj = q2;
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            str = (String) this.L$1;
            lruCache = (LruCache) this.L$0;
            kotlin.j.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            concurrentHashMap = StaticStickerManager.f11847i;
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    break;
                }
                StaticSticker staticSticker = (StaticSticker) concurrentHashMap.get(readLine);
                if (staticSticker != null) {
                    lruCache.put(readLine, staticSticker);
                }
            }
            randomAccessFile.close();
        }
        return u.a;
    }
}
