package cn.edu.imnu.ciec.rtest18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP301 on 2016/12/26.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int resoutceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resoutceId= textViewResourceId;


    }
    /*
       @NonNull
       @Override
       //每个子项被滚到屏幕内的时候都会被调用

       *运行效率很低 每次都重新加载
       *
       *
       public View getView(int position, View convertView, ViewGroup parent) {
   //        return super.getView(position, convertView, parent);
           Fruit fruit =getItem(position);
           View view= LayoutInflater.from(getContext()).inflate(resoutceId,parent,false);
           ImageView fruitImage= (ImageView) view.findViewById(R.id.fruit_image);
           TextView fruitName= (TextView) view.findViewById(R.id.fruit_name);
           fruitImage.setImageResource(fruit.getImageId());
           fruitName.setText(fruit.getName());
           return view;
       }

       */

    /*
    * 对getView进行判断*/
    /*
    * 每次都要findviewbyid  用  ViewHolder
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit =getItem(position);
        View view;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resoutceId,parent,false);

        }else {
            view=convertView;

        }
        ImageView fruitImage= (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName= (TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        return view;


    }
    */

    @NonNull
    @Override
    /*
    新增ViewHolder 用于对控件进行的实例进行缓存
    当convertView为null的时候，创建一个VH对象，并将控件的实例都放在VH里
    然后调用View的setTag()方法，将VH对象储存在View中
    当converView不为null的时候，则调用View的getTag（）方法，把VH重新取出
    这样所有的控件都缓存在了VH，就没有必要每次都通过findviewbyid方法来获取控件实例了
    * */
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resoutceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView= (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.textView= (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();

        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;

    }
}
