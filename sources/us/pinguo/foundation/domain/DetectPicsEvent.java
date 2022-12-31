package us.pinguo.foundation.domain;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class DetectPicsEvent {
    private ArrayList<PublishMediaItem> mPicPathList;

    public DetectPicsEvent(ArrayList<PublishMediaItem> arrayList) {
        this.mPicPathList = arrayList;
    }

    public ArrayList<PublishMediaItem> getPicList() {
        return this.mPicPathList;
    }
}
