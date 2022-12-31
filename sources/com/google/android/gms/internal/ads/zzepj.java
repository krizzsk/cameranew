package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzepj extends zzepl implements zzbs {
    private String type;
    private long zzawv;
    private zzbr zzjaw;
    private boolean zzjax;

    public zzepj(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final void zza(zzbr zzbrVar) {
        this.zzjaw = zzbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final void zza(zzepn zzepnVar, ByteBuffer byteBuffer, long j2, zzbn zzbnVar) throws IOException {
        this.zzawv = zzepnVar.position() - byteBuffer.remaining();
        this.zzjax = byteBuffer.remaining() == 16;
        zza(zzepnVar, j2, zzbnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzepl
    public final void zza(zzepn zzepnVar, long j2, zzbn zzbnVar) throws IOException {
        this.zzjbd = zzepnVar;
        long position = zzepnVar.position();
        this.zzjbi = position;
        this.zzbga = position - ((this.zzjax || 8 + j2 >= IjkMediaMeta.AV_CH_WIDE_RIGHT) ? 16 : 8);
        zzepnVar.zzfc(zzepnVar.position() + j2);
        this.zzasu = zzepnVar.position();
        this.zzjbg = zzbnVar;
    }
}
