package pers.dlx.ele;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseEleHtml {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File input = new File("D:\\code\\webstorm-test\\ele.html");
        Document doc = Jsoup.parse(input, "UTF-8", "");

//		Elements newsHeadlines = doc.select("#mp-itn b a");
//		for (Element headline : newsHeadlines) {
//		  log("%s\n\t%s",
//		    headline.attr("title"), headline.absUrl("href"));
//		}
        Elements shopList = doc.select("section > section");

        List<EleEntity> list = new ArrayList<EleEntity>();
        for (Element shop : shopList) {
            Elements spanList = shop.children().select("section").select("span");

            // 0 2 3 4 5 6 7 8
            EleEntity entity = new EleEntity();
            entity.setName(spanList.get(0).text());
            entity.setScore(spanList.get(2).text());
            entity.setSoldCnt(spanList.get(3).text());
            entity.setStart(spanList.get(4).text());
            entity.setExpressFee(spanList.get(5).text());
            entity.setDistance(spanList.get(6).text());
            entity.setTime(spanList.get(7).text());
            entity.setCategory(spanList.get(8).text());
            list.add(entity);

//            for (Element span : spanList) {
//                System.out.println(span.text());
//            }
//            System.out.println(shop.children().select("section").size());
//            System.out.println("=============");
//            // 店名
//            Elements shopName = sections.get(0).select("h3").select("span");
//            System.out.println(shopName.first().text());
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                EleEntity.class, list);

        File out = new File("D:\\code\\webstorm-test\\ele-out.xls");
        workbook.write(new FileOutputStream(out));
        System.out.println(shopList.size());
    }
}
