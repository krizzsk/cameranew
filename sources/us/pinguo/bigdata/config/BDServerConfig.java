package us.pinguo.bigdata.config;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class BDServerConfig implements Serializable {
    private static final long serialVersionUID = -1947869194052027554L;
    private boolean postPush = true;
    private int onStartUpDelay = 5;
    private float num = 5.0f;
    private boolean onStartUp = true;
    private boolean onExit = true;
    private String mechanism = UploadType.batchInQuantum.name();
    private List<Sampling> sam = null;

    /* loaded from: classes3.dex */
    public enum UploadType {
        batchOnStartup,
        batchInTime,
        batchInQuantum
    }

    public String getMechanism() {
        return this.mechanism;
    }

    public float getNum() {
        return this.num;
    }

    public boolean getOnStartUp() {
        return this.onStartUp;
    }

    public boolean getPostPush() {
        return this.postPush;
    }

    public List<Sampling> getSam() {
        return this.sam;
    }

    public boolean isOnExit() {
        return this.onExit;
    }

    public void setSam(List<Sampling> list) {
        this.sam = list;
    }
}
