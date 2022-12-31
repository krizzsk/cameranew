package us.pinguo.inspire.module.discovery.entity.dicovery;
/* loaded from: classes9.dex */
public class DiscoveryFixedItem {
    public String cover;
    public String desc;
    public int height;
    public String icon;
    public String title;
    public String vid;
    public int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryFixedItem) {
            String str = this.vid;
            String str2 = ((DiscoveryFixedItem) obj).vid;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.vid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
