package net.fatihdemirag.navigasyonmenucustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by fxd on 18.10.2017.
 */

public class ExpandedListViewAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<String> basliklar = new ArrayList<>();
    Map<String, ArrayList<String>> ogeler = new HashMap<>();

    public ExpandedListViewAdapter(Context context, ArrayList<String> basliklar, Map<String, ArrayList<String>> ogeler) {
        this.context = context;
        this.basliklar = basliklar;
        this.ogeler = ogeler;
    }

    LayoutInflater layoutInflater;

    @Override
    public int getGroupCount() {
        return basliklar.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return ogeler.get(basliklar.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return basliklar.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return ogeler.get(basliklar.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.basliklar, null);
        }
        TextView baslik = view.findViewById(R.id.baslik);
        baslik.setText((String) getGroup(i));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.ogeler, null);
        }

        TextView oge = view.findViewById(R.id.oge);
        oge.setText((String) getChild(i, i1));

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
