package us.pinguo.inspire.module.discovery.entity.dicovery;

import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.inspire.model.InspireWork;
/* loaded from: classes9.dex */
public class DiscoveryFall {
    public static final String FALLS_TYPE_HOT_USER = "hotUser";
    public static final String FALLS_TYPE_HOT_WORK = "hotWork";
    public static final String FALLS_TYPE_PHOTO_GAME = "photoGame";
    public static final String FALLS_TYPE_REC = "rec";
    public DiscoveryHotUser hotUser;
    public InspireWork hotWork;
    public DiscoveryPhotoGame photoGame;
    public DiscoveryRec rec;
    public FeedStat stat;
    public String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiscoveryFall discoveryFall = (DiscoveryFall) obj;
        String str = this.type;
        if (str == null ? discoveryFall.type == null : str.equals(discoveryFall.type)) {
            InspireWork inspireWork = this.hotWork;
            if (inspireWork == null ? discoveryFall.hotWork == null : inspireWork.equals(discoveryFall.hotWork)) {
                DiscoveryHotUser discoveryHotUser = this.hotUser;
                DiscoveryHotUser discoveryHotUser2 = discoveryFall.hotUser;
                return discoveryHotUser != null ? discoveryHotUser.equals(discoveryHotUser2) : discoveryHotUser2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        InspireWork inspireWork = this.hotWork;
        int hashCode2 = (hashCode + (inspireWork != null ? inspireWork.hashCode() : 0)) * 31;
        DiscoveryHotUser discoveryHotUser = this.hotUser;
        return hashCode2 + (discoveryHotUser != null ? discoveryHotUser.hashCode() : 0);
    }
}
