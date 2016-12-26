package cn.edu.imnu.ciec.rtest18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String[] data={
//            "Apple", "Banana", "Orange", "Watermelon", "Pear",
//            "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
//            "Apple", "Banana", "Orange", "Watermelon", "Pear",
//            "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"
//    };

    private List<Fruit> fruitList=new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();

        /*
        适配器 ArrayAdapter
        1)当前上下文 2）ListView子项布局的id,android内置的一个布局文件,里面只有一个TextView
         */

//        ArrayAdapter< Fruit> adapter=new ArrayAdapter<Fruit>(
//                MainActivity.this,R.layout.furit_item,fruitList
//        );
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.furit_item,fruitList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_LONG).show();

            }
        });




    }

    private void initFruits() {
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
}
