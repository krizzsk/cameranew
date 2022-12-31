package us.pinguo.blockbuster.lib.graph;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes3.dex */
public class BFSTraverse {
    private static final String TAG = "us.pinguo.blockbuster.lib.graph.BFSTraverse";
    private final Graph graph;
    private Queue<VexNode> queue;
    private TraverseListener traverseListener;
    private List<VexNode> visited;

    /* loaded from: classes3.dex */
    public interface TraverseListener {
        boolean onVexVisit(VexNode vexNode);
    }

    public BFSTraverse(Graph graph) {
        if (graph != null) {
            if (graph.vexNum != 0 && graph.arcNum != 0) {
                this.graph = graph;
                this.queue = new LinkedBlockingDeque();
                this.visited = new ArrayList();
                return;
            }
            throw new IllegalArgumentException("Invalid vex or arc number: vexNum = " + graph.vexNum + ", arcNum = " + graph.arcNum);
        }
        throw new IllegalArgumentException("Graph cannot be null!");
    }

    private boolean canVisit(VexNode vexNode) {
        boolean z;
        ArcBox arcBox = vexNode.firstIn;
        if (arcBox == null) {
            return true;
        }
        ArcBox arcBox2 = arcBox.headLink;
        if (arcBox2 != null) {
            if (!isVisited(this.graph.vexNodes.get(arcBox2.tailVexNodeId))) {
                z = false;
                return !isVisited(this.graph.vexNodes.get(vexNode.firstIn.tailVexNodeId)) && z;
            }
        }
        z = true;
        if (isVisited(this.graph.vexNodes.get(vexNode.firstIn.tailVexNodeId))) {
        }
    }

    private int firstAdjVex(VexNode vexNode) {
        ArcBox arcBox = vexNode.firstOut;
        if (arcBox != null) {
            return arcBox.headVexNodeId;
        }
        return 0;
    }

    private boolean isVisited(VexNode vexNode) {
        return this.visited.contains(vexNode);
    }

    private int nexAdjVex(VexNode vexNode, int i2) {
        ArcBox arcBox = vexNode.firstOut;
        while (arcBox.headVexNodeId != i2) {
            arcBox = arcBox.tailLink;
        }
        ArcBox arcBox2 = arcBox.tailLink;
        if (arcBox2 != null) {
            return arcBox2.headVexNodeId;
        }
        return 0;
    }

    private void setVisited(VexNode vexNode) {
        String str = TAG;
        Log.i(str, "Visit vexNode:" + vexNode.nodeId);
        this.visited.add(vexNode);
    }

    public void setTraverseListener(TraverseListener traverseListener) {
        this.traverseListener = traverseListener;
    }

    public void start() {
        int i2 = 0;
        while (true) {
            Graph graph = this.graph;
            if (i2 >= graph.vexNum) {
                return;
            }
            VexNode vexNode = graph.vexNodes.get(i2);
            if (!isVisited(vexNode)) {
                if (canVisit(vexNode)) {
                    TraverseListener traverseListener = this.traverseListener;
                    if (traverseListener != null) {
                        traverseListener.onVexVisit(vexNode);
                    }
                    setVisited(vexNode);
                }
                this.queue.add(vexNode);
                while (!this.queue.isEmpty()) {
                    VexNode poll = this.queue.poll();
                    int firstAdjVex = firstAdjVex(poll);
                    while (firstAdjVex > 0) {
                        VexNode vexNode2 = this.graph.vexNodes.get(firstAdjVex);
                        if (!isVisited(vexNode2)) {
                            if (canVisit(vexNode2)) {
                                TraverseListener traverseListener2 = this.traverseListener;
                                if (traverseListener2 != null) {
                                    traverseListener2.onVexVisit(vexNode2);
                                }
                                setVisited(vexNode2);
                            }
                            this.queue.add(vexNode2);
                        }
                        firstAdjVex = nexAdjVex(poll, firstAdjVex);
                    }
                }
            }
            i2++;
        }
    }
}
