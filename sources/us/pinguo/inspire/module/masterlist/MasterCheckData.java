package us.pinguo.inspire.module.masterlist;
/* loaded from: classes9.dex */
public class MasterCheckData {
    private ConditionsBean conditions;
    private String gotoUrl;
    private int isOk;
    private NowStatsBean nowStats;
    private int status;

    /* loaded from: classes9.dex */
    public static class ConditionsBean {
        private int fansNum;
        private int followsNum;
        private int workNum;

        public int getFansNum() {
            return this.fansNum;
        }

        public int getFollowsNum() {
            return this.followsNum;
        }

        public int getWorkNum() {
            return this.workNum;
        }

        public void setFansNum(int i2) {
            this.fansNum = i2;
        }

        public void setFollowsNum(int i2) {
            this.followsNum = i2;
        }

        public void setWorkNum(int i2) {
            this.workNum = i2;
        }
    }

    /* loaded from: classes9.dex */
    public static class NowStatsBean {
        private int fansNum;
        private int followsNum;
        private int workNum;

        public int getFansNum() {
            return this.fansNum;
        }

        public int getFollowsNum() {
            return this.followsNum;
        }

        public int getWorkNum() {
            return this.workNum;
        }

        public void setFansNum(int i2) {
            this.fansNum = i2;
        }

        public void setFollowsNum(int i2) {
            this.followsNum = i2;
        }

        public void setWorkNum(int i2) {
            this.workNum = i2;
        }
    }

    public ConditionsBean getConditions() {
        return this.conditions;
    }

    public String getGotoUrl() {
        return this.gotoUrl;
    }

    public int getIsOk() {
        return this.isOk;
    }

    public NowStatsBean getNowStats() {
        return this.nowStats;
    }

    public int getStatus() {
        return this.status;
    }

    public void setConditions(ConditionsBean conditionsBean) {
        this.conditions = conditionsBean;
    }

    public void setGotoUrl(String str) {
        this.gotoUrl = str;
    }

    public void setIsOk(int i2) {
        this.isOk = i2;
    }

    public void setNowStats(NowStatsBean nowStatsBean) {
        this.nowStats = nowStatsBean;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
