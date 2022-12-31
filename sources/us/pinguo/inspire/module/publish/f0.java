package us.pinguo.inspire.module.publish;

import java.util.Comparator;
import us.pinguo.inspire.module.publish.vo.BlockUploadInfo;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class f0 implements Comparator {
    public static final /* synthetic */ f0 a = new f0();

    private /* synthetic */ f0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return InspirePublishTask.m((BlockUploadInfo) obj, (BlockUploadInfo) obj2);
    }
}
