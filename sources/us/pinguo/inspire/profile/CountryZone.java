package us.pinguo.inspire.profile;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CountryZone implements Parcelable {
    public static final Parcelable.Creator<CountryZone> CREATOR = new a();
    private String group;
    private List<ListBean> list;

    /* loaded from: classes4.dex */
    public static class ListBean implements Parcelable {
        public static final Parcelable.Creator<ListBean> CREATOR = new a();
        private int cc;
        private String code;
        public String group;
        private String name;

        /* loaded from: classes4.dex */
        class a implements Parcelable.Creator<ListBean> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ListBean createFromParcel(Parcel parcel) {
                return new ListBean(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ListBean[] newArray(int i2) {
                return new ListBean[i2];
            }
        }

        public ListBean() {
        }

        public int a() {
            return this.cc;
        }

        public String b() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ListBean listBean = (ListBean) obj;
            if (this.cc != listBean.cc) {
                return false;
            }
            String str = this.code;
            if (str == null ? listBean.code == null : str.equals(listBean.code)) {
                String str2 = this.name;
                if (str2 == null ? listBean.name == null : str2.equals(listBean.name)) {
                    String str3 = this.group;
                    String str4 = listBean.group;
                    return str3 != null ? str3.equals(str4) : str4 == null;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String str = this.code;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.cc) * 31;
            String str3 = this.group;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.code);
            parcel.writeString(this.name);
            parcel.writeInt(this.cc);
        }

        protected ListBean(Parcel parcel) {
            this.code = parcel.readString();
            this.name = parcel.readString();
            this.cc = parcel.readInt();
        }
    }

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<CountryZone> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CountryZone createFromParcel(Parcel parcel) {
            return new CountryZone(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CountryZone[] newArray(int i2) {
            return new CountryZone[i2];
        }
    }

    public CountryZone() {
    }

    public String a() {
        return this.group;
    }

    public List<ListBean> b() {
        return this.list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.group);
        parcel.writeList(this.list);
    }

    protected CountryZone(Parcel parcel) {
        this.group = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.list = arrayList;
        parcel.readList(arrayList, ListBean.class.getClassLoader());
    }
}
