package pers.dlx.shit.db;

import edu.princeton.cs.algs4.BTree;

public class Table {
    BTree<Integer, Row> st;
    int numRows;

    public Table() {
        st = new BTree<Integer, Row>();
        numRows = 0;
    }

    public Row getRow(int key) {
        return st.get(key);
    }

    public boolean insertRow(Row row) {
        int id = row.id;
        if (st.get(id) !=null) {
            return false;
        }
        st.put(row.id, row);
        numRows++;
        return true;
    }

}
