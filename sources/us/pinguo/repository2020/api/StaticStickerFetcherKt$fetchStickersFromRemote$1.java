package us.pinguo.repository2020.api;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.foundation.j;
import us.pinguo.repository2020.database.staticsticker.StaticStickerJson;
import us.pinguo.repository2020.database.staticsticker.StaticStickerResponse;
import us.pinguo.repository2020.utils.RequestIntervalPref;
/* compiled from: StaticStickerFetcher.kt */
/* loaded from: classes6.dex */
final class StaticStickerFetcherKt$fetchStickersFromRemote$1 extends Lambda implements p<StaticStickerResponse, Throwable, u> {
    final /* synthetic */ p<StaticStickerJson, Throwable, u> $callback;
    final /* synthetic */ int $forceUpdateVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerFetcherKt$fetchStickersFromRemote$1(int i2, p<? super StaticStickerJson, ? super Throwable, u> pVar) {
        super(2);
        this.$forceUpdateVersion = i2;
        this.$callback = pVar;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(StaticStickerResponse staticStickerResponse, Throwable th) {
        invoke2(staticStickerResponse, th);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(StaticStickerResponse staticStickerResponse, Throwable th) {
        Long interval;
        if (staticStickerResponse != null) {
            Integer status = staticStickerResponse.getStatus();
            if (status != null && status.intValue() == 10220) {
                j.e().q("force_update_static_sticker", this.$forceUpdateVersion);
                RequestIntervalPref.a.d("/api/product/unity-static", -1L, null);
                p<StaticStickerJson, Throwable, u> pVar = this.$callback;
                if (pVar == null) {
                    return;
                }
                String message = staticStickerResponse.getMessage();
                pVar.invoke(null, new Throwable(s.q("status:10220,message:", message != null ? message : "null")));
                return;
            }
            Integer status2 = staticStickerResponse.getStatus();
            if (status2 != null && status2.intValue() == 200) {
                j.e().q("force_update_static_sticker", this.$forceUpdateVersion);
                RequestIntervalPref requestIntervalPref = RequestIntervalPref.a;
                StaticStickerJson data = staticStickerResponse.getData();
                long j2 = 0;
                if (data != null && (interval = data.getInterval()) != null) {
                    j2 = interval.longValue();
                }
                requestIntervalPref.d("/api/product/unity-static", j2 * 1000, null);
                p<StaticStickerJson, Throwable, u> pVar2 = this.$callback;
                if (pVar2 == null) {
                    return;
                }
                pVar2.invoke(staticStickerResponse.getData(), null);
                return;
            }
            p<StaticStickerJson, Throwable, u> pVar3 = this.$callback;
            if (pVar3 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("status:");
            Integer status3 = staticStickerResponse.getStatus();
            if (status3 == null) {
                status3 = "null";
            }
            sb.append(status3);
            sb.append(",message:");
            String message2 = staticStickerResponse.getMessage();
            sb.append(message2 != null ? message2 : "null");
            pVar3.invoke(null, new Throwable(sb.toString()));
            return;
        }
        p<StaticStickerJson, Throwable, u> pVar4 = this.$callback;
        if (pVar4 == null) {
            return;
        }
        pVar4.invoke(null, th);
    }
}
