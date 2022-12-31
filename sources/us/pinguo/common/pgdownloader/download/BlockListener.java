package us.pinguo.common.pgdownloader.download;
/* compiled from: BlockListener.kt */
/* loaded from: classes4.dex */
public interface BlockListener {
    void onBlockError(String str, int i2, String str2);

    void onBlockFinish(String str, int i2, long j2);

    void onBlockProgress(int i2, int i3);
}
