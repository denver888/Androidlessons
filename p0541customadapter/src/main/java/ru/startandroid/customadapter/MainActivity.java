package ru.startandroid.customadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);
        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Упражнение №" + i, i * 1000, R.drawable.img111, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Выбранные упражнения:";
        for (Product p : boxAdapter.getBox()) {
            if (p.box) result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
