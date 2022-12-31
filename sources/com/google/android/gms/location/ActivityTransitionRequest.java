package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new w();
    public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new v();
    @Nullable
    private final String tag;
    private final List<ActivityTransition> zzl;
    private final List<ClientIdentity> zzm;

    public ActivityTransitionRequest(List<ActivityTransition> list, @Nullable String str, @Nullable List<ClientIdentity> list2) {
        com.google.android.gms.common.internal.q.k(list, "transitions can't be null");
        com.google.android.gms.common.internal.q.b(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(IS_SAME_TRANSITION);
        for (ActivityTransition activityTransition : list) {
            com.google.android.gms.common.internal.q.b(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
        this.zzl = Collections.unmodifiableList(list);
        this.tag = str;
        this.zzm = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (com.google.android.gms.common.internal.p.a(this.zzl, activityTransitionRequest.zzl) && com.google.android.gms.common.internal.p.a(this.tag, activityTransitionRequest.tag) && com.google.android.gms.common.internal.p.a(this.zzm, activityTransitionRequest.zzm)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.zzl.hashCode() * 31;
        String str = this.tag;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.zzm;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzl);
        String str = this.tag;
        String valueOf2 = String.valueOf(this.zzm);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append('\'');
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, this.zzl, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.tag, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 3, this.zzm, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
