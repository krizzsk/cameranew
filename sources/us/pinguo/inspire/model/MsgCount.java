package us.pinguo.inspire.model;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MsgCount implements Serializable {
    private static final long serialVersionUID = 5861760230766837811L;
    public int at;
    public int comment;
    public int fans;
    public ArrayList<FansInfo> fansList;
    public int gift;
    public int like;
    public int sysMsgs;
    public int vote;

    public int getCount() {
        return this.comment + this.fans + this.sysMsgs + this.at + this.like + this.vote + this.gift;
    }

    public int hashCode() {
        int i2 = ((((((((((((this.comment * 31) + this.fans) * 31) + this.like) * 31) + this.vote) * 31) + this.at) * 31) + this.sysMsgs) * 31) + this.gift) * 31;
        ArrayList<FansInfo> arrayList = this.fansList;
        return i2 + (arrayList != null ? arrayList.hashCode() : 0);
    }
}
