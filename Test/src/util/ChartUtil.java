package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import entity.report;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

public class ChartUtil {

    public static int max(double[] sampleValues) {
        int max = 0;
        for (double v : sampleValues) {
            if (v > max)
                max = (int) v;
        }
        return max;
    }

    private static String[] sampleLabels(List<report> rs) {
        String[] sampleLabels = new String[31];
        for (int i = 0; i < 31; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "日");
        }
        return sampleLabels;
    }

    public static double[] sampleValues(List<report> rs) {
        double[] sampleValues = new double[rs.size()];
        for (int i = 0; i < sampleValues.length; i++) {
            sampleValues[i] = rs.get(i).totalPrice;
        }
        return sampleValues;
    }

    public static Image getImage(List<report> rs, int width, int height) {
        // 模拟样本数据
        double[] sampleValues = sampleValues(rs);
        // 下方显示的文字
        String[] sampleLabels = sampleLabels(rs);
        // 样本中的最大值
        int max = max(sampleValues);

        // 数据颜色
        Color[] sampleColors = new Color[] { ColorUtil.blueColor };

        // 图
        Chart chart = new BarChart();

        // 设置样本个数
        chart.setSampleCount(31);
        // 设置样本数据
        chart.setSampleValues(0, sampleValues);
        // 设置文字
        chart.setSampleLabels(sampleLabels);
        // 设置样本颜色
        chart.setSampleColors(sampleColors);
        // 设置取值范围
        chart.setRange(0, max * 1.05);
        // 显示背景横线
        chart.setValueLinesOn(true);
        // 显示文字
        chart.setSampleLabelsOn(true);
        // 把文字显示在下方
        chart.setSampleLabelStyle(Chart.BELOW);

        // 样本值的字体
        chart.setFont("rangeLabelFont", new Font("楷体", Font.BOLD, 24));
        // 显示图例说明
        chart.setLegendOn(true);
        // 把图例说明放在左侧
        chart.setLegendPosition(Chart.LEFT);
        // 图例说明中的文字
        chart.setLegendLabels(new String[] { "销售额" });
        // 图例说明的字体
        chart.setFont("legendFont", new Font("楷体", Font.BOLD, 24));
        // 下方文字的字体
        chart.setFont("sampleLabelFont", new Font("楷体", Font.BOLD, 24));
        // 图表中间背景颜色
        chart.setChartBackground(Color.white);
        // 图表整体背景颜色
        chart.setBackground(ColorUtil.backgroundColor);
        // 把图表转换为Image类型
        Image im = chart.getImage(width, height);
        return im;
    }
}