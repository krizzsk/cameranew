package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class GlobalSettingBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<GlobalSettingBean> CREATOR = new a();
    private DetBean det;
    private String etag;
    private String host;
    private String pullInterval;

    /* loaded from: classes3.dex */
    public class DetBean implements Serializable {
        private int detSwitch;
        private RulesBean rules;

        /* loaded from: classes3.dex */
        public class RulesBean implements Serializable {
            private List<FailsBean> fails;
            private List<SuccessBean> success;

            /* loaded from: classes3.dex */
            public class FailsBean implements Serializable {
                private String domain;
                private String match;

                public FailsBean() {
                }

                public String getDomain() {
                    return this.domain;
                }

                public String getMatch() {
                    return this.match;
                }

                public void setDomain(String str) {
                    this.domain = str;
                }

                public void setMatch(String str) {
                    this.match = str;
                }
            }

            /* loaded from: classes3.dex */
            public class SuccessBean implements Serializable {
                private String domain;
                private String match;

                public SuccessBean() {
                }

                public String getDomain() {
                    return this.domain;
                }

                public String getMatch() {
                    return this.match;
                }

                public void setDomain(String str) {
                    this.domain = str;
                }

                public void setMatch(String str) {
                    this.match = str;
                }
            }

            public RulesBean() {
            }

            public List<FailsBean> getFails() {
                return this.fails;
            }

            public List<SuccessBean> getSuccess() {
                return this.success;
            }

            public void setFails(List<FailsBean> list) {
                this.fails = list;
            }

            public void setSuccess(List<SuccessBean> list) {
                this.success = list;
            }
        }

        public DetBean() {
        }

        public RulesBean getRules() {
            return this.rules;
        }

        public boolean isSwitchOpen() {
            return this.detSwitch == 1;
        }

        public void setDetSwitch(int i2) {
            this.detSwitch = i2;
        }

        public void setRules(RulesBean rulesBean) {
            this.rules = rulesBean;
        }
    }

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<GlobalSettingBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GlobalSettingBean createFromParcel(Parcel parcel) {
            return new GlobalSettingBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GlobalSettingBean[] newArray(int i2) {
            return new GlobalSettingBean[i2];
        }
    }

    public GlobalSettingBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DetBean getDet() {
        return this.det;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getHost() {
        return this.host;
    }

    public String getPullInterval() {
        return this.pullInterval;
    }

    public void setDet(DetBean detBean) {
        this.det = detBean;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setPullInterval(String str) {
        this.pullInterval = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.det);
        parcel.writeString(this.etag);
        parcel.writeString(this.pullInterval);
        parcel.writeString(this.host);
    }

    protected GlobalSettingBean(Parcel parcel) {
        this.det = (DetBean) parcel.readSerializable();
        this.etag = parcel.readString();
        this.pullInterval = parcel.readString();
        this.host = parcel.readString();
    }
}
