package com.example.win7.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView txtPrefer,txtResult;
    private ListView listPrefer;
    String[]Comics = new String[]{"王者天下","全職高手","航海王","妖精的尾巴","頭文字D","飆速宅男"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  取得介面元件
        txtResult = (TextView)findViewById(R.id.txtResult);
        listPrefer = (ListView)findViewById(R.id.listPrefer);

        //  建立  ArrayAdapter
        ArrayAdapter<String> adapterCoimics = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Comics);

        //  設定ListView資料來源
        listPrefer.setAdapter(adapterCoimics);

        listPrefer.setOnItemClickListener(listPreferListener);

        //  改變  ListView 屬性
        listPrefer.setTextFilterEnabled(true);  //  啟動按鍵過濾功能
        listPrefer.setSelector(R.drawable.green);   // 改變選取的背景色為圖片
    }
    private ListView.OnItemClickListener listPreferListener = new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //   顯示 ListView的選項內容
            String sel = parent.getItemAtPosition(position).toString();
            txtResult.setText("我最喜歡的漫畫是 : " + sel);
        }
    };

}
