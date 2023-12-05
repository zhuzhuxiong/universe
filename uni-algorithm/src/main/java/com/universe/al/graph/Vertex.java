package com.universe.al.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 顶点类
 * @author l
 */
public class Vertex {

    public int val;

    public Vertex(int val){
        this.val = val;
    }

    public static Vertex[] valsToVers(int[] vals){
        Vertex[] vers = new Vertex[vals.length];
        for (int i = 0; i < vals.length; i++) {
            vers[i] = new Vertex(vals[i]);
        }
        return vers;
    }

    public static List<Integer> versToVals(List<Vertex> vers) {
        ArrayList<Integer> vals = new ArrayList<>();
        for (Vertex ver : vers) {
            vals.add(ver.val);
        }
        return vals;
    }
}
