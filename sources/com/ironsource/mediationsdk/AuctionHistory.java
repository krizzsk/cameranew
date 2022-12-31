package com.ironsource.mediationsdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class AuctionHistory {
    private ConcurrentHashMap<String, ArrayList<ISAuctionPerformance>> a = new ConcurrentHashMap<>();
    private int b;

    /* loaded from: classes2.dex */
    public enum ISAuctionPerformance {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public AuctionHistory(List<String> list, int i2) {
        this.b = i2;
        for (String str : list) {
            ArrayList<ISAuctionPerformance> arrayList = new ArrayList<>();
            this.a.put(str, arrayList);
        }
    }

    public String a(String str) {
        Iterator<ISAuctionPerformance> it;
        ArrayList<ISAuctionPerformance> arrayList = this.a.get(str);
        String str2 = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            str2 = "" + it.next().ordinal();
            while (arrayList.iterator().hasNext()) {
                str2 = (str2 + ",") + it.next().ordinal();
            }
        }
        return str2;
    }

    public void b(ConcurrentHashMap<String, ISAuctionPerformance> concurrentHashMap) {
        if (this.b == 0) {
            return;
        }
        for (String str : this.a.keySet()) {
            ISAuctionPerformance iSAuctionPerformance = ISAuctionPerformance.ISAuctionPerformanceNotPartOfWaterfall;
            if (concurrentHashMap.containsKey(str)) {
                iSAuctionPerformance = concurrentHashMap.get(str);
            }
            ArrayList<ISAuctionPerformance> arrayList = this.a.get(str);
            if (this.b != -1 && arrayList.size() == this.b) {
                arrayList.remove(0);
            }
            arrayList.add(iSAuctionPerformance);
        }
    }
}
