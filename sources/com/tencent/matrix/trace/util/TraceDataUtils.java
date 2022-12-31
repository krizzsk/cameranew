package com.tencent.matrix.trace.util;

import android.util.Log;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.items.MethodItem;
import com.tencent.matrix.util.MatrixLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class TraceDataUtils {
    private static final String TAG = "Matrix.TraceDataUtils";

    /* loaded from: classes3.dex */
    public interface IStructuredDataFilter {
        void fallback(List<MethodItem> list, int i2);

        int getFilterMaxCount();

        boolean isFilter(long j2, int i2);
    }

    /* loaded from: classes3.dex */
    public static final class TreeNode {
        LinkedList<TreeNode> children = new LinkedList<>();
        TreeNode father;
        MethodItem item;

        TreeNode(MethodItem methodItem, TreeNode treeNode) {
            this.item = methodItem;
            this.father = treeNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void add(TreeNode treeNode) {
            this.children.addFirst(treeNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int depth() {
            MethodItem methodItem = this.item;
            if (methodItem == null) {
                return 0;
            }
            return methodItem.depth;
        }

        private boolean isLeaf() {
            return this.children.isEmpty();
        }
    }

    /* loaded from: classes3.dex */
    static class a implements IStructuredDataFilter {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
        public void fallback(List<MethodItem> list, int i2) {
            MatrixLog.w(TraceDataUtils.TAG, "[getTreeKey] size:%s targetSize:%s", Integer.valueOf(i2), Integer.valueOf(this.a));
            ListIterator<MethodItem> listIterator = list.listIterator(Math.min(i2, this.a));
            while (listIterator.hasNext()) {
                listIterator.next();
                listIterator.remove();
            }
        }

        @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
        public int getFilterMaxCount() {
            return 60;
        }

        @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
        public boolean isFilter(long j2, int i2) {
            return j2 < ((long) (i2 * 5));
        }
    }

    /* loaded from: classes3.dex */
    static class b implements Comparator<MethodItem> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MethodItem methodItem, MethodItem methodItem2) {
            return Integer.compare((methodItem2.depth + 1) * methodItem2.durTime, (methodItem.depth + 1) * methodItem.durTime);
        }
    }

    private static int addMethodItem(LinkedList<MethodItem> linkedList, MethodItem methodItem) {
        if (AppMethodBeat.isDev) {
            Log.v(TAG, "method:" + methodItem);
        }
        MethodItem peek = linkedList.isEmpty() ? null : linkedList.peek();
        if (peek != null && peek.methodId == methodItem.methodId) {
            int i2 = peek.depth;
            int i3 = methodItem.depth;
            if (i2 == i3 && i3 != 0) {
                int i4 = methodItem.durTime;
                if (i4 == 5000) {
                    i4 = peek.durTime;
                }
                methodItem.durTime = i4;
                peek.mergeMore(i4);
                return peek.durTime;
            }
        }
        linkedList.push(methodItem);
        return methodItem.durTime;
    }

    public static int countTreeNode(TreeNode treeNode) {
        int size = treeNode.children.size();
        Iterator<TreeNode> it = treeNode.children.iterator();
        while (it.hasNext()) {
            size += countTreeNode(it.next());
        }
        return size;
    }

    private static int getMethodId(long j2) {
        return (int) ((j2 >> 43) & 1048575);
    }

    private static long getTime(long j2) {
        return j2 & 8796093022207L;
    }

    @Deprecated
    public static String getTreeKey(List<MethodItem> list, int i2) {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList(list);
        trimStack(linkedList, i2, new a(i2));
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + Effect.DIVIDER);
        }
        return sb.toString();
    }

    private static boolean isIn(long j2) {
        return ((j2 >> 63) & 1) == 1;
    }

    public static void printTree(TreeNode treeNode, StringBuilder sb) {
        sb.append("|*   TraceStack: ");
        sb.append("\n");
        printTree(treeNode, 0, sb, "|*        ");
    }

    public static long stackToString(LinkedList<MethodItem> linkedList, StringBuilder sb, StringBuilder sb2) {
        sb2.append("|*\t\tTraceStack:");
        sb2.append("\n");
        sb2.append("|*\t\t[id count cost]");
        sb2.append("\n");
        Iterator<MethodItem> it = linkedList.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            MethodItem next = it.next();
            sb.append(next.toString());
            sb.append('\n');
            sb2.append("|*\t\t");
            sb2.append(next.print());
            sb2.append('\n');
            int i2 = next.durTime;
            if (j2 < i2) {
                j2 = i2;
            }
        }
        return j2;
    }

    public static int stackToTree(LinkedList<MethodItem> linkedList, TreeNode treeNode) {
        TreeNode treeNode2;
        ListIterator<MethodItem> listIterator = linkedList.listIterator(0);
        TreeNode treeNode3 = null;
        int i2 = 0;
        while (listIterator.hasNext()) {
            TreeNode treeNode4 = new TreeNode(listIterator.next(), treeNode3);
            i2++;
            if (treeNode3 != null || treeNode4.depth() == 0) {
                int depth = treeNode4.depth();
                if (treeNode3 == null || depth == 0) {
                    treeNode.add(treeNode4);
                } else if (treeNode3.depth() >= depth) {
                    while (treeNode3 != null && treeNode3.depth() > depth) {
                        treeNode3 = treeNode3.father;
                    }
                    if (treeNode3 != null && (treeNode2 = treeNode3.father) != null) {
                        treeNode4.father = treeNode2;
                        treeNode3.father.add(treeNode4);
                    }
                } else {
                    treeNode3.add(treeNode4);
                }
                treeNode3 = treeNode4;
            } else {
                MatrixLog.e(TAG, "[stackToTree] begin error! why the first node'depth is not 0!", new Object[0]);
                return 0;
            }
        }
        return i2;
    }

    public static void structuredDataToStack(long[] jArr, LinkedList<MethodItem> linkedList, boolean z, long j2) {
        int methodId;
        LinkedList linkedList2 = new LinkedList();
        boolean z2 = !z;
        int i2 = 0;
        for (long j3 : jArr) {
            if (0 != j3) {
                if (z) {
                    if (isIn(j3) && 1048574 == getMethodId(j3)) {
                        z2 = true;
                    }
                    if (!z2) {
                        MatrixLog.d(TAG, "never begin! pass this method[%s]", Integer.valueOf(getMethodId(j3)));
                    }
                }
                if (isIn(j3)) {
                    if (getMethodId(j3) == 1048574) {
                        i2 = 0;
                    }
                    i2++;
                    linkedList2.push(Long.valueOf(j3));
                } else {
                    int methodId2 = getMethodId(j3);
                    if (linkedList2.isEmpty()) {
                        MatrixLog.w(TAG, "[structuredDataToStack] method[%s] not found in! ", Integer.valueOf(methodId2));
                    } else {
                        long longValue = ((Long) linkedList2.pop()).longValue();
                        i2--;
                        LinkedList linkedList3 = new LinkedList();
                        linkedList3.add(Long.valueOf(longValue));
                        while (true) {
                            methodId = getMethodId(longValue);
                            if (methodId == methodId2 || linkedList2.isEmpty()) {
                                break;
                            }
                            MatrixLog.w(TAG, "pop inMethodId[%s] to continue match ouMethodId[%s]", Integer.valueOf(methodId), Integer.valueOf(methodId2));
                            longValue = ((Long) linkedList2.pop()).longValue();
                            i2--;
                            linkedList3.add(Long.valueOf(longValue));
                        }
                        if (methodId != methodId2 && methodId == 1048574) {
                            MatrixLog.e(TAG, "inMethodId[%s] != outMethodId[%s] throw this outMethodId!", Integer.valueOf(methodId), Integer.valueOf(methodId2));
                            linkedList2.addAll(linkedList3);
                            i2 += linkedList2.size();
                        } else {
                            long time = getTime(j3) - getTime(longValue);
                            if (time < 0) {
                                MatrixLog.e(TAG, "[structuredDataToStack] trace during invalid:%d", Long.valueOf(time));
                                linkedList2.clear();
                                linkedList.clear();
                                return;
                            }
                            addMethodItem(linkedList, new MethodItem(methodId2, (int) time, i2));
                        }
                    }
                }
            }
        }
        while (!linkedList2.isEmpty() && z) {
            long longValue2 = ((Long) linkedList2.pop()).longValue();
            int methodId3 = getMethodId(longValue2);
            boolean isIn = isIn(longValue2);
            long time2 = getTime(longValue2) + AppMethodBeat.getDiffTime();
            MatrixLog.w(TAG, "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", Integer.valueOf(methodId3), Boolean.valueOf(isIn), Long.valueOf(time2), Long.valueOf(j2), Integer.valueOf(linkedList2.size()));
            if (isIn) {
                addMethodItem(linkedList, new MethodItem(methodId3, (int) (j2 - time2), linkedList2.size()));
            } else {
                MatrixLog.e(TAG, "[structuredDataToStack] why has out Method[%s]? is wrong! ", Integer.valueOf(methodId3));
            }
        }
        TreeNode treeNode = new TreeNode(null, null);
        MatrixLog.i(TAG, "stackToTree: count=%s", Integer.valueOf(stackToTree(linkedList, treeNode)));
        linkedList.clear();
        treeToStack(treeNode, linkedList);
    }

    private static void treeToStack(TreeNode treeNode, LinkedList<MethodItem> linkedList) {
        for (int i2 = 0; i2 < treeNode.children.size(); i2++) {
            TreeNode treeNode2 = treeNode.children.get(i2);
            if (treeNode2 != null) {
                MethodItem methodItem = treeNode2.item;
                if (methodItem != null) {
                    linkedList.add(methodItem);
                }
                if (!treeNode2.children.isEmpty()) {
                    treeToStack(treeNode2, linkedList);
                }
            }
        }
    }

    public static void trimStack(List<MethodItem> list, int i2, IStructuredDataFilter iStructuredDataFilter) {
        if (i2 < 0) {
            list.clear();
            return;
        }
        int size = list.size();
        int i3 = 1;
        while (size > i2) {
            ListIterator<MethodItem> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (iStructuredDataFilter.isFilter(listIterator.previous().durTime, i3)) {
                    listIterator.remove();
                    size--;
                    if (size <= i2) {
                        return;
                    }
                }
            }
            size = list.size();
            i3++;
            if (iStructuredDataFilter.getFilterMaxCount() < i3) {
                break;
            }
        }
        int size2 = list.size();
        if (size2 > i2) {
            iStructuredDataFilter.fallback(list, size2);
        }
    }

    public static void printTree(TreeNode treeNode, int i2, StringBuilder sb, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        for (int i3 = 0; i3 <= i2; i3++) {
            sb2.append("    ");
        }
        for (int i4 = 0; i4 < treeNode.children.size(); i4++) {
            TreeNode treeNode2 = treeNode.children.get(i4);
            sb.append(sb2.toString());
            sb.append(treeNode2.item.methodId);
            sb.append("[");
            sb.append(treeNode2.item.durTime);
            sb.append("]");
            sb.append("\n");
            if (!treeNode2.children.isEmpty()) {
                printTree(treeNode2, i2 + 1, sb, str);
            }
        }
    }

    public static String getTreeKey(List<MethodItem> list, long j2) {
        Iterator it;
        StringBuilder sb = new StringBuilder();
        long j3 = ((float) j2) * 0.3f;
        LinkedList linkedList = new LinkedList();
        for (MethodItem methodItem : list) {
            if (methodItem.durTime >= j3) {
                linkedList.add(methodItem);
            }
        }
        Collections.sort(linkedList, new b());
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
        } else if (linkedList.size() > 1 && ((MethodItem) linkedList.peek()).methodId == 1048574) {
            linkedList.removeFirst();
        }
        if (linkedList.iterator().hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + Effect.DIVIDER);
        }
        return sb.toString();
    }
}
