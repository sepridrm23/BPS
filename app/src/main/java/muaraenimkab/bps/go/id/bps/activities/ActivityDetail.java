package muaraenimkab.bps.go.id.bps.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Cartesian3d;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

import muaraenimkab.bps.go.id.bps.R;

public class ActivityDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        Pie pie = AnyChart.column3d();
         Cartesian cartesian = AnyChart.vertical();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Lubuk Linggau", 250000));
        data.add(new ValueDataEntry("Pagar Alam", 150000));
        data.add(new ValueDataEntry("Prabumulih", 200000));
        data.add(new ValueDataEntry("Palembang", 1550000));
        data.add(new ValueDataEntry("Empat Lawang", 200000));
        data.add(new ValueDataEntry("Ogan Ilir", 200000));
        data.add(new ValueDataEntry("OKU Timur", 270000));
        data.add(new ValueDataEntry("OKU Selatan", 480000));
        data.add(new ValueDataEntry("Banyuasin", 550000));
        data.add(new ValueDataEntry("Musi Banyuasin", 450000));
        data.add(new ValueDataEntry("Muratara", 850000));
        data.add(new ValueDataEntry("Musi Rawas", 510000));
        data.add(new ValueDataEntry("Lahat", 480000));
        data.add(new ValueDataEntry("Pali", 470000));
        data.add(new ValueDataEntry("Muara Enim", 510000));
        data.add(new ValueDataEntry("OKI", 850000));
        data.add(new ValueDataEntry("OKU", 450000));

        cartesian.data(data);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setChart(cartesian);

    }
}
