package com.daoran.newfactory.onefactory.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daoran.newfactory.onefactory.R;
import com.daoran.newfactory.onefactory.activity.work.DebugGaodeActivity;
import com.daoran.newfactory.onefactory.activity.work.SignActivity;
import com.daoran.newfactory.onefactory.activity.work.SignDetailActivity;
import com.daoran.newfactory.onefactory.activity.work.SignOpenActivity;
import com.daoran.newfactory.onefactory.activity.work.car.SqlcarApplyActivity;
import com.daoran.newfactory.onefactory.activity.work.commo.CommoditySqlActivity;
import com.daoran.newfactory.onefactory.activity.work.production.ProductionActivity;
import com.daoran.newfactory.onefactory.bean.WorkBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据角色返回的菜单加载页面适配
 * Created by lizhipeng on 2017/5/10.
 */

public class ScrollWrokAdapter extends BaseAdapter {
    private Context context;
    private List<WorkBean> workBeen = new ArrayList<WorkBean>();

    public ScrollWrokAdapter(Context context, List<WorkBean> workBeen) {
        this.context = context;
        this.workBeen = workBeen;
    }

    @Override
    public int getCount() {
        return workBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return workBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_work, null);
            holder.tvOpenCarDetail = (TextView) convertView.findViewById(R.id.tvOpenCarDetail);
            holder.ivopenCarDetail = (ImageView) convertView.findViewById(R.id.ivopenCarDetail);
            holder.llOpenCarDetail = (LinearLayout) convertView.findViewById(R.id.llOpenCarDetail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final String itemtitle = workBeen.get(position).getText();
        holder.tvOpenCarDetail.setText(itemtitle);
        switch (itemtitle) {
            case "用车申请单":
                holder.ivopenCarDetail.setImageResource(R.mipmap.ucar_220);
                break;
            case "外勤签到":
                holder.ivopenCarDetail.setImageResource(R.mipmap.regedit_220);
                break;
            case "签到查询":
                holder.ivopenCarDetail.setImageResource(R.mipmap.count_500);
                break;
            case "公交路线":
                holder.ivopenCarDetail.setImageResource(R.mipmap.navigation_20);
                break;
            case "生产日报表":
                holder.ivopenCarDetail.setImageResource(R.mipmap.daily);
                break;
            case "查货跟踪表":
                holder.ivopenCarDetail.setImageResource(R.mipmap.prd_220);
                break;
        }
        holder.llOpenCarDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (itemtitle) {
                    case "用车申请单":
                        context.startActivity(new Intent(context, SqlcarApplyActivity.class));
                        break;
                    case "外勤签到":
                        context.startActivity(new Intent(context, SignOpenActivity.class));
                        break;
                    case "签到查询":
                        context.startActivity(new Intent(context, SignDetailActivity.class));
                        break;
                    case "公交路线":
                        context.startActivity(new Intent(context, DebugGaodeActivity.class));
                        break;
                    case "生产日报表":
                        context.startActivity(new Intent(context, ProductionActivity.class));
                        break;
                    case "查货跟踪表":
                        context.startActivity(new Intent(context, CommoditySqlActivity.class));
                        break;
                }
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView tvOpenCarDetail;
        ImageView ivopenCarDetail;
        LinearLayout llOpenCarDetail;
    }
}