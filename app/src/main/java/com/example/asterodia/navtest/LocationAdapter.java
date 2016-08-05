package com.example.asterodia.navtest;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Asterodia on 31/07/2016.
 */
public class LocationAdapter extends BaseExpandableListAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<LocationParent> mParent;

    public LocationAdapter(Context _context, ArrayList<LocationParent> parent){
        mParent = parent;
        context = _context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    //counts the number of group/parent items so the list knows how many times calls getGroupView() method
    public int getGroupCount() {
        return mParent.size();
    }

    @Override
    //gets the title of each parent/group
    public Object getGroup(int i) {
        return mParent.get(i).getTitle();
    }

    @Override
    //gets the number of children
    public int getChildrenCount(int i) { return 1; }

    @Override
    //gets the name of each item
    public Object getChild(int i, int i1) {
        return mParent.get(i).getChild();
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
        return true;
    }

    @Override
    //in this method you must set the text to see the parent/group on the list
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        holder.groupPosition = groupPosition;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item_parent, viewGroup,false);
        }

        TextView textView = (TextView) view.findViewById(R.id.list_item_text_view);
        textView.setText(getGroup(groupPosition).toString());

        view.setTag(holder);

        //return the entire view
        return view;
    }

    @Override
    //in this method you must set the text to see the children on the list
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        holder.childPosition = childPosition;
        holder.groupPosition = groupPosition;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item_child, viewGroup,false);
        }

        Location child = mParent.get(groupPosition).getChild();

        ImageView img = (ImageView) view.findViewById(R.id.image);
        img.setImageDrawable( context.getResources().getDrawable(context.getResources().getIdentifier("@drawable/" + child.image, null, context.getPackageName())));

        TextView desc = (TextView) view.findViewById(R.id.desc);
        desc.setText(child.desc);

        view.setTag(holder);


        //return the entire view
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        /* used to make the notifyDataSetChanged() method work */
        super.registerDataSetObserver(observer);
    }

// Intentionally put on comment, if you need on click deactivate it
/*  @Override
    public void onClick(View view) {
        ViewHolder holder = (ViewHolder)view.getTag();
        if (view.getId() == holder.button.getId()){

           // DO YOUR ACTION
        }
    }*/


    protected class ViewHolder {
        protected int childPosition;
        protected int groupPosition;
        protected Button button;
    }
}

