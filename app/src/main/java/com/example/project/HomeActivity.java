package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPopular;
    private RecyclerView.Adapter adapterPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initRecyclerView();

    }

    private void initRecyclerView() {

        ArrayList<Item> itemList = new ArrayList<>();

        itemList.add(new Item("img", "Nhà sách Cá Chép", "211-213 Võ Văn Tần, Phường 5, Quận 3, TP. Hồ Chí Minh", 512, "Nhà sách này không chỉ là điểm mua sắm tiện ích mà còn là không gian đọc sách đẹp, ấm áp, tích hợp đa dạng các sản phẩm, dịch vụ: khu sách văn học dân tộc, khu thiếu nhi, khu sách ngoại văn, khu mua sắm đồ lưu niệm.", true, 10.790571589432108,106.70482658012503));
        itemList.add(new Item("img", "Nhà sách Fahasa", "389 Hai Bà Trưng, Phường 8, Quận 03, TP. Hồ Chí Minh.", 521, "Nhà sách này không chỉ là điểm mua sắm tiện ích mà còn là không gian đọc sách đẹp, ấm áp, tích hợp đa dạng các sản phẩm, dịch vụ: khu sách văn học dân tộc, khu thiếu nhi, khu sách ngoại văn, khu mua sắm đồ lưu niệm.", true,10.790571589432108,106.70482658012503));
        itemList.add(new Item("img", "Nhà sách Hải An", " 2B Nguyễn Thị Minh Khai, Phường Đa Kao, Quận 1, TP. Hồ Chí Minh", 453, "Nhà sách này không chỉ là điểm mua sắm tiện ích mà còn là không gian đọc sách đẹp, ấm áp, tích hợp đa dạng các sản phẩm, dịch vụ: khu sách văn học dân tộc, khu thiếu nhi, khu sách ngoại văn, khu mua sắm đồ lưu niệm.", true,10.790571589432108,106.70482658012503));

        recyclerViewPopular = findViewById(R.id.viewPopular);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterPopular = new MyAdapter(itemList);

        recyclerViewPopular.setAdapter(adapterPopular);
    }
}
