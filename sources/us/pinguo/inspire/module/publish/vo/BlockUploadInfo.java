package us.pinguo.inspire.module.publish.vo;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class BlockUploadInfo {
    public long blockSize;
    public long offset;
    public int order;
    public List<SliceResult> sliceResultList;

    public BlockUploadInfo() {
    }

    public void addSliceResult(SliceResult sliceResult) {
        if (this.sliceResultList == null) {
            this.sliceResultList = new ArrayList();
        }
        this.sliceResultList.add(sliceResult);
    }

    public boolean isUploadFinish() {
        return false;
    }

    public BlockUploadInfo(long j2, int i2, long j3) {
        this.blockSize = j3;
        this.order = i2;
        this.offset = j2;
    }
}
